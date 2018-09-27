package com.example.echivambo.livroregistoec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MeuRelatorioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_relatorio);

        WebView myWebView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);

        //myWebView.loadUrl("http://localhost/firebase-sync-mariadb/bWV1IHJlbGF0b3Jpb0A=ZWRzb24gY2hpdmFtYm8=/");
        myWebView.loadUrl("https://www.evidencias.psi.org.mz/livro/public/meu-relatorio");
        //myWebView.loadUrl("http://psi.evidevi.com/powerbi/public/login");

        myWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
