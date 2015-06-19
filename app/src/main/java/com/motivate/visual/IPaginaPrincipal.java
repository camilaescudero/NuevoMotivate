package com.motivate.visual;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.motivate.nuevo.DataBaseManager;
import com.motivate.nuevo.R;


public class IPaginaPrincipal extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);
        ListView list;
        list=(ListView)findViewById(R.id.listView_prueba_rescata);
        Cursor cursor;
        SimpleCursorAdapter adapter;
        //crea la base de datos
        DataBaseManager manager =new DataBaseManager(this);

        /*manager.insertar("cami","0");
        manager.insertar("mari","0");
        manager.insertar("angie","0");*/
        String[] from= new String[]{manager.a_nombre,manager.a_puntaje};
        int[] to= new int[]{android.R.id.text1,android.R.id.text2};

        cursor= manager.cargarJugadores();
        adapter = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,cursor,from,to,0);
        list.setAdapter(adapter);


        Button boton = (Button)findViewById(R.id.btn_nuevapartida);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoform = new Intent(IPaginaPrincipal.this,IJugadorEstandar.class);
                startActivity(nuevoform);
            }
        });

        Button botonRegla = (Button)findViewById(R.id.btn_reglas);
        botonRegla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoform3 = new Intent(IPaginaPrincipal.this,IReglas.class);
                startActivity(nuevoform3);
            }
        });

        Button boton4 = (Button)findViewById(R.id.btn_salon);
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoform4 = new Intent(IPaginaPrincipal.this,ISalon.class);
                startActivity(nuevoform4);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pagina_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
