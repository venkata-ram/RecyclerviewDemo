package com.venkat.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.concurrent.fixedRateTimer

class MyRecyclerViewAdapter(private val friends:List<Friend>,private val clickListener : (Friend)->Unit) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val friend = friends[position]
        holder.bind(friend,clickListener)
    }

    override fun getItemCount(): Int {
        return friends.size
    }
}

class MyViewHolder(val view : View) : RecyclerView.ViewHolder(view){
    val nameTextView = view.findViewById<TextView>(R.id.name_text_view)

    fun bind(friend: Friend,clickListener: (Friend) -> Unit){
        nameTextView.text = "Hello ${friend.name},${friend.age}"
        view.setOnClickListener {
            clickListener(friend)
        }
    }
}