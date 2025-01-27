package com.opos.mobad.n.c;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* loaded from: classes4.dex */
public class o extends Scroller {

    /* renamed from: a */
    private int f22064a;

    public o(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.f22064a = 1000;
    }

    public void a(int i2) {
        this.f22064a = i2;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i2, int i3, int i4, int i5) {
        super.startScroll(i2, i3, i4, i5, this.f22064a);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i2, int i3, int i4, int i5, int i6) {
        super.startScroll(i2, i3, i4, i5, this.f22064a);
    }
}
