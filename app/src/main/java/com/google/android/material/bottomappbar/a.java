package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.j.g;
import com.google.android.material.j.q;

/* loaded from: classes.dex */
public class a extends g implements Cloneable {

    /* renamed from: a */
    private static final int f6779a = 90;

    /* renamed from: b */
    private static final int f6780b = 180;

    /* renamed from: c */
    private static final int f6781c = 270;

    /* renamed from: d */
    private static final int f6782d = 180;

    /* renamed from: e */
    private float f6783e;

    /* renamed from: f */
    private float f6784f;

    /* renamed from: g */
    private float f6785g;

    /* renamed from: h */
    private float f6786h;

    /* renamed from: i */
    private float f6787i;

    public a(float f2, float f3, float f4) {
        this.f6784f = f2;
        this.f6783e = f3;
        i(f4);
        this.f6787i = 0.0f;
    }

    @Override // com.google.android.material.j.g
    public void b(float f2, float f3, float f4, @NonNull q qVar) {
        float f5 = this.f6785g;
        if (f5 == 0.0f) {
            qVar.n(f2, 0.0f);
            return;
        }
        float f6 = ((this.f6784f * 2.0f) + f5) / 2.0f;
        float f7 = f4 * this.f6783e;
        float f8 = f3 + this.f6787i;
        float f9 = (this.f6786h * f4) + ((1.0f - f4) * f6);
        if (f9 / f6 >= 1.0f) {
            qVar.n(f2, 0.0f);
            return;
        }
        float f10 = f6 + f7;
        float f11 = f9 + f7;
        float sqrt = (float) Math.sqrt((f10 * f10) - (f11 * f11));
        float f12 = f8 - sqrt;
        float f13 = f8 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f11));
        float f14 = 90.0f - degrees;
        qVar.n(f12, 0.0f);
        float f15 = f7 * 2.0f;
        qVar.a(f12 - f7, 0.0f, f12 + f7, f15, 270.0f, degrees);
        qVar.a(f8 - f6, (-f6) - f9, f8 + f6, f6 - f9, 180.0f - f14, (f14 * 2.0f) - 180.0f);
        qVar.a(f13 - f7, 0.0f, f13 + f7, f15, 270.0f - degrees, degrees);
        qVar.n(f2, 0.0f);
    }

    float d() {
        return this.f6786h;
    }

    float e() {
        return this.f6784f;
    }

    float f() {
        return this.f6783e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float g() {
        return this.f6785g;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float h() {
        return this.f6787i;
    }

    void i(@FloatRange(from = 0.0d) float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f6786h = f2;
    }

    void j(float f2) {
        this.f6784f = f2;
    }

    void k(float f2) {
        this.f6783e = f2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void l(float f2) {
        this.f6785g = f2;
    }

    void m(float f2) {
        this.f6787i = f2;
    }
}
