package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;

/* loaded from: classes2.dex */
public final class an {
    private static volatile an aAe = new an();
    private volatile boolean aAf;
    private volatile long aAg = 0;
    private volatile PowerManager aAh;

    public static an DN() {
        return aAe;
    }

    public final boolean ci(Context context) {
        if (this.aAg > 0 && SystemClock.elapsedRealtime() - this.aAg < 600) {
            return this.aAf;
        }
        if (this.aAh == null && context != null) {
            synchronized (this) {
                if (this.aAh == null) {
                    this.aAh = (PowerManager) context.getApplicationContext().getSystemService("power");
                }
            }
        }
        this.aAf = this.aAh != null ? Build.VERSION.SDK_INT >= 20 ? this.aAh.isInteractive() : this.aAh.isScreenOn() : false;
        this.aAg = SystemClock.elapsedRealtime();
        return this.aAf;
    }
}
