package com.kwad.components.ad.splashscreen.monitor;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.splashscreen.monitor.a$a */
    public static class C0405a {
        private static final a Ev = new a();
    }

    private static SplashMonitorInfo Y(@NonNull AdTemplate adTemplate) {
        AdInfo eb2 = e.eb(adTemplate);
        return new SplashMonitorInfo().setPreloadId(com.kwad.sdk.core.response.b.a.aZ(eb2)).setCreativeId(com.kwad.sdk.core.response.b.a.J(eb2)).setMaterialType(com.kwad.sdk.core.response.b.a.bc(eb2) ? 1 : 2).setAdTemplate(adTemplate);
    }

    private static void c(com.kwad.sdk.commercial.c.a aVar) {
        if (l.At().zE()) {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_splash_callback", "callback_type").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        }
    }

    private static void d(com.kwad.sdk.commercial.c.a aVar) {
        if (l.At().zE()) {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_splash_action", "action_type").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        }
    }

    public static a lk() {
        return C0405a.Ev;
    }

    public final void Z(@NonNull AdTemplate adTemplate) {
        c(Y(adTemplate).setCallbackType(2));
    }

    public final void aa(@NonNull AdTemplate adTemplate) {
        c(Y(adTemplate).setCallbackType(5));
    }

    public final void ab(@NonNull AdTemplate adTemplate) {
        d(Y(adTemplate).setActionType(1));
    }

    public final void ac(@NonNull AdTemplate adTemplate) {
        d(Y(adTemplate).setActionType(2));
    }

    public final void o(long j10) {
        c(new SplashMonitorInfo().setCallbackType(4).setPosId(j10));
    }

    public final void q(@NonNull AdTemplate adTemplate) {
        c(Y(adTemplate).setCallbackType(1));
    }

    public final void r(@NonNull AdTemplate adTemplate) {
        c(Y(adTemplate).setCallbackType(3));
    }
}
