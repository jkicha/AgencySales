package com.jss.repman.agencysales;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by krishna on 08-05-2014.
 */
public class ViewPagerStyle1Activity extends FragmentActivity{


    private ViewPager _mViewPager;
    private ViewPagerAdapter _adapter;

    /** Called when the activity is first created */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_detail);
        Log.i("agency", "inside style1 class oncreate");
        setUpView();
        setTab();
    }

    private void setTab() {
        _mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        findViewById(R.id.first_tab).setVisibility(View.VISIBLE);
                        findViewById(R.id.second_tab).setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        findViewById(R.id.first_tab).setVisibility(View.INVISIBLE);
                        findViewById(R.id.second_tab).setVisibility(View.VISIBLE);
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setUpView() {
        _mViewPager = (ViewPager) findViewById(R.id.viewPager);
        _adapter = new ViewPagerAdapter(getApplicationContext(),getSupportFragmentManager());
        _mViewPager.setAdapter(_adapter);
        _mViewPager.setCurrentItem(0);
    }


}
