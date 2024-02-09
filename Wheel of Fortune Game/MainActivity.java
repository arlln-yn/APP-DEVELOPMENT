package com.example.wheeloffortune;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final int[] sectors = {750, 500, 250, 1000, 750, 250, 250, 250, 500, 500};
    final int[] sectorsDegree = new int[sectors.length];

    // random index
    int randomSectorIndex = 0;

    // to spin
    ImageView wheel;
    boolean spinning = false;
    int earnings = 0;
    int earningsRecord = 0;

    // random to help generate random index
    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // to spin
        wheel = findViewById(R.id.theWheel);

        // tap detector
        ImageView belt = findViewById(R.id.belt);

        // generate sector deg
        generateSectorDegrees();

        // click belt to spin the wheel
        belt.setOnClickListener(v -> {
            // only if its not spinning
            if (!spinning){
                spin();
                spinning = true; // now spinning
            }
        });

        // withdraw
        Button withdrawBtn = findViewById(R.id.button);
        withdrawBtn.setOnClickListener(v -> {
            String text = "Ready to withdraw " + earningsRecord + " coins money?? Do more...";
            toast(text);
        });

        Button resetButton = findViewById(R.id.buttonReset);
        // Set OnClickListener for the reset button
        resetButton.setOnClickListener(v -> resetEarnings());
    }

    private void spin() {
        // get any random sector index
        randomSectorIndex = random.nextInt(sectors.length); // the bound is exclusive

        // generate a random degree to spin
        int randomDegree = generateRandomDegreeToSpinTo();

        // do actual spinning
        RotateAnimation rotateAnimation = new RotateAnimation(0, randomDegree, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        // time for spinning
        rotateAnimation.setDuration(3600); //3.6 sec
        rotateAnimation.setFillAfter(true); //filter

        // interpolator
        rotateAnimation.setInterpolator(new DecelerateInterpolator()); //start with high speed

        //spinning listener
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //interested when spinning ends
                // get earns
                int earnedCoins = sectors[sectors.length - (randomSectorIndex+1)];
                //save earnings
                saveEarnings(earnedCoins);

                // toast the current earning
                String sms = "You have earned " + earnedCoins + " coins";
                toast(sms);

                // Spinning ended
                spinning = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // apply animation to wheel
        wheel.startAnimation(rotateAnimation);
    }

    private void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private void saveEarnings(int earnedCoins){
        earningsRecord = earningsRecord + earnedCoins;
        //set the value to textview
        TextView tv = findViewById(R.id.earnings);
        tv.setText(String.valueOf(earningsRecord));

    }

    private int generateRandomDegreeToSpinTo() {
        //make it high as you can
        return (360*sectors.length) + sectorsDegree[randomSectorIndex];
    }

    private void generateSectorDegrees() {
        // for 1 sector
        int sectorDegree = 360/sectors.length;
        for (int i = 0; i < sectors.length; i++) {
            //make it greater as much as you can
            sectorsDegree[i] = (i+1) * sectorDegree;
        }
    }

    private void resetEarnings() {
        // Reset earnings and update UI
        earningsRecord = 0;
        TextView tv = findViewById(R.id.earnings);
        tv.setText(String.valueOf(earningsRecord));

        // Display a toast message to indicate that earnings have been reset
        toast("Earnings reset to 0 coins.");
    }
}