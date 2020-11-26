package com.example.mvvm.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.data.db.Entities.ShoppingItem
import com.example.mvvm.ui.ShoppingList.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(var items: List<ShoppingItem>, private val viewModel: ShoppingViewModel) :
    RecyclerView.Adapter<ShoppingItemAdapter.ShoppingVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingVH(view)
    }

    override fun onBindViewHolder(holder: ShoppingVH, position: Int) {
        val curShoppingItem = items[position]

        holder.itemView.tvname.text = curShoppingItem.item_name
        holder.itemView.tvamount.text = curShoppingItem.item_amount.toString()

        holder.itemView.ivdelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.itemView.ivplus.setOnClickListener {
            curShoppingItem.item_amount++
            viewModel.upsert(curShoppingItem)
        }

        holder.itemView.ivMinus.setOnClickListener {
            if (curShoppingItem.item_amount > 0) {
                curShoppingItem.item_amount--
                viewModel.upsert(curShoppingItem)
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingVH(itemview: View) : RecyclerView.ViewHolder(itemview)

}