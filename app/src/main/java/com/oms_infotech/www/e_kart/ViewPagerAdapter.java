package com.oms_infotech.www.e_kart;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Himanshu on 10/20/2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentsArray=new ArrayList<>();
    List<String> tabTitle =new ArrayList<>();


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentsArray.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsArray.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle.get(position);
    }


    public void addFragment(Fragment fragment,String string) {
        fragmentsArray.add(fragment);
        tabTitle.add(string);
    }
}