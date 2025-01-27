package com.kwad.components.ad.interstitial;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: classes2.dex */
public final class e {
    public static KsInterstitialAd d(@NonNull AdResultData adResultData) {
        int et = com.kwad.sdk.core.response.b.e.et(com.kwad.sdk.core.response.b.c.o(adResultData));
        return et != 1 ? et != 2 ? new b(adResultData) : new com.kwad.components.ad.interstitial.e.a(false, adResultData) : new com.kwad.components.ad.interstitial.e.a(true, adResultData);
    }
}
