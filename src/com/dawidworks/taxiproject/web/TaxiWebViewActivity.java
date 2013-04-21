package com.dawidworks.taxiproject.web;

import java.lang.reflect.Method;
import java.util.ArrayList;

import com.dawidworks.taxiproject.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

public class TaxiWebViewActivity extends Activity {

	public static final String START_URL_KEY = "start_Url";
	public static final String ACCEPTED_URLS_KEY = "accpted_Urls";
	
	private WebView mWebView;

	@SuppressLint("SetJavaScriptEnabled")
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
		
		setContentView(R.layout.web_view);

		Bundle extras = getIntent().getExtras();
		String startUrl = extras.getString(START_URL_KEY);
		ArrayList<String> acceptedUrls = extras.getStringArrayList(ACCEPTED_URLS_KEY);
		
		mWebView = (WebView) findViewById(R.id.webView);
		mWebView.setWebViewClient(new TaxiWebViewClient(acceptedUrls));
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.loadUrl(startUrl);
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		try
        {
			//Hack: így lehet megakadályozni a státuszbár legödítését
           if(!hasFocus)
           {
                Object service = getSystemService("statusbar");
                Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
                Method collapse = statusbarManager.getMethod("collapse");
                collapse.setAccessible(true);
                collapse.invoke(service);
           }
        }
        catch(Exception ex)
        {}
	}
}
