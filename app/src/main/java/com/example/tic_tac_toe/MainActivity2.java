package com.example.tic_tac_toe;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    Button arribaIzq;
    Button arribaMed;
    Button arribaDer;
    Button medioIzq;
    Button medioMed;
    Button medioDer;
    Button abajoIzq;
    Button abajoMed;
    Button abajoDer;
    Button volverAJugar;

    TextView aJugar;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String nombre = getIntent().getStringExtra("nombre");

        aJugar = findViewById(R.id.aJugar);
        score= findViewById(R.id.score);

        boolean simbolo = getIntent().getBooleanExtra("simbolo",true);

        arribaIzq = findViewById(R.id.arribaIzq);
        arribaMed = findViewById(R.id.arribaMed);
        arribaDer = findViewById(R.id.arribaDer);
        medioIzq = findViewById(R.id.medioIzq);
        medioMed = findViewById(R.id.medioMed);
        medioDer = findViewById(R.id.medioDer);
        abajoIzq = findViewById(R.id.abajoIzq);
        abajoMed = findViewById(R.id.abajoMed);
        abajoDer = findViewById(R.id.abajoDer);
        volverAJugar = findViewById(R.id.volverAJugar);



        if(simbolo){

            setterClick(arribaIzq,"X");
            setterClick(arribaMed,"X");
            setterClick(arribaDer,"X");
            setterClick(medioIzq,"X");
            setterClick(medioMed,"X");
            setterClick(medioDer,"X");
            setterClick(abajoIzq,"X");
            setterClick(abajoMed,"X");
            setterClick(abajoDer,"X");




        }else{
            elegir("X");
            setterClick(arribaIzq,"O");
            setterClick(arribaMed,"O");
            setterClick(arribaDer,"O");
            setterClick(medioIzq,"O");
            setterClick(medioMed,"O");
            setterClick(medioDer,"O");
            setterClick(abajoIzq,"O");
            setterClick(abajoMed,"O");
            setterClick(abajoDer,"O");
        }

        String texto=nombre +", Que comience el juego!";

        aJugar.setText(texto);




    }

    private void setterClick(Button btn ,String simbolo){
        String maq;
        if(simbolo.equals("O"))
            maq="X";
        else
            maq="O";

            btn.setOnClickListener(view -> {

                btn.setText(simbolo);
                btn.setEnabled(false);

                String estado = comprobarJugada(simbolo);

                if(estado.equals("ganaste") || estado.equals("perdiste")) {

                    volverAJugar.setOnClickListener(view1 -> {
                        arribaIzq.setText(null);
                        arribaMed.setText(null);
                        arribaDer.setText(null);

                        medioIzq.setText(null);
                        medioMed.setText(null);
                        medioDer.setText(null);

                        abajoIzq.setText(null);
                        abajoMed.setText(null);
                        abajoDer.setText(null);


                        arribaIzq.setEnabled(true);
                        arribaMed.setEnabled(true);
                        arribaDer.setEnabled(true);

                        medioIzq.setEnabled(true);
                        medioMed.setEnabled(true);
                        medioDer.setEnabled(true);

                        abajoIzq.setEnabled(true);
                        abajoMed.setEnabled(true);
                        abajoDer.setEnabled(true);

                        int blanco = Color.parseColor("#ffffff");

                         arribaIzq.setBackgroundColor(blanco);
                         arribaMed.setBackgroundColor(blanco);
                         arribaDer.setBackgroundColor(blanco);
                         medioIzq.setBackgroundColor(blanco);
                         medioMed.setBackgroundColor(blanco);
                         medioDer.setBackgroundColor(blanco);
                         abajoIzq.setBackgroundColor(blanco);
                         abajoMed.setBackgroundColor(blanco);
                         abajoDer.setBackgroundColor(blanco);

                        setScore(estado);
                    });
                }
                if(estado.equals("nada"))
                    elegir(maq);

                comprobarJugada(simbolo);

            });

    }


   private void setterAuto(Button btn,String simbolo){
        btn.setText(simbolo);
        btn.setEnabled(false);



    }


    private void elegir(String simbolo){

        ArrayList<Integer> casillas= new ArrayList<>();

        if( arribaIzq.getText().toString().isEmpty()){
          casillas.add(1);
        }
        if(arribaMed.getText().toString().isEmpty()){
            casillas.add(2);
        }
        if(arribaDer.getText().toString().isEmpty()){
            casillas.add(3);
        }
        if(medioIzq.getText().toString().isEmpty()){
            casillas.add(4);
        }
        if(medioMed.getText().toString().isEmpty()){
            casillas.add(5);
        }
        if(medioDer.getText().toString().isEmpty()){
            casillas.add(6);
        }
        if(abajoIzq.getText().toString().isEmpty()){
            casillas.add(7);
        }
        if(abajoMed.getText().toString().isEmpty()){
            casillas.add(8);
        }
        if(abajoDer.getText().toString().isEmpty()){
            casillas.add(9);
        }




        Random generador = new Random();
        int i = generador.nextInt(casillas.size());
        int elegida= casillas.get(i);


        if(elegida==1){
            setterAuto(arribaIzq,simbolo);
        }else if(elegida==2){
            setterAuto(arribaMed,simbolo);
        }else if(elegida==3){
            setterAuto(arribaDer,simbolo);
        }else if(elegida==4){
            setterAuto(medioIzq,simbolo);
        }else if(elegida==5){
            setterAuto(medioMed,simbolo);
        }else if(elegida==6){
            setterAuto(medioDer,simbolo);
        }else if(elegida==7){
            setterAuto(abajoIzq,simbolo);
        }else if(elegida==8){
            setterAuto(abajoMed,simbolo);
        }else if(elegida==9){
            setterAuto(abajoDer,simbolo);
        }
    }

    private void setScore(String estado){
        int valor=Integer.parseInt(score.getText().toString());
        String total;

        if(estado.equals("ganaste")) {
            valor = valor + 10;
            total = Integer.toString(valor);
            score.setText(total);

        }else if (estado.equals("perdiste")){
            valor=valor-5;
            total= Integer.toString(valor);
            score.setText(total);
        }
    }

    public String comprobarJugada(String jugador){

        int verde = Color.parseColor("#98ff98");
        int rojo = Color.parseColor("#ff9688");

        if(arribaIzq.getText().toString().equals(arribaDer.getText().toString())  && arribaDer.getText().toString().equals(arribaMed.getText().toString())  && (arribaMed.getText().toString().equals("X") || arribaMed.getText().toString().equals("O"))){
          if(arribaIzq.getText().toString().equals(jugador)){

              arribaIzq.setBackgroundColor(verde);
              arribaDer.setBackgroundColor(verde);
              arribaMed.setBackgroundColor(verde);
             medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);

              return "ganaste";
          }else{

              arribaIzq.setBackgroundColor(rojo);
              arribaDer.setBackgroundColor(rojo);
              arribaMed.setBackgroundColor(rojo);
              medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);
              return "perdiste";
          }

        }else if(arribaIzq.getText().toString().equals(medioMed.getText().toString()) && medioMed.getText().toString().equals(abajoDer.getText().toString()) && (abajoDer.getText().toString().equals("X") || abajoDer.getText().toString().equals("O"))){
            if(arribaIzq.getText().toString().equals(jugador)){


                arribaIzq.setBackgroundColor(verde);
                medioMed.setBackgroundColor(verde);
                abajoDer.setBackgroundColor(verde);
                arribaMed.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoMed.setEnabled(false);

                return "ganaste";
            }else{

                arribaIzq.setBackgroundColor(rojo);
                medioMed.setBackgroundColor(rojo);
                abajoDer.setBackgroundColor(rojo);
                arribaMed.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoMed.setEnabled(false);
                return "perdiste";
            }
        }else if(arribaIzq.getText().toString().equals(medioIzq.getText().toString()) && medioIzq.getText().toString().equals(abajoIzq.getText().toString()) && (abajoIzq.getText().toString().equals("X") || abajoIzq.getText().toString().equals("O"))){
            if(arribaIzq.getText().toString().equals(jugador)){


                arribaIzq.setBackgroundColor(verde);
                medioIzq.setBackgroundColor(verde);
                abajoIzq.setBackgroundColor(verde);
                arribaMed.setEnabled(false);arribaDer.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);

                return "ganaste";
            }else{

                arribaIzq.setBackgroundColor(rojo);
                medioIzq.setBackgroundColor(rojo);
                abajoIzq.setBackgroundColor(rojo);
                arribaMed.setEnabled(false);arribaDer.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);
                return "perdiste";
            }
        }else if(medioIzq.getText().toString().equals(medioMed.getText().toString()) && medioMed.getText().toString().equals(medioDer.getText().toString()) && (medioDer.getText().toString().equals("X") || medioDer.getText().toString().equals("O"))){
            if(medioDer.getText().toString().equals(jugador)){


                medioIzq.setBackgroundColor(verde);
                medioMed.setBackgroundColor(verde);
                medioDer.setBackgroundColor(verde);
                arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);

                return "ganaste";
            }else{

                medioIzq.setBackgroundColor(rojo);
                medioMed.setBackgroundColor(rojo);
                medioDer.setBackgroundColor(rojo);
                arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);
                return "perdiste";
            }
        }else if(abajoIzq.getText().toString().equals(abajoMed.getText().toString()) && abajoMed.getText().toString().equals(abajoDer.getText().toString()) && (abajoDer.getText().toString().equals("X") || abajoDer.getText().toString().equals("O"))){
            if(abajoIzq.getText().toString().equals(jugador)){


                abajoIzq.setBackgroundColor(verde);
                abajoMed.setBackgroundColor(verde);
                abajoDer.setBackgroundColor(verde);
                arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);

                return "ganaste";
            }else{

                abajoIzq.setBackgroundColor(rojo);
                abajoMed.setBackgroundColor(rojo);
                abajoDer.setBackgroundColor(rojo);
                arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);
                return "perdiste";
            }
        }else if(abajoIzq.getText().toString().equals(medioMed.getText().toString()) && abajoIzq.getText().toString().equals(arribaDer.getText().toString()) && (abajoIzq.getText().toString().equals("X") || abajoIzq.getText().toString().equals("O"))){
            if(abajoIzq.getText().toString().equals(jugador)){


                abajoIzq.setBackgroundColor(verde);
                medioMed.setBackgroundColor(verde);
                arribaDer.setBackgroundColor(verde);
                arribaMed.setEnabled(false);medioIzq.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);

                return "ganaste";
            }else{

                abajoIzq.setBackgroundColor(rojo);
                medioMed.setBackgroundColor(rojo);
                arribaDer.setBackgroundColor(rojo);
                arribaIzq.setEnabled(false); arribaMed.setEnabled(false);medioIzq.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);
                return "perdiste";
            }
        }else{
            return "nada";
        }

    }

}