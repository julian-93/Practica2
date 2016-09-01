package com.practica2.julianalmanza.punto4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


public class Punto4 extends AppCompatActivity {

    Button aceptar;
    DatePicker date;
    TextView mostrar;
    EditText loggin,password,conpassword,correo;
    RadioButton masculino,femenino;
    CheckBox deporte,arte,literatura,videjuegos;
    Spinner spinner;
    ArrayAdapter adapter;
    String sloggin,spassword,sconpassword,scorreo,ssexo,sciudad,spasatiempos,smostrar,error,fecha;
    int dia,mes,año;
    boolean comprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto4);

        comprobar=false;
        aceptar=(Button) findViewById(R.id.aceptar);
        date=(DatePicker) findViewById(R.id.date);
        mostrar=(TextView) findViewById(R.id.mostrar);
        loggin=(EditText) findViewById(R.id.loggin);
        password=(EditText) findViewById(R.id.password);
        conpassword=(EditText) findViewById(R.id.conpassword);
        correo=(EditText) findViewById(R.id.correo);
        masculino=(RadioButton) findViewById(R.id.masculino);
        femenino=(RadioButton) findViewById(R.id.femenino);
        deporte=(CheckBox) findViewById(R.id.deporte);
        arte=(CheckBox) findViewById(R.id.arte);
        literatura=(CheckBox) findViewById(R.id.literatura);
        videjuegos=(CheckBox) findViewById(R.id.videojuegos);



//Llenamos spinner
        spinner = (Spinner) findViewById(R.id.spinner);
// Crear una ArrayAdapter utilizando la matriz de cadenas y un diseño predeterminado spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ciudades, android.R.layout.simple_spinner_item);
// Especificar el diseño de utilizar cuando aparezca la lista de opciones
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
//Fin spinner

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Limpiar mostrar
                mostrar.setText("");
                smostrar="";
                error="";
                spasatiempos="";

                //Comprobar datos
                comprobar=true;
                if(loggin.getText().toString().isEmpty()){
                    comprobar=false;
                    error="*Falta  loggin \n";

                    //loggin.setError("Falta llenar");
                    //loggin.setError(null);

                }else{
                    sloggin=loggin.getText().toString();
                    smostrar="Nombre:\n"+sloggin+"\n";
                }

                if(password.getText().toString().isEmpty()){
                    comprobar=false;
                    error=error+"*Falta password \n";
                    //password.setError("Falta llenar");
                    //password.setError(null);

                }else{
                    spassword=password.getText().toString();
                    //smostrar=smostrar+"Contraseña:\n"+spassword+"\n";
                }

                if(conpassword.getText().toString().isEmpty()){
                    comprobar=false;
                    error=error+"*Falta Confirmar password \n";
                    //password.setError("Falta llenar");
                    //password.setError(null);

                }else{
                    sconpassword=conpassword.getText().toString();
                    if(spassword.equals(sconpassword)){
                        sconpassword=conpassword.getText().toString();
                        smostrar=smostrar+"Contraseña:\n"+spassword+"\n";
                    }else{
                        error=error+"*Las Contraseñas No Coinciden \n";
                        comprobar=false;
                    }

                }

                if(correo.getText().toString().isEmpty()){
                    comprobar=false;
                    error=error+"*Falta correo \n";
                    //password.setError("Falta llenar");
                    //password.setError(null);

                }else{
                    scorreo=correo.getText().toString();
                    smostrar=smostrar+"Correo:\n"+scorreo+"\n";
                }


                if(masculino.isChecked()){
                    ssexo="Masculino";
                    smostrar=smostrar+"Sexo:\n"+ssexo+"\n";
                }else{
                    if(femenino.isChecked()){
                        ssexo="Femenino";
                        smostrar=smostrar+"Sexo:\n"+ssexo+"\n";
                    }else{
                        comprobar=false;
                        error=error+"*No ha Seleccionado el Sexo\n";
                    }

                }


                //FECHA DE NACIMIENTO
                dia=date.getDayOfMonth();
                mes=date.getMonth()+1;
                año=date.getYear();
                fecha=Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(año);
                smostrar=smostrar+"Fecha De Nacimiento:\n"+fecha+"\n";

                //LUGAR DE NACIMIENTO
                sciudad=spinner.getSelectedItem().toString();
                smostrar=smostrar+"Ciudad De Nacimiento:\n"+sciudad+"\n";

                smostrar=smostrar+"Pasatiempos:\n";

                if(deporte.isChecked()){
                    spasatiempos="-Deportes\n";
                }
                if(videjuegos.isChecked()){
                    spasatiempos=spasatiempos+"-VideoJuegos\n";
                }
                if(arte.isChecked()){
                    spasatiempos=spasatiempos+"-Arte\n";
                }
                if(literatura.isChecked()){
                    spasatiempos=spasatiempos+"-Literatura\n";
                }
                if(spasatiempos.isEmpty()){
                    spasatiempos="-Ninguno\n";
                }
                smostrar=smostrar+spasatiempos;


                //Fin comprobar datos

                if(comprobar==true){
                    mostrar.setTextColor(Color.BLACK);
                    mostrar.setText(smostrar);
                }else{
                    mostrar.setTextColor(Color.RED);
                    mostrar.setText(error);
                }


            }
        });

    }
}
