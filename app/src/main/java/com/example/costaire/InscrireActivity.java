package com.example.costaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.costaire.models.Utilisateur;

public class InscrireActivity extends AppCompatActivity {

    Button insValider;
    EditText nom;
    EditText prenom;
    EditText email;
    EditText password;

    SQLite db = new SQLite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscrire);

        insValider = findViewById(R.id.InsValider);
        nom = findViewById(R.id.editNom);
        prenom = findViewById(R.id.editPrenom);
        email = findViewById(R.id.email);
        password = findViewById(R.id.editPass);



        insValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom_str = nom.getText().toString();
                String prenom_str = prenom.getText().toString();
                String email_str = email.getText().toString();
                String password_str = password.getText().toString();

                if(nom_str.equals("")||prenom_str.equals("")||email_str.equals("")||password_str.equals("")){
                    Toast.makeText(InscrireActivity.this,"No empty",Toast.LENGTH_SHORT).show();
                }else {
                    //TODO: 导入数据库
                    Utilisateur utilisateur = new Utilisateur();
                    utilisateur.setNom(nom_str);
                    utilisateur.setPrenom(prenom_str);
                    utilisateur.setEmail(email_str);
                    utilisateur.setPassword(password_str);

                    db.insertUtilisateur(utilisateur);

                    Intent intent = new Intent(InscrireActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}