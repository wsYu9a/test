package com.sigmob.sdk.videoAd;

/* loaded from: classes4.dex */
public enum m {
    START("start"),
    FIRST_QUARTILE("firstQuartile"),
    MIDPOINT("midpoint"),
    THIRD_QUARTILE("thirdQuartile"),
    COMPLETE("complete"),
    COMPANION_AD_VIEW("companionAdView"),
    COMPANION_AD_CLICK("companionAdClick"),
    FINISH("finish"),
    SHOW("show"),
    CLICK("click"),
    UNKNOWN("");


    /* renamed from: a */
    public final String f20491a;

    m(String str) {
        this.f20491a = str;
    }

    public final String b() {
        return this.f20491a;
    }

    public static m a(String str) {
        if (str == null) {
            return UNKNOWN;
        }
        for (m mVar : values()) {
            if (str.equals(mVar.b())) {
                return mVar;
            }
        }
        return UNKNOWN;
    }
}
