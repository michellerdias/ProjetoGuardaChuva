package com.michelle.microbacias.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.michelle.microbacias.Calculo;
import com.michelle.microbacias.MainActivity;
import com.michelle.microbacias.R;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class NovaMicrobacia extends AppCompatActivity {
    private EditText editNomeProprietario, editCpf, editCep, editRua, editNumero, altura, angulo, largura;
    private Button btcalcular, btsalvar;
    TextView resultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_microbacia);

        editNomeProprietario = findViewById(R.id.editNomeProprietario);
        editCpf = findViewById(R.id.editCpf);
        editCep = findViewById(R.id.editCep);
        editRua = findViewById(R.id.editRua);
        editNumero = findViewById(R.id.editNumero);
        btcalcular = findViewById(R.id.btcalcular);
        altura = findViewById(R.id.editaltura);
        largura = findViewById(R.id.editlargura);
        angulo = findViewById(R.id.editangulo);
        resultado = findViewById(R.id.volumeMicrobacia);
        btsalvar = findViewById(R.id.btsalvar);

        btcalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                double anguloValue = Double.parseDouble(findViewById(R.id.editangulo).toString());
                double alturaValue = Double.parseDouble(findViewById(R.id.editaltura).toString());
                double larguraValue = Double.parseDouble(findViewById(R.id.editlargura).toString());
                double anguloRadianos = Math.toRadians(anguloValue);
                double alturaEfetiva = alturaValue * Math.cos(anguloRadianos);
                double volume = larguraValue * alturaEfetiva * 0.1718;

                public double getVolume() {
                    return volume;
                }
                resultado.setText("Volume calculado: " + getVolume());
            }
        });


        btsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeProprietario = editNomeProprietario.getText().toString();
                String cpf = editCpf.getText().toString();
                String cep = editCep.getText().toString();
                String rua = editRua.getText().toString();
                String numero = editNumero.getText().toString();

                // Verifique se os campos não estão vazios
                if (!nomeProprietario.isEmpty() && !cpf.isEmpty() && !cep.isEmpty() && !rua.isEmpty() && !numero.isEmpty()) {
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    DocumentReference microbaciaRef = db.collection("microbacias").document();

                    // Crie um mapa de dados
                    Map<String, Object> microbacia = new HashMap<>();
                    microbacia.put("nomeProprietario", nomeProprietario);
                    microbacia.put("cpf", cpf);
                    microbacia.put("cep", cep);
                    microbacia.put("rua", rua);
                    microbacia.put("numero", numero);
                    microbacia.put("altura", altura);
                    microbacia.put("largura", largura);
                    microbacia.put("angulo", angulo);


                    // Adicione os dados ao Firestore
                    microbaciaRef.set(microbacia)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    // Dados enviados com sucesso
                                    //Abre a Activity Calculadora
                                    Intent intent = new Intent(NovaMicrobacia.this, Calculadora.class);
                                    startActivity(intent);
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    // Tratamento de erros das falhas
                                    // Pensar nos tipos de erro
                                }
                            });
                }
            }
        });
    }
}