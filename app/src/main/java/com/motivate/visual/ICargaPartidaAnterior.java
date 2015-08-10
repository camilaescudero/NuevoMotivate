package com.motivate.visual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.motivate.nuevo.DataBaseJugador;
import com.motivate.nuevo.Jugador;
import com.motivate.nuevo.Partida;
import com.motivate.nuevo.R;

import java.util.ArrayList;

/**
 * Created by Cami on 23-06-2015.
 */
public class ICargaPartidaAnterior extends ActionBarActivity {

    StringBuilder mensaje = new StringBuilder();
    TextView textView;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargapartidaanterior);
        ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
        Partida p = new Partida();
        DataBaseJugador manager =new DataBaseJugador(this);
        jugadors=manager.rescatarDatos();
        System.out.println("nombre de los jugadores");
        textView = (TextView) findViewById( R.id.txt_cargarjugadores );
        for(int i=0;i<jugadors.size();i++){
            mensaje.append(jugadors.get(i).getNombre()+"\t \t \t : \t"+jugadors.get(i).getPuntaje());
            mensaje.append("\n");

            System.out.println(jugadors.get(i).getNombre());
        }
        textView.setText(mensaje);

        Button boton = (Button)findViewById(R.id.btn_cargar_juego);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoform = new Intent(ICargaPartidaAnterior.this,IRotarRuleta.class);
                startActivity(nuevoform);
            }
        });


        //p.setJugadores(manager.rescatarDatos());
    }
}
