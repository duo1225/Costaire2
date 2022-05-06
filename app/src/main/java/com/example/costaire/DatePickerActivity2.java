package com.example.costaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DatePickerActivity2 extends AppCompatActivity {

    int year, month,day;
    DatePicker datePicker;
    Button validerDate;
    String dateChoisir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker2);

        datePicker = findViewById(R.id.datepicker2);
        validerDate = findViewById(R.id.validerDate2);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        //initialise datepicker
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                year = i;
                month = i1+1;
                day = i2;
                dateChoisir = year+"/"+month+"/"+day;
                show(year,month,day);
            }
        });

        validerDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DatePickerActivity2.this,StatsActivity.class);
                intent.putExtra("date",dateChoisir);
                startActivity(intent);
            }
        });
    }

    private void show(int year,int month,int day){
        String str = year+"/"+month+"/"+day;
        Toast.makeText(DatePickerActivity2.this, str, Toast.LENGTH_SHORT).show();
    }
}