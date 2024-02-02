package com.example.laboratoryactivityweek8_9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class VoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
    }

    public void voting (View v) {
        EditText presInput = findViewById(R.id.editTextPresident);
        EditText vicePresInput = findViewById(R.id.editTextVicePresident);

        String pres = presInput.getText().toString();
        String vicePres = vicePresInput.getText().toString();

        if (pres.isEmpty() && vicePres.isEmpty()) {
            Toast.makeText(this, "Please enter your chosen president and vice president.", Toast.LENGTH_SHORT).show();
        } else if (pres.isEmpty()) {
            Toast.makeText(this, "Please enter your chosen president.", Toast.LENGTH_SHORT).show();
        } else if (vicePres.isEmpty()) {
            Toast.makeText(this, "Please enter your chosen vice president.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Vote saved.", Toast.LENGTH_SHORT).show();

            // Save the input values to move to Result Activity class
            Intent i = new Intent(this, ResultActivity.class);

            i.putExtra("president", pres);
            i.putExtra("vicePresident", vicePres);

            startActivity(i);
        }
    }
}