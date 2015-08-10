package com.motivate.nuevo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cami on 29-06-2015.
 */
public class DbHelperJuego  extends SQLiteOpenHelper {
    private static final String DB_NAME ="juego.sqlite";
    private static final int DB_SCHEME_VERSION =1;
    public DbHelperJuego(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DataBaseJuego.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
