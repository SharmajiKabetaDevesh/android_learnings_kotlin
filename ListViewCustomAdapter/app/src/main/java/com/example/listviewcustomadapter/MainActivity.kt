package com.example.listviewcustomadapter

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {

    lateinit var dataforlistview:ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name= arrayListOf("Devesh","Devang","Rohit","Vinit","Raj")
        val lastmsg= arrayListOf("Mai hoon na","Mera baab harami","Bhag Bsdke","Mai nalla","Meri gf ban gayi")
        val lastmsgtime= arrayListOf("06:45 AM","08:45 AM","09:45 AM","10:45 AM","11:45 AM")
        val phone = arrayListOf("7738874661","1234567898","1425367894","8787864878","56535656")
        val imgId= intArrayOf(R.drawable.pic11,R.drawable.pic12,R.drawable.pic13,R.drawable.p14,R.drawable.p15)


        dataforlistview=ArrayList()

        for(eachIndex in name.indices){
            val user=User(name[eachIndex],lastmsg[eachIndex],lastmsgtime[eachIndex], phone[eachIndex], imgId[eachIndex])
            dataforlistview.add(user)
        }



        val listviewshow=findViewById<ListView>(R.id.listdata)
        listviewshow.isClickable=true
        listviewshow.adapter=MyAdapter(this,dataforlistview)

        listviewshow.setOnItemClickListener { adapterView, view, i, l ->
            //open a new activity
           var userName=name[i]
            var userPhone=phone[i]
            var imgId=imgId[i]

            val intent= Intent(this,UserActivity::class.java)
            intent.putExtra("name",userName)
            intent.putExtra("phone",userPhone)
            intent.putExtra("image",imgId)
            startActivity(intent)

        }


    }
}
