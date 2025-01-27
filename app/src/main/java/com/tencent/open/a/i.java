package com.tencent.open.a;

import com.tencent.open.a.d;

/* loaded from: classes4.dex */
public abstract class i {

    /* renamed from: a */
    private volatile int f23171a;

    /* renamed from: b */
    private volatile boolean f23172b;

    /* renamed from: c */
    private h f23173c;

    public i() {
        this(c.f23146a, true, h.f23170a);
    }

    public void a(int i10) {
        this.f23171a = i10;
    }

    public abstract void a(int i10, Thread thread, long j10, String str, String str2, Throwable th2);

    public void b(int i10, Thread thread, long j10, String str, String str2, Throwable th2) {
        if (d() && d.a.a(this.f23171a, i10)) {
            a(i10, thread, j10, str, str2, th2);
        }
    }

    public boolean d() {
        return this.f23172b;
    }

    public h e() {
        return this.f23173c;
    }

    public i(int i10, boolean z10, h hVar) {
        this.f23171a = c.f23146a;
        this.f23172b = true;
        this.f23173c = h.f23170a;
        a(i10);
        a(z10);
        a(hVar);
    }

    public void a(boolean z10) {
        this.f23172b = z10;
    }

    public void a(h hVar) {
        this.f23173c = hVar;
    }
}
