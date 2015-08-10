package com.motivate.visual;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.motivate.nuevo.DataBaseJuego;
import com.motivate.nuevo.DataBaseJugador;
import com.motivate.nuevo.Juego;
import com.motivate.nuevo.JuegoCanteLaPalabra;
import com.motivate.nuevo.Jugador;
import com.motivate.nuevo.R;

import java.util.ArrayList;


public class IJuegoCanteLaPalabra extends ActionBarActivity {
    TextView txt_palabrasecreta;
    TextView txt_muestratimer;
    Button boton_apretame;
    Button boton_aceptar ;
    Button boton_rechazar ;
    JuegoCanteLaPalabra canteLaPalabra = new JuegoCanteLaPalabra();

    DataBaseJuego dataBaseJuego = new DataBaseJuego(this);
    DataBaseJugador baseJugador = new DataBaseJugador(this);
    ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
    Juego juego = new Juego();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantelapalabra);

        TextView jugadorTurno= (TextView)findViewById(R.id.txt_turno_cantelapalabra);

        //ASIGNA EL JUGADOR DE TURNO Y LO MUESTRA EN LA PANTALLA, ADEMAS DE MODIFICAR EN LA BASE DE DATOS EL TURNO DEL JUGADOR
        jugadors= baseJugador.rescatarDatos();
        juego.setTurno(dataBaseJuego.rescatarDatos());
        juego.setJugador(jugadors.get(juego.getTurno()));
        jugadorTurno.setText(jugadors.get(juego.getTurno()).getNombre());
        dataBaseJuego.modificarTurno(dataBaseJuego.devuelveId(),dataBaseJuego.rescatarDatos()+1,jugadors.size());


        txt_palabrasecreta = (TextView) findViewById(R.id.txt_MuestraPalabraCancion);
        boton_apretame = (Button) findViewById(R.id.bt_MuestraPalabraCancion);
        txt_muestratimer = (TextView) findViewById(R.id.txt_timer);

        establecerPalabra();


    }


    public void establecerPalabra(){
        boton_apretame.setOnClickListener(new View.OnClickListener() {
            //CAMBIA TXT DE LA PALABRA ES... POR UNA DEL STRING
            @Override
            public void onClick(View v) {
                txt_palabrasecreta.setText(canteLaPalabra.asignar_palabra());
                esperar();
            }
        });

    }

    public void esperar() {
        new CountDownTimer(30000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                txt_muestratimer.setText("Tiempo: " + (millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoCanteLaPalabra.this);
                builder.setMessage("Perdiste!")
                        .setTitle("Mensaje")
                        .setCancelable(false)
                        .setNeutralButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        Intent nuevoform4 = new Intent(IJuegoCanteLaPalabra.this, IRuleta.class);
                                        startActivity(nuevoform4);
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        }.start();


        boton_aceptar = (Button) findViewById(R.id.btn_aceptar);
        boton_aceptar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                baseJugador.modificarPuntaje(juego.getJugador().getNombre(), juego.getJugador().getPuntaje() + 1);
                AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoCanteLaPalabra.this);
                builder.setMessage("Ganaste 1 puntos")
                        .setTitle("Mensaje")
                        .setCancelable(false)
                        .setNeutralButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        Intent nuevoform4 = new Intent(IJuegoCanteLaPalabra.this,IRuleta.class);
                                        startActivity(nuevoform4);
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();




            }
        });


        boton_rechazar = (Button) findViewById(R.id.btn_rechazar);
        boton_rechazar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoCanteLaPalabra.this);
                builder.setMessage("Perdiste!")
                        .setTitle("Mensaje")
                        .setCancelable(false)
                        .setNeutralButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        Intent nuevoform4 = new Intent(IJuegoCanteLaPalabra.this, IRuleta.class);
                                        startActivity(nuevoform4);
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });


    }
}
