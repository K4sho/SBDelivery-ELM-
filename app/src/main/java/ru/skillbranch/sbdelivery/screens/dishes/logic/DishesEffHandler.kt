package ru.skillbranch.sbdelivery.screens.dishes.logic

import ru.skillbranch.sbdelivery.screens.root.logic.IEffHandler
import ru.skillbranch.sbdelivery.screens.root.logic.Msg

class DishesEffHandler : IEffHandler<DishesFeature.Eff, Msg> {
    override suspend fun handle(effect: DishesFeature.Eff, commit: (Msg) -> Unit) {
        when(effect) {
            is DishesFeature.Eff.AddToCart -> TODO()
            DishesFeature.Eff.FindAllDishes -> TODO()
            is DishesFeature.Eff.RemoveFromCart -> TODO()
            is DishesFeature.Eff.SearchDishes ->  TODO()
            is DishesFeature.Eff.SyncDishes -> TODO()
        }
    }
}