package com.vivo.mobilead.lottie.c.b;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private final float[] f29209a;

    /* renamed from: b */
    private final int[] f29210b;

    public c(float[] fArr, int[] iArr) {
        this.f29209a = fArr;
        this.f29210b = iArr;
    }

    public void a(c cVar, c cVar2, float f2) {
        if (cVar.f29210b.length == cVar2.f29210b.length) {
            for (int i2 = 0; i2 < cVar.f29210b.length; i2++) {
                this.f29209a[i2] = com.vivo.mobilead.lottie.f.g.a(cVar.f29209a[i2], cVar2.f29209a[i2], f2);
                this.f29210b[i2] = com.vivo.mobilead.lottie.f.b.a(f2, cVar.f29210b[i2], cVar2.f29210b[i2]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f29210b.length + " vs " + cVar2.f29210b.length + ")");
    }

    public float[] a() {
        return this.f29209a;
    }

    public int[] b() {
        return this.f29210b;
    }

    public int c() {
        return this.f29210b.length;
    }
}
