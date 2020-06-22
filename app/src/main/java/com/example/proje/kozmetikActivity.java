package com.example.proje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kozmetikActivity extends AppCompatActivity {

    Button farmasi,eve,rossmann, avon, oriflame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kozmetik);


        farmasi = (Button)findViewById(R.id.farmasi);

        farmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), farmasiActivity.class);
                startActivity(intent);

            }
        });

        oriflame= (Button)findViewById(R.id.oriflame);

        oriflame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), oriflameActivity.class);
                startActivity(intent);

            }
        });

        rossmann = (Button)findViewById(R.id.rossmann);

        rossmann.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), rossmannActivity.class);
                startActivity(intent);

            }
        });

        avon = (Button)findViewById(R.id.avon);

        avon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), avonActivity.class);
                startActivity(intent);

            }
        });

        eve = (Button)findViewById(R.id.eve);

        eve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), eveActivity.class);
                startActivity(intent);

            }
        });
    }
}
