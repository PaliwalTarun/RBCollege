package com.example.rbcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    TextView faculty1, subject1, date1, date2, time1, time2, content1, student1;
    Button submit;
    EditText faculty2, subject2, content2, student2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MydbHelper helpMe = new MydbHelper(getApplicationContext());



        //for database
//        Database dba = new Database(this);
//        // SQLiteDatabase db =  g.getReadableDatabase();
//        SQLiteDatabase db =  g.getWritableDatabase();


        Runnable runnable = new CountDownRunner();
        Thread myThread = new Thread(runnable);
        myThread.start();

        //for date
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());
        date2 = (TextView) findViewById(R.id.tx10);
        date2.setText(currentDate);


        faculty2 = findViewById(R.id.facultyName);
        subject2 = findViewById(R.id.subjectName);
        time2 = findViewById(R.id.tx20);
        content2 = findViewById(R.id.contentDelivered);
//        submit =  findViewById(R.id.submitBtn);
        submit = findViewById(R.id.submitBtn);
        student2 = findViewById(R.id.noOfStudentPresent);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String facultyName = faculty2.getText().toString();
                String subjectName = subject2.getText().toString();
                String contentDelivered = content2.getText().toString();
                String noOfStudentString = student2.getText().toString();


                if (TextUtils.isEmpty(facultyName)) {

                    Toast.makeText(MainActivity.this, "please fill name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(subjectName)) {

                    Toast.makeText(MainActivity.this, "please fill subject name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(noOfStudentString)) {

                    Toast.makeText(MainActivity.this, "please fill student present", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(contentDelivered)) {

                    Toast.makeText(MainActivity.this, "please fill content delivered", Toast.LENGTH_SHORT).show();
                    return;
                }

//                 &&  &&  &&

//               int noOfStudent = Integer.parseInt(noOfStudentString);
                boolean i = helpMe.insertUserData(facultyName, subjectName, contentDelivered, noOfStudentString);
                if (i) {
                    Toast.makeText(getApplicationContext(), "Submitted Successfully", Toast.LENGTH_SHORT).show();
//           startActivity(new Intent(getApplicationContext(),MainActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Error Registering Data", Toast.LENGTH_SHORT).show();

                }

                faculty2.setText("");
                subject2.setText("");
                content2.setText("");
                student2.setText("");

            }
        });
    }

    public void doWork() {
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    TextView txtCurrentTime = (TextView) findViewById(R.id.tx20);
                    Date dt = new Date();
                    int hours = dt.getHours();
                    int minutes = dt.getMinutes();
                    int seconds = dt.getSeconds();
                    String curTime = hours + ":" + minutes + ":" + seconds;
                    txtCurrentTime.setText(curTime);
                } catch (Exception e) {
                }
            }
        });
    }


    class CountDownRunner implements Runnable {
        // @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    doWork();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Exception e) {
                }
            }
        }

    }
}
