package com.motivate.visual;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.motivate.nuevo.DataBaseJuego;
import com.motivate.nuevo.DataBaseJugador;
import com.motivate.nuevo.Juego;
import com.motivate.nuevo.JuegoPreguntaRespuesta;
import com.motivate.nuevo.Jugador;
import com.motivate.nuevo.R;

import java.util.ArrayList;

/**
 * Created by Cami on 25-05-2015.
 */
public class IJuegoPreguntaRespuesta extends ActionBarActivity {
    StringBuilder mensaje = new StringBuilder();
    int numero_aleatorio;
    TextView mensaje_cuenta;
    boolean terminado= false;
    boolean acerto=false;
    DataBaseJuego dataBaseJuego = new DataBaseJuego(this);
    DataBaseJugador baseJugador = new DataBaseJugador(this);
    ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
    Juego juego = new Juego();

  public IJuegoPreguntaRespuesta() {

    }

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_respuesta);
        numero_aleatorio = (int)(Math.random()*3);

        TextView jugadorTurno= (TextView)findViewById(R.id.txt_turno_preguntarespuesta);

        //ASIGNA EL JUGADOR DE TURNO Y LO MUESTRA EN LA PANTALLA, ADEMAS DE MODIFICAR EN LA BASE DE DATOS EL TURNO DEL JUGADOR
        jugadors= baseJugador.rescatarDatos();
        juego.setTurno(dataBaseJuego.rescatarDatos());
        juego.setJugador(jugadors.get(juego.getTurno()));
        jugadorTurno.setText(jugadors.get(juego.getTurno()).getNombre());
        dataBaseJuego.modificarTurno(dataBaseJuego.devuelveId(),dataBaseJuego.rescatarDatos()+1,jugadors.size());

        TextView pregunta_aleatoria = (TextView)findViewById(R.id.txt_pregunta);
        EditText respuesta_jugador =(EditText)findViewById(R.id.txt_respuesta);
        mensaje_cuenta = (TextView)findViewById(R.id.txt_cuenta);

        Resources res = getResources();
        String[] pregunta = res.getStringArray(R.array.preguntas);


        String[] opciones ;
        final JuegoPreguntaRespuesta preguntaRespuesta = new JuegoPreguntaRespuesta(pregunta);
        esperar();

        pregunta_aleatoria.setText(pregunta[numero_aleatorio]);
        Button boton4 = (Button)findViewById(R.id.btn_aceptarPreguntaRespuesta);
        boton4.setOnClickListener(new View.OnClickListener() {
                    @Override
            public void onClick(View view) {
                String[] respuesta;
                TextView pregunta_aleatoria = (TextView)findViewById(R.id.txt_pregunta);
                EditText respuesta_jugador =(EditText)findViewById(R.id.txt_respuesta);

                 Resources res = getResources();
                if (numero_aleatorio == 0) {

                    respuesta = res.getStringArray(R.array.paises);
                    mensaje_respuesta(preguntaRespuesta.comparar(String.valueOf(respuesta_jugador.getText()), respuesta));

                }
                if (numero_aleatorio== 1) {
                    respuesta = res.getStringArray(R.array.animales);
                    mensaje_respuesta(preguntaRespuesta.comparar(String.valueOf(respuesta_jugador.getText()), respuesta));

                }

                if (numero_aleatorio == 2) {
                    respuesta = res.getStringArray(R.array.numeros);
                    mensaje_respuesta(preguntaRespuesta.comparar(String.valueOf(respuesta_jugador.getText()), respuesta));

                }
            }

        });


    }
    public void mensaje_respuesta(int numero){

        if(numero==1){
            DataBaseJugador manager = new DataBaseJugador(this);
            ArrayList<Jugador> jugadors= new ArrayList<Jugador>();
            jugadors= manager.rescatarDatos();


            manager.modificarPuntaje(jugadors.get(juego.getTurno()).getNombre(),jugadors.get(juego.getTurno()).getPuntaje()+1);


            AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoPreguntaRespuesta.this);
            builder.setMessage("Ganaste 1 punto!!")
                    .setTitle("Atención!!")
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent nuevoform4 = new Intent(IJuegoPreguntaRespuesta.this,IRuleta.class);
                                    startActivity(nuevoform4);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
        if(numero==2){
            AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoPreguntaRespuesta.this);
            builder.setMessage("PERDISTE")
                    .setTitle("Atención!!")
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent nuevoform4 = new Intent(IJuegoPreguntaRespuesta.this,IRuleta.class);
                                    startActivity(nuevoform4);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
    public void esperar(){

        new CountDownTimer(18000,1000) {

            @Override
            public void onTick(long l) {
                mensaje_cuenta.setText("Tiempo "+(l/1000));

            }

            @Override
            public void onFinish() {
                mensaje_respuesta(2);
            }
        }.start();


    }
}