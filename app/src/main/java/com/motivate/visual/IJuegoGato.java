package com.motivate.visual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.motivate.nuevo.DataBaseJuego;
import com.motivate.nuevo.DataBaseJugador;
import com.motivate.nuevo.Juego;
import com.motivate.nuevo.JuegoGato;
import com.motivate.nuevo.Jugador;
import com.motivate.nuevo.R;

import java.util.ArrayList;

/**
 * Created by Cami on 08-06-2015.
 */
public class IJuegoGato extends ActionBarActivity {
 /*   private Jugador jugador1;
    private Jugador jugador2;

    public IJuegoGato(Jugador j){
        this.jugador1 = j;
    }
*/
    JuegoGato gato = new JuegoGato();

    DataBaseJuego dataBaseJuego = new DataBaseJuego(this);
    DataBaseJugador baseJugador = new DataBaseJugador(this);
    ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
    Juego juego = new Juego();
    Button casilla0,casilla1, casilla2, casilla3,casilla4,casilla5,casilla6, casilla7,casilla8;
    int c1, c2, c3,c4,c5,c6,c7,c8,c9;
    int[] c = new int[9];
    int i;
    int cont=0;
    int turno=0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gato);


        jugadors= baseJugador.rescatarDatos();
        int num = jugadors.size()-1;
        int versus;

        juego.setTurno(dataBaseJuego.rescatarDatos());
        TextView jugadorTurnoGato = (TextView)findViewById(R.id.txt_gato_versus);
        do{
            versus= (int)(Math.random()*num);
        }while (versus == juego.getTurno());

        gato.setJugador1(jugadors.get(juego.getTurno()));
        gato.setJugador2(jugadors.get(versus));
        jugadorTurnoGato.setText(gato.getJugador1().getNombre()+"  vs  "+gato.getJugador2().getNombre());

        //cambia el turno para el siguiente
        dataBaseJuego.modificarTurno(dataBaseJuego.devuelveId(),dataBaseJuego.rescatarDatos()+1,jugadors.size());

        for(i=0;i<=8;i++){
            c[i]=0;
        }
        casilla0 = (Button)findViewById(R.id.x1);
        casilla1 = (Button)findViewById(R.id.x2);
        casilla2 = (Button)findViewById(R.id.x3);
        casilla3 = (Button)findViewById(R.id.x4);
        casilla4 = (Button)findViewById(R.id.x5);
        casilla5 = (Button)findViewById(R.id.x6);
        casilla6 = (Button)findViewById(R.id.x7);
        casilla7 = (Button)findViewById(R.id.x8);
        casilla8 = (Button)findViewById(R.id.x9);

        casilla0.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
            if(c[0]==0 ){
                if(turno ==0 || turno ==2 ||turno ==4||turno ==6||turno ==8 ){

                    casilla0.setBackgroundResource(R.mipmap.cruz);
                    turno=turno+1;
                    c[0]=1;

                }
                else{
                    casilla0.setBackgroundResource(R.mipmap.ciculo);
                    turno=turno+1;
                       c[0]=2;
                }
               // compara(0,c);
                if(gato.compara(0,c)!=-1){
                    mensaje(gato.compara(0,c));
                }
            }
            }
        });

        casilla1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if(c[1]==0 ){
                    if(turno ==0 || turno ==2 ||turno ==4||turno ==6||turno ==8 ){

                        casilla1.setBackgroundResource(R.mipmap.cruz);
                        turno=turno+1;
                        c[1]=1;
                    }
                    else{
                        casilla1.setBackgroundResource(R.mipmap.ciculo);
                        turno=turno+1;
                        c[1]=2;
                    }
                    if(gato.compara(1,c)!=-1){
                        mensaje(gato.compara(1,c));
                    }
                }
            }
        });

        casilla2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if(c[2]==0){
                    if(turno ==0 || turno ==2 ||turno ==4||turno ==6||turno ==8 ){

                        casilla2.setBackgroundResource(R.mipmap.cruz);
                        turno=turno+1;
                        c[2]=1;
                    }
                    else{
                        casilla2.setBackgroundResource(R.mipmap.ciculo);
                        turno=turno+1;
                        c[2]=2;
                    }
                    if(gato.compara(2,c)!=-1){
                        mensaje(gato.compara(2,c));
                    }
                }
            }
        });

        casilla3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                    if(c[3]==0){
                        if(turno ==0 || turno ==2 ||turno ==4||turno ==6||turno ==8 ){

                            casilla3.setBackgroundResource(R.mipmap.cruz);
                            turno=turno+1;
                            c[3]=1;
                        }
                        else{
                            casilla3.setBackgroundResource(R.mipmap.ciculo);
                            turno=turno+1;
                            c[3]=2;
                        }
                        if(gato.compara(3,c)!=-1){
                            mensaje(gato.compara(3,c));
                        }
                    }
            }
        });

        casilla4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if(c[4]==0){
                    if(turno ==0 || turno ==2 ||turno ==4||turno ==6||turno ==8 ){

                        casilla4.setBackgroundResource(R.mipmap.cruz);
                        turno=turno+1;
                        c[4]=1;
                    }
                    else{
                        casilla4.setBackgroundResource(R.mipmap.ciculo);
                        turno=turno+1;
                        c[4]=2;
                    }
                    if(gato.compara(4,c)!=-1){
                        mensaje(gato.compara(4,c));
                    }
                }
            }
        });

        casilla5.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if(c[5]==0) {
                    if (turno == 0 || turno == 2 || turno == 4 || turno == 6 || turno == 8) {

                        casilla5.setBackgroundResource(R.mipmap.cruz);
                        turno = turno + 1;
                        c[5]=1;
                    }else{
                        casilla5.setBackgroundResource(R.mipmap.ciculo);
                        turno = turno + 1;
                        c[5]=2;
                    }
                    if(gato.compara(5,c)!=-1){
                        mensaje(gato.compara(5,c));
                    }
                }
            }
        });

        casilla6.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if (c[6]==0) {
                    if (turno == 0 || turno == 2 || turno == 4 || turno == 6 || turno == 8) {

                        casilla6.setBackgroundResource(R.mipmap.cruz);
                        turno = turno + 1;
                        c[6]=1;
                    } else {
                        casilla6.setBackgroundResource(R.mipmap.ciculo);
                        turno = turno + 1;
                        c[6]=2;
                    }
                    if(gato.compara(6,c)!=-1){
                        mensaje(gato.compara(6,c));
                    }
                }
            }
        });

        casilla7.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if (c[7]==0){
                    if(turno ==0 || turno ==2 ||turno ==4||turno ==6||turno ==8 ){

                        casilla7.setBackgroundResource(R.mipmap.cruz);
                        turno=turno+1;
                        c[7]=1;
                    }
                    else{
                        casilla7.setBackgroundResource(R.mipmap.ciculo);
                        turno=turno+1;
                        c[7]=2;
                    }
                    if(gato.compara(7,c)!=-1){
                        mensaje(gato.compara(7,c));
                    }
                }
            }
        });

        casilla8.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if(c[8]==0){
                    if(turno ==0 || turno ==2 ||turno ==4||turno ==6||turno ==8 ){

                        casilla8.setBackgroundResource(R.mipmap.cruz);
                        turno=turno+1;
                        c[8]=1;
                    }
                    else{
                        casilla8.setBackgroundResource(R.mipmap.ciculo);
                        turno=turno+1;
                        c[8]=2;
                    }

                    if(gato.compara(8,c)!=-1){
                        mensaje(gato.compara(8,c));
                    }
                }
            }
        });

    }


    public void mensaje(int resultado){
        DataBaseJugador manager = new DataBaseJugador(this);

        if(resultado==1) {

            manager.modificarPuntaje(gato.getJugador1().getNombre() ,gato.getJugador2().getPuntaje()+1);

            AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoGato.this);
            builder.setMessage("Ganaste 1 puntos")
                    .setTitle("GANA  X"+ juego.getJugador().getNombre() )
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent nuevoform4 = new Intent(IJuegoGato.this,IRuleta.class);
                                    startActivity(nuevoform4);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();


        }
        if(resultado==2){
            manager.modificarPuntaje(gato.getJugador1().getNombre() ,gato.getJugador2().getPuntaje()+1);

            AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoGato.this);
            builder.setMessage("Ganaste 1 punto")
                    .setTitle("GANA O"+ juego.getJugador().getNombre())
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent nuevoform4 = new Intent(IJuegoGato.this,IRuleta.class);
                                    startActivity(nuevoform4);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();

        }
        if(resultado==-2){
            AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoGato.this);
            builder.setMessage("Toman los dos por weones  xD")
                    .setTitle("Empate ")
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent nuevoform4 = new Intent(IJuegoGato.this,IRuleta.class);
                                    startActivity(nuevoform4);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }


    }


    }
