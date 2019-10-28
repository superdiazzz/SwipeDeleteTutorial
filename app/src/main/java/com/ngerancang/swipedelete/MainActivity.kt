package com.ngerancang.swipedelete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter : FruitsAdapter ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fruits = getAllFruits()

        adapter = FruitsAdapter{ item, position ->

            // snack bar
            Snackbar.make(root_layout, "Undo?", Snackbar.LENGTH_LONG)
                .setAction("Ok", object : View.OnClickListener{
                    override fun onClick(v: View?) {

                        // do Undo here
                        adapter!!.addItemByPosition(item, position)

                    }

                }).show()

        }
        adapter!!.addFruits(fruits as ArrayList<String>)
        my_recyclerview.adapter = adapter

        ItemTouchHelper(SwipeDeleteCallback(adapter!!))
            .attachToRecyclerView(my_recyclerview)

    }

    private fun getAllFruits(): List<String> {
        val arr = mutableListOf<String>()
        arr.add("Apple")
        arr.add("Banana")
        arr.add("Mango")
        arr.add("Pineapple")
        arr.add("Kiwi")
        arr.add("Star Fruit")
        arr.add("Lemon")
        arr.add("Orange")
        arr.add("Strawberry")
        return arr
    }
}
