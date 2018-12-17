package com.example.danny.parkingapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpScreen extends AppCompatActivity implements View.OnClickListener {

    private DBManager dbManager;


    TextView firstName;
    TextView lastName;
    TextView PUID;
    TextView License;
    TextView PIN1;
    TextView PIN2;
    TextView alert;
    ImageButton imageButton3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        dbManager = new DBManager(this);
        dbManager.open();

        firstName = (TextView) findViewById(R.id.editText);
        lastName = (TextView) findViewById(R.id.editText2);
        PUID = (TextView) findViewById(R.id.editText3);
        License = (TextView) findViewById(R.id.editText4);
        PIN1 = (TextView) findViewById(R.id.editText5);
        PIN2 = (TextView) findViewById(R.id.editText6);
        alert = (TextView) findViewById(R.id.textView);


        imageButton3 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3.setOnClickListener((View.OnClickListener) this);
    }






        public void onClick(View v) {
            if ( firstName.getText().toString().isEmpty() || lastName.getText().toString().isEmpty() ||
                    PUID.getText().toString().isEmpty() || License.getText().toString().isEmpty() ||
                    PIN1.getText().toString().isEmpty() || PIN2.getText().toString().isEmpty()) {
                alert.setTextColor(Color.RED);
                alert.setText("Information missing");
            }

            else if (!PIN1.getText().toString().equals((PIN2.getText().toString())))
            {
                alert.setTextColor(Color.RED);
                alert.setText("Pins do not match");
            }
            else
        {

            dbManager.insert(PUID.getText().toString(), firstName.getText().toString(), lastName.getText().toString()
                    , License.getText().toString(), PIN1.getText().toString(), "1");
            Toast.makeText(this, "Added to database", Toast.LENGTH_LONG).show();


            Intent intent = new Intent(SignUpScreen.this, PurdueMap.class);
            startActivity(intent);

        }








        }
}






