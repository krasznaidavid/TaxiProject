package com.dawidworks.taxiproject.web;

import java.util.ArrayList;

import com.dawidworks.taxiproject.R;

public class WebPageDetailManager {
	
	private static ArrayList<WebPageDetail> mWebPageDetails;
	
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
    	indexDetail.setStartUrl("m.index.hu");
    	ArrayList<String> indexAcceptedUrls = new ArrayList<String>();
    	indexAcceptedUrls.add("www.index.hu");
    	indexAcceptedUrls.add("index.hu");
    	indexAcceptedUrls.add("m.index.hu");
    	indexAcceptedUrls.add("daemon.indapass.hu/http/session_request?redirect_to=http%3A%2F%2Fm.index.hu");
    	indexAcceptedUrls.add("daemon.indapass.hu/http/session_request?redirect_to=http%3A%2F%2Findex.hu");
    	indexAcceptedUrls.add("daemon.indapass.hu/http/session_request?redirect_to=http%3A%2F%2Fwww.index.hu");
    	indexDetail.setAcceptedUrls(indexAcceptedUrls);
    	indexDetail.setImageId(R.drawable.index);
    	
    	mWebPageDetails.add(indexDetail);
    	
    	WebPageDetail sgDetail = new WebPageDetail(0, 3);
    	sgDetail.setStartUrl("m.sg.hu");
    	ArrayList<String> sgAcceptedUrls = new ArrayList<String>();
    	sgAcceptedUrls.add("www.sg.hu");
    	sgAcceptedUrls.add("sg.hu");
    	sgAcceptedUrls.add("m.sg.hu");
    	sgDetail.setAcceptedUrls(sgAcceptedUrls);
    	sgDetail.setImageId(R.drawable.sg);
    	
    	mWebPageDetails.add(sgDetail);
    	
    	WebPageDetail origoDetail = new WebPageDetail(0, 6);
    	origoDetail.setStartUrl("origo.hu");
    	ArrayList<String> origoAcceptedUrls = new ArrayList<String>();
    	origoAcceptedUrls.add("www.origo.hu");
    	origoAcceptedUrls.add("origo.hu");
    	origoAcceptedUrls.add("m.origo.hu");
    	origoDetail.setAcceptedUrls(origoAcceptedUrls);
    	origoDetail.setImageId(R.drawable.origo);
    	
    	mWebPageDetails.add(origoDetail);
    	
    	WebPageDetail hvgDetail = new WebPageDetail(0, 10);
    	hvgDetail.setStartUrl("hvg.hu");
    	ArrayList<String> hvgAcceptedUrls = new ArrayList<String>();
    	hvgAcceptedUrls.add("www.hvg.hu");
    	hvgAcceptedUrls.add("hvg.hu");
    	hvgAcceptedUrls.add("m.hvg.hu");
    	hvgDetail.setAcceptedUrls(hvgAcceptedUrls);
    	hvgDetail.setImageId(R.drawable.hvg);
    	
    	mWebPageDetails.add(hvgDetail);
    }	
}
