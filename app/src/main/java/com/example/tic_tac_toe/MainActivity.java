package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    RadioButton cruz;
    RadioButton circulo;
    Button btnJugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombre = (EditText) findViewById(R.id.nombre);
        cruz = (RadioButton) findViewById(R.id.cruz);
        circulo = (RadioButton) findViewById(R.id.circulo);
        btnJugar = (Button) findViewById(R.id.btnJugar);


        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                String pasarNombre = nombre.getText().toString();
                boolean simboloCruz= cruz.isChecked();
                boolean simboloCirculo= circulo.isChecked();

                if((simboloCruz==false && simboloCirculo==false) || simboloCruz==true)
                    i.putExtra("simbolo","cruz");
                else
                    i.putExtra("simbolo","circulo");


                if(pasarNombre.isEmpty())
                    i.putExtra("nombre", "Extraño");
                else
                    i.putExtra("nombre", pasarNombre);
                startActivity(i);

            }
        });
    }
}