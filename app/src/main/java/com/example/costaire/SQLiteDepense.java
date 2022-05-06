package com.example.costaire;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.costaire.models.Depense;

import java.util.ArrayList;
import java.util.List;

public class SQLiteDepense extends SQLiteOpenHelper {
    public static final String CREATE_DATABASE =
            "CREATE TABLE Depense (id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, total INTEGER,date TEXT);";

    public static final  String DROP_DATABASE = "DROP TABLE IF EXISTS Depense";
    public static final String INSERT_DATABASE = "INSERT INTO Depense(nom, total, date) VALUES ";

    public SQLiteDepense(Context context) {
        super(context, "costaire.db", null, 1);
    }

    public SQLiteDepense(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DROP_DATABASE);
        onCreate(db);
    }
    //search data with date
    public List<Depense> search(){
        List<Depense> list = new ArrayList<>();
        //todo

        return list;

    }
    //inserer
    public void insert(Depense depense){

    }
}
