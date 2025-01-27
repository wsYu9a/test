package com.kwad.sdk.api;

import android.app.Activity;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;

@KsAdSdkApi
@Keep
/* loaded from: classes2.dex */
public interface KsInterstitialAd extends BaseKSAd {

    @KsAdSdkApi
    @Keep
    public interface AdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked();

        @KsAdSdkApi
        @Keep
        void onAdClosed();

        @KsAdSdkApi
        @Keep
        void onAdShow();

        @KsAdSdkApi
        @Keep
        void onPageDismiss();

        @KsAdSdkApi
        @Keep
        void onSkippedAd();

        @KsAdSdkApi
        @Keep
        void onVideoPlayEnd();

        @KsAdSdkApi
        @Keep
        void onVideoPlayError(int i2, int i3);

        @KsAdSdkApi
        @Keep
        void onVideoPlayStart();
    }

    @KsAdSdkApi
    @Keep
    int getECPM();

    @Keep
    int getInteractionType();

    @Keep
    int getMaterialType();

    @KsAdSdkApi
    @Keep
    @Deprecated
    boolean isVideo();

    @KsAdSdkApi
    @Keep
    void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    @Keep
    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @Keep
    @Deprecated
    void setBidEcpm(int i2);

    @KsAdSdkApi
    @Keep
    void setBidEcpm(long j2, long j3);

    @KsAdSdkApi
    @Keep
    void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig);
}
