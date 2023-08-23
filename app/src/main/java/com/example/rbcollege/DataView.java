package com.example.rbcollege;

import android.view.View;
import android.widget.TextView;

public class DataView {
    TextView id,facultyName,sujectName,contentDeliverd,noOfStudent,date;

    DataView(View view){

        id = view.findViewById(R.id.showId);
        facultyName = view.findViewById(R.id.showFacultyName);
        sujectName = view.findViewById(R.id.showSubjectName);
        contentDeliverd = view.findViewById(R.id.showContentDeliverd);
        noOfStudent = view.findViewById(R.id.showNoOfStudent);
        date = view.findViewById(R.id.showDate);
    }
}
