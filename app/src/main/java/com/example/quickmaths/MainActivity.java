package com.example.quickmaths;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button goButton;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationofcorrectanswer;
    int wrongAnswer;
    TextView correctTextview;
    int score = 0;
    int hits = 0;
    TextView scoreTextview;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView quesTextview;
    TextView timerTextView2;
    Button playAgain;
    ConstraintLayout gamelayout;


    public void playAgain(View view) {
        score = 0;
        hits = 0;
        timerTextView2.setText("30s");
        scoreTextview.setText(Integer.toString(score) + "/" + Integer.toString(hits));
        newQues();
        playAgain.setVisibility(View.INVISIBLE);
        correctTextview.setText("");

        new CountDownTimer(30100, 1000) {

            @Override
            public void onTick(long l) {
                timerTextView2.setText(String.valueOf(l / 1000) + "s");
            }

            @Override
            public void onFinish() {
                correctTextview.setText("Done!");
                playAgain.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void start(View view) {
        goButton.setVisibility(View.INVISIBLE);
        gamelayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.timerTextView2));
    }


    public void chooseAnswer(View view) {
        if (Integer.toString(locationofcorrectanswer).equals(view.getTag().toString())) {
            correctTextview.setText("Correct");
            score++;
        } else {
            correctTextview.setText("Wrong" + ":(");
        }
        hits++;
        scoreTextview.setText(Integer.toString(score) + "/" + Integer.toString(hits));
        newQues();
    }

    public void newQues() {
        Random random = new Random();

        int a = random.nextInt(51);
        int b = random.nextInt(51);

        quesTextview.setText(Integer.toString(a) + " + " + (Integer.toString(b)));
        locationofcorrectanswer = random.nextInt(4);
        answers.clear();

        for (int i = 0; i < 4; i++) {
            if (i == locationofcorrectanswer) {
                answers.add(a + b);

            } else {
                wrongAnswer = random.nextInt(51);
                while (wrongAnswer == a + b) ;
                wrongAnswer = random.nextInt(51);
            }
            answers.add(random.nextInt(101));

        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        correctTextview = findViewById(R.id.correct);
        quesTextview = findViewById(R.id.quesTextView);
        goButton = findViewById(R.id.goButton);
        scoreTextview = findViewById(R.id.scoreTextView);
        timerTextView2 = findViewById(R.id.timerTextView2);
        playAgain = findViewById(R.id.playAgain);
        gamelayout = findViewById(R.id.gamelayout);
        /*newQues();*/
        goButton.setVisibility(View.VISIBLE);
        gamelayout.setVisibility(View.INVISIBLE);


    }
}

