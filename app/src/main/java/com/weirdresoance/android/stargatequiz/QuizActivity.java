package com.weirdresoance.android.stargatequiz;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;


import static com.weirdresoance.android.stargatequiz.WelcomeActivity.userName;

public class QuizActivity extends AppCompatActivity {

    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        displayName();


        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroupQ1);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButtonQ1A:
                        // do operations specific to this selection
                        radioButton = (RadioButton) findViewById(R.id.radioButtonQ1A);
                        Toast.makeText(QuizActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonQ1B:
                        // do operations specific to this selection
                        break;
                    case R.id.radioButtonQ1C:
                        // do operations specific to this selection
                        break;
                    case R.id.radioButtonQ1D:
                        // do operations specific to this selection
                        break;
                }
            }
        });

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



/*
import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.Toast;

public class MyAndroidAppActivity extends Activity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        radioGroup = (RadioGroup) findViewById(R.id.radio);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(MyAndroidAppActivity.this,
                        radioButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });

    }
}*/
