package ru.skillbranch.sbdelivery.screens.root.logic

import android.util.Log
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import ru.skillbranch.sbdelivery.screens.dishes.logic.DishesEffHandler
import ru.skillbranch.sbdelivery.screens.dishes.logic.DishesFeature
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class EffDispatcher @Inject constructor(
    private val dishesHandler: DishesEffHandler
) : IEffHandler<Eff, Msg> {
    private lateinit var _localJob: Job

    override suspend fun handle(effect: Eff, commit: (Msg) -> Unit) {
        Log.e("DemoEffHandler", "handle effect $effect")
        when (effect) {
            is Eff.Dishes -> dishesHandler.handle(effect.eff, commit)
        }
    }
}