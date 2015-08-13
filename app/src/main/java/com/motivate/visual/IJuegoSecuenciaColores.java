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
import com.motivate.nuevo.JuegoSecuenciaColores;
import com.motivate.nuevo.Jugador;
import com.motivate.nuevo.R;

import java.util.ArrayList;

/**
 * Created by Cami on 30-06-2015.
 */
public class IJuegoSecuenciaColores  extends ActionBarActivity {

    Button amarrillo, azul, rojo, verde;
    int[] secuencia = new int[5];
    DataBaseJuego dataBaseJuego = new DataBaseJuego(this);
    DataBaseJugador baseJugador = new DataBaseJugador(this);
    ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
    Juego juego = new Juego();
    TextView mensaje_cuenta;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secuenciacolores);

        TextView jugadorTurno= (TextView)findViewById(R.id.txt_turno_secuencia);

        //ASIGNA EL JUGADOR DE TURNO Y LO MUESTRA EN LA PANTALLA, ADEMAS DE MODIFICAR EN LA BASE DE DATOS EL TURNO DEL JUGADOR
        jugadors= baseJugador.rescatarDatos();
        juego.setTurno(dataBaseJuego.rescatarDatos());
        juego.setJugador(jugadors.get(juego.getTurno()));
        jugadorTurno.setText(jugadors.get(juego.getTurno()).getNombre());
        dataBaseJuego.modificarTurno(dataBaseJuego.devuelveId(),dataBaseJuego.rescatarDatos()+1,jugadors.size());

        mensaje_cuenta = (TextView)findViewById(R.id.txt_cuenta_secuencia);
        final JuegoSecuenciaColores juegoSecuenciaColores = new JuegoSecuenciaColores();
        this.secuencia= juegoSecuenciaColores.generarSecuencia();

        amarrillo = (Button)findViewById(R.id.btn_amarillo);
        azul = (Button)findViewById(R.id.btn_azul);
        rojo= (Button)findViewById(R.id.btn_rojo);
        verde = (Button)findViewById(R.id.btn_verde);

        esperar();


        amarrillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                amarrillo.setBackgroundResource(R.mipmap.amarilloon);
                esperar0();
                mensaje(juegoSecuenciaColores.compraraColores(0));
            }
        });

        azul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                azul.setBackgroundResource(R.mipmap.azulon);
                esperar1();
                mensaje(juegoSecuenciaColores.compraraColores(1));
            }
        });

        rojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rojo.setBackgroundResource(R.mipmap.rojoon);
                esperar2();
                mensaje(juegoSecuenciaColores.compraraColores(2));
            }
        });

        verde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verde.setBackgroundResource(R.mipmap.verdeon);
                esperar3();
                mensaje(juegoSecuenciaColores.compraraColores(3));
            }
        });
    }

    public void esperar(){


        new CountDownTimer(25000,1000) {

            @Override
            public void onTick(long l) {

                if(l/1000==24){
                    mensaje_cuenta.setText(" 3 ");
                }
                if(l/1000==23){
                    mensaje_cuenta.setText(" 2 ");
                }
                if(l/1000==22){
                    mensaje_cuenta.setText(" 1 ");
                }
                if(l/1000==21){
                    mensaje_cuenta.setText(" GO! ");
                }
                if(l/1000==20){
                    mensaje_cuenta.setText("  ");
                }
                if(l/1000==19){
                    muestraColores(secuencia[0]);
                }
                if(l/1000==17){
                    ocultaColores(secuencia[0]);
                }
                if(l/1000==15){
                    muestraColores(secuencia[1]);
                }
                if(l/1000==13){
                    ocultaColores(secuencia[1]);
                }
                if(l/1000==11){
                    muestraColores(secuencia[2]);
                }
                if(l/1000==9){
                    ocultaColores(secuencia[2]);
                }
                if(l/1000==7){
                    muestraColores(secuencia[3]);
                }
                if(l/1000==5){
                    ocultaColores(secuencia[3]);
                }
                if(l/1000==3){
                    muestraColores(secuencia[4]);
                }
                if(l/1000==1){
                    ocultaColores(secuencia[4]);
                }


            }

            @Override
            public void onFinish() {

            }
        }.start();


    }

    public void esperar0(){
        final int color;
        new CountDownTimer(1000,1000) {

            @Override
            public void onTick(long l) {  }

            @Override
            public void onFinish() {
                ocultaColores(0);
            }
        }.start();
    }
    public void esperar1(){
        final int color;
        new CountDownTimer(1000,1000) {

            @Override
            public void onTick(long l) {  }

            @Override
            public void onFinish() {
                ocultaColores(1);
            }
        }.start();
    }
    public void esperar2(){
        final int color;
        new CountDownTimer(1000,1000) {

            @Override
            public void onTick(long l) {  }

            @Override
            public void onFinish() {
                ocultaColores(2);
            }
        }.start();
    }
    public void esperar3(){
        final int color;
        new CountDownTimer(1000,1000) {

            @Override
            public void onTick(long l) {  }

            @Override
            public void onFinish() {
                ocultaColores(3);
            }
        }.start();
    }

    public void muestraColores(int posicion){
        //entrara la posicion del color de la secuencia
        if(posicion==0) {
            amarrillo.setBackgroundResource(R.mipmap.amarilloon);
        }
        if(posicion==1) {
            azul.setBackgroundResource(R.mipmap.azulon);
        }
        if(posicion==2) {
            rojo.setBackgroundResource(R.mipmap.rojoon);
        }
        if(posicion==3) {
            verde.setBackgroundResource(R.mipmap.verdeon);
        }

    }

    public void ocultaColores(int posicion){
        //entrara la posicion del color de la secuencia
        if(posicion==0) {
            amarrillo.setBackgroundResource(R.mipmap.amarillooff);
        }
        if(posicion==1) {
            azul.setBackgroundResource(R.mipmap.azuloff);
        }
        if(posicion==2) {
            rojo.setBackgroundResource(R.mipmap.rojooff);
        }
        if(posicion==3) {
            verde.setBackgroundResource(R.mipmap.verdeoff);
        }

    }
    public void ocultaColores2(int posicion){
        //entrara la posicion del color de la secuencia
        if(posicion==0) {

            amarrillo.setBackgroundResource(R.mipmap.amarillooff);
        }
        if(posicion==1) {
            azul.setBackgroundResource(R.mipmap.azuloff);
        }
        if(posicion==2) {
            rojo.setBackgroundResource(R.mipmap.rojooff);
        }
        if(posicion==3) {
            verde.setBackgroundResource(R.mipmap.verdeoff);
        }

    }

    public void mensaje(int resultado){

        if(resultado==2){
            baseJugador.modificarPuntaje(juego.getJugador().getNombre(), juego.getJugador().getPuntaje() + 1);
            AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoSecuenciaColores.this);
            builder.setMessage("Ganaste 1 punto")
                    .setTitle("GANA ")
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    dialog.cancel();
                                    Intent nuevoform4 = new Intent(IJuegoSecuenciaColores.this,IRuleta.class);
                                    startActivity(nuevoform4);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();

        }
        if(resultado==-2){
            AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoSecuenciaColores.this);
            builder.setMessage("Perdiste")
                    .setTitle("Perdiste ")
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //Intent nuevoform4 = new Intent(IJuegoSecuenciaColores.this,IRuleta.class);
                                    //startActivity(nuevoform4);
                                    dialog.cancel();
                                    Intent nuevoform4 = new Intent(IJuegoSecuenciaColores.this,IRuleta.class);
                                    startActivity(nuevoform4);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }

    }


}
