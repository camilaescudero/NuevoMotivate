package com.motivate.visual;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.motivate.nuevo.DataBaseJuego;
import com.motivate.nuevo.DataBaseJugador;
import com.motivate.nuevo.Juego;
import com.motivate.nuevo.JuegoAhorcado;
import com.motivate.nuevo.Jugador;
import com.motivate.nuevo.R;

import java.util.ArrayList;

/**
 * Created by Mara Elizabeth on 20-06-2015.
 */
public class IJuegoAhorcado extends ActionBarActivity {
    Button btna,btnb,btnc,btnd,btne,btnf,btng,btnh,btni,btnj,btnk,btnl,btnm,btnn,btnnn,btno,btnp,btnq,btnr,btns,btnt,btnu,btnv,
            btnw,btnx,btny,btnz;
    TextView palabra_secreta;
    ImageView imagen_ahorcado;
    JuegoAhorcado ahorcado = new JuegoAhorcado();
    int estado_imagen;
    int largo= ahorcado.largo_palabra;
    DataBaseJuego dataBaseJuego = new DataBaseJuego(this);
    DataBaseJugador baseJugador = new DataBaseJugador(this);
    ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
    Juego juego = new Juego();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorcado);

        TextView jugadorTurno= (TextView)findViewById(R.id.txt_turno_ahorcado);

        //ASIGNA EL JUGADOR DE TURNO Y LO MUESTRA EN LA PANTALLA, ADEMAS DE MODIFICAR EN LA BASE DE DATOS EL TURNO DEL JUGADOR
        jugadors= baseJugador.rescatarDatos();
        juego.setTurno(dataBaseJuego.rescatarDatos());
        juego.setJugador(jugadors.get(juego.getTurno()));
        jugadorTurno.setText(jugadors.get(juego.getTurno()).getNombre());
        dataBaseJuego.modificarTurno(dataBaseJuego.devuelveId(),dataBaseJuego.rescatarDatos()+1,jugadors.size());


        btna = (Button) findViewById(R.id.btna);
        btnb = (Button) findViewById(R.id.btnb);
        btnc = (Button) findViewById(R.id.btnc);
        btnd = (Button) findViewById(R.id.btnd);
        btne = (Button) findViewById(R.id.btne);
        btnf = (Button) findViewById(R.id.btnf);
        btng = (Button) findViewById(R.id.btng);
        btnh = (Button) findViewById(R.id.btnh);
        btni = (Button) findViewById(R.id.btni);
        btnj = (Button) findViewById(R.id.btnj);
        btnk = (Button) findViewById(R.id.btnk);
        btnl = (Button) findViewById(R.id.btnl);
        btnm = (Button) findViewById(R.id.btnm);
        btnn = (Button) findViewById(R.id.btnn);
        btnnn = (Button) findViewById(R.id.btnnn);
        btno = (Button) findViewById(R.id.btno);
        btnp = (Button) findViewById(R.id.btnp);
        btnq = (Button) findViewById(R.id.btnq);
        btnr = (Button) findViewById(R.id.btnr);
        btns = (Button) findViewById(R.id.btns);
        btnt = (Button) findViewById(R.id.btnt);
        btnu = (Button) findViewById(R.id.btnu);
        btnv = (Button) findViewById(R.id.btnv);
        btnw = (Button) findViewById(R.id.btnw);
        btnx = (Button) findViewById(R.id.btnx);
        btny = (Button) findViewById(R.id.btny);
        btnz = (Button) findViewById(R.id.btnz);

        palabra_secreta = (TextView) findViewById(R.id.txt_palabraAhorcado);

        imagen_ahorcado = (ImageView) findViewById(R.id.img_ahorcado);
        estado_imagen=1;
        establecer_imagen(estado_imagen);

        String palabra_bonita= ahorcado.generar_inicial().toString();
        palabra_bonita=palabra_bonita.replace("[","");
        palabra_bonita=palabra_bonita.replace("]","");
        palabra_bonita=palabra_bonita.replace(","," ");
        palabra_secreta.setText(palabra_bonita);
        System.out.println(ahorcado.palabra);

        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('a');
                btna.setEnabled(false);
            }
        });
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('b');
                btnb.setEnabled(false);
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('c');
                btnc.setEnabled(false);
            }
        });
        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('d');
                btnd.setEnabled(false);
            }
        });
        btne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('e');
                btne.setEnabled(false);
            }
        });
        btnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('f');
                btnf.setEnabled(false);
            }
        });
        btng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('g');
                btng.setEnabled(false);
            }
        });
        btnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('h');
                btnh.setEnabled(false);
            }
        });
        btni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('i');
                btni.setEnabled(false);
            }
        });
        btnj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('j');
                btnj.setEnabled(false);
            }
        });
        btnk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('k');
                btnk.setEnabled(false);
            }
        });
        btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('l');
                btnl.setEnabled(false);
            }
        });
        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('m');
                btnm.setEnabled(false);
            }
        });
        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('n');
                btnn.setEnabled(false);
            }
        });
        btnnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('�');
                btnnn.setEnabled(false);
            }
        });
        btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('o');
                btno.setEnabled(false);
            }
        });
        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('p');
                btnp.setEnabled(false);
            }
        });
        btnq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('q');
                btnq.setEnabled(false);
            }
        });
        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('r');
                btnr.setEnabled(false);
            }
        });
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('s');
                btns.setEnabled(false);
            }
        });
        btnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('t');
                btnt.setEnabled(false);
            }
        });
        btnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('u');
                btnu.setEnabled(false);
            }
        });
        btnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('v');
                btnv.setEnabled(false);
            }
        });
        btnw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('w');
                btnw.setEnabled(false);
            }
        });
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('x');
                btnx.setEnabled(false);
            }
        });
        btny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('y');
                btny.setEnabled(false);
            }
        });
        btnz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click('z');
                btnz.setEnabled(false);
            }
        });
    }

    public void click(char letra){
        if (ahorcado.compara_letra(letra)) {
            String palabra_bonita= ahorcado.generar_palabra(letra).toString();
            palabra_bonita=palabra_bonita.replace("[","");
            palabra_bonita=palabra_bonita.replace("]","");
            palabra_bonita=palabra_bonita.replace(","," ");
            palabra_secreta.setText(palabra_bonita);
            if(ahorcado.palabra_completa()){
                mostrar_alerta("Ganaste!!","Otorgale un copete a la persona que quieras");
                baseJugador.modificarPuntaje(juego.getJugador().getNombre(), juego.getJugador().getPuntaje() + 1);
            }

        } else {
            estado_imagen = estado_imagen + 1;
            establecer_imagen(estado_imagen);
            if (estado_imagen == 6) {
                mostrar_alerta("Has perdido", "La palabra era "+ahorcado.palabra+". Debes tomar un sorbo");
            }

        }
    }
    public String rellenar_palabra(int largo){
        String[] vector_palabra ={};
        for (int i=0;i<largo;i++){
            vector_palabra[i]="_";
        }
        return vector_palabra.toString();
    }

    private void establecer_imagen (int estado){
        String nombre= "";

        switch (estado){
            case 1:
                nombre="ahorcadoinicial";
                break;
            case 2:
                nombre="ahorcadopiernas";
                break;
            case 3:
                nombre="ahorcadotronco";
                break;
            case 4:
                nombre="ahorcadobrazos";
                break;
            case 5:
                nombre="ahorcadocuello";
                break;
            case 6:
                nombre="ahorcadofinal";
                break;
        }

        int resId= getResources().getIdentifier(nombre,"mipmap",getPackageName() );
        imagen_ahorcado.setImageResource(resId);

       // System.out.println("nombre " + adivinaQuien.asignar_nombre());
    }

    private void mostrar_alerta(String titulo,String mensaje){

        AlertDialog.Builder builder = new AlertDialog.Builder(IJuegoAhorcado.this);
        builder.setMessage(mensaje)
                .setTitle(titulo)
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                                Intent nuevoform4 = new Intent(IJuegoAhorcado.this, IRuleta.class);
                                startActivity(nuevoform4);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
