package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes3.dex */
public final class i {
    private static SimpleDateFormat aMt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String aG(long j10) {
        return j10 <= 0 ? "unknown" : aMt.format(new Date(j10));
    }
}
