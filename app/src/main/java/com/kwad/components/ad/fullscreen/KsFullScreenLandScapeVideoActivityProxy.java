package com.kwad.components.ad.fullscreen;

import androidx.annotation.Keep;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;

@KsAdSdkDynamicImpl(KsFullScreenLandScapeVideoActivity.class)
@Keep
/* loaded from: classes.dex */
public class KsFullScreenLandScapeVideoActivityProxy extends KsFullScreenVideoActivityProxy {
    @InvokeBy(invokerClass = com.kwad.sdk.service.a.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.a.a(KsFullScreenLandScapeVideoActivity.class, KsFullScreenLandScapeVideoActivityProxy.class);
    }
}
