package com.example.viewstrial;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<ContactModel> arrContacts = new ArrayList<>();
RecyclerView recyclerView;
FloatingActionButton opendialoguebox;
    RecyclerContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
recyclerView=findViewById(R.id.recyclerView);
opendialoguebox=findViewById(R.id.opendialoguebox);
opendialoguebox.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.addupdatelayout);
        EditText cn = dialog.findViewById(R.id.cn);
        EditText cnum = dialog.findViewById(R.id.cnum);
        Button save = dialog.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "",number="";
                if(!cn.getText().toString().equals("")){
                name = cn.getText().toString();

            } else{
                    Toast.makeText(MainActivity.this,"Please Enter Contact Name", Toast.LENGTH_LONG).show();
                }

                    if(!cnum.getText().toString().equals("")){
                     number = cnum.getText().toString();
                }else{
                        Toast.makeText(MainActivity.this,"Please Enter Contact Number", Toast.LENGTH_LONG).show();
                    }

                    arrContacts.add(new ContactModel(name,number));
                    adapter.notifyItemInserted(arrContacts.size());
                    recyclerView.scrollToPosition(arrContacts.size()-1);
                    dialog.dismiss();
            }
        });
        dialog.show();
    }
});
recyclerView.setLayoutManager(new LinearLayoutManager(this));
arrContacts.add(new ContactModel(R.drawable.a,"A","7738874661"));
        arrContacts.add(new ContactModel(R.drawable.b,"B","7738874661"));
        arrContacts.add(new ContactModel(R.drawable.c,"C","7738874661"));
        arrContacts.add(new ContactModel(R.drawable.d,"D","7738874661"));
        arrContacts.add(new ContactModel(R.drawable.e,"E","7738874661"));
        arrContacts.add(new ContactModel(R.drawable.f,"F","7738874661"));
        arrContacts.add(new ContactModel(R.drawable.g,"G","7738874661"));
        arrContacts.add(new ContactModel(R.drawable.h,"H","7738874661"));
        arrContacts.add(new ContactModel(R.drawable.i,"I","7738874661"));
        arrContacts.add(new ContactModel(R.drawable.j,"J","7738874661"));
        arrContacts.add(new ContactModel(R.drawable.k,"K","7738874661"));
        arrContacts.add(new ContactModel(R.drawable.l,"L","7738874661"));
        arrContacts.add(new ContactModel(R.drawable.m,"M","7738874661"));
        arrContacts.add(new ContactModel(R.drawable.n,"N","7738874661"));
        arrContacts.add(new ContactModel(R.drawable.o,"O","7738874661"));
 adapter = new RecyclerContactAdapter(this,arrContacts);
recyclerView.setAdapter(adapter);





    }
}