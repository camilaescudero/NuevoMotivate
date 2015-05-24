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
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruleta);


        textView = (TextView) findViewById( R.id.txt );
        Intent intent = getIntent();
        Bundle bundle= intent.getExtras();
        mensaje.append(bundle.getInt("numero"));
        textView.setText( mensaje );
        ArrayList<String> jugadores = new ArrayList<String>();
        ArrayList<Jugador> ju = new ArrayList<Jugador>();
        int j;
        for ( int i=0; i< bundle.getInt("numero"); i++){
            j=i+1;
            jugadores.add("jugador" + j +"\n");
        }
        mensaje.append(jugadores);
        textView.setText(mensaje);
    }

}
