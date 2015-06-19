package com.motivate.visual;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.motivate.nuevo.R;

/**
 * Created by Angélica on 26-05-2015.
 */


public class IJuegoNoDiga extends ActionBarActivity {

    Button comenzar;

    Button botonaceptar ;
    Button botonrechazar ;
    private TextView mensaje_cuenta;

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nodigasinodigano);


        comenzar = (Button) findViewById(R.id.btn_comenzar);
        mensaje_cuenta=(TextView) findViewById(R.id.Titulo);

        //aceptar();


        comenzar.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v) {
                esperar();
            }


        });


   }


    public void esperar(){

        new CountDownTimer(61000,1000){


            @Override
            public void onTick(long millisUntilFinished) {

                mensaje_cuenta.setText("" + (millisUntilFinished/1000))   ;
            }

            @Override
            public void onFinish() {
                mensaje_cuenta.setText("") ;

            }
        }.start();


    }

    public void aceptar(){
        botonaceptar = (Button) findViewById(R.id.btn_aceptar);
        botonaceptar.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view) {
                        Intent nuevoformA = new Intent(IJuegoNoDiga.this,IRuleta.class);
                        startActivity(nuevoformA);

                }
        });
    }
    public void rechazar(){

        botonrechazar = (Button) findViewById(R.id.btn_rechazar);
        botonrechazar.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view) {
                        Intent nuevoformR = new Intent(IJuegoNoDiga.this,IRuleta.class);
                        startActivity(nuevoformR);

                }
        });

    }

}
