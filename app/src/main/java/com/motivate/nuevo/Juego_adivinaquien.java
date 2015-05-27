package com.motivate.nuevo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by María Elizabeth on 26-05-2015.
 */
public class Juego_adivinaquien extends ActionBarActivity {
    private String[] nombre_personaje={"angelina_jolie","caua_raymond","jennifer_lopez", "johnny_depp","lindsay_lohan", "paul_walker",
            "vin_diesel","zac_efron"};
    private int intentos = 3;
    private Button aceptar;
    private TextView mensaje_intentos;
    private EditText usuario_personaje;
    private int numero_generado=0;
    private ImageView img_personaje;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivinaquien);
        aceptar=(Button)findViewById(R.id.btn_aceptar);
        mensaje_intentos= (TextView)findViewById(R.id.lbl_intentos);
        usuario_personaje=(EditText)findViewById(R.id.txt_personaje);
        img_personaje=(ImageView)findViewById(R.id.imageView);
        numero_generado=generar_aleatorio();
        establecer_imagen(numero_generado);
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

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre= usuario_personaje.getText().toString().toLowerCase();
                if (nombre.equals(nombre_personaje[numero_generado])){
                    AlertDialog.Builder builder= new AlertDialog.Builder(Juego_adivinaquien.this);
                    builder.setMessage("Correcto ! ganaste 1 punto")
                            .setTitle("Correcto")
                            .setCancelable(false)
                            .setNeutralButton("Aceptar",
                                    new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    }
                            );
                }else {
                    intentos = intentos - 1;
                    if (intentos <= 0) {
                        mensaje_intentos.setText("PERDISTE!!");

                    } else {
                        mensaje_intentos.setText("Tiene" + intentos + " intentos");
                    }

                }
            }
        });
    }
    private void establecer_imagen (int numero){
        int resId= getResources().getIdentifier(nombre_personaje[numero],"mipmap",getPackageName() );
        img_personaje.setImageResource(resId);
    }
    private int generar_aleatorio(){
        return (int) (Math.random()*nombre_personaje.length);
    }
}
