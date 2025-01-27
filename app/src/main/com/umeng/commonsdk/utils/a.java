package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: e */
    private static final int f24810e = 1;

    /* renamed from: a */
    private final long f24811a;

    /* renamed from: b */
    private final long f24812b;

    /* renamed from: c */
    private long f24813c;

    /* renamed from: f */
    private HandlerThread f24815f;

    /* renamed from: g */
    private Handler f24816g;

    /* renamed from: d */
    private boolean f24814d = false;

    /* renamed from: h */
    private Handler.Callback f24817h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        public AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                try {
                    if (a.this.f24814d) {
                        return true;
                    }
                    long elapsedRealtime = a.this.f24813c - SystemClock.elapsedRealtime();
                    if (elapsedRealtime <= 0) {
                        a.this.c();
                        if (a.this.f24815f != null) {
                            a.this.f24815f.quit();
                        }
                    } else if (elapsedRealtime < a.this.f24812b) {
                        a.this.f24816g.sendMessageDelayed(a.this.f24816g.obtainMessage(1), elapsedRealtime);
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        a.this.a(elapsedRealtime);
                        long elapsedRealtime3 = (elapsedRealtime2 + a.this.f24812b) - SystemClock.elapsedRealtime();
                        while (elapsedRealtime3 < 0) {
                            elapsedRealtime3 += a.this.f24812b;
                        }
                        a.this.f24816g.sendMessageDelayed(a.this.f24816g.obtainMessage(1), elapsedRealtime3);
                    }
                    return false;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    };

    /* renamed from: com.umeng.commonsdk.utils.a$1 */
    public class AnonymousClass1 implements Handler.Callback {
        public AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                try {
                    if (a.this.f24814d) {
                        return true;
                    }
                    long elapsedRealtime = a.this.f24813c - SystemClock.elapsedRealtime();
                    if (elapsedRealtime <= 0) {
                        a.this.c();
                        if (a.this.f24815f != null) {
                            a.this.f24815f.quit();
                        }
                    } else if (elapsedRealtime < a.this.f24812b) {
                        a.this.f24816g.sendMessageDelayed(a.this.f24816g.obtainMessage(1), elapsedRealtime);
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        a.this.a(elapsedRealtime);
                        long elapsedRealtime3 = (elapsedRealtime2 + a.this.f24812b) - SystemClock.elapsedRealtime();
                        while (elapsedRealtime3 < 0) {
                            elapsedRealtime3 += a.this.f24812b;
                        }
                        a.this.f24816g.sendMessageDelayed(a.this.f24816g.obtainMessage(1), elapsedRealtime3);
                    }
                    return false;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public a(long j10, long j11) {
        this.f24811a = j10;
        this.f24812b = j11;
        if (d()) {
            this.f24816g = new Handler(this.f24817h);
            return;
        }
        HandlerThread handlerThread = new HandlerThread("CountDownTimerThread");
        this.f24815f = handlerThread;
        handlerThread.start();
        this.f24816g = new Handler(this.f24815f.getLooper(), this.f24817h);
    }

    public abstract void a(long j10);

    public abstract void c();

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final synchronized void a() {
        this.f24814d = true;
        this.f24816g.removeMessages(1);
    }

    public final synchronized a b() {
        this.f24814d = false;
        if (this.f24811a <= 0) {
            c();
            return this;
        }
        this.f24813c = SystemClock.elapsedRealtime() + this.f24811a;
        Handler handler = this.f24816g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
