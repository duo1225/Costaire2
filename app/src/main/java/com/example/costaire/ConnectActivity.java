package com.example.costaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConnectActivity extends AppCompatActivity {

    Button conValider;
    EditText nom;
    EditText password;
    SQLite db = new SQLite(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        conValider = findViewById(R.id.ConValider);
        nom = findViewById(R.id.editNomCon);
        password = findViewById(R.id.editPsd);


        conValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom_str = nom.getText().toString();
                String pwd_str = password.getText().toString();

                //todo:
                /*
                if(nom_str != null && pwd_str !=null){
                    //success
                    System.out.println("connection nom "+nom_str+"pwd"+pwd_str);
                    if(db.isConnect(nom_str,pwd_str)){
                        Intent intent = new Intent(ConnectActivity.this,StatsActivity.class);
                        intent.putExtra("nom",nom_str);
                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(ConnectActivity.this, "Not correct, please retry!", Toast.LENGTH_SHORT).show();
                }
*/
                Intent intent = new Intent(ConnectActivity.this,StatsActivity.class);
                startActivity(intent);
            }
        });
    }
}