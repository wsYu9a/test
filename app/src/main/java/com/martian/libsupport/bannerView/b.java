package com.martian.libsupport.bannerView;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes3.dex */
public class b implements ViewPager.PageTransformer {

    /* renamed from: a */
    private float f10576a = 0.0f;

    /* renamed from: b */
    private float f10577b = 0.0f;

    /* renamed from: c */
    private float f10578c = 0.0f;

    /* renamed from: d */
    private final ViewPager f10579d;

    public b(ViewPager pager) {
        this.f10579d = pager;
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(@NonNull View view, float position) {
        if (this.f10578c == 0.0f) {
            float paddingLeft = this.f10579d.getPaddingLeft();
            this.f10578c = paddingLeft / ((this.f10579d.getMeasuredWidth() - paddingLeft) - this.f10579d.getPaddingRight());
        }
        float f2 = position - this.f10578c;
        if (this.f10577b == 0.0f) {
            float width = view.getWidth();
            this.f10577b = width;
            this.f10576a = (width * 0.3f) / 2.0f;
        }
        if (f2 <= -1.0f) {
            view.setTranslationX(this.f10576a);
            view.setScaleX(0.7f);
            view.setScaleY(0.7f);
        } else if (f2 > 1.0d) {
            view.setScaleX(0.7f);
            view.setScaleY(0.7f);
            view.setTranslationX(-this.f10576a);
        } else {
            float abs = 0.3f * Math.abs(1.0f - Math.abs(f2));
            view.setTranslationX(f2 * (-this.f10576a));
            float f3 = abs + 0.7f;
            view.setScaleX(f3);
            view.setScaleY(f3);
        }
    }
}
