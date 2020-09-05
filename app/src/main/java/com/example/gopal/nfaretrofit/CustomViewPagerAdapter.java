package com.example.gopal.nfaretrofit;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CustomViewPagerAdapter extends FragmentPagerAdapter {
    String Url;
    Context mContext;

    public CustomViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Url = "https://content.guardianapis.com/search?&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail,byline";
                break;
            case 1:
                Url = "https://content.guardianapis.com/search?q=sports&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail,byline";
                break;
            case 2:
                Url = "https://content.guardianapis.com/search?q=entertainment,movie&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail,byline";
                break;
            case 3:
                Url = "https://content.guardianapis.com/search?q=tech&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail,byline";
                break;
            case 4:
                Url = "https://content.guardianapis.com/search?q=politics&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail,byline";
                break;
            default:
                Url = "https://content.guardianapis.com/search?q=health&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail,byline";
                break;
        }
        return MasterFragment.newInstance(Url);
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.nfa);
            case 1:
                return mContext.getString(R.string.sports);
            case 2:
                return mContext.getString(R.string.entertainment);
            case 3:
                return mContext.getString(R.string.Tech);
            case 4:
                return mContext.getString(R.string.politics);
            default:
                return mContext.getString(R.string.Health);
        }
    }

}