package com.motivate.nuevo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Cami on 17-06-2015.
 */
public class DataBaseJugador {
    public static final String TABLE_NAME= "jugadores";
    public static final String a_id = "_id";
    public static final String a_nombre= "nombre";
    public static final String a_puntaje = "puntaje";

    public DataBaseJugador(DbHelper helper) {
        this.helper = helper;
    }

    public static final  String CREATE_TABLE ="create table "+ TABLE_NAME+" ("
            +a_id+ " integer primary key autoincrement,"
            +a_nombre+ " text not null,"
            +a_puntaje+ " integer);";

    private DbHelper helper;
    private SQLiteDatabase db;

    public DataBaseJugador(Context context) {
        helper =new DbHelper(context);
        //db =helper.getWritableDatabase();
    }

    private ContentValues generarContentValues (String nomb, int punt){
        ContentValues valores = new ContentValues();
        valores.put(a_nombre,nomb);
        valores.put(a_puntaje,punt);
        return valores;
    }

    public void insertar(ArrayList<Jugador> jugadors){
        db =helper.getWritableDatabase();
        System.out.println("Dentro del insetar");
        for (int i =0;i<jugadors.size();i++){
            System.out.println("nombre: "+jugadors.get(i).getNombre()+"puntaje"+jugadors.get(i).getPuntaje());
            db.insert(TABLE_NAME, null, generarContentValues(jugadors.get(i).getNombre(), jugadors.get(i).getPuntaje()));
        }
        //db.insert(TABLE_NAME,null,generarContentValues(nomb,punt));
        //si devuelve menos uno si es que hay problemas

    }
    public void insertar2(String nomb, String punt){
        db.execSQL("insert into "+TABLE_NAME+ "values (null,'"+nomb+"',"+punt+")");
    }
    public void eliminar( ArrayList<Jugador> jugadors){
        db =helper.getWritableDatabase();
        for (int i =0;i<jugadors.size();i++) {
            db.delete(TABLE_NAME, a_nombre + "=?", new String[]{jugadors.get(i).getNombre()});
        }
    }
    public void modificarPuntaje(String nombre, int puntaje){
        db =helper.getWritableDatabase();
        db.update(TABLE_NAME,generarContentValues(nombre,puntaje),a_nombre+"=?",new String[]{nombre});
    }

   public Cursor cargarJugadores(){
       db =helper.getWritableDatabase();
       String[] columnas = new String[]{a_id,a_nombre,a_puntaje};

       return db.query(TABLE_NAME,columnas,null,null,null,null,null);
   }

    public ArrayList<Jugador> rescatarDatos(){
        db =helper.getReadableDatabase();
        ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
        if(db!=null){
            Cursor c= db.rawQuery("select * from jugadores",null);
            int cantidad =c.getCount();
            int i=0;
            String[] arreglo = new String[cantidad];
            if(c.moveToFirst()){
                do{
                   // String linea = c.getInt(0)+" "+ c.getString(1)+" "+ c.getString(2);
                    jugadors.add(new Jugador(c.getInt(0),c.getString(1),c.getInt(2) ));
                }while (c.moveToNext());
            }
        }
        return jugadors;
    }



}
