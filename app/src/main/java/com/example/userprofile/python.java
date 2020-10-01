package com.example.userprofile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;

public class python extends AppCompatActivity {

    int currentQuestion = 1;
    int cppMarks = 0;
    String mailMessage = null;
    private Toolbar pToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python);

        pToolbar = findViewById(R.id.python_toolbar);
        setSupportActionBar(pToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.python_menu, menu);
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
    public void pPre(View view) {

        if (currentQuestion > 0) {
            currentQuestion -= 1;
            displayQuestion(currentQuestion);
        }
    }


    //When Next Button clicked
    public void pNext(View view) {

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


        Button pBPre = findViewById(R.id.pBPre);
        Button pBNext = findViewById(R.id.pBNext);

        switch (question) {
            case 1:
                lq1.setVisibility(View.VISIBLE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.GONE);


                pBPre.setVisibility(View.INVISIBLE);
                return;
            case 2:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.VISIBLE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.GONE);


                pBPre.setVisibility(View.VISIBLE);
                return;
            case 3:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.VISIBLE);
                lq4.setVisibility(View.GONE);

                pBNext.setVisibility(View.VISIBLE);
                return;
            case 4:
                lq1.setVisibility(View.GONE);
                lq2.setVisibility(View.GONE);
                lq3.setVisibility(View.GONE);
                lq4.setVisibility(View.VISIBLE);



                pBNext.setVisibility(View.INVISIBLE);
                return;
        }
    }

    //  When they submit quiz
    public void pSubmit(View view) {

        String grade = null;

        boolean q1;
        boolean q2;
        boolean q3;

        String q4ans=null;

        int q4;

        float grading;

        RadioButton q1op1a = findViewById(R.id.q1op1a);
        q1 = q1op1a.isChecked();
        if (q1){
            cppMarks += 1;
        }

        RadioButton q2op3a = findViewById(R.id.q2op3a);
        q2 = q2op3a.isChecked();
        if (q2){
            cppMarks += 1;
        }

        RadioButton q3op2a = findViewById(R.id.q3op2a);
        q3 = q3op2a.isChecked();
        if (q3){
            cppMarks += 1;
        }

        EditText q4a = findViewById(R.id.q4a);
        q4ans = q4a.getText().toString();
        if (q4ans.matches("")) {
            q4 = 0;
        }
        else {
            q4 = Integer.parseInt(q4ans);
        }


        if(q4 == 125){
            cppMarks += 1;
        }

        grading = ((cppMarks * 100) / 4);

        TextView tvpCongrats = findViewById(R.id.tvpCongrats);

        if(grading > 89){
            grade = "A+";
            tvpCongrats.setText("Outstanding Performance!");
        }
        else if(grading <= 89 & grading > 74){
            grade = "A";
            tvpCongrats.setText("Good Performance!");
        }
        else if(grading <= 74 & grading > 54){
            grade = "B";
            tvpCongrats.setText("Congratulations!");
        }
        else if(grading <=54 & grading > 29){
            grade = "C";
            tvpCongrats.setText("Good!");
        }
        else if(grading <= 29 & grading >= 0){
            grade = "Fail";
            tvpCongrats.setText("Try Again!");
        }
        TextView tvpMarks = findViewById(R.id.tvpMarks);
        tvpMarks.setText("You Got: " + cppMarks + "/4");

        TextView tvpGrade = findViewById(R.id.tvpGrade);
        tvpGrade.setText("Grade: " + grade);

        mailMessage = "Hello Dear,\n\n   Below are the Results for your Python Quiz taken on Quiz App.\n\nYou Got: " + cppMarks + "/4 \nGrade: " + grade + "\n\nThanks \nQuiz App Team";

        LinearLayout lpResults = findViewById(R.id.lpResults);
        lpResults.setVisibility(View.VISIBLE);

        LinearLayout lTop = findViewById(R.id.lTop);

        LinearLayout lq1 = findViewById(R.id.lq1);
        LinearLayout lq2 = findViewById(R.id.lq2);
        LinearLayout lq3 = findViewById(R.id.lq3);
        LinearLayout lq4 = findViewById(R.id.lq4);

        Button pBPre = findViewById(R.id.pBPre);
        Button pBNext = findViewById(R.id.pBNext);
        Button pBsubmit = findViewById(R.id.pBsubmit);

        lTop.setVisibility(View.GONE);

        lq1.setVisibility(View.VISIBLE);
        RadioGroup prgq1 = findViewById(R.id.prgq1);
        prgq1.setVisibility(View.GONE);
        TextView pq1a = findViewById(R.id.pq1a);
        pq1a.setVisibility(View.VISIBLE);

        lq2.setVisibility(View.VISIBLE);
        RadioGroup prgq2 = findViewById(R.id.prgq2);
        prgq2.setVisibility(View.GONE);
        TextView pq2a = findViewById(R.id.pq2a);
        pq2a.setVisibility(View.VISIBLE);

        lq3.setVisibility(View.VISIBLE);
        RadioGroup prgq3 = findViewById(R.id.prgq3);
        prgq3.setVisibility(View.GONE);
        TextView pq3a = findViewById(R.id.pq3a);
        pq3a.setVisibility(View.VISIBLE);

        lq4.setVisibility(View.VISIBLE);
        TextInputLayout lpHName = findViewById(R.id.lpHName);
        lpHName.setVisibility(View.GONE);
        TextView pq4a = findViewById(R.id.pq4a);
        pq4a.setVisibility(View.VISIBLE);

        pBPre.setVisibility(View.INVISIBLE);
        pBNext.setVisibility(View.INVISIBLE);
        pBsubmit.setVisibility(View.INVISIBLE);
    }

    public void pMail(View view){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:")); //Only to mail apps
        intent.setType("*/*");
//        intent.putExtra(Intent.EXTRA_EMAIL, "suri0393@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Python Quiz Result");
        intent.putExtra(Intent.EXTRA_TEXT, mailMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}