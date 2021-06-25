package edu.neu.madcourse.madsu21_martapalermo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class A6 extends AppCompatActivity {

    String url;
    private TextView showDef;
    private EditText enterWord;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at_your_service);

        Button searchBtn = findViewById(R.id.searchBtn);

        Button clearBtn = findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(v -> {
            TextView def = findViewById(R.id.showDef);
            if (v.getId() == R.id.clearBtn) {
                def.setText("");
            }
        });

        showDef = findViewById(R.id.showDef);
        enterWord = findViewById(R.id.enterWord);
//        progressBar = findViewById(R.id.progressBar);
    }
    private String dictionaryEntries() {
        final String language = "en-gb";
        final String word = enterWord.getText().toString(); // we're gonna get meaning of entered word
        final String fields = "definitions"; // replace with whatever field we want
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    }

    public void sendRequestOnClick(View v){
        DictionaryRequest dR = new DictionaryRequest(this, showDef);
        url = dictionaryEntries();
        dR.execute(url);
    }




}