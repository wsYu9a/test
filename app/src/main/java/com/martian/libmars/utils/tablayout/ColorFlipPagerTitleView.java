package com.martian.libmars.utils.tablayout;

import android.content.Context;

/* loaded from: classes3.dex */
public class ColorFlipPagerTitleView extends SimplePagerTitleView {

    /* renamed from: h */
    public float f12414h;

    public ColorFlipPagerTitleView(Context context, boolean z10) {
        super(context, z10);
        this.f12414h = 0.5f;
    }

    @Override // com.martian.libmars.utils.tablayout.SimplePagerTitleView, m9.g
    public void b(int i10, int i11) {
    }

    @Override // com.martian.libmars.utils.tablayout.SimplePagerTitleView, m9.g
    public void c(int i10, int i11, float f10, boolean z10) {
        if (f10 >= this.f12414h) {
            setTextColor(this.f12475b);
        } else {
            setTextColor(this.f12476c);
        }
    }

    @Override // com.martian.libmars.utils.tablayout.SimplePagerTitleView, m9.g
    public void d(int i10, int i11) {
    }

    @Override // com.martian.libmars.utils.tablayout.SimplePagerTitleView, m9.g
    public void e(int i10, int i11, float f10, boolean z10) {
        if (f10 >= this.f12414h) {
            setTextColor(this.f12476c);
        } else {
            setTextColor(this.f12475b);
        }
    }

    public float getChangePercent() {
        return this.f12414h;
    }

    public void setChangePercent(float f10) {
        this.f12414h = f10;
    }
}
