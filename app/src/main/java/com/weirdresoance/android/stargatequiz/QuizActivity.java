package com.weirdresoance.android.stargatequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;

import java.util.ArrayList;

import static com.weirdresoance.android.stargatequiz.MainActivity.score;
import static com.weirdresoance.android.stargatequiz.MainActivity.userName;
import static com.weirdresoance.android.stargatequiz.R.id.checkboxQ2A;
import static com.weirdresoance.android.stargatequiz.R.id.checkboxQ2B;
import static com.weirdresoance.android.stargatequiz.R.id.checkboxQ2C;
import static com.weirdresoance.android.stargatequiz.R.id.checkboxQ2D;
import static com.weirdresoance.android.stargatequiz.R.id.layout6;
import static com.weirdresoance.android.stargatequiz.R.id.mainQuestionView;
import static com.weirdresoance.android.stargatequiz.R.id.next;
import static com.weirdresoance.android.stargatequiz.R.id.radioButtonQ1A;
import static com.weirdresoance.android.stargatequiz.R.id.radioButtonQ4A;
import static com.weirdresoance.android.stargatequiz.R.id.restart;


public class QuizActivity extends AppCompatActivity {

    // Declare variables
    RadioButton radioButton;
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

    /**
     * Question 1 Radio Buttons onClick
     *
     * @param v
     */
    public void onRadioButtonClickedQ1(View v) {
        // Set the isAnswered boolean to true as we wouldn't be here if the user hadn't click on a radiobutton
        isAnswered = true;

        // Check which radio button was clicked
        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()) {
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

    /**
     * Question 2 checkboxes
     *
     * @param v
     */
    public void onCheckboxClickedQ2(View v) {
        if (q2checkedCount < 2) {
            // Check which checkbox was clicked
            boolean checked = ((CheckBox) v).isChecked();
            switch (v.getId()) {
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
            // Check the user hasn't checked too many boxes. If they have clear them all
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

        // Set isAnswered to true if the user has checked the correct amount of boxes
        if (q2checkedCount == 2) {
            isAnswered = true;
        } else isAnswered = false;
    }

    /**
     * Question 4 Radio Buttons onClick
     *
     * @param v
     */
    public void onRadioButtonClickedQ4(View v) {
        // Set the isAnswered boolean to true as we wouldn't be here if the user hadn't click on a radiobutton
        isAnswered = true;

        // Check which radio button was clicked
        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()) {
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
        // Check to see if text entry fields have anything in them for questions 3 and 5
        EditText isQ3Answered = (EditText) findViewById(R.id.q3Entry);
        String q3FieldBlank = isQ3Answered.getText().toString();
        EditText isQ5Answered = (EditText) findViewById(R.id.q5Entry);
        String q5FieldBlank = isQ5Answered.getText().toString();
        if (!q3FieldBlank.matches("") && (quizLayoutNumber == 3)) {
            isAnswered = true;
        }
        if (!q5FieldBlank.matches("") && (quizLayoutNumber == 5)) {
            isAnswered = true;
        }

        // Check to make sure the user has answered the question before proceeding
        if (isAnswered) {
            // Create a string for the ID of the current view
            String viewID = "layout" + quizLayoutNumber;

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

            showNextQuestion();
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
            case 6:
                question5Commit();
                break;
        }

        // Set the Question number header text
        ((TextView) findViewById(R.id.questionHeader)).setText(getString(R.string.questionNumberText) + " " + quizLayoutNumber);

        // Set the viewID string
        String viewID = getString(R.string.layoutText) + (quizLayoutNumber);

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
        String viewID = "layout" + quizLayoutNumber;
        int resID = getResources().getIdentifier(viewID, "id", getPackageName());
        View view = findViewById(resID);
        view.setVisibility(View.GONE);
        clearAnswers();

        // Check if the mainQuestionView is visible and if it isn't show it
        View mainView = findViewById(mainQuestionView);

        if (!mainView.isShown()) {
            mainView = findViewById(mainQuestionView);
            mainView.setVisibility(View.VISIBLE);

            // Change the text in the next button to Next
            Button changeToFinish = (Button) findViewById(next);
            changeToFinish.setText(R.string.nextButtonText);

            // Show the Next button
            Button hideFinish = (Button) findViewById(next);
            hideFinish.setVisibility(View.VISIBLE);

            // Show the Restart button but add a new one at the bottom of the scrollview
            Button hideRestart = (Button) findViewById(restart);
            hideRestart.setVisibility(View.VISIBLE);
        }

        // Set the quizLayoutNumber back to 1 so the first question will be shown when ShowNextQuestion is called
        quizLayoutNumber = 1;
        showNextQuestion();
    }

    /**
     * Clear all the quiz entries
     */
    public void clearAnswers() {
        // Clear Q1 RadioGroup
        RadioGroup rG1 = (RadioGroup) findViewById(R.id.radioGroupQ1);
        rG1.clearCheck();

        // Clear Q2 CheckBoxes
        CheckBox cbQ2A = (CheckBox) findViewById(R.id.checkboxQ2A);
        cbQ2A.setChecked(false);
        CheckBox cbQ2B = (CheckBox) findViewById(R.id.checkboxQ2B);
        cbQ2B.setChecked(false);
        CheckBox cbQ2C = (CheckBox) findViewById(R.id.checkboxQ2C);
        cbQ2C.setChecked(false);
        CheckBox cbQ2D = (CheckBox) findViewById(R.id.checkboxQ2D);
        cbQ2D.setChecked(false);
        q2checkedCount = 0;

        // Clear Q3
        EditText q3Answer = (EditText) findViewById(R.id.q3Entry);
        q3Answer.setText("");

        // Clear Q4
        RadioGroup rG4 = (RadioGroup) findViewById(R.id.radioGroupQ4);
        rG4.clearCheck();

        // Clear Q5
        EditText q5Answer = (EditText) findViewById(R.id.q5Entry);
        q5Answer.setText("");

        // Reset well done and sorry views to Gone
        findViewById(R.id.q1Correct).setVisibility(View.GONE);
        findViewById(R.id.q1InCorrect).setVisibility(View.GONE);
        findViewById(R.id.q2Correct).setVisibility(View.GONE);
        findViewById(R.id.q2InCorrect).setVisibility(View.GONE);
        findViewById(R.id.q3Correct).setVisibility(View.GONE);
        findViewById(R.id.q3InCorrect).setVisibility(View.GONE);
        findViewById(R.id.q4Correct).setVisibility(View.GONE);
        findViewById(R.id.q4InCorrect).setVisibility(View.GONE);
        findViewById(R.id.q5Correct).setVisibility(View.GONE);
        findViewById(R.id.q5InCorrect).setVisibility(View.GONE);

        // Set the results scrollview page back to the top
        findViewById(R.id.layout6).scrollTo(0, 0);

        // Set isAnswered and score to false and 0
        isAnswered = false;
        score = 0;
    }

    /**
     * Commit the answers in question 1 to the results page view
     */
    public void question1Commit() {
        // GET THE ID OF THE CORRECT ANSWER
        int correctAnswerQ1Id = R.id.radioButtonQ1C;

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

    /**
     * Commit the answers in question 2 to the results page view
     */
    public void question2Commit() {
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
        if ((userAnswersQ2.get(0) == checkboxQ2B) && (userAnswersQ2.get(1) == checkboxQ2D)) {
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

    /**
     * Commit the answers in question 3 to the results page view
     */
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

    /**
     * Commit the answers in question 4 to the results page view
     */
    public void question4Commit() {
        // GET THE ID OF THE CORRECT ANSWER
        int correctAnswerQ4Id = R.id.radioButtonQ4D;

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

        // Change the text in the next button to Finish
        Button changeToFinish = (Button) findViewById(next);
        changeToFinish.setText(R.string.finishButtonText);
    }

    /**
     * Commit the answers in question 5 to the results page view
     */
    public void question5Commit() {
        // Get the entry in the EditText box
        EditText q5Answer = (EditText) findViewById(R.id.q5Entry);
        String userAnsweredTextQ5 = q5Answer.getText().toString().trim();

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

    /**
     * Hide the main question view and show the final results view
     */
    public void finishQuiz() {
        // Find the main quiz view and hide it
        View view = findViewById(mainQuestionView);
        view.setVisibility(View.GONE);

        // Hide the Finish button
        Button hideFinish = (Button) findViewById(next);
        hideFinish.setVisibility(View.GONE);

        // Hide the restart button but add a new one at the bottom of the scrollview
        Button hideRestart = (Button) findViewById(restart);
        hideRestart.setVisibility(View.GONE);

        // Toast message to user
        String scoreToastMessage = "Thank you for taking part in the quiz " + userName + " You scored " + MainActivity.score + " out of 5\n\nWhen this message finishes you will be able to see a breakdown of all the questions";
        Toast toast = Toast.makeText(getApplicationContext(), scoreToastMessage, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);

        // Increase the text size in the Toast and then show it
        ViewGroup group = (ViewGroup) toast.getView();
        TextView messageTextView = (TextView) group.getChildAt(0);
        messageTextView.setTextSize(20);

        toast.show();

        // Set the users score at the top of the page
        ((TextView) findViewById(R.id.score)).setText("You scored " + MainActivity.score + " /5");

        ScrollView resultsShow = (ScrollView) findViewById(layout6);
        resultsShow.setVisibility(View.VISIBLE);
    }

}