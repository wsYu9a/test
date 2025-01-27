package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class t {
    private static String aDh = GC();
    private static long aDi = 0;
    private static Context aDj;

    @WorkerThread
    public static long GA() {
        long bx = bx(aDj);
        b(aDj, 1 + bx);
        return bx;
    }

    public static long GB() {
        return aDi;
    }

    private static String GC() {
        return UUID.randomUUID().toString();
    }

    public static String Gy() {
        com.kwad.sdk.core.d.c.d("ReportIdManager", ">> updateSessionId");
        String GC = GC();
        aDh = GC;
        return GC;
    }

    public static String Gz() {
        return aDh;
    }

    @WorkerThread
    private static boolean b(Context context, long j10) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
        edit.putLong("seq", j10);
        return edit.commit();
    }

    @WorkerThread
    private static long bx(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("seq", 1L);
    }

    public static void init(Context context) {
        aDj = context;
    }
}
