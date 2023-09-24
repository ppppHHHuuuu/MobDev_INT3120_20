package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class ViewPager2Adapter extends FragmentStateAdapter {
    private List<Fragment> pageLayouts;

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragmentList) {
        super(fragmentActivity);
        this.pageLayouts = fragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return a fragment for the corresponding layout
        return pageLayouts.get(position);

    }

    @Override
    public int getItemCount() {
        return pageLayouts.size();
    }
}
