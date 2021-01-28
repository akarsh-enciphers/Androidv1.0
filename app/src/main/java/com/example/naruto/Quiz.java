package com.example.naruto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {
    TextView v1;
    Button b1;
    RadioButton r1,r2,r3,r4;
    static int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        b1=(Button)findViewById(R.id.button6);
        v1=(TextView)findViewById(R.id.textView4);
        r1=(RadioButton)findViewById(R.id.radioButton);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r3=(RadioButton)findViewById(R.id.radioButton3);
        r4=(RadioButton)findViewById(R.id.radioButton4);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score=0;
                if(r3.isChecked()){
                    ++score;
                }
                else{
                    --score;
                }
                Intent j=new Intent(Quiz.this,Quiz2.class);
                startActivity(j);
                finish();
            }
        });
    }
}