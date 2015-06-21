package com.motivate.nuevo;

import java.util.ArrayList;

/**
 * Created by María Elizabeth on 20-06-2015.
 */
public class JuegoAhorcado extends Juego {
    private String[] img_ahorcado={"ahorcadoinicial","ahorcadopiernas","ahorcadotronco","ahorcadobrazos","ahorcadocuello",
            "ahorcadofinal"};
    public String[] palabra_ahorcado={"computador", "peluche", "florero", "campanario", "microscopio","cuaderno","dormitorio",
            "celular","mochila", "cama","silla","auto","plato"};
    private int numero_generado=generar_aleatorio();
    public String palabra= asignar_palabra();
    public int largo_palabra=palabra.length();
    public ArrayList<String> vector_palabra= new ArrayList<>(largo_palabra);
    private int posicion;

    public boolean compara_letra(Character letra){
        for(int i=0; i<palabra.length();i++){
            if(palabra.charAt(i)==letra){
                posicion=i;
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> rescata_posiciones(Character letra){
        ArrayList<Integer> posiciones= new ArrayList<>();
        posiciones=null;
        for(int i=0; i<palabra.length();i++){
            if(palabra.charAt(i)==letra){
                posiciones.add(i);
            }
        }
        return posiciones;
    }

    public String asignar_palabra(){
        return palabra_ahorcado[numero_generado];
    }

    private int generar_aleatorio(){
        return (int) (Math.random()*palabra_ahorcado.length);
    }

    public ArrayList generar_inicial(){
        for(int i=0; i<palabra.length();i++){
            vector_palabra.add("_");
        }
        return vector_palabra;
    }

    public ArrayList generar_palabra(Character letra){
        for(int i=0; i<palabra.length();i++){
            if(palabra.charAt(i)==letra) {
                vector_palabra.set(i,letra.toString());
            }
        }


        return vector_palabra;
    }

    public boolean palabra_completa(){
        int contador=0;
        for(int i=0; i<vector_palabra.size();i++){
            if(vector_palabra.get(i)=="_") {
                contador=contador+1;
            }
        }
        if (contador==0)return true;
        else return false;
    }


}
