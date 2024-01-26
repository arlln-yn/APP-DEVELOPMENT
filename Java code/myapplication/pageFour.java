package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class pageFour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_four);
    }

    float x1, y1, x2, y2;
    // swipe method

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x1 < x2){
                    Intent i = new Intent(this, pageThree.class);
                    startActivity(i);
                }else if (x1 > x2){
                    Intent i = new Intent(this, pageFive.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
    //To next page button
    public void toPageFive (View v){
        Intent i = new Intent(this, pageFive.class);
        startActivity(i);
    }

    // Back to prev page button
    public void prevPageThree (View v){
        Intent i = new Intent(this, pageThree.class);
        startActivity(i);
    }
}