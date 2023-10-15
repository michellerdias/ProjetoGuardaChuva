package com.michelle.microbacias.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.michelle.microbacias.R;

public class Sobre extends AppCompatActivity implements View.OnClickListener {

    private static CardView michelle, ana, valessa, artur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        michelle = findViewById(R.id.michelle);
        artur = findViewById(R.id.artur);
        ana = findViewById(R.id.ana);
        valessa= findViewById(R.id.valessa);


        michelle.setOnClickListener(this);
        artur.setOnClickListener(this);
        ana.setOnClickListener(this);
        valessa.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        if (view.getId() == R.id.michelle){
            i = new Intent(this, Michelle.class);
            startActivity(i);
        }
        if (view.getId() == R.id.artur){
            i = new Intent(this, Artur.class);
            startActivity(i);
        }
        if (view.getId() == R.id.ana){
            i = new Intent(this, Ana.class);
            startActivity(i);
        }
        if (view.getId() == R.id.valessa){
            i = new Intent(this, Valessa.class);
            startActivity(i);
        }
    }

}