package com.example.astro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity {
    private EditText name,password,college,phone,email;
    private Button signup,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=(EditText)findViewById(R.id.);
        password=(EditText)findViewById(R.id.);
        college=(EditText)findViewById(R.id.);
        phone=(EditText)findViewById(R.id.);
        email=(EditText)findViewById(R.id.);
        signup=(Button)findViewById(R.id.);
        login=(Button)findViewById(R.id.);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                startActivity(new Intent(signup.this,welcome.class));

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup.this,login.class));
            }
        });
    }

    private Boolean check(){
        Boolean result=false;
        String name1=name.getText().toString();
        String password1=password.getText().toString();
    }
}
