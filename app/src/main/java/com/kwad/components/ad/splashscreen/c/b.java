package com.kwad.components.ad.splashscreen.c;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.components.core.c.f;
import com.kwad.components.core.proxy.h;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class b extends h {
    private KsSplashScreenAd.SplashScreenAdInteractionListener DH;

    /* renamed from: dk */
    private com.kwad.sdk.core.h.b f11900dk;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;

    private void a(com.kwad.sdk.core.h.b bVar) {
        this.f11900dk = bVar;
    }

    public static b b(@NonNull AdResultData adResultData, com.kwad.sdk.core.h.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Bundle bundle = new Bundle();
        bundle.putInt("ad_result_cache_idx", f.nt().j(adResultData));
        b bVar2 = new b();
        bVar2.setArguments(bundle);
        bVar2.a(bVar);
        bVar2.setSplashScreenAdListener(splashScreenAdInteractionListener);
        return bVar2;
    }

    private void initData() {
        int i10 = getArguments().getInt("ad_result_cache_idx");
        if (i10 > 0) {
            AdResultData d10 = f.nt().d(i10, true);
            this.mAdResultData = d10;
            this.mAdTemplate = c.o(d10);
        }
    }

    private void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.DH = splashScreenAdInteractionListener;
    }

    @Override // com.kwad.components.core.proxy.h
    public final ViewGroup mw() {
        initData();
        if (this.mAdTemplate != null) {
            return com.kwad.components.ad.splashscreen.c.a(this.mContext, this.mAdResultData, false, this.f11900dk, this.DH);
        }
        com.kwad.components.ad.splashscreen.monitor.b.lm();
        com.kwad.components.ad.splashscreen.monitor.b.a((AdTemplate) null, "adTemplate null", false);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(0, "data parse error");
        }
        return null;
    }
}
