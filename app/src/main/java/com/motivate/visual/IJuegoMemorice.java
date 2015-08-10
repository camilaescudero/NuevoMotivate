package com.motivate.visual;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.motivate.nuevo.JuegoMemorice;
import com.motivate.nuevo.R;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * Created by Guillermo on 06-07-2015.
 */
public class IJuegoMemorice extends ActionBarActivity {
    private ImageButton boton_cas11, boton_cas12, boton_cas13, boton_cas14;
    private ImageButton boton_cas21, boton_cas22, boton_cas23, boton_cas24;
    private ImageButton boton_cas31, boton_cas32, boton_cas33, boton_cas34;
    private Button boton_empezar;
    private TextView txt_muestratimer;
    JuegoMemorice memorice = new JuegoMemorice();
    //arraylist para reconocer los botones qe han sido apretados y poder comparar
    private ArrayList<ImageButton> apretado = new ArrayList<ImageButton>();
    //arraylist para saber si gano el juego
    private ArrayList<ImageButton> terminado = new ArrayList<>();
    //recordar cambiar metodos a juegoMemorice cosa de usar get, set y seguir siendo global



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorice);
        //array con los valores del xml valores

        Resources res = getResources();
        final String[] valoresxml = res.getStringArray(R.array.rangers);
        final String[] imagenesxml = memorice.mezclar(valoresxml);


        boton_cas11 = (ImageButton) findViewById(R.id.btn_cas11);
        boton_cas12 = (ImageButton) findViewById(R.id.btn_cas12);
        boton_cas13 = (ImageButton) findViewById(R.id.btn_cas13);
        boton_cas14 = (ImageButton) findViewById(R.id.btn_cas14);
        boton_cas21 = (ImageButton) findViewById(R.id.btn_cas21);
        boton_cas22 = (ImageButton) findViewById(R.id.btn_cas22);
        boton_cas23 = (ImageButton) findViewById(R.id.btn_cas23);
        boton_cas24 = (ImageButton) findViewById(R.id.btn_cas24);
        boton_cas31 = (ImageButton) findViewById(R.id.btn_cas31);
        boton_cas32 = (ImageButton) findViewById(R.id.btn_cas32);
        boton_cas33 = (ImageButton) findViewById(R.id.btn_cas33);
        boton_cas34 = (ImageButton) findViewById(R.id.btn_cas34);
        boton_empezar = (Button) findViewById(R.id.btn_terminar);
        txt_muestratimer = (TextView) findViewById(R.id.txt_timer);

        cambiarEstadoBotones(false);

        boton_cas11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (memorice.getTurno() < 2) {
                    establecerValor2(boton_cas11, imagenesxml[0]);
                    if (memorice.getTurno() == 0) {
                        //ingresar primer boton apretado al arraylist
                        apretado.add(0, boton_cas11);
                    } else {
                        //ingresar segundo boton apretado al arraylist
                        apretado.add(1, boton_cas11);
                    }
                    memorice.setTurno(memorice.getTurno() + 1);
                } else if (memorice.getTurno() == 2) {
                    //verificar si los botones contienen la misma imagen
                    if (!verficarIguales(imagenesxml)) {
                        darVuelta();
                    }
                    memorice.setTurno(1);
                    establecerValor2(boton_cas11, imagenesxml[0]);
                    //agregar primer boton apretado al arraylist
                    apretado.add(0, boton_cas11);
                }
            }
        });

        boton_cas12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (memorice.getTurno() < 2) {
                    establecerValor2(boton_cas12, imagenesxml[1]);
                    if (memorice.getTurno() == 0) {
                        //ingresar primer boton apretado al arraylist
                        apretado.add(0, boton_cas12);
                    } else {
                        //ingresar segundo boton apretado al arraylist
                        apretado.add(1, boton_cas12);
                    }
                    memorice.setTurno(memorice.getTurno() + 1);
                } else if (memorice.getTurno() == 2) {
                    //verificar si los botones contienen la misma imagen
                    if (verficarIguales(imagenesxml) == false) {
                        darVuelta();
                    }
                    memorice.setTurno(1);
                    establecerValor2(boton_cas12, imagenesxml[1]);
                    //agregar primer boton apretado al arraylist
                    apretado.add(0, boton_cas12);
                }
            }
        });

        boton_cas13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (memorice.getTurno() < 2) {
                    establecerValor2(boton_cas13, imagenesxml[2]);
                    if (memorice.getTurno() == 0) {
                        //ingresar primer boton apretado al arraylist
                        apretado.add(0, boton_cas13);
                    } else {
                        //ingresar segundo boton apr etado al arraylist
                        apretado.add(1, boton_cas13);
                    }
                    memorice.setTurno(memorice.getTurno() + 1);
                } else if (memorice.getTurno() == 2) {
                    //verificar si los botones contienen la misma imagen
                    if (verficarIguales(imagenesxml) == false) {
                        darVuelta();
                    }
                    establecerValor2(boton_cas13, imagenesxml[2]);
                    //agregar primer boton apretado al arraylist
                    apretado.add(0, boton_cas13);
                    memorice.setTurno(1);
                }
            }
        });

        boton_cas14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (memorice.getTurno() < 2) {
                    establecerValor2(boton_cas14, imagenesxml[3]);
                    if (memorice.getTurno() == 0) {
                        //ingresar primer boton apretado al arraylist
                        apretado.add(0, boton_cas14);
                    } else {
                        //ingresar segundo boton apretado al arraylist
                        apretado.add(1, boton_cas14);
                    }
                    memorice.setTurno(memorice.getTurno() + 1);
                } else if (memorice.getTurno() == 2) {
                    //verificar si los botones contienen la misma imagen
                    if (verficarIguales(imagenesxml) == false) {
                        darVuelta();
                    }
                    establecerValor2(boton_cas14, imagenesxml[3]);
                    //agregar primer boton apretado al arraylist
                    apretado.add(0, boton_cas14);
                    memorice.setTurno(1);
                }
            }
        });

        boton_cas21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (memorice.getTurno() < 2) {
                    establecerValor2(boton_cas21, imagenesxml[4]);
                    if (memorice.getTurno() == 0) {
                        //ingresar primer boton apretado al arraylist
                        apretado.add(0, boton_cas21);
                    } else {
                        //ingresar segundo boton apretado al arraylist
                        apretado.add(1, boton_cas21);
                    }
                    memorice.setTurno(memorice.getTurno() + 1);
                } else if (memorice.getTurno() == 2) {
                    //verificar si los botones contienen la misma imagen
                    if (verficarIguales(imagenesxml) == false) {
                        darVuelta();
                    }
                    establecerValor2(boton_cas21, imagenesxml[4]);
                    //agregar primer boton apretado al arraylist
                    apretado.add(0, boton_cas21);
                    memorice.setTurno(1);
                }
            }
        });

        boton_cas22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (memorice.getTurno() < 2) {
                    establecerValor2(boton_cas22, imagenesxml[5]);
                    if (memorice.getTurno() == 0) {
                        //ingresar primer boton apretado al arraylist
                        apretado.add(0, boton_cas22);
                    } else {
                        //ingresar segundo boton apretado al arraylist
                        apretado.add(1, boton_cas22);
                    }
                    memorice.setTurno(memorice.getTurno() + 1);
                } else if (memorice.getTurno() == 2) {
                    //verificar si los botones contienen la misma imagen
                    if (verficarIguales(imagenesxml) == false) {
                        darVuelta();
                    }
                    memorice.setTurno(1);
                    establecerValor2(boton_cas22, imagenesxml[5]);
                    //agregar primer boton apretado al arraylist
                    apretado.add(0, boton_cas22);
                }
            }
        });

        boton_cas23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (memorice.getTurno() < 2) {
                    establecerValor2(boton_cas23, imagenesxml[6]);
                    if (memorice.getTurno() == 0) {
                        //ingresar primer boton apretado al arraylist
                        apretado.add(0, boton_cas23);
                    } else {
                        //ingresar segundo boton apretado al arraylist
                        apretado.add(1, boton_cas23);
                    }
                    memorice.setTurno(memorice.getTurno() + 1);
                } else if (memorice.getTurno() == 2) {
                    //verificar si los botones contienen la misma imagen
                    if (verficarIguales(imagenesxml) == false) {
                        darVuelta();
                    }
                    memorice.setTurno(1);
                    establecerValor2(boton_cas23, imagenesxml[6]);
                    //agregar primer boton apretado al arraylist
                    apretado.add(0, boton_cas23);
                }
            }
        });

        boton_cas24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (memorice.getTurno() < 2) {
                    establecerValor2(boton_cas24, imagenesxml[7]);
                    if (memorice.getTurno() == 0) {
                        //ingresar primer boton apretado al arraylist
                        apretado.add(0, boton_cas24);
                    } else {
                        //ingresar segundo boton apretado al arraylist
                        apretado.add(1, boton_cas24);
                    }
                    memorice.setTurno(memorice.getTurno() + 1);
                } else if (memorice.getTurno() == 2) {
                    //verificar si los botones contienen la misma imagen
                    if (verficarIguales(imagenesxml) == false) {
                        darVuelta();
                    }
                    memorice.setTurno(1);
                    establecerValor2(boton_cas24, imagenesxml[7]);
                    //agregar primer boton apretado al arraylist
                    apretado.add(0, boton_cas24);
                }
            }
        });

        boton_cas31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (memorice.getTurno() < 2) {
                    establecerValor2(boton_cas31, imagenesxml[8]);
                    if (memorice.getTurno() == 0) {
                        //ingresar primer boton apretado al arraylist
                        apretado.add(0, boton_cas31);
                    } else {
                        //ingresar segundo boton apretado al arraylist
                        apretado.add(1, boton_cas31);
                    }
                    memorice.setTurno(memorice.getTurno() + 1);
                } else if (memorice.getTurno() == 2) {
                    //verificar si los botones contienen la misma imagen
                    if (verficarIguales(imagenesxml) == false) {
                        darVuelta();
                    }
                    memorice.setTurno(1);
                    establecerValor2(boton_cas31, imagenesxml[8]);
                    //agregar primer boton apretado al arraylist
                    apretado.add(0, boton_cas31);
                }
            }
        });

        boton_cas32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (memorice.getTurno() < 2) {
                    establecerValor2(boton_cas32, imagenesxml[9]);
                    if (memorice.getTurno() == 0) {
                        //ingresar primer boton apretado al arraylist
                        apretado.add(0, boton_cas32);
                    } else {
                        //ingresar segundo boton apretado al arraylist
                        apretado.add(1, boton_cas32);
                    }
                    memorice.setTurno(memorice.getTurno() + 1);
                } else if (memorice.getTurno() == 2) {
                    //verificar si los botones contienen la misma imagen
                    if (verficarIguales(imagenesxml) == false) {
                        darVuelta();
                    }
                    memorice.setTurno(1);
                    establecerValor2(boton_cas32, imagenesxml[9]);
                    //agregar primer boton apretado al arraylist
                    apretado.add(0, boton_cas32);
                }
            }
        });

        boton_cas33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (memorice.getTurno() < 2) {
                    establecerValor2(boton_cas33, imagenesxml[10]);
                    if (memorice.getTurno() == 0) {
                        //ingresar primer boton apretado al arraylist
                        apretado.add(0, boton_cas33);
                    } else {
                        //ingresar segundo botonapretado al arraylist
                        apretado.add(1, boton_cas33);
                    }
                    memorice.setTurno(memorice.getTurno() + 1);
                } else if (memorice.getTurno() == 2) {
                    //verificar si los botones contienen la misma imagen
                    if (verficarIguales(imagenesxml) == false) {
                        darVuelta();
                    }
                    memorice.setTurno(1);
                    establecerValor2(boton_cas33, imagenesxml[10]);
                    //agregar primer boton apretdo al arraylist
                    apretado.add(0, boton_cas33);
                }
            }
        });

        //agregar wea pa eliminar lo que hay en arraylist en dar vuelta

        boton_cas34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //revisa que el boton ya fue apretado
                // entra si todavia no ha obtenido los 2 botones
                if (memorice.getTurno() < 2) {
                    //muestra la imagen del boton
                    establecerValor2(boton_cas34, imagenesxml[11]);
                    //para saber si ya existe un boton apretado
                    if (memorice.getTurno() == 0) {
                        //ingresar primer boton apretado al arraylist
                        apretado.add(0, boton_cas34);
                    } else {
                        //ingresar segundo boton apretado al arraylist
                        apretado.add(1, boton_cas34);
                    }
                    memorice.setTurno(memorice.getTurno() + 1);
                } else if (memorice.getTurno() == 2) {
                    //verificar si los botones contienen la misma imagen
                    if (verficarIguales(imagenesxml) == false) {
                        darVuelta();
                    }
                    //Para mostrar imagen del primer boton apretado despues de berificar anteriores
                    memorice.setTurno(1);
                    establecerValor2(boton_cas34, imagenesxml[11]);
                    //agregar primer boton apretado al arraylist
                    apretado.add(0, boton_cas34);
                }
            }
        });

        boton_empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int aux = memorice.getTerminar();
                if(aux == 0){
                    esperar();
                    cambiarEstadoBotones(true);
                    boton_empezar.setText("Terminar");
                    memorice.setTerminar(memorice.getTerminar() + 1);
                }else{
                    verficarIguales(imagenesxml);
                    int op = verificarGanar();
                    if (op == 1){
                        //gano
                        AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoMemorice.this);
                        builder.setMessage("Ganaste 10 puntos!")
                                .setTitle("Mensaje")
                                .setCancelable(false)
                                .setNeutralButton("Aceptar",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                                Intent nuevoform4 = new Intent(IJuegoMemorice.this, IRuleta.class);
                                                startActivity(nuevoform4);
                                            }
                                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }else{
                        //perdio
                        AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoMemorice.this);
                        builder.setMessage("Perdiste!")
                                .setTitle("Mensaje")
                                .setCancelable(false)
                                .setNeutralButton("Aceptar",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                                Intent nuevoform4 = new Intent(IJuegoMemorice.this, IRuleta.class);
                                                startActivity(nuevoform4);
                                            }
                                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                }

            }
        });


    }

    public int verificarGanar(){
        if(terminado.size() == 12){
            return 1;
        }
        return 0;
    }

    public void cambiarEstadoBotones(boolean estado){
        boton_cas11.setEnabled(estado);
        boton_cas12.setEnabled(estado);
        boton_cas13.setEnabled(estado);
        boton_cas14.setEnabled(estado);
        boton_cas21.setEnabled(estado);
        boton_cas22.setEnabled(estado);
        boton_cas23.setEnabled(estado);
        boton_cas24.setEnabled(estado);
        boton_cas31.setEnabled(estado);
        boton_cas32.setEnabled(estado);
        boton_cas33.setEnabled(estado);
        boton_cas34.setEnabled(estado);
    }






    public boolean verficarIguales(String[] imagenesxml){
        String primero = buscarApretado(apretado.get(0), imagenesxml);
        String segundo = buscarApretado(apretado.get(1), imagenesxml);
        if(primero.equals(segundo)){
            if (apretado.get(0).getId() == boton_cas11.getId() || apretado.get(1).getId() == boton_cas11.getId()){
                boton_cas11.setEnabled(false);
                terminado.add(boton_cas11);
            }
            if (apretado.get(0).getId() == boton_cas12.getId() || apretado.get(1).getId() == boton_cas12.getId()){
                boton_cas12.setEnabled(false);
                terminado.add(boton_cas12);
            }
            if (apretado.get(0).getId() == boton_cas13.getId() || apretado.get(1).getId() == boton_cas13.getId()){
                boton_cas13.setEnabled(false);
                terminado.add(boton_cas13);
            }
            if (apretado.get(0).getId() == boton_cas14.getId() || apretado.get(1).getId() == boton_cas14.getId()){
                boton_cas14.setEnabled(false);
                terminado.add(boton_cas14);
            }
            if (apretado.get(0).getId() == boton_cas21.getId() || apretado.get(1).getId() == boton_cas21.getId()){
                boton_cas21.setEnabled(false);
                terminado.add(boton_cas21);
            }
            if (apretado.get(0).getId() == boton_cas22.getId() || apretado.get(1).getId() == boton_cas22.getId()){
                boton_cas22.setEnabled(false);
                terminado.add(boton_cas22);
            }
            if (apretado.get(0).getId() == boton_cas23.getId() || apretado.get(1).getId() == boton_cas23.getId()){
                boton_cas23.setEnabled(false);
                terminado.add(boton_cas23);
            }
            if (apretado.get(0).getId() == boton_cas24.getId() || apretado.get(1).getId() == boton_cas24.getId()){
                boton_cas24.setEnabled(false);
                terminado.add(boton_cas24);
            }
            if (apretado.get(0).getId() == boton_cas31.getId() || apretado.get(1).getId() == boton_cas31.getId()){
                boton_cas31.setEnabled(false);
                terminado.add(boton_cas31);
            }
            if (apretado.get(0).getId() == boton_cas32.getId() || apretado.get(1).getId() == boton_cas32.getId()){
                boton_cas32.setEnabled(false);
                terminado.add(boton_cas32);
            }
            if (apretado.get(0).getId() == boton_cas33.getId() || apretado.get(1).getId() == boton_cas33.getId()){
                boton_cas33.setEnabled(false);
                terminado.add(boton_cas33);
            }
            if (apretado.get(0).getId() == boton_cas34.getId() || apretado.get(1).getId() == boton_cas34.getId()){
                boton_cas34.setEnabled(false);
                terminado.add(boton_cas34);
            }
            return true;
        }
        return false;
    }

    public String buscarApretado(ImageButton boton, String[] imagenesxml){
        if(boton.getId() == boton_cas11.getId()){
            return imagenesxml[0];
        }else if(boton.getId() == boton_cas12.getId()){
            return imagenesxml[1];
        }else if(boton.getId() == boton_cas13.getId()){
            return imagenesxml[2];
        }else if(boton.getId() == boton_cas14.getId()){
            return imagenesxml[3];
        }else if(boton.getId() == boton_cas21.getId()){
            return imagenesxml[4];
        }else if(boton.getId() == boton_cas22.getId()){
            return imagenesxml[5];
        }else if(boton.getId() == boton_cas23.getId()){
            return imagenesxml[6];
        }else if(boton.getId() == boton_cas24.getId()){
            return imagenesxml[7];
        }else if(boton.getId() == boton_cas31.getId()){
            return imagenesxml[8];
        }else if(boton.getId() == boton_cas32.getId()){
            return imagenesxml[9];
        }else if(boton.getId() == boton_cas33.getId()){
            return imagenesxml[10];
        }else if(boton.getId() == boton_cas34.getId()){
            return imagenesxml[11];
        }
        return null;
    }


    public void darVuelta() {
        String cas = "casilla";

        if(apretado.get(0).getId() == boton_cas11.getId() || apretado.get(1).getId() == boton_cas11.getId()){
            establecerValor2(boton_cas11,cas);
        }
        if(apretado.get(0).getId() == boton_cas12.getId() || apretado.get(1).getId() == boton_cas12.getId()){
            establecerValor2(boton_cas12,cas);
        }
        if(apretado.get(0).getId() == boton_cas13.getId() || apretado.get(1).getId() == boton_cas13.getId()){
            establecerValor2(boton_cas13,cas);
        }
        if(apretado.get(0).getId() == boton_cas14.getId() || apretado.get(1).getId() == boton_cas14.getId()){
            establecerValor2(boton_cas14,cas);
        }
        if(apretado.get(0).getId() == boton_cas21.getId() || apretado.get(1).getId() == boton_cas21.getId()){
            establecerValor2(boton_cas21,cas);
        }
        if(apretado.get(0).getId() == boton_cas22.getId() || apretado.get(1).getId() == boton_cas22.getId()){
            establecerValor2(boton_cas22,cas);
        }
        if(apretado.get(0).getId() == boton_cas23.getId() || apretado.get(1).getId() == boton_cas23.getId()){
            establecerValor2(boton_cas23,cas);
        }
        if(apretado.get(0).getId() == boton_cas24.getId() || apretado.get(1).getId() == boton_cas24.getId()){
            establecerValor2(boton_cas24,cas);
        }
        if(apretado.get(0).getId() == boton_cas31.getId() || apretado.get(1).getId() == boton_cas31.getId()){
            establecerValor2(boton_cas31,cas);
        }
        if(apretado.get(0).getId() == boton_cas32.getId() || apretado.get(1).getId() == boton_cas32.getId()){
            establecerValor2(boton_cas32,cas);
        }
        if(apretado.get(0).getId() == boton_cas33.getId() || apretado.get(1).getId() == boton_cas33.getId()){
            establecerValor2(boton_cas33,cas);
        }
        if(apretado.get(0).getId() == boton_cas34.getId() || apretado.get(1).getId() == boton_cas34.getId()){
            establecerValor2(boton_cas34,cas);
        }
        apretado.clear();
    }


    public void establecerValor2(final ImageButton boton, final String val) {
        String s = val.toString();
        String rojo = "rojo";
        String negro = "negro";
        String blanco = "blanco";
        String rosado = "rosado";
        String amarillo = "amarillo";
        String azul = "azul";
        String casilla = "casilla";

        if (s.equals(rojo)) {
            boton.setBackgroundResource(R.drawable.rojo);
        } else if (s.equals(negro)) {
            boton.setBackgroundResource(R.drawable.negro);
        } else if (s.equals(blanco)) {
            boton.setBackgroundResource(R.drawable.blanco);
        } else if (s.equals(rosado)) {
            boton.setBackgroundResource(R.drawable.rosado);
        } else if (s.equals(amarillo)) {
            boton.setBackgroundResource(R.drawable.amarillo);
        } else if (s.equals(azul)) {
            boton.setBackgroundResource(R.drawable.azul);
        } else if (s.equals(casilla)){
            boton.setBackgroundResource(R.drawable.casilla5);
        }
    }



    public void esperar() {
        new CountDownTimer(30000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                txt_muestratimer.setText("Tiempo: " + (millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoMemorice.this);
                builder.setMessage("Perdiste!")
                        .setTitle("Mensaje")
                        .setCancelable(false)
                        .setNeutralButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        Intent nuevoform4 = new Intent(IJuegoMemorice.this, IRuleta.class);
                                        startActivity(nuevoform4);
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        }.start();
    }


}



