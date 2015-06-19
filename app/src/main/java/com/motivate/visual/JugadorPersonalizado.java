package com.motivate.visual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.motivate.nuevo.DataBaseManager;
import com.motivate.nuevo.Jugador;
import com.motivate.nuevo.Partida;
import com.motivate.nuevo.R;

import java.util.ArrayList;

/**
 * Created by Cami on 24-05-2015.
 */
public class JugadorPersonalizado extends ActionBarActivity {

    StringBuilder mensaje = new StringBuilder();
    TextView textView;
    EditText nombre;
    Button aceptar;
    Button iniciar;
    TextView mostrar;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarjugador);


        Button boton = (Button)findViewById(R.id.btn_jugar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoform = new Intent(JugadorPersonalizado.this, Ruleta.class);
                startActivity(nuevoform);
            }
        });


        textView = (TextView) findViewById( R.id.txt );

        nombre=(EditText)findViewById(R.id.txt_nombre);
        aceptar=(Button)findViewById(R.id.btn_agregar);
        mostrar=(TextView)findViewById(R.id.txt_mostrar);
        iniciar= (Button)findViewById(R.id.btn_jugar);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = (TextView) findViewById( R.id.txt_lista );
                //respuesta.setText(String.valueOf(saludo.getText()));
                Partida p= new Partida();
                p.creaPersonalizado(String.valueOf(nombre.getText()));

                mensaje.append(String.valueOf(nombre.getText()));
                mensaje.append("\n");
                textView.setText(mensaje);
                nombre.setText("");

            }

        });
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nuevoform = new Intent(JugadorPersonalizado.this,Ruleta.class);
                startActivity(nuevoform);
            }
        });

    }


}
