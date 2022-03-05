package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ScreenOfResults: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_of_results);
        val result:TextView = findViewById(R.id.textOfResults);
        val value = intent.extras!!.getString("value");
        result.setText("${value}/10");
        val button:Button=findViewById(R.id.button);
        button.setOnClickListener {
            val intent = Intent(this,::MainActivity::class.java);
            startActivity(intent)
        }
    }
}
//private val value = valueOfAnswerToQuestions;