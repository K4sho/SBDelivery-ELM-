package ru.skillbranch.sbdelivery.screens.dishes.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.screens.dishes.ui.DishItem
import ru.skillbranch.sbdelivery.screens.dishes.data.DishesUiState
import ru.skillbranch.sbdelivery.screens.dishes.logic.DishesFeature

@Composable
fun DishesScreen(state: DishesFeature.State, accept: (DishesFeature.Msg) -> Unit) {
    when (state.list) {
        is DishesUiState.Empty -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.bg_splash),
                    contentDescription = "empty",
                    modifier = Modifier.requiredSize(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Нет ответа от сервера", color = MaterialTheme.colors.onBackground)
            }
        }
        is DishesUiState.Error -> TODO()
        is DishesUiState.Loading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = MaterialTheme.colors.secondary)
        }
        is DishesUiState.Value -> LazyVerticalGrid(
            columns = GridCells.Adaptive(8.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(state.list.dishes) { item ->
                DishItem(
                    dish = item,
                    onClick = { accept(DishesFeature.Msg.ClickDish(item.id, item.title)) },
                    addToCart = { accept(DishesFeature.Msg.AddToCart(item.id, item.title)) }
                )
            }
        }
    }
}