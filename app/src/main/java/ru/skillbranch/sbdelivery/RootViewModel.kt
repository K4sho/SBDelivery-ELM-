package ru.skillbranch.sbdelivery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ru.skillbranch.sbdelivery.screens.dishes.logic.DishesEffHandler
import ru.skillbranch.sbdelivery.screens.root.logic.EffDispatcher
import ru.skillbranch.sbdelivery.screens.root.logic.Msg
import ru.skillbranch.sbdelivery.screens.root.logic.RootFeature

class RootViewModel() : ViewModel() {

    val feature = RootFeature

    init {
        feature.listen(viewModelScope, EffDispatcher(DishesEffHandler()))
    }

    fun accept(msg: Msg) {
        feature.mutate(msg)
    }
}