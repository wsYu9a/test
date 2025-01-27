package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.feed.monitor.FeedErrorInfo;
import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import com.kwad.components.ad.feed.monitor.FeedWebViewInfo;

/* loaded from: classes3.dex */
public final class cn {
    @InvokeBy(invokerClass = gc.class, methodId = "registerHolder")
    public static void Fe() {
        gc.Ff().put(FeedPageInfo.a.class, new gq());
        gc.Ff().put(FeedErrorInfo.class, new dz());
        gc.Ff().put(FeedPageInfo.class, new ec());
        gc.Ff().put(FeedWebViewInfo.class, new ee());
    }
}
