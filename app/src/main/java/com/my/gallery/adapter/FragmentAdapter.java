package com.my.gallery.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.my.gallery.activity.PhotoActivity;
import com.my.gallery.activity.VideoActivity;

public class FragmentAdapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;

    public FragmentAdapter(Context context, @NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.context = context;
        this.totalTabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                PhotoActivity photoActivity = new PhotoActivity();
                return photoActivity;
            case 1:
                VideoActivity videoActivity = new VideoActivity();
                return videoActivity;
        }
        return null;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
