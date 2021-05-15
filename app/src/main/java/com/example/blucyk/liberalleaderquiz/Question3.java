package com.example.blucyk.liberalleaderquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class Question3 extends AppCompatActivity implements IQuestion {

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

        affectResult(correctAnswer);
    }

    /**
     * Will notify the user of a correct answer, and change the rightImg and results text
     * accordingly. On correct answer, will also give the user the ability to close the app.
     * @param correctAnswer: true if user's answer was correct, false if not
     */
    public void affectResult(boolean correctAnswer) {
        TextView resultsText = findViewById(R.id.resultsText);
        ImageView rightImg = findViewById(R.id.rightImg);

        if(correctAnswer) {
            resultsText.setText(getString(R.string.answer_correct));
            rightImg.setImageResource(R.drawable.circle_kw);
            rightImg.setContentDescription(getString(R.string.kw_imgDesc));
            Button submitBtn = findViewById(R.id.submitBtn);
            submitBtn.setText(getString(R.string.close_btn));
            submitBtn.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    finish();
                }
            });
        }
        else {
            resultsText.setText(R.string.answer_incorrect);
        }
    }

}