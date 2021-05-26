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

        buttonA = findViewById(R.id.buttonA);
        buttonA.setOnClickListener(this::onClick);

        buttonB = findViewById(R.id.buttonB);
        buttonB.setOnClickListener(this::onClick);

        buttonC = findViewById(R.id.buttonC);
        buttonC.setOnClickListener(this::onClick);

        buttonD = findViewById(R.id.buttonD);
        buttonD.setOnClickListener(this::onClick);

        buttonE = findViewById(R.id.buttonE);
        buttonE.setOnClickListener(this::onClick);

        buttonF = findViewById(R.id.buttonF);
        buttonF.setOnClickListener(this::onClick);
    }


    public void onClick(View view) {
        TextView pressTV = (TextView) findViewById(R.id.pressed);
        switch (view.getId()) {
            case R.id.buttonA:
                pressTV.setText("Pressed: A");
                break;
            case R.id.buttonB:
                pressTV.setText("Pressed: B");
                break;
            case R.id.buttonC:
                pressTV.setText("Pressed: C");
                break;
            case R.id.buttonD:
                pressTV.setText("Pressed: D");
                break;
            case R.id.buttonE:
                pressTV.setText("Pressed: E");
                break;
            case R.id.buttonF:
                pressTV.setText("Pressed: F");
                break;
        }
    }
}
