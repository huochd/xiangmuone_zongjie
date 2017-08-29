package com.example.rain.xiangmuone_zongjie;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * data 2017/8/9.
 * author:霍远东(Rain)
 * function:
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    public MyPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private List<Fragment> list;

    public void init(List<Fragment> fragments) {
        list = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
