package com.example.supeeerrrr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity {

    Button rock1, scissors1, paper1, reset1;
    TextView score1, score2;
    ImageView ComputerChoose1, MyChoose1;

    int MyScore, computerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Buttons
        rock1 = findViewById(R.id.rock);
        scissors1 = findViewById(R.id.scissors);
        paper1 = findViewById(R.id.paper);
        reset1 = findViewById(R.id.reset);

        //ImageViews
        ComputerChoose1 = findViewById(R.id.computerChoisePhoto);
        MyChoose1 = findViewById(R.id.myChoisePhoto);

        //Text
        score1 = findViewById(R.id.scorehumen);
        score2 = findViewById(R.id.scorecomputer);

        //resetButton
        reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyScore = 0;
                computerScore = 0;
                score1.setText("  نتيجتي: " + 0 );
                score2.setText( "نتيجة الكمبيوتر:" + 0 );
                return;
            }
        });


        paper1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyChoose1.setImageResource(R.drawable.paper);
                String message =  play_turn("paper");
                Toast.makeText(Game.this, message, Toast.LENGTH_SHORT).show();
                score1.setText("  نتيجتي: " + Integer.toString(MyScore));
                score2.setText( "   نتيجة الكمبيوتر: " + Integer.toString(computerScore));

                int i = MyScore;
                int n = computerScore;

                if (MyScore == 3){
                    Toast.makeText(Game.this, "You Win  "+i +"-"+ n , Toast.LENGTH_SHORT).show();
                    MyScore = 0;
                    computerScore = 0;
                    score1.setText("  نتيجتي: " + 0 );
                    score2.setText( "نتيجة الكمبيوتر:" + 0 );
                }else if (computerScore == 3){
                    Toast.makeText(Game.this, "You Lose!  "+i +"-"+ n , Toast.LENGTH_SHORT).show();
                    MyScore = 0;
                    computerScore = 0;
                    score1.setText("  نتيجتي: " + 0 );
                    score2.setText( "نتيجة الكمبيوتر:" + 0 );
                }
            }
        });

        rock1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyChoose1.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(Game.this, message, Toast.LENGTH_SHORT).show();
                score1.setText("  نتيجتي: " + Integer.toString(MyScore));
                score2.setText( "   نتيجة الكمبيوتر: " + Integer.toString(computerScore));

                int i = MyScore;
                int n = computerScore;

                if (MyScore == 3){
                    Toast.makeText(Game.this, "You Win  "+i +"-"+ n , Toast.LENGTH_SHORT).show();
                    MyScore = 0;
                    computerScore = 0;
                    score1.setText("  نتيجتي: " + 0 );
                    score2.setText( "نتيجة الكمبيوتر:" + 0 );

                }else if (computerScore == 3){
                    Toast.makeText(Game.this, "You Lose!  "+i +"-"+ n , Toast.LENGTH_SHORT).show();
                    MyScore = 0;
                    computerScore = 0;
                    score1.setText("  نتيجتي: " + 0 );
                    score2.setText( "نتيجة الكمبيوتر:" + 0 );
                }
            }
        });
        scissors1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyChoose1.setImageResource(R.drawable.scissors);
                String message = play_turn("scissors");
                Toast.makeText(Game.this, message, Toast.LENGTH_SHORT).show();
                score1.setText("  نتيجتي: " + Integer.toString(MyScore));
                score2.setText( "   نتيجة الكمبيوتر: " + Integer.toString(computerScore));

                int i = MyScore;
                int n = computerScore;

                if (MyScore == 3){
                    Toast.makeText(Game.this, "You Win  "+i +"-"+ n , Toast.LENGTH_SHORT).show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            MyScore = 0;
                            computerScore = 0;
                            score1.setText("  نتيجتي: " + 0 );
                            score2.setText( "نتيجة الكمبيوتر:" + 0 );
                        }
                    }, 1000);

                }else if (computerScore == 3){
                    Toast.makeText(Game.this, "You Lose!  "+ i +"-"+ n, Toast.LENGTH_SHORT).show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            MyScore = 0;
                            computerScore = 0;
                            score1.setText("  نتيجتي: " + 0 );
                            score2.setText( "نتيجة الكمبيوتر:" + 0 );
                        }
                    }, 1000);

                }
            }
        });







    }

    public String play_turn(String player_choise){
        String computerChoise2 ="";
        Random a =new Random();

        int computer_choise_number = a.nextInt(3) + 1;

        if (computer_choise_number == 1){
            computerChoise2 = "rock";
        }else
        if (computer_choise_number == 2){
            computerChoise2 = "scissors";
        }else
        if (computer_choise_number == 3){
            computerChoise2 = "paper";
        }

        //اختيار الكمبيوتر الصورة
        if (computerChoise2 == "rock"){
            ComputerChoose1.setImageResource(R.drawable.rock);
        }else
        if (computerChoise2 == "scissors"){
            ComputerChoose1.setImageResource(R.drawable.scissors);
        }else
        if (computerChoise2 == "paper"){
            ComputerChoose1.setImageResource(R.drawable.paper);
        }

        //اختيار الكمبيوتر واللاعب

        if (computerChoise2 == player_choise){
            return "Draw. No body won." ;
        }else
        if (player_choise == "rock" && computerChoise2 == "scissors"){
            MyScore++;
            return "rock crushes scissors. YOU win:)";
        }else
        if (player_choise == "rock" && computerChoise2 == "paper"){
            computerScore++;
            return "paper covers rock. Computer win:(";
        }else
        if (player_choise == "scissors" && computerChoise2 == "rock"){
            computerScore++;
            return "rock crushes scissors. Computer win:(";
        }else
        if (player_choise == "scissors" && computerChoise2 == "paper"){
            MyScore++;
            return "scissors cuts paper. YOU win:)";
        }else
        if (player_choise == "paper" && computerChoise2 == "rock"){
            MyScore++;
            return "paper covers rock. YOU win:)";
        }else
        if (player_choise == "paper" && computerChoise2 == "scissors"){
            computerScore++;
            return "scissors cuts paper. Computer win:(";
        }
        else return "NOT SURE....";

    }
}