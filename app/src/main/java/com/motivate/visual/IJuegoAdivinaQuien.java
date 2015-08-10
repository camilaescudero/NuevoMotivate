package com.motivate.visual;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.motivate.nuevo.DataBaseJuego;
import com.motivate.nuevo.DataBaseJugador;
import com.motivate.nuevo.Juego;
import com.motivate.nuevo.JuegoAdivinaQuien;
import com.motivate.nuevo.Jugador;
import com.motivate.nuevo.R;

import java.util.ArrayList;

/**
 * Created by María Elizabeth on 26-05-2015.
 */
public class IJuegoAdivinaQuien extends ActionBarActivity {

    int intentos = 3;
    Button aceptar_adivinaquien;
    TextView mensaje_intentos;
    EditText usuario_personaje;
    ImageView img_personaje;
    JuegoAdivinaQuien adivinaQuien =new JuegoAdivinaQuien();
    DataBaseJuego dataBaseJuego = new DataBaseJuego(this);
    DataBaseJugador baseJugador = new DataBaseJugador(this);
    ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
    Juego juego = new Juego();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivinaquien);
        aceptar_adivinaquien=(Button)findViewById(R.id.btn_aceptar_adivinaquien);
        mensaje_intentos= (TextView)findViewById(R.id.lbl_intentos);
        usuario_personaje=(EditText)findViewById(R.id.txt_personaje);
        img_personaje=(ImageView)findViewById(R.id.imageView);
        //numero_generado=generar_aleatorio();


        TextView jugadorTurno= (TextView)findViewById(R.id.txt_turno_adivinaquien);

        //ASIGNA EL JUGADOR DE TURNO Y LO MUESTRA EN LA PANTALLA, ADEMAS DE MODIFICAR EN LA BASE DE DATOS EL TURNO DEL JUGADOR
        jugadors= baseJugador.rescatarDatos();
        juego.setTurno(dataBaseJuego.rescatarDatos());
        juego.setJugador(jugadors.get(juego.getTurno()));
        jugadorTurno.setText(jugadors.get(juego.getTurno()).getNombre());
        dataBaseJuego.modificarTurno(dataBaseJuego.devuelveId(),dataBaseJuego.rescatarDatos()+1,jugadors.size());


        establecer_imagen();



        aceptar_adivinaquien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = usuario_personaje.getText().toString().toLowerCase().trim();
                if (nombre.equals(adivinaQuien.asignar_nombre())) {
                    mostrar_alerta("Correcto !", "El personaje es " + nombre + ". Has ganado un punto ! ");
                    baseJugador.modificarPuntaje(juego.getJugador().getNombre(), juego.getJugador().getPuntaje() + 1);

                } else {
                    mostrar_alerta("Incorrecto !", "El personaje es " + adivinaQuien.asignar_nombre() + ". Has perdido");
                }
            }
        });
    }
    private void establecer_imagen (){

        int resId= getResources().getIdentifier(adivinaQuien.id_imagen(),"mipmap",getPackageName() );
        img_personaje.setImageResource(resId);
        System.out.println("VENTANA juego adivina quien");

        System.out.println("nombre " + adivinaQuien.asignar_nombre());
    }


    private void mostrar_alerta(String titulo,String mensaje){


        AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoAdivinaQuien.this);
        builder.setMessage(mensaje)
                .setTitle(titulo)
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                                Intent nuevoform4 = new Intent(IJuegoAdivinaQuien.this,IRuleta.class);
                                startActivity(nuevoform4);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
