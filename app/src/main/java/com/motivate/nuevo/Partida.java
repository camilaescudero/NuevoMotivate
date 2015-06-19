package com.motivate.nuevo;

import com.motivate.visual.JugadorEstandar;
import com.motivate.visual.JugadorPersonalizado;

import java.util.ArrayList;

/**
 * Created by Cami on 07-06-2015.
 */
public class Partida {


    private ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
    public Partida(){

    }

    public ArrayList<Jugador> getJugadores() {
        mostrarJugadores();
        return jugadores;

    }

    public void setJugadores(ArrayList<Jugador> jugadores) {

        this.jugadores = jugadores;
        mostrarJugadores();
    }

    public void agregarJugador(Jugador j){
        jugadores.add(j);
        mostrarJugadores();
    }
    public void creaEstandar(int numero){
        int j;
        Jugador jug = new Jugador();
        for ( int i=0; i< numero; i++){
            j=i+1;
            jug.setNombre("jugador "+j);
            jug.setPuntaje(0);
            agregarJugador(jug);
            mostrarJugadores();
        }
    }
    public void creaPersonalizado(String nombre){
        Jugador j= new Jugador();
        j.setNombre(nombre);
        agregarJugador(j);
        mostrarJugadores();
    }
    public void mostrarJugadores(){
        int i;
        System.out.println("Mostrara los nombres :");
        for(i=0;i< jugadores.size();i++){
            System.out.println(jugadores.get(i).getNombre());
            System.out.println(jugadores.get(i).getPuntaje());
        }
    }

}
