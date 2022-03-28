package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    TextView aJugar;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String nombre = getIntent().getStringExtra("nombre");
        aJugar = (TextView) findViewById(R.id.aJugar);
        score= (TextView) findViewById(R.id.score);

        Boolean simbolo = getIntent().getBooleanExtra("simbolo",true);

        arribaIzq = findViewById(R.id.arribaIzq);
        arribaMed = findViewById(R.id.arribaMed);
        arribaDer = findViewById(R.id.arribaDer);
        medioIzq = findViewById(R.id.medioIzq);
        medioMed = findViewById(R.id.medioMed);
        medioDer = findViewById(R.id.medioDer);
        abajoIzq = findViewById(R.id.abajoIzq);
        abajoMed = findViewById(R.id.abajoMed);
        abajoDer = findViewById(R.id.abajoDer);



        if(simbolo==true){


            setterClick(arribaIzq,"X");
            setterClick(arribaMed,"X");
            setterClick(arribaDer,"X");
            setterClick(medioIzq,"X");
            setterClick(medioMed,"X");
            setterClick(medioDer,"X");
            setterClick(abajoIzq,"X");
            setterClick(abajoMed,"X");
            setterClick(abajoDer,"X");

            comprobarJugada("X","O");




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

        aJugar.setText(nombre +", Que comience el juego!");


    }

    private void setterClick(Button btn ,String simbolo){
        String maq;
        if(simbolo=="X")
            maq="O";
        else
            maq="X";




            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    btn.setText(simbolo);
                    btn.setEnabled(false);

                    String estado = comprobarJugada(simbolo, maq);

                    if(estado!="perdiste" || estado!="ganaste")
                        elegir(maq);
                    estado = comprobarJugada(simbolo, maq);

                }

            });

    }


   private void setterAuto(Button btn,String simbolo){
        btn.setText(simbolo);
        btn.setEnabled(false);
    }


    private void elegir(String simbolo){

        ArrayList<Integer> casillas=new ArrayList<Integer>();

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
        Integer valor=Integer.parseInt(score.getText().toString());
        String total;

        if(estado=="Ganaste") {
            valor = valor + 10;
            total = valor.toString();
            score.setText(total);

        }else if (estado=="Perdiste"){
            valor=valor-5;
            total=valor.toString();
            score.setText(total);
        }
    }

    public String comprobarJugada(String jugador, String maquina){

        int verde = Color.parseColor("#98ff98");
        int rojo = Color.parseColor("#ff9688");
        if(arribaIzq.getText().toString()==arribaDer.getText().toString() && arribaDer.getText().toString()==arribaMed.getText().toString() && (arribaMed.getText().toString()=="X" || arribaMed.getText().toString()=="O")){
          if(arribaIzq.getText().toString()==maquina){



              arribaIzq.setBackgroundColor(rojo);
              arribaDer.setBackgroundColor(rojo);
              arribaMed.setBackgroundColor(rojo);
              arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);

              return "perdiste";
          }else{


              arribaIzq.setBackgroundColor(verde);
              arribaDer.setBackgroundColor(verde);
              arribaMed.setBackgroundColor(verde);
              arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);
              return "ganaste";
          }

        }else if(arribaIzq.getText().toString()==medioMed.getText().toString() && medioMed.getText().toString()==abajoDer.getText().toString() && (abajoDer.getText().toString()=="X" || abajoDer.getText().toString()=="O")){
            if(arribaIzq.getText().toString()==maquina){

                arribaIzq.setBackgroundColor(rojo);
                medioMed.setBackgroundColor(rojo);
                abajoDer.setBackgroundColor(rojo);
                arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);

                return "perdiste";
            }else{


                arribaIzq.setBackgroundColor(verde);
                medioMed.setBackgroundColor(verde);
                abajoDer.setBackgroundColor(verde);
                arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);
                return "ganaste";
            }
        }else if(arribaIzq.getText().toString()==medioIzq.getText().toString() && medioIzq.getText().toString()==abajoIzq.getText().toString() && (abajoIzq.getText().toString()=="X" || abajoIzq.getText().toString()=="O")){
            if(arribaIzq.getText().toString()==maquina){

                arribaIzq.setBackgroundColor(rojo);
                medioIzq.setBackgroundColor(rojo);
                abajoIzq.setBackgroundColor(rojo);
                arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);

                return "perdiste";
            }else{


                arribaIzq.setBackgroundColor(verde);
                medioIzq.setBackgroundColor(verde);
                abajoIzq.setBackgroundColor(verde);
                arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);
                return "ganaste";
            }
        }else if(medioIzq.getText().toString()==medioMed.getText().toString() && medioMed.getText().toString()==medioDer.getText().toString() && (abajoDer.getText().toString()=="X" || abajoDer.getText().toString()=="O")){
            if(arribaIzq.getText().toString()==maquina){

                medioIzq.setBackgroundColor(rojo);
                medioMed.setBackgroundColor(rojo);
                medioDer.setBackgroundColor(rojo);
                arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);

                return "perdiste";
            }else{


                medioIzq.setBackgroundColor(verde);
                medioMed.setBackgroundColor(verde);
                medioDer.setBackgroundColor(verde);
                arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);
                return "ganaste";
            }
        }else if(abajoIzq.getText().toString()==abajoMed.getText().toString() && abajoMed.getText().toString()==abajoDer.getText().toString() && (abajoDer.getText().toString()=="X" || abajoDer.getText().toString()=="O")){
            if(arribaIzq.getText().toString()==maquina){

                abajoIzq.setBackgroundColor(rojo);
                abajoMed.setBackgroundColor(rojo);
                abajoDer.setBackgroundColor(rojo);
                arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);

                return "perdiste";
            }else{


                abajoIzq.setBackgroundColor(verde);
                abajoMed.setBackgroundColor(verde);
                abajoDer.setBackgroundColor(verde);
                arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);
                return "ganaste";
            }
        }else if(abajoDer.getText().toString()==medioMed.getText().toString() && abajoIzq.getText().toString()==abajoDer.getText().toString() && (abajoIzq.getText().toString()=="X" || abajoIzq.getText().toString()=="O")){
            if(arribaIzq.getText().toString()==maquina){

                abajoDer.setBackgroundColor(rojo);
                medioMed.setBackgroundColor(rojo);
                arribaIzq.setBackgroundColor(rojo);
                arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);

                return "perdiste";
            }else{


                abajoDer.setBackgroundColor(verde);
                medioMed.setBackgroundColor(verde);
                arribaIzq.setBackgroundColor(verde);
                arribaMed.setEnabled(false);arribaIzq.setEnabled(false);arribaDer.setEnabled(false);medioIzq.setEnabled(false);medioMed.setEnabled(false);medioDer.setEnabled(false);abajoIzq.setEnabled(false);abajoDer.setEnabled(false);abajoMed.setEnabled(false);
                return "ganaste";
            }
        }
        return "nada";
    }

}