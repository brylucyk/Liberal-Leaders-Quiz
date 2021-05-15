package com.example.blucyk.liberalleaderquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class Question2 extends AppCompatActivity implements IQuestion {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
    }

    /**
     * OnClick function for the submit button.
     * Checks if the user has entered the correct answer.
     * @param v: view for the current activity
     */
    public void checkAnswer(View v) {
        boolean correctAnswer = false;

        RadioButton radioButton = findViewById(R.id.georgeBrownBtn);

        if(radioButton.isChecked()) {
            correctAnswer = true;
        }

        affectResult(correctAnswer);
    }

    /**
     * Will notify the user of a correct answer, and change the rightImg and results text
     * accordingly. On correct answer, will also give the user the ability to advance to
     * the next question.
     * @param correctAnswer: true if user's answer was correct, false if not
     */
    public void affectResult(boolean correctAnswer) {
        TextView resultsText = findViewById(R.id.resultsText);
        ImageView rightImg = findViewById(R.id.rightImg);

        if(correctAnswer) {
            resultsText.setText(getString(R.string.answer_correct));
            rightImg.setImageResource(R.drawable.circle_gb);
            rightImg.setContentDescription(getString(R.string.gb_imgDesc));
            Button submitBtn = findViewById(R.id.submitBtn);
            submitBtn.setText(getString(R.string.next_btn));
            submitBtn.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent intent = new Intent(v.getContext(), Question3.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        else {
            resultsText.setText(R.string.answer_incorrect);
        }
    }
}