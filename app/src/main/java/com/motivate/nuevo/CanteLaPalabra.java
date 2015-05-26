package com.motivate.nuevo;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CanteLaPalabra extends ActionBarActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantelapalabra);

        final TextView textOne= (TextView) findViewById(R.id.txt_MuestraPalabraCancion);
        Button pushMe = (Button) findViewById(R.id.bt_MuestraPalabraCancion);
        final String[] palabraCancion = {"Amor","Adios","Sol","Lluvia","Hombre","Mujer"};

        final int rando = (int) (Math.random()*6);


        pushMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOne.setText(palabraCancion[rando]);
            }
        });
    }
}
