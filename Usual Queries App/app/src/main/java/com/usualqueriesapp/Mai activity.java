package com.usualqueriesapp;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.webkit.*;

public class MainActivity extends Activity
{
	
	private WebView mywebView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mywebView=(WebView) findViewById(R.id.webview);
		mywebView.setWebViewClient(new WebViewClient());
		mywebView.loadUrl("https://usualqueries.blogspot.com/");
		WebSettings webSettings=mywebView.getSettings();
		mywebView.getSettings().setDomStorageEnabled(true);
		mywebView.getSettings().setDatabaseEnabled(true);
		webSettings.setJavaScriptEnabled(true);
		mywebView.setWebChromeClient(new WebChromeClient() {
			@Override
			public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
				return super.onJsAlert(view, url, message, result);
			}
		});
    }
	public class mywebClient extends WebViewClient{
        @Override
		public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
	@Override
    public void onBackPressed(){
        if(mywebView.canGoBack()) {
            mywebView.goBack();
        }
		else{
			super.onBackPressed();
		}
	}
private class Splash extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        int secondsDelayed = 3;
        new Handler().postDelayed(new Runnable() {
                public void run() {
					startActivity(new Intent(Splash.this, MainActivity.class));
					finish();
                }
			}, secondsDelayed * 1000);
    }
}
}
