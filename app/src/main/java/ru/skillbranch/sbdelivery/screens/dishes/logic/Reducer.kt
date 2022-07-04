package ru.skillbranch.sbdelivery.screens.dishes.logic

import ru.skillbranch.sbdelivery.screens.dishes.data.DishesUiState
import ru.skillbranch.sbdelivery.screens.root.logic.Eff
import ru.skillbranch.sbdelivery.screens.root.logic.RootState
import ru.skillbranch.sbdelivery.screens.root.logic.ScreenState

fun DishesFeature.State.selfReduce(msg: DishesFeature.Msg): Pair<DishesFeature.State, Set<Eff>> =
    when (msg) {
        is DishesFeature.Msg.AddToCart -> TODO()
        is DishesFeature.Msg.ClickDish -> TODO()
        is DishesFeature.Eff.FindSuggestions -> TODO()
        is DishesFeature.Msg.RemoveToCart -> TODO()
        is DishesFeature.Msg.SearchInput -> TODO()
        is DishesFeature.Msg.SearchSubmit -> TODO()
        is DishesFeature.Msg.SearchToggle -> TODO()
        is DishesFeature.Msg.ShowDishes -> {
            val dishes =
                if (msg.dishes.isEmpty()) DishesUiState.Empty else DishesUiState.Value(msg.dishes)
            copy(list = dishes, suggestions = emptyMap()) to emptySet()
        }
        is DishesFeature.Msg.ShowError -> TODO()
        is DishesFeature.Msg.ShowLoading -> copy(list = DishesUiState.Loading) to emptySet()
        is DishesFeature.Msg.ShowSuggestion -> TODO()
        is DishesFeature.Msg.SuggestionSelect -> TODO()
        is DishesFeature.Msg.UpdateSuggestionResult -> TODO()
    }

fun DishesFeature.State.reduce(root: RootState, msg: DishesFeature.Msg): Pair<RootState, Set<Eff>> {
    val (screenState, eff) = selfReduce(msg)
    return root.changeCurrentScreen<ScreenState.Dishes> { copy(state = screenState) } to eff
}