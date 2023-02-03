package com.nohjunh.basic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nohjunh.basic.R
import com.nohjunh.basic.database.entity.SentenceEntity
import com.nohjunh.basic.database.entity.WordEntity

class MainAdapter(val context : Context, val dataSet : List<WordEntity>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val textViewId : TextView = view.findViewById(R.id.TV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewId.text = dataSet[position].word
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}