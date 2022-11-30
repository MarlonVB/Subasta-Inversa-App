package com.example.subastainversaapp.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

public class SearchDBHelper extends DBHelper{


    Context context;

    public SearchDBHelper(@Nullable @org.jetbrains.annotations.Nullable Context context) {
        super(context);
        this.context=context;
    }

    public Cursor consultar (String nombre){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "Select * from t_usuario";
        String[] selectionArgs = null;
        if (nombre != null) {
            sql += " where name LIKE '%' || ? || '%'";
            selectionArgs = new String[] {nombre};
        }
        return db.rawQuery(sql, selectionArgs);
    }
    public Cursor consultarProveedor (String id_persona){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "Select * from t_registro_proveedor";
        String[] selectionArgs = null;
        if (id_persona != null) {
            sql += " where name LIKE '%' || ? || '%'";
            selectionArgs = new String[] {id_persona};
        }
        return db.rawQuery(sql, selectionArgs);
    }
}
