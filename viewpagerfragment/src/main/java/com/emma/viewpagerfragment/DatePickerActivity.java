package com.emma.viewpagerfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity {

    int year, month,day;
    DatePicker datePicker;
    Button validerDate;
    String dateChoisir;
    String fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        datePicker = findViewById(R.id.datepicker);
        validerDate = findViewById(R.id.validerDate);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        // recevoir le nom de fragment
        Intent intentFromFragment = getIntent();
        fragment = intentFromFragment.getStringExtra("fragment");

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
                //todo：
                Intent intent = new Intent(DatePickerActivity.this,MainActivity.class);
                intent.putExtra("date",dateChoisir);
                intent.putExtra("fragment",fragment);
                startActivity(intent);
            }
        });
    }

    private void show(int year,int month,int day){
        String str = year+"/"+month+"/"+day;
        Toast.makeText(DatePickerActivity.this, str, Toast.LENGTH_SHORT).show();
    }
}