package ru.skillbranch.sbdelivery.screens.dishes.data

sealed class DishesUiState() {
    object Loading : DishesUiState()
    object Empty : DishesUiState()
    object Error : DishesUiState()
    data class Value(val dishes: List<DishItem>) : DishesUiState()
}