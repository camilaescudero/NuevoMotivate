package com.motivate.visual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.motivate.nuevo.Jugador;
import com.motivate.nuevo.Partida;
import com.motivate.nuevo.R;

import java.util.ArrayList;



/**
 * Created by Cami on 23-05-2015.
 */
public class Ruleta  extends ActionBarActivity  {

    StringBuilder mensaje = new StringBuilder();
    TextView textView;



    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruleta);
        TextView mostrar;
        mostrar = (TextView)findViewById(R.id.txt_muestrajugadoresRuleta);
        textView = (TextView) findViewById( R.id.lbl_muestra );

        ArrayList<String> jugadores = new ArrayList<String>();
        ArrayList<Jugador> juega = new ArrayList<Jugador>();
        Jugador jugador = new Jugador();
        int j;

        Partida p = new Partida();
        int i;
        mensaje.append("hola");
        juega= p.getJugadores();
        mensaje.append(juega.size());
         for (i=0; i < juega.size();i++){

            mensaje.append( p.getJugadores().get(i).getNombre());

        }

        mostrar.setText(mensaje);
        Button boton_ND = (Button)findViewById(R.id.btn_nodigasi_nodigano);
        boton_ND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoformND = new Intent(Ruleta.this,IJuegoNoDiga.class);
                startActivity(nuevoformND);
            }
        });

        Button boton_CP = (Button)findViewById(R.id.btn_cantelapalabra);
        boton_CP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoformCP = new Intent(Ruleta.this,IJuegoCanteLaPalabra.class);
                startActivity(nuevoformCP);
            }
        });


        Button boton_PR = (Button)findViewById(R.id.btn_pregunta_respuesta);
        boton_PR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoformPR = new Intent(Ruleta.this, IJuegoPreguntaRespuesta.class);
                startActivity(nuevoformPR);
            }
        });

        Button boton_AQ = (Button)findViewById(R.id.btn_adivina_quien);
        boton_AQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoformAD = new Intent(Ruleta.this,IJuegoAdivinaQuien.class);
                startActivity(nuevoformAD);
            }
        });


        Button boton_Gato = (Button)findViewById(R.id.btn_gato);
        boton_Gato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoformAD = new Intent(Ruleta.this,IJuegoGato.class);
                startActivity(nuevoformAD);
            }
        });

    }
}