package com.kwad.sdk.api;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;

@KsAdSdkApi
@Keep
/* loaded from: classes3.dex */
public interface KsDrawAd extends BaseKSAd {

    @KsAdSdkApi
    @Keep
    public interface AdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked();

        @KsAdSdkApi
        @Keep
        void onAdShow();

        @KsAdSdkApi
        @Keep
        void onVideoPlayEnd();

        @KsAdSdkApi
        @Keep
        void onVideoPlayError();

        @KsAdSdkApi
        @Keep
        void onVideoPlayPause();

        @KsAdSdkApi
        @Keep
        void onVideoPlayResume();

        @KsAdSdkApi
        @Keep
        void onVideoPlayStart();
    }

    @Nullable
    @KsAdSdkApi
    @Keep
    View getDrawView(Context context);

    @KsAdSdkApi
    @Keep
    int getECPM();

    @KsAdSdkApi
    @Keep
    int getInteractionType();

    @KsAdSdkApi
    @Keep
    int getMaterialType();

    @KsAdSdkApi
    @Keep
    void reportAdExposureFailed(int i10, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    @Keep
    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @Keep
    @Deprecated
    void setBidEcpm(int i10);

    @KsAdSdkApi
    @Keep
    void setBidEcpm(long j10, long j11);

    @KsAdSdkApi
    @Keep
    void setVideoSoundEnable(boolean z10);
}
