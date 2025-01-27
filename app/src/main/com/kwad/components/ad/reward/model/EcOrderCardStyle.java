package com.kwad.components.ad.reward.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;

/* loaded from: classes2.dex */
public enum EcOrderCardStyle {
    SPIKE_AND_COUPON(1),
    SPIKE(2),
    COUPON(3),
    NO_SPIKE_AND_NO_COUPON(4),
    DEFAULT(5);

    private int value;

    EcOrderCardStyle(int i10) {
        this.value = i10;
    }

    @Nullable
    public static EcOrderCardStyle createFromAdInfo(AdInfo adInfo) {
        if (!com.kwad.components.ad.reward.a.b.k(adInfo) && !com.kwad.components.ad.reward.a.b.j(adInfo)) {
            return null;
        }
        AdProductInfo cW = com.kwad.sdk.core.response.b.a.cW(adInfo);
        boolean hasSpike = cW.hasSpike();
        boolean hasCoupon = cW.hasCoupon();
        return (hasSpike && hasCoupon) ? SPIKE_AND_COUPON : hasSpike ? SPIKE : hasCoupon ? COUPON : cW.hasOriginalPrice() ? NO_SPIKE_AND_NO_COUPON : DEFAULT;
    }

    public final int getValue() {
        return this.value;
    }
}
