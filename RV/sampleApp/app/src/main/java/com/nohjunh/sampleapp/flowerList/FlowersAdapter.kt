package com.nohjunh.sampleapp.flowerList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nohjunh.sampleapp.R
import com.nohjunh.sampleapp.data.Flower


// https://cliearl.github.io/posts/android/recyclerview-listadapter/
class FlowersAdapter(private val onClick: (Flower) -> Unit):
    ListAdapter<Flower, FlowersAdapter.FlowerViewHolder>(FlowerDiffCallback) {

    class FlowerViewHolder(itemView: View, val onClick: (Flower) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val flowerTextView : TextView = itemView.findViewById(R.id.flower_text)
        private val flowerImageView : ImageView = itemView.findViewById(R.id.flower_image)
        private var currentFlower: Flower? = null

        init {
            itemView.setOnClickListener {
                currentFlower?.let {
                    onClick(it)
                }
            }
        }

        /* flower의 name과 image Binding */
        fun bind(flower: Flower) {
            currentFlower = flower

            flowerTextView.text = flower.name
            if (flower.image != null ) {
                flowerImageView.setImageResource(flower.image)
            } else { // null 이면 rose 이미지로 통일
                flowerImageView.setImageResource(R.drawable.rose)
            }
        }
    }

    /* Creates and inflates view and return FlowerViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : FlowerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.flower_item, parent, false)
        return FlowerViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        val flower = getItem(position)
        holder.bind(flower)
    }
}

object FlowerDiffCallback : DiffUtil.ItemCallback<Flower>() {
    override fun areItemsTheSame(oldItem: Flower, newItem: Flower): Boolean {
        return oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: Flower, newItem: Flower): Boolean {
        return oldItem.id == newItem.id
    }
}