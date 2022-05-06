package com.example.costaire;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.eap.EapSessionConfig;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Enter_data extends AppCompatActivity {
    Spinner spinner;
    EditText mount;
    Button valider;
    TextView date;
    TextView dateAfficher;

    String dateChoisir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);

        String[] strings = {"General", "Restaurant", "Supermarche", "Assurance", "Loisir"};

        spinner = findViewById(R.id.spinner);
        mount = findViewById(R.id.mount);
        valider = findViewById(R.id.valider);
        date = findViewById(R.id.date);
        dateAfficher = findViewById(R.id.dateAfficher);

        // spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_list, strings);

        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Enter_data.this, str, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // choose a date
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Enter_data.this,DatePickerActivity.class);
                startActivityForResult(intent,0x11);
            }
        });

        // get date chosen
        Intent intent = getIntent();
        dateChoisir = intent.getStringExtra("date");
        System.out.println("date chose"+dateChoisir);
        // afficher a date
        dateAfficher.setText(dateChoisir);

        //valider le page
        // inserer dans la database --- todo
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Enter_data.this,StatsActivity.class);
                startActivity(intent);
            }
        });

    }


}