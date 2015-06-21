package com.motivate.nuevo;

import android.content.res.Resources;

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

           for (int i = 0; i < respuesta.length; i++) {
               if (respuesta[i].equals(respuestaUsuario)) {
                   return 1;
               }
           }

       return 2;

   }

}
