package com.kwad.components.ad.interstitial.report;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: classes2.dex */
public final class d {

    public static class a {
        private static final d mH = new d();
    }

    private static void a(boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(z10 ? 1.0d : 0.01d).N("ad_sdk_interstitial_play", "status").a(BusinessType.AD_INTERSTITIAL).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static d eo() {
        return a.mH;
    }

    public final void b(@NonNull AdTemplate adTemplate, int i10, String str) {
        AdInfo eb2 = e.eb(adTemplate);
        a(true, new InterstitialReportInfo(adTemplate).setCreativeId(com.kwad.sdk.core.response.b.a.J(eb2)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(eb2)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(eb2) * 1000).setStatus(2).setErrorMsg(str).setErrorCode(i10).setAdTemplate(adTemplate));
    }

    public final void z(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(1).setAdTemplate(adTemplate));
    }

    public final void a(@NonNull AdTemplate adTemplate, long j10) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(3).setCreativeId(e.el(adTemplate)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(e.eb(adTemplate))).setVideoDuration(com.kwad.sdk.core.response.b.a.L(r0) * 1000).setPlayStartedDuration(j10).setAdTemplate(adTemplate));
    }
}
