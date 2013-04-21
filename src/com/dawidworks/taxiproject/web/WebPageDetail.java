package com.dawidworks.taxiproject.web;

import java.util.ArrayList;

public class WebPageDetail {
	
	private int mImageId;
	private int mPageNumber;
	private int mPosition;
	private String mStartUrl;
	private ArrayList<String> mAcceptedUrls;
	
	public WebPageDetail() {}
	
	public WebPageDetail(int mPageNumber, int mPosition) {
		super();
		this.mPageNumber = mPageNumber;
		this.mPosition = mPosition;
	}

	public WebPageDetail(int mImageId, int mPageNumber, int mPosition,
			String mStartUrl, ArrayList<String> mAcceptedUrls) {
		super();
		this.mImageId = mImageId;
		this.mPageNumber = mPageNumber;
		this.mPosition = mPosition;
		this.mStartUrl = mStartUrl;
		this.mAcceptedUrls = mAcceptedUrls;
	}

	public int getImageId() {
		return mImageId;
	}

	public void setImageId(int imageId) {
		this.mImageId = imageId;
	}

	public int getPageNumber() {
		return mPageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.mPageNumber = pageNumber;
	}

	public int getPosition() {
		return mPosition;
	}

	public void setPosition(int position) {
		this.mPosition = position;
	}

	public String getStartUrl() {
		return mStartUrl;
	}
	
	public void setStartUrl(String startUrl) {
		if (!startUrl.startsWith("http://") && !startUrl.startsWith("https://"))
			startUrl = "http://" + startUrl;
		this.mStartUrl = startUrl;
	}

	public ArrayList<String> getAcceptedUrls() {
		return mAcceptedUrls;
	}

	public void setAcceptedUrls(ArrayList<String> acceptedUrls) {
		this.mAcceptedUrls = acceptedUrls;
	}

}
