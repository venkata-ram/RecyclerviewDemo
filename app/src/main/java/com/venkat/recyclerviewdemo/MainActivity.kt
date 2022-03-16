package com.venkat.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    val friends = listOf(
        Friend("Vicky",25),
        Friend("Prathap",26),
        Friend("Perusu",26),
        Friend("Rakul",26),
        Friend("Raghul",26),
        Friend("Kirthi",26),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.my_recycler_view)

        recyclerView.setBackgroundColor(Color.CYAN)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val clickListener = {friend:Friend -> listItemClicked(friend)}
        recyclerView.adapter = MyRecyclerViewAdapter(friends,clickListener)

    }

    private fun listItemClicked(friend: Friend){
        Toast.makeText(this@MainActivity,"Hello ${friend.name}",Toast.LENGTH_LONG).show()
    }
}