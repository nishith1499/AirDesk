package com.example.astro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper( Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user (name varchar(20) not null,password varchar(20) not null,college varchar(20),phone bigint not null ,email varchar(20) not null primary key)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user ");
        onCreate(db);
    }

    public boolean insert(String name,String password,String college, String phone,String email){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("email",email);
        c.put("password",password);
        c.put("college",college);
        c.put("phone",phone);
        c.put("email",email);
        long i=db.insert("user",null,c);
        if (i==-1) return false;
        else return true;
    }

    public boolean checkexist(String email){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM user WHERE email=?",new String[]{email});
        if(cursor.getCount()>0)return false;
        return true;
    }
}
