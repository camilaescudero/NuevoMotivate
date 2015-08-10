package com.motivate.visual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.motivate.nuevo.DataBaseJugador;
import com.motivate.nuevo.Partida;
import com.motivate.nuevo.R;


public class IJugadorEstandar extends ActionBarActivity {
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

                DataBaseJugador manager = new DataBaseJugador(IJugadorEstandar.this);
                p.creaEstandar(npick.getValue());
                manager.insertar(p.getJugadores());

                Intent nuevoform = new Intent(IJugadorEstandar.this,IRuleta.class);
                startActivity(nuevoform);
            }
        });


        Button boton2 = (Button)findViewById(R.id.btn_editarjugadores);
        boton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent nuevo = new Intent(IJugadorEstandar.this,IJugadorPersonalizado.class);
                startActivity(nuevo);
            }
        });



    }



}
