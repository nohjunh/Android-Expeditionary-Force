package com.nohjunh.sample.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nohjunh.sample.R
import com.nohjunh.sample.model.CurOrderBookCoin
import org.w3c.dom.Text

class CoinAdapter(val context : Context, val dataSet : List<CurOrderBookCoin>) : RecyclerView.Adapter<CoinAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val coinNameTV : TextView = view.findViewById(R.id.coinNameTV)
        val bidsPriceTV1 : TextView = view.findViewById(R.id.bidsPriceTV1)
        val bidsPriceTV2 : TextView = view.findViewById(R.id.bidsPriceTV2)
        val asksPriceTV1 : TextView = view.findViewById(R.id.asksPriceTV1)
        val asksPriceTV2 : TextView = view.findViewById(R.id.asksPriceTV2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.coin_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.coinNameTV.text = dataSet[position].order_currency.toString()

        holder.bidsPriceTV1.text = dataSet[position].bids[0].price
        holder.bidsPriceTV2.text = dataSet[position].bids[1].price
        holder.bidsPriceTV1.setTextColor(Color.parseColor("#D61355"))
        holder.bidsPriceTV2.setTextColor(Color.parseColor("#D61355"))

        holder.asksPriceTV1.text = dataSet[position].asks[0].price
        holder.asksPriceTV2.text = dataSet[position].asks[1].price
        holder.asksPriceTV1.setTextColor(Color.parseColor("#4B56D2"))
        holder.asksPriceTV2.setTextColor(Color.parseColor("#4B56D2"))

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}