package com.vivo.mobilead.unified.reward;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: e */
    private static volatile d f30498e;

    /* renamed from: a */
    private long f30499a;

    /* renamed from: b */
    private boolean f30500b = false;

    /* renamed from: c */
    private long f30501c;

    /* renamed from: d */
    private long f30502d;

    private d() {
    }

    public static d c() {
        if (f30498e == null) {
            synchronized (d.class) {
                if (f30498e == null) {
                    f30498e = new d();
                }
            }
        }
        return f30498e;
    }

    public long a() {
        if (System.currentTimeMillis() - this.f30502d > 30000) {
            this.f30499a = 0L;
        }
        return this.f30499a;
    }

    public boolean b() {
        if (System.currentTimeMillis() - this.f30501c > 30000) {
            this.f30500b = false;
        }
        return this.f30500b;
    }

    public void a(long j2) {
        if (j2 == 0) {
            this.f30502d = 0L;
        } else {
            this.f30502d = System.currentTimeMillis();
        }
        this.f30499a = j2;
    }

    public void a(boolean z) {
        if (z) {
            this.f30501c = System.currentTimeMillis();
        } else {
            this.f30501c = 0L;
        }
        this.f30500b = z;
    }
}
