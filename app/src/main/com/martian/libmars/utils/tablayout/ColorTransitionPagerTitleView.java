package com.martian.libmars.utils.tablayout;

import android.content.Context;

/* loaded from: classes3.dex */
public class ColorTransitionPagerTitleView extends SimplePagerTitleView {
    public ColorTransitionPagerTitleView(Context context, boolean z10) {
        super(context, z10);
    }

    @Override // com.martian.libmars.utils.tablayout.SimplePagerTitleView, m9.g
    public void b(int i10, int i11) {
        super.b(i10, i11);
    }

    @Override // com.martian.libmars.utils.tablayout.SimplePagerTitleView, m9.g
    public void c(int i10, int i11, float f10, boolean z10) {
        setTextColor(m9.a.a(f10, this.f12476c, this.f12475b));
    }

    @Override // com.martian.libmars.utils.tablayout.SimplePagerTitleView, m9.g
    public void d(int i10, int i11) {
        super.d(i10, i11);
    }

    @Override // com.martian.libmars.utils.tablayout.SimplePagerTitleView, m9.g
    public void e(int i10, int i11, float f10, boolean z10) {
        setTextColor(m9.a.a(f10, this.f12475b, this.f12476c));
    }
}
