package com.kwad.components.ad.interstitial.e;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes.dex */
public abstract class a extends FrameLayout {

    @NonNull
    public Context mContext;

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public abstract void a(@NonNull AdTemplate adTemplate, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener);

    public abstract void cu();

    public abstract void cv();

    public abstract void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener);
}
