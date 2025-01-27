package com.kwad.sdk.utils;

import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;

/* loaded from: classes3.dex */
public final class at {
    private static volatile at aUg = new at();
    private volatile boolean aUh;
    private volatile long aUi = 0;
    private volatile PowerManager aUj;

    public static at NU() {
        return aUg;
    }

    public final boolean cK(Context context) {
        if (this.aUi > 0 && SystemClock.elapsedRealtime() - this.aUi < 600) {
            return this.aUh;
        }
        if (this.aUj == null && context != null) {
            synchronized (this) {
                try {
                    if (this.aUj == null) {
                        this.aUj = (PowerManager) context.getApplicationContext().getSystemService("power");
                    }
                } finally {
                }
            }
        }
        this.aUh = this.aUj != null ? this.aUj.isInteractive() : false;
        this.aUi = SystemClock.elapsedRealtime();
        return this.aUh;
    }
}
