package com.motivate.nuevo;


import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
 * Created by Guillermo on 06-07-2015.
 */
public class JuegoMemorice {
    private int turno = 0;
    private int [] apretados = {-1,-1};
    private ArrayList<ImageButton> apretado = new ArrayList<ImageButton>();
    private int terminar = 0;

    public static String[] mezclar (String[] val) {
        int l = val.length;
        String[] nuevo = new String[l];
        ArrayList<String> aux = new ArrayList<String>(Arrays.asList(val));
        Collections.shuffle(aux);
        for (int i =0; i<aux.size(); i++){
            nuevo[i]=aux.get(i).toString();
        }
        return (nuevo);
    }



    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }




    public int[] getApretados() {
        return apretados;
    }

    public int getApretados(int i){
        return apretados[i];
    }

    public void setApretados(int[] apretados) {
        this.apretados = apretados;
    }

    public void setApretados (int i,int valor){
        this.apretados[i]= valor;
    }



    public ArrayList<ImageButton> getApretado() {
        return apretado;
    }

    public void setApretado(ArrayList<ImageButton> apretado) {
        this.apretado = apretado;
    }

    public int getTerminar() {
        return terminar;
    }

    public void setTerminar(int terminar) {
        this.terminar = terminar;
    }
}

