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

public class DisplayMessageActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message3);

        Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
         final String message2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        final String message3 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
         // Capture the layout's TextView and set the string as its text



        final WebView webView = (WebView)findViewById(R.id.webview3);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

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

                final String pwd = message ;
                final String pwd2 = message2 ;
                        //"SZY58214";
                final String pwd3 = message3 ;
                    //"WBAPX51060C147585";
                //String pwd3="28.01.2011";
                view.loadUrl("javascript: var elements = document.getElementById('_historiapojazduportlet_WAR_historiapojazduportlet_:rej').value = '"+pwd+"'");
                view.loadUrl("javascript: var elements = document.getElementById('_historiapojazduportlet_WAR_historiapojazduportlet_:vin').value = '"+pwd2+"'");
                view.loadUrl("javascript: var elements = document.getElementById('_historiapojazduportlet_WAR_historiapojazduportlet_:data').value = '"+pwd3+"'");
                view.loadUrl("javascript: var elements = document.getElementById('_historiapojazduportlet_WAR_historiapojazduportlet_:btnSprawdz').click();");

                super.onPageFinished(view, url);





            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                //put your code here if your want to show the progress with progressbar
            }
        });

        String loadUrl = "https://historiapojazdu.gov.pl/";
        webView.loadUrl(loadUrl);


    }


}

