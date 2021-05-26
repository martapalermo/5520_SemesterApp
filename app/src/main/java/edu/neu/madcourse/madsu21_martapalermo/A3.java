package edu.neu.madcourse.madsu21_martapalermo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class A3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickyclik);

        Button buttonA = findViewById(R.id.buttonA);
        buttonA.setOnClickListener(v -> {
            TextView pressTV =  findViewById(R.id.pressed);
            if (v.getId() == R.id.buttonA) {
                pressTV.setText("Pressed: A");
            }
        });

        Button buttonB = findViewById(R.id.buttonB);
        buttonB.setOnClickListener(v -> {
            TextView pressTV = findViewById(R.id.pressed);
            if (v.getId() == R.id.buttonB) {
                pressTV.setText("Pressed: B");
            }
        });

        Button buttonC = findViewById(R.id.buttonC);
        buttonC.setOnClickListener(v -> {
            TextView pressTV = findViewById(R.id.pressed);
            if (v.getId() == R.id.buttonC) {
                pressTV.setText("Pressed: C");
            }
        });

        Button buttonD = findViewById(R.id.buttonD);
        buttonD.setOnClickListener(v -> {
            TextView pressTV = findViewById(R.id.pressed);
            if (v.getId() == R.id.buttonD) {
                pressTV.setText("Pressed: D");
            }
        });

        Button buttonE = findViewById(R.id.buttonE);
        buttonE.setOnClickListener(v -> {
            TextView pressTV = findViewById(R.id.pressed);
            if (v.getId() == R.id.buttonE) {
                pressTV.setText("Pressed: E");
            }
        });

        Button buttonF = findViewById(R.id.buttonF);
        buttonF.setOnClickListener(v -> {
            TextView pressTV = findViewById(R.id.pressed);
            if (v.getId() == R.id.buttonF) {
                pressTV.setText("Pressed: F");
            }
        });
    }
}
