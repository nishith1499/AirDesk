package com.example.astro;


import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button write;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MediaPlayer player;
    private EditText title,description;
    Homehelper community;
    SharedPreferences pref=getSharedPreferences("user_details",MODE_PRIVATE);
    String username=pref.getString("name",null);
    String coll=pref.getString("college",null);
    ScrollView read;
    private ArrayAdapter<String> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_home);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        title=(EditText)findViewById(R.id.titlecomm);
        description=(EditText)findViewById(R.id.descriptioncomm);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        write=(Button)findViewById(R.id.writecomment);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean i= (boolean) community.insert(username,coll,title.getText().toString(),description.getText().toString());

                if(i==true)

                    Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_SHORT).show();
            else
                    Toast.makeText(getApplicationContext(),"Not inserted",Toast.LENGTH_SHORT).show();

        }});

        read=(ScrollView)findViewById(R.id.scroll);

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
                break;
            case R.id.nav_library:
                Intent lib=new Intent(this,library.class);
                startActivity(lib);
                break;
            case R.id.nav_playmusic:
                Intent music=new Intent(this,PlayMusic.class);
                startActivity(music);
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
