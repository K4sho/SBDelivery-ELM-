package ru.skillbranch.sbdelivery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import ru.skillbranch.sbdelivery.data.db.entity.CartItemDbView

@Dao
interface CartDao {
    @Query("SELECT * FROM CartItemDbView")
    suspend fun findCartItems(): List<CartItemDbView>
}