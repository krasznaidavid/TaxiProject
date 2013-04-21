package com.dawidworks.taxiproject;

import com.dawidworks.taxiproject.layout.ImageAdapter;
import com.dawidworks.taxiproject.web.TaxiWebViewActivity;
import com.dawidworks.taxiproject.web.WebPageDetail;
import com.dawidworks.taxiproject.web.WebPageDetailManager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class ScreenSlidePageFragment extends Fragment{
	
	public static final String PAGE_NUMBER = "page_number";
	
	private int mPageNumber; 
	
	public ScreenSlidePageFragment() {}
	
	public static ScreenSlidePageFragment create(int pageNumber) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(PAGE_NUMBER, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(PAGE_NUMBER);
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        
        final GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
        
        gridview.setAdapter(new ImageAdapter(rootView.getContext(), mPageNumber));
        
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

            	WebPageDetail wpd = WebPageDetailManager.getWebPageDetail(mPageNumber, position);
            	
            	if (wpd != null) {
	            	Intent intent = new Intent(rootView.getContext(), TaxiWebViewActivity.class);
	            	intent.putStringArrayListExtra(TaxiWebViewActivity.ACCEPTED_URLS_KEY, wpd.getAcceptedUrls());
	            	intent.putExtra(TaxiWebViewActivity.START_URL_KEY, wpd.getStartUrl());
					startActivity(intent);
            	}
            }
        });
        
        return rootView;
    }

	public int getPageNumber() {
        return mPageNumber;
    }
}
