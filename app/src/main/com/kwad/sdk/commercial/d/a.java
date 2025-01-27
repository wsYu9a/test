package com.kwad.sdk.commercial.d;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.001d).a(com.kwad.sdk.commercial.d.aZ(adTemplate)).N("ad_convert_method_call", "method_name").u(aVar));
    }

    public static void bA(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toOpenAppDialog"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bB(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toOpenDeeplinkDialog"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bC(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toH5PageDialog"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bD(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toMiddlePageDialog"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bE(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toSmallAppDialog"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bj(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("adClick"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bk(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("startH5Page"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bl(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("dplinkStart"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bm(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("smallAppSuccess"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bn(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("appstoreStart"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bo(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("disableClick"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bp(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toVideoH5Web"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bq(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toDownload"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void br(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toOpenApp"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bs(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toInstallApp"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bt(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toDownloadDialog"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bu(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toDownloadThirdDialog"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bv(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toDownloadPage"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bw(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toDownloadPause"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bx(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toDownloadResume"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void by(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toDownloadNoNet"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bz(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Cj().cF("toDoNoting"));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void f(AdTemplate adTemplate, boolean z10) {
        try {
            a(adTemplate, b.Cj().cF("adUserClick").bl(z10));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
