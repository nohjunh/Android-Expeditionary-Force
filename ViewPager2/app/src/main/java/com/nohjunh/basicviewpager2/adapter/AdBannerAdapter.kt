package com.nohjunh.basicviewpager2.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nohjunh.basicviewpager2.R

class AdBannerAdapter(private val bannerImageDataSet : Array<Int>)
    :RecyclerView.Adapter<AdBannerAdapter.ViewHolder>() {

    // viewHolder 초기화
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var bannerImageView : ImageView = view.findViewById(R.id.Banner_image_View)
    }

    // 화면(View) 설정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.banner_item_layout, parent, false)
        return ViewHolder(view)
    }

    // 데이터 설정
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bannerImageView.load(bannerImageDataSet[position])
    }
    
    // 갯수 가져오기
    override fun getItemCount(): Int {
        return bannerImageDataSet.size
    }

}