package com.motivate.nuevo;

import java.util.ArrayList;

/**
 * Created by Cami on 07-06-2015.
 */
public class Partida {

    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void agregarJugador(String nom, int punt){
        Jugador ju = new Jugador();
        ju.setNombre(nom);
        ju.setPuntaje(punt);
        jugadores.add(ju);
    }


}
