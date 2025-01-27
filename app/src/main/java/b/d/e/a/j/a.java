package b.d.e.a.j;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes4.dex */
public final class a extends HandlerThread {

    /* renamed from: a, reason: collision with root package name */
    private static a f4531a;

    /* renamed from: b, reason: collision with root package name */
    private static Handler f4532b;

    private a() {
        super("AdSdk-sdk1-bg.tasks", 0);
    }

    private static void c() {
        if (f4531a == null) {
            a aVar = new a();
            f4531a = aVar;
            aVar.start();
            f4532b = new Handler(f4531a.getLooper());
        }
    }

    public static void d(Runnable runnable) {
        e().post(runnable);
    }

    public static Handler e() {
        Handler handler;
        synchronized (a.class) {
            c();
            handler = f4532b;
        }
        return handler;
    }
}
