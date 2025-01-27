package com.kwad.sdk.utils;

import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class l {
    public static long azn = -1;

    public static void cu(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = azn;
            adTemplate.mOutClickTimeParam = azn;
        }
    }

    public static void cv(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mOutClickTimeParam = System.currentTimeMillis();
        }
    }

    public static void cw(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = System.currentTimeMillis();
        }
    }

    public static long cx(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return System.currentTimeMillis();
        }
        long j2 = adTemplate.mOutClickTimeParam;
        return j2 > 0 ? j2 : adTemplate.mVisibleTimeParam;
    }
}
