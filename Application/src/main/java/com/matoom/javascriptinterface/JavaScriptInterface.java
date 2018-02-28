package com.matoom.javascriptinterface;

import android.content.Context;
import android.webkit.JavascriptInterface;

public class JavaScriptInterface {
    Context context;

    JavaScriptInterface(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public String scanBarcode() {
        return "hello from Android (Java)";
    }
}
