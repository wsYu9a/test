package com.martian.libsupport.bannerView;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes3.dex */
public class ScaleYTransformer implements ViewPager.PageTransformer {

    /* renamed from: a */
    public static final float f13009a = 0.7f;

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(@NonNull View view, float f10) {
        if (f10 < -1.0f) {
            view.setScaleY(0.7f);
        } else if (f10 <= 1.0f) {
            view.setScaleY(Math.max(0.7f, 1.0f - Math.abs(f10)));
        } else {
            view.setScaleY(0.7f);
        }
    }
}
