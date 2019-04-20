package com.example.astro;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;

public class pdfopener extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    PDFView pdfviewer;
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopener);
        pdfviewer=(PDFView)findViewById(R.id.pdfViewer);
        String getItem=getIntent().getStringExtra("pdfFileName");
        if(getItem.equals("Android Book")){
            pdfviewer.fromAsset("Android Book.pdf").load();

        }

        if(getItem.equals("MPCA-1")){
            pdfviewer.fromAsset("Arm System-On-Chip Architecture.pdf").load();

        }

        if(getItem.equals("MPCA-2")){
            pdfviewer.fromAsset("ARM_System_Developers_Guide-Designing_and_Optimizing_System_Software.pdf").load();

        }

        if(getItem.equals("MPCA-3")){
            pdfviewer.fromAsset("Computer_Organization_and_Design_By_David_Patterson_5th_ed.pdf").load();

        }

        if(getItem.equals("MPCA-4")){
            pdfviewer.fromAsset("Computer-Organization-by-Carl-Hamacher-5th.pdf").load();

        }

        if(getItem.equals("Database Management Systems")){
            pdfviewer.fromAsset(".pdf").load();

        }

        if(getItem.equals("Design and analysis of algorithms")){
            pdfviewer.fromAsset("Introduction to the Design and Analysis of Algorithms - FTP Directory  ( PDFDrive.com ).pdf").load();

        }

        if(getItem.equals("Linear Algebra")){
            pdfviewer.fromAsset("Linear algebra and its applications.pdf").load();

        }
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_pdfopener);
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

                break;
            default:break;
        }
        return false;
    }
}
