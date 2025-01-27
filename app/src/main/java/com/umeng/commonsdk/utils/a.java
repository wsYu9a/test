package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: e */
    private static final int f26471e = 1;

    /* renamed from: a */
    private final long f26472a;

    /* renamed from: b */
    private final long f26473b;

    /* renamed from: c */
    private long f26474c;

    /* renamed from: f */
    private HandlerThread f26476f;

    /* renamed from: g */
    private Handler f26477g;

    /* renamed from: d */
    private boolean f26475d = false;

    /* renamed from: h */
    private Handler.Callback f26478h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                if (a.this.f26475d) {
                    return true;
                }
                long elapsedRealtime = a.this.f26474c - SystemClock.elapsedRealtime();
                if (elapsedRealtime <= 0) {
                    a.this.c();
                    if (a.this.f26476f != null) {
                        a.this.f26476f.quit();
                    }
                } else if (elapsedRealtime < a.this.f26473b) {
                    a.this.f26477g.sendMessageDelayed(a.this.f26477g.obtainMessage(1), elapsedRealtime);
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    a.this.a(elapsedRealtime);
                    long elapsedRealtime3 = (elapsedRealtime2 + a.this.f26473b) - SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        elapsedRealtime3 += a.this.f26473b;
                    }
                    a.this.f26477g.sendMessageDelayed(a.this.f26477g.obtainMessage(1), elapsedRealtime3);
                }
                return false;
            }
        }
    };

    /* renamed from: com.umeng.commonsdk.utils.a$1 */
    class AnonymousClass1 implements Handler.Callback {
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                if (a.this.f26475d) {
                    return true;
                }
                long elapsedRealtime = a.this.f26474c - SystemClock.elapsedRealtime();
                if (elapsedRealtime <= 0) {
                    a.this.c();
                    if (a.this.f26476f != null) {
                        a.this.f26476f.quit();
                    }
                } else if (elapsedRealtime < a.this.f26473b) {
                    a.this.f26477g.sendMessageDelayed(a.this.f26477g.obtainMessage(1), elapsedRealtime);
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    a.this.a(elapsedRealtime);
                    long elapsedRealtime3 = (elapsedRealtime2 + a.this.f26473b) - SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        elapsedRealtime3 += a.this.f26473b;
                    }
                    a.this.f26477g.sendMessageDelayed(a.this.f26477g.obtainMessage(1), elapsedRealtime3);
                }
                return false;
            }
        }
    }

    public a(long j2, long j3) {
        this.f26472a = j2;
        this.f26473b = j3;
        if (d()) {
            this.f26477g = new Handler(this.f26478h);
            return;
        }
        HandlerThread handlerThread = new HandlerThread("CountDownTimerThread");
        this.f26476f = handlerThread;
        handlerThread.start();
        this.f26477g = new Handler(this.f26476f.getLooper(), this.f26478h);
    }

    public abstract void a(long j2);

    public abstract void c();

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final synchronized void a() {
        this.f26475d = true;
        this.f26477g.removeMessages(1);
    }

    public final synchronized a b() {
        this.f26475d = false;
        if (this.f26472a <= 0) {
            c();
            return this;
        }
        this.f26474c = SystemClock.elapsedRealtime() + this.f26472a;
        Handler handler = this.f26477g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
