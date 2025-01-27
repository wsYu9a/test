package com.martian.ttbook.b.a.i;

/* loaded from: classes4.dex */
public class h extends Exception {

    /* renamed from: b */
    private int f14991b;

    public h(int i2, String str) {
        super(str);
        this.f14991b = 0;
        this.f14991b = i2;
    }

    public h(int i2, String str, Throwable th) {
        super(str, th);
        this.f14991b = 0;
        this.f14991b = i2;
    }

    public h(int i2, Throwable th) {
        super(th);
        this.f14991b = 0;
        this.f14991b = i2;
    }

    public h(String str) {
        super(str);
        this.f14991b = 0;
    }

    public int a() {
        return this.f14991b;
    }
}
