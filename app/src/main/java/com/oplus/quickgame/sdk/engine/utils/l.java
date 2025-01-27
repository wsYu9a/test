package com.oplus.quickgame.sdk.engine.utils;

import android.os.Looper;

/* loaded from: classes4.dex */
public class l {
    public static void a(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("xgame_router_sub_thread");
        thread.setDaemon(true);
        thread.start();
    }

    public static boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
