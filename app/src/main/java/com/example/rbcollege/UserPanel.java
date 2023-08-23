package com.example.rbcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserPanel extends AppCompatActivity {
    EditText userName ,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_panel);

        userName = (EditText) findViewById(R.id.username);


        Password= (EditText) findViewById(R.id.password);

        String databaseValue1 = "user";
        String databaseValue2 = "user@123";

        Button button = findViewById(R.id.btnsignup);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstValue = userName.getText().toString();
                String secondValue = Password.getText().toString();
                if(firstValue.equals(databaseValue1) && secondValue.equals(databaseValue2)){
                    Intent intent = new Intent(UserPanel.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(UserPanel.this, "Fill Correct Detail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}