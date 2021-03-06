package com.example.astro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class randomfacts extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    TextView factbox;
    facts factholder=new facts();
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomfacts);
        factbox=(TextView)findViewById(R.id.facttext);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_randomfacts);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void genfact(View view) {
        factbox.setText(factholder.nextfact());



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
                case R.id.nav_randomfacts:

                    break;
                case R.id.nav_library:
                    Intent lib=new Intent(this,library.class);
                    startActivity(lib);
                    break;

                case R.id.nav_aboutus:
                    Intent abt=new Intent(this,aboutus.class);
                    startActivity(abt);
                    break;
                case R.id.nav_todo:
                    Intent to=new Intent(this,todo.class);
                    startActivity(to);
                    break;
                case R.id.nav_pdfopener:
                    Intent pdf=new Intent(this,pdfopener.class);
                    startActivity(pdf);
                    break;
                case R.id.nav_home:
                    Intent home=new Intent(this,library.class);
                    startActivity(home);
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
