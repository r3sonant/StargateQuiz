package com.weirdresoance.android.stargatequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void turnPage(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);

        // Get the users name
        EditText name = (EditText) findViewById(R.id.nameEntry);
        MainActivity.userName = name.getText().toString();
    }
}
