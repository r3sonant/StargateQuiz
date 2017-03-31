package com.weirdresoance.android.stargatequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


import static com.weirdresoance.android.stargatequiz.WelcomeActivity.userName;

public class QuizActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        displayName();

        addListenerOnButton();
    }

    public void displayName() {
        TextView name = (TextView) findViewById(R.id.nameTest);
        name.setText(userName);
    }

    public void addListenerOnButton() {

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupQ1);
        btnDisplay = (Button) findViewById(R.id.radioButtonQ1A);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(QuizActivity.this,
                        radioButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });

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
