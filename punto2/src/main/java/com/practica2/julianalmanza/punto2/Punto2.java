package com.practica2.julianalmanza.punto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Punto2 extends AppCompatActivity {

    Button cal;
    EditText n1,n2;
    TextView resul;
    RadioButton sum,res,mul,div;
    int a=1;
    double b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto2);
        cal=(Button) findViewById(R.id.cal);
        n1=(EditText) findViewById(R.id.n1);
        n2=(EditText) findViewById(R.id.n2);
        resul=(TextView) findViewById(R.id.resul);

        sum=(RadioButton) findViewById(R.id.sum);
        res=(RadioButton) findViewById(R.id.res);
        mul=(RadioButton) findViewById(R.id.mul);
        div=(RadioButton) findViewById(R.id.div);

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=1;
                res.setChecked(false);
                mul.setChecked(false);
                div.setChecked(false);
            }
        });
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=2;
                sum.setChecked(false);
                mul.setChecked(false);
                div.setChecked(false);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=3;
                sum.setChecked(false);
                res.setChecked(false);
                div.setChecked(false);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=4;
                sum.setChecked(false);
                mul.setChecked(false);
                res.setChecked(false);
            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                String nu1=n1.getText().toString();
                String nu2=n2.getText().toString();
                String resultado;
                
                if(nu1.isEmpty()){
                }else{
                    if(nu2.isEmpty()) {
                    }else{
                       double num1 = Double.parseDouble(nu1);
                        double num2 = Double.parseDouble(nu2);
                        switch (a) {
                            case (1):
                                b = num1 + num2;
                                resultado = Double.toString(b);
                                resul.setText(resultado);
                                break;
                            case (2):
                                b = num1 - num2;
                                resultado = Double.toString(b);
                                resul.setText(resultado);
                                break;
                            case (3):
                                b = num1 * num2;
                                resultado = Double.toString(b);
                                resul.setText(resultado);
                                break;
                            case (4):
                                b = num1 / num2;
                                resultado = Double.toString(b);
                                resul.setText(resultado);
                                break;

                        }
                    }
                }
            }
        });

    }
}


