package com.nohjunh.basic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nohjunh.basic.R
import com.nohjunh.basic.model.PlantList
import com.nohjunh.basic.model.PlantListItem

class PlantAdapter(val context : Context, val dataSet : PlantList) : RecyclerView.Adapter<PlantAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val imageView : ImageView = view.findViewById(R.id.imageView)
        val nameTextView : TextView = view.findViewById(R.id.nameView)
        val plantIdTextView : TextView = view.findViewById(R.id.plantIdView)
        val growZoneNumberTextView : TextView = view.findViewById(R.id.growZoneNumberView)
        val wateringIntervalTextView : TextView = view.findViewById(R.id.wateringIntervalView)
        val descriptionTextView : TextView = view.findViewById(R.id.descriptionView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.load(dataSet[position].imageUrl)
        holder.nameTextView.text = dataSet[position].name
        holder.plantIdTextView.text = dataSet[position].plantId
        holder.growZoneNumberTextView.text = dataSet[position].growZoneNumber.toString()
        holder.wateringIntervalTextView.text = dataSet[position].wateringInterval.toString()
        holder.descriptionTextView.text = dataSet[position].description
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}