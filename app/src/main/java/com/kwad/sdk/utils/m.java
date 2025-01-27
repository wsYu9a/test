package com.kwad.sdk.utils;

import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes3.dex */
public final class m {
    public static long aSS = -1;

    public static void eA(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = System.currentTimeMillis();
        }
    }

    public static long eB(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return System.currentTimeMillis();
        }
        long j10 = adTemplate.mOutClickTimeParam;
        return j10 > 0 ? j10 : adTemplate.mVisibleTimeParam;
    }

    public static void ey(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = aSS;
            adTemplate.mOutClickTimeParam = aSS;
        }
    }

    public static void ez(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mOutClickTimeParam = System.currentTimeMillis();
        }
    }
}
