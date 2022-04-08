package ru.skillbranch.sbdelivery.screens.dishes.ui

import androidx.compose.runtime.Composable
import ru.skillbranch.sbdelivery.screens.dishes.data.DishesUiState
import ru.skillbranch.sbdelivery.screens.dishes.logic.DishesFeature


@Composable
fun DishesScreen(state: DishesFeature.State, accept: (DishesFeature.Msg) -> Unit) {
    when (state.list) {
        is DishesUiState.Empty -> TODO()
        is DishesUiState.Error -> TODO()
        is DishesUiState.Loading -> TODO()
        is DishesUiState.Value -> TODO()
    }
}