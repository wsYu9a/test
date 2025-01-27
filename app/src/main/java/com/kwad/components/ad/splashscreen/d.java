package com.kwad.components.ad.splashscreen;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class d {
    public static int BC;
    private String BD;
    private int BE = 2;
    private String title;

    private void Z(int i2) {
        this.BE = i2;
    }

    private void Z(String str) {
        this.BD = str;
    }

    public static d a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.d.b.c cVar, int i2) {
        String str;
        d dVar = new d();
        BC = i2;
        if (adInfo != null && cVar != null) {
            if (i2 == 1) {
                dVar.setTitle(com.kwad.sdk.core.response.a.b.cN(adInfo));
            } else if (i2 != 4) {
                if (com.kwad.sdk.core.response.a.a.ax(adInfo)) {
                    str = "或点击" + a(adTemplate, adInfo, cVar.nb());
                } else {
                    String a2 = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.a.a.BR);
                    if (TextUtils.isEmpty(a2)) {
                        a2 = "点击跳转详情页或第三方应用";
                    }
                    str = "或" + a2;
                }
                dVar.Z(str);
            }
            str = a(adInfo, cVar);
            dVar.Z(str);
        }
        dVar.Z(com.kwad.sdk.core.response.a.b.cW(adInfo));
        return dVar;
    }

    public static String a(AdInfo adInfo, int i2) {
        AdMatrixInfo.DownloadTexts b2 = b(adInfo, BC);
        return i2 != 8 ? i2 != 12 ? b2.adActionDescription : b2.openAppLabel : b2.installAppLabel;
    }

    private static String a(AdInfo adInfo, com.kwad.components.core.d.b.c cVar) {
        if (!com.kwad.sdk.core.response.a.a.ax(adInfo)) {
            String d2 = d(adInfo, BC);
            return TextUtils.isEmpty(d2) ? "点击跳转详情页或第三方应用" : d2;
        }
        int nb = cVar.nb();
        AdMatrixInfo.DownloadTexts b2 = b(adInfo, BC);
        return nb != 8 ? nb != 12 ? b2.adActionDescription : b2.openAppLabel : b2.installAppLabel;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i2) {
        return i2 != 8 ? i2 != 12 ? com.kwad.sdk.core.response.a.a.aw(adInfo) : com.kwad.sdk.core.response.a.a.T(adInfo) : com.kwad.sdk.core.response.a.a.aH(adTemplate);
    }

    private static AdMatrixInfo.DownloadTexts b(AdInfo adInfo, int i2) {
        if (i2 == 1) {
            return com.kwad.sdk.core.response.a.b.cL(adInfo) != null ? com.kwad.sdk.core.response.a.b.cL(adInfo) : new AdMatrixInfo.DownloadTexts();
        }
        if (i2 == 4 && com.kwad.sdk.core.response.a.b.cQ(adInfo) != null) {
            return com.kwad.sdk.core.response.a.b.cQ(adInfo);
        }
        return new AdMatrixInfo.DownloadTexts();
    }

    public static String c(AdInfo adInfo, int i2) {
        AdMatrixInfo.DownloadTexts cM = com.kwad.sdk.core.response.a.b.cM(adInfo) != null ? com.kwad.sdk.core.response.a.b.cM(adInfo) : new AdMatrixInfo.DownloadTexts();
        return i2 != 8 ? i2 != 12 ? cM.adActionDescription : cM.openAppLabel : cM.installAppLabel;
    }

    private static String d(AdInfo adInfo, int i2) {
        return i2 == 1 ? com.kwad.sdk.core.response.a.b.cP(adInfo) != null ? com.kwad.sdk.core.response.a.b.cP(adInfo) : "" : (i2 != 4 || com.kwad.sdk.core.response.a.b.cR(adInfo) == null) ? "" : com.kwad.sdk.core.response.a.b.cR(adInfo);
    }

    private void setTitle(String str) {
        this.title = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String kq() {
        return this.BD;
    }

    public final int kr() {
        return this.BE;
    }
}
