package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;

/* loaded from: classes4.dex */
public class aa {

    /* renamed from: a */
    private static z f25621a = null;

    /* renamed from: b */
    private static boolean f25622b = false;

    public static synchronized String a(Context context) {
        synchronized (aa.class) {
            try {
                if (context == null) {
                    throw new RuntimeException("Context is null");
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    throw new IllegalStateException("Cannot be called from the main thread");
                }
                b(context);
                z zVar = f25621a;
                if (zVar != null) {
                    try {
                        return zVar.a(context);
                    } catch (Exception unused) {
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void b(Context context) {
        if (f25621a != null || f25622b) {
            return;
        }
        synchronized (aa.class) {
            if (f25621a == null && !f25622b) {
                f25621a = ac.a(context);
                f25622b = true;
            }
        }
    }
}
