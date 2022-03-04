package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button_start:Button=findViewById(R.id.btn_start);
        val input_start:EditText=findViewById(R.id.input_start);
        button_start.setOnClickListener {
            if(input_start.text.toString().isEmpty()){
                Toast.makeText(this,"Please, enter your name!",Toast.LENGTH_SHORT).show();
            }else{
                val intent = Intent(this,QuizQuestons::class.java);
                startActivity(intent)

            }
        }
    }
}//fgdf gdf g fd gfd g