package com.weirdresoance.android.stargatequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.weirdresoance.android.stargatequiz.WelcomeActivity.userName;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        displayName();
    }

    public void displayName() {
        TextView name = (TextView) findViewById(R.id.nameTest);
        name.setText(userName);
    }

    public void hideView(View v) {

        // Oi!!! STEEV-----Get RadioButton checked state and save it to somewhere - An array maybe, or just variables!!!!!!!
        setContentView(R.layout.activity_quiz);
        View view = findViewById(R.id.layoutQuestion1);
        view.setVisibility(View.INVISIBLE);

        // Increment layout counter by 1 --- layoutQuestion += 1
    }

    public void showView(View v) {
        setContentView(R.layout.activity_quiz);
        View view = findViewById(R.id.layoutQuestion1);
        view.setVisibility(View.VISIBLE);
    }
}
