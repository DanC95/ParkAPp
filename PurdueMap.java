package com.example.danny.parkingapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class PurdueMap extends AppCompatActivity {
    int idunno;
    boolean doReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purdue_map);
        doReset = false;



        Button button1 = findViewById(R.id.andBut);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSpots(0);
            }
        });

        Button button2 =  findViewById(R.id.cloBut);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpots(1);
            }
        });

        Button button3 =  findViewById(R.id.potBut);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSpots(2);
            }
        });

        Button button4 =  findViewById(R.id.gyteBut);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSpots(3);
            }
        });

        Button button5 =  findViewById(R.id.porBut);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSpots(4);
            }
        });

        Button button6 =  findViewById(R.id.sulBut);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSpots(5);
            }
        });
        Button button7 =  findViewById(R.id.lawBut);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSpots(6);
            }
        });

        Button buttonRandom =  findViewById(R.id.button14);
        buttonRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeReset();

            }
        });






    }


public void changeReset(){
        doReset = !doReset;
}

    public void openSpots(int here){
        idunno = here;

        Intent intent = new Intent(PurdueMap.this, Spots.class);
        intent.putExtra("location", idunno);
        intent.putExtra("resetter", doReset);

        startActivity(intent);

    }

    }

