package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes4.dex */
public final class m {

    /* renamed from: a */
    private static final Handler f31031a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static final HandlerThread f31032b;

    /* renamed from: c */
    private static final Handler f31033c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        f31032b = handlerThread;
        handlerThread.start();
        f31033c = new n(handlerThread.getLooper());
    }

    public static void a(l lVar) {
        if (lVar == null) {
            com.vivo.push.util.p.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int a2 = lVar.a();
        Message message = new Message();
        message.what = a2;
        message.obj = lVar;
        f31033c.sendMessageDelayed(message, 0L);
    }

    public static void b(Runnable runnable) {
        f31031a.post(runnable);
    }

    public static void c(Runnable runnable) {
        Handler handler = f31033c;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public static void a(Runnable runnable) {
        Handler handler = f31033c;
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 15000L);
    }
}
