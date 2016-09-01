package com.practica2.julianalmanza.punto3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class Punto3 extends AppCompatActivity {

    EditText ladocua,basetrian,alturatrian,baserectan,alturarectan,radiocir;
    TextView resultado;
    RadioButton cuadrado,triangulo,rectangulo,circulo;
    Button calcular;
    int a=0;
    double resul;
    LinearLayout laycua,laytrian,layrectan,laycir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto3);
        ladocua=(EditText) findViewById(R.id.ladocua);
        basetrian=(EditText) findViewById(R.id.basetrian);
        alturatrian=(EditText) findViewById(R.id.alturatrian);
        baserectan=(EditText) findViewById(R.id.baserectan);
        alturarectan=(EditText) findViewById(R.id.alturarectan);
        radiocir=(EditText) findViewById(R.id.radiocir);
        resultado=(TextView) findViewById(R.id.resultado);
        cuadrado=(RadioButton) findViewById(R.id.cuadrado);
        rectangulo=(RadioButton) findViewById(R.id.rectangulo);
        triangulo=(RadioButton) findViewById(R.id.triangulo);
        circulo=(RadioButton) findViewById(R.id.circulo);
        calcular=(Button) findViewById(R.id.calcular);
        laycua=(LinearLayout) findViewById(R.id.laycua);
        laytrian=(LinearLayout) findViewById(R.id.laytrian);
        layrectan=(LinearLayout) findViewById(R.id.layrectan);
        laycir=(LinearLayout) findViewById(R.id.laycir);


        cuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                laycua.setVisibility(View.VISIBLE);
                laytrian.setVisibility(View.GONE);
                layrectan.setVisibility(View.GONE);
                laycir.setVisibility(View.GONE);
            }
        });

        triangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                laytrian.setVisibility(View.VISIBLE);
                laycua.setVisibility(View.GONE);
                layrectan.setVisibility(View.GONE);
                laycir.setVisibility(View.GONE);
            }
        });

        rectangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layrectan.setVisibility(View.VISIBLE);
                laytrian.setVisibility(View.GONE);
                laycua.setVisibility(View.GONE);
                laycir.setVisibility(View.GONE);
            }
        });

        circulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                laycir.setVisibility(View.VISIBLE);
                laytrian.setVisibility(View.GONE);
                layrectan.setVisibility(View.GONE);
                laycua.setVisibility(View.GONE);
            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (cuadrado.isChecked()) {
                        String lado = ladocua.getText().toString();
                        if (lado.isEmpty()) {
                        } else {
                            resul = Double.parseDouble(lado);
                            resul = resul * resul;
                            lado = Double.toString(resul);
                            resultado.setText(lado);
                        }

                    }
                    if (triangulo.isChecked()) {
                        String base = basetrian.getText().toString();
                        String altura = alturatrian.getText().toString();
                        if (base.isEmpty()) {
                        } else {
                            if (altura.isEmpty()) {
                            } else {
                                resul = (Double.parseDouble(base))*(Double.parseDouble(altura));
                                resul = resul /2;
                                base = Double.toString(resul);
                                resultado.setText(base);
                            }

                        }
                    }

                    if (rectangulo.isChecked()) {
                        String base = baserectan.getText().toString();
                        String altura = alturarectan.getText().toString();
                        if (base.isEmpty()) {
                        } else {
                            if (altura.isEmpty()) {
                            } else {
                                resul = (Double.parseDouble(base))*(Double.parseDouble(altura));
                                base = Double.toString(resul);
                                resultado.setText(base);
                            }

                        }
                    }

                    if (circulo.isChecked()) {
                        String radio = radiocir.getText().toString();
                        if (radio.isEmpty()) {
                        } else {
                            resul = Double.parseDouble(radio);
                            resul = Math.PI*(resul*resul);
                            radio = Double.toString(resul);
                            resultado.setText(radio);
                        }

                    }
                }
        });


    }
}
