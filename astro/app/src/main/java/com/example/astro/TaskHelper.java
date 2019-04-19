package com.example.astro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskHelper extends SQLiteOpenHelper {

    public TaskHelper(Context context) {
        super(context, "Workflow.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "Create Table tasks (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL,email varchar(20) NOT NULL);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tasks" );
        onCreate(db);
    }
}
