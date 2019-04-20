package com.example.astro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class pdfopener extends AppCompatActivity {
    PDFView pdfviewer;
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

    }
}
