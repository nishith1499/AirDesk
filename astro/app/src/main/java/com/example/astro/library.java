package com.example.astro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;

public class library extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ListView pdfListView;
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        pdfListView = (ListView) findViewById(R.id.PDFList);
        String[] pdfFiles = {"Android book", "MPCA-1", "MPCA-2", "MPCA-3", "MPCA-4", "Database Management Systems", "Design and analysis of algorithms",
                "Linear Algebra"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pdfFiles) {

            @Nullable
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                return view;
            }

        };

        pdfListView.setAdapter(adapter);

        pdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item=pdfListView.getItemAtPosition(position).toString();
                Intent i =new Intent(getApplicationContext(),pdfopener.class);
                i.putExtra("pdfFileName",item);
                startActivity(i);
            }
        });



        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_library);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
