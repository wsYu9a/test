package com.kwad.sdk.commercial.g;

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

    public static void j(AdTemplate adTemplate, int i10, String str) {
        try {
            a(adTemplate, b.Cn().cl(1).cN(str).cm(i10));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void k(AdTemplate adTemplate, int i10, String str) {
        try {
            a(adTemplate, b.Cn().cl(2).cN(str).cm(i10));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void l(AdTemplate adTemplate, int i10, String str) {
        try {
            a(adTemplate, b.Cn().cl(4).cN(str).cm(i10));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void m(AdTemplate adTemplate, int i10, String str) {
        try {
            a(adTemplate, b.Cn().cl(5).cN(str).cm(i10));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(z10 ? 0.1d : 0.01d).a(d.aZ(adTemplate)).N("ad_sdk_landing_page_performance", "status").u(aVar));
    }

    public static void a(AdTemplate adTemplate, int i10, String str, String str2) {
        try {
            a(adTemplate, true, b.Cn().cl(3).cN(str).cm(i10).setErrorCode(100009).setErrorMsg(str2));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(AdTemplate adTemplate, int i10, String str, int i11, String str2) {
        try {
            a(adTemplate, true, b.Cn().cl(6).cN(str).cm(i10).setErrorCode(i11).setErrorMsg(str2));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
