package com.example.astro;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;

public class library extends AppCompatActivity {
    ListView pdfListView;

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

    }
}
