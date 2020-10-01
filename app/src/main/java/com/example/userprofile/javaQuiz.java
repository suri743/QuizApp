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

public class javaQuiz extends AppCompatActivity {

    int currentQuestion = 1;
    int cppMarks = 0;
    String mailMessage = null;
   private Toolbar jToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_quiz);

        jToolbar = findViewById(R.id.java_toolbar);
        setSupportActionBar(jToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.java_menu, menu);
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
    public void jPre(View view) {

        if (currentQuestion > 0) {
            currentQuestion -= 1;
            displayQuestion(currentQuestion);
        }
    }


    //When Next Button clicked
    public void jNext(View view) {

        if (currentQuestion < 8) {

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
        LinearLayout lq6 = findViewById(R.id.lq6);
        LinearLayout lq7 = findViewById(R.id.lq7);


        Button jBPre = findViewById(R.id.jBPre);
        Button jBNext = findViewById(R.id.jBNext);

        switch (question) {
            case 1:
                lq1.setVisibility(View.VISIBLE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.GONE);
                lq5.setVisibility(View.GONE);
                lq6.setVisibility(View.GONE);
                lq7.setVisibility(View.GONE);


                jBPre.setVisibility(View.INVISIBLE);
                return;
            case 2:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.VISIBLE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.GONE);
                lq5.setVisibility(View.GONE);
                lq6.setVisibility(View.GONE);
                lq7.setVisibility(View.GONE);

                jBPre.setVisibility(View.VISIBLE);
                return;
            case 3:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.VISIBLE);
                lq4.setVisibility(View.GONE);
                lq5.setVisibility(View.GONE);
                lq6.setVisibility(View.GONE);
                lq7.setVisibility(View.GONE);


                return;
            case 4:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.VISIBLE);
                lq5.setVisibility(View.GONE);
                lq6.setVisibility(View.GONE);
                lq7.setVisibility(View.GONE);



                return;
            case 5:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.GONE);
                lq5.setVisibility(View.VISIBLE);
                lq6.setVisibility(View.GONE);
                lq7.setVisibility(View.GONE);



                return;
            case 6:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.GONE);
                lq5.setVisibility(View.GONE);
                lq6.setVisibility(View.VISIBLE);
                lq7.setVisibility(View.GONE);


                jBNext.setVisibility(View.VISIBLE);
                return;
            case 7:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.GONE);
                lq5.setVisibility(View.GONE);
                lq6.setVisibility(View.GONE);
                lq7.setVisibility(View.VISIBLE);


                jBNext.setVisibility(View.INVISIBLE);
                return;
        }
    }

    //  When they submit quiz
    public void jSubmit(View view) {

        String grade = null;

        boolean q1;
        boolean q2;
        boolean q3;
        boolean q4;
        boolean q51;
        boolean q52;
        boolean q53;

        String q6=null;

        boolean q7;

        float grading;

        RadioButton q1op1a = findViewById(R.id.q1op1a);
        q1 = q1op1a.isChecked();
        if (q1){
            cppMarks += 1;
        }

        RadioButton q2op1a = findViewById(R.id.q2op1a);
        q2 = q2op1a.isChecked();
        if (q2){
            cppMarks += 1;
        }

        RadioButton q3op3a = findViewById(R.id.q3op3a);
        q3 = q3op3a.isChecked();
        if (q3){
            cppMarks += 1;
        }

        RadioButton q4op2a = findViewById(R.id.q4op2a);
        q4 = q4op2a.isChecked();
        if (q4){
            cppMarks += 1;
        }

        CheckBox q5op1a = findViewById(R.id.q5op1a);
        q51 = q5op1a.isChecked();

        CheckBox q5op2 = findViewById(R.id.q5op2);
        boolean q5 = q5op2.isChecked();

        CheckBox q5op3a = findViewById(R.id.q5op3a);
        q52 = q5op3a.isChecked();

        CheckBox q5op4a = findViewById(R.id.q5op4a);
        q53 = q5op4a.isChecked();

        if(( q51 && q52 && q53)&&(!q5)){
            cppMarks += 1;
        }
        EditText q6a = findViewById(R.id.q6a);
        q6 = q6a.getText().toString();

        if(q6 == "AC"){
            cppMarks += 1;
        }

        CheckBox q7op3a = findViewById(R.id.q7op3a);
        q7 = q7op3a.isChecked();

        if (q7){
            cppMarks += 1;
        }

        grading = ((cppMarks * 100) / 7);

        TextView tvjCongrats = findViewById(R.id.tvjCongrats);

        if(grading > 89){
            grade = "A+";
            tvjCongrats.setText("Outstanding Performance!");
        }
        else if(grading <= 89 & grading > 74){
            grade = "A";
            tvjCongrats.setText("Good Performance!");
        }
        else if(grading <= 74 & grading > 54){
            grade = "B";
            tvjCongrats.setText("Congratulations!");
        }
        else if(grading <=54 & grading > 29){
            grade = "C";
            tvjCongrats.setText("Good!");
        }
        else if(grading <= 29 & grading >= 0){
            grade = "Fail";
            tvjCongrats.setText("Try Again!");
        }
        TextView tvjMarks = findViewById(R.id.tvjMarks);
        tvjMarks.setText("You Got: " + cppMarks + "/7");

        TextView tvjGrade = findViewById(R.id.tvjGrade);
        tvjGrade.setText("Grade: " + grade);

        mailMessage = "Hello Dear,\n\n   Below are the Results for your Java Quiz taken on Quiz App.\n\nYou Got: " + cppMarks + "/7 \nGrade: " + grade + "\n\nThanks \nQuiz App Team";

        LinearLayout ljResults = findViewById(R.id.ljResults);
        ljResults.setVisibility(View.VISIBLE);

        LinearLayout lTop = findViewById(R.id.lTop);

        LinearLayout lq1 = findViewById(R.id.lq1);
        LinearLayout lq2 = findViewById(R.id.lq2);
        LinearLayout lq3 = findViewById(R.id.lq3);
        LinearLayout lq4 = findViewById(R.id.lq4);
        LinearLayout lq5 = findViewById(R.id.lq5);
        LinearLayout lq6 = findViewById(R.id.lq6);
        LinearLayout lq7 = findViewById(R.id.lq7);

        Button jBPre = findViewById(R.id.jBPre);
        Button jBNext = findViewById(R.id.jBNext);
        Button jBsubmit = findViewById(R.id.jBsubmit);

        lTop.setVisibility(View.GONE);

        lq1.setVisibility(View.VISIBLE);
        RadioGroup jrgq1 = findViewById(R.id.jrgq1);
        jrgq1.setVisibility(View.GONE);
        TextView jq1a = findViewById(R.id.jq1a);
        jq1a.setVisibility(View.VISIBLE);

        lq2.setVisibility(View.VISIBLE);
        RadioGroup jrgq2 = findViewById(R.id.jrgq2);
        jrgq2.setVisibility(View.GONE);
        TextView jq2a = findViewById(R.id.jq2a);
        jq2a.setVisibility(View.VISIBLE);

        lq3.setVisibility(View.VISIBLE);
        RadioGroup jrgq3 = findViewById(R.id.jrgq3);
        jrgq3.setVisibility(View.GONE);
        TextView jq3a = findViewById(R.id.jq3a);
        jq3a.setVisibility(View.VISIBLE);

        lq4.setVisibility(View.VISIBLE);
        RadioGroup jrgq4 = findViewById(R.id.jrgq4);
        jrgq4.setVisibility(View.GONE);
        TextView jq4a = findViewById(R.id.jq4a);
        jq4a.setVisibility(View.VISIBLE);

        lq5.setVisibility(View.VISIBLE);
        LinearLayout jq5cg = findViewById(R.id.jq5cg);
        jq5cg.setVisibility(View.GONE);
        TextView jq5a = findViewById(R.id.jq5a);
        jq5a.setVisibility(View.VISIBLE);

        lq6.setVisibility(View.VISIBLE);
        TextInputLayout ljHName = findViewById(R.id.ljHName);
        ljHName.setVisibility(View.GONE);
        TextView jq6a = findViewById(R.id.jq6a);
        jq6a.setVisibility(View.VISIBLE);

        lq7.setVisibility(View.VISIBLE);
        LinearLayout jq7cg = findViewById(R.id.jq7cg);
        jq7cg.setVisibility(View.GONE);
        TextView jq7a = findViewById(R.id.jq7a);
        jq7a.setVisibility(View.VISIBLE);

        jBPre.setVisibility(View.INVISIBLE);
        jBNext.setVisibility(View.INVISIBLE);
        jBsubmit.setVisibility(View.INVISIBLE);
    }

    public void jMail(View view){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:")); //Only to mail apps
        intent.setType("*/*");
//        intent.putExtra(Intent.EXTRA_EMAIL, "suri0393@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Java Quiz Result");
        intent.putExtra(Intent.EXTRA_TEXT, mailMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}