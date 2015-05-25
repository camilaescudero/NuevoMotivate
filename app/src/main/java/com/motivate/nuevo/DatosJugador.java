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
    private ArrayList<Jugador> ju = new ArrayList<Jugador>();
    private ArrayList<String> jugadores = new ArrayList<String>();
    Jugador jugar=new Jugador();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_datosjugador);

        npick=(NumberPicker)findViewById(R.id.npick_cantidadjugadores);
        npick.setMaxValue(50);
        npick.setMinValue(0);
        npick.setWrapSelectorWheel(false);

        respuesta=(TextView)findViewById(R.id.txt_respuesta);
        Button boton = (Button)findViewById(R.id.btn_iniciarpartida);
        boton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int j;
                Bundle bundle = new Bundle();
                respuesta.setText(String.valueOf(npick.getValue()));
                for ( int i=0; i< npick.getValue(); i++){
                    j=i+1;
                    //asigna nombres predeterminados, jugador1, jugador2, etc..
                    jugadores.add("jugador" + j +"\n");

                }
                //mando el Arraylist con los nombres a la Ruleta
                Intent nuevoform = new Intent(DatosJugador.this,Ruleta.class);
                bundle.putInt("numero",npick.getValue());
                bundle.putStringArrayList("juegue",jugadores);
                bundle.putInt("entraRuleta",0);
                nuevoform.putExtras(bundle);
                startActivity(nuevoform);
            }
        });


        Button boton2 = (Button)findViewById(R.id.btn_editarjugadores);
        boton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                Intent nuevo = new Intent(DatosJugador.this,EditarJugador.class);
                //manda solo el nombre de los jugadores a Ruleta
                bundle.putInt("numero",npick.getValue());
                nuevo.putExtras(bundle);
                startActivity(nuevo);
            }
        });



    }


    public ArrayList<Jugador> getJu() {
        return ju;
    }

    public void setJu(ArrayList<Jugador> ju) {
        this.ju = ju;
    }
}
