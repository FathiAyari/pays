package com.cyrine.pays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button signUpButton = findViewById(R.id.signup);
        EditText userName = findViewById(R.id.username);
        EditText  password = findViewById(R.id.password);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userName.getText().toString().isEmpty()){

                    Toast.makeText(SignUp.this, "Username can't be empty", Toast.LENGTH_SHORT).show();
                }else if(password.getText().toString().isEmpty()){
                    Toast.makeText(SignUp.this, "Password can't be empty", Toast.LENGTH_SHORT).show();
                }else{
                    UserDbHelper dbHelper = new UserDbHelper(SignUp.this);
                 boolean result=   dbHelper.insertData(userName.getText().toString(),password.getText().toString());
                    if(result){
                        Intent intent = new Intent(SignUp.this, Start.class);
                        startActivity(intent);
                    }

                }

            }
        });
    }
}