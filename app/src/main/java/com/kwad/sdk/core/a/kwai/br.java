package com.kwad.sdk.core.a.kwai;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import com.kwad.components.ad.feed.monitor.FeedWebViewInfo;

/* loaded from: classes2.dex */
public final class br {
    @InvokeBy(invokerClass = ev.class, methodId = "registerHolder")
    public static void vO() {
        ev.vP().put(FeedPageInfo.class, new dc());
        ev.vP().put(FeedWebViewInfo.class, new de());
    }
}
