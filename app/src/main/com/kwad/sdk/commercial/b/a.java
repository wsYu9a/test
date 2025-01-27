package com.kwad.sdk.commercial.b;

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

    public static void b(AdTemplate adTemplate, String str, String str2, int i10, int i11) {
        try {
            a(adTemplate, b.Ci().cg(2).cD(str).cE(str2).ci(i10).ch(i11));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(z10 ? 0.1d : 0.01d).a(d.aZ(adTemplate)).N("ad_sdk_appstore_performance", "status").u(aVar));
    }

    public static void a(AdTemplate adTemplate, String str, int i10, int i11) {
        try {
            a(adTemplate, "", str, i10, i11, "marketUrl is empty");
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, int i10, int i11) {
        try {
            a(adTemplate, b.Ci().cg(1).cD(str).cE(str2).ci(i10).ch(i11));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, int i10, int i11, String str3) {
        try {
            a(adTemplate, true, b.Ci().cg(4).cD(str).cE(str2).ci(i10).ch(i11).setErrorCode(100006).setErrorMsg(str3));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
