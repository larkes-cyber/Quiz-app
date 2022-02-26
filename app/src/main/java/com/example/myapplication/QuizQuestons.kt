package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class QuizQuestons : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questons)

        val num_of_progress:TextView = findViewById(R.id.num_of_progress);

        val ProgressElem:ProgressBar = findViewById(R.id.progress);

        val tv_option_one:TextView = findViewById(R.id.tv_option_one);

        val tv_option_two:TextView = findViewById(R.id.tv_option_two);

        val tv_option_three:TextView = findViewById(R.id.tv_option_three);

        val tv_option_four:TextView = findViewById(R.id.tv_option_four);

        val question_img: ImageView = findViewById(R.id.question_img);

        val position = 1;

        val Questions = Constants.getQuestions();

        val forQuestion = Questions[position-1];

        ProgressElem.progress = position;

        num_of_progress.setText("${position}/10");

        tv_option_one.setText(forQuestion.optionOne);

        tv_option_two.setText(forQuestion.optionTwo);

        tv_option_three.setText(forQuestion.optionThree);

        tv_option_four.setText(forQuestion.optionFour);

        question_img.setImageResource(forQuestion.image);
    }
}