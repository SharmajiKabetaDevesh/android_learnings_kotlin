package com.example.sqlitepractisekotlin

import ListViewer
import SqliteDb
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : ComponentActivity() {
    lateinit var namebut: EditText

    lateinit var numberbut:EditText

    lateinit var myrecyclerview:RecyclerView

    lateinit var datalistfromsql:ArrayList<ContactModel>

    lateinit var dbhelper:SqliteDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // finding the ids
        namebut=findViewById(R.id.name)
        numberbut=findViewById(R.id.number)
        myrecyclerview=findViewById<RecyclerView>(R.id.listView)
        var addbutton=findViewById<Button>(R.id.addbutton)




        dbhelper=SqliteDb(this)
        dataloader()


        // setting On click listener on buttons
        addbutton.setOnClickListener {
            var namedata=namebut.text.toString()
            val numberdata=numberbut.text.toString()
            val model=ContactModel(0,namedata,numberdata)
            val success=dbhelper.insertRecord(model) as Boolean

            if(success){
                dataloader()
                Toast.makeText(this,"Data Added Successfully",Toast.LENGTH_LONG).show()
            }else{
                dataloader()
                Toast.makeText(this,"Something is wrong",Toast.LENGTH_LONG).show()
            }
        }


    }

    private fun dataloader(){
        datalistfromsql=dbhelper.getAllRecords()
        //setting the adapter
        myrecyclerview.layoutManager=LinearLayoutManager(this)
        myrecyclerview.adapter= ListViewer(this, datalistfromsql)

    }

    }


