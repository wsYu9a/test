package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

/* loaded from: classes.dex */
public final class LogTime {
    private static final double MILLIS_MULTIPLIER;

    static {
        MILLIS_MULTIPLIER = Build.VERSION.SDK_INT >= 17 ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    private LogTime() {
    }

    public static double getElapsedMillis(long j2) {
        double logTime = getLogTime() - j2;
        double d2 = MILLIS_MULTIPLIER;
        Double.isNaN(logTime);
        return logTime * d2;
    }

    @TargetApi(17)
    public static long getLogTime() {
        return Build.VERSION.SDK_INT >= 17 ? SystemClock.elapsedRealtimeNanos() : SystemClock.uptimeMillis();
    }
}
