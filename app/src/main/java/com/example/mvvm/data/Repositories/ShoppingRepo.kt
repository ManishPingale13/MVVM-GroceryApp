package com.example.mvvm.data.Repositories

import com.example.mvvm.data.db.Entities.ShoppingItem
import com.example.mvvm.data.db.ShoppingDB

class ShoppingRepo(private val db: ShoppingDB) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().Upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().Delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()

}