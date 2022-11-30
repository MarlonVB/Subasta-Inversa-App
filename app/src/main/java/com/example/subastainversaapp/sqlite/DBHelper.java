package com.example.subastainversaapp.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NOMBRE= "SUBASTA_APP";
    private static final String TABLA_REGISTRO_PROVEEDOR ="t_registro_cliente";
    private static final String TABLA_USUARIO  ="t_usuario";
    private static final String TABLA_OFERTA  ="t_oferta";
    private static final String TABLA_SUBASTA  ="t_subasta";
    private static final String TABLA_NOTIFICACIONES  ="t_notificaciones";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+ TABLA_REGISTRO_PROVEEDOR+" ("+
                "id_persona INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT NOT NULL, "+
                "apellido TEXT NOT NULL, "+
                "email TEXT NOT NULL, "+
                "telefono TEXT NOT NULL, "+
                "direccion TEXT NOT NULL, "+
                "contrasenia TEXT NOT NULL," +
                "id_usuario TEXT NOT NULL);");

        db.execSQL("CREATE TABLE "+ TABLA_USUARIO+" ("+
                "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre_usuario TEXT NOT NULL, "+ //Viene de la API usaremos en ls filtros
                "contrasenia_usuario TEXT NOT NULL);");

        db.execSQL("CREATE TABLE "+ TABLA_SUBASTA+" ("+
                "id_sub INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "id_subasta TEXT NOT NULL, "+ //Viene de la API usaremos en ls filtros
                "fechaInicio TEXT NOT NULL, "+
                "fechaFin TEXT NOT NULL, "+
                "estadoSubasta TEXT NOT NULL, "+
                "descripcionSubasta TEXT NOT NULL, "+
                "imgSubasta TEXT NOT NULL);");

        db.execSQL("CREATE TABLE "+ TABLA_OFERTA+" ("+
                "id_ofe INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "idOferta INTEGER ,"+
                "percioOferta REAL NOT NULL, "+
                "calificacion INTEGER NOT NULL, "+
                "fecha TEXT NOT NULL, "+
                "descripcion_oferta TEXT NOT NULL, "+
                "estado TEXT NOT NULL);");

        db.execSQL("CREATE TABLE "+ TABLA_NOTIFICACIONES+" ("+
                "id_not INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "id_usuario INTEGER NOT NULL,"+
                "mensaje_principal TEXT NOT NULL,"+
                "mesnaje_Secundario TEXT NOT NULL, "+
                "FOREIGN KEY(id_usuario) REFERENCES "+TABLA_USUARIO+"(id_usuario));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+ TABLA_REGISTRO_PROVEEDOR);
        db.execSQL("DROP TABLE "+ TABLA_USUARIO);
        db.execSQL("DROP TABLE "+ TABLA_OFERTA);
        db.execSQL("DROP TABLE "+ TABLA_SUBASTA);
        db.execSQL("DROP TABLE "+ TABLA_NOTIFICACIONES);
        onCreate(db);
    }

}
