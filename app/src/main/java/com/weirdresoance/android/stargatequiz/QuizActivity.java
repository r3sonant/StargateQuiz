package com.weirdresoance.android.stargatequiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;


import org.w3c.dom.Text;

import static android.R.attr.breakStrategy;
import static android.R.attr.checked;
import static android.R.attr.id;
import static android.R.attr.name;
import static android.R.id.message;
import static android.media.CamcorderProfile.get;
//import static com.weirdresoance.android.stargatequiz.MainActivity.userAnswers;
import static com.weirdresoance.android.stargatequiz.MainActivity.score;
import static com.weirdresoance.android.stargatequiz.MainActivity.userName;
import static com.weirdresoance.android.stargatequiz.R.id.finish;
import static com.weirdresoance.android.stargatequiz.R.id.mainQuestionView;
import static com.weirdresoance.android.stargatequiz.R.id.next;
import static com.weirdresoance.android.stargatequiz.R.id.q1Result;
import static com.weirdresoance.android.stargatequiz.R.id.q1YourAnswer;
import static com.weirdresoance.android.stargatequiz.R.id.radioButtonQ1A;
import static com.weirdresoance.android.stargatequiz.R.id.resultsSummary;
import static com.weirdresoance.android.stargatequiz.R.string.question3;
import static java.lang.Integer.valueOf;


public class QuizActivity extends AppCompatActivity {

    RadioButton radioButton;
    //CheckBox checkBox;
    int quizLayoutNumber = 1;
    boolean isAnswered = false;
    int q1AnswerID;
    int q2checkedCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        clearAnswers();
    }

    // Question 1 Radio Buttons onClick
    public void onRadioButtonClickedQ1(View view) {
        // Set the isAnswered boolean to true as we wouldn't be here if the user hadn't click on a radiobutton
        isAnswered = true;

        // Check which radio button was clicked
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButtonQ1A:
                if (checked)
                    q1AnswerID = R.id.radioButtonQ1A;
                radioButton = (RadioButton) findViewById(radioButtonQ1A);
                break;
            case R.id.radioButtonQ1B:
                if (checked)
                    q1AnswerID = R.id.radioButtonQ1B;
                radioButton = (RadioButton) findViewById(R.id.radioButtonQ1B);
                break;
            case R.id.radioButtonQ1C:
                if (checked)
                    q1AnswerID = R.id.radioButtonQ1C;
                radioButton = (RadioButton) findViewById(R.id.radioButtonQ1C);
                break;
            case R.id.radioButtonQ1D:
                if (checked)
                    q1AnswerID = R.id.radioButtonQ1D;
                radioButton = (RadioButton) findViewById(R.id.radioButtonQ1D);
                break;
        }
    }

    public void onCheckboxClickedQ2(View view) {
        if (q2checkedCount < 2) {
            // Check which checkbox was clicked
            boolean checked = ((CheckBox) view).isChecked();
            switch (view.getId()) {
                case R.id.checkboxQ2A:
                    if (checked) q2checkedCount++;
                    else q2checkedCount--;
                    break;
                case R.id.checkboxQ2B:
                    if (checked) q2checkedCount++;
                    else q2checkedCount--;
                    break;
                case R.id.checkboxQ2C:
                    if (checked)
                        q2checkedCount++;
                    else q2checkedCount--;
                    break;
                case R.id.checkboxQ2D:
                    if (checked)
                        q2checkedCount++;
                    else q2checkedCount--;
                    break;
            }

        } else {
            Toast.makeText(QuizActivity.this, R.string.tooManyChecked, Toast.LENGTH_SHORT).show();
            CheckBox checkBoxA = (CheckBox) findViewById(R.id.checkboxQ2A);
            checkBoxA.setChecked(false);
            CheckBox checkBoxB = (CheckBox) findViewById(R.id.checkboxQ2B);
            checkBoxB.setChecked(false);
            CheckBox checkBoxC = (CheckBox) findViewById(R.id.checkboxQ2C);
            checkBoxC.setChecked(false);
            CheckBox checkBoxD = (CheckBox) findViewById(R.id.checkboxQ2D);
            checkBoxD.setChecked(false);
            q2checkedCount = 0;
            isAnswered = false;
        }

        if (q2checkedCount == 2) {
            isAnswered = true;
        } else isAnswered = false;
    }

    /**
     * Hide the current view when the user clicks the next button
     *
     * @param v
     */
    public void hideCurrentQuestion(View v) {



        //DELETE THIS AFTER TESTING !!!!!!!
        isAnswered = true;



        // Check to make sure the user has answered the question before proceeding
        if (isAnswered) {
            // Create a string for the ID of the current view
            String viewID = "layoutQuestion" + quizLayoutNumber;

            // Convert the string into the ID of the view
            int resID = getResources().getIdentifier(viewID, "id", getPackageName());

            // Find the view
            View view = findViewById(resID);

            // Set the view to GONE so it no longer shows and doesn't take up any space
            view.setVisibility(View.GONE);

            // Increment the quizLayoutNumber so it can be used in showNextQuestion to show the next question view
            // and then call showNextQuestion
            quizLayoutNumber++;
            isAnswered = false;
            if (quizLayoutNumber < 6) {
                showNextQuestion();
            } else question5Commit();
        }
        // Let the user know they need to answer the question before proceeding
        else Toast.makeText(QuizActivity.this, R.string.pleaseAnswer, Toast.LENGTH_SHORT).show();


    }

    /**
     * Show the next question when the user clicks the next button
     */
    public void showNextQuestion() {
        // Switch statement to work out which question the user is on and call the appropriate method to calculate the score
        switch (quizLayoutNumber) {
            case 2:
                question1Commit();
                break;
            case 3:
                question2Commit();
                break;
            case 4:
                question3Commit();
                break;
            case 5:
                question4Commit();
                break;
/*            case 6:
                question5Commit();
                break;*/
        }

        // Set the Question number header text
        ((TextView) findViewById(R.id.questionHeader)).setText("Question " + quizLayoutNumber);

        // Set the viewID string
        String viewID = "layoutQuestion" + (quizLayoutNumber);

        // Convert the viewID string into a view ID
        int resID = getResources().getIdentifier(viewID, "id", getPackageName());

        // Get the view and set it to visible
        View view = findViewById(resID);
        view.setVisibility(View.VISIBLE);
    }

    /**
     * Go to the first question and call he clearAnswers method to reset all quiz entries
     *
     * @param v
     */
    public void restartQuiz(View v) {
        String viewID = "layoutQuestion" + quizLayoutNumber;
        int resID = getResources().getIdentifier(viewID, "id", getPackageName());
        View view = findViewById(resID);
        view.setVisibility(View.GONE);
        clearAnswers();
        quizLayoutNumber = 1;
        showNextQuestion();
    }

    /**
     * Clear all the quiz entries
     */
    public void clearAnswers() {
        RadioGroup rG1 = (RadioGroup) findViewById(R.id.radioGroupQ1);
        rG1.clearCheck();
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkboxQ2A);
        cb1.setChecked(false);
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkboxQ2B);
        cb2.setChecked(false);
        CheckBox cb3 = (CheckBox) findViewById(R.id.checkboxQ2C);
        cb3.setChecked(false);
        CheckBox cb4 = (CheckBox) findViewById(R.id.checkboxQ2D);
        cb4.setChecked(false);
    }

    public void question1Commit() {
        //NEEDS TO OVERWRITE VALUE
        //userAnswers.add(q1AnswerID);
        //Integer now = userAnswers.get(0);
        //Toast.makeText(QuizActivity.this, String.valueOf(now), Toast.LENGTH_SHORT).show();
        //Toast.makeText(QuizActivity.this, String.valueOf(R.id.radioButtonQ1A), Toast.LENGTH_SHORT).show();
        // Toast.makeText(QuizActivity.this, String.valueOf(R.id.radioButtonQ1B), Toast.LENGTH_SHORT).show();
        //Toast.makeText(QuizActivity.this, String.valueOf(R.id.radioButtonQ1C), Toast.LENGTH_SHORT).show();
        //Toast.makeText(QuizActivity.this, String.valueOf(R.id.radioButtonQ1D), Toast.LENGTH_SHORT).show();
        //Toast.makeText(QuizActivity.this, message, Toast.LENGTH_SHORT).show();




        //int userAnsweredQ1 = q1AnswerID;


        // GET THE ID OF THE CORRECT ANSWER
        int correctAnswerQ1Id = R.id.radioButtonQ1C;

        // GET THE TEXT OF THE CORRECT ANSWER
        RadioButton rbCorrect = (RadioButton) findViewById(correctAnswerQ1Id) ;
        String correctAnswerTextQ1 = rbCorrect.getText().toString();

        // GET THE TEXT OF THE USERS ANSWER
        RadioButton rbUserAnswer = (RadioButton) findViewById(q1AnswerID);
        String userAnsweredTextQ1 = rbUserAnswer.getText().toString();

        //RadioButton rb = (RadioButton) findViewById(userAnsweredQ1);
        //String correctAnswerTextQ1 = rb.getText().toString();

        ((TextView) findViewById(R.id.q1YourAnswer)).setText(userAnsweredTextQ1);

        if (q1AnswerID == correctAnswerQ1Id) {
            TextView q1ResultText = (TextView) findViewById(q1Result);
            q1ResultText.setText(correctAnswerTextQ1);
            MainActivity.score++;
            //TextView q1Result = (TextView) findViewById(R.id.question1Result);
            //q1Result.setText("Hello");
            //Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
        }

    }

    public void question2Commit() {

    }

    public void question3Commit() {

    }

    public void question4Commit() {
        // Hide the next button
        Button hideNext = (Button) findViewById(next);
        hideNext.setVisibility(View.GONE);

        // Show the Finish button
        Button showFinish = (Button) findViewById(finish);
        showFinish.setVisibility(View.VISIBLE);
    }

    public void question5Commit() {
        finishQuiz();

    }

    public void finishQuiz() {
        // Find the main quiz view and hide it
        View view = findViewById(mainQuestionView);
        view.setVisibility(View.GONE);

        // Hide the Finish button
        Button hideFinish = (Button) findViewById(finish);
        hideFinish.setVisibility(View.GONE);

        // Toast message to user
        String scoreToastMessage = "Thank you for taking part in the quiz " + userName + " You scored " + score + " out of 5\n\nWhen this message finishes you will be able to see a breakdown of all the questions";
        Toast toast= Toast.makeText(getApplicationContext(), scoreToastMessage, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

        ScrollView resultsShow = (ScrollView) findViewById(resultsSummary);
        resultsShow.setVisibility(View.VISIBLE);
    }



}