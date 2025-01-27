package com.kwad.components.ad.splashscreen.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.p;

/* loaded from: classes2.dex */
public final class a {
    public static k BP = new k("splashTimeOutMilliSecond", 5000);
    public static p BQ = new p("splashTimerTips", "");
    public static p BR = new p("splashBtnText", "点击跳过详情页或第三方应用");
    public static d BS = new d("splashCropNewSwitch", true);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
