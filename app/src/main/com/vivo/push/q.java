package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes4.dex */
public abstract class q {

    /* renamed from: a */
    protected Context f25084a;

    /* renamed from: b */
    protected Handler f25085b;

    /* renamed from: c */
    private final Object f25086c = new Object();

    public class a extends Handler {
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
        this.f25085b = new a(handlerThread.getLooper());
    }

    public final void a(Context context) {
        this.f25084a = context;
    }

    public abstract void b(Message message);

    public final void a(Message message) {
        synchronized (this.f25086c) {
            try {
                Handler handler = this.f25085b;
                if (handler == null) {
                    String str = "Dead worker dropping a message: " + message.what;
                    com.vivo.push.util.p.e(getClass().getSimpleName(), str + " (Thread " + Thread.currentThread().getId() + ")");
                } else {
                    handler.sendMessage(message);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
