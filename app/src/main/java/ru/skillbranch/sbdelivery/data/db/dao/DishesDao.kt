package ru.skillbranch.sbdelivery.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.google.android.material.circularreveal.CircularRevealHelper
import ru.skillbranch.sbdelivery.data.db.entity.DishesPersist

@Dao
interface DishesDao {
    @Query("SELECT * FROM dishes")
    suspend fun findAllDishes(): List<DishesPersist>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDishes(dishes: List<DishesPersist>)

    @Query("SELECT COUNT(*) FROM dishes")
    suspend fun dishesCounts(): Int

    @Query("SELECT * FROM dishes WHERE name LIKE '%' || :searchText || '%' ORDER BY name ASC")
    suspend fun findDishesFrom(searchText: String): List<DishesPersist>

    @Query("SELECT * FROM dishes WHERE id=:id")
    suspend fun findDish(id: String): DishesPersist
}