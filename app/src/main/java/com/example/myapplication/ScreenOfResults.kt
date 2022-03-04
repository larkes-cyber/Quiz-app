package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ScreenOfResults: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_of_results);
        val result:TextView = findViewById(R.id.textOfResults);
        val value = intent.extras!!.getString("value");
        result.setText(value);
    }
}
//private val value = valueOfAnswerToQuestions;