package com.kwad.sdk.core.adlog.b;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class a {
    private static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, b bVar) {
        a(aVar, cVar, false, bVar);
    }

    public static void b(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i10) {
        try {
            a(aVar, cVar, b.CN().ct(2).cy(i10));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void c(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i10) {
        try {
            a(aVar, cVar, true, b.CN().ct(3).cy(i10));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void d(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i10) {
        try {
            a(aVar, cVar, b.CN().ct(4).cy(i10));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void e(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i10) {
        try {
            a(aVar, cVar, true, b.CN().ct(7).cy(i10));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, boolean z10, b bVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = aVar.asS;
        AdTemplate adTemplate = aVar2.adTemplate;
        bVar.cu(aVar2.asm).cv(aVar.retryCount).cw(aVar.asU).dk(aVar.asV).cx(cVar.atd).setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(z10 ? 1.0d : 0.1d).a(com.kwad.sdk.commercial.d.aZ(adTemplate)).N("ad_sdk_adlog_retry", "status").u(bVar));
    }

    public static void b(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i10, long j10) {
        try {
            a(aVar, cVar, true, b.CN().ct(6).cy(i10).an(j10));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i10) {
        try {
            a(aVar, cVar, b.CN().ct(1).cy(i10));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i10, long j10) {
        try {
            a(aVar, cVar, b.CN().ct(5).cy(i10).an(j10));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
