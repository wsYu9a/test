package com.vivo.mobilead.lottie.f;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private float f29444a;

    /* renamed from: b */
    private int f29445b;

    public void a(float f2) {
        float f3 = this.f29444a + f2;
        this.f29444a = f3;
        int i2 = this.f29445b + 1;
        this.f29445b = i2;
        if (i2 == Integer.MAX_VALUE) {
            this.f29444a = f3 / 2.0f;
            this.f29445b = i2 / 2;
        }
    }
}
