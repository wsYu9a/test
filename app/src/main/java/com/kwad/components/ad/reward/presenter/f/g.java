package com.kwad.components.ad.reward.presenter.f;

import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes2.dex */
public abstract class g extends d {

    /* renamed from: yf */
    public KSFrameLayout f11778yf;

    public void a(FrameLayout frameLayout) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        KSFrameLayout kSFrameLayout = this.f11778yf;
        if (kSFrameLayout != null) {
            return kSFrameLayout;
        }
        KSFrameLayout kSFrameLayout2 = (KSFrameLayout) findViewById(ih());
        this.f11778yf = kSFrameLayout2;
        if (kSFrameLayout2 == null) {
            KSFrameLayout kSFrameLayout3 = new KSFrameLayout(getContext());
            this.f11778yf = kSFrameLayout3;
            kSFrameLayout3.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            a(this.f11778yf);
            ((FrameLayout) getRootView()).addView(this.f11778yf, layoutParams);
        }
        return this.f11778yf;
    }

    @IdRes
    public abstract int ih();
}
