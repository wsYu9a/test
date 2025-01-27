package com.martian.mibook.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

/* loaded from: classes3.dex */
public class HomepageFragmentAdapter extends FragmentPagerAdapter {

    /* renamed from: a */
    public final List<Fragment> f15860a;

    public HomepageFragmentAdapter(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager, 1);
        this.f15860a = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f15860a.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @NonNull
    public Fragment getItem(int i10) {
        return this.f15860a.get(i10);
    }
}
