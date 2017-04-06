package com.weirdresoance.android.stargatequiz;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.attr.name;
import static com.weirdresoance.android.stargatequiz.MainActivity.score;
import static com.weirdresoance.android.stargatequiz.MainActivity.userName;
import static com.weirdresoance.android.stargatequiz.R.id.checkboxQ2A;
import static com.weirdresoance.android.stargatequiz.R.id.checkboxQ2B;
import static com.weirdresoance.android.stargatequiz.R.id.checkboxQ2C;
import static com.weirdresoance.android.stargatequiz.R.id.checkboxQ2D;
import static com.weirdresoance.android.stargatequiz.R.id.finish;
import static com.weirdresoance.android.stargatequiz.R.id.mainQuestionView;
import static com.weirdresoance.android.stargatequiz.R.id.next;
import static com.weirdresoance.android.stargatequiz.R.id.q1Correct;
import static com.weirdresoance.android.stargatequiz.R.id.q3Answer;
import static com.weirdresoance.android.stargatequiz.R.id.radioButtonQ1A;
import static com.weirdresoance.android.stargatequiz.R.id.radioButtonQ4A;
import static com.weirdresoance.android.stargatequiz.R.id.restart;
import static com.weirdresoance.android.stargatequiz.R.id.resultsSummary;


public class QuizActivity extends AppCompatActivity {

