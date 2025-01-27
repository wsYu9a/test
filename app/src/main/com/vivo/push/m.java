package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.C;

/* loaded from: classes4.dex */
public final class m {

    /* renamed from: a */
    private static final Handler f25067a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static final HandlerThread f25068b;

    /* renamed from: c */
    private static final Handler f25069c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        f25068b = handlerThread;
        handlerThread.start();
        f25069c = new n(handlerThread.getLooper());
    }

    public static void a(l lVar) {
        if (lVar == null) {
            com.vivo.push.util.p.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int a10 = lVar.a();
        Message message = new Message();
        message.what = a10;
        message.obj = lVar;
        f25069c.sendMessageDelayed(message, 0L);
    }

    public static void b(Runnable runnable) {
        f25067a.post(runnable);
    }

    public static void c(Runnable runnable) {
        Handler handler = f25069c;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public static void a(Runnable runnable) {
        Handler handler = f25069c;
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
    }
}
