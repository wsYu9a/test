package com.martian.mibook.lib.yuewen.b;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends FragmentPagerAdapter {

    /* renamed from: g */
    List<Fragment> f14080g;

    /* renamed from: h */
    private List<String> f14081h;

    public a(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.f14080g = new ArrayList();
        this.f14080g = fragmentList;
    }

    public boolean b(Collection c2) {
        return c2 == null || c2.isEmpty();
    }

    public void c(FragmentManager fm, List<Fragment> fragments, List<String> mTitles) {
        this.f14081h = mTitles;
        if (this.f14080g != null) {
            FragmentTransaction beginTransaction = fm.beginTransaction();
            Iterator<Fragment> it = this.f14080g.iterator();
            while (it.hasNext()) {
                beginTransaction.remove(it.next());
            }
            beginTransaction.commitAllowingStateLoss();
            fm.executePendingTransactions();
        }
        this.f14080g = fragments;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f14080g.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int position) {
        return this.f14080g.get(position);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        return !b(this.f14081h) ? this.f14081h.get(position) : "";
    }

    public a(FragmentManager fm, List<Fragment> fragmentList, List<String> mTitles) {
        super(fm);
        this.f14080g = new ArrayList();
        this.f14081h = mTitles;
        c(fm, fragmentList, mTitles);
    }
}
