package com.example.proje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class migrosKatalog2Activity extends AppCompatActivity {
    WebView webview1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_migros_katalog2);


        webview1 = (WebView)findViewById(R.id.webview1);
        WebSettings webSettings = webview1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview1.loadUrl("https://www.money.com.tr/mc/kampanyalara-bak/migroskop-dijital/83");
        webview1.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(webview1.canGoBack())
        {
            webview1.canGoBack();
        }else
            super.onBackPressed();
    }

}
