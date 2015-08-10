package com.motivate.nuevo;

import android.content.res.Resources;

import java.util.ArrayList;

/**
 * Created by Cami on 19-06-2015.
 */
public class JuegoPreguntaRespuesta extends Juego {

    private String[] pregunta;
    private String[] respuesta;
    public JuegoPreguntaRespuesta(String pregun[]){
        pregunta = pregun;
    }

   public int comparar(String respuestaUsuario, String respuesta[]){

       Partida p = new Partida();
       Juego juego= new Juego();
       ArrayList<Jugador> jugadors= new ArrayList<Jugador>();
       jugadors= p.getJugadores();

           for (int i = 0; i < respuesta.length; i++) {
               if (respuesta[i].equals(respuestaUsuario)) {
                   return 1;

               }
           }

       return 2;
   }


}
