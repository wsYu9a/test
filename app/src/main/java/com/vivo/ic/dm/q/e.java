package com.vivo.ic.dm.q;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private static HandlerThread f28625a;

    /* renamed from: b */
    private static Handler f28626b;

    public interface a {
        void a(Object obj);
    }

    static {
        b bVar = new b("download_worker_thread");
        f28625a = bVar;
        bVar.start();
        f28626b = new Handler(f28625a.getLooper());
    }

    public static void a(int i2, Runnable runnable) {
        f28626b.removeMessages(i2);
        Message obtain = Message.obtain(f28626b, runnable);
        obtain.what = i2;
        obtain.sendToTarget();
    }

    public static void b(Runnable runnable) {
        a(runnable, 0L, 5);
    }

    public static void a(Runnable runnable, int i2) {
        a(runnable, 0L, i2);
    }

    public static void a(Runnable runnable, long j2, int i2) {
        f28625a.setPriority(i2);
        if (f28625a.getThreadId() == Process.myTid()) {
            runnable.run();
        } else {
            f28626b.postDelayed(runnable, j2);
        }
    }

    public static void a(Runnable runnable) {
        f28626b.removeCallbacks(runnable);
    }
}
