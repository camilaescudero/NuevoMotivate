package com.motivate.nuevo;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

/**
 * Created by Angélica on 26-05-2015.
 */
public class Juego1  extends ActionBarActivity {

    Button comenzar,detener;
    Chronometer crono;
    long Time=0;

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego1);

        crono = (Chronometer) findViewById(R.id.Cronometro);
        comenzar = (Button) findViewById(R.id.btn_comenzar);
        detener = (Button) findViewById(R.id.btn_detener);

        comenzar.setEnabled(true);
        detener.setEnabled(false);

        comenzar.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v) {
                comenzar.setEnabled(false);
                detener.setEnabled(true);
                crono.setBase(SystemClock.elapsedRealtime());
                crono.start();
            }
        });

        detener.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                comenzar.setEnabled(true);
                detener.setEnabled(false);

                crono.stop();
            }

        });
    }



}
