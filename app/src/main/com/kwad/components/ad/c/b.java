package com.kwad.components.ad.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* loaded from: classes2.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public FrameLayout bG;
    public a bH;
    public KsAdVideoPlayConfig bI;
    public List<AdTemplate> bJ;
    private KsBannerAd.BannerAdInteractionListener bK;
    public StyleTemplate bL;
    public boolean bM = false;
    public AdResultData mAdResultData;

    @NonNull
    public SceneImpl mAdScene;
    public Context mContext;

    public interface a {
        void Y();
    }

    @MainThread
    public final void V() {
        this.mAdTemplate.converted = true;
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bK;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdShow();
        }
    }

    @MainThread
    public final void W() {
        this.mAdTemplate.converted = true;
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bK;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdClicked();
        }
    }

    @MainThread
    public final void X() {
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bK;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdClose();
        }
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.o(adResultData);
    }

    @MainThread
    public final void c(int i10, String str) {
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bK;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdShowError(0, str);
        }
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
    }

    public static boolean a(AdTemplate adTemplate) {
        AdMatrixInfo.AdBannerTKInfo dp;
        return com.kwad.sdk.core.config.d.Du() && (dp = com.kwad.sdk.core.response.b.b.dp(adTemplate)) != null && !TextUtils.isEmpty(dp.templateId) && dp.renderType == 1;
    }

    public final void a(KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener) {
        this.bK = bannerAdInteractionListener;
    }

    public final void a(a aVar) {
        this.bH = aVar;
    }
}
