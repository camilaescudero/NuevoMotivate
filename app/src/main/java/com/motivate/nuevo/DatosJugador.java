package com.motivate.nuevo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;


public class DatosJugador  extends ActionBarActivity {

    NumberPicker npick = null;
    TextView respuesta;
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

                Bundle bundle = new Bundle();
                respuesta.setText(String.valueOf(npick.getValue()));
                Intent nuevoform = new Intent(DatosJugador.this,Ruleta.class);

                bundle.putInt("numero",npick.getValue());
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

                bundle.putInt("numero",npick.getValue());
                nuevo.putExtras(bundle);
                startActivity(nuevo);
            }
        });



    }




}
