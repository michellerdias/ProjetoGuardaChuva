package com.michelle.microbacias.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.michelle.microbacias.R;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    private CardView novaMicrobacia, microbaciasCadastradas, tutorial, sobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        novaMicrobacia = (CardView) findViewById(R.id.novaMicrobacia);
        microbaciasCadastradas = (CardView) findViewById(R.id.microbaciasCadastradas);
        tutorial = (CardView) findViewById(R.id.tutorial);
        sobre = (CardView) findViewById(R.id.sobre);

        novaMicrobacia.setOnClickListener(this);
        microbaciasCadastradas.setOnClickListener(this);
        tutorial.setOnClickListener(this);
        sobre.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.novaMicrobacia:
                i = new Intent(this, NovaMicrobacia.class);
                startActivity(i);
                break;
            case R.id.microbaciasCadastradas:
                i = new Intent(this, MicrobaciasCadastradas.class);
                startActivity(i);
                break;
            case R.id.tutorial:
                i = new Intent(this, Tutorial.class);
                startActivity(i);
                break;
            case R.id.sobre:
                i = new Intent(this, Sobre.class);
                startActivity(i);
                break;
        }
    }
}