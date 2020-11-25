package com.example.mvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm.data.db.Entities.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDB : RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile
        private var instance: ShoppingDB? = null

        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: CreateDB(context).also { instance = it }
        }

        private fun CreateDB(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDB::class.java, "ShoppingDB.db"
            ).build()
    }
}