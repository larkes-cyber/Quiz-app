package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.*
import com.example.myapplication.Constants.getQuestions


class QuizQuestons : AppCompatActivity() {

    private var countOfPages = 0;

    private var flagOfCheck= true;

    private lateinit var selectedQuestion:TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questons)

        val tv_option_one:TextView = findViewById(R.id.tv_option_one);
        val tv_option_two:TextView = findViewById(R.id.tv_option_two);
        val tv_option_three:TextView = findViewById(R.id.tv_option_three);
        val tv_option_four:TextView = findViewById(R.id.tv_option_four);

        val arrayOfElements:ArrayList<TextView> = java.util.ArrayList();

        arrayOfElements.add(tv_option_one);
        arrayOfElements.add(tv_option_two);
        arrayOfElements.add(tv_option_three);
        arrayOfElements.add(tv_option_four);

        val button:Button=findViewById(R.id.btn_submit);

        for(elem in arrayOfElements){
            elem.setOnClickListener{
                if(flagOfCheck) selectedThis(elem, arrayOfElements);
            }
        }

        onUpdateQuestions(1, arrayOfElements);

        button.setOnClickListener{
            if(flagOfCheck){
                checkTrueAnswer(1, arrayOfElements, selectedQuestion);
                flagOfCheck=false;
            }

        }


    }

    private fun setDefaultBorder(arrayOfElems:ArrayList<TextView>){

        arrayOfElems.forEach {
            elem -> elem.setBackgroundResource(R.drawable.default_option_border_bg);
        }

    }

    private fun checkTrueAnswer(count:Int, arrayOfElems:ArrayList<TextView>, selectedQuestion:TextView){

        setDefaultBorder(arrayOfElems);

        val Data:Question=getQuestions(count);
        val numOfAnswer:Int = Data.answer;

        arrayOfElems[numOfAnswer-1].setBackgroundResource(R.drawable.the_right_question);

        if(selectedQuestion != arrayOfElems[numOfAnswer-1]){
            selectedQuestion.setBackgroundResource(R.drawable.is_not_right_answer);
        }

    }


    private fun selectedThis(view:TextView, arrayOfElems:ArrayList<TextView>){
        setDefaultBorder(arrayOfElems);
        view.setBackgroundResource(R.drawable.selected_elem);
        selectedQuestion=view;
    }

    private fun onUpdateQuestions(count:Int, arrayOfElems:ArrayList<TextView>){

        val question_img: ImageView = findViewById(R.id.question_img);

        val Data:Question=getQuestions(count);

        arrayOfElems[0].setText(Data.optionOne);
        arrayOfElems[1].setText(Data.optionTwo);
        arrayOfElems[2].setText(Data.optionThree)
        arrayOfElems[3].setText(Data.optionFour)

    }

}

//fg gf hfg
//        val position = 1;
////SAD
//        val Questions = Constants.getQuestions();
//
//        val forQuestion = Questions[position-1];
//
//        ProgressElem.progress = position;
//
//        num_of_progress.setText("${position}/10");
//
//        tv_option_one.setText(forQuestion.optionOne);
//
//        tv_option_two.setText(forQuestion.optionTwo);
//
//        tv_option_three.setText(forQuestion.optionThree);
//
//        tv_option_four.setText(forQuestion.optionFour);
//
//        question_img.setImageResource(forQuestion.image);

//        val num_of_progress:TextView = findViewById(R.id.num_of_progress);
//
//        val ProgressElem:ProgressBar = findViewById(R.id.progress);