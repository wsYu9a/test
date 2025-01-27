package com.kwad.sdk.commercial.j;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.x;
import java.util.List;

/* loaded from: classes3.dex */
public final class a {
    private static C0482a ask;

    /* renamed from: com.kwad.sdk.commercial.j.a$1 */
    public class AnonymousClass1 implements c<C0482a> {
        private static C0482a Cs() {
            return new C0482a();
        }

        @Override // com.kwad.sdk.core.c
        public final /* synthetic */ C0482a Ct() {
            return Cs();
        }
    }

    @KsJson
    /* renamed from: com.kwad.sdk.commercial.j.a$a */
    public static class C0482a extends com.kwad.sdk.core.response.a.a {
        public List<String> asl;
    }

    private static C0482a Cr() {
        String Ai = ((h) ServiceProvider.get(h.class)).Ai();
        if (!TextUtils.isEmpty(Ai)) {
            ask = (C0482a) x.b(Ai, new c<C0482a>() { // from class: com.kwad.sdk.commercial.j.a.1
                private static C0482a Cs() {
                    return new C0482a();
                }

                @Override // com.kwad.sdk.core.c
                public final /* synthetic */ C0482a Ct() {
                    return Cs();
                }
            });
        }
        return ask;
    }

    private static void a(AdTemplate adTemplate, b bVar) {
        a(adTemplate, false, bVar);
    }

    private static boolean cW(String str) {
        C0482a Cr;
        List<String> list;
        if (TextUtils.isEmpty(str) || (Cr = Cr()) == null || (list = Cr.asl) == null) {
            return false;
        }
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void n(AdTemplate adTemplate, int i10, String str) {
        try {
            a(adTemplate, b.Cu().co(4).cp(i10).cX(str).setAdTemplate(adTemplate));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void o(AdTemplate adTemplate, int i10, String str) {
        try {
            a(adTemplate, b.Cu().co(1).cp(i10).cX(str).setAdTemplate(adTemplate));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z10, b bVar) {
        if (cW(bVar.ase)) {
            return;
        }
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(z10 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z10 ? 1.0d : 0.001d).a(d.aZ(adTemplate)).N("ad_sdk_track_performance", "status").u(bVar));
    }

    public static void a(AdTemplate adTemplate, String str, String str2, String str3, String str4) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(1.0d).a(d.aZ(adTemplate)).N("ad_sdk_macro_check_performance", "error_name").u(com.kwad.sdk.commercial.i.a.Cq().cP(str).cR(str2).cS(str3).cQ(str4).setAdTemplate(adTemplate)));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(AdTemplate adTemplate, int i10, String str, int i11, int i12) {
        try {
            a(adTemplate, b.Cu().co(2).cp(i10).cX(str).cq(i12).setErrorCode(i11).setAdTemplate(adTemplate));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(AdTemplate adTemplate, int i10, String str, String str2, int i11, String str3, int i12) {
        try {
            a(adTemplate, true, b.Cu().co(3).cp(i10).cX(str).cY(str2).setErrorCode(i11).setErrorMsg(str3).cq(i12).setAdTemplate(adTemplate));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
