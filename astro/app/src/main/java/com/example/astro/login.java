package com.example.astro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {
    private EditText name,password;
    private Button login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(name.getText().toString(),password.getText().toString());
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(login.this,signup.class);
                startActivity(j);
            }
        });

    }

    private void check(String name, String password)
    {
        if(name.equals()&& password.equals()){
            Intent i=new Intent(login.this,home.class);
            startActivity(i);
        }
    }
}
