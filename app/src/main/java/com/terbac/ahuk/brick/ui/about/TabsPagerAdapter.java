package com.terbac.ahuk.brick.ui.about;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
/**
 * Adapter for the tabs
 */
@SuppressWarnings("ALL")
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index)
    {
        switch (index) {
            case 0:
                return new HeadlessFragment.BacterHeadlessFragment();
            case 1:
                return new LicenseFragment();
            case 2:
                return new ChangeLogFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}