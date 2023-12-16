package com.example.listviewcustomadapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter (val context:Activity,var value:ArrayList<User>)
    :ArrayAdapter<User>(context,R.layout.contentlayout_listview,value){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater= LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.contentlayout_listview,null)

        val image=view.findViewById<CircleImageView>(R.id.profile_image)
        val name=view.findViewById<TextView>(R.id.textview1)
        val lastmsg=view.findViewById<TextView>(R.id.textview2)
        val time=view.findViewById<TextView>(R.id.textview3)
        name.text=value[position].name
        lastmsg.text=value[position].lastmessage
        time.text=value[position].lastmessageTime
        image.setImageResource(value[position].imageId)

        return view

    }
}