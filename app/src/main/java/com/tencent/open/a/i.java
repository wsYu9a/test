package com.tencent.open.a;

import com.tencent.open.a.d;

/* loaded from: classes4.dex */
public abstract class i {

    /* renamed from: a */
    private volatile int f25438a;

    /* renamed from: b */
    private volatile boolean f25439b;

    /* renamed from: c */
    private h f25440c;

    public i() {
        this(c.f25417a, true, h.f25437a);
    }

    public void a(int i2) {
        this.f25438a = i2;
    }

    protected abstract void a(int i2, Thread thread, long j2, String str, String str2, Throwable th);

    public void b(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f25438a, i2)) {
            a(i2, thread, j2, str, str2, th);
        }
    }

    public boolean d() {
        return this.f25439b;
    }

    public h e() {
        return this.f25440c;
    }

    public i(int i2, boolean z, h hVar) {
        this.f25438a = c.f25417a;
        this.f25439b = true;
        this.f25440c = h.f25437a;
        a(i2);
        a(z);
        a(hVar);
    }

    public void a(boolean z) {
        this.f25439b = z;
    }

    public void a(h hVar) {
        this.f25440c = hVar;
    }
}
