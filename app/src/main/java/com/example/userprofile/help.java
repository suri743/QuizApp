package com.example.userprofile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class help extends AppCompatActivity {

private Toolbar hToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        hToolbar = findViewById(R.id.help_toolbar);
        setSupportActionBar(hToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.help_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        Toast.makeText(this,"Checking", Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.quizApp:
                startActivity(new Intent(this, MainActivity2.class));
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

    public void hSendMail(View view){
        Toast.makeText(this,"We got your message. Will get back to you soon!", Toast.LENGTH_LONG).show();

        EditText hName = findViewById(R.id.hName);
//        hName.setText("");

//        EditText hLastName = findViewById(R.id.hLastName);
//        hLastName.setText("");

        EditText hEmail = findViewById(R.id.hEmail);
//        hEmail.setText("");

        EditText hMessage = findViewById(R.id.hMessage);
//        hMessage.setText("");

    }
}