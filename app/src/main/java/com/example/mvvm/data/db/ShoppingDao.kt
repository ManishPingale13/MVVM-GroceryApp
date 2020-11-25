package com.example.mvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvm.data.db.Entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Upsert(item: ShoppingItem)

    @Delete
    suspend fun Delete(item: ShoppingItem)

    @Query("SELECT * FROM ShoppingItem")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}