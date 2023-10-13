package com.michelle.microbacias;

public class Calculo {

    double anguloValue = Double.parseDouble(angulo.getText().toString());
    double alturaValue = Double.parseDouble(altura.getText().toString());
    double larguraValue = Double.parseDouble(largura.getText().toString());

    double anguloRadianos = Math.toRadians(anguloValue);
    double alturaEfetiva = alturaValue * Math.cos(anguloRadianos);
    double volume = larguraValue * alturaEfetiva * 0.1718;

}
