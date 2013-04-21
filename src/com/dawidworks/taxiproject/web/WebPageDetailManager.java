package com.dawidworks.taxiproject.web;

import java.util.ArrayList;

import com.dawidworks.taxiproject.R;

public class WebPageDetailManager {

    static {
		initalizeWebPageDatails();
	}
    
    public static WebPageDetail getWebPageDetail(int pageNumber, int position) {
    	for (WebPageDetail wpd : mWebPageDetails) {
    		if (wpd.getPageNumber() == pageNumber && wpd.getPosition() == position)
    			return wpd;
    	}
    	return null;
    }
	
    private static void initalizeWebPageDatails() {
    	mWebPageDetails = new ArrayList<WebPageDetail>();
    	
    	WebPageDetail indexDetail = new WebPageDetail(0, 0);
    	indexDetail.setStartUrl("http://m.index.hu");
    	ArrayList<String> indexAcceptedUrls = new ArrayList<String>();
    	indexAcceptedUrls.add("http://index.hu");
    	indexAcceptedUrls.add("https://index.hu");
    	indexAcceptedUrls.add("http://www.index.hu");
    	indexAcceptedUrls.add("https://www.index.hu");
    	indexAcceptedUrls.add("http://m.index.hu");
    	indexAcceptedUrls.add("https://m.index.hu");
    	indexAcceptedUrls.add("http://daemon.indapass.hu/http/session_request?redirect_to=http");
    	indexAcceptedUrls.add("https://daemon.indapass.hu/http/session_request?redirect_to=http");
    	indexDetail.setAcceptedUrls(indexAcceptedUrls);
    	indexDetail.setImageId(R.drawable.index);
    	
    	mWebPageDetails.add(indexDetail);
    }
    
	private static ArrayList<WebPageDetail> mWebPageDetails;
	
}
