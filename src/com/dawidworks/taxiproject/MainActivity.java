package com.dawidworks.taxiproject;


import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

import com.dawidworks.taxiproject.layout.ZoomOutPageTransformer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends FragmentActivity {
	
	private static final int NUM_PAGES = 3;
	private ViewPager mPager;
	private PagerAdapter mPagerAdapter;
	private Timer mTimer;
	
	public MainActivity() {
		setUpAndStartTimer();
	}
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);        
        
        setContentView(R.layout.activity_screen_slide);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
    }
	
	@Override
    public void onBackPressed() {

    }
	
	private void collapseStatusBar() {
		//Hack: így lehet megakadályozni a státuszbár legödítését
		try {
            Object service = getSystemService("statusbar");
            Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
            Method collapse = statusbarManager.getMethod("collapse");
            collapse.setAccessible(true);
            collapse.invoke(service);
        }
	    catch(Exception ex)
	    {}
	}
	
	private void setUpAndStartTimer() {
		mTimer = new Timer();
		mTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if (!hasWindowFocus()) {
					collapseStatusBar();
				}
			}
		}, 100, 100);
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
        if(!hasFocus) {
			collapseStatusBar();
        }
	}
	
	private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.create(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
