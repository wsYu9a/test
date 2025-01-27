package com.vivo.mobilead.lottie.g;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private float f29483a;

    /* renamed from: b */
    private float f29484b;

    public d() {
        this(1.0f, 1.0f);
    }

    public d(float f2, float f3) {
        this.f29483a = f2;
        this.f29484b = f3;
    }

    public float a() {
        return this.f29483a;
    }

    public void a(float f2, float f3) {
        this.f29483a = f2;
        this.f29484b = f3;
    }

    public float b() {
        return this.f29484b;
    }

    public boolean b(float f2, float f3) {
        return this.f29483a == f2 && this.f29484b == f3;
    }

    public String toString() {
        return a() + "x" + b();
    }
}
