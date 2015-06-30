package com.motivate.visual;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.motivate.nuevo.Juego;
import com.motivate.nuevo.JuegoAhorcado;
import com.motivate.nuevo.JuegoBachillerato;
import com.motivate.nuevo.R;

/**
 * Created by María Elizabeth on 29-06-2015.
 */
public class IJuegoBachillerato extends ActionBarActivity {
    Button btn_randomletra, btn_stop, btn_bachilleratoaceptar, btn_bachilleratorechazar;
    TextView txt_muestraletra, txt_tiempo;
    EditText respuesta_nombreapellido, respuesta_animal,respuesta_frutaverdura,respuesta_paisciudad;
    JuegoBachillerato bachillerato = new JuegoBachillerato();
    CountDownTimer timer;

    String letra= bachillerato.letra;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bachillerato);

        btn_randomletra = (Button) findViewById(R.id.btn_randomletra);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_bachilleratoaceptar = (Button) findViewById(R.id.btn_bachilleratoaceptar);
        btn_bachilleratorechazar = (Button) findViewById(R.id.btn_bachilleratorechazar);
        txt_muestraletra = (TextView) findViewById(R.id.txt_muestraletra);
        txt_tiempo = (TextView)findViewById(R.id.txt_tiempo);
        respuesta_nombreapellido= (EditText) findViewById(R.id.respuesta_nombreapellido);
        respuesta_animal= (EditText) findViewById(R.id.respuesta_animal);
        respuesta_frutaverdura= (EditText) findViewById(R.id.respuesta_frutaverdura);
        respuesta_paisciudad= (EditText) findViewById(R.id.respuesta_paisciudad);

        btn_stop.setEnabled(false);
        btn_bachilleratoaceptar.setEnabled(false);
        btn_bachilleratorechazar.setEnabled(false);
        respuesta_nombreapellido.setEnabled(false);
        respuesta_animal.setEnabled(false);
        respuesta_frutaverdura.setEnabled(false);
        respuesta_paisciudad.setEnabled(false);

        btn_randomletra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_muestraletra.setText(letra);
                btn_randomletra.setEnabled(false);
                btn_stop.setEnabled(true);
                indicaciones_randomletra("Atencion!!", "A partir de ahora tendras 30 segundos para responder. Cuando rellenes todo presiona Stop para detener el tiempo.");
                respuesta_nombreapellido.setEnabled(true);
                respuesta_animal.setEnabled(true);
                respuesta_frutaverdura.setEnabled(true);
                respuesta_paisciudad.setEnabled(true);
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                btn_stop.setEnabled(false);
                btn_bachilleratoaceptar.setEnabled(true);
                btn_bachilleratorechazar.setEnabled(true);
                respuesta_nombreapellido.setEnabled(false);
                respuesta_animal.setEnabled(false);
                respuesta_frutaverdura.setEnabled(false);
                respuesta_paisciudad.setEnabled(false);
                indicaciones_stop("Atencion!!","Muestrale tus respuestas a tus amigos, ellos decidiran si las aceptan o las rechazan.");
            }
        });

        btn_bachilleratoaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar_alerta("Ganaste!!", "Regalale un copetits a la persona que quieras");
            }
        });

        btn_bachilleratorechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar_alerta("Perdiste!!", "Tus amigos creen que estay chamullando, tomate un copete.");
            }
        });

    }

    public void esperar(){

        timer = new CountDownTimer(31000,1000) {

            @Override
            public void onTick(long l) {
                txt_tiempo.setText("Tiempo "+(l/1000));

            }

            @Override
            public void onFinish() {
                mostrar_alerta("Perdiste", "El tiempo se acabo, tomate un copetitss");
            }
        }.start();

    }

    private void mostrar_alerta(String titulo,String mensaje){

        AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoBachillerato.this);
        builder.setMessage(mensaje)
                .setTitle(titulo)
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                                Intent nuevoform4 = new Intent(IJuegoBachillerato.this, IRuleta.class);
                                startActivity(nuevoform4);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void indicaciones_randomletra(String titulo,String mensaje){

        AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoBachillerato.this);
        builder.setMessage(mensaje)
                .setTitle(titulo)
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                esperar();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void indicaciones_stop(String titulo,String mensaje){

        AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoBachillerato.this);
        builder.setMessage(mensaje)
                .setTitle(titulo)
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
