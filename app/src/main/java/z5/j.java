package z5;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a */
    public final float f33681a;

    /* renamed from: b */
    public final float f33682b;

    /* renamed from: c */
    public final float f33683c;

    /* renamed from: d */
    public final float f33684d;

    /* renamed from: e */
    public final float f33685e;

    /* renamed from: f */
    public final float f33686f;

    /* renamed from: g */
    public final float f33687g;

    /* renamed from: h */
    public final float f33688h;

    /* renamed from: i */
    public final float f33689i;

    public j(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.f33681a = f10;
        this.f33682b = f13;
        this.f33683c = f16;
        this.f33684d = f11;
        this.f33685e = f14;
        this.f33686f = f17;
        this.f33687g = f12;
        this.f33688h = f15;
        this.f33689i = f18;
    }

    public static j b(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25) {
        return d(f18, f19, f20, f21, f22, f23, f24, f25).e(c(f10, f11, f12, f13, f14, f15, f16, f17));
    }

    public static j c(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return d(f10, f11, f12, f13, f14, f15, f16, f17).a();
    }

    public static j d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        float f18 = ((f10 - f12) + f14) - f16;
        float f19 = ((f11 - f13) + f15) - f17;
        if (f18 == 0.0f && f19 == 0.0f) {
            return new j(f12 - f10, f14 - f12, f10, f13 - f11, f15 - f13, f11, 0.0f, 0.0f, 1.0f);
        }
        float f20 = f12 - f14;
        float f21 = f16 - f14;
        float f22 = f13 - f15;
        float f23 = f17 - f15;
        float f24 = (f20 * f23) - (f21 * f22);
        float f25 = ((f23 * f18) - (f21 * f19)) / f24;
        float f26 = ((f20 * f19) - (f18 * f22)) / f24;
        return new j((f25 * f12) + (f12 - f10), (f26 * f16) + (f16 - f10), f10, (f13 - f11) + (f25 * f13), (f17 - f11) + (f26 * f17), f11, f25, f26, 1.0f);
    }

    public j a() {
        float f10 = this.f33685e;
        float f11 = this.f33689i;
        float f12 = this.f33686f;
        float f13 = this.f33688h;
        float f14 = (f10 * f11) - (f12 * f13);
        float f15 = this.f33687g;
        float f16 = this.f33684d;
        float f17 = (f12 * f15) - (f16 * f11);
        float f18 = (f16 * f13) - (f10 * f15);
        float f19 = this.f33683c;
        float f20 = this.f33682b;
        float f21 = (f19 * f13) - (f20 * f11);
        float f22 = this.f33681a;
        return new j(f14, f17, f18, f21, (f11 * f22) - (f19 * f15), (f15 * f20) - (f13 * f22), (f20 * f12) - (f19 * f10), (f19 * f16) - (f12 * f22), (f22 * f10) - (f20 * f16));
    }

    public j e(j jVar) {
        float f10 = this.f33681a;
        float f11 = jVar.f33681a;
        float f12 = this.f33684d;
        float f13 = jVar.f33682b;
        float f14 = this.f33687g;
        float f15 = jVar.f33683c;
        float f16 = (f10 * f11) + (f12 * f13) + (f14 * f15);
        float f17 = jVar.f33684d;
        float f18 = jVar.f33685e;
        float f19 = jVar.f33686f;
        float f20 = (f10 * f17) + (f12 * f18) + (f14 * f19);
        float f21 = jVar.f33687g;
        float f22 = jVar.f33688h;
        float f23 = jVar.f33689i;
        float f24 = (f10 * f21) + (f12 * f22) + (f14 * f23);
        float f25 = this.f33682b;
        float f26 = this.f33685e;
        float f27 = this.f33688h;
        float f28 = (f25 * f11) + (f26 * f13) + (f27 * f15);
        float f29 = (f25 * f17) + (f26 * f18) + (f27 * f19);
        float f30 = (f27 * f23) + (f25 * f21) + (f26 * f22);
        float f31 = this.f33683c;
        float f32 = this.f33686f;
        float f33 = (f11 * f31) + (f13 * f32);
        float f34 = this.f33689i;
        return new j(f16, f20, f24, f28, f29, f30, (f15 * f34) + f33, (f17 * f31) + (f18 * f32) + (f19 * f34), (f31 * f21) + (f32 * f22) + (f34 * f23));
    }

    public void f(float[] fArr) {
        int length = fArr.length;
        float f10 = this.f33681a;
        float f11 = this.f33682b;
        float f12 = this.f33683c;
        float f13 = this.f33684d;
        float f14 = this.f33685e;
        float f15 = this.f33686f;
        float f16 = this.f33687g;
        float f17 = this.f33688h;
        float f18 = this.f33689i;
        for (int i10 = 0; i10 < length; i10 += 2) {
            float f19 = fArr[i10];
            int i11 = i10 + 1;
            float f20 = fArr[i11];
            float f21 = (f12 * f19) + (f15 * f20) + f18;
            fArr[i10] = (((f10 * f19) + (f13 * f20)) + f16) / f21;
            fArr[i11] = (((f19 * f11) + (f20 * f14)) + f17) / f21;
        }
    }

    public void g(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            float f10 = fArr[i10];
            float f11 = fArr2[i10];
            float f12 = (this.f33683c * f10) + (this.f33686f * f11) + this.f33689i;
            fArr[i10] = (((this.f33681a * f10) + (this.f33684d * f11)) + this.f33687g) / f12;
            fArr2[i10] = (((this.f33682b * f10) + (this.f33685e * f11)) + this.f33688h) / f12;
        }
    }
}
