package com.example.proyectofinalap1chavez;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "usuarios.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_USERS = "usuarios";
    private static final String COL_ID = "id";
    private static final String COL_USERNAME = "usuario";
    private static final String COL_PASSWORD = "contrasenia";

    public AdminSQLiteOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_USERS + "(" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_USERNAME + " TEXT, " +
                COL_PASSWORD + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // Registro de usuario
    public boolean registrarUsuario(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_USERNAME, username);
        values.put(COL_PASSWORD, password);
        long result = db.insert(TABLE_USERS, null, values);
        return result != -1;
    }// Verificación de login

    public Cursor loginUsuario(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE usuario = ? AND contrasenia = ?", new String[]{username, password});
    }

    // Obtener datos por usuario
    public Cursor getUserioDatos(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE usuario = ?", new String[]{username});
    }

    // Modificar datos
    public boolean actualizarUsuario(String oldUsername, String newUsername, String newPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_USERNAME, newUsername);
        values.put(COL_PASSWORD, newPassword);
        int result = db.update(TABLE_USERS, values, "usuario = ?", new String[]{oldUsername});
        return result > 0;
    }

    // Eliminar usuario
    public boolean borrarUsuario(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_USERS, "usuario = ?", new String[]{username}) > 0;
    }

}
