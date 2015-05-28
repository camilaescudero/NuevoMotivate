package com.motivate.nuevo;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CanteLaPalabra extends ActionBarActivity {
    //TEXTO, BOTON Y STRING DE POSIBLES PALABRAS
    private TextView txt_palabrasecreta;
    private TextView txt_muestratimer;
    private String[] palabraCancion = {"Amor", "Adios", "Sol", "Lluvia", "Hombre", "Mujer"};
    private Button bt_apretame;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantelapalabra);
        txt_palabrasecreta = (TextView) findViewById(R.id.txt_MuestraPalabraCancion);
        bt_apretame = (Button) findViewById(R.id.bt_MuestraPalabraCancion);
        txt_muestratimer = (TextView) findViewById(R.id.txt_timer);


        //CREAR NUMERO RANDOM
        final int rando = (int) (Math.random() * 6);
        bt_apretame.setOnClickListener(new View.OnClickListener() {
            //CAMBIA TXT DE LA PALABRA ES... POR UNA DEL STRING
            @Override
            public void onClick(View v) {
                txt_palabrasecreta.setText(palabraCancion[rando]);
                esperar();
            }
        });
    }
    // FUNCION PARA DEFINIR TIEMPO TIMER Y QUE HACER ANTES Y LUEGO DE QUE TERMINE

    public void esperar() {
        new CountDownTimer(90000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                txt_muestratimer.setText("" + (millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}
