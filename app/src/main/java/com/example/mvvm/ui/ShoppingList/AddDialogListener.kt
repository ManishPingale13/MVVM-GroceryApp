package com.example.mvvm.ui.ShoppingList

import com.example.mvvm.data.db.Entities.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked(item: ShoppingItem)
}