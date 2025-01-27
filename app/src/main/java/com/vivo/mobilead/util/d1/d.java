package com.vivo.mobilead.util.d1;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: e */
    public static final d f30610e;

    /* renamed from: f */
    public static final d f30611f;

    /* renamed from: g */
    public static final d f30612g;

    /* renamed from: h */
    public static final d f30613h;

    /* renamed from: i */
    public static final d f30614i;

    /* renamed from: j */
    public static final d f30615j;

    /* renamed from: a */
    final float[] f30616a;

    /* renamed from: b */
    final float[] f30617b;

    /* renamed from: c */
    final float[] f30618c = new float[3];

    /* renamed from: d */
    boolean f30619d = false;

    static {
        d dVar = new d();
        f30610e = dVar;
        b(dVar);
        e(dVar);
        d dVar2 = new d();
        f30611f = dVar2;
        d(dVar2);
        e(dVar2);
        d dVar3 = new d();
        f30612g = dVar3;
        a(dVar3);
        e(dVar3);
        d dVar4 = new d();
        f30613h = dVar4;
        b(dVar4);
        c(dVar4);
        d dVar5 = new d();
        f30614i = dVar5;
        d(dVar5);
        c(dVar5);
        d dVar6 = new d();
        f30615j = dVar6;
        a(dVar6);
        c(dVar6);
    }

    d() {
        float[] fArr = new float[3];
        this.f30616a = fArr;
        float[] fArr2 = new float[3];
        this.f30617b = fArr2;
        a(fArr);
        a(fArr2);
        l();
    }

    private void l() {
        float[] fArr = this.f30618c;
        fArr[0] = 0.24f;
        fArr[1] = 0.52f;
        fArr[2] = 0.24f;
    }

    public float a() {
        return this.f30618c[1];
    }

    public float b() {
        return this.f30617b[2];
    }

    public float c() {
        return this.f30616a[2];
    }

    public float d() {
        return this.f30617b[0];
    }

    public float e() {
        return this.f30616a[0];
    }

    public float f() {
        return this.f30618c[2];
    }

    public float g() {
        return this.f30618c[0];
    }

    public float h() {
        return this.f30617b[1];
    }

    public float i() {
        return this.f30616a[1];
    }

    public boolean j() {
        return this.f30619d;
    }

    void k() {
        int length = this.f30618c.length;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < length; i2++) {
            float f3 = this.f30618c[i2];
            if (f3 > 0.0f) {
                f2 += f3;
            }
        }
        if (f2 != 0.0f) {
            int length2 = this.f30618c.length;
            for (int i3 = 0; i3 < length2; i3++) {
                float[] fArr = this.f30618c;
                if (fArr[i3] > 0.0f) {
                    fArr[i3] = fArr[i3] / f2;
                }
            }
        }
    }

    private static void a(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    private static void b(d dVar) {
        float[] fArr = dVar.f30617b;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
    }

    private static void c(d dVar) {
        float[] fArr = dVar.f30616a;
        fArr[1] = 0.3f;
        fArr[2] = 0.4f;
    }

    private static void d(d dVar) {
        float[] fArr = dVar.f30617b;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
    }

    private static void e(d dVar) {
        float[] fArr = dVar.f30616a;
        fArr[0] = 0.35f;
        fArr[1] = 1.0f;
    }

    private static void a(d dVar) {
        float[] fArr = dVar.f30617b;
        fArr[1] = 0.26f;
        fArr[2] = 0.45f;
    }
}
