package ru.skillbranch.sbdelivery.screens.dishes.ui

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import dev.chrisbanes.accompanist.coil.CoilImage
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.screens.dishes.data.DishItem
import ru.skillbranch.sbdelivery.screens.root.ui.AppTheme

@Composable
fun DishItem(
    dish: DishItem,
    onClick: (dishId: DishItem) -> Unit,
    addToCart: (dishId: DishItem) -> Unit
) {
    Card(Modifier.requiredHeight(250.dp)) {
        ConstraintLayout(
            Modifier
                .clickable {
                    onClick(dish)
                }
        ) {
            val (fab, title, poster, price) = createRefs()

            CoilImage(
                data = dish.image,
                contentDescription = "photo of the dish",
                contentScale = ContentScale.Crop,
                error = {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.bg_splash
                        ),
                        contentDescription = "Error loading image",
                        tint = MaterialTheme.colors.secondary,
                        modifier = Modifier
                            .padding(48.dp)
                            .fillMaxSize()
                    )
                },
                modifier = Modifier.constrainAs(poster) {
                    top.linkTo(parent.top)
                })
            FloatingActionButton(
                onClick = { addToCart(dish) },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                modifier = Modifier.constrainAs(fab) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_add_24),
                    contentDescription = "Add to Card"
                )
            }
        }
    }
}