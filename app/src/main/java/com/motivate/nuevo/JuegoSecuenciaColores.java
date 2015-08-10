package com.motivate.nuevo;

import android.os.Bundle;

/**
 * Created by Cami on 30-06-2015.
 */
public class JuegoSecuenciaColores extends Juego {

    private int[] secuencia;
    private int selecciona;

    public void JuegoSecuenciaColores() {

    }

    public int getSelecciona() {
        return selecciona;
    }

    public int[] getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int[] secuencia) {
        this.secuencia = secuencia;
    }

    public void setSelecciona(int selecciona) {
        this.selecciona = selecciona;
    }



    public JuegoSecuenciaColores() {
        secuencia= new  int[4];
    }
    public int[] generarSecuencia(){

        secuencia[0]= (int)(Math.random()*3);
        secuencia[1]= (int)(Math.random()*3);
        secuencia[2]= (int)(Math.random()*3);
        secuencia[3]= (int)(Math.random()*3);
        return secuencia;
    }
    public int compraraColores( int color){

        if (secuencia[selecciona]==color && this.selecciona<3){
            this.selecciona=this.selecciona+1;
              return 1;
        }
        if (secuencia[selecciona]==color && this.selecciona==3){
            this.selecciona=this.selecciona+1;
            return 2;
        }
        if (secuencia[selecciona]!=color){
            this.selecciona=this.selecciona+1;
            return -2;
        }


        return 0;
    }

}
