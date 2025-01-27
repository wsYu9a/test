package com.kwad.sdk.service;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenLandScapeVideoActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardLandScapeVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.internal.api.VideoPlayConfigImpl;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.d;
import com.kwad.framework.filedownloader.services.FileDownloadServiceProxy;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class b {
    private static final Map<Class<?>, Class<?>> aSk = new HashMap();
    private static final Map<Class<?>, Class<?>> aSl = new HashMap();
    private static boolean aSm = false;
    private static boolean aSn = false;

    private static synchronized void Mv() {
        synchronized (b.class) {
            if (aSm) {
                return;
            }
            Mw();
            aSm = true;
        }
    }

    @ForInvoker(methodId = "initComponentProxyForInvoker")
    private static void Mw() {
        FeedDownloadActivityProxy.register();
        KsFullScreenLandScapeVideoActivityProxy.register();
        KsFullScreenVideoActivityProxy.register();
        KSRewardLandScapeVideoActivityProxy.register();
        KSRewardVideoActivityProxy.register();
        com.kwad.components.core.page.a.register();
        AdWebViewActivityProxy.register();
        AdWebViewVideoActivityProxy.register();
        d.register();
        com.kwad.components.core.r.a.a.register();
        FileDownloadServiceProxy.register();
        com.kwad.sdk.collector.b.a.register();
        a.register();
    }

    private static synchronized void Mx() {
        synchronized (b.class) {
            if (aSn) {
                return;
            }
            My();
            aSn = true;
        }
    }

    @ForInvoker(methodId = "initModeImplForInvoker")
    private static void My() {
        KSAdVideoPlayConfigImpl.register();
        com.kwad.components.core.internal.api.d.register();
        VideoPlayConfigImpl.register();
        com.kwad.components.core.p.b.register();
        SceneImpl.register();
    }

    public static void a(Class<?> cls, Class<?> cls2) {
        aSk.put(cls, cls2);
    }

    public static void b(Class cls, Class cls2) {
        aSl.put(cls, cls2);
    }

    public static Class<?> g(Class<?> cls) {
        Mv();
        return aSk.get(cls);
    }

    public static Class<?> h(Class<?> cls) {
        Mx();
        return aSl.get(cls);
    }

    public static void init() {
        Mv();
        Mx();
    }
}
