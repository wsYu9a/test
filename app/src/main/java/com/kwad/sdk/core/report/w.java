package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class w {
    private static Context Op;
    private static String ajS = xl();
    private static long ajT = 0;

    @WorkerThread
    private static long aV(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("seq", 1L);
    }

    @WorkerThread
    private static boolean d(Context context, long j2) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
        edit.putLong("seq", j2);
        return edit.commit();
    }

    public static void init(Context context) {
        Op = context;
    }

    public static String xh() {
        com.kwad.sdk.core.d.b.d("ReportIdManager", ">> updateSessionId");
        String xl = xl();
        ajS = xl;
        return xl;
    }

    public static String xi() {
        return ajS;
    }

    @WorkerThread
    public static long xj() {
        long aV = aV(Op);
        d(Op, 1 + aV);
        return aV;
    }

    public static long xk() {
        return ajT;
    }

    private static String xl() {
        return UUID.randomUUID().toString();
    }
}
