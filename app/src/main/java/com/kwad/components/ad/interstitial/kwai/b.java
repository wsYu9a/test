package com.kwad.components.ad.interstitial.kwai;

import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes.dex */
public final class b {
    public static int b(AdInfo adInfo) {
        int intValue = a.jd.getValue().intValue();
        if (com.kwad.sdk.core.response.a.a.aU(adInfo)) {
            int F = com.kwad.sdk.core.response.a.a.F(adInfo);
            return intValue == 0 ? F : Math.min(intValue, F);
        }
        if (intValue > 60 || intValue <= 0) {
            return 60;
        }
        return intValue;
    }

    public static boolean c(AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.a.co(adInfo) && a.jg.getValue().intValue() == 1;
    }

    public static boolean cH() {
        return a.jf.getValue().booleanValue();
    }

    public static boolean cI() {
        return a.iZ.getValue().intValue() == 1;
    }

    public static int cJ() {
        return a.ja.getValue().intValue();
    }

    public static boolean cK() {
        return a.jb.getValue().intValue() == 1;
    }

    public static boolean cL() {
        return a.jc.getValue().intValue() == 1;
    }

    public static int cM() {
        return a.jh.getValue().intValue();
    }

    public static boolean cN() {
        return a.je.getValue().intValue() == 1;
    }
}
