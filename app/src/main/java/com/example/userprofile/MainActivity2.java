package com.example.userprofile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity2 extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        Toast.makeText(this,"Checking", Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.help:
                startActivity(new Intent(this, help.class));
                return true;
            case R.id.contactUs:

                return true;
            case R.id.logout:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void qCplus(View view){

        startActivity(new Intent(this, cplus.class));

    }
    public void qKotlin(View view){
        startActivity(new Intent(this, kotlinquiz.class));
    }
    public void qJava(View view){
        startActivity(new Intent(this, javaQuiz.class));
    }
    public void qPython(View view){
        startActivity(new Intent(this, python.class));
    }
}