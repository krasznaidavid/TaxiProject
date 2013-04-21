package com.dawidworks.taxiproject.web;

import java.util.ArrayList;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class TaxiWebViewClient extends WebViewClient {
	
	private ArrayList<String> mAcceptedUrls;
	
	public TaxiWebViewClient(ArrayList<String> acceptedUrls) {
		mAcceptedUrls = acceptedUrls;
	}
	
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		return isAcceptedeUrl(view, url);
	}
	
	private boolean isAcceptedeUrl(WebView view, String url) {
		for (String urlStr : mAcceptedUrls) {
			if (!urlStr.startsWith("http://") && !urlStr.startsWith("https://")) {
				String httpUrl = "http://" + urlStr;
				String httpsUrl = "https://" + urlStr;
				if (url.startsWith(httpUrl) || url.startsWith(httpsUrl))
					return false;
			}
			else if (url.startsWith(urlStr))
				return false;
		}
		Toast.makeText(view.getContext(), "Navigálunk navigálunk? Sajnos nem lehet :(", Toast.LENGTH_SHORT).show();
		return true;
	}
}
