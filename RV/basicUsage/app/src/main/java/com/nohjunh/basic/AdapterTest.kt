package com.nohjunh.basic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterTest(private val dataSet : ArrayList<String>) : RecyclerView.Adapter<AdapterTest.ViewHolder>() {

    // ViewHolder는 다음과 같은 구성으로 만들어짐.
    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val textTest : TextView = view.findViewById(R.id.textItem)
    }

    // ViewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    // ViewHolder 데이터 처리
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTest.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}