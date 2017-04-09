package com.weirdresoance.android.stargatequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void turnPage(View view) {
        EditText name = (EditText) findViewById(R.id.nameEntry);
        String isNameEntered = name.getText().toString();

        if (!isNameEntered.matches("")) {
            Intent intent = new Intent(this, QuizActivity.class);
            startActivity(intent);

            // Get the users name
            MainActivity.userName = name.getText().toString();
        }
        // Let the user know they need to answer the question before proceeding
        else {
            Toast.makeText(WelcomeActivity.this, R.string.pleaseAnswer, Toast.LENGTH_SHORT).show();
        }
    }
}
