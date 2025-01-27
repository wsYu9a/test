package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes4.dex */
public abstract class q {

    /* renamed from: a */
    protected Context f31048a;

    /* renamed from: b */
    protected Handler f31049b;

    /* renamed from: c */
    private final Object f31050c = new Object();

    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            q.this.b(message);
        }
    }

    public q() {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.f31049b = new a(handlerThread.getLooper());
    }

    public final void a(Context context) {
        this.f31048a = context;
    }

    public abstract void b(Message message);

    public final void a(Message message) {
        synchronized (this.f31050c) {
            Handler handler = this.f31049b;
            if (handler == null) {
                String str = "Dead worker dropping a message: " + message.what;
                com.vivo.push.util.p.e(getClass().getSimpleName(), str + " (Thread " + Thread.currentThread().getId() + ")");
            } else {
                handler.sendMessage(message);
            }
        }
    }
}
