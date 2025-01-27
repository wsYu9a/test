package com.opos.mobad.f.a;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public class m<T> implements Runnable {

    /* renamed from: a */
    private volatile T f20785a;

    /* renamed from: b */
    private a<T> f20786b;

    /* renamed from: c */
    private volatile long f20787c = Long.MAX_VALUE;

    public interface a<T> {
        void a(T t);
    }

    public m(a<T> aVar) {
        this.f20786b = aVar;
    }

    public void a() {
        this.f20787c = Long.MAX_VALUE;
        this.f20785a = null;
    }

    public void a(long j2, T t) {
        long max = Math.max(0L, j2);
        this.f20787c = SystemClock.uptimeMillis() + max;
        this.f20785a = t;
        com.opos.mobad.service.c.a(this, max);
    }

    public void b() {
        com.opos.mobad.service.c.b(this);
        this.f20785a = null;
    }

    @Override // java.lang.Runnable
    public void run() {
        a<T> aVar;
        if (SystemClock.uptimeMillis() >= this.f20787c && (aVar = this.f20786b) != null) {
            aVar.a(this.f20785a);
        }
    }
}
