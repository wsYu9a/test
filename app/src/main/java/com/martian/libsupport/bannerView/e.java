package com.martian.libsupport.bannerView;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes3.dex */
public class e implements ViewPager.PageTransformer {

    /* renamed from: a */
    private static final float f10580a = 0.7f;

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(@NonNull View page, float position) {
        if (position < -1.0f) {
            page.setScaleY(f10580a);
        } else if (position <= 1.0f) {
            page.setScaleY(Math.max(f10580a, 1.0f - Math.abs(position)));
        } else {
            page.setScaleY(f10580a);
        }
    }
}
