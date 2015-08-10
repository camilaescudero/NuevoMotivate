package com.motivate.nuevo;

import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;

/**
 * Created by Cami on 16-06-2015.
 */
public class Juego extends ActionBarActivity {

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    private int turno;

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    private Jugador jugador;
    public Juego(){

    }
    public Juego(ArrayList<Jugador> jugadors){

    }
    public Juego(int tur){
        this.turno=tur;


    }


    public String turno(){
        Partida p = new Partida();
        ArrayList<Jugador> jugadors= new ArrayList<Jugador>();
        jugadors=p.getJugadores();
        return jugadors.get(this.turno).getNombre();
    }

    public void modificarPuntaje (int puntaje){
        DataBaseJugador manager = new DataBaseJugador(this);
        ArrayList<Jugador> jugadors= new ArrayList<Jugador>();
        jugadors= manager.rescatarDatos();
        manager.modificarPuntaje(jugadors.get(turno).getNombre(),puntaje);
    }

}
