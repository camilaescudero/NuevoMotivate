package com.motivate.nuevo;

/**
 * Created by Cami on 17-06-2015.
 */
public class JuegoGato extends Juego {
    public Jugador getJugador1(){
        Partida p = new Partida();
        return p.getJugadores().get(0);
    }

    public Jugador getJugador2(){
        Partida p = new Partida();
        return p.getJugadores().get(1);
    }

    public Boolean verificar(){
        return true;
    }

    public int compara(int casilla, int c[]){

        Boolean acerto=false;
        int simbolo=-1; //simbolo tomara el valor de 1 si es x, 2 si es o y -2 en caso de que sea un empate

        if(casilla<=2){
            if((c[0]==c[1] && c[0]==c[2]) ){
                acerto=true;
                simbolo=c[0];
            }
        }
        if(casilla>=3 && casilla<=5) {
            if ((c[3] == c[4] && c[3] == c[5])) {
                acerto=true;
                simbolo=c[3];
            }

        }
        if(casilla>5){
            if((c[6]==c[7] && c[6]==c[8]) ){
                acerto=true;
                simbolo=c[6];
            }
        }
        if(casilla==1 || casilla==4 || casilla==7){
            if((c[1]==c[4] && c[1]==c[7]) ){
                acerto=true;
                simbolo=c[1];
            }

        }
        if(casilla==0 || casilla==3 || casilla==6){
            if((c[0]==c[3] && c[0]==c[6]) ){
                acerto=true;
                simbolo=c[0];
            }

        }
        if(casilla==2 || casilla==5 || casilla==8){
            if((c[2]==c[5] && c[2]==c[8]) ){
                acerto=true;
                simbolo=c[2];
            }
        }
        if(casilla==4 ){
            if((c[4]==c[0] && c[4]==c[8]) || (c[4]==c[2] && c[4]==c[8]) || (c[4]==c[1] && c[4]==c[7]) || (c[4]==c[3] && c[4]==c[5]) ){
                acerto=true;
                simbolo=c[4];
            }
        }
        if(casilla==0 || casilla==8){
            if(c[0]==c[8] && c[0]==c[4]){
                acerto=true;
                simbolo=c[0];
            }
        }
        if(casilla==2 || casilla==6){
            if(c[2]==c[6] && c[2]==c[4]){
                acerto=true;
                simbolo=c[2];
            }
        }


       if(acerto==false){
           //si acerto es falso, quiere decir que no se completo una fila o diagonal con los mismos simbolos
            if(sinGanador(c)){
                //si todas las casillas estan llenas entonces retonara -2 para mostrar mensaje de empate
                simbolo=-2;
            }
        }

        return simbolo;
    }

    public boolean sinGanador(int c[]){
        //cuenta la cantidad de casillas ocupadas, retorna true si es que estan llenas, false si es que no
        int cont,i;
        cont =0;
        for(i=0;i<=8;i++){
            if (c[i]!= 0){
                cont= cont+1;
            }
        }
        if(cont==9) {
            return true;
        }
        return false;

    }





}
