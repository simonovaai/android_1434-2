package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Resultgame extends AppCompatActivity {
    private TextView showResult;
    private ArrayList<String> resAnswer = new ArrayList<String>();
    private String strResult;
    //private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultgame);

        resAnswer = getIntent().getStringArrayListExtra("showResult");
        showResult = findViewById(R.id.showResult);
        for(int i=0; i<resAnswer.size(); i++){
            if(strResult == null)
                strResult = resAnswer.get(i);
            else
                strResult = strResult+resAnswer.get(i);
        }
        showResult.setText(strResult);
    }
}
