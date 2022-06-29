package ru.skillbranch.sbdelivery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import ru.skillbranch.sbdelivery.data.db.entity.DishesPersist

@Dao
interface DishesDao {
    @Query("SELECT * FROM dishes")
    suspend fun findAllDishes(): List<DishesPersist>
}