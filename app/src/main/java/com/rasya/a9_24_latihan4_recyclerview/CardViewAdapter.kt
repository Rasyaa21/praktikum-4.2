package com.rasya.a9_24_latihan4_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class CardViewAdapter (private val dataList: List<itemData>): RecyclerView.Adapter<CardViewAdapter.CardViewHolder>(){
    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): CardViewAdapter.CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_view, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewAdapter.CardViewHolder, position: Int) {
        val listItem = dataList[position]
        holder.titleView.text = listItem.nama
        holder.descriptionView.text = listItem.description

        Glide.with(holder.imageView.context)
            .load(listItem.imgUrl)
            .into(holder.imageView)

        holder.favBtn.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Favorite ${dataList[position].nama}", Toast.LENGTH_LONG).show()
        }

        holder.shareBtn.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Favorite ${dataList[position].nama}" , Toast.LENGTH_LONG).show()
        }

    }
    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleView: TextView = itemView.findViewById(R.id.tv_item_name)
        val descriptionView : TextView = itemView.findViewById(R.id.tv_item_detail)
        val imageView : ImageView = itemView.findViewById(R.id.img_item_photo)
        val favBtn : Button = itemView.findViewById(R.id.btn_set_favorite)
        val shareBtn : Button = itemView.findViewById(R.id.btn_set_share)
    }

}