package com.example.astro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private EditText name,password,email;
    private Button login,signup;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new DatabaseHelper(this);
        name=(EditText)findViewById(R.id.username1);
        password=(EditText)findViewById(R.id.password1);

        email= (EditText) findViewById(R.id.email1);
        login=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.signup);
        final String emailx=email.getText().toString();



        SQLiteDatabase d=db.getWritableDatabase();
        Cursor c=d.rawQuery("SELECT * FROM users WHERE email=?",new String[]{emailx});
        final String coll=c.getString(2);
        String namex=c.getString(0);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean check= db.checklogin(name.getText().toString(),password.getText().toString());
               if(check==true){
                   SharedPreferences pref=getSharedPreferences("user_details",MODE_PRIVATE);
                   SharedPreferences.Editor e=pref.edit();
                   e.putString("name",name.getText().toString());
                   e.putString("email",email.getText().toString());
                   e.putString("college",coll);
                   e.apply();
                   Toast.makeText(getApplicationContext(),"Login successful",Toast.LENGTH_SHORT).show();
                   startActivity(new Intent(login.this,home.class));

               }
               else
                   Toast.makeText(getApplicationContext(),"Name or password invalid",Toast.LENGTH_SHORT).show();
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


}
