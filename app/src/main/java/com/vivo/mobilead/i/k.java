package com.vivo.mobilead.i;

import java.util.Map;

/* loaded from: classes4.dex */
public abstract class k<T> extends l {

    /* renamed from: a */
    private final int f28898a;

    /* renamed from: b */
    private final String f28899b;

    /* renamed from: c */
    private volatile boolean f28900c = false;

    /* renamed from: d */
    private volatile boolean f28901d = false;

    public k(int i2, String str, d dVar) {
        this.f28898a = i2;
        this.f28899b = str;
    }

    public int a() {
        return this.f28898a;
    }

    public abstract T a(e eVar) throws c;

    public abstract Map<String, String> b();

    protected void b(boolean z) {
        this.f28900c = z;
    }

    public String c() {
        return "UTF-8";
    }

    public String d() {
        return this.f28899b;
    }

    protected boolean e() {
        return this.f28901d;
    }

    protected boolean f() {
        return this.f28900c;
    }

    protected void a(boolean z) {
        this.f28901d = z;
    }
}
