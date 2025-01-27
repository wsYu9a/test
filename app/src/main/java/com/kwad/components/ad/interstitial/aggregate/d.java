package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.utils.w;

/* loaded from: classes2.dex */
public final class d extends Scroller {
    private final int kA;

    public d(Context context) {
        super(context);
        this.kA = 1000;
    }

    public final void a(ViewPager viewPager) {
        try {
            w.a(viewPager, "mScroller", this);
        } catch (Throwable unused) {
        }
    }

    @Override // android.widget.Scroller
    public final void startScroll(int i10, int i11, int i12, int i13) {
        super.startScroll(i10, i11, i12, i13, 1000);
    }

    @Override // android.widget.Scroller
    public final void startScroll(int i10, int i11, int i12, int i13, int i14) {
        super.startScroll(i10, i11, i12, i13, 1000);
    }
}
