package com.motivate.nuevo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cami on 24-05-2015.
 */
public class EditarJugador extends ActionBarActivity {

    private StringBuilder mensaje = new StringBuilder();
    private TextView textView;
    private EditText saludo;
    private Button aceptar;
    private TextView respuesta;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarjugador);

        textView = (TextView) findViewById( R.id.txt );
        Intent intent = getIntent();
        Bundle bundle= intent.getExtras();
        //mensaje.append(bundle.getInt("numero"));
        //textView.setText( mensaje );
        ArrayList<String> jugadores = new ArrayList<String>();
        ArrayList<Jugador> ju = new ArrayList<Jugador>();

        int j;
        /*for ( int i=0; i< bundle.getInt("numero"); i++) {
            j = i + 1;
            jugadores.add("jugador" + j + "\n");
        }*/
        saludo=(EditText)findViewById(R.id.txt_nombre);
        aceptar=(Button)findViewById(R.id.btn_agregar);
        respuesta=(TextView)findViewById(R.id.txt_mostrar);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = (TextView) findViewById( R.id.txt_lista );
                Intent intent = getIntent();
                Bundle bundle= intent.getExtras();
                ArrayList<String> jugadores = new ArrayList<String>();
                respuesta.setText(String.valueOf(saludo.getText()));
                jugadores.add(String.valueOf(saludo.getText()));

                mensaje.append(jugadores);
                textView.setText(mensaje);
            }
        });

       // mensaje.append(jugadores);
       // textView.setText(mensaje);
       /* TextView editText;
        AlertDialog.Builder  builder = new AlertDialog.Builder(this);
        builder.setTitle("Nombre del jugador 1 ").setCancelable(false).setNeutralButton("Aceptar",new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
*/


    }
}
