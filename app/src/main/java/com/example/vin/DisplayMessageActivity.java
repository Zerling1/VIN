package com.example.vin;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;


import android.webkit.WebViewClient;
import android.widget.TextView;



public class DisplayMessageActivity extends AppCompatActivity {

    private String loadUrl = "https://www.autodna.pl/vin/VF1DTF2G648284645";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        final WebView webView = (WebView)findViewById(R.id.webview1);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

//load the page with cache
        if (Build.VERSION.SDK_INT >= 19) {
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }


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
                findViewById(R.id.progress1).setVisibility(View.VISIBLE);

            }
            @Override
            public void onPageFinished(WebView view, String url)
            {
                view.loadUrl("javascript:var elements = document.getElementsByClassName('main-title'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('container-wide'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsId('vehicle-report'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('vin-check-medium'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('vehicle-report-precheck'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('sub-title'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('vehicle-report-product checked'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('vehicle-report-product checked'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('vehicle-report-product-container'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('vehicle-report-product-footer'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('sub-title'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('vehicle-report-product checked'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('vehicle-report-product disabled'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('vehicle-report-product disabled'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('vehicle-report-product disabled'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('vehicle-report-product disabled'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('vehicle-report-product disabled '); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('client-basket-static'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementById('vehicle-report'); console.log( elements.parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('user-box disabled'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('user-box disabled'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('user-box disabled'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('container-wide'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                view.loadUrl("javascript:var elements = document.getElementsByClassName('page-footer'); console.log( elements[0].parentNode.removeChild(elements[0]));");
                super.onPageFinished(view, url);
                findViewById(R.id.progress1).setVisibility(View.GONE);




            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                //put your code here if your want to show the progress with progressbar
            }
        });

        String loadUrl = "https://www.autodna.pl/vin/VF1DTF2G648284645";
        webView.loadUrl(loadUrl);


    }


}