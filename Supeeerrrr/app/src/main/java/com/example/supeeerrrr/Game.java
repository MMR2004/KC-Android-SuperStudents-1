package com.example.supeeerrrr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity {

    Button rock1, scissors1, paper1, reset1, back1;
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
        back1 = findViewById(R.id.back);

        //ImageViews
        ComputerChoose1 = findViewById(R.id.computerChoisePhoto);
        MyChoose1 = findViewById(R.id.myChoisePhoto);

        //Text
        score1 = findViewById(R.id.scorehumen);
        score2 = findViewById(R.id.scorecomputer);


        //backButton
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backintent = new Intent(Game.this, Start.class);
                startActivity(backintent);
            }
        });

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
                String message =  play_turn("ورق");
                Toast.makeText(Game.this, message, Toast.LENGTH_SHORT).show();
                score1.setText("  نتيجتي: " + Integer.toString(MyScore));
                score2.setText( "   نتيجة الكمبيوتر: " + Integer.toString(computerScore));

                int i = MyScore;
                int n = computerScore;

                if (MyScore == 3){
                    Toast.makeText(Game.this, "لقد فزت أحسنتتت    "+i +"-"+ n , Toast.LENGTH_SHORT).show();
                    MyScore = 0;
                    computerScore = 0;
                    score1.setText("  نتيجتي: " + 0 );
                    score2.setText( "نتيجة الكمبيوتر:" + 0 );
                }else if (computerScore == 3){
                    Toast.makeText(Game.this, "لقد خسرت! وا أسفاه عليك   "+i +"-"+ n , Toast.LENGTH_SHORT).show();
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
                String message = play_turn("حجر");
                Toast.makeText(Game.this, message, Toast.LENGTH_SHORT).show();
                score1.setText("  نتيجتي: " + Integer.toString(MyScore));
                score2.setText( "   نتيجة الكمبيوتر: " + Integer.toString(computerScore));

                int i = MyScore;
                int n = computerScore;

                if (MyScore == 3){
                    Toast.makeText(Game.this, "لقد فزت أحسنتتت    "+i +"-"+ n , Toast.LENGTH_SHORT).show();
                    MyScore = 0;
                    computerScore = 0;
                    score1.setText("  نتيجتي: " + 0 );
                    score2.setText( "نتيجة الكمبيوتر:" + 0 );

                }else if (computerScore == 3){
                    Toast.makeText(Game.this, "لقد خسرت! وا أسفاه عليك   "+i +"-"+ n , Toast.LENGTH_SHORT).show();
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
                String message = play_turn("مقص");
                Toast.makeText(Game.this, message, Toast.LENGTH_SHORT).show();
                score1.setText("  نتيجتي: " + Integer.toString(MyScore));
                score2.setText( "   نتيجة الكمبيوتر: " + Integer.toString(computerScore));

                int i = MyScore;
                int n = computerScore;

                if (MyScore == 3){
                    Toast.makeText(Game.this, "لقد فزت أحسنتتت    "+i +"-"+ n , Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Game.this, "لقد خسرت! وا أسفاه عليك   "+ i +"-"+ n, Toast.LENGTH_SHORT).show();
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
            computerChoise2 = "حجر";
        }else
        if (computer_choise_number == 2){
            computerChoise2 = "مقص";
        }else
        if (computer_choise_number == 3){
            computerChoise2 = "ورق";
        }

        //اختيار الكمبيوتر الصورة
        if (computerChoise2 == "حجر"){
            ComputerChoose1.setImageResource(R.drawable.rock);
        }else
        if (computerChoise2 == "مقص"){
            ComputerChoose1.setImageResource(R.drawable.scissors);
        }else
        if (computerChoise2 == "ورق"){
            ComputerChoose1.setImageResource(R.drawable.paper);
        }

        //اختيار الكمبيوتر واللاعب

        if (computerChoise2 == player_choise){
            return "تعادل.. لا فائز" ;
        }else
        if (player_choise == "حجر" && computerChoise2 == "مقص"){
            MyScore++;
            return "الحجر يحطم المقص. لقد فزت :)";
        }else
        if (player_choise == "حجر" && computerChoise2 == "ورق"){
            computerScore++;
            return "الورق يصد الحجر. لقد فاز الكمبيوتر:(";
        }else
        if (player_choise == "مقص" && computerChoise2 == "حجر"){
            computerScore++;
            return "الحجر يحطم المقص. لقد فاز الكمبيوتر:(";
        }else
        if (player_choise == "مقص" && computerChoise2 == "ورق"){
            MyScore++;
            return "المقص يقطع الورق. لقد فزت:)";
        }else
        if (player_choise == "ورق" && computerChoise2 == "حجر"){
            MyScore++;
            return "الورق يصد الحجر. لقد فزت:)";
        }else
        if (player_choise == "ورق" && computerChoise2 == "مقص"){
            computerScore++;
            return "المقص يقص الورق. لقد فاز الكمبيوتر:(";
        }
        else return "لست متأكد.....";

    }
}