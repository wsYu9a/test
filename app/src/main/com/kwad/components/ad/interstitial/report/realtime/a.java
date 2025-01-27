package com.kwad.components.ad.interstitial.report.realtime;

import com.kwad.components.ad.interstitial.report.realtime.model.InterstitialRealTimeInfo;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.b;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.interstitial.report.realtime.a$a */
    public static class C0385a {
        private static final a mI = new a((byte) 0);
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public static void A(AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setRenderType(e.eb(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType);
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            b.d(c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N("ad_sdk_interstitial_data_check_monitor", "monitor_index").a(BusinessType.AD_INTERSTITIAL).u(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void B(AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            b.d(c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N("ad_sdk_interstitial_service_call_monitor", "monitor_index").a(BusinessType.AD_INTERSTITIAL).u(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(com.kwad.sdk.core.network.e eVar) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setErrorCode(eVar.errorCode);
            b.d(c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N("ad_sdk_interstitial_data_result_monitor", "error_code").a(BusinessType.AD_INTERSTITIAL).u(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void b(String str, AdTemplate adTemplate) {
        try {
            AdInfo eb2 = e.eb(adTemplate);
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            interstitialRealTimeInfo.setErrorMsg(str);
            interstitialRealTimeInfo.setMaterialUrl(com.kwad.sdk.core.response.b.a.K(eb2));
            b.d(c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N("ad_sdk_interstitial_resource_monitor", "monitor_index").a(BusinessType.AD_INTERSTITIAL).u(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static a eq() {
        return C0385a.mI;
    }

    private a() {
    }

    public static void a(String str, AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            interstitialRealTimeInfo.setErrorMsg(str);
            b.d(c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N("ad_sdk_interstitial_render_result_monitor", "monitor_index").a(BusinessType.AD_INTERSTITIAL).u(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
