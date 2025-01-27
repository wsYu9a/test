package com.kwad.components.ad.splashscreen;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class d {
    public static int DL;
    private String DM;
    private int DN = 2;

    private void V(String str) {
        this.DM = str;
    }

    private void W(int i10) {
        this.DN = i10;
    }

    public static d a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar, int i10) {
        d dVar = new d();
        DL = i10;
        if (adInfo != null && cVar != null) {
            if (i10 == 1 || i10 == 4) {
                dVar.V(a(adTemplate, adInfo, cVar));
            } else if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
                dVar.V("或点击" + a(adTemplate, adInfo, cVar.oK(), 0));
            } else {
                String a10 = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.Er);
                if (TextUtils.isEmpty(a10)) {
                    a10 = "点击跳转详情页或第三方应用";
                }
                dVar.V("或" + a10);
            }
        }
        dVar.W(com.kwad.sdk.core.response.b.b.dJ(adInfo));
        return dVar;
    }

    public final String kM() {
        return this.DM;
    }

    public final int kN() {
        return this.DN;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i10, int i11) {
        String aE = com.kwad.sdk.core.response.b.a.aE(adInfo);
        if (i10 == 2) {
            return i11 + "%";
        }
        if (i10 == 4) {
            return "继续下载";
        }
        if (i10 != 8) {
            return i10 != 12 ? aE : com.kwad.sdk.core.response.b.a.ac(adInfo);
        }
        return com.kwad.sdk.core.response.b.a.cg(adTemplate);
    }

    private static String a(AdInfo adInfo, int i10) {
        if (i10 == 1) {
            if (com.kwad.sdk.core.response.b.b.dD(adInfo) == null) {
                return "";
            }
            return com.kwad.sdk.core.response.b.b.dD(adInfo);
        }
        if (i10 != 4 || com.kwad.sdk.core.response.b.b.dE(adInfo) == null) {
            return "";
        }
        return com.kwad.sdk.core.response.b.b.dE(adInfo);
    }

    private static String a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar) {
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            return a(adTemplate, adInfo, cVar.oK(), 0);
        }
        String a10 = a(adInfo, DL);
        return TextUtils.isEmpty(a10) ? "点击跳转详情页或第三方应用" : a10;
    }
}
