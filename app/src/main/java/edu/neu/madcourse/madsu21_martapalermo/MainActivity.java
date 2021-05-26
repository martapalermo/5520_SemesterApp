package edu.neu.madcourse.madsu21_martapalermo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aboutMe = findViewById(R.id.aboutMe);
        aboutMe.setOnClickListener(v -> openAbout());

        Button clickyClick = findViewById(R.id.clickyClick);
        clickyClick.setOnClickListener(v -> openClickyClick());
    }

    private void openAbout() {
        Intent intent = new Intent(this, A1.class);
        startActivity(intent);
    }

    private void openClickyClick() {
        Intent intent = new Intent(this, A3.class);
        startActivity(intent);
    }
}