package com.kwad.components.ad.reward.a;

import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes2.dex */
public final class b {
    public static int gK() {
        return a.rT.getValue().intValue();
    }

    public static String gL() {
        return a.rX.getValue();
    }

    public static int gM() {
        return a.rU.getValue().intValue();
    }

    public static boolean gN() {
        return a.rW.getValue().booleanValue();
    }

    public static int gO() {
        return a.rV.getValue().intValue();
    }

    private static boolean gP() {
        return a.rZ.getValue().intValue() == 1;
    }

    public static float gQ() {
        return a.f11657se.getValue().floatValue();
    }

    public static boolean gR() {
        return a.f11657se.getValue().floatValue() > 0.0f && a.f11657se.getValue().floatValue() < 1.0f;
    }

    public static boolean gS() {
        return a.f11658sf.getValue().booleanValue();
    }

    public static long gT() {
        return a.f11655sc.getValue().intValue();
    }

    public static int gU() {
        return a.f11656sd.getValue().intValue();
    }

    public static int gV() {
        return a.f11659sg.getValue().intValue();
    }

    public static boolean gW() {
        return a.f11660sh.getValue().booleanValue();
    }

    public static boolean gX() {
        return a.f11661si.getValue().intValue() == 1 || a.f11661si.getValue().intValue() == 3;
    }

    public static boolean gY() {
        return a.f11662sj.getValue().booleanValue();
    }

    public static boolean gZ() {
        return a.f11663sk.getValue().booleanValue();
    }

    public static boolean i(AdInfo adInfo) {
        return !j(adInfo) && com.kwad.sdk.core.response.b.a.cQ(adInfo) && gP();
    }

    public static boolean j(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.cQ(adInfo) && a.f11654sb.getValue().intValue() == 1;
    }

    public static boolean k(AdInfo adInfo) {
        return i(adInfo);
    }
}
