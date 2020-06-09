package com.example.vin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import android.app.Activity;
import android.os.Bundle;
import android.sax.Element;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    private static final String DATE_PATTERN =    "(0?[1-9]|1[012]) [.] (0?[1-9]|[12][0-9]|3[01]) [.] ((19|20)\\d\\d)";
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        editText5 = (EditText)findViewById(R.id.editText5);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                boolean check1 = editText.getText().length()!=0;
                boolean check2 = editText.getText().length()!=17;
                if(check1&&check2) {
                    editText.setError("Błędny format VIN");
                    }
                }

        });

        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                boolean check1 = editText2.getText().length()!=0;
                boolean check2 = editText2.getText().length()!=7;
                if(check1&&check2) {
                    editText2.setError("Błędny format numerów rejestracyjnych");
                }
            }

        });
        editText3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                boolean check1 = editText3.getText().length()!=0;
                boolean check2 = editText3.getText().length()!=7;
                if(check1&&check2) {
                    editText3.setError("Błędny format numerów rejestracyjnych");
                }
            }

        });
        editText4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                boolean check1 = editText4.getText().length()!=0;
                boolean check2 = editText4.getText().length()!=17;
                if(check1&&check2) {
                    editText4.setError("Błędny format VIN");
                }
            }

        });
        editText5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                boolean check1 = editText5.getText().length()!=0;
                boolean check2 = editText.getText().length()!=10;
                if(check1&&check2) {
                    editText5.setError("Błędny format daty");
                }
            }

        });

    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {


        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
    public void sendMessage2(View view) {
        Intent intent = new Intent(this,  DisplayMessageActivity2.class);
        EditText editText = (EditText) findViewById(R.id.editText2);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void sendMessage3(View view) {
        Intent intent = new Intent(this,  DisplayMessageActivity3.class);
        EditText editText = (EditText) findViewById(R.id.editText4);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }



}
