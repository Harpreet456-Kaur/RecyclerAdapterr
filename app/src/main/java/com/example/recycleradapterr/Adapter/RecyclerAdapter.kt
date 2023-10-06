package com.example.recyclerview.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycleradapterr.Model.Article
import com.example.recycleradapterr.R
import com.example.recycleradapterr.databinding.ActivityMainBinding.inflate
import com.example.recycleradapterr.databinding.ItemsBinding

class RecyclerAdapter(val list: ArrayList<Article>, private val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.viewHolder>() {


    class viewHolder(itemVew: View) : RecyclerView.ViewHolder(itemVew) {
        val title = itemVew.findViewById<TextView>(R.id.itemTitle)
        val des = itemVew.findViewById<TextView>(R.id.itemDesc)
        val img = itemVew.findViewById<ImageView>(R.id.itemImage)
        fun onBind(currentItem: Article, context: Context) {
            title.text = currentItem.title.toString()
            des.text = currentItem.content
            Glide.with(context).load(currentItem.urlToImage)
                .placeholder(R.drawable.ic_image_placeholder).into(img)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
//        val binding = inflate(LayoutInflater.from(parent.context),parent,false)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val currentItem = list[position]
        holder.onBind(currentItem, context)

//        holder.title.text = currentItem.title
    }

}