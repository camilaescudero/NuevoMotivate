package com.motivate.visual;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.motivate.nuevo.DataBaseJugador;
import com.motivate.nuevo.Jugador;
import com.motivate.nuevo.R;

import java.util.ArrayList;

/**
 *
 */
public class ISalon extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {

        StringBuilder mensaje = new StringBuilder();
        TextView textView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon);
     /*   ListView list;
        list=(ListView)findViewById(R.id.listView_salon);
        Cursor cursor;
        SimpleCursorAdapter adapter;

        DataBaseJugador baseJugador = new DataBaseJugador(this);

        String[] from= new String[]{baseJugador.a_nombre,baseJugador.a_puntaje};
        int[] to= new int[]{android.R.id.text1,android.R.id.text2};
        cursor= baseJugador.cargarJugadores();
        adapter = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,cursor,from,to,0);
        list.setAdapter(adapter);
*/
        ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
        Jugador jugador = new Jugador();
        int j, turno;

        DataBaseJugador manager = new DataBaseJugador(this);
        jugadors = manager.rescatarDatos();
        burbuja(jugadors);


        System.out.println("nombre de los jugadores");
        textView = (TextView) findViewById( R.id.textView_salonfama );
        for(int i=0;i<jugadors.size();i++){
            mensaje.append("\n");
            mensaje.append(jugadors.get(i).getNombre()+"\t \t \t : \t"+jugadors.get(i).getPuntaje());
            mensaje.append("\n");

            System.out.println(jugadors.get(i).getNombre());
        }
        textView.setText(mensaje);

    }

    public void burbuja(ArrayList<Jugador> juega) {
        int i, j, aux;

        for (i = 0; i < juega.size() - 1; i++){
            for (j = 0; j < juega.size() - i - 1; j++) {
                if (juega.get(j+1).getPuntaje() > juega.get(j).getPuntaje()) {
                    //aux=juega.get(j+1).getPuntaje();
                    Jugador jugador = new Jugador();
                    jugador.setNombre(juega.get(j + 1).getNombre());
                    jugador.setPuntaje(juega.get(j + 1).getPuntaje());
                    System.out.println(" BURBUJA ");
                    System.out.println(jugador.getNombre());
                    System.out.println(jugador.getPuntaje());
                    juega.set(j + 1, juega.get(j));
                    //jugador.setPuntaje(aux);
                    juega.set(j, jugador);

                }
            }
        }
        StringBuilder mensaje = new StringBuilder();
        TextView textView;

    }
}
