package com.kwad.components.ad.interstitial.b;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.k;

/* loaded from: classes2.dex */
public final class a {
    public static k kB = new k("interstitialAdSkipCloseType", 0);
    public static k kC = new k("interstitialAdSkipCloseArea", 0);
    public static k kD = new k("interstitialAdFullClick", 1);
    public static k kE = new k("interstitialAdBackPressSwitch", 0);
    public static k kF = new k("interstitialPlayableTime", 999);
    public static k kG = new k("interstitialAdClickShutDown", 0);
    public static d kH = new d("interstitialAutoStartSwitch", false);
    public static k kI = new k("ecInterstitialAdOrderSwitch", 0);
    public static k kJ = new k("interstitialCycleAggregateMaxCount", 3);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
