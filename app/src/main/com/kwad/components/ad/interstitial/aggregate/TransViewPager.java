package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class TransViewPager extends com.kwad.sdk.widget.d {

    /* renamed from: ki */
    private float f11576ki;

    /* renamed from: kj */
    @SlideType
    private int f11577kj;
    private Map<Integer, com.kwad.components.ad.interstitial.h.c> map;

    public TransViewPager(@NonNull Context context) {
        this(context, null);
    }

    private void a(View view, View view2, float f10) {
        if (this.f11577kj == 0 && f10 != 0.0f) {
            float f11 = this.f11576ki;
            if (f11 != 0.0f) {
                if (f10 > f11) {
                    this.f11577kj = 1;
                } else {
                    this.f11577kj = 2;
                }
            }
        }
        if (this.f11577kj == 1 && view2 != null) {
            if (f10 > 0.5d || f10 <= 0.0f) {
                view2.setTranslationX((1.0f - f10) * 240.0f);
            } else {
                view2.setTranslationX(240.0f * f10);
            }
        }
        if (this.f11577kj == 2 && view != null) {
            if (f10 > 0.5d || f10 < 0.0f) {
                view.setTranslationX((1.0f - f10) * (-240.0f));
            } else {
                view.setTranslationX((-240.0f) * f10);
            }
        }
        this.f11576ki = f10;
        if (f10 == 0.0f) {
            this.f11577kj = 0;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void onPageScrolled(int i10, float f10, int i11) {
        a(y(i10), y(i10 + 1), f10);
        super.onPageScrolled(i10, f10, i11);
    }

    public final com.kwad.components.ad.interstitial.h.c y(int i10) {
        return this.map.get(Integer.valueOf(i10));
    }

    public TransViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.map = new HashMap();
        this.f11577kj = 0;
    }

    public final void a(int i10, com.kwad.components.ad.interstitial.h.c cVar) {
        this.map.put(Integer.valueOf(i10), cVar);
    }
}
