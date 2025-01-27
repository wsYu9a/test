package com.kwad.sdk.utils;

import android.content.Context;

/* loaded from: classes3.dex */
public final class s {
    public static String aQ(Context context) {
        return gD("curversion");
    }

    private static String gD(String str) {
        return bl.h("kssdk_api_pref", str, "");
    }
}
