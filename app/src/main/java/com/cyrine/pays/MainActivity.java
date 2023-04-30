package com.cyrine.pays;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton = findViewById(R.id.login);
        Button signUpButton = findViewById(R.id.signup1);
        EditText userName = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        UserDbHelper dbHelper = new UserDbHelper(MainActivity.this);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().isEmpty()) {

                    Toast.makeText(MainActivity.this, "Username can't be empty", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Password can't be empty", Toast.LENGTH_SHORT).show();
                } else {
                    boolean result =dbHelper.login(userName.getText().toString(), password.getText().toString());
                    if(result){
                        Intent intent = new Intent(MainActivity.this, Start.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "There is no user with this data", Toast.LENGTH_SHORT).show();

                    }
                }


            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });


    }
}