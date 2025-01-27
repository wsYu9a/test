package com.bytedance.pangle.util.b.b;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public int f6316a;

    /* renamed from: e, reason: collision with root package name */
    public int f6320e;

    /* renamed from: f, reason: collision with root package name */
    public int f6321f;

    /* renamed from: g, reason: collision with root package name */
    public int f6322g;

    /* renamed from: h, reason: collision with root package name */
    public String f6323h;

    /* renamed from: i, reason: collision with root package name */
    public long f6324i;

    /* renamed from: b, reason: collision with root package name */
    public long f6317b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f6318c = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f6319d = 0;

    /* renamed from: j, reason: collision with root package name */
    private final long f6325j = 30;

    public final long a() {
        long j2 = this.f6318c;
        return j2 > 0 ? j2 : this.f6319d;
    }

    public final long b() {
        return c() + a();
    }

    public final long c() {
        return this.f6320e + 30 + this.f6322g;
    }
}
