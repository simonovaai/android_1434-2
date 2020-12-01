package com.example.myapplication2;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button yesBtn;
    private Button noBtn;
    private Button showAnswer;
    private Question[] questions = new Question[]{
            new Question(R.string.question1, true),
            new Question(R.string.question2, false),
            new Question(R.string.question3, false),
            new Question(R.string.question4, true),
            new Question(R.string.question5, true)
    };
    private ArrayList<String> colAnswer = new ArrayList<String>();
    String resValue;
    String strResult;
    private int questionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("System INFO","Метод onCreate() запущен");
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            questionIndex = savedInstanceState.getInt("questionIndex");
        }

        textView = findViewById(R.id.textView);
        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);
        showAnswer = findViewById(R.id.showAnswer);

        resValue = null;
        textView.setText(questions[questionIndex].getQuestionResId());
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questions[questionIndex].isAnswerTrue()){
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    resValue = getResources().getString(R.string.correct);
                }else{
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                    resValue = getResources().getString(R.string.incorrect);
                }
                colAnswer.add(questionIndex, textView.getText().toString()+" "+
                        getResources().getString(R.string.yes)+" Ответ: "+resValue+"\n");
                //strResult = strResult+questions[questionIndex]+" "+R.string.yes+" Ответ: "+resValue+"\n";

                questionIndex++;

                if(questionIndex == questions.length){
                    Intent intentres = new Intent(MainActivity.this, Resultgame.class);
                    intentres.putStringArrayListExtra("showResult",colAnswer);
                    startActivity(intentres);

                    questionIndex=0;
                }else
                    textView.setText(questions[questionIndex].getQuestionResId());
                //if(questionIndex==0) {
                //    textView.setText(questions[questionIndex].getQuestionResId());
                //    colAnswer.clear();
                //}
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questions[questionIndex].isAnswerTrue()) {
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                    resValue = getResources().getString(R.string.incorrect);
                }else {
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    resValue = getResources().getString(R.string.correct);
                }

                colAnswer.add(questionIndex, textView.getText().toString()+" "+
                        getResources().getString(R.string.no)+" Ответ: "+resValue+"\n");
                //strResult = strResult+questions[questionIndex]+" "+R.string.no+" Ответ: "+resValue+"\n";

                questionIndex++;

                if(questionIndex == questions.length){
                    Intent intentres = new Intent(MainActivity.this, Resultgame.class);
                    intentres.putStringArrayListExtra("showResult",colAnswer);
                    startActivity(intentres);

                    questionIndex=0;
                }else
                    textView.setText(questions[questionIndex].getQuestionResId());
                //if(questionIndex==0) {
                //    textView.setText(questions[questionIndex].getQuestionResId());
                //    colAnswer.clear();
                //}
            }
        });
        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer",questions[questionIndex].isAnswerTrue());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("System INFO","Метод onStart() запущен");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d("System INFO","Метод onResume() запущен");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("System INFO","Метод onPause() запущен");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d("System INFO","Метод onSaveInstanceState() запущен");
        savedInstanceState.putInt("questionIndex",questionIndex);
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d("System INFO","Метод onStop() запущен");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("System INFO","Метод onDestroy() запущен");
    }
}
