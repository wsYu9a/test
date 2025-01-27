package com.kwad.components.ad.fullscreen.kwai;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.config.item.k;

/* loaded from: classes.dex */
public final class a {
    public static k gm = new k("fullscreenSkipType", 0);
    public static k gn = new k("fullscreenSkipShowTime", 5);
    public static k go = new k("fullScreenShakeMaxCount", 0);

    @InvokeBy(invokerClass = d.class, methodId = "initConfigList")
    public static void init() {
    }
}
