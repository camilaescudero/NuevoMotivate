package com.motivate.nuevo;

/**
 * Created by Maria Elizabeth on 29-06-2015.
 */
public class JuegoBachillerato extends Juego {
    private String[] abecedario = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X",
            "Y","Z"};
    public String letra= asignar_letra();

    private String asignar_letra(){
        int numero= (int) (Math.random()*abecedario.length);
        return abecedario[numero];
    }

}

