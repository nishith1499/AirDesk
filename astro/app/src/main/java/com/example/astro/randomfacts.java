package com.example.astro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class randomfacts extends AppCompatActivity {
    TextView factbox;
    facts factholder=new facts();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomfacts);
        factbox=(TextView)findViewById(R.id.facttext);
    }

    public void genfact(View view) {
        factbox.setText(factholder.nextfact());

    }
}
