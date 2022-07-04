package ru.skillbranch.sbdelivery.data

import ru.skillbranch.sbdelivery.data.db.entity.DishesPersist
import ru.skillbranch.sbdelivery.data.network.res.DishRes
import ru.skillbranch.sbdelivery.screens.dishes.data.DishItem

fun DishRes.toDishPersist(): DishesPersist = DishesPersist(
    id,
    name,
    description ?: "",
    image ?: "",
    oldPrice ?: 0,
    price,
    rating ?: 0f,
    likes ?: 0,
    category,
    commentsCount ?: 0,
    active,
    createdAt,
    updatedAt
)

fun DishesPersist.toDishItem(): DishItem = DishItem(
    id,
    image,
    "$price",
    title = name
)