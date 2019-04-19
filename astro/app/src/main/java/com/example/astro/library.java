package com.example.astro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class library extends AppCompatActivity {
    ListView pdfListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        pdfListView=(ListView)findViewById(R.id.PDFList);
        String[] pdfFiles={"Android book","MPCA-1","MPCA-2","MPCA-3","MPCA-4","Database Management Systems","Design and analysis of algorithms",
        "Linear Algebra"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
    }
}
