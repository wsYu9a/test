package com.martian.libmars.utils.tablayout;

import androidx.viewpager.widget.ViewPager;

/* loaded from: classes2.dex */
public class p {

    static class a implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        final /* synthetic */ MagicIndicator f10272a;

        a(final MagicIndicator val$magicIndicator) {
            this.f10272a = val$magicIndicator;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.f10272a.b(state);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            this.f10272a.c(position, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            this.f10272a.d(position);
        }
    }

    public static void a(final MagicIndicator magicIndicator, ViewPager viewPager) {
        if (magicIndicator == null || viewPager == null) {
            return;
        }
        viewPager.addOnPageChangeListener(new a(magicIndicator));
    }
}
