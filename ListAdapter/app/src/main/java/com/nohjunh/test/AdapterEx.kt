package com.nohjunh.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.nohjunh.test.databinding.LayoutViewholderBinding

class AdapterEx : ListAdapter<DataEx, ViewHolderEx>(ExDiffCallback) {

    interface ExHolderClickListener {
        fun onClick(view: View, position: Int, data: DataEx)
    }
    var exHolderClickListener : ExHolderClickListener? = null

    companion object {
        private val ExDiffCallback = object : DiffUtil.ItemCallback<DataEx>() {
            override fun areItemsTheSame(oldItem: DataEx, newItem: DataEx): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: DataEx, newItem: DataEx): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderEx {
        return ViewHolderEx(
            LayoutViewholderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderEx, position: Int) {
        val data = currentList[position]
        holder.bind(data)

        holder.itemView.setOnClickListener { view ->
            exHolderClickListener?.onClick(view, position, data)
            return@setOnClickListener
        }
    }

}