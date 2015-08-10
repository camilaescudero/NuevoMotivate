package com.motivate.nuevo;

import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;

/**
 * Created by Cami on 07-06-2015.
 */
public class Partida extends ActionBarActivity {


    private ArrayList<Jugador> jugadores= new ArrayList<Jugador>();

    public Partida(){

    }

    public Partida(ArrayList<Jugador> jugadors ){
        jugadores = jugadors;

    }
    public ArrayList<Jugador> getJugadores() {
        mostrarJugadores();
        return jugadores;

    }

    public void setJugadores(ArrayList<Jugador> jugadores) {

        this.jugadores = jugadores;
        System.out.println("setJugadores");
        mostrarJugadores();
    }

    public void agregarJugador(Jugador j){
        this.jugadores.add(j);
        System.out.println("agregaJugador");
        mostrarJugadores();
    }
    public void creaEstandar(int numero){
        int i,j;
        for (i=0; i< numero; i++){
            j=i+1;
            Jugador jug = new Jugador();
            jug.setNombre("jugador "+j);
            jug.setPuntaje(0);
            this.jugadores.add(jug);
        }
        System.out.println("creaEstandar");
        mostrarJugadores();
        //manager.insertar(jugadores);

    }
    public void creaPersonalizado(String nombre){
        Jugador j= new Jugador();
        j.setNombre(nombre);
        agregarJugador(j);
        //mostrarJugadores();
    }
    public void mostrarJugadores(){
        int i;
        System.out.println("Mostrara los nombres :");
        for(i=0;i< jugadores.size();i++){
            System.out.println(jugadores.get(i).getNombre());
            System.out.println(jugadores.get(i).getPuntaje());
        }
    }


  /*  public void modificarPuntajeJugador (String nombre, String puntaje){
        DataBaseManager manager = new DataBaseManager(this);
        manager.modificarPuntaje(nombre,puntaje);
    }*/

    public void modificarPuntajeJugador (String nombre, int puntaje) {
        for (int i =0; i<jugadores.size();i++){
            if(jugadores.get(i).getNombre().equals(nombre)){
                jugadores.get(i).setPuntaje(puntaje);
            }
        }
    }
    public void modificaPuntaje(){
        DataBaseJugador manager = new DataBaseJugador(this);
        ArrayList<Jugador> jugadors= new ArrayList<Jugador>();
        jugadors= manager.rescatarDatos();
        manager.modificarPuntaje(jugadors.get(0).getNombre(),20);
    }






    }
