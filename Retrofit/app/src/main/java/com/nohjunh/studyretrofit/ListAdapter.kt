package com.nohjunh.studyretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nohjunh.studyretrofit.network.model.CurrentPriceDTO
import retrofit2.Callback

class ListAdapter(private val context: Context) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var datas = mutableListOf<CurrentPriceDTO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val txt1: TextView = itemView.findViewById(R.id.firstText)
        private val txt2: TextView = itemView.findViewById(R.id.secondText)

        fun bind(item: CurrentPriceDTO) {
            /*
            txt1.text = item.data.openingPrice.toString()
            txt2.text = item.data.closingPrice.toString()

             */
        }
    }
}