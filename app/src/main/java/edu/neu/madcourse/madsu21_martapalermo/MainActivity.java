package edu.neu.madcourse.madsu21_martapalermo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button aboutMe, clickyClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aboutMe = (Button) findViewById(R.id.aboutMe);
        aboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });

        clickyClick = (Button) findViewById(R.id.clickyClick);
        clickyClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClickyClick();
            }
        });
    }

    private void openAbout() {
        Intent intent = new Intent(this, A1.class);
        startActivity(intent);
    }

    private void openClickyClick() {
        Intent intent = new Intent(this, A3.class);
    }
}