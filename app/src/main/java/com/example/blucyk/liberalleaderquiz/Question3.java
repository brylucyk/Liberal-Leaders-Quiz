package com.example.blucyk.liberalleaderquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Question3 extends AppCompatActivity implements IQuestion {

    final String [] rdoBtnIds = {"bobRaeBtn", "mikeHarrisBtn", "dougFordBtn", "kathleenWynneBtn"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
    }

    /**
     * OnClick function for the submit button.
     * Checks if the user has entered the correct answer.
     * @param v: view for the current activity
     */
    public void checkAnswer(View v) {
        boolean correctAnswer = false;

        RadioButton radioButton = findViewById(R.id.kathleenWynneBtn);

        if(radioButton.isChecked()) {
            correctAnswer = true;
        }

        displayResult(correctAnswer);
    }

    /**
     * Will notify the user of a correct answer, and change the rightImg and results text
     * accordingly. Calls changeBtnPath().
     * @param correctAnswer: true if user's answer was correct, false if not
     */
    public void displayResult(boolean correctAnswer) {
        TextView resultsText = findViewById(R.id.resultsText);
        ImageView rightImg = findViewById(R.id.rightImg);

        if(correctAnswer) {
            resultsText.setText(getString(R.string.answer_correct));
            rightImg.setImageResource(R.drawable.circle_kw);
            rightImg.setContentDescription(getString(R.string.kw_imgDesc));

            // disable buttons
            for (String rdoBtnId : rdoBtnIds) {
                RadioButton radioButton = findViewById(getResources().getIdentifier(rdoBtnId, "id", getPackageName()));
                radioButton.setEnabled(false);
            }
        }
        else {
            resultsText.setText(R.string.answer_incorrect);
        }

        Button submitBtn = findViewById(R.id.submitBtn);
        changeBtnPath(correctAnswer, submitBtn);
    }

    /**
     * Changes the behaviour of the submit button so that the user can proceed.
     * @param submitBtn: true if user's answer was correct, false if not
     */
    public void changeBtnPath(Boolean correctAnswer, Button submitBtn) {
        if(correctAnswer) {
            submitBtn.setText(getString(R.string.close_btn));

            submitBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    finish();
                }
            });
        }
        else {
            submitBtn.setText(getString(R.string.submit_btn));

            submitBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    checkAnswer(findViewById(android.R.id.content));
                }
            });
        }
    }

    @Override
    protected void onPause() {
        SharedPreferences settings = getSharedPreferences("datapersistance", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        // find which radio button was checked
        for (String rdoBtnId : rdoBtnIds) {
            RadioButton radioButton = findViewById(getResources().getIdentifier(rdoBtnId, "id", getPackageName()));
            if (radioButton.isChecked()) {
                editor.putString("q3_btn_checked", rdoBtnId);
            }
        }

        editor.apply();

        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences settings = getSharedPreferences("datapersistance",Context.MODE_PRIVATE);
        String btnChecked = settings.getString("q3_btn_checked", null);

        if(btnChecked != null) {
            RadioGroup rg = findViewById(R.id.questionOptions);
            rg.check(getResources().getIdentifier(btnChecked, "id", getPackageName()));
        }

        if(btnChecked != null) {
            RadioGroup rg = findViewById(R.id.questionOptions);
            rg.check(getResources().getIdentifier(btnChecked, "id", getPackageName()));
            checkAnswer(findViewById(android.R.id.content));
        }
    }

}