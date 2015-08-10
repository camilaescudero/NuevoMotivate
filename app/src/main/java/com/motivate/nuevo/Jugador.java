package com.motivate.nuevo;

/**
 * Created by Cami on 23-05-2015.
 */
public class Jugador {

    private String nombre;
    private int puntaje;

    public Jugador(){
        nombre="";
        puntaje =0;
    }
    public Jugador(int id, String nomb, int punt){
        nombre=nomb;
        puntaje=punt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int  getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
