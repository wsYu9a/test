package com.kwad.components.ad.fullscreen.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.config.item.k;

/* loaded from: classes2.dex */
public final class a {
    public static k hU = new k("fullscreenSkipType", 0);
    public static k hV = new k("fullscreenSkipShowTime", 5);
    public static k hW = new k("fullScreenShakeMaxCount", 0);

    @InvokeBy(invokerClass = d.class, methodId = "initConfigList")
    public static void init() {
    }
}
