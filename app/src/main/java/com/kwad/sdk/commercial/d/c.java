package com.kwad.sdk.commercial.d;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class c {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.001d).a(com.kwad.sdk.commercial.d.aZ(adTemplate)).N("ad_convert_method_call", "method_name").u(aVar));
    }

    public static void bF(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("callShow"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bG(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("adShowSuccess"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
