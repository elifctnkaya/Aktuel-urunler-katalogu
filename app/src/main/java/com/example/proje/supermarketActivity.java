package com.example.proje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class supermarketActivity extends AppCompatActivity {

    Button a101,altun,bim,migros,carrefour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermarket);

        a101 = (Button)findViewById(R.id.a101);

        a101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),a101Activity.class);
                startActivity(intent);

            }
        });

        altun = (Button)findViewById(R.id.altun);

        altun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), altunActivity.class);
                startActivity(intent);
            }
        });

        bim = (Button)findViewById(R.id.bim);

        bim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), bimActivity.class);
                startActivity(intent);

            }
        });

        migros = (Button)findViewById(R.id.migros);

        migros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), migrosActivity.class);
                startActivity(intent);

            }
        });

        carrefour = (Button)findViewById(R.id.carrefour);

        carrefour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), carrefourActivity.class);
                startActivity(intent);

            }
        });
    }
}
