package com.example.astro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Homehelper extends SQLiteOpenHelper {

    public Homehelper( Context context) {
        super(context,"Workflow.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE community (id primary key autoincrement, name varchar(20) not null,college varchar(20) not null,title varchar(20)not null,desscription text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS community ");
        onCreate(db);
    }

    public boolean insert(String name,String college,String title, String description){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("name",name);
        c.put("college",college);
        c.put("title",title);
        c.put("description",description);
        long i=db.insert("community",null,c);
        if (i==-1) return false;
        else return true;
    }

    public ArrayList<String> getcomment(){
        ArrayList<String> tasklist=new ArrayList<>();
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor= (Cursor) db.rawQuery("SELECT * FROM community;",new String[]{});
        while(cursor.moveToNext()){
            int index=cursor.getColumnIndex("name");
            tasklist.add(cursor.getString(index));
            int index1=cursor.getColumnIndex("college");
            tasklist.add(cursor.getString(index1));
            int index2=cursor.getColumnIndex("title");
            tasklist.add(cursor.getString(index2));
            int index3=cursor.getColumnIndex("description");
            tasklist.add(cursor.getString(index3));
        }
        db.close();
        return tasklist;

    }
}
