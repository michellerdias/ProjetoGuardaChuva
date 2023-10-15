package com.michelle.microbacias.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.michelle.microbacias.R;
import android.widget.TextView;
import java.text.DecimalFormat;

public class Calculadora extends AppCompatActivity {

    EditText altura, angulo, largura;
    Button calcular, salvar;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        altura = findViewById(R.id.editaltura);
        largura = findViewById(R.id.editlargura);
        angulo = findViewById(R.id.editangulo);
        calcular = findViewById(R.id.btcalcular);
        resultado = findViewById(R.id.volumeMicrobacia);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Obtém os valores dos campos de entrada de texto e converte para double
                    double anguloValue = Double.parseDouble(angulo.getText().toString());
                    double alturaValue = Double.parseDouble(altura.getText().toString());
                    double larguraValue = Double.parseDouble(largura.getText().toString());

                    // Calcula o volume com base nos valores obtidos
                    double anguloRadianos = Math.toRadians(anguloValue);
                    double alturaEfetiva = alturaValue * Math.cos(anguloRadianos);
                    double volume = larguraValue * alturaEfetiva * 0.1718;

                    // Formate o valor para exibir apenas 2 casas decimais
                    DecimalFormat df = new DecimalFormat("#.00");
                    String volumeFormatado = df.format(volume);

                    // Exiba o resultado no TextView
                    resultado.setText(volumeFormatado + " m³");
                } catch (NumberFormatException e) {
                    resultado.setText("Valores inválidos. Preencha todos os campos corretamente.");
                }
            }

            //salvar.setOnClickListener(new View.OnClickListener() {
                //Escrever o codigo para editar os valores de angulo, largura e altura no Banco de Dados, e salvar o volumeFormatado.
            //}

        });
    }
}