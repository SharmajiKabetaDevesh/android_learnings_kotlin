package com.example.listviewtrial

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.listviewtrial.databinding.ActivityMainBinding
import com.example.listviewtrial.ui.theme.ListViewTrialTheme

class MainActivity : ComponentActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data= arrayListOf<String>()
        data.add("Find the best internships")
        data.add("Repair the resume")
        data.add("Khaana banana hai")
        data.add("Internship ka kaam karna hai")
        data.add("Life is lifeless without drinking")
        val showin=binding.listnew
        val adapterbabu=ArrayAdapter(this,android.R.layout.simple_list_item_1,data)
        showin.adapter=adapterbabu
        showin.setOnItemClickListener { adapterView, view, i, l ->
            val textonclick= "Clicked on"+(view as TextView).text.toString()
            Toast.makeText(this,textonclick,Toast.LENGTH_SHORT).show()

        }





    }
}

