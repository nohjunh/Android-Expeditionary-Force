package com.nohjunh.test

import androidx.recyclerview.widget.RecyclerView
import com.nohjunh.test.databinding.LayoutViewholderBinding

class ViewHolderEx (
    private val binding : LayoutViewholderBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(data : DataEx) {
        val price = data.price.toString() + " 원"
        val count = if (data.count == 0) "갯수가 없습니다" else data.count

        itemView.apply {
            binding.tvName.text = data.name.toString()
            binding.tvPrice.text = price.toString()
            binding.tvCount.text = count.toString()
        }

    }


}