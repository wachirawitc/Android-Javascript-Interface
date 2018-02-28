package com.matoom.javascriptinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private final String INTERFACE_NAME = "Android";
    private final String URL = "http://192.168.96.67/test/";

    private JavaScriptInterface javaScriptInterface;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = findViewById(R.id.webview);
        webview.loadUrl(URL);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());

        javaScriptInterface = new JavaScriptInterface(this);
        webview.addJavascriptInterface(javaScriptInterface, INTERFACE_NAME);
    }

}
