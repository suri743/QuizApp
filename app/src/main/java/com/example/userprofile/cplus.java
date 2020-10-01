package com.example.userprofile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;

public class cplus extends AppCompatActivity {

    int currentQuestion = 1;
    int cppMarks = 0;
    String mailMessage = null;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cplus);

        mToolbar = findViewById(R.id.cpp_toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.cpp_menu, menu);
        return true;
    }

    //    When menu seelcted
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.quizApp:
                startActivity(new Intent(this, MainActivity2.class));
                return true;
            case R.id.contactUs:

                return true;
            case R.id.help:
                startActivity(new Intent(this, help.class));
                return true;
            case R.id.logout:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    //When Previous Button clicked
    public void cpPre(View view) {

        if (currentQuestion > 0) {
            currentQuestion -= 1;
            displayQuestion(currentQuestion);
        }
    }


    //When Next Button clicked
    public void cpNext(View view) {

        if (currentQuestion < 6) {

            currentQuestion += 1;
            displayQuestion(currentQuestion);
        }
    }

    //   Logic When Previous and Next buttons clicked
    private void displayQuestion(int question) {

        LinearLayout lq1 = findViewById(R.id.lq1);
        LinearLayout lq2 = findViewById(R.id.lq2);
        LinearLayout lq3 = findViewById(R.id.lq3);
        LinearLayout lq4 = findViewById(R.id.lq4);
        LinearLayout lq5 = findViewById(R.id.lq5);

        Button cpBPre = findViewById(R.id.cpBPre);
        Button cpBNext = findViewById(R.id.cpBNext);

        switch (question) {
            case 1:
                lq1.setVisibility(View.VISIBLE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.GONE);
                lq5.setVisibility(View.GONE);

                cpBPre.setVisibility(View.INVISIBLE);
                return;
            case 2:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.VISIBLE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.GONE);
                lq5.setVisibility(View.GONE);

                cpBPre.setVisibility(View.VISIBLE);
                return;
            case 3:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.VISIBLE);
                lq4.setVisibility(View.GONE);
                lq5.setVisibility(View.GONE);

                return;
            case 4:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.VISIBLE);
                lq5.setVisibility(View.GONE);

                cpBNext.setVisibility(View.VISIBLE);
                return;
            case 5:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.GONE);
                lq5.setVisibility(View.VISIBLE);

                cpBNext.setVisibility(View.INVISIBLE);
                return;
        }
    }

    //  When they submit quiz
    public void cpSubmit(View view) {

        String grade = null;

        boolean q1;
        boolean q2;
        boolean q3;
        boolean q41;
        boolean q42;

        String q5ans = null;
        int q5;

        float grading;

        RadioButton q1op2a = findViewById(R.id.q1op2a);
        q1 = q1op2a.isChecked();
        if (q1) {
            cppMarks += 1;
        }

        RadioButton q2op1a = findViewById(R.id.q2op1a);
        q2 = q2op1a.isChecked();
        if (q2) {
            cppMarks += 1;
        }

        RadioButton q3op3a = findViewById(R.id.q3op3a);
        q3 = q3op3a.isChecked();
        if (q3) {
            cppMarks += 1;
        }

        CheckBox q4op2a = findViewById(R.id.q4op2a);
        q42 = q4op2a.isChecked();
        CheckBox q4op5a = findViewById(R.id.q4op5a);
        boolean q45 = q4op5a.isChecked();

        CheckBox q4op1 = findViewById(R.id.q4op1);
        q41 = q4op1.isChecked();

        CheckBox q4op3 = findViewById(R.id.q4op3);
        boolean q43 = q4op3.isChecked();

        CheckBox q4op4 = findViewById(R.id.q4op4);
        boolean q44 = q4op4.isChecked();

        if (q41 && q45 && !q42 && !q43 && !q44) {
            cppMarks += 1;
        }

        EditText q5a = findViewById(R.id.q5a);
        q5ans = q5a.getText().toString();
        if (q5ans.matches("")) {
            q5 = 0;
        } else {
            q5 = Integer.parseInt(q5ans);
        }

        if (q5 == 65535) {
            cppMarks += 1;
        }

        grading = ((cppMarks * 100) / 5);

        TextView tvCongrats = findViewById(R.id.tvCongrats);

        if (grading > 89) {
            grade = "A+";
            tvCongrats.setText("Outstanding Performance!");
        } else if (grading <= 89 & grading > 74) {
            grade = "A";
            tvCongrats.setText("Good Performance!");
        } else if (grading <= 74 & grading > 54) {
            grade = "B";
            tvCongrats.setText("Congratulations!");
        } else if (grading <= 54 & grading > 29) {
            grade = "C";
            tvCongrats.setText("Good!");
        } else if (grading <= 29 & grading >= 0) {
            grade = "Fail";
            tvCongrats.setText("Try Again!");
        }
        TextView tvMarks = findViewById(R.id.tvMarks);
        tvMarks.setText("You Got: " + cppMarks + "/5");

        TextView tvGrade = findViewById(R.id.tvGrade);
        tvGrade.setText("Grade: " + grade);

        mailMessage = "Hello Dear,\n\n   Below are the Results for your C++ Quiz taken on Quiz App.\n\nYou Got: " + cppMarks + "/5 \nGrade: " + grade + "\n\nThanks \nQuiz App Team";

        LinearLayout lResults = findViewById(R.id.lResults);
        lResults.setVisibility(View.VISIBLE);

        LinearLayout lTop = findViewById(R.id.lTop);

        LinearLayout lq1 = findViewById(R.id.lq1);
        LinearLayout lq2 = findViewById(R.id.lq2);
        LinearLayout lq3 = findViewById(R.id.lq3);
        LinearLayout lq4 = findViewById(R.id.lq4);
        LinearLayout lq5 = findViewById(R.id.lq5);

        Button cpBPre = findViewById(R.id.cpBPre);
        Button cpBNext = findViewById(R.id.cpBNext);
        Button cpBsubmit = findViewById(R.id.cpBsubmit);

        lTop.setVisibility(View.GONE);

        lq1.setVisibility(View.VISIBLE);
        RadioGroup crgq1 = findViewById(R.id.crgq1);
        crgq1.setVisibility(View.GONE);
        TextView cq1a = findViewById(R.id.cq1a);
        cq1a.setVisibility(View.VISIBLE);

        lq2.setVisibility(View.VISIBLE);
        RadioGroup crgq2 = findViewById(R.id.crgq2);
        crgq2.setVisibility(View.GONE);
        TextView cq2a = findViewById(R.id.cq2a);
        cq2a.setVisibility(View.VISIBLE);

        lq3.setVisibility(View.VISIBLE);
        RadioGroup crgq3 = findViewById(R.id.crgq3);
        crgq3.setVisibility(View.GONE);
        TextView cq3a = findViewById(R.id.cq3a);
        cq3a.setVisibility(View.VISIBLE);

        lq4.setVisibility(View.VISIBLE);
        LinearLayout cq4cg = findViewById(R.id.cq4cg);
        cq4cg.setVisibility(View.GONE);
        TextView cq4a = findViewById(R.id.cq4a);
        cq4a.setVisibility(View.VISIBLE);

        lq5.setVisibility(View.VISIBLE);
        TextInputLayout lhName = findViewById(R.id.lHName);
        lhName.setVisibility(View.GONE);
        TextView cq5a = findViewById(R.id.cq5a);
        cq5a.setVisibility(View.VISIBLE);

        cpBPre.setVisibility(View.INVISIBLE);
        cpBNext.setVisibility(View.INVISIBLE);
        cpBsubmit.setVisibility(View.INVISIBLE);
    }

    public void cpMail(View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:")); //Only to mail apps
        intent.setType("*/*");
//        intent.putExtra(Intent.EXTRA_EMAIL, "suri0393@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "C++ Quiz Result");
        intent.putExtra(Intent.EXTRA_TEXT, mailMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}