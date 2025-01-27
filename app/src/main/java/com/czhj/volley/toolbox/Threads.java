package com.czhj.volley.toolbox;

import android.os.Looper;

/* loaded from: classes2.dex */
final class Threads {
    public static void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Must be invoked from the main thread.");
        }
    }
}
