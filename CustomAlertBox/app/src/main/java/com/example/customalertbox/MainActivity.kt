package com.example.customalertbox


import android.app.Dialog


import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity

import com.example.customalertbox.R.layout.custom_dialog
import com.example.customalertbox.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dialog=Dialog(this)
        dialog.setContentView(custom_dialog)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.alertbox))


        val goodButton =dialog.findViewById<Button>(R.id.goodbut)
            val badButton =dialog.findViewById<Button>(R.id.badbut)

        goodButton.setOnClickListener {
            dialog.dismiss()
        }

        badButton.setOnClickListener {

          Toast.makeText(this,"Try Kar Mil Samjhega",Toast.LENGTH_LONG).show()
        }

        binding.but1.setOnClickListener {

            dialog.show()
        }




    }


}

