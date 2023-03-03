package com.example.tictactoebajud;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;
    TextView txtStatus;
    TextView p1score;
    boolean playerOnActive;
    TextView p1scores;
    TextView p2score;
    TextView p2scores;
    Boolean PlayerOneActive;
    Button btnPlayAgain,btnReset;
    Button[] Buttons = new Button[9];
    int check,PlayerOneScoreCount,PlayerTwoScoreCount,rounds;

    int[] gameStats = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8},{0,3,6},
            {1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @SuppressLint({"CutPasteId", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1score = findViewById(R.id.p1score);
        p1scores = findViewById(R.id.p1scores);
        p2score = findViewById(R.id.p2score);
        p2scores = findViewById(R.id.p2scores);


        Buttons[0] = findViewById(R.id.img1);
        Buttons[1] = findViewById(R.id.img2);
        Buttons[2] = findViewById(R.id.img3);
        Buttons[3] = findViewById(R.id.img4);
        Buttons[4] = findViewById(R.id.img5);
        Buttons[5] = findViewById(R.id.img6);
        Buttons[6] = findViewById(R.id.img7);
        Buttons[7] = findViewById(R.id.img8);
        Buttons[8] = findViewById(R.id.img9);

        btnPlayAgain = findViewById(R.id.btnPlayAgain);
        btnReset = findViewById(R.id.btnReset);

        for (int i=0; i< Buttons.length; i++){
            Buttons[i].setOnClickListener(this);
        }

        PlayerOneScoreCount = 0;
        PlayerTwoScoreCount = 0;
        playerOnActive = true;
        rounds = 0;


    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        } else if (checkwinner()) {
            return;
        }
        String ButtonsId = v.getResources().getResourceEntryName(v.getId());
        int gameStatePointer = Integer.parseInt(ButtonsId.substring(ButtonsId.length() - 1));
        if (PlayerOneActive) {
            ((Button) v).setText("X");
            ((Button) v).setTextColor(Color.parseColor("#ffc34a"));
            gameStats[gameStatePointer] = 0;
        }
    else {
            ((Button) v).setText("O");
            ((Button) v).setTextColor(Color.parseColor("#70fc3a"));
            gameStats[gameStatePointer] = 1;
        }
    rounds++;
    if (checkwinner())
    {
        if (PlayerOneActive)
        {
            PlayerOneScoreCount++;
            updateplayerscore();
            txtStatus.setText("Player-1 has won");
        }
        else {
            PlayerTwoScoreCount++;
            updateplayerscore();
            txtStatus.setText("Player-2 has won");
        }
    } else if (rounds==9) {

        txtStatus.setText("No Winner");
    }
    else {
        playerOnActive = !playerOnActive;
    }

    btnReset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            btnPlayagain();
            PlayerOneScoreCount = 0;
            PlayerTwoScoreCount = 0;
            updateplayerscore();
        }
    });

    btnPlayAgain.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            btnPlayagain();
        }
    });

    }

    private boolean checkwinner()
    {
        boolean winnerResults = false;
        for (int[] winningPositions: winningPositions)
        {
            if (gameStats[winningPositions[0]]==gameStats[winningPositions[1]]&&
            gameStats[winningPositions[1]]==gameStats[winningPositions[2]]&&
                gameStats[winningPositions[0]]!=2)

            {
                winnerResults =true;
            }
        }
        return winnerResults;

    }

    private void btnPlayagain()
    {
        rounds = 0;
        PlayerOneActive = true;
        for (int i=0; i<Buttons.length; i++)
        {
            gameStats[i] = 2;
            Buttons[i].setText("");
        }

        txtStatus.setText("Status");
    }

    private void updateplayerscore()
    {
        p1scores.setText(Integer.toString(PlayerOneScoreCount));
        p2scores.setText(Integer.toString(PlayerTwoScoreCount));

    }
}
//        img1 = findViewById(R.id.img1);
//        img2 = findViewById(R.id.img2);
//        img3 = findViewById(R.id.img3);
//        img4 = findViewById(R.id.img4);
//        img5 = findViewById(R.id.img5);
//        img6 = findViewById(R.id.img6);
//        img7 = findViewById(R.id.img7);
//        img8 = findViewById(R.id.img8);
//        img9 = findViewById(R.id.img9);

//        img1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (check%2==0){
//                    img1.setImageResource(R.drawable.o);
//                }
//                else {
//                    img1.setImageResource(R.drawable.x);
//                }
//                check++;
//            }
//        });img2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (check%2==0){
//                    img2.setImageResource(R.drawable.o);
//                }
//                else {
//                    img2.setImageResource(R.drawable.x);
//                }
//                check++;
//            }
//        });img3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (check%2==0){
//                    img3.setImageResource(R.drawable.o);
//                }
//                else {
//                    img3.setImageResource(R.drawable.x);
//                }
//                check++;
//            }
//        });img4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (check%2==0){
//                    img4.setImageResource(R.drawable.o);
//                }
//                else {
//                    img4.setImageResource(R.drawable.x);
//                }
//                check++;
//            }
//        });img5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (check%2==0){
//                    img5.setImageResource(R.drawable.o);
//                }
//                else {
//                    img5.setImageResource(R.drawable.x);
//                }
//                check++;
//            }
//        });img6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (check%2==0){
//                    img6.setImageResource(R.drawable.o);
//                }
//                else {
//                    img6.setImageResource(R.drawable.x);
//                }
//                check++;
//            }
//        });img7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (check%2==0){
//                    img7.setImageResource(R.drawable.o);
//                }
//                else {
//                    img7.setImageResource(R.drawable.x);
//                }
//                check++;
//            }
//        });img8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (check%2==0){
//                    img8.setImageResource(R.drawable.o);
//                }
//                else {
//                    img8.setImageResource(R.drawable.x);
//                }
//                check++;
//            }
//        });img9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (check%2==0){
//                    img9.setImageResource(R.drawable.o);
//                }
//                else {
//                    img9.setImageResource(R.drawable.x);
//                }
//                check++;
//            }
//        });
