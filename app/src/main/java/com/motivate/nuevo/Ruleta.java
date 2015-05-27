package com.motivate.nuevo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cami on 23-05-2015.
 */
public class Ruleta  extends ActionBarActivity  {

    private StringBuilder mensaje = new StringBuilder();
    private TextView textView;
    private ArrayList<Jugador> arregloJugadores = new ArrayList<Jugador>();
    private ArrayList<String> jugadores = new ArrayList<String>();
    private Jugador jugar = new Jugador();
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruleta);
        textView = (TextView) findViewById( R.id.txt_jugadoresRuleta );
        Intent intent = getIntent();
        Bundle bundle= intent.getExtras();
        mensaje.append(bundle.getInt("numero"));
        int numero = bundle.getInt("entraRuleta");
        textView.setText( mensaje );
        ArrayList<String> jugadores = new ArrayList<String>();
        ArrayList<Jugador> ju = new ArrayList<Jugador>();
        int j;

       jugadores=bundle.getStringArrayList("juegue");
        if(numero ==0){
            for ( int i=0; i< jugadores.size(); i++){
                j=i+1;

                jugar.setNombre(jugadores.get(i));
                jugar.setPuntaje(0);
                arregloJugadores.add(jugar);
            //    mensaje.append(" "+arregloJugadores.get(numero).getNombre());
            }
        }
        else{

          //  mensaje.append(arregloJugadores.get(numero).getNombre());
        }
        //mensaje.append("cantidad de veces que ha entrado"+ numero);
       // mensaje.append(jugadores);
        //textView.setText(mensaje);

        Button botonND = (Button)findViewById(R.id.btn_nodigasi_nodigano);
        botonND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoformND = new Intent(Ruleta.this,Juego1.class);
                startActivity(nuevoformND);
            }
        });

        Button botonCP = (Button)findViewById(R.id.btn_cantelapalabra);
        botonCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoformCP = new Intent(Ruleta.this,CanteLaPalabra.class);
                startActivity(nuevoformCP);
            }
        });


        Button botonPR = (Button)findViewById(R.id.btn_pregunta_respuesta);
        botonPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoformPR = new Intent(Ruleta.this,PreguntaRespuesta.class);
                startActivity(nuevoformPR);
            }
        });

        Button botonAQ = (Button)findViewById(R.id.btn_adivina_quien);
        botonAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoformAD = new Intent(Ruleta.this,Juego_adivinaquien.class);
                startActivity(nuevoformAD);
            }
        });

    }
}