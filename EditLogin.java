package com.example.danny.parkingapplication;

import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditLogin extends AppCompatActivity {

    private DBManager dbManager;

    ArrayList<String> apple = new ArrayList<String>();
    DatabaseHelper mydb;


    TextView puid;
    TextView oldpin;

    TextView newPIN1;
    TextView newPIN2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_login);

        dbManager = new DBManager(this);
        dbManager.open();

        mydb = new DatabaseHelper(this);


        puid = (TextView) findViewById(R.id.editText7);
        oldpin = (TextView) findViewById(R.id.editText9);
        newPIN1 = (TextView) findViewById(R.id.editText10);
        newPIN2 = (TextView) findViewById(R.id.editText11);


        Button editor = (Button) findViewById(R.id.button5);
        editor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editPIN();
            }
        });

//dbManager.delete(Long.valueOf(puid.getText().toString()));
    }

        public void editPIN(){


            Cursor rs = mydb.getData(puid.getText().toString());
            if( rs!=null && rs.moveToFirst()){
                rs.moveToFirst();
                String idd = rs.getString(rs.getColumnIndex(DatabaseHelper.COL_3));
                String nam = rs.getString(rs.getColumnIndex(DatabaseHelper.COL_1));
                String sur = rs.getString(rs.getColumnIndex(DatabaseHelper.COL_2));
                String lic = rs.getString(rs.getColumnIndex(DatabaseHelper.COL_4));
                String pin = rs.getString(rs.getColumnIndex(DatabaseHelper.COL_5));
                String spo = rs.getString(rs.getColumnIndex(DatabaseHelper.COL_6));
                rs.close();
            }
String pin = "1111";



            if (
                    puid.getText().toString().isEmpty() || oldpin.getText().toString().isEmpty() ||
                    newPIN1.getText().toString().isEmpty() || newPIN2.getText().toString().isEmpty()) {
                Toast.makeText(this, "Missing Information", Toast.LENGTH_LONG).show();
            }

            else if (!newPIN1.getText().toString().equals((newPIN2.getText().toString())))
            {
                Toast.makeText(this, "Pins do not match", Toast.LENGTH_LONG).show();
            }
            else if (!pin.equals((oldpin.getText().toString()))) {
                Toast.makeText(this, "Wrong Pin entered", Toast.LENGTH_LONG).show();
            }
            else
             mydb.updateInfo(puid.getText().toString(), newPIN1.getText().toString());

            Toast.makeText(this, "Successfully changed PIN", Toast.LENGTH_LONG).show();


            }






    }

