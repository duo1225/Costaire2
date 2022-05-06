package com.example.costaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StatsActivity extends AppCompatActivity {
    TextView ressource;
    TextView total;
    TextView depense;
    Button ajouter;
    ListView listView;
    Button chooseDate;
    TextView date;

    String dateChoisir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        ressource = findViewById(R.id.ressourceText);
        total = findViewById(R.id.totalText);
        depense = findViewById(R.id.depenseText);
        listView = findViewById(R.id.listView);
        chooseDate = findViewById(R.id.chooseDate);
        date = (TextView) findViewById(R.id.date);

        //todo: ajouter adapter for listview

        ajouter = findViewById(R.id.ajouter);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatsActivity.this,DepenseRessourceActivity.class);
                startActivity(intent);
            }
        });

        // sans choisir, la date par default
        //todo ????
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH)+1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            String dateTime = year+"/"+month+"/"+day;
            System.out.println(dateTime);

        // get date chosen
        Intent intent = getIntent();
        //todo: need transfer to database
        dateChoisir = intent.getStringExtra("date");
        System.out.println("date chose"+dateChoisir);

        // afficher a date
        if(dateChoisir == null){
            date.setText(dateTime);
        }else{
            date.setText(dateChoisir);
        }

        // choose a new date
        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatsActivity.this,DatePickerActivity2.class);
                startActivityForResult(intent,0x11);
            }
        });


        //todo: refresh data with database


        String[] ctype = {"全部","图书","游戏","电视"};
        //listView adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, ctype);
        //connecter adapter avec listview
        listView.setAdapter(adapter);
    }
}