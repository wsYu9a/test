package com.kwad.sdk.commercial.d;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class d {
    private static void a(SceneImpl sceneImpl, com.kwad.sdk.commercial.c.a aVar) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.001d).a(com.kwad.sdk.commercial.d.cb(sceneImpl.getAdStyle())).N("ad_convert_method_call", "method_name").u(aVar));
    }

    public static void b(SceneImpl sceneImpl) {
        try {
            a(sceneImpl, b.Cj().cF("loadRequest").cj(sceneImpl.getAdNum()).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void b(SceneImpl sceneImpl, String str) {
        try {
            a(sceneImpl, b.Cj().cF("requestStart").cj(sceneImpl.getAdNum()).cG(str).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(SceneImpl sceneImpl, String str, String str2) {
        try {
            a(sceneImpl, b.Cj().cF("requestFinish").cj(sceneImpl.getAdNum()).cG(str).cH(str2).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(SceneImpl sceneImpl, int i10) {
        try {
            a(sceneImpl, b.Cj().cF("dataReady").cj(i10));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(int i10, int i11, String str, String str2) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(1.0d).a(com.kwad.sdk.commercial.d.cb(i10)).N("ad_convert_method_call", "method_name").u(b.Cj().cF("requestError").cG(str2).setErrorCode(com.kwad.sdk.commercial.d.cc(i11)).setErrorMsg(str)));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