    RadioButton radioButton;
    //CheckBox checkBox;
    int quizLayoutNumber = 1;
    boolean isAnswered = false;
    int q1AnswerID;
    int q4AnswerID;
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
                case checkboxQ2B:
                    if (checked) q2checkedCount++;
                    else q2checkedCount--;
                    break;
                case checkboxQ2C:
                    if (checked)
                        q2checkedCount++;
                    else q2checkedCount--;
                    break;
                case checkboxQ2D:
                    if (checked)
                        q2checkedCount++;
                    else q2checkedCount--;
                    break;
            }

        } else {
            Toast.makeText(QuizActivity.this, R.string.tooManyChecked, Toast.LENGTH_SHORT).show();
            CheckBox checkBoxA = (CheckBox) findViewById(R.id.checkboxQ2A);
            checkBoxA.setChecked(false);
            CheckBox checkBoxB = (CheckBox) findViewById(checkboxQ2B);
            checkBoxB.setChecked(false);
            CheckBox checkBoxC = (CheckBox) findViewById(checkboxQ2C);
            checkBoxC.setChecked(false);
            CheckBox checkBoxD = (CheckBox) findViewById(checkboxQ2D);
            checkBoxD.setChecked(false);
            q2checkedCount = 0;
            isAnswered = false;
        }

        if (q2checkedCount == 2) {
            isAnswered = true;
        } else isAnswered = false;
    }

    // Question 1 Radio Buttons onClick
    public void onRadioButtonClickedQ4(View view) {
        // Set the isAnswered boolean to true as we wouldn't be here if the user hadn't click on a radiobutton
        isAnswered = true;

        // Check which radio button was clicked
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButtonQ4A:
                if (checked)
                    q4AnswerID = radioButtonQ4A;
                radioButton = (RadioButton) findViewById(radioButtonQ4A);
                break;
            case R.id.radioButtonQ4B:
                if (checked)
                    q4AnswerID = R.id.radioButtonQ4B;
                radioButton = (RadioButton) findViewById(R.id.radioButtonQ4B);
                break;
            case R.id.radioButtonQ4C:
                if (checked)
                    q4AnswerID = R.id.radioButtonQ4C;
                radioButton = (RadioButton) findViewById(R.id.radioButtonQ4C);
                break;
            case R.id.radioButtonQ4D:
                if (checked)
                    q4AnswerID = R.id.radioButtonQ4D;
                radioButton = (RadioButton) findViewById(R.id.radioButtonQ4D);
                break;
        }
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
        CheckBox cb2 = (CheckBox) findViewById(checkboxQ2B);
        cb2.setChecked(false);
        CheckBox cb3 = (CheckBox) findViewById(checkboxQ2C);
        cb3.setChecked(false);
        CheckBox cb4 = (CheckBox) findViewById(checkboxQ2D);
        cb4.setChecked(false);
    }

    public void question1Commit() {
        // GET THE ID OF THE CORRECT ANSWER
        int correctAnswerQ1Id = R.id.radioButtonQ1C;

        // GET THE TEXT OF THE CORRECT ANSWER
        RadioButton rbCorrectQ1 = (RadioButton) findViewById(correctAnswerQ1Id) ;
        String correctAnswerTextQ1 = rbCorrectQ1.getText().toString();

        // GET THE TEXT OF THE USERS ANSWER
        RadioButton rbUserAnswer = (RadioButton) findViewById(q1AnswerID);
        String userAnsweredTextQ1 = rbUserAnswer.getText().toString();

        // Set the text for the Users answer TextView
        ((TextView) findViewById(R.id.q1YourAnswer)).setText(userAnsweredTextQ1);

        // Increment the score if they answered correctly
        if (q1AnswerID == correctAnswerQ1Id) {
            MainActivity.score++;

            // Get the You Answered Correctly view and set it to visible
            View view = findViewById(R.id.q1Correct);
            view.setVisibility(View.VISIBLE);
        } else {
            View view = findViewById(R.id.q1InCorrect);
            view.setVisibility(View.VISIBLE);
        }

    }

    public void question2Commit() {

        // Get the ID's of the correct answers
        int correctAnswerQ2_1 = checkboxQ2B;
        int correctAnswerQ2_2 = checkboxQ2D;

        // Create the ArrayList to store which checkboxes the users has checked
        ArrayList<Integer> userAnswersQ2 = new ArrayList<>();

        // Get the ID of the users answers and them to the userAnswersQ2 ArrayList
        CheckBox cbUserAnswerQ2_1 = (CheckBox) findViewById(checkboxQ2A);
        if (cbUserAnswerQ2_1.isChecked()) {
            userAnswersQ2.add(checkboxQ2A);
        }

        CheckBox cbUserAnswerQ2_2 = (CheckBox) findViewById(checkboxQ2B);
        if (cbUserAnswerQ2_2.isChecked()) {
            userAnswersQ2.add(checkboxQ2B);
        }

        CheckBox cbUserAnswerQ2_3 = (CheckBox) findViewById(checkboxQ2C);
        if (cbUserAnswerQ2_3.isChecked()) {
            userAnswersQ2.add(checkboxQ2C);
        }

        CheckBox cbUserAnswerQ2_4 = (CheckBox) findViewById(checkboxQ2D);
        if (cbUserAnswerQ2_4.isChecked()) {
            userAnswersQ2.add(checkboxQ2D);
        }

        // GET THE TEXT OF THE USERS ANSWER
        CheckBox cbUserAnswer_1 = (CheckBox) findViewById(userAnswersQ2.get(0));
        String userAnsweredTextQ2_1 = cbUserAnswer_1.getText().toString();

        CheckBox cbUserAnswer_2 = (CheckBox) findViewById(userAnswersQ2.get(1));
        String userAnsweredTextQ2_2 = cbUserAnswer_2.getText().toString();

        // If the user has checked the two correct checkboxes then increment the score counter
        if ((userAnswersQ2.get(0) == correctAnswerQ2_1) && (userAnswersQ2.get(1) == correctAnswerQ2_2)) {
            MainActivity.score++;

            // Get the You Answered Correctly view and set it to visible
            View view = findViewById(R.id.q2Correct);
            view.setVisibility(View.VISIBLE);
        } else {
            View view = findViewById(R.id.q2InCorrect);
            view.setVisibility(View.VISIBLE);
        }

        // Add the users answers text to the you answered views
        ((TextView) findViewById(R.id.q2_1YourAnswer)).setText(userAnsweredTextQ2_1);
        ((TextView) findViewById(R.id.q2_2YourAnswer)).setText(userAnsweredTextQ2_2);
    }

    public void question3Commit() {
        // Get the entry to the EditText box
        EditText q3Answer = (EditText) findViewById(R.id.q3Entry);
        String userAnsweredTextQ3 = q3Answer.getText().toString();

        if (userAnsweredTextQ3.equals("9")) {
            MainActivity.score++;

            // Get the You Answered Correctly view and set it to visible
            View view = findViewById(R.id.q3Correct);
            view.setVisibility(View.VISIBLE);

        } else {
            View view = findViewById(R.id.q3InCorrect);
            view.setVisibility(View.VISIBLE);
        }

        ((TextView) findViewById(R.id.q3_YourAnswer)).setText(userAnsweredTextQ3);
    }

    public void question4Commit() {
        // GET THE ID OF THE CORRECT ANSWER
        int correctAnswerQ4Id = R.id.radioButtonQ4D;

        // GET THE TEXT OF THE CORRECT ANSWER
        RadioButton rbCorrectQ4 = (RadioButton) findViewById(correctAnswerQ4Id) ;
        String correctAnswerTextQ4 = rbCorrectQ4.getText().toString();

        // GET THE TEXT OF THE USERS ANSWER
        RadioButton rbUserAnswer = (RadioButton) findViewById(q4AnswerID);
        String userAnsweredTextQ4 = rbUserAnswer.getText().toString();

        // Set the text for the Users answer TextView
        ((TextView) findViewById(R.id.q4YourAnswer)).setText(userAnsweredTextQ4);

        // Increment the score if they answered correctly
        if (q4AnswerID == correctAnswerQ4Id) {
            MainActivity.score++;

            // Get the You Answered Correctly view and set it to visible
            View view = findViewById(R.id.q4Correct);
            view.setVisibility(View.VISIBLE);
        } else {
            View view = findViewById(R.id.q4InCorrect);
            view.setVisibility(View.VISIBLE);
        }

        // Hide the next button
        Button hideNext = (Button) findViewById(next);
        hideNext.setVisibility(View.GONE);

        // Show the Finish button
        Button showFinish = (Button) findViewById(finish);
        showFinish.setVisibility(View.VISIBLE);
    }

    public void question5Commit() {
        // Get the entry in the EditText box
        EditText q5Answer = (EditText) findViewById(R.id.q5Entry);
        String userAnsweredTextQ5 = q5Answer.getText().toString();

        // Convert both strings to uppercase to compare
        String q5CorrectAnswerUpper = getString(R.string.answer5).toUpperCase();

        if (userAnsweredTextQ5.toUpperCase().equals(q5CorrectAnswerUpper)) {
            MainActivity.score++;

            // Get the You Answered Correctly view and set it to visible
            View view = findViewById(R.id.q5Correct);
            view.setVisibility(View.VISIBLE);

        } else {
            View view = findViewById(R.id.q5InCorrect);
            view.setVisibility(View.VISIBLE);
        }

        ((TextView) findViewById(R.id.q5_YourAnswer)).setText(userAnsweredTextQ5);
        finishQuiz();

    }

    public void finishQuiz() {
        // Find the main quiz view and hide it
        View view = findViewById(mainQuestionView);
        view.setVisibility(View.GONE);

        // Hide the Finish button
        Button hideFinish = (Button) findViewById(finish);
        hideFinish.setVisibility(View.GONE);

        // Hide the restart button but add a new one at the bottom of the scrollview
        Button hideRestart = (Button) findViewById(restart);
        hideRestart.setVisibility(View.GONE);

        // Toast message to user
        String scoreToastMessage = "Thank you for taking part in the quiz " + userName + " You scored " + MainActivity.score + " out of 5\n\nWhen this message finishes you will be able to see a breakdown of all the questions";
        Toast toast= Toast.makeText(getApplicationContext(), scoreToastMessage, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

        ScrollView resultsShow = (ScrollView) findViewById(resultsSummary);
        resultsShow.setVisibility(View.VISIBLE);
    }



}