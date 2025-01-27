package com.kwad.components.core.n.c;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class c {
    private static void a(d dVar, boolean z10) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(z10 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z10 ? 1.0d : 0.01d).N("ad_sdk_offline_component_update", "load_status").u(dVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
    }

    public static void b(String str, long j10, int i10, String str2, String str3) {
        try {
            a(new d().ar(str).D(j10).setErrorCode(i10).at(str2).as(str3).C(2L), true);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void d(String str, long j10, String str2) {
        try {
            a(new d().ar(str).at(str2).D(j10).C(1L), false);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(String str, long j10, long j11, String str2) {
        try {
            a(new d().ar(str).D(j10).E(j11).at(str2).C(3L), false);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
