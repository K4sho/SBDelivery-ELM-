package ru.skillbranch.sbdelivery.screens.root.logic

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.skillbranch.sbdelivery.screens.dishes.logic.DishesFeature
import ru.skillbranch.sbdelivery.screens.dishes.logic.reduce

object RootFeature {

    fun initialState(): RootState = RootState(
        screens = mapOf(
            DishesFeature.route to ScreenState.Dishes(DishesFeature.initialState())
        ),
        currentRoute = DishesFeature.route
    )

    fun initialEffects(): Set<Eff> = DishesFeature.initialEffects().mapTo(HashSet(), Eff::Dishes)

    private val _state: MutableStateFlow<RootState> = MutableStateFlow(initialState())
    val state = _state.asStateFlow()
    private lateinit var _scope: CoroutineScope

    // Mutations change state
    private val mutations: MutableSharedFlow<Msg> = MutableSharedFlow()

    // State change function
    fun mutate(mutation: Msg) {
        _scope.launch {
            mutations.emit(mutation)
        }
    }

    // Запускает UDF цикл
    fun listen(scope: CoroutineScope, effDispatcher: IEffHandler<Eff, Msg>) {
        _scope = scope
        _scope.launch {
            // scan знает предыдущее значение и выдает новое
            mutations
                .onEach { Log.e("DemoEffHandler", "Mutation $it") }
                .scan(initialState() to initialEffects()) {
                    // s - state, m - mutation
                        (s, _), m ->
                    reduceDispatcher(s, m)
                }
                .collect { (s, eff) ->
                    _state.emit(s)
                    eff.forEach {
                        launch {
                            effDispatcher.handle(it, ::mutate)
                        }
                    }
                }
        }
    }

    private fun reduceDispatcher(root: RootState, msg: Msg): Pair<RootState, Set<Eff>> =
        when {
            msg is Msg.Dishes && root.current is ScreenState.Dishes -> root.current.state.reduce(
                root,
                msg.msg
            )

            else -> root to emptySet()
        }
}

data class RootState(
    val screens: Map<String, ScreenState>,
    val currentRoute: String,
    val backstack: List<ScreenState> = emptyList(),
    val cartCount: Int = 0,
) {
    val current: ScreenState = checkNotNull(screens[currentRoute])

    fun <T : ScreenState> changeCurrentScreen(block: T.() -> T): RootState {
        val newScreen = (current as? T)?.block()
        val newScreens = if (newScreen != null) screens.toMutableMap().also { mutScreens ->
            mutScreens[currentRoute] = newScreen
        } else {
            screens
        }

        return copy(screens = newScreens)
    }
}

sealed class ScreenState(
    val route: String,
    val title: String
) {
    data class Dishes(val state: DishesFeature.State) :
        ScreenState(DishesFeature.route, "Все блюда")
}

// Message received from UI or Effects
sealed class Msg {
    data class Dishes(val msg: DishesFeature.Msg) : Msg()
}

// Порождает новые Message
sealed class Eff {
    data class Dishes(val eff: DishesFeature.Eff) : Eff()
}

// Input effect and type of mutation
interface IEffHandler<E, M> {
    suspend fun handle(effect: E, commit: (M) -> Unit)
}