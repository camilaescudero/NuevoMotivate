package com.motivate.nuevo;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cami on 08-06-2015.
 */
public class Juego_Gato extends ActionBarActivity {
    private Jugador jugador1;
    private Jugador jugador2;

    public Juego_Gato(Jugador j){
        this.jugador1 = j;
    }

    Button casilla0,casilla1, casilla2, casilla3,casilla4,casilla5,casilla6, casilla7,casilla8;
    int c1, c2, c3,c4,c5,c6,c7,c8,c9;
    int[] c = new int[9];
    int i;
    int cont=0;
    int turno=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gato);
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
                compara(0,c);
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
                    compara(1,c);
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
                    compara(2,c);
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
                        compara(3,c);
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
                    compara(4,c);
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
                    compara(5,c);
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
                    compara(6,c);
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
                    compara(7,c);
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
                    compara(8,c);
                }
            }
        });

        if(turno==8){
            sinGanador(c);
        }



    }

    public void compara(int casilla, int valor[]){
        boolean acerto=false;
        if(casilla<=2){
            if((c[0]==c[1] && c[0]==c[2]) ){
                acerto=true;
                mensaje_ganaste(c[0]);
            }
        }
        if(casilla>=3 && casilla<=5) {
            if ((c[3] == c[4] && c[3] == c[5])) {
                acerto=true;
                mensaje_ganaste(c[3]);
            }
        }
        if(casilla>5){
            if((c[6]==c[7] && c[6]==c[8]) ){
                acerto=true;
                mensaje_ganaste(c[6]);
            }
        }
        if(casilla==1 || casilla==4 || casilla==7){
            if((c[1]==c[4] && c[1]==c[7]) ){
                acerto=true;
                mensaje_ganaste(c[1]);
            }
        }
        if(casilla==0 || casilla==3 || casilla==6){
            if((c[0]==c[3] && c[0]==c[6]) ){
                acerto=true;
                mensaje_ganaste(c[0]);
            }
        }
        if(casilla==2 || casilla==5 || casilla==8){
            if((c[2]==c[5] && c[2]==c[8]) ){
                acerto=true;
                mensaje_ganaste(c[2]);
            }
        }
        if(casilla==4){
            if((c[4]==c[0] && c[4]==c[8]) || (c[4]==c[2] && c[4]==c[8]) || (c[4]==c[1] && c[4]==c[7]) || (c[4]==c[3] && c[4]==c[5]) ){
                acerto=true;
                mensaje_ganaste(c[4]);
            }
        }
        if(acerto==false){
            sinGanador(c);
        }

    }
    public void mensaje_ganaste(int gana){
        if(gana==1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Juego_Gato.this);
            builder.setMessage("Ganaste 10 puntos")
                    .setTitle("GANA  X")
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent nuevoform4 = new Intent(Juego_Gato.this,Ruleta.class);
                                    startActivity(nuevoform4);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();


        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(Juego_Gato.this);
            builder.setMessage("Ganaste 10 puntos")
                    .setTitle("GANA O")
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent nuevoform4 = new Intent(Juego_Gato.this,Ruleta.class);
                                    startActivity(nuevoform4);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();

        }

    }
    public void sinGanador(int c[]){

        cont =0;
        for(i=0;i<=8;i++){
            if (c[i]!= 0){
                cont= cont+1;
            }
        }
        if(cont==9){
            AlertDialog.Builder builder = new AlertDialog.Builder(Juego_Gato.this);
            builder.setMessage("Toman los dos por weones  xD")
                    .setTitle("Empate ")
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent nuevoform4 = new Intent(Juego_Gato.this,Ruleta.class);
                                    startActivity(nuevoform4);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }




    }
