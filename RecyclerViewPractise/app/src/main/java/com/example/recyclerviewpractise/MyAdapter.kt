package com.example.recyclerviewpractise

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

@Suppress("DEPRECATION")
class MyAdapter(private val news: ArrayList<News>, private val context: Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var myListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClicking(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        myListener = listener
    }

    // To create a new view instance when the layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cardnews, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    // Populate items with data
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = news[position]
        holder.himage.setImageResource(currentItem.newsImage)
        holder.hTitle.text = currentItem.newsheading
    }

    // Return the number of list items in your array
    override fun getItemCount(): Int {
        return news.size
    }

    // It holds the view so views are not created every time, saving memory
    class MyViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val hTitle = itemView.findViewById<TextView>(R.id.headingtitle)
        val himage = itemView.findViewById<ShapeableImageView>(R.id.headingimage)

        init {
            itemView.setOnClickListener {
                listener.onItemClicking(adapterPosition)
            }
        }
    }
}
