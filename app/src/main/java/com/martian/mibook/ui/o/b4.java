package com.martian.mibook.ui.o;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

/* loaded from: classes4.dex */
public class b4 extends FragmentPagerAdapter {

    /* renamed from: g */
    private final List<Fragment> f14299g;

    public b4(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.f14299g = fragments;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f14299g.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @NonNull
    public Fragment getItem(int arg0) {
        return this.f14299g.get(arg0);
    }
}
