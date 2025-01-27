package yk;

import java.lang.Thread;

/* loaded from: classes5.dex */
public final class e implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (!(defaultUncaughtExceptionHandler instanceof c)) {
                c.a(defaultUncaughtExceptionHandler);
                Thread.setDefaultUncaughtExceptionHandler(new c(Thread.getDefaultUncaughtExceptionHandler()));
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        c.f33567c.postDelayed(this, 3000L);
    }
}
