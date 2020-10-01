package com.example.userprofile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class kotlinquiz extends AppCompatActivity {

    int currentQuestion = 1;
    int cppMarks = 0;
    String mailMessage = null;
    private Toolbar kToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotlinquiz);

        kToolbar = findViewById(R.id.k_toolbar);
        setSupportActionBar(kToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.kotlin_menu, menu);
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
    public void kPre(View view) {

        if (currentQuestion > 0) {
            currentQuestion -= 1;
            displayQuestion(currentQuestion);
        }
    }


    //When Next Button clicked
    public void kNext(View view) {

        if (currentQuestion < 5) {

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


        Button kBPre = findViewById(R.id.kBPre);
        Button kBNext = findViewById(R.id.kBNext);

        switch (question) {
            case 1:
                lq1.setVisibility(View.VISIBLE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.GONE);


                kBPre.setVisibility(View.INVISIBLE);
                return;
            case 2:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.VISIBLE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.GONE);


                kBPre.setVisibility(View.VISIBLE);
                return;
            case 3:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.VISIBLE);
                lq4.setVisibility(View.GONE);

                kBNext.setVisibility(View.VISIBLE);
                return;
            case 4:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.VISIBLE);



                kBNext.setVisibility(View.INVISIBLE);
                return;
        }
    }

    //  When they submit quiz
    public void kSubmit(View view) {

        String grade = null;

        boolean q1;
        boolean q2;
        boolean q3;
        boolean q41;
        boolean q42;

        float grading;

        RadioButton q1op3a = findViewById(R.id.q1op3a);
        q1 = q1op3a.isChecked();
        if (q1){
            cppMarks += 1;
        }

        RadioButton q2op1a = findViewById(R.id.q2op1a);
        q2 = q2op1a.isChecked();
        if (q2){
            cppMarks += 1;
        }

        RadioButton q3op2a = findViewById(R.id.q3op2a);
        q3 = q3op2a.isChecked();
        if (q3){
            cppMarks += 1;
        }

        CheckBox q4op1 = findViewById(R.id.q4op1);
        q41 = q4op1.isChecked();

        CheckBox q4op2a = findViewById(R.id.q4op2a);
        q42 = q4op2a.isChecked();

        CheckBox q4op3a = findViewById(R.id.q4op3a);
        boolean q43 = q4op3a.isChecked();

        CheckBox q4op4 = findViewById(R.id.q4op4);
        boolean q44 = q4op4.isChecked();

        if( q42 && q43 && !q41 && !q44){
            cppMarks += 1;
        }

        grading = ((cppMarks * 100) / 4);

        TextView tvkCongrats = findViewById(R.id.tvkCongrats);

        if(grading > 89){
            grade = "A+";
            tvkCongrats.setText("Outstanding Performance!");
        }
        else if(grading <= 89 & grading > 74){
            grade = "A";
            tvkCongrats.setText("Good Performance!");
        }
        else if(grading <= 74 & grading > 54){
            grade = "B";
            tvkCongrats.setText("Congratulations!");
        }
        else if(grading <=54 & grading > 29){
            grade = "C";
            tvkCongrats.setText("Good!");
        }
        else if(grading <= 29 & grading >= 0){
            grade = "Fail";
            tvkCongrats.setText("Try Again!");
        }
        TextView tvkMarks = findViewById(R.id.tvkMarks);
        tvkMarks.setText("You Got: " + cppMarks + "/4");

        TextView tvkGrade = findViewById(R.id.tvkGrade);
        tvkGrade.setText("Grade: " + grade);

        mailMessage = "Hello Dear,\n\n   Below are the Results for your Kotlin Quiz taken on Quiz App.\n\nYou Got: " + cppMarks + "/4 \nGrade: " + grade + "\n\nThanks \nQuiz App Team";

        LinearLayout lkResults = findViewById(R.id.lkResults);
        lkResults.setVisibility(View.VISIBLE);

        LinearLayout lTop = findViewById(R.id.lTop);

        LinearLayout lq1 = findViewById(R.id.lq1);
        LinearLayout lq2 = findViewById(R.id.lq2);
        LinearLayout lq3 = findViewById(R.id.lq3);
        LinearLayout lq4 = findViewById(R.id.lq4);

        Button kBPre = findViewById(R.id.kBPre);
        Button kBNext = findViewById(R.id.kBNext);
        Button kBsubmit = findViewById(R.id.kBsubmit);

        lTop.setVisibility(View.GONE);

        lq1.setVisibility(View.VISIBLE);
        RadioGroup rgq1 = findViewById(R.id.rgq1);
        rgq1.setVisibility(View.GONE);
        TextView kq1a = findViewById(R.id.kq1a);
        kq1a.setVisibility(View.VISIBLE);

        lq2.setVisibility(View.VISIBLE);
        RadioGroup rgq2 = findViewById(R.id.rgq2);
        rgq2.setVisibility(View.GONE);
        TextView kq2a = findViewById(R.id.kq2a);
        kq2a.setVisibility(View.VISIBLE);

        lq3.setVisibility(View.VISIBLE);
        RadioGroup rgq3 = findViewById(R.id.rgq3);
        rgq3.setVisibility(View.GONE);
        TextView kq3a = findViewById(R.id.kq3a);
        kq3a.setVisibility(View.VISIBLE);

        lq4.setVisibility(View.VISIBLE);
        LinearLayout q4cg = findViewById(R.id.q4cg);
        q4cg.setVisibility(View.GONE);
        TextView kq4a = findViewById(R.id.kq4a);
        kq4a.setVisibility(View.VISIBLE);

        kBPre.setVisibility(View.INVISIBLE);
        kBNext.setVisibility(View.INVISIBLE);
        kBsubmit.setVisibility(View.INVISIBLE);
    }

    public void kMail(View view){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:")); //Only to mail apps
        intent.setType("*/*");
//        intent.putExtra(Intent.EXTRA_EMAIL, "suri0393@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Kotlin Quiz Result");
        intent.putExtra(Intent.EXTRA_TEXT, mailMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}