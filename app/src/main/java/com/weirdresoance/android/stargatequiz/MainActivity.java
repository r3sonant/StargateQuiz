package com.weirdresoance.android.stargatequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /** Called when the user taps the button */
    public void turnPage(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);

        overridePendingTransition(R.animator.animation_entrance, R.animator.animation_exit);
    }
}
