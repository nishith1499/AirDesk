package com.example.astro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.RangeValueIterator;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class aboutus extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawerLayout;
    private Button ajeya,nishith,sudhanva,abhinav;
    private TextView details;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_aboutus);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ajeya = (Button)findViewById(R.id.ajeya);
        sudhanva = (Button)findViewById(R.id.sudhanva);
        abhinav = (Button)findViewById(R.id.abhinav);
        nishith = (Button)findViewById(R.id.nishith);
        details = (TextView)findViewById(R.id.details);

        ajeya.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                details.setText("AJEYA B.S: PES1201701604");
            }

        });

        sudhanva.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                details.setText("SUDHANVA SRINIVAS: PES1201700200");
            }

        });

        abhinav.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                details.setText("ABHINAV B.M: PES1201701500");
            }
        });

        nishith.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                details.setText("NISHITH VIHAR: PES1201701897");
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id=menuItem.getItemId();
        switch(id)
        {
            case R.id.nav_home:
                Intent home=new Intent(this,home.class);
                startActivity(home);
                break;
            case R.id.nav_library:
                Intent lib=new Intent(this,library.class);
                startActivity(lib);
                break;

            case R.id.nav_aboutus:

                break;
            case R.id.nav_todo:
                Intent to=new Intent(this,todo.class);
                startActivity(to);
                break;
            case R.id.nav_pdfopener:
                Intent pdf=new Intent(this,pdfopener.class);
                startActivity(pdf);
                break;
            case R.id.nav_randomfacts:
                Intent random=new Intent(this,randomfacts.class);
                startActivity(random);
                break;
            case R.id.nav_logout:
                Intent log=new Intent(this,login.class);
                SharedPreferences pref=getSharedPreferences("user_details",MODE_PRIVATE);
                SharedPreferences.Editor e=pref.edit();
                e.clear();

                e.apply();
                startActivity(log);
                break;
            default:break;
        }
        return false;
    }
}
