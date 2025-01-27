package com.sn.catpie.service;

import androidx.annotation.Keep;
import com.sntech.ads.api.event.SNEvent;

@Keep
/* loaded from: classes4.dex */
public interface MediationService {
    @Keep
    double getAdEcpm(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, double d10);

    @Keep
    String getBannerPlacementId(int i10);

    @Keep
    String getBannerPlacementId(int i10, String str);

    @Keep
    String getInterstitialPlacementId(int i10);

    @Keep
    String getInterstitialPlacementId(int i10, String str);

    @Keep
    String getNativePlacementId(int i10);

    @Keep
    String getNativePlacementId(int i10, String str);

    @Keep
    String getRewardVideoPlacementId(int i10);

    @Keep
    String getRewardVideoPlacementId(int i10, String str);

    @Keep
    String getSplashPlacementId(int i10);

    @Keep
    String getSplashPlacementId(int i10, String str);

    @Keep
    boolean isAdTypeAvailable(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType);

    @Keep
    void onTopOnAdShow(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, String str2, double d10);
}
