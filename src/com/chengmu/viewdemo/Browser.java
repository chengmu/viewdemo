package com.chengmu.viewdemo;

import com.chengmu.viewdemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;




public class Browser extends Activity {
	EditText url;
	WebView show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        
        url = (EditText) findViewById(R.id.url);
		show = (WebView) findViewById(R.id.show);
        show.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                return false;
            }
        });


        WebSettings webSettings = show.getSettings();
//        webSettings.setSupportZoom(true);
//        webSettings.setBuiltInZoomControls(true);
//        webSettings.setLoadWithOverviewMode(tr‰ue);
//        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUserAgentString("Mozilla/5.0 (Android 4.2; rv:19.0) Gecko/20121129 Firefox/19.0");



        show.addJavascriptInterface(new MyObj(this), "me");


        show.loadUrl("file:///android_asset/index.html");


        show.setWebChromeClient(new WebChromeClient() {
            public void onConsoleMessage(String message, int lineNumber, String sourceID) {
                Log.d("MyApplication", message + " -- From line "
                        + lineNumber + " of "
                        + sourceID);
            }
        });

        show.loadUrl("javascript:testAndroidCallJs('chengmu')");


//        show.setWebChromeClient(new WebChromeClient() {
//            public boolean onConsoleMessage(ConsoleMessage cm) {
//                Log.d("MyApplication", cm.message() + " -- From line "
//                        + cm.lineNumber() + " of "
//                        + cm.sourceId() );
//                return true;
//            }
//        });

        
    }

    private static final String TAG = "MyActivity";


    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
        Log.e(TAG, "keycode is " + keyCode + "");
        Log.e(TAG, "search keycode" + KeyEvent.KEYCODE_SEARCH + "");

		if (keyCode == 67)
		{
			String urlStr = url.getText().toString();
            Log.e(TAG, "srt = " + urlStr);
			show.loadUrl("http://" + urlStr);
			return true;
		}
		return false;
	}





}
