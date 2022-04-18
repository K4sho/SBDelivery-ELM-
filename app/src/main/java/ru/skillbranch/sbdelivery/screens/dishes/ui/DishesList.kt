package ru.skillbranch.sbdelivery.screens.dishes.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import dev.chrisbanes.accompanist.coil.CoilImage
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.screens.dishes.data.DishItem


// TODO: Нужно доработать. Требуются ресурсы
@Composable
fun DishItem(
    dish: DishItem,
    onClick: (dishId: DishItem) -> Unit,
    addToCart: (dishId: DishItem) -> Unit
) {
    Card(Modifier.requiredHeight(250.dp)) {
        ConstraintLayout(
            Modifier.clickable {
                onClick(dish)
            }
        ) {
            val (fab, title, poster, price) = createRefs()

            CoilImage(
                data = dish.image,
                contentDescription = "My content description",
                contentScale = ContentScale.Crop,
                error = {
                    Icon(
                        painter = painterResource(
                            id = com.google.android.material.R.drawable.navigation_empty_icon
                        ),
                        contentDescription = null,
                        tint = MaterialTheme.colors.secondary,
                        modifier = Modifier
                            .padding(48.dp)
                            .fillMaxSize()
                    )
                }
            ) {

            }
        }
    }
}