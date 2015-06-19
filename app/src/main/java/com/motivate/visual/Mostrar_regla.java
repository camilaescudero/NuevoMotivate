package com.motivate.visual;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.motivate.nuevo.R;

/**
 * Created by María Elizabeth on 24-05-2015.
 */
public class Mostrar_regla extends ActionBarActivity {
    private TextView txt_nombreregla, txt_descripcionregla;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_regla);
        txt_nombreregla=(TextView)findViewById(R.id.txt_nombreregla);
        txt_descripcionregla=(TextView)findViewById(R.id.txt_descripcionregla);
        Bundle parametros= getIntent().getExtras();
        if (parametros != null){
            txt_nombreregla.setText(parametros.getString("Juego"));
            String nombre= txt_nombreregla.getText().toString();
            System.out.println(nombre);
            switch (nombre){
                case "El ahorcado":
                    txt_descripcionregla.setText(R.string.regla_elahorcado);
                    break;
                case "Bachillerato":
                    txt_descripcionregla.setText(R.string.regla_bachillerato);
                    break;
                case "No digas si, no digas no":
                    txt_descripcionregla.setText(R.string.regla_nodigassi);
                    break;
                case "Memorice":
                    txt_descripcionregla.setText(R.string.regla_memorice);
                    System.out.println(nombre);
                    break;
                case "Cante la palabra":
                    txt_descripcionregla.setText(R.string.regla_cantelapalabra);
                    break;
                case "El gato (desafio)":
                    txt_descripcionregla.setText(R.string.regla_elgato);
                    break;
                case "Secuencia de colores":
                    txt_descripcionregla.setText(R.string.regla_secuenciacolores);
                    break;
                case "Coloque la pieza en su lugar":
                    txt_descripcionregla.setText(R.string.regla_coloquepieza);
                    break;
                case "Mimica":
                    txt_descripcionregla.setText(R.string.regla_mimica);
                    break;
                case "Pregunta y respuesta":
                    txt_descripcionregla.setText(R.string.regla_preguntayrespuesta);
                    break;
                case "La ronda":
                    txt_descripcionregla.setText(R.string.regla_laronda);
                    break;
                case "Adivina quien":
                    txt_descripcionregla.setText(R.string.regla_adivinaquien);
                    break;
                case "Tabu":
                    txt_descripcionregla.setText(R.string.regla_tabu);
                    break;
                default:txt_descripcionregla.setText(nombre);

            }
        }
    }
}
