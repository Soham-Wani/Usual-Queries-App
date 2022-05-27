package com.usualqueriesapp;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.webkit.*;
public class MainActivity extends Activity {
    private WebView mywebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mywebView = (WebView) findViewById(R.id.webview);
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://usualqueries.blogspot.com/"); // Change this URL with your website
        WebSettings webSettings = mywebView.getSettings();
        mywebView.getSettings().setDomStorageEnabled(true);
        mywebView.getSettings().setDatabaseEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        mywebView.setWebChromeClient(new WebChromeClient() {
            @Override // This one is to enable alerts and prompts
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) { 
                return super.onJsAlert(view, url, message, result);
            }
        });
    }
    public class mywebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    @Override // This is for pressing back. Can be changed if you want something else to happen after pressing back
    public void onBackPressed() {
        if (mywebView.canGoBack()) {
            mywebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    private class Splash extends Activity {
        @Override // The splashscreen override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splashscreen); // Contents to be changed in layout file
            int secondsDelayed = 3; // Time dor which the splashscreen will be displayed. Can be changed 
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    startActivity(new Intent(Splash.this, MainActivity.class));
                    finish();
                }
            }, secondsDelayed * 1000);
        }
    }
}
