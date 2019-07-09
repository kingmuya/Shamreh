package com.example.complete;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Second extends AppCompatActivity {
    WebView WebView;
    @Override
    protected void onCreate{
        Bundle savedInstanceState};
        super.onCreate(savedInstancestate) {
        setContentView(R.layout.activity_second);
        WebView = findViewById(R.id.webview);
        WebView.loadUrl("file:///android_assets/index.html");

    }

}
