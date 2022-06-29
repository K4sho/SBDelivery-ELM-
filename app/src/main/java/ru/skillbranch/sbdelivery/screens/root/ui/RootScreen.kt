package ru.skillbranch.sbdelivery.screens.root.logic

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.skillbranch.sbdelivery.RootViewModel
import ru.skillbranch.sbdelivery.screens.dishes.ui.DishesScreen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RootScreen(vm: RootViewModel) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        content = { ContentHost(vm) }
    )
}

@Composable
fun ContentHost(vm: RootViewModel) {
    // Compose функция. Позволяет рассматривать StateFlow именно как State для компоуза.
    val state: RootState by vm.feature.state.collectAsState()
    val screen: ScreenState = state.current

    // Navigate save state
    when (screen) {
        is ScreenState.Dishes -> DishesScreen(screen.state) { vm.accept(Msg.Dishes(it)) }
    }
}