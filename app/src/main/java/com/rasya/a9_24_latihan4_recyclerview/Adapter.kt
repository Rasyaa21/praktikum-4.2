package com.rasya.a9_24_latihan4_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.net.URL

class Adapter (private val dataList: List<itemData>): RecyclerView.Adapter<Adapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleView: TextView = itemView.findViewById(R.id.title)
        val descriptionView : TextView = itemView.findViewById(R.id.description)
        val imageView : ImageView = itemView.findViewById(R.id.circleImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val listItem = dataList[position]
        holder.titleView.text = listItem.nama
        holder.descriptionView.text = listItem.description
        Glide.with(holder.imageView.context)
            .load(listItem.imgUrl)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}