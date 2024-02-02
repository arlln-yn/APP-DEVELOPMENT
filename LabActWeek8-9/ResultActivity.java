package com.example.laboratoryactivityweek8_9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView presResult = findViewById(R.id.displayPres);
        TextView vicePresResult = findViewById(R.id.displayVicePres);

        // Retrieve intent values from Voting Act
        Intent i = getIntent();

        String president = i.getStringExtra("president");
        String vicePresident = i.getStringExtra("vicePresident");

        // Display intent values from Voting Act

        presResult.setText(president);
        vicePresResult.setText(vicePresident);
    }

    public void toMainMenu (View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}