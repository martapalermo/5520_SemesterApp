package edu.neu.madcourse.madsu21_martapalermo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class A3 extends AppCompatActivity {
    private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Button buttonD;
    private Button buttonE;
    private Button buttonF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickyclik);

        buttonA = (Button) findViewById(R.id.buttonA);
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pressTV = (TextView) findViewById(R.id.pressed);
                if (v.getId() == R.id.buttonA) {
                    pressTV.setText("Pressed: A");
                }
            }
        });

        buttonB = (Button) findViewById(R.id.buttonB);
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pressTV = (TextView) findViewById(R.id.pressed);
                if (v.getId() == R.id.buttonB) {
                    pressTV.setText("Pressed: B");
                }
            }
        });

        buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pressTV = (TextView) findViewById(R.id.pressed);
                if (v.getId() == R.id.buttonC) {
                    pressTV.setText("Pressed: C");
                }
            }
        });

        buttonD = (Button) findViewById(R.id.buttonD);
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pressTV = (TextView) findViewById(R.id.pressed);
                if (v.getId() == R.id.buttonD) {
                    pressTV.setText("Pressed: D");
                }
            }
        });

        buttonE = (Button) findViewById(R.id.buttonE);
        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pressTV = (TextView) findViewById(R.id.pressed);
                if (v.getId() == R.id.buttonE) {
                    pressTV.setText("Pressed: E");
                }
            }
        });

        buttonF = (Button) findViewById(R.id.buttonF);
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pressTV = (TextView) findViewById(R.id.pressed);
                if (v.getId() == R.id.buttonF) {
                    pressTV.setText("Pressed: F");
                }
            }
        });
    }
}
