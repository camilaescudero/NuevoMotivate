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
import com.motivate.nuevo.Jugador;
import com.motivate.nuevo.R;

import java.util.ArrayList;

/**
 * Created by Angélica on 26-05-2015.
 */


public class IJuegoNoDiga extends ActionBarActivity {

    Button comenzar;
    Button botonaceptar ;
    Button botonrechazar ;
    TextView mensaje_cuenta;
    DataBaseJuego dataBaseJuego = new DataBaseJuego(this);
    DataBaseJugador baseJugador = new DataBaseJugador(this);
    ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
    Juego juego = new Juego();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nodigasinodigano);

        TextView jugadorTurno= (TextView)findViewById(R.id.txt_turno_nodiga);

        //ASIGNA EL JUGADOR DE TURNO Y LO MUESTRA EN LA PANTALLA, ADEMAS DE MODIFICAR EN LA BASE DE DATOS EL TURNO DEL JUGADOR
        jugadors= baseJugador.rescatarDatos();
        juego.setTurno(dataBaseJuego.rescatarDatos());
        juego.setJugador(jugadors.get(juego.getTurno()));
        jugadorTurno.setText(jugadors.get(juego.getTurno()).getNombre());
        dataBaseJuego.modificarTurno(dataBaseJuego.devuelveId(),dataBaseJuego.rescatarDatos()+1,jugadors.size());

        comenzar = (Button) findViewById(R.id.btn_comenzar);
        mensaje_cuenta=(TextView) findViewById(R.id.Titulo);
        comenzar.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v) {
                esperar();
                comenzar.setEnabled(false);
            }
        });

        botonaceptar = (Button) findViewById(R.id.btn_aceptar);
        botonaceptar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                baseJugador.modificarPuntaje(juego.getJugador().getNombre(), juego.getJugador().getPuntaje() + 1);
                AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoNoDiga.this);
                builder.setMessage("Ganaste 1 punto")
                        .setTitle("Mensaje")
                        .setCancelable(false)
                        .setNeutralButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        Intent nuevoform4 = new Intent(IJuegoNoDiga.this,IRuleta.class);
                                        startActivity(nuevoform4);
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();




            }
        });


        botonrechazar = (Button) findViewById(R.id.btn_rechazar);
        botonrechazar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoNoDiga.this);
                builder.setMessage("Perdiste!")
                        .setTitle("Mensaje")
                        .setCancelable(false)
                        .setNeutralButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        Intent nuevoform4 = new Intent(IJuegoNoDiga.this,IRuleta.class);
                                        startActivity(nuevoform4);
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });





    }


    public void esperar(){

        new CountDownTimer(61000,1000){


            @Override
            public void onTick(long millisUntilFinished) {

                mensaje_cuenta.setText("" + (millisUntilFinished/1000))   ;
            }

            @Override
            public void onFinish() {
                mensaje_cuenta.setText("") ;

            }
        }.start();


    }


    public void aceptar(){
        botonaceptar = (Button) findViewById(R.id.btn_aceptar);
        botonaceptar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent nuevoformA = new Intent(IJuegoNoDiga.this,IRuleta.class);
                startActivity(nuevoformA);

            }
        });
    }
    public void rechazar(){

        botonrechazar = (Button) findViewById(R.id.btn_rechazar);
        botonrechazar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent nuevoformR = new Intent(IJuegoNoDiga.this,IRuleta.class);
                startActivity(nuevoformR);

            }
        });

    }


}
