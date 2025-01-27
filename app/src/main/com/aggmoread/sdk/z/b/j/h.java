package com.aggmoread.sdk.z.b.j;

/* loaded from: classes.dex */
public class h extends Exception {

    /* renamed from: b, reason: collision with root package name */
    private int f4592b;

    public h(int i10, String str) {
        super(str);
        this.f4592b = i10;
    }

    public int a() {
        return this.f4592b;
    }

    public h(int i10, String str, Throwable th2) {
        super(str, th2);
        this.f4592b = i10;
    }

    public h(int i10, Throwable th2) {
        super(th2);
        this.f4592b = i10;
    }

    public h(String str) {
        super(str);
        this.f4592b = 0;
    }
}
