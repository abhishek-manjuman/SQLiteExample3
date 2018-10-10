package com.swipcom.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDBHelper extends SQLiteOpenHelper {


    public static final String CREATE_TABLE="create table"+ ContactContract.contactEntery.TABLE_NAME +"("+ContactContract.contactEntery.CONTACT_ID+" number,"+
           ContactContract.contactEntery.NAME +" text,"+ContactContract.contactEntery.EMAIL+" text);" ;
    public static final String DROP_TABLE="drop table if exists "+ ContactContract.contactEntery.TABLE_NAME +";" ;

    public static final String DATABAE_NAME="contact_db";
    public static final int DATABAE_VEARION = 1;

    public ContactDBHelper(Context context){
        super(context,DATABAE_NAME,null,DATABAE_VEARION);

        Log.d("Database operation","Database Created......");

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        Log.d("database operation", "onCreate: Table Created........ ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);
        onCreate(db);

    }

    public void addContact(int id, String name, String email,SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues= new ContentValues();
        contentValues.put(ContactContract.contactEntery.CONTACT_ID,id);
        contentValues.put(ContactContract.contactEntery.NAME,name);
        contentValues.put(ContactContract.contactEntery.EMAIL,email);

        sqLiteDatabase.insert(ContactContract.contactEntery.TABLE_NAME,null,contentValues);
        Log.d("Database Opeartion","one row insarted....");

    }
}
