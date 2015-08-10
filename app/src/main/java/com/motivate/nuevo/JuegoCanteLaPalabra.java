package com.motivate.nuevo;

/**
 * Created by Guillermo on 26-06-2015.
 */
public class JuegoCanteLaPalabra extends Juego {
    private String[] palabraCancion = {"Amor", "Adios", "Sol", "Lluvia", "Hombre", "Mujer", "Vida", "Corazon"};
    private int numero_generado = generar_aleatorio();

    private int generar_aleatorio() {
        return (int) (Math.random() * getPalabraCancion().length);
    }

    public String asignar_palabra(){
        return palabraCancion[numero_generado];
    }


    public String[] getPalabraCancion() {
        return palabraCancion;
    }

    public void setPalabraCancion(String[] palabraCancion) {
        this.palabraCancion = palabraCancion;
    }

    public int getNumero_generado() {
        return numero_generado;
    }

    public void setNumero_generado(int numero_generado) {
        this.numero_generado = numero_generado;
    }



}
