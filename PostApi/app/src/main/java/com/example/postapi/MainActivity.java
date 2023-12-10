  package com.example.postapi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

  public class MainActivity extends AppCompatActivity {
WebView webView;
ProgressBar pg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
webView =findViewById(R.id.webView);
        pg=findViewById(R.id.pg);

webView.loadUrl("https://www.google.co.in/");
webView.setWebViewClient(new WebViewClient(){


    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        pg.setVisibility(View.VISIBLE);
        super.onPageStarted(view, url, favicon);
    }


    @Override
    public void onPageFinished(WebView view, String url) {
        pg.setVisibility(View.INVISIBLE);
        super.onPageFinished(view, url);
    }
});

    }

      @Override
      public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }

      }
  }