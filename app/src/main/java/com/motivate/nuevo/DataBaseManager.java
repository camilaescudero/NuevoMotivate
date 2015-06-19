package com.motivate.nuevo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Cami on 17-06-2015.
 */
public class DataBaseManager {
    public static final String TABLE_NAME= "jugadores";
    public static final String a_id = "_id";
    public static final String a_nombre= "nombre";
    public static final String a_puntaje = "puntaje";

    public DataBaseManager(DbHelper helper) {
        this.helper = helper;
    }

    public static final  String CREATE_TABLE ="create table "+ TABLE_NAME+" ("
            +a_id+ " integer primary key autoincrement,"
            +a_nombre+ " text not null,"
            +a_puntaje+ " text);";

    private DbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context) {
        helper =new DbHelper(context);
        db =helper.getWritableDatabase();
    }

    private ContentValues generarContentValues (String nomb, String punt){
        ContentValues valores = new ContentValues();
        valores.put(a_nombre,nomb);
        valores.put(a_puntaje,punt);
        return valores;
    }

    public void insertar(String nomb, String punt){
        db.insert(TABLE_NAME,null,generarContentValues(nomb,punt));
        //si devuelve menos uno hay problemas

    }
    public void insertar2(String nomb, String punt){
        db.execSQL("insert into "+TABLE_NAME+ "values (null,'"+nomb+"',"+punt+")");
    }
    public void eliminar( String nombre){
        db.delete(TABLE_NAME,a_nombre+"=?",new String[]{nombre});

    }
    public void modificarPuntaje(String nombre, String puntaje){
        db.update(TABLE_NAME,generarContentValues(nombre,puntaje),a_nombre+"=?",new String[]{nombre});
    }

   public Cursor cargarJugadores(){
       String[] columnas = new String[]{a_id,a_nombre,a_puntaje};
       return db.query(TABLE_NAME,columnas,null,null,null,null,null);
   }
}
