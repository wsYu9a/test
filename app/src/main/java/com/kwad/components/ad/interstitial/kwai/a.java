package com.kwad.components.ad.interstitial.kwai;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.k;

/* loaded from: classes.dex */
public final class a {
    public static k iZ = new k("interstitialAdSkipCloseType", 0);
    public static k ja = new k("interstitialAdSkipCloseArea", 0);
    public static k jb = new k("interstitialAdFullClick", 1);
    public static k jc = new k("interstitialAdBackPressSwitch", 0);
    public static k jd = new k("interstitialPlayableTime", 999);
    public static k je = new k("interstitialAdClickShutDown", 0);
    public static d jf = new d("interstitialAutoStartSwitch", false);
    public static k jg = new k("ecInterstitialAdOrderSwitch", 0);
    public static k jh = new k("interstitialCycleAggregateMaxCount", 3);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
