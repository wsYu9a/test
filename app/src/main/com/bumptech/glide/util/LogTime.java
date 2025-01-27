package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* loaded from: classes2.dex */
public final class LogTime {
    private static final double MILLIS_MULTIPLIER = 1.0d / Math.pow(10.0d, 6.0d);

    private LogTime() {
    }

    public static double getElapsedMillis(long j10) {
        return (getLogTime() - j10) * MILLIS_MULTIPLIER;
    }

    @TargetApi(17)
    public static long getLogTime() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
