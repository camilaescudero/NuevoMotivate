package com.motivate.nuevo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Cami on 25-05-2015.
 */
public class PreguntaRespuesta extends ActionBarActivity {
    private StringBuilder mensaje = new StringBuilder();
    private int random ;
    private TextView mensaje_cuenta;
    boolean terminado= false;
    private boolean acerto=false;
    int hola;
    ArrayList<String> jugadores = new ArrayList<String>();


    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_respuesta);
        TextView pregunta_aleatoria = (TextView)findViewById(R.id.txt_pregunta);
        EditText respuesta_jugador =(EditText)findViewById(R.id.txt_respuesta);
        mensaje_cuenta = (TextView)findViewById(R.id.txt_cuenta);
        //random = (int)(Math.random()*3);
        random=0;


        Resources res = getResources();
        String[] pregunta = res.getStringArray(R.array.preguntas);
        String[] respuesta = res.getStringArray(R.array.paises);
        String[] opciones ;


        esperar();

        pregunta_aleatoria.setText(pregunta[random]);
        Button boton4 = (Button)findViewById(R.id.btn_aceptarPreguntaRespuesta);
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView pregunta_aleatoria = (TextView)findViewById(R.id.txt_pregunta);
                EditText respuesta_jugador =(EditText)findViewById(R.id.txt_respuesta);
                //int random = (int)(Math.random()*4);

                Resources res = getResources();
                String[] pregunta = res.getStringArray(R.array.preguntas);
                String[] respuesta ;

                if (random == 0) {
                    respuesta = res.getStringArray(R.array.paises);
                    for (int i = 0; i < respuesta.length; i++) {
                        if (respuesta[i].equals(String.valueOf(respuesta_jugador.getText()))) {

                            AlertDialog.Builder builder = new AlertDialog.Builder(PreguntaRespuesta.this);
                            builder.setMessage("Ganaste 10 puntos")
                                    .setTitle("Atención!!")
                                    .setCancelable(false)
                                    .setNeutralButton("Aceptar",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    dialog.cancel();
                                                    Intent nuevoform4 = new Intent(PreguntaRespuesta.this,Ruleta.class);
                                                    startActivity(nuevoform4);
                                                }
                                            });
                            AlertDialog alert = builder.create();
                            alert.show();

                        }

                    }

                }
                if (random == 1) {
                    respuesta = res.getStringArray(R.array.animales);
                    for (int i = 0; i < respuesta.length; i++) {
                        if (respuesta[i].equals(String.valueOf(respuesta_jugador.getText()))) {

                            AlertDialog.Builder builder = new AlertDialog.Builder(PreguntaRespuesta.this);
                            builder.setMessage("Ganaste 10 puntos")
                                    .setTitle("Atención!!")
                                    .setCancelable(false)
                                    .setNeutralButton("Aceptar",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    dialog.cancel();
                                                    Intent nuevoform4 = new Intent(PreguntaRespuesta.this,Ruleta.class);
                                                    startActivity(nuevoform4);
                                                }
                                            });
                            AlertDialog alert = builder.create();
                            alert.show();

                        }

                    }

                }

                if (random == 2) {
                    respuesta = res.getStringArray(R.array.numeros);
                    for (int i = 0; i < respuesta.length; i++) {
                        if (respuesta[i].equals(String.valueOf(respuesta_jugador.getText()))) {

                            AlertDialog.Builder builder = new AlertDialog.Builder(PreguntaRespuesta.this);
                            builder.setMessage("Ganaste 10 puntos")
                                    .setTitle("Atención!!" + random)
                                    .setCancelable(false)
                                    .setNeutralButton("Aceptar",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    dialog.cancel();
                                                    Intent nuevoform4 = new Intent(PreguntaRespuesta.this,Ruleta.class);
                                                    startActivity(nuevoform4);
                                                }
                                            });
                            AlertDialog alert = builder.create();
                            alert.show();

                        }

                    }

                }


            }

        });


    }
    public void esperar(){

        new CountDownTimer(18000,1000) {


            @Override
            public void onTick(long l) {
                mensaje_cuenta.setText("Tiempo "+(l/1000));


            }

            @Override
            public void onFinish() {
                AlertDialog.Builder builder = new AlertDialog.Builder(PreguntaRespuesta.this);
                builder.setMessage("PERDISTE")
                        .setTitle("Atención!!")
                        .setCancelable(false)
                        .setNeutralButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        Intent nuevoform4 = new Intent(PreguntaRespuesta.this,Ruleta.class);
                                        startActivity(nuevoform4);
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();



            }
        }.start();


    }
}