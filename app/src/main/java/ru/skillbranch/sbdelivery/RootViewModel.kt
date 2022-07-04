package ru.skillbranch.sbdelivery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.skillbranch.sbdelivery.screens.dishes.logic.DishesEffHandler
import ru.skillbranch.sbdelivery.screens.root.logic.EffDispatcher
import ru.skillbranch.sbdelivery.screens.root.logic.Msg
import ru.skillbranch.sbdelivery.screens.root.logic.RootFeature
import javax.inject.Inject

@HiltViewModel
class RootViewModel @Inject constructor(
    val dispatcher: EffDispatcher
) : ViewModel() {

    val feature = RootFeature

    init {
        feature.listen(viewModelScope, dispatcher)
    }

    fun accept(msg: Msg) {
        feature.mutate(msg)
    }
}