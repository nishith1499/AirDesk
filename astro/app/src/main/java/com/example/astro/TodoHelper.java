package com.example.astro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class TodoHelper extends SQLiteOpenHelper {

    public TodoHelper( Context context) {
        super(context,"Workflow.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS task (id int primary key not null , email varchar(20) not null, taskname varchar(100) not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS task ");
        onCreate(db);
    }

    public void inserttask(String task,String email){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues v=new ContentValues();
        v.put("taskname",task);
        v.put("email",email);
        db.insertWithOnConflict("task",null,v,SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public void deletetask(String task){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("task","taskname=?",new String[]{task});
        db.close();
    }

    public ArrayList<String> gettasklist(String email){
        ArrayList<String> tasklist=new ArrayList<>();
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM task WHERE email=?",new String[]{email});
        while(cursor.moveToNext()){
            int index=cursor.getColumnIndex("taskname");
            tasklist.add(cursor.getString(index));
        }
        db.close();
        return tasklist;

    }


}

