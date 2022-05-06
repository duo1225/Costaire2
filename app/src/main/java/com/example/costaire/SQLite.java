package com.example.costaire;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.costaire.models.Utilisateur;

public class SQLite extends SQLiteOpenHelper {
    public static final String CREATE_DATABASE =
            "CREATE TABLE Utilisateur (numero INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, prenom TEXT,email TEXT,password TEXT);";

    public static final  String DROP_DATABASE = "DROP TABLE IF EXISTS Utilisateur";
    public static final String INSERT_DATABASE = "INSERT INTO Utilisateur(nom, prenom, email, password) VALUES ";
    public SQLite(Context context) {
        super(context, "costaire.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DROP_DATABASE);
        onCreate(db);
    }
    public void insertUtilisateur(Utilisateur utilisateur){
        String nom = utilisateur.getNom();
        String prenom = utilisateur.getPrenom();
        String email = utilisateur.getEmail();
        String password = utilisateur.getPassword();

        String insert = INSERT_DATABASE+"('"+nom +"','" + prenom +"', '" +email +"','" + password+"')";
        System.out.println("Insert语句 "+insert);
        System.out.println(insert);

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(insert);
    }

    public Boolean isConnect(String nom,String pwd){
        Utilisateur utilisateur = new Utilisateur();
        String selectQuery = "SELECT * FROM Utilisateur WHERE  nom = ?";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,new String[]{nom});

        if(cursor.moveToFirst()){
            @SuppressLint("Range")
            String password = cursor.getString(cursor.getColumnIndex("password"));
            if(password.equals(pwd)){
                return true;
            }
        }

        //db.close();
        return false;
    }

}