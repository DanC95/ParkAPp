package com.example.danny.parkingapplication;



import android.content.ContentValues;
import android.content.Context;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "students2.db";


    public static final String TABLE_NAME = "students";


    public static final String COL_1 = "FirstName";
    public static final String COL_2 = "lastName";
    public static final String COL_3 = "PUID";
    public static final String COL_4 = "License";
    public static final String COL_5 = "PIN";
    public static final String COL_6 = "HasSpot";

    //private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COL_3 + "TEXT" + COL_1 + "TEXT," + COL_2 +
            //"TEXT" + COL_4 + "TEXT" + COL_5 + "TEXT" + COL_6 + "TEXT);";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

     //   db.execSQL(CREATE_TABLE);
        //db.execSQL(" CREATE TABLE " + TABLE_NAME + " ( " + " COL_3 TEXT, " + " COL_1 TEXT, " + " COL_2 TEXT, " + " COL_4 TEXT, " + " COL_5 TEXT, " +" COL_6 TEXT " + " );  " );    }
        db.execSQL(" CREATE TABLE " + TABLE_NAME + "(" + COL_3 + " TEXT, " + COL_1 + " TEXT , " + COL_2 + " TEXT, " + COL_4 + " TEXT , " + COL_5 + " TEXT , " + COL_6 + " TEXT " +")");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public Cursor getData(String puid){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select " +COL_5+ " from " + "students" +" where " +" PUID " + " =' " +puid +"'"  ,null);
                return res;
    }





    public void updateInfo(String puid, String pin){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("PIN", pin);
        db.update("students", contentValues, " PUID = ? ", new String [] { puid});
    }

    public ArrayList<String> getAllInfo(){
        ArrayList<String> array_list = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from students" , null);
        res.moveToFirst();

        while(!res.isAfterLast()){
            array_list.add(res.getString(res.getColumnIndex(COL_3)));
            res.moveToNext();

        }
        return array_list;
    }











}


