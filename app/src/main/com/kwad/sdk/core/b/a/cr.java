package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.ad.splashscreen.monitor.SplashWebMonitorInfo;

/* loaded from: classes3.dex */
public final class cr {
    @InvokeBy(invokerClass = gc.class, methodId = "registerHolder")
    public static void Fe() {
        gc.Ff().put(SplashMonitorInfo.class, new js());
        gc.Ff().put(com.kwad.components.ad.splashscreen.local.a.class, new jr());
        gc.Ff().put(SplashPreloadManager.PreLoadItem.class, new ih());
        gc.Ff().put(SplashWebMonitorInfo.class, new jz());
        gc.Ff().put(SplashSkipViewModel.class, new jw());
    }
}
