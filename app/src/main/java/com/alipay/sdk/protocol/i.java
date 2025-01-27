package com.alipay.sdk.protocol;

/* loaded from: classes.dex */
public abstract class i extends c {

    /* renamed from: d */
    public static final int f5427d = 4;

    /* renamed from: e */
    public static final int f5428e = 6;

    /* renamed from: f */
    public static final int f5429f = 7;

    /* renamed from: g */
    public static final int f5430g = 8;

    /* renamed from: h */
    public static final int f5431h = 9;

    /* renamed from: i */
    public static final int f5432i = 10;

    /* renamed from: j */
    public static final int f5433j = -10;
    boolean k;

    protected i(b.b.a.c.e eVar, b.b.a.c.f fVar) {
        super(eVar, fVar);
        this.k = false;
    }

    private void e(boolean z) {
        this.k = z;
    }

    private boolean i() {
        return this.k;
    }

    public abstract boolean f();

    public abstract int g();

    public abstract String h();
}
