package com.android.floripatourguide.build;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context thisContext;
    private int currentPos = -1;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.addToBackStack(null);
        transaction.commit();

        thisContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            currentPos = 0;
            return new PasseiosFragment();
        } else if (position == 1) {
            currentPos = 1;
            return new PraiasFragment();
        } else if (position == 2) {
            currentPos = 2;
            return new ComidaFragment();
        } else {
            currentPos = 3;
            return new TrilhasFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return thisContext.getString(R.string.category_passeios);
        } else if (position == 1) {
            return thisContext.getString(R.string.category_praias);
        } else if (position == 2) {
            return thisContext.getString(R.string.category_comida);
        } else if (position == 3) {
            return thisContext.getString(R.string.category_trilhas);
        } else {
            return "";
        }
    }

}
