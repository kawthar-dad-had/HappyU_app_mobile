package com.example.happyuapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "login.db";
    public static final int DATABASE_VERSION = 1;

    // Table pour stocker les comptes
    public static final String TABLE_COMPTES = "comptes";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";

    // Requête SQL pour créer la table des comptes
    private static final String CREATE_COMPTES_TABLE = "CREATE TABLE " + TABLE_COMPTES + " (" +
            COLUMN_EMAIL + " TEXT PRIMARY KEY, " +
            COLUMN_PASSWORD + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_COMPTES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPTES);
        onCreate(db);
    }

    // Méthode pour insérer un compte dans la table des comptes
    public boolean insertCompte(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_PASSWORD, password);
        long result = db.insert(TABLE_COMPTES, null, contentValues);
        return result != -1;
    }

    // Méthode pour vérifier les informations de connexion
    public boolean checkLoginCredentials(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                COLUMN_EMAIL,
                COLUMN_PASSWORD
        };

        String selection = COLUMN_EMAIL + " = ? AND " +
                COLUMN_PASSWORD + " = ?";

        String[] selectionArgs = {email, password};

        Cursor cursor = db.query(
                TABLE_COMPTES,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        boolean isValid = cursor.getCount() > 0;

        cursor.close();
        db.close();

        return isValid;
    }
}