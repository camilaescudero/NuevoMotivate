package com.motivate.visual;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.motivate.nuevo.DataBaseJuego;
import com.motivate.nuevo.DataBaseJugador;
import com.motivate.nuevo.Jugador;
import com.motivate.nuevo.R;

import java.util.ArrayList;

/**
 * Created by Cami on 08-06-2015.
 */
public class IRotarRuleta extends ActionBarActivity {
    DataBaseJuego dataBaseJuego =new DataBaseJuego(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intento);

        ImageView imagen = (ImageView)findViewById(R.id.imagenRuleta);
        Button boton= (Button)findViewById(R.id.btn_girar);;
       // dataBaseJuego.insertar(1);
        ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
        DataBaseJugador manager =new DataBaseJugador(this);
        jugadors=manager.rescatarDatos();
        //dataBaseJuego.modificarTurno(5,7);
        int id=dataBaseJuego.rescatarDatos();
        dataBaseJuego.eliminar(id);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseJuego.insertar(0);
                esperar();
                ImageView imagen = (ImageView)findViewById(R.id.imagenRuleta);
                Animation rota;
                rota = AnimationUtils.loadAnimation(IRotarRuleta.this, R.anim.rotacion);
                rota.reset();
                imagen.startAnimation(rota);
            }
        });

    }

    public void esperar(){

        new CountDownTimer(7000,1000) {

            @Override
            public void onTick(long l) {


            }

            @Override
            public void onFinish() {
                int random= (int)(Math.random()*5);
                switch (random){
                    case 0:
                        Intent nuevoformND = new Intent(IRotarRuleta.this,IJuegoNoDiga.class);
                        startActivity(nuevoformND);
                        break;

                    case 1:
                        Intent nuevoformCP = new Intent(IRotarRuleta.this,IJuegoCanteLaPalabra.class);
                        startActivity(nuevoformCP);
                        break;

                    case 2:
                        Intent nuevoformPR = new Intent(IRotarRuleta.this, IJuegoPreguntaRespuesta.class);
                        startActivity(nuevoformPR);
                        break;

                    case 3:
                        Intent nuevoformAD = new Intent(IRotarRuleta.this,IJuegoAdivinaQuien.class);
                        startActivity(nuevoformAD);
                        break;

                    case 4:
                        Intent nuevoformG = new Intent(IRotarRuleta.this,IJuegoGato.class);
                        startActivity(nuevoformG);
                        break;

                    case 5:
                        Intent nuevoformA = new Intent(IRotarRuleta.this,IJuegoAhorcado.class);
                        startActivity(nuevoformA);
                        break;


                }

            }
        }.start();


    }
}
