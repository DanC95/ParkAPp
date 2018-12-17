package com.example.danny.parkingapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c){
        context = c;
    }

    public DBManager open() throws SQLException{
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();

    }


    public void insert(String PUID, String firstName, String lastName, String license, String pin, String hasSpot){
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.COL_3, PUID);
        contentValue.put(DatabaseHelper.COL_1, firstName);
        contentValue.put(DatabaseHelper.COL_2, lastName);
        contentValue.put(DatabaseHelper.COL_4, license);
        contentValue.put(DatabaseHelper.COL_5, pin);
        contentValue.put(DatabaseHelper.COL_6, hasSpot);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }






    public Cursor fetch(){
        String[] columns = new String[]{DatabaseHelper.COL_3, DatabaseHelper.COL_1, DatabaseHelper.COL_2,
                DatabaseHelper.COL_4, DatabaseHelper.COL_5, DatabaseHelper.COL_6};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor!= null){
            cursor.moveToFirst();
                    }
                    return cursor;
    }


    public int update(long puid, String firstName, String lastName, String license, String pin, String hasSpot)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_1, firstName);
        contentValues.put(DatabaseHelper.COL_2, lastName);
        contentValues.put(DatabaseHelper.COL_4, license);
        contentValues.put(DatabaseHelper.COL_5, pin);
        contentValues.put(DatabaseHelper.COL_6, hasSpot);

        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.COL_3 + " "
        + puid, null);
        return i;

    }

    public void delete(long puid){
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.COL_3 + "=" + puid, null);
    }
}
