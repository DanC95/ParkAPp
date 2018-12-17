package com.example.danny.parkingapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.danny.parkingapplication.ParkingSpots.multi;

public class Spots extends AppCompatActivity {

    Intent intent;
    int intValue;
    static int[][] multi = new int[7][6];







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots);

        intent = getIntent();
        intValue = intent.getIntExtra("location", 0);

        Button spot1 =  findViewById(R.id.spot1);
        Button spot2 =  findViewById(R.id.spot2);
        Button spot3=  findViewById(R.id.spot3);
        Button spot4 =  findViewById(R.id.spot4);
        Button spot5 =  findViewById(R.id.spot5);
        Button spot6 = findViewById(R.id.spot6);


        Boolean myBool = getIntent().getExtras().getBoolean("resetter");




        spot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int spot = 0;
                spotClicked(intValue,spot) ;

            }
        });

        spot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int spot =1;
                spotClicked(intValue,spot) ;


            }
        });

        spot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int spot = 2;
                spotClicked(intValue,spot) ;


            }
        });

        spot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int spot = 3;
                spotClicked(intValue,spot) ;


            }
        });

        spot5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int spot = 4;
                spotClicked(intValue,spot) ;

                }


        });

        spot6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int spot = 5;
                    spotClicked(intValue,spot) ;

                }

                ;

        });

    }




    public void spotClicked(int value, int spot) {
        if (multi[value][spot]==0)
        {
            multi[value][spot] = 1;
            Toast.makeText(this, "Spot has been reserved", Toast.LENGTH_LONG).show();
            changeColor(spot);

        } else {
            Toast.makeText(this, "Spot already taken", Toast.LENGTH_LONG).show();

        }
    }
        public void changeColor(int apple){

            if (apple ==0 )
            {
                Button spot1 =  findViewById(R.id.spot1);
                spot1.setTextColor(Color.RED);
            }
            else if (apple == 1)
            {
                Button spot2 =  findViewById(R.id.spot2);
                spot2.setTextColor(Color.RED);
            }
            else if (apple == 2)
            {
                Button spot3 =  findViewById(R.id.spot3);
                spot3.setTextColor(Color.RED);
            }
            else if (apple ==3 )
            {
                Button spot4 =  findViewById(R.id.spot4);
                spot4.setTextColor(Color.RED);
            }
            else if (apple == 4)
            {
                Button spot5 =  findViewById(R.id.spot5);
                spot5.setTextColor(Color.RED);
            }
            else
            {
                Button spot6 =  findViewById(R.id.spot6);
                spot6.setTextColor(Color.RED);
            }


        }

    }



