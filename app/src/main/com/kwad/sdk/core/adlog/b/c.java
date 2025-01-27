package com.kwad.sdk.core.adlog.b;

import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class c {
    private static void a(AdTemplate adTemplate, @Nullable com.kwad.sdk.core.adlog.a.a aVar, d dVar) {
        a(adTemplate, aVar, false, dVar);
    }

    public static void b(AdTemplate adTemplate, int i10, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, d.CO().cz(2).cA(i10).setAdTemplate(adTemplate));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void c(AdTemplate adTemplate, int i10, String str, int i11, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, true, d.CO().cz(4).cA(i10).dl(str).setErrorCode(i11).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void d(AdTemplate adTemplate, int i10, String str, int i11, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, true, d.CO().cz(3).cA(i10).dl(str).setErrorCode(i11).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static void a(AdTemplate adTemplate, @Nullable com.kwad.sdk.core.adlog.a.a aVar, boolean z10, d dVar) {
        if (aVar != null) {
            dVar.cB(1).cC(aVar.retryCount);
        }
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(z10 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z10 ? 0.01d : 1.0E-4d).j(z10 ? 1.0d : 0.01d).a(com.kwad.sdk.commercial.d.aZ(adTemplate)).N("ad_sdk_adlog_performance", "status").u(dVar));
    }

    public static void b(AdTemplate adTemplate, int i10, String str, int i11, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, true, d.CO().cz(5).cA(i10).dl(str).setErrorCode(i11).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(AdTemplate adTemplate, int i10, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, d.CO().cz(1).cA(i10).setAdTemplate(adTemplate));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(AdTemplate adTemplate, int i10, String str, int i11, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, d.CO().cz(5).cA(i10).dl(str).setErrorCode(100004).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
