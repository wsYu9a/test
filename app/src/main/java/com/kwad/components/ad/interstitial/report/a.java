package com.kwad.components.ad.interstitial.report;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.interstitial.report.a$a */
    public static class C0384a {
        private static final a mE = new a();
    }

    private static void a(String str, com.kwad.sdk.commercial.c.a aVar) {
        if (l.At().zE()) {
            try {
                com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_interstitial_callback", str).a(BusinessType.AD_INTERSTITIAL).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    public static a ei() {
        return C0384a.mE;
    }

    public final void b(AdTemplate adTemplate, long j10, long j11) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(2L).setClickSceneType(j10).setItemClickType(j11).setAdTemplate(adTemplate));
    }

    public final void q(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(1L).setAdTemplate(adTemplate));
    }

    public final void r(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(3L).setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, long j10, long j11) {
        a("action_type", new InterstitialReportInfo().setActionType(1L).setClickSceneType(j10).setItemClickType(j11).setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, double d10) {
        a("action_type", new InterstitialReportInfo().setActionType(2L).setVisiblePercent(d10).setAdTemplate(adTemplate));
    }
}
