package com.jss.repman.agencysales;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by krishna on 08-05-2014.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context _context;

    public ViewPagerAdapter( Context _context, FragmentManager fm) {
        super(fm);
        this._context = _context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = new Fragment();
        switch (position) {
            case 0:
                f = LayoutOne.newInstance(_context);
                break;
            case 1:
                f = LayoutTwo.newInstance(_context);
                break;
        }
        return f;

    }
}
