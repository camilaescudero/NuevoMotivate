package com.motivate.nuevo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Cami on 29-06-2015.
 */
public class DataBaseJuego {
    public static final String TABLE_NAME= "juego";
    public static final String a_id = "_id";
    public static final String a_turno = "turno";
    public DataBaseJuego(DbHelperJuego helperJuego) {

        this.helperJuego= helperJuego;
    }

    public static final  String CREATE_TABLE ="create table "+ TABLE_NAME+" ("
            +a_id+ " integer primary key autoincrement,"
            +a_turno+ " integer);";


    private DbHelperJuego helperJuego;
    private SQLiteDatabase db;
    public DataBaseJuego(Context context) {
        helperJuego =new DbHelperJuego(context);
        //db =helper.getWritableDatabase();
    }

    private ContentValues generarContentValues (int turno){
        ContentValues valores = new ContentValues();
        valores.put(a_turno,turno);
        return valores;
    }

    public void insertar(int turno){

           db = helperJuego.getWritableDatabase();
           db.insert(TABLE_NAME, null, generarContentValues(turno));

    }

    public void modificarTurno(int id, int turno, int largo){
        if(turno==largo){
            turno=0;
        }

        String busca = Integer.toString(id);
        db =helperJuego.getWritableDatabase();
        db.update(TABLE_NAME,generarContentValues(turno),a_id+"=?",new String[]{busca});
    }
    public void eliminar(int id){
        String id_= Integer.toString(id);
        db =helperJuego.getWritableDatabase();
        db.delete(TABLE_NAME, a_id + "=?", new String[]{id_});
        System.out.println("a_id" + a_id + "\n\n" + "id_" + id_ + "\n\nid" + id);

    }
    public int rescatarDatos(){
        db =helperJuego.getReadableDatabase();
        int linea=0;
        if(db!=null){
            Cursor c= db.rawQuery("select * from juego",null);
            int cantidad =c.getCount();
            int i=0;

            String[] arreglo = new String[cantidad];
            if(c.moveToFirst()){
                do{
                    linea = c.getInt(1);

                }while (c.moveToNext());
            }
        }
        return linea;
    }

    public int devuelveId(){
        db =helperJuego.getReadableDatabase();
        int linea=0;
        if(db!=null){
            Cursor c= db.rawQuery("select * from juego",null);
            int cantidad =c.getCount();
            int i=0;

            String[] arreglo = new String[cantidad];
            if(c.moveToFirst()){
                do{
                    linea = c.getInt(0);

                }while (c.moveToNext());
            }
        }
        return linea;
    }
}
