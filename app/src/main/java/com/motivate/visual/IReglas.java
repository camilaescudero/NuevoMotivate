package com.motivate.visual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.motivate.nuevo.R;

/**
 * Created by María Elizabeth on 23-05-2015.
 */
public class IReglas extends ActionBarActivity implements ListView.OnItemClickListener, View.OnClickListener {
    private ListView lv_juegos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reglas);
        lv_juegos= (ListView)findViewById(R.id.list_juegos);//lv_juegos?
        String juegosxml[]=getResources().getStringArray(R.array.juegos);
        ArrayAdapter<String> adaptador= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,juegosxml);
        lv_juegos.setOnItemClickListener(this);
        lv_juegos.setAdapter(adaptador);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
        String valor= (String) adapterView.getItemAtPosition(posicion);
        Intent nuevoform= new Intent(IReglas.this,IReglaJuegoX.class);
        nuevoform.putExtra("Juego", valor);
        startActivity(nuevoform);


    }

    @Override
    public void onClick(View view) {

    }


}

