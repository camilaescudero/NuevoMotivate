package com.motivate.visual;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.motivate.nuevo.R;

/**
 * Created by Cami on 08-06-2015.
 */
public class Rotar_Ruleta extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intento);

        ImageView imagen = (ImageView)findViewById(R.id.imagenRuleta);
        Button boton= (Button)findViewById(R.id.btn_girar);;


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imagen = (ImageView)findViewById(R.id.imagenRuleta);
                Animation rota;
                rota = AnimationUtils.loadAnimation(Rotar_Ruleta.this, R.anim.rotacion);
                rota.reset();
                imagen.startAnimation(rota);
            }
        });


    }
}
