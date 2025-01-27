package com.martian.libmars.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class v0 extends FragmentPagerAdapter {

    /* renamed from: g */
    private List<a> f10278g;

    public static class a {

        /* renamed from: a */
        private Fragment f10279a;

        /* renamed from: b */
        private String f10280b;

        public Fragment a() {
            return this.f10279a;
        }

        public String b() {
            return this.f10280b;
        }

        public a c(Fragment fragment) {
            this.f10279a = fragment;
            return this;
        }

        public a d(String title) {
            this.f10280b = title;
            return this;
        }
    }

    public v0(FragmentManager fm, List<a> fragmentSections) {
        super(fm);
        if (fragmentSections == null || fragmentSections.isEmpty()) {
            this.f10278g = new ArrayList();
        } else {
            this.f10278g = fragmentSections;
        }
    }

    public List<a> b() {
        List<a> list = this.f10278g;
        return list == null ? new ArrayList() : list;
    }

    public void c(List<a> newFragmentSections) {
        List<a> list = this.f10278g;
        if (list != null) {
            list.clear();
        }
        this.f10278g = newFragmentSections;
        notifyDataSetChanged();
    }

    public void d(List<String> titles) {
        int i2 = 0;
        for (a aVar : this.f10278g) {
            if (i2 < titles.size()) {
                aVar.d(titles.get(i2));
                i2++;
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f10278g.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int position) {
        if (position >= this.f10278g.size()) {
            return null;
        }
        return this.f10278g.get(position).a();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        return position >= this.f10278g.size() ? "" : this.f10278g.get(position).b();
    }
}
