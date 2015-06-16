package com.motivate.nuevo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;


public class DatosJugador  extends ActionBarActivity {

    NumberPicker npick = null;
    TextView respuesta;


    Jugador jugar=new Jugador();
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
                Jugador jue = new Jugador();
                respuesta.setText(String.valueOf(npick.getValue()));
                ArrayList<Jugador> ju = new ArrayList<Jugador>();
                for ( int i=0; i< npick.getValue(); i++){
                    j=i+1;
                    //asigna nombres predeterminados, jugador1, jugador2, etc..
                    //jugadores.add("jugador" + j +"\n");
                    jue.setNombre("jugador "+j);
                    jue.setPuntaje(0);
                    ju.add(jue);
                    p.setJugadores(ju);


                }

                Intent nuevoform = new Intent(DatosJugador.this,Ruleta.class);

                startActivity(nuevoform);
            }
        });


        Button boton2 = (Button)findViewById(R.id.btn_editarjugadores);
        boton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                Intent nuevo = new Intent(DatosJugador.this,EditarJugador.class);

                //bundle.putInt("numero",npick.getValue());
                nuevo.putExtras(bundle);
                startActivity(nuevo);
            }
        });



    }



}
