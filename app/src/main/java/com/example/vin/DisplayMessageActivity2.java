package com.example.vin;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class DisplayMessageActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message2);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView5);
        textView.setText(message);


        final WebView webView = (WebView)findViewById(R.id.webview2);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

//load the page with cache
        if (Build.VERSION.SDK_INT >= 19) {
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }
        boolean loadingFinished = true;
        boolean redirect = false;

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //return true load with system-default-browser or other browsers, false with your webView
                return false;
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

            }
            @Override
            public void onPageFinished(WebView view, String url)
            {

                String pwd="YL53 RRU";
                view.loadUrl("javascript: var elements = document.getElementById('wizard_vehicle_enquiry_capture_vrn_vrn').value = '"+pwd+"'");
                view.loadUrl("javascript: var elements = document.getElementById('submit_vrn_button').click();");
                view.loadUrl("javascript: var elements = document.getElementById('yes-vehicle-confirm').click();");
                view.loadUrl("javascript: var elements = document.getElementById('capture_confirm_button').click();");
                super.onPageFinished(view, url);





            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                //put your code here if your want to show the progress with progressbar
            }
        });

        String loadUrl = "https://vehicleenquiry.service.gov.uk/";
        webView.loadUrl(loadUrl);


    }


}
