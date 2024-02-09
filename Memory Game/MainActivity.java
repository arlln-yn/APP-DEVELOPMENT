package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    TextView score;

    ImageView iv_11, iv_12, iv_13, iv_14, iv_21, iv_22, iv_23, iv_24,
            iv_31, iv_32, iv_33, iv_34, iv_41, iv_42, iv_43, iv_44;

    // array for images
    Integer[] cardsArray = {101, 102, 103, 104, 105, 106, 107, 108,
            201, 202, 203, 204, 205, 206, 207, 208};

    // actual images
    int img101, img102, img103, img104, img105, img106, img107, img108,
            img201, img202, img203, img204, img205, img206, img207, img208;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    // for timer
    private TextView timerTextView;
    private CountDownTimer countDownTimer;

    int playerScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView = findViewById(R.id.timer);

        startTimer(60000); // Start the timer for 1 minute

        score = findViewById(R.id.score);

        // First card set
        iv_11 = findViewById(R.id.iv_11);
        iv_12 = findViewById(R.id.iv_12);
        iv_13 = findViewById(R.id.iv_13);
        iv_14 = findViewById(R.id.iv_14);

        // Second card set
        iv_21 = findViewById(R.id.iv_21);
        iv_22 = findViewById(R.id.iv_22);
        iv_23 = findViewById(R.id.iv_23);
        iv_24 = findViewById(R.id.iv_24);

        // Third card set
        iv_31 = findViewById(R.id.iv_31);
        iv_32 = findViewById(R.id.iv_32);
        iv_33 = findViewById(R.id.iv_33);
        iv_34 = findViewById(R.id.iv_34);

        // Fourth card set
        iv_41 = findViewById(R.id.iv_41);
        iv_42 = findViewById(R.id.iv_42);
        iv_43 = findViewById(R.id.iv_43);
        iv_44 = findViewById(R.id.iv_44);

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");
        iv_21.setTag("4");
        iv_22.setTag("5");
        iv_23.setTag("6");
        iv_24.setTag("7");
        iv_31.setTag("8");
        iv_32.setTag("9");
        iv_33.setTag("10");
        iv_34.setTag("11");
        iv_41.setTag("12");
        iv_42.setTag("13");
        iv_43.setTag("14");
        iv_44.setTag("15");

        //load the card images
        frontOfCardResources();

        //shuffle the images
        Collections.shuffle(Arrays.asList(cardsArray));

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_11, theCard);
            }
        });

        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_12, theCard);

            }
        });

        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_13, theCard);

            }
        });

        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_14, theCard);

            }
        });

        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_21, theCard);

            }
        });

        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_22, theCard);

            }
        });

        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_23, theCard);

            }
        });

        iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_24, theCard);

            }
        });

        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_31, theCard);

            }
        });

        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_32, theCard);

            }
        });

        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_33, theCard);

            }
        });

        iv_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_34, theCard);

            }
        });

        iv_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_41, theCard);

            }
        });

        iv_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_42, theCard);

            }
        });

        iv_43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_43, theCard);

            }
        });

        iv_44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_44, theCard);

            }
        });
    }

    // timer methods
    private void startTimer(long milliseconds) {
        countDownTimer = new CountDownTimer(milliseconds, 1000) {
            public void onTick(long millisUntilFinished) {
                updateTimerText(millisUntilFinished);
            }

            public void onFinish() {
                timerTextView.setText("00:00");
                // game ends
                checkEnd();
            }
        }.start();
    }

    private void updateTimerText(long millisecondsUntilFinished) {
        long seconds = millisecondsUntilFinished / 1000;
        long minutes = seconds / 60;
        seconds = seconds % 60;
        String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);
        timerTextView.setText(timeLeftFormatted);
    }

    private void stopTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }


    // memory card game methods
    private void doStuff(ImageView iv, int card){
        if(cardsArray[card] == 101){
            iv.setImageResource(img101);
        } else if (cardsArray[card] == 102){
            iv.setImageResource(img102);
        } else if (cardsArray[card] == 103){
            iv.setImageResource(img103);
        } else if (cardsArray[card] == 104) {
            iv.setImageResource(img104);
        } else if (cardsArray[card] == 105){
            iv.setImageResource(img105);
        } else if (cardsArray[card] == 106){
            iv.setImageResource(img106);
        } else if (cardsArray[card] == 107){
            iv.setImageResource(img107);
        } else if (cardsArray[card] == 108){
            iv.setImageResource(img108);
        } else if (cardsArray[card] == 201){
            iv.setImageResource(img201);
        } else if (cardsArray[card] == 202){
            iv.setImageResource(img202);
        } else if (cardsArray[card] == 203){
            iv.setImageResource(img203);
        } else if (cardsArray[card] == 204){
            iv.setImageResource(img204);
        } else if (cardsArray[card] == 205){
            iv.setImageResource(img205);
        } else if (cardsArray[card] == 206){
            iv.setImageResource(img206);
        } else if (cardsArray[card] == 207){
            iv.setImageResource(img207);
        } else if (cardsArray[card] == 208){
            iv.setImageResource(img208);
        }

        // check which image is selected and save it into temporary variables
        if(cardNumber == 1){
            firstCard = cardsArray[card];
            if(firstCard > 200){
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardsArray[card];
            if(secondCard > 200){
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_34.setEnabled(false);
            iv_41.setEnabled(false);
            iv_42.setEnabled(false);
            iv_43.setEnabled(false);
            iv_44.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run(){
                    // check is the selected images are equal
                    calculate();
                }
            }, 1000);
        }
    }

    private void calculate(){
        // if images are equal, remove them and add score
        if(firstCard == secondCard) {
            if (clickedFirst == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                iv_34.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 12) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 13) {
                iv_42.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 14) {
                iv_43.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 15) {
                iv_44.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                iv_34.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 12) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 13) {
                iv_42.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 14) {
                iv_43.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 15) {
                iv_44.setVisibility(View.INVISIBLE);
            }

            // add points
            playerScore++;
            score.setText("Score: " + playerScore);

        } else {
            iv_11.setImageResource(R.drawable.cardbg);
            iv_12.setImageResource(R.drawable.cardbg);
            iv_13.setImageResource(R.drawable.cardbg);
            iv_14.setImageResource(R.drawable.cardbg);
            iv_21.setImageResource(R.drawable.cardbg);
            iv_22.setImageResource(R.drawable.cardbg);
            iv_23.setImageResource(R.drawable.cardbg);
            iv_24.setImageResource(R.drawable.cardbg);
            iv_31.setImageResource(R.drawable.cardbg);
            iv_32.setImageResource(R.drawable.cardbg);
            iv_33.setImageResource(R.drawable.cardbg);
            iv_34.setImageResource(R.drawable.cardbg);
            iv_41.setImageResource(R.drawable.cardbg);
            iv_42.setImageResource(R.drawable.cardbg);
            iv_43.setImageResource(R.drawable.cardbg);
            iv_44.setImageResource(R.drawable.cardbg);
        }

        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_34.setEnabled(true);
        iv_41.setEnabled(true);
        iv_42.setEnabled(true);
        iv_43.setEnabled(true);
        iv_44.setEnabled(true);


    }

    private void checkEnd(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Game Over");
        builder.setMessage("Your score: " + playerScore);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
                // Handle any further action after game over, such as restarting the game
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopTimer(); // Stop the timer to avoid memory leaks
    }

    private void frontOfCardResources(){

        img101 = R.drawable.card1;
        img102 = R.drawable.card2;
        img103 = R.drawable.card3;
        img104 = R.drawable.card4;
        img105 = R.drawable.card5;
        img106 = R.drawable.card6;
        img107 = R.drawable.card7;
        img108 = R.drawable.card8;

        img201 = R.drawable.card1dup;
        img202 = R.drawable.card2dup;
        img203 = R.drawable.card3dup;
        img204 = R.drawable.card4dup;
        img205 = R.drawable.card5dup;
        img206 = R.drawable.card6dup;
        img207 = R.drawable.card7dup;
        img208 = R.drawable.card8dup;


    }
}