package com.example.rbcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.rbcollege.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class AdminExcess extends AppCompatActivity {
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_excess);;

        MydbHelper db = new MydbHelper(AdminExcess.this);

        ArrayList<String> allData = new ArrayList<>();
        listView =findViewById(R.id.listView);

        List<UserModel> Record = db.fetchUserData();
        for(UserModel data:Record){
            Log.d("tabledata","Id:" +  data.getId()+
                    "FacultyName" + data.getNumberOfStudent() +
                    "SubjectName" + data.getSubjectName() +
                    "ContentDelivered" + data.getContentDelivered()+
                    "NumberOfStudent" + data.getNumberOfStudent());
            allData.add("   Id: " + data.getId() +"\n"
                    +"   Faculty Name: " + data.getFacultyName() +"\n"
                    +"   Subject Name: " + data.getSubjectName() +"\n"
                    +"   Content Delivered: " + data.getContentDelivered() +"\n"
                    +"   Present: " + data.getNumberOfStudent());
//                    + data.getNumberOfStudent());

//                    + "SubjectName" +"ContentDelivered" + "NumberOfStudent" +"\n" +data.getId() + "|" +data.getFacultyName() +"|"
//                    + data.getSubjectName() +"|" +data.getContentDelivered() +"|"
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.list_item,allData);
        listView.setAdapter(arrayAdapter);
    }
}