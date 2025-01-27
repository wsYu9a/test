package com.opos.exoplayer.core.i;

import android.annotation.TargetApi;
import android.os.Trace;

/* loaded from: classes4.dex */
public final class t {
    public static void a() {
        if (u.f19078a >= 18) {
            b();
        }
    }

    public static void a(String str) {
        if (u.f19078a >= 18) {
            b(str);
        }
    }

    @TargetApi(18)
    private static void b() {
        Trace.endSection();
    }

    @TargetApi(18)
    private static void b(String str) {
        Trace.beginSection(str);
    }
}
