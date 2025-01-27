package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class bf {
    public static void a(long j2, int i2, @Nullable Context context) {
        if (j2 == 0 || context == null || i2 <= 0 || i2 > 100) {
            return;
        }
        long currentTimeMillis = j2 - System.currentTimeMillis();
        (Math.abs(currentTimeMillis) / 3600000 > ((long) i2) ? context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong("key_time_diff_s2c", currentTimeMillis) : context.getSharedPreferences("ksadsdk_pref", 0).edit().remove("key_time_diff_s2c")).apply();
    }

    public static long v(@Nullable Context context, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!z) {
            return currentTimeMillis;
        }
        if (context != null) {
            long j2 = context.getSharedPreferences("ksadsdk_pref", 0).getLong("key_time_diff_s2c", 0L);
            if (j2 != 0) {
                return currentTimeMillis + j2;
            }
        }
        return Math.abs(currentTimeMillis);
    }
}
