package com.kwad.sdk.crash.utils;

import androidx.core.os.EnvironmentCompat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public final class i {
    private static SimpleDateFormat ath = new SimpleDateFormat(b.d.b.f.f4408b);

    public static String Y(long j2) {
        return j2 <= 0 ? EnvironmentCompat.MEDIA_UNKNOWN : ath.format(new Date(j2));
    }
}
