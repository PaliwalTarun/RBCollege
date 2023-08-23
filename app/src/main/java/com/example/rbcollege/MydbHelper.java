package com.example.rbcollege;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.rbcollege.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class MydbHelper  extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "user";
    public static final String USER_ID = "id";
    public static final String FACULTY_NAME = "facultyName";
    public static final String SUBJECT_NAME = "subject_name";
    public static final String CONTENT_DELIVERED = "contentDelivered";
    public static final String NUMBER_OF_STUDENT = "number_Of_Student";
    public static final String DATE_TIME = "time";

    public static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FACULTY_NAME + " TEXT, "
            + SUBJECT_NAME + " TEXT, "
            + CONTENT_DELIVERED + " TEXT, "
            + NUMBER_OF_STUDENT + " INTEGER, "
            + DATE_TIME + " DATE DEFAULT (datetime('now','localtime')) "
            + ")";

    public MydbHelper(Context context){
        super(context,TABLE_NAME,null,1);
    }
    public boolean insertUserData(String facultyName, String subjectName, String contentDelivered, String noOfStudent)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put("facultyName",facultyName);
        contentValues.put("subject_name",subjectName);
        contentValues.put("contentDelivered",contentDelivered);
        contentValues.put("number_Of_Student",noOfStudent);
        long result = db.insert("user",null,contentValues);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(CREATE_USER_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);


    }
    public ArrayList<FetchData> fetchContact(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);

        ArrayList<FetchData> arrFetch  = new ArrayList<>();
                while(cursor.moveToNext()){
                    FetchData fetch = new FetchData();
                    fetch.USER_ID = cursor.getString(0);
                    fetch.FACULTY_NAME = cursor.getString(1);
                    fetch.CONTENT_DELIVERED = cursor.getString(2);
                    fetch.NUMBER_OF_STUDENT = cursor.getString(3);
                    fetch.DATE_TIME = cursor.getString(4);

                    arrFetch.add(fetch);
                }
        return arrFetch;
    }
    public List<UserModel> fetchUserData(){
        List<UserModel> usrData = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(select,null);

        if(cursor.moveToFirst())
        {
            do{

                UserModel userModel = new UserModel();
                userModel.setId(Integer.parseInt(cursor.getString(0)));
                userModel.setFacultyName(cursor.getString(1));
                userModel.setSubjectName(cursor.getString(2));
                userModel.setContentDelivered(cursor.getString(3));
                userModel.setNumberOfStudent(Integer.parseInt(cursor.getString(4)));
                usrData.add(userModel);
            }while (cursor.moveToNext());
        }
        return usrData;

    }
}
