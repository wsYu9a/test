package bh;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static HandlerThread f1604a = new HandlerThread("snadsdk_work_thread", 10);

    /* renamed from: b, reason: collision with root package name */
    public static Handler f1605b;

    /* renamed from: c, reason: collision with root package name */
    public static Handler f1606c;

    public a() {
        f1604a.start();
        f1605b = new Handler(f1604a.getLooper());
        f1606c = new Handler(Looper.getMainLooper());
        SystemClock.elapsedRealtime();
    }

    public static Handler a() {
        if (f1606c == null) {
            synchronized (a.class) {
                try {
                    if (f1606c == null) {
                        f1606c = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return f1606c;
    }
}
