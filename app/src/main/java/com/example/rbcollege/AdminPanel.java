package com.example.rbcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminPanel extends AppCompatActivity {
    EditText AdminName ,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        AdminName = (EditText) findViewById(R.id.AdminName);

        Password= (EditText) findViewById(R.id.password);


        String databaseValue1 = "Admin";
        String databaseValue2 = "Admin@123";

        Button button = findViewById(R.id.btnsignup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstValue = AdminName.getText().toString();
                String secondValue = Password.getText().toString();
                if(firstValue.equals(databaseValue1) && secondValue.equals(databaseValue2)){
                    Intent intent = new Intent(AdminPanel.this, AdminExcess.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(AdminPanel.this, "Fill Correct Detail", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //fetch data
        MydbHelper helpMe1 = new MydbHelper(getApplicationContext());
        ArrayList<FetchData> arrFetch = helpMe1.fetchContact();

        for(int i=0;i<arrFetch.size();i++)
            Log.d("Data_INFO","USER_ID : " + arrFetch.get(i).USER_ID +",FACULTY_NAME" + arrFetch.get(i).FACULTY_NAME + ",CONTENT_DELIVERED" +arrFetch.get(i).CONTENT_DELIVERED+",NUMBER_OF_STUDENT"+arrFetch.get(i).NUMBER_OF_STUDENT + ",DATE_TIME" +arrFetch.get(i).DATE_TIME);
    }
}