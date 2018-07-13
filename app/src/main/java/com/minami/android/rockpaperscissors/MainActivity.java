package com.minami.android.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn_rock, btn_paper, btn_scissors;
    ImageView iv_cpu, iv_me;
    String myChoise, cpuChoise, result;
    Random random;
    final int ROCK = 0;
    final int PAPER = 1;
    final int SCISSORS = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_cpu = findViewById(R.id.iv_cpu);
        iv_me = findViewById(R.id.iv_me);
        btn_rock = findViewById(R.id.btn_rock);
        btn_paper = findViewById(R.id.btn_paper);
        btn_scissors = findViewById(R.id.btn_scissors);
    }

    public void calculate(){
        random = new Random();
        int cpu = random.nextInt(3);
        if (cpu == ROCK){
            cpuChoise = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        } else if (cpu == PAPER) {
            cpuChoise = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        } else if (cpu == SCISSORS) {
            cpuChoise = "scissors";
            iv_cpu.setImageResource(R.drawable.scissors);
        }
        if (myChoise.equals("rock") && cpuChoise.equals("paper")) {
            result = "You Lose";
        } else if (myChoise.equals("rock") && cpuChoise.equals("scissors")) {
            result = "You Win";
        } else if (myChoise.equals("paper") && cpuChoise.equals("scissors")) {
            result = "You Lose";
        } else if (myChoise.equals("paper") && cpuChoise.equals("rock")) {
            result = "You Win";
        } else if (myChoise.equals("scissors") && cpuChoise.equals("rock")) {
            result = "You Lose";
        } else if (myChoise.equals("scissors") && cpuChoise.equals("paper")) {
            result = "You Win";
        } else {
            result = "Draw";
        }

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();

    }

    public void startGame(View view) {
        myChoise = ((Button) view).getText().toString();
        if (myChoise.equals("rock")){
            iv_me.setImageResource(R.drawable.rock);
        } else if (myChoise.equals("paper")) {
            iv_me.setImageResource(R.drawable.paper);
        } else if (myChoise.equals("scissors")) {
            iv_me.setImageResource(R.drawable.scissors);
        }
        calculate();

    }
}
