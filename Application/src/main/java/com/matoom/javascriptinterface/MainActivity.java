package com.matoom.javascriptinterface;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private JavaScriptInterface javaScriptInterface;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView) findViewById(R.id.webview);
        webview.loadUrl("http://192.168.1.43/test/");

        webview.getSettings().setJavaScriptEnabled(true);

        javaScriptInterface = new JavaScriptInterface(this);
        webview.addJavascriptInterface(javaScriptInterface, "Android");
        webview.setWebViewClient(new WebViewClient());
    }

    public class JavaScriptInterface {
        Context context;

        JavaScriptInterface(Context context) {
            this.context = context;
        }
        

        @JavascriptInterface
        public void scanBarcode() {
            Log.d("MainActivity", "scanBarcode");

            webview.post(new Runnable() {
                @Override
                public void run() {
                    String loadingUrl = "javascript:setBarcode('hello from android (java)')";
                    webview.loadUrl(loadingUrl);

                    Log.d("MainActivity", webview.getUrl());
                }
            });


        }
    }
}
