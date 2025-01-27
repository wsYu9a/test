package com.wbl.ad.yzz.config;

import com.baidu.mobads.sdk.api.NativeResponse;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;

/* loaded from: classes5.dex */
public interface IConfigAdFilter {
    boolean needFilterAd(NativeResponse nativeResponse, String str);

    boolean needFilterAd(TTNativeAd tTNativeAd, String str);

    boolean needFilterAd(KsNativeAd ksNativeAd, String str);

    boolean needFilterAd(NativeUnifiedADData nativeUnifiedADData, String str);
}
