package com.example.costaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EnterDataRessourceActivity extends AppCompatActivity {

    Spinner spinner;
    EditText mount;
    Button valider;
    TextView date;
    TextView dateAfficher;

    String dateChoisir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data_ressource);

        String[] strings = {"Salaire", "Invertissement"};

        spinner = findViewById(R.id.spinnerRes);
        mount = findViewById(R.id.mountRes);
        valider = findViewById(R.id.validerRes);
        date = findViewById(R.id.dateRes);
        dateAfficher = findViewById(R.id.dateAfficherRes);

        // spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_list, strings);

        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(EnterDataRessourceActivity.this, str, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // choose a date
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnterDataRessourceActivity.this,DatePickerActivity.class);
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
                Intent intent = new Intent(EnterDataRessourceActivity.this,StatsActivity.class);
                startActivity(intent);
            }
        });

    }

}