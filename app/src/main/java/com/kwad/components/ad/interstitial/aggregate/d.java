package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.utils.s;

/* loaded from: classes.dex */
public final class d extends Scroller {
    private final int iY;

    public d(Context context) {
        super(context);
        this.iY = 1000;
    }

    public final void a(ViewPager viewPager) {
        try {
            s.a(viewPager, "mScroller", this);
        } catch (Throwable unused) {
        }
    }

    @Override // android.widget.Scroller
    public final void startScroll(int i2, int i3, int i4, int i5) {
        super.startScroll(i2, i3, i4, i5, 1000);
    }

    @Override // android.widget.Scroller
    public final void startScroll(int i2, int i3, int i4, int i5, int i6) {
        super.startScroll(i2, i3, i4, i5, 1000);
    }
}
