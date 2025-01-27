package com.kwad.components.ad.interstitial.b;

import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes2.dex */
public final class b {
    public static int b(AdInfo adInfo) {
        int intValue = a.kF.getValue().intValue();
        if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            int L = com.kwad.sdk.core.response.b.a.L(adInfo);
            return intValue == 0 ? L : Math.min(intValue, L);
        }
        if (intValue > 60 || intValue <= 0) {
            return 60;
        }
        return intValue;
    }

    public static boolean da() {
        return a.kH.getValue().booleanValue();
    }

    public static boolean db() {
        return a.kB.getValue().intValue() == 1;
    }

    public static int dc() {
        return a.kC.getValue().intValue();
    }

    public static boolean dd() {
        return a.kD.getValue().intValue() == 1;
    }

    public static boolean de() {
        return a.kE.getValue().intValue() == 1;
    }

    public static int df() {
        return a.kJ.getValue().intValue();
    }

    public static boolean dg() {
        return a.kG.getValue().intValue() == 1;
    }

    public static boolean dh() {
        return a.kI.getValue().intValue() == 1;
    }
}
