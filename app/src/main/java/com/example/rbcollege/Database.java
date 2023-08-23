package com.example.rbcollege;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String dbname = "db.db";

    public Database(@Nullable Context context){
        super(context,dbname,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String q = "create table user (_id integer primary key autoincrement,faculty2 text,subject2 text,content2 text,number_of_student integer)";
        sqLiteDatabase.execSQL(q);
    }
    public boolean insert_data(String faculty,String subject,String content,int studentNumber)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("faculty2",faculty);
        c.put("subject2",subject);
        c.put("content2",content);
        c.put("number_of_student",studentNumber);

        //  c.put("student2",student);
        long result = db.insert("user",null,c);
        if(result==-1) {
            db.close();
            return false;
        }
        else {
            db.close();
            return true;
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists user");
        onCreate(sqLiteDatabase);
    }

}