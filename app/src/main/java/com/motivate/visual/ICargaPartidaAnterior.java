package com.motivate.visual;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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
        textView = (TextView) findViewById( R.id.textViewcarga );
        for(int i=0;i<jugadors.size();i++){
            mensaje.append(jugadors.get(i).getNombre());
            mensaje.append("\n");

            System.out.println(jugadors.get(i).getNombre());
        }
        textView.setText(mensaje);

        //p.setJugadores(manager.rescatarDatos());
    }
}
