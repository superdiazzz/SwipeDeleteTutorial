package com.ngerancang.swipedelete

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_fruit.view.*

class FruitsAdapter(val listenerDelete: (String, Int) -> Unit) : RecyclerView.Adapter<FruitsAdapter.FruitsViewHolder>() {


    var fruits  = ArrayList<String>()


    fun addFruits(fruits: ArrayList<String>){
        this.fruits.addAll(fruits)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_fruit, parent, false)
        return FruitsViewHolder(v)

    }

    override fun getItemCount(): Int {
        return fruits.size
    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        val currentItem = fruits[position]
        holder.name.text = currentItem
    }

    fun deleteItem(adapterPosition: Int) {

        val fruit = fruits[adapterPosition]
        listenerDelete(fruit, adapterPosition)
    }

    fun addItemByPosition(item: String, position: Int) {
        fruits.add(position, item)
        notifyItemInserted(position)
    }


    inner class FruitsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.name

    }

}