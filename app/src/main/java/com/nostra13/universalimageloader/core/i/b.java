package com.nostra13.universalimageloader.core.i;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: a */
    private final int f16027a;

    /* renamed from: b */
    private final boolean f16028b;

    /* renamed from: c */
    private final boolean f16029c;

    /* renamed from: d */
    private final boolean f16030d;

    public b(int i2) {
        this(i2, true, true, true);
    }

    public static void b(View view, int i2) {
        if (view != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(i2);
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            view.startAnimation(alphaAnimation);
        }
    }

    @Override // com.nostra13.universalimageloader.core.i.a
    public void a(Bitmap bitmap, com.nostra13.universalimageloader.core.j.a aVar, LoadedFrom loadedFrom) {
        aVar.setImageBitmap(bitmap);
        if ((this.f16028b && loadedFrom == LoadedFrom.NETWORK) || ((this.f16029c && loadedFrom == LoadedFrom.DISC_CACHE) || (this.f16030d && loadedFrom == LoadedFrom.MEMORY_CACHE))) {
            b(aVar.getWrappedView(), this.f16027a);
        }
    }

    public b(int i2, boolean z, boolean z2, boolean z3) {
        this.f16027a = i2;
        this.f16028b = z;
        this.f16029c = z2;
        this.f16030d = z3;
    }
}
