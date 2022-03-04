package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.*
import com.example.myapplication.Constants.getQuestions


class QuizQuestons: AppCompatActivity() {

    private var countOfPages = 0;

    private var flagOfCheck= true;

    private lateinit var selectedQuestion:TextView;

    private var theRightAnswers:Int = 0;

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

        onUpdateQuestions(countOfPages, arrayOfElements);

        button.setOnClickListener{

            if(flagOfCheck){
                checkTrueAnswer(countOfPages, arrayOfElements, selectedQuestion);
                flagOfCheck=false;
            }
            else{
                setDefaultBorder(arrayOfElements);
                countOfPages++;
                if(countOfPages==10){
                    val intent = Intent(this,ScreenOfResults::class.java);
                    intent.putExtra("value", theRightAnswers.toString());
                    startActivity(intent)
                    return@setOnClickListener;
                }
                uploadOfProgress();
                onUpdateQuestions(countOfPages, arrayOfElements);
                flagOfCheck = true;
            }

        }


    }

    private fun uploadOfProgress(){

        val progress:ProgressBar = findViewById(R.id.progress);
        val numOfProgress:TextView = findViewById(R.id.num_of_progress);

        progress.setProgress(countOfPages);
        numOfProgress.setText("${countOfPages}/10");

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
        else{
            theRightAnswers++;
        }

    }


    private fun selectedThis(view:TextView, arrayOfElems:ArrayList<TextView>){
        setDefaultBorder(arrayOfElems);
        view.setBackgroundResource(R.drawable.selected_elem);
        selectedQuestion=view;
    }

    private fun onUpdateQuestions(count:Int, arrayOfElems:ArrayList<TextView>){

        val question_img: ImageView = findViewById(R.id.question_img);
        val tv_question:TextView = findViewById(R.id.tv_question);

        val Data:Question=getQuestions(count);

        question_img.setImageResource(Data.image);
        tv_question.setText(Data.question);
        arrayOfElems[0].setText(Data.optionOne);
        arrayOfElems[1].setText(Data.optionTwo);
        arrayOfElems[2].setText(Data.optionThree);
        arrayOfElems[3].setText(Data.optionFour);

    }

}
