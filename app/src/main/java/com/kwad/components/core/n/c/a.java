package com.kwad.components.core.n.c;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class a {
    private static void a(b bVar) {
        a(bVar, false);
    }

    public static void b(String str, long j10, int i10) {
        try {
            a(new b().ao(str).B(j10).ax(i10).A(2L));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void c(String str, long j10) {
        try {
            a(new b().ao(str).B(j10).A(1L));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void d(String str, long j10) {
        try {
            a(new b().ao(str).B(j10).A(6L));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static void a(b bVar, boolean z10) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(z10 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z10 ? 1.0d : 0.01d).N("ad_sdk_offline_component_monitor", "load_status").u(bVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
    }

    public static void c(String str, long j10, String str2) {
        try {
            a(new b().ao(str).B(j10).aq(str2).A(4L));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void b(String str, long j10, String str2) {
        try {
            a(new b().ao(str).B(j10).aq(str2).A(3L));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(String str, long j10, int i10, String str2, String str3) {
        try {
            a(new b().ao(str).B(j10).setErrorCode(i10).aq(str3).ap(str2).A(7L), true);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void c(String str, long j10, int i10) {
        try {
            a(new b().ao(str).A(8L).ax(i10).B(j10));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(String str, long j10, String str2) {
        try {
            a(new b().ao(str).aq(str2).B(j10).A(5L));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
