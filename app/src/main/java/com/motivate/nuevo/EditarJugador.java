package com.motivate.nuevo;

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
    private Button iniciar;
    private TextView respuesta;
    private ArrayList<Jugador> ju = new ArrayList<Jugador>();
    private ArrayList<String> jugadores = new ArrayList<String>();
    private Jugador jugar = new Jugador();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarjugador);
        textView = (TextView) findViewById( R.id.txt );
        //recibo el numero , creo que no se usara
        Intent intent = getIntent();
        Bundle bundle= intent.getExtras();

        saludo=(EditText)findViewById(R.id.txt_nombre);
        aceptar=(Button)findViewById(R.id.btn_agregar);
        respuesta=(TextView)findViewById(R.id.txt_mostrar);
        iniciar= (Button)findViewById(R.id.btn_jugar);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = (TextView) findViewById( R.id.txt_lista );
                //respuesta.setText(String.valueOf(saludo.getText()));

                jugadores.add(String.valueOf(saludo.getText()));

                getJugar().setNombre(String.valueOf(saludo.getText()));
                getJugar().setPuntaje(0);
                getJu().add(getJugar());

                mensaje.append(String.valueOf(saludo.getText()));
                mensaje.append("\n");
                textView.setText(mensaje);
                saludo.setText("");
            }

        });
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent nuevoform = new Intent(EditarJugador.this,Ruleta.class);
                bundle.putInt("entraRuleta",0);
                bundle.putStringArrayList("juegue", jugadores);
                nuevoform.putExtras(bundle);
                startActivity(nuevoform);
            }
        });


    }

    public Jugador getJugar() {
        return jugar;
    }

    public void setJugar(Jugador jugar) {
        this.jugar = jugar;
    }

    public ArrayList<Jugador> getJu() {
        return ju;
    }

    public void setJu(ArrayList<Jugador> ju) {
        this.ju = ju;
    }
}
