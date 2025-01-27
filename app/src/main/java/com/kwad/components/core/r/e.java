package com.kwad.components.core.r;

import java.util.Locale;

/* loaded from: classes2.dex */
public final class e {
    public static String a(long j2, boolean z) {
        double d2;
        String[] strArr = {" B", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB"};
        if (j2 <= 1) {
            return j2 + "B";
        }
        double d3 = j2;
        int log = (int) (Math.log(d3) / Math.log(1024.0d));
        if (j2 > 1024) {
            double pow = Math.pow(1024.0d, log);
            Double.isNaN(d3);
            d2 = d3 / pow;
        } else {
            Double.isNaN(d3);
            d2 = d3 / 1024.0d;
        }
        return String.format(Locale.ENGLISH, "%.1f%s", Double.valueOf(d2), strArr[log]);
    }
}
