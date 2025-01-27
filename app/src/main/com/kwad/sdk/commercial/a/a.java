package com.kwad.sdk.commercial.a;

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

    public static void bb(AdTemplate adTemplate) {
        a(adTemplate, b.Ch().cd(3).setAdTemplate(adTemplate));
    }

    public static void bc(AdTemplate adTemplate) {
        a(adTemplate, b.Ch().cd(4).setAdTemplate(adTemplate));
    }

    public static void bd(AdTemplate adTemplate) {
        a(adTemplate, b.Ch().cd(5).setAdTemplate(adTemplate));
    }

    public static void be(AdTemplate adTemplate) {
        h(adTemplate, 100002, "");
    }

    public static void bf(AdTemplate adTemplate) {
        a(adTemplate, b.Ch().cd(7).ce(adTemplate.mInstallApkFormUser ? 1 : 2).setAdTemplate(adTemplate));
    }

    public static void bg(AdTemplate adTemplate) {
        int i10 = 2;
        b ce2 = b.Ch().cd(8).ce(adTemplate.mInstallApkFormUser ? 1 : 2);
        if (adTemplate.mInstallApkFromSDK) {
            i10 = 1;
        } else if (!adTemplate.mClickOpenAppStore) {
            i10 = 0;
        }
        a(adTemplate, ce2.cf(i10).setAdTemplate(adTemplate));
    }

    public static void bh(AdTemplate adTemplate) {
        a(adTemplate, b.Ch().cd(10).cf(adTemplate.mInstallApkFromSDK ? 1 : adTemplate.mClickOpenAppStore ? 2 : 0).setAdTemplate(adTemplate));
    }

    public static void h(AdTemplate adTemplate, int i10, String str) {
        a(adTemplate, true, b.Ch().cd(6).setAdTemplate(adTemplate).setErrorCode(i10).setErrorMsg(str));
    }

    public static void i(AdTemplate adTemplate, int i10, String str) {
        a(adTemplate, true, b.Ch().cd(9).ce(adTemplate.mInstallApkFormUser ? 1 : 2).setAdTemplate(adTemplate).setErrorCode(100003).setErrorMsg(str));
    }

    public static void j(AdTemplate adTemplate, long j10) {
        a(adTemplate, b.Ch().cd(2).al(j10).setAdTemplate(adTemplate));
    }

    public static void s(AdTemplate adTemplate) {
        a(adTemplate, b.Ch().cd(1).setAdTemplate(adTemplate));
    }

    private static void a(AdTemplate adTemplate, boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.b.d(c.Cg().cB(z10 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z10 ? 1.0d : 0.1d).a(d.aZ(adTemplate)).N("ad_sdk_download_performance", "status").u(aVar));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
