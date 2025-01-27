package com.kwad.sdk.commercial.f;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        a(adTemplate, false, aVar);
    }

    public static void d(AdTemplate adTemplate, String str, String str2) {
        try {
            a(adTemplate, true, b.Cm().ck(6).cM(str).setErrorCode(100007).setErrorMsg(str2));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void f(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.Cm().ck(1).cM(str));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void g(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.Cm().ck(2).cM(str));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void h(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.Cm().ck(3).cM(str));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void i(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.Cm().ck(4).cM(str));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void j(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.Cm().ck(5).cM(str));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(z10 ? 0.1d : 0.01d).a(d.aZ(adTemplate)).N("ad_sdk_deeplink_performance", "status").u(aVar));
    }
}
