package com.motivate.visual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.motivate.nuevo.Jugador;
import com.motivate.nuevo.Partida;
import com.motivate.nuevo.R;

import java.util.ArrayList;


public class JugadorEstandar extends ActionBarActivity {
    NumberPicker npick = null;
    TextView respuesta;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_datosjugador);


        npick=(NumberPicker)findViewById(R.id.npick_cantidadjugadores);
        npick.setMaxValue(40);
        npick.setMinValue(1);
        npick.setWrapSelectorWheel(false);

        respuesta=(TextView)findViewById(R.id.txt_respuesta);
        Button boton = (Button)findViewById(R.id.btn_iniciarpartida);
        boton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int j;
                Partida p = new Partida();

                respuesta.setText(String.valueOf(npick.getValue()));
                ArrayList<Jugador> jue = new ArrayList<Jugador>();

                for ( int i=0; i< npick.getValue(); i++){
                    j=i+1;
                    Jugador jug = new Jugador();
                    jug.setNombre("jugador "+j);
                    jug.setPuntaje(0);
                    jue.add(jug);


                }
                p.setJugadores(jue);

                Intent nuevoform = new Intent(JugadorEstandar.this,Ruleta.class);
                startActivity(nuevoform);
            }
        });


        Button boton2 = (Button)findViewById(R.id.btn_editarjugadores);
        boton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent nuevo = new Intent(JugadorEstandar.this,JugadorPersonalizado.class);
                startActivity(nuevo);
            }
        });



    }



}
