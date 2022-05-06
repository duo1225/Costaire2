package com.example.costaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class DepenseRessourceActivity extends AppCompatActivity {
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depense_ressource);

        tabHost = findViewById(android.R.id.tabhost);
        //initialiser
        tabHost.setup();

        //ajouter
        LayoutInflater inflater = LayoutInflater.from(this);
        //动态载入XML, 不需要Activity
        inflater.inflate(R.layout.activity_enter_data_ressource,tabHost.getTabContentView());
        inflater.inflate(R.layout.activity_enter_data,tabHost.getTabContentView());

        tabHost.addTab(tabHost.newTabSpec("ressource").setIndicator("Ressource").setContent(R.id.left));
        tabHost.addTab(tabHost.newTabSpec("depense").setIndicator("Depense").setContent(R.id.right));



    }
}