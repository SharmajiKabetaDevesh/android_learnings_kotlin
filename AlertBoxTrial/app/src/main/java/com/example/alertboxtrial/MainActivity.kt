package com.example.alertboxtrial

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.alertboxtrial.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.but1.setOnClickListener {
         val build1= AlertDialog.Builder(this).setTitle("Are you SUre")
             build1.setMessage("Do you want to close the app")
            build1.setIcon(R.drawable.baseline_exit_to_app_24)
            build1.setPositiveButton("Yes", DialogInterface.OnClickListener{ dialogInterface: DialogInterface, i: Int ->

                Toast.makeText(this,"Exited BRo",Toast.LENGTH_LONG).show()
                finish()
            })
            build1.setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"Ok BRo",Toast.LENGTH_LONG).show()
                finish()
            })
            build1.show()

        }
        binding.but2.setOnClickListener {
            val options =arrayOf("Gulab Jamun","Rasmalai","Kaju Katli")
            val build2=AlertDialog.Builder(this)
            build2.setTitle("Kya pasand hai aapko")
            build2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"Mera pasand $i ",Toast.LENGTH_LONG).show()
            })
            build2.setPositiveButton("Submit",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"Ordered",Toast.LENGTH_LONG).show()
            })

            build2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"Pakka na BRo",Toast.LENGTH_LONG).show()
            })
            build2.show()
        }
        binding.but3.setOnClickListener {
            val options=arrayOf("Gulab Jamun","RasMalai","Kaju Katli","Boondi")
            val build3 =AlertDialog.Builder(this)
            build3.setTitle("Sirf 2 hi select karo")
            build3.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                Toast.makeText(this,"AA rahe hai $i $b",Toast.LENGTH_LONG).show()

            })
            build3.setPositiveButton("Submit",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"Ordered",Toast.LENGTH_LONG).show()
            })

            build3.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"Pakka na BRo",Toast.LENGTH_LONG).show()
            })
            build3.show()


        }

    }
}

