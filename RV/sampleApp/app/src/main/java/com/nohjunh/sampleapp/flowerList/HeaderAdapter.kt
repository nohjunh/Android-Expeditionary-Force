package com.nohjunh.sampleapp.flowerList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nohjunh.sampleapp.R

class HeaderAdapter: RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>(){
    private var flowerCount : Int = 0

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val flowerNumberTextView : TextView = itemView.findViewById(R.id.flower_number_text)

        fun bind(flowerCount : Int) { // flower 갯수가 몇 개 있는지 나타내는 곳에 flower갯수 binding
            flowerNumberTextView.text = flowerCount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.header_item, parent, false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(flowerCount)
    }

    override fun getItemCount(): Int {
        return 1
    }

    fun updateFLowerCount(updatedFlowerCount: Int) {
        flowerCount = updatedFlowerCount
        notifyDataSetChanged()
    }
}