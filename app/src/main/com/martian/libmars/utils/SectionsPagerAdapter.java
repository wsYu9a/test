package com.martian.libmars.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    /* renamed from: a */
    public final List<a> f12400a;

    public static class a {

        /* renamed from: a */
        public Fragment f12401a;

        /* renamed from: b */
        public String f12402b;

        public Fragment a() {
            return this.f12401a;
        }

        public String b() {
            return this.f12402b;
        }

        public a c(Fragment fragment) {
            this.f12401a = fragment;
            return this;
        }

        public a d(String str) {
            this.f12402b = str;
            return this;
        }
    }

    public SectionsPagerAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager, 1);
        if (list == null || list.isEmpty()) {
            this.f12400a = new ArrayList();
        } else {
            this.f12400a = list;
        }
    }

    public List<a> a() {
        List<a> list = this.f12400a;
        return list == null ? new ArrayList() : list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f12400a.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @NonNull
    public Fragment getItem(int i10) {
        return this.f12400a.get(i10).a();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i10) {
        return i10 >= this.f12400a.size() ? "" : this.f12400a.get(i10).b();
    }
}
