package com.example.rbcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Home extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton, r1, r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        radioGroup = findViewById(R.id.radioGroup);
        // r1 = findViewById(R.id.radioButton);
        //r2 = findViewById(R.id.radioButton2);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    if (selectedRadioButton.getId() == R.id.radioButton) {
                        Intent intent = new Intent(Home.this, AdminPanel.class);
                        startActivity(intent);
                        //  startActivities(new Intent(Home.this,AdminPanel.class));
                    } else if (selectedRadioButton.getId() == R.id.radioButton2) {

                        Intent intent = new Intent(Home.this, UserPanel.class);
                        startActivity(intent);
                    }
                }

            }
        });
    }
//    public void  onRadioButtonClicked(View view){
//        boolean checked = ((RadioButton) view).isChecked();
//        switch(view.getId()){
//            case R.id.radioButton:
//                if(checked){
//                    Intent intent = new Intent(Home.this,AdminPanel.class);
//                    startActivity(intent);
//                }
//        }
//
//    }
}


//Toast.makeText(this, "Opening second activity", Toast.LENGTH_SHORT).show();
//    Intent intent = new Intent(Home.this,AdminPanel.class);
//    startActivity(intent);
//     Code for RadioButton 2
// Intent intent = new Intent(Home.this,UserPanel.class);
//startActivity(intent);

