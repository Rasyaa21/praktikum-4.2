package com.rasya.a9_24_latihan4_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GridAdapter (private val dataList: List<itemData>): RecyclerView.Adapter<GridAdapter.GridViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val listItem = dataList[position]
        Glide.with(holder.imgPhoto.context)
            .load(listItem.imgUrl)
            .into(holder.imgPhoto)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}