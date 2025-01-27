package com.kwad.components.ad.splashscreen.b;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.r;

/* loaded from: classes2.dex */
public final class a {
    public static k Ep = new k("splashTimeOutMilliSecond", 5000);
    public static r Eq = new r("splashTimerTips", "");
    public static r Er = new r("splashBtnText", "点击跳转详情页或第三方应用");
    public static d Es = new d("splashCropNewSwitch", true);
    public static d Et = new d("splashAdLoadProcessChange", false);
    public static k Eu = new k("splashMaterialDownloadTimeMs", 500);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
