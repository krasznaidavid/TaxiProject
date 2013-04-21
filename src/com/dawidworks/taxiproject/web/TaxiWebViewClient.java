package com.dawidworks.taxiproject.web;

import java.util.ArrayList;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TaxiWebViewClient extends WebViewClient {
	
	private ArrayList<String> mAcceptedUrls;
	
	public TaxiWebViewClient(ArrayList<String> acceptedUrls) {
		mAcceptedUrls = acceptedUrls;
	}
	
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		return isAcceptedeUrl(url);
	}
	
	private boolean isAcceptedeUrl(String url) {
		for (String urlStr : mAcceptedUrls) {
			if (url.startsWith(urlStr))
				return false;
		}
		return true;
	}
}
