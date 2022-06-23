package com.meyfandi.faceimage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Login extends AppCompatActivity {
    String username="admin";
    String password ="admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText txtUser =findViewById(R.id.username);
        EditText txtpass = findViewById(R.id.password);
        Button login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtUser.getText().toString().equalsIgnoreCase(username)&&txtpass.getText().toString().equalsIgnoreCase(password)){
                    startActivity(new Intent(Login.this,Menu.class));

                }else{
                    Toast.makeText(Login.this,"username/password",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}