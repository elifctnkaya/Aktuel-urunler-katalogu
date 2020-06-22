package com.example.proje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button spr, kzm , liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        spr = (Button)findViewById(R.id.supermarket);

        spr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),supermarketActivity.class);
                startActivity(intent);
            }
        });

        kzm = (Button)findViewById(R.id.kozmetik);

        kzm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),kozmetikActivity.class);
                startActivity(intent);

            }
        });


        liste =(Button)findViewById(R.id.liste);

        liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), listeActivity.class);
                startActivity(intent);

            }
        });

    }
}
