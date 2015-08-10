package com.motivate.visual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.motivate.nuevo.DataBaseJuego;
import com.motivate.nuevo.DataBaseJugador;
import com.motivate.nuevo.Jugador;
import com.motivate.nuevo.R;

import java.util.ArrayList;



/**
 * Created by Cami on 23-05-2015.
 */
public class IRuleta extends ActionBarActivity  {

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
        int j, turno;

        DataBaseJugador manager = new DataBaseJugador(this);
        juega= manager.rescatarDatos();
        DataBaseJuego dataBaseJuego = new DataBaseJuego(this);
        turno= dataBaseJuego.rescatarDatos();
        int i;
        mensaje.append("hola\n");

        mensaje.append("\nturno : "+turno+"\n");
         for (i=0; i < juega.size();i++){

            mensaje.append("\n"+juega.get(i).getNombre());

        }

        mostrar.setText(mensaje);
        Button boton_ND = (Button)findViewById(R.id.btn_nodigasi_nodigano);
        boton_ND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoformND = new Intent(IRuleta.this,IJuegoNoDiga.class);
                startActivity(nuevoformND);
            }
        });

        Button boton_CP = (Button)findViewById(R.id.btn_cantelapalabra);
        boton_CP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoformCP = new Intent(IRuleta.this,IJuegoCanteLaPalabra.class);
                startActivity(nuevoformCP);
            }
        });


        Button boton_PR = (Button)findViewById(R.id.btn_pregunta_respuesta);
        boton_PR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoformPR = new Intent(IRuleta.this, IJuegoPreguntaRespuesta.class);
                startActivity(nuevoformPR);
            }
        });

        Button boton_AQ = (Button)findViewById(R.id.btn_adivina_quien);
        boton_AQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoformAD = new Intent(IRuleta.this,IJuegoAdivinaQuien.class);
                startActivity(nuevoformAD);
            }
        });


        Button boton_Gato = (Button)findViewById(R.id.btn_gato);
        boton_Gato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoformAD = new Intent(IRuleta.this,IJuegoGato.class);
                startActivity(nuevoformAD);
            }
        });

        Button boton_Ahorcado = (Button)findViewById(R.id.btn_ahorcado);
        boton_Ahorcado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoformAD = new Intent(IRuleta.this,IJuegoAhorcado.class);
                startActivity(nuevoformAD);
            }
        });

    }
}