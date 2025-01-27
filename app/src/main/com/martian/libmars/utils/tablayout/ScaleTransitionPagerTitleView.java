package com.martian.libmars.utils.tablayout;

import android.content.Context;

/* loaded from: classes3.dex */
public class ScaleTransitionPagerTitleView extends ColorTransitionPagerTitleView {

    /* renamed from: h */
    public float f12472h;

    /* renamed from: i */
    public float f12473i;

    /* renamed from: j */
    public boolean f12474j;

    public ScaleTransitionPagerTitleView(Context context, boolean z10) {
        super(context, z10);
        this.f12472h = 1.2f;
        this.f12473i = 0.89f;
    }

    @Override // com.martian.libmars.utils.tablayout.ColorTransitionPagerTitleView, com.martian.libmars.utils.tablayout.SimplePagerTitleView, m9.g
    public void c(int i10, int i11, float f10, boolean z10) {
        super.c(i10, i11, f10, z10);
        setPivotX(getWidth() >> 1);
        if (!this.f12474j) {
            setPivotY(getContentBottom());
            setScaleX(((this.f12472h - 1.0f) * f10) + 1.0f);
            setScaleY(((this.f12472h - 1.0f) * f10) + 1.0f);
        } else {
            float f11 = this.f12473i;
            setScaleX(f11 + ((1.0f - f11) * f10));
            float f12 = this.f12473i;
            setScaleY(f12 + ((1.0f - f12) * f10));
        }
    }

    @Override // com.martian.libmars.utils.tablayout.ColorTransitionPagerTitleView, com.martian.libmars.utils.tablayout.SimplePagerTitleView, m9.g
    public void e(int i10, int i11, float f10, boolean z10) {
        super.e(i10, i11, f10, z10);
        if (this.f12474j) {
            setScaleX(((this.f12473i - 1.0f) * f10) + 1.0f);
            setScaleY(((this.f12473i - 1.0f) * f10) + 1.0f);
            return;
        }
        setPivotY(getContentBottom());
        float f11 = this.f12472h;
        setScaleX(f11 + ((1.0f - f11) * f10));
        float f12 = this.f12472h;
        setScaleY(f12 + ((1.0f - f12) * f10));
    }

    public void setMaxScale(float f10) {
        this.f12472h = f10;
    }

    public void setMinScale(float f10) {
        this.f12473i = f10;
    }

    public void setMinScaleType(boolean z10) {
        this.f12474j = z10;
    }
}
