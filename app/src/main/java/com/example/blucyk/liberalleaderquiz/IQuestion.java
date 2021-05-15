package com.example.blucyk.liberalleaderquiz;

import android.view.View;

public interface IQuestion {

    /**
     * OnClick function for the submit button.
     * Checks if the user has entered the correct answer.
     * @param  v: view for the current activity
     */
    void checkAnswer(View v);

    /**
     * Will notify the user of a correct answer, and change the rightImg and results text
     * accordingly. On correct answer, will also give the user the ability to close the app.
     * @param correctAnswer: true if user's answer was correct, false if not
     */
    void affectResult(boolean correctAnswer);
}
