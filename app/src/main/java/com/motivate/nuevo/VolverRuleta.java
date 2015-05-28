package com.motivate.nuevo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Cami on 28-05-2015.
 */
public class VolverRuleta extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        ArrayList<String> jugadores = new ArrayList<String>();
        super.onCreate(savedInstanceState);

       /* Intent intent = getIntent();
        Bundle bundle2= intent.getExtras();

        jugadores = bundle2.getStringArrayList("j");
        int turn = bundle2.getInt("t");
        int punt = bundle2.getInt("p");
*/
        Bundle bundle = new Bundle();

        Intent nuevoform = new Intent(VolverRuleta.this,Ruleta.class);

        bundle.putStringArrayList("juegue", jugadores);
        bundle.putInt("turno",0);
        bundle.putInt("puntaje",0);
        nuevoform.putExtras(bundle);
        startActivity(nuevoform);

    }
}