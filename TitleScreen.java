package com.example.danny.parkingapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;

public class TitleScreen extends AppCompatActivity {

    private DBManager dbManager;

    private SimpleCursorAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        dbManager = new DBManager(this);
        dbManager.open();


        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditlogin();
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });
    }

    public void openEditlogin()
    {
        Intent intent = new Intent(this, EditLogin.class);
        startActivity(intent);
    }


    public void openMap(){

        Intent intent = new Intent(this, PurdueMap.class);
        startActivity(intent);

    }
    public void openSignUp(){
        Intent intent = new Intent(this, SignUpScreen.class);

        startActivity(intent);

    }
}
