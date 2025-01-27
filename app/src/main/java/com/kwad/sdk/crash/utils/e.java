package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

/* loaded from: classes2.dex */
public final class e {
    private static Context Op;

    @WorkerThread
    private static long aV(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("crashseq", 1L);
    }

    @WorkerThread
    private static boolean d(Context context, long j2) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
        edit.putLong("crashseq", j2);
        return edit.commit();
    }

    public static void init(Context context) {
        Op = context;
    }

    @WorkerThread
    public static long xj() {
        long aV = aV(Op);
        d(Op, 1 + aV);
        return aV;
    }
}
