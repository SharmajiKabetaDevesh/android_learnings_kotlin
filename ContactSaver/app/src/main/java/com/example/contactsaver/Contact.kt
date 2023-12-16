package com.example.contactsaver

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.contactsaver.databinding.ActivityContactBinding
import com.example.contactsaver.ui.theme.ContactDto
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Contact : AppCompatActivity() {
    private lateinit var binding:ActivityContactBinding
    private lateinit var database:DatabaseReference
    private lateinit var dialog: Dialog
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
       dialog=Dialog(this)
        dialog.setContentView(R.layout.dialogcontact)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.dialogboxwa))
        val dialogbutton=dialog.findViewById<Button>(R.id.buttondialog)
        dialogbutton.setOnClickListener {
            dialog.dismiss()
        }
        database= FirebaseDatabase.getInstance().getReference("Contacts")

        binding.save.setOnClickListener {
            val name=binding.name.text.toString()
            val number=binding.number.text.toString()
            val contact=ContactDto(name,number)
            database.child(number).setValue(contact).addOnSuccessListener {
                dialog.show()


            }.addOnFailureListener{
                Toast.makeText(this,"Try Again",Toast.LENGTH_SHORT).show()
            }


        }



    }
}