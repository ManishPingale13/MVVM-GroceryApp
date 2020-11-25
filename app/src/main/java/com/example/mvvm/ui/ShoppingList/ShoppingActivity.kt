package com.example.mvvm.ui.ShoppingList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm.R
import com.example.mvvm.data.Repositories.ShoppingRepo
import com.example.mvvm.data.db.ShoppingDB

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)


        val database = ShoppingDB(this)
        val repo = ShoppingRepo(database)
        val factory = ShoppingVMFactory(repo)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)
    }
}