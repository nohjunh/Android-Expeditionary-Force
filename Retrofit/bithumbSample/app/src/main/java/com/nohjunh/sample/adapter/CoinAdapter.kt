package com.nohjunh.sample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nohjunh.sample.R
import com.nohjunh.sample.model.CurrentCoin

class CoinAdapter(val context: Context, val dataSet: List<CurrentCoin>) : RecyclerView.Adapter<CoinAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val coinNameTV : TextView = view.findViewById(R.id.coinNameTV)
        val coinPriceTV : TextView = view.findViewById(R.id.currentPriceTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coin_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.coinNameTV.text = dataSet[position].coinName
        holder.coinPriceTV.text = dataSet[position].coinInfo.closing_price.toString()
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
    
}