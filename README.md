# Usual-Queries-App
Usual Queries App is a simple WebView Android application that I had once made to bring my blog to life only to realise Google Play charges you to list an app. Yeah, I was dumb, but here is the code.

I have also given some tips below regarding how you can make your own WebView Android application.

## What is Android WebView app anyways?
Essentially Android WebView is something that helps Android apps to display content from the web directly inside an Android application. It allows the app to interact with webpages. The app gets sort of an embedded browser.

## How to make a simple Android WebView app on Windows / Mac / Linux / ChromeOS?
- **Step 1:** Download [Android Studio](https://developer.android.com/studio) and open a new project with all suitable details.
- **Step 2:** Locate `MainActivity.java` in the `src` file. Select and replace the entire code with 
```java
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); // Here 'main' is a filename in 'layout' folder
        WebView webView = (WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.usualqueries.blogspot.com"); // Change this URL with your URL
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {
	 		      @Override // For proper functioning of prompts and alerts
			      public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
				        return super.onJsAlert(view, url, message, result);
			      }
		    });
    }
    public void onBackPressed(){
        if (webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    private class Splash extends Activity { // Can be deleted if splashscreen is not required or if you are getting undesired errors
        @Override // For splashscreen
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splashscreen); // Here 'splashscreen' is a filename in 'layout' folder
            int secondsDelayed = 3; // Set splashscreen timeout here
            new Handler().postDelayed(new Runnable() {
                 public void run() {
		     startActivity(new Intent(Splash.this, MainActivity.class));
                     finish();
                 }
             }, secondsDelayed * 1000);
         }
    }
}
```

## How to make a simple Android WebView app on Android?
- **Step 1:** Download [AIDE](https://play.google.com/store/apps/details?id=com.aide.ui&hl=en_IN&gl=US) and open a new project with all suitable details.
- **Step 2:** 

## Some Rules
Apps with the primary functionality of WebView are allowed to be publicly released if the website of which the app is, is owned by you. It is not allowed to publish apps that provide a WebView of a website you don't own or administer. Yes, if the app's main goal is not to make just an app for the website but to have an embedded browser, then you can do so. Your app should include features, content, and UI that elevates it beyond a repackaged website if you want to use someone else's website. Although, this tutorial was not an example for this.
