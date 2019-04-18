package com.example.astro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    private EditText name,password,college,phone,email;
    private Button signup,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        college=(EditText)findViewById(R.id.college);
        phone=(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.email);
        signup=(Button)findViewById(R.id.regsignup);
        login=(Button)findViewById(R.id.reglogin);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check())
                {
                    
                }
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
        String name1=name.getText().toString();
        String password1=password.getText().toString();
        String email1=email.getText().toString();
        String college1=college.getText().toString();
        String phone1=phone.getText().toString();
        if(name1.isEmpty() || phone1.isEmpty() || password1.isEmpty() || email1.isEmpty() || college1.isEmpty()){
            Toast.makeText(this,"Please enter the details",Toast.LENGTH_SHORT).show();return false;
        }
        else return true;
    }
}
