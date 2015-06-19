package com.motivate.nuevo;

/**
 * Created by Cami on 16-06-2015.
 */
public class JuegoAdivinaQuien extends Juego {
    private String[] nombre_personaje={"angelina_jolie","caua_raymond","jennifer_lopez", "johnny_depp","lindsay_lohan", "paul_walker",
            "vin_diesel","zac_efron"};
    private int numero_generado = generar_aleatorio();

    public String asignar_nombre(){

        switch (numero_generado){
            case 0:
                nombre_personaje[numero_generado]= "angelina jolie";
                break;

            case 1:
                nombre_personaje[numero_generado]= "caua raymond";
                break;

            case 2:
                nombre_personaje[numero_generado]= "jennifer lopez";
                break;

            case 3:
                nombre_personaje[numero_generado]= "johnny depp";
                break;

            case 4:
                nombre_personaje[numero_generado]= "lindsay lohan";
                break;

            case 5:
                nombre_personaje[numero_generado]= "paul walker";
                break;

            case 6:
                nombre_personaje[numero_generado]= "vin diesel";
                break;

            case 7:
                nombre_personaje[numero_generado]= "zac efron";
                break;

        }
       /* System.out.println("numero"+numero_generado);
        System.out.println("nombre "+nombre_personaje[numero_generado]);*/
        return(nombre_personaje[numero_generado]);
    }
    public String id_imagen(){
        return nombre_personaje[numero_generado];
    }



    private int generar_aleatorio(){

        return (int) (Math.random()*nombre_personaje.length);
    }

    public int devulve_numero(){
        return numero_generado;
    }
}
