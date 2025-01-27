package com.martian.libsupport.bannerView;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes3.dex */
public class CoverModeTransformer implements ViewPager.PageTransformer {

    /* renamed from: a */
    public float f12965a = 0.0f;

    /* renamed from: b */
    public float f12966b = 0.0f;

    /* renamed from: c */
    public float f12967c = 0.0f;

    /* renamed from: d */
    public final ViewPager f12968d;

    public CoverModeTransformer(ViewPager viewPager) {
        this.f12968d = viewPager;
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(@NonNull View view, float f10) {
        if (this.f12967c == 0.0f) {
            float paddingLeft = this.f12968d.getPaddingLeft();
            this.f12967c = paddingLeft / ((this.f12968d.getMeasuredWidth() - paddingLeft) - this.f12968d.getPaddingRight());
        }
        float f11 = f10 - this.f12967c;
        if (this.f12966b == 0.0f) {
            float width = view.getWidth();
            this.f12966b = width;
            this.f12965a = (width * 0.3f) / 2.0f;
        }
        if (f11 <= -1.0f) {
            view.setTranslationX(this.f12965a);
            view.setScaleX(0.7f);
            view.setScaleY(0.7f);
        } else if (f11 > 1.0d) {
            view.setScaleX(0.7f);
            view.setScaleY(0.7f);
            view.setTranslationX(-this.f12965a);
        } else {
            float abs = 0.3f * Math.abs(1.0f - Math.abs(f11));
            view.setTranslationX(f11 * (-this.f12965a));
            float f12 = abs + 0.7f;
            view.setScaleX(f12);
            view.setScaleY(f12);
        }
    }
}
