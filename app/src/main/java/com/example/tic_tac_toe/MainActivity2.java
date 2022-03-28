package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
  /*
    Button arribaIzq;
    Button arribaMed;
    Button arribaDer;
    Button medioIzq;
    Button medioMed;
    Button medioDer;
    Button abajoIzq;
    Button abajoMed;
    Button abajoDer;
*/


    Button arribaIzq;
    Button arribaMed;
    Button arribaDer;
    Button medioIzq;
    Button medioMed;
    Button medioDer;
    Button abajoIzq;
    Button abajoMed;
    Button abajoDer;



    TextView aJugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String nombre = getIntent().getStringExtra("nombre");
        aJugar = (TextView) findViewById(R.id.aJugar);

        String simbolo = getIntent().getStringExtra("simbolo");



        if(simbolo=="circulo"){
            aJugar.setText("entre puta");

            /*
            arribaIzq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    arribaIzq.setText("X");
                }
            });
*/
        }else{
            aJugar.setText("Entre putita");
        }

        //aJugar.setText(nombre +", Que comience el juego!");
    }
}