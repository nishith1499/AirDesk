package com.example.astro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    private EditText name,password,college,phone,email,confirmpassword;
    private Button signup,login;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        db=new DatabaseHelper(this);
        name=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.regpassword);
        confirmpassword=(EditText)findViewById(R.id.confirm);
        college=(EditText)findViewById(R.id.college);
        phone=(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.email);
        signup=(Button)findViewById(R.id.regsignup);
        login=(Button)findViewById(R.id.reglogin);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup.this,login.class));
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(check())
                {
                    String name1=name.getText().toString().trim();
                    String password1=password.getText().toString().trim();
                    String password2=confirmpassword.getText().toString().trim();
                    String email1=email.getText().toString().trim();
                    String college1=college.getText().toString().trim();
                    String phone1=phone.getText().toString().trim();
                    if(password1.equals(password2)){
                        if(db.checkexist(email1)){
                            boolean i=db.insert(name1,password1,college1,phone1,email1);
                            if(i==true)
                            {Toast.makeText(getApplicationContext(),"Signup successful",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(signup.this,welcome.class));
                            }
                        }else
                            Toast.makeText(getApplicationContext(),"Email already exists",Toast.LENGTH_SHORT).show();

                    } else Toast.makeText(getApplicationContext(),"Passwords don't match",Toast.LENGTH_SHORT).show();

                }
            }});


    }
    

    private boolean check() {
        String name1=name.getText().toString();
        String password1=password.getText().toString();
        String email1=email.getText().toString();
        String college1=college.getText().toString();
        String phone1=phone.getText().toString();
        String password2=confirmpassword.getText().toString();
        if(name1.isEmpty() || phone1.isEmpty() || password1.isEmpty() || email1.isEmpty() || college1.isEmpty() || password2.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please enter the details",Toast.LENGTH_SHORT).show();return false;
        }
        else return true;
    }
}
