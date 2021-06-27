package edu.neu.madcourse.madsu21_martapalermo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class A6 extends AppCompatActivity {

    String url;
    private TextView showDef;
    private EditText enterWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at_your_service);


        showDef = findViewById(R.id.showDef);
        enterWord = findViewById(R.id.enterWord);
        //Button searchBtn = findViewById(R.id.searchBtn);

        Button clearBtn = findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(v -> {
            TextView def = showDef;
            EditText word = enterWord;
            if (v.getId() == R.id.clearBtn) {
                def.setText("");
                word.setText("");
                findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
            }

        });

     //   findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
    }


    private String dictionaryEntries() {
        final String language = "en-gb";
        final String word = enterWord.getText().toString(); // we're gonna get meaning of entered word
        final String fields = "definitions"; //"etymologies"; // replace with whatever field we want  definitions
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    }

    public void sendRequestOnClick(View v){
        DictionaryRequest dR = new DictionaryRequest(this, showDef);
        url = dictionaryEntries();
        dR.execute(url);
        findViewById(R.id.progressBar).setVisibility(View.GONE);
    }




}