package ru.skillbranch.sbdelivery.repository

import kotlinx.coroutines.delay
import ru.skillbranch.sbdelivery.data.db.dao.CartDao
import ru.skillbranch.sbdelivery.data.db.dao.DishesDao
import ru.skillbranch.sbdelivery.data.network.RestService
import ru.skillbranch.sbdelivery.data.network.res.DishRes
import ru.skillbranch.sbdelivery.data.toDishItem
import ru.skillbranch.sbdelivery.data.toDishPersist
import ru.skillbranch.sbdelivery.screens.dishes.data.DishItem
import javax.inject.Inject

interface IDishesRepository {
    suspend fun searchDishes(newInput: String): List<DishItem>
    suspend fun isEmptyDishes(): Boolean
    suspend fun syncDishes()
    suspend fun findDishes(): List<DishItem>
    suspend fun findSuggestions(query: String): Map<String, Int>
    suspend fun addDishToCart(id: String)
    suspend fun removeDishFromCart(dishId: String)
    suspend fun cartCount(): Int
}

class DishesRepository @Inject constructor(
    private val api: RestService,
    private val dishesDao: DishesDao,
    private val cartDao: CartDao
) : IDishesRepository {
    override suspend fun searchDishes(newInput: String): List<DishItem> {
        TODO("Not yet implemented")
    }

    override suspend fun isEmptyDishes(): Boolean = true

    override suspend fun syncDishes() {
        val dishes = mutableListOf<DishRes>()
        var offset = 0
        while (true) {
            val res = api.getDishes(offset * 10, 10)
            if (res.isSuccessful) {
                offset++
                res.body()?.let {
                    dishes.addAll(it)
                } ?: dishes.addAll(emptyList())
            } else {
                break
            }
        }
        dishesDao.insertDishes(dishes.map { it.toDishPersist() })
    }

    override suspend fun findDishes(): List<DishItem> {
        return dishesDao.findAllDishes().map { it.toDishItem() }
    }

    override suspend fun findSuggestions(query: String): Map<String, Int> {
        TODO("Not yet implemented")
    }

    override suspend fun addDishToCart(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removeDishFromCart(dishId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun cartCount(): Int {
        TODO("Not yet implemented")
    }

}