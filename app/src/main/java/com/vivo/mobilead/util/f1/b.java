package com.vivo.mobilead.util.f1;

import com.vivo.mobilead.util.VOpenLog;

/* loaded from: classes4.dex */
public abstract class b implements Runnable {
    public static final String TAG = "SafeRunnable";

    @Override // java.lang.Runnable
    public void run() {
        try {
            safelyRun();
        } catch (Throwable th) {
            VOpenLog.w(TAG, "" + th.getMessage());
        }
    }

    public abstract void safelyRun();
}
