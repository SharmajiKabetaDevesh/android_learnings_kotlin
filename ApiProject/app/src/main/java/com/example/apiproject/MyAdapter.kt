package com.example.apiproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiproject.ui.theme.Product
import com.squareup.picasso.Picasso

class MyAdapter(context: Context, val array: List<Product>?):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

//pehle jo apna card layout hai ya koi aur custom layout hai usko inflate kar do
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
   val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardrv,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
  return array!!.size
    }

    //views ko find kiya aur variables mai store kiya to be used by binder to pppulate
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder (itemView){
        val cardimage= itemView.findViewById<ImageView>(R.id.cardimage)!!
        val cardtitl= itemView.findViewById<TextView>(R.id.cardtext)!!
    }
  //this sets the individual data onto individual numerous cards
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
   val currentItem= array?.get(position)

      if (currentItem != null) {
          holder.cardtitl.text=currentItem.title
      }
      //how to show image from an url
      //we will be using an library called picaso
      if (currentItem != null) {
          Picasso.get().load(currentItem.thumbnail).into(holder.cardimage)
      }


    }
}