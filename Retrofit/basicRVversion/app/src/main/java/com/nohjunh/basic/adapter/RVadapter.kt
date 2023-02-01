package com.nohjunh.basic.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nohjunh.basic.R
import com.nohjunh.basic.model.Post

class RVadapter(private val dataSet : Post) : RecyclerView.Adapter<RVadapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val textViewItem : TextView = view.findViewById(R.id.textViewItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewItem.text = dataSet[position].title
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}