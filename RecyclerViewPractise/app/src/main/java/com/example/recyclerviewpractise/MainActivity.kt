package com.example.recyclerviewpractise

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractise.ui.theme.NewsDetailActivity


class MainActivity : ComponentActivity() {
    lateinit var myrecyclerview:RecyclerView
    lateinit var newsarray:ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
   myrecyclerview=findViewById(R.id.rv)

        val newsImageArray=arrayOf(
            R.drawable.pic11,
            R.drawable.pic12,
            R.drawable.pic13,
            R.drawable.p14,
            R.drawable.p15,
            R.drawable.p16,
            R.drawable.p17)
        val newsHeadingArray = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
            "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra"
        )

        val newsdata=arrayOf(
            getString(R.string.data),
            getString(R.string.data),
            getString(R.string.data),
            getString(R.string.data),
           getString(R.string.data),
            getString(R.string.data),
            getString(R.string.data),


        )

       newsarray=ArrayList<News>()

        for(i in newsHeadingArray.indices){
            val news=News(newsHeadingArray[i],newsImageArray[i],newsdata[i])
            newsarray.add(news)

        }
        //used to set hav bhav of items inside recycler view matlab verticallyscrotlling,horizontal scroling
       myrecyclerview.layoutManager= LinearLayoutManager(this)
       var myAdapter=MyAdapter(newsarray,this)
        myrecyclerview.adapter=myAdapter
      myAdapter.setOnItemClickListener(object:MyAdapter.onItemClickListener{
          override fun onItemClicking(position: Int) {
              //on clicking each item what action do you need to perform

              val intent = Intent(applicationContext,NewsDetailActivity::class.java)
              intent.putExtra("heading",newsarray[position].newsheading)
              intent.putExtra("newscontent",newsarray[position].newsContent)
              intent.putExtra("images",newsarray[position].newsImage)
              startActivity(intent)
          }

      })



    }
}

