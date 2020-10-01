package com.example.userprofile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setLoginPage(View view) {

        clearData();

        int flag1 = 0;
        int flag2 = 0;

        Intent quizList = new Intent(this, MainActivity2.class);

//      Get Phone Number and Validate
        EditText lPhone = findViewById(R.id.lPhone);
        String phoneNumber = lPhone.getText().toString();

        if (phoneNumber.length() == 0) {
            lPhone.setError("Please Enter Phone Number");
        } else if (phoneNumber.length() < 10 || phoneNumber.length() > 10) {
            lPhone.setError("Please Enter valid Number");
        } else {
            flag1 = 1;
        }

//      Get Name and validate
        EditText lEmail = findViewById(R.id.lEmail);
        String name = lEmail.getText().toString();
        if (name.length() == 0) {
            lEmail.setError("Please enter Email");
        } else {
            flag2 = 1;
        }
        if (flag1 == 1 & flag2 == 1) {
            startActivity(new Intent(this, MainActivity2.class));
        }
    }

    private void clearData() {

        EditText fName = findViewById(R.id.fName);
        fName.setText("");
        fName.setError(null);

        EditText lName = findViewById(R.id.lName);
        lName.setText("");
        lName.setError(null);

        EditText lEmail = findViewById(R.id.lEmail);
        lEmail.setText("");
        lEmail.setError(null);

        EditText lPhone = findViewById(R.id.lPhone);
        lPhone.setText("");
        lPhone.setError(null);


    }
    public void setSkip(View view) {
        startActivity(new Intent(this, MainActivity2.class));
    }
}