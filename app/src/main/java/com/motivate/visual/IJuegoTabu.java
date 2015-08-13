package com.motivate.visual;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.motivate.nuevo.DataBaseJuego;
import com.motivate.nuevo.DataBaseJugador;
import com.motivate.nuevo.Juego;
import com.motivate.nuevo.JuegoTabu;
import com.motivate.nuevo.Jugador;
import com.motivate.nuevo.R;

/**
 * Created by Guillermo on 30-06-2015.
 */
public class IJuegoTabu extends ActionBarActivity {
    Button boton_comenzar;
    Button boton_correcto;
    Button boton_incorrecto;
    TextView txt_muestratimer;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView palabra_secreta;
    JuegoTabu tabu = new JuegoTabu();

    DataBaseJuego dataBaseJuego = new DataBaseJuego(this);
    DataBaseJugador baseJugador = new DataBaseJugador(this);
    ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
    Juego juego = new Juego();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabu);

        TextView jugadorTurno= (TextView)findViewById(R.id.txt_turno_tabu);

        //ASIGNA EL JUGADOR DE TURNO Y LO MUESTRA EN LA PANTALLA, ADEMAS DE MODIFICAR EN LA BASE DE DATOS EL TURNO DEL JUGADOR
        jugadors= baseJugador.rescatarDatos();
        juego.setTurno(dataBaseJuego.rescatarDatos());
        juego.setJugador(jugadors.get(juego.getTurno()));
        jugadorTurno.setText(jugadors.get(juego.getTurno()).getNombre());
        dataBaseJuego.modificarTurno(dataBaseJuego.devuelveId(),dataBaseJuego.rescatarDatos()+1,jugadors.size());


        tv1 = (TextView) findViewById(R.id.txt_no_decir_1);
        tv2 = (TextView) findViewById(R.id.txt_no_decir_2);
        tv3 = (TextView) findViewById(R.id.txt_no_decir_3);
        tv4 = (TextView) findViewById(R.id.txt_no_decir_4);
        tv5 = (TextView) findViewById(R.id.txt_no_decir_5);
        palabra_secreta = (TextView) findViewById(R.id.txt_palabra_secreta);
        txt_muestratimer = (TextView) findViewById(R.id.txt_timer);

        boton_correcto = (Button) findViewById(R.id.btn_correcto);
        boton_incorrecto = (Button) findViewById(R.id.btn_incorrecto);

        try {
            boton_comenzar = (Button) findViewById(R.id.btn_comenzar);
            InputStream is = getAssets().open("valores_tabu");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            Element element = doc.getDocumentElement();
            element.normalize();

            NodeList nList = doc.getElementsByTagName("palabras");
            int aux = tabu.generar_aleatorio(nList);
            Node node = nList.item(aux);
            Element element2 = (Element) node;
            establecer_palabra(boton_comenzar, element2, palabra_secreta, tv1, tv2, tv3, tv4, tv5, txt_muestratimer);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }






    private void establecer_palabra(Button boton_comenzar,final Element  element,final TextView palabra_secreta,final TextView tv1,final TextView tv2,final TextView tv3,final TextView tv4,final TextView tv5,final TextView txt_muestratimer) {
        boton_comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                palabra_secreta.setText(tabu.getValue("palabra", element));
                tv1.setText(tabu.getValue("res1", element));
                tv2.setText(tabu.getValue("res2", element));
                tv3.setText(tabu.getValue("res3", element));
                tv4.setText(tabu.getValue("res4", element));
                tv5.setText(tabu.getValue("res5", element));
                esperar(txt_muestratimer);
            }
        });
    }


    public void esperar(final TextView txt_muestratimer){
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txt_muestratimer.setText("Tiempo: " + (millisUntilFinished/1000));
            }
            @Override
            public void onFinish() {
                AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoTabu.this);
                builder.setMessage("Perdiste!")
                        .setTitle("Mensaje")
                        .setCancelable(false)
                        .setNeutralButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        Intent nuevoform4 = new Intent(IJuegoTabu.this, IRuleta.class);
                                        startActivity(nuevoform4);
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        }.start();


        boton_correcto = (Button) findViewById(R.id.btn_correcto);
        boton_correcto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseJugador.modificarPuntaje(juego.getJugador().getNombre(), juego.getJugador().getPuntaje() + 1);
                AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoTabu.this);
                builder.setMessage("Ganaste 1 punto")
                        .setTitle("Mensaje")
                        .setCancelable(false)
                        .setNeutralButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        Intent nuevoform4 = new Intent(IJuegoTabu.this, IRuleta.class);
                                        startActivity(nuevoform4);
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


        boton_incorrecto = (Button) findViewById(R.id.btn_incorrecto);
        boton_incorrecto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoTabu.this);
                builder.setMessage("Perdiste!")
                        .setTitle("Mensaje")
                        .setCancelable(false)
                        .setNeutralButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        Intent nuevoform4 = new Intent(IJuegoTabu.this, IRuleta.class);
                                        startActivity(nuevoform4);
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });
    }

}