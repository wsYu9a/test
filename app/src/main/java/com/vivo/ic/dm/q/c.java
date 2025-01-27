package com.vivo.ic.dm.q;

import android.os.Process;
import com.vivo.ic.VLog;

/* loaded from: classes4.dex */
public class c extends Thread {

    /* renamed from: a */
    private static final String f28612a = "BackgroundThread";

    /* renamed from: b */
    public static boolean f28613b = false;

    public c() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f28613b) {
            try {
                Process.setThreadPriority(10);
            } catch (Exception e2) {
                VLog.i(f28612a, "setThreadPriority Fail " + e2.getMessage());
            }
        }
        super.run();
    }

    public c(Runnable runnable) {
        super(runnable);
    }

    public c(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
    }

    public c(String str) {
        super(str);
    }

    public c(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }

    public c(Runnable runnable, String str) {
        super(runnable, str);
    }

    public c(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, runnable, str);
    }

    public c(ThreadGroup threadGroup, Runnable runnable, String str, long j2) {
        super(threadGroup, runnable, str, j2);
    }
}
