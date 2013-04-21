package com.dawidworks.taxiproject.layout;

import com.dawidworks.taxiproject.R;
import com.dawidworks.taxiproject.web.WebPageDetail;
import com.dawidworks.taxiproject.web.WebPageDetailManager;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    
	private Context mContext;
	
	private final int mItemCount = 12;
	private final int mRowCount = 3;
	private final int mColumnCount = 4;
	private final int mPadding = 12;
	
	private int mPageNumber;
	
	private int mImageWidth;
	private int mImageHeight;
	

    public ImageAdapter(Context context, int pageNumber) {
        mContext = context;
        mPageNumber = pageNumber;
        calculateImageSize();
    }

    public int getCount() {
        return mItemCount;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(mImageWidth, mImageHeight));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(mPadding, mPadding, mPadding, mPadding);
        } else {
            imageView = (ImageView) convertView;
        }

        int imageId;
        WebPageDetail wpd = WebPageDetailManager.getWebPageDetail(mPageNumber, position);
        imageId = wpd == null ? R.drawable.ic_launcher : wpd.getImageId();
        imageView.setImageResource(imageId);
        return imageView;
    }

    private void calculateImageSize() {
    	WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
    	Display display = wm.getDefaultDisplay();  	
    	Point size = new Point();
    	display.getSize(size);
    	int screenWidth = size.x;
    	int screenHeight = size.y;
    	
    	mImageHeight = (screenHeight - ((mRowCount + 1) * mPadding)) / mRowCount;
    	mImageWidth = (screenWidth - ((mColumnCount + 1) * mPadding)) / mColumnCount;
    }
}

