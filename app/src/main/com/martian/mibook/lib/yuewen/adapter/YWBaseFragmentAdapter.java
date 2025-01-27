package com.martian.mibook.lib.yuewen.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class YWBaseFragmentAdapter extends FragmentPagerAdapter {

    /* renamed from: a */
    public List<Fragment> f14009a;

    /* renamed from: b */
    public List<String> f14010b;

    public YWBaseFragmentAdapter(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        new ArrayList();
        this.f14009a = list;
    }

    public boolean a(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public void b(FragmentManager fragmentManager, List<Fragment> list, List<String> list2) {
        this.f14010b = list2;
        if (this.f14009a != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Iterator<Fragment> it = this.f14009a.iterator();
            while (it.hasNext()) {
                beginTransaction.remove(it.next());
            }
            beginTransaction.commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        this.f14009a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f14009a.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i10) {
        return this.f14009a.get(i10);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i10) {
        return !a(this.f14010b) ? this.f14010b.get(i10) : "";
    }

    public YWBaseFragmentAdapter(FragmentManager fragmentManager, List<Fragment> list, List<String> list2) {
        super(fragmentManager);
        this.f14009a = new ArrayList();
        this.f14010b = list2;
        b(fragmentManager, list, list2);
    }
}
