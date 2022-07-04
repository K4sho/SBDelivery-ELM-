package ru.skillbranch.sbdelivery.screens.dishes.logic

import ru.skillbranch.sbdelivery.repository.DishesRepository
import ru.skillbranch.sbdelivery.screens.root.logic.IEffHandler
import ru.skillbranch.sbdelivery.screens.root.logic.Msg
import javax.inject.Inject

class DishesEffHandler @Inject constructor(
    private val repository: DishesRepository
) : IEffHandler<DishesFeature.Eff, Msg> {
    override suspend fun handle(effect: DishesFeature.Eff, commit: (Msg) -> Unit) {
        when (effect) {
            is DishesFeature.Eff.AddToCart -> TODO()
            DishesFeature.Eff.FindAllDishes -> TODO()
            is DishesFeature.Eff.RemoveFromCart -> TODO()
            is DishesFeature.Eff.SearchDishes -> TODO()
            is DishesFeature.Eff.SyncDishes -> {
                commit(DishesFeature.Msg.ShowLoading.toMsg())

                val isEmpty = repository.isEmptyDishes()
                if (isEmpty) repository.syncDishes()
                val dishes = repository.findDishes()

                commit(DishesFeature.Msg.ShowDishes(dishes).toMsg())
            }
        }
    }

    private fun DishesFeature.Msg.toMsg() = Msg.Dishes(this)
}