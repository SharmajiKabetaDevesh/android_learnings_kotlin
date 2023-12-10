package com.example.leardb;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    private static final int ver = 1;
    private static final String DATABASEName = "ContactsDB";
    private static final String TAB_name = "contacts";
    private static final String KEY_id = "id";
    private static final String KEY_name = "name";
    private static final String KEy_phoneno = "phone_no";

    public Database(@Nullable Context context) {
        super(context, DATABASEName, null, ver);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TAB_name +
                "(" + KEY_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_name + " TEXT NOT NULL, " +
                KEy_phoneno + " INTEGER UNIQUE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TAB_name);
        onCreate(db);
    }

    public void addContact(String name, String phone_no) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_name, name);
        values.put(KEy_phoneno, phone_no);
        db.insert(TAB_name, null, values);
    }

    public ArrayList<Struc> getContacts() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TAB_name, null);

        ArrayList<Struc> contacts = new ArrayList<>();
        while (cursor.moveToNext()) {
            Struc contact = new Struc();
            contact.id = cursor.getInt(0);
            contact.name = cursor.getString(1);
            contact.phoneno = cursor.getString(2);
            contacts.add(contact);
        }

        cursor.close();
        return contacts;
    }

    public void update(Struc struc){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEy_phoneno,struc.phoneno);

        db.update(TAB_name,values,KEY_id +" = "+struc.id,null);


    }

    public void deletecontact(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TAB_name,KEY_id + "=?",new String[]{String.valueOf(id)});
    }

}


