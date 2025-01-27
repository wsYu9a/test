package com.google.android.material.j;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class f extends e {

    /* renamed from: a */
    float f7403a;

    public f() {
        this.f7403a = -1.0f;
    }

    @Override // com.google.android.material.j.e
    public void b(@NonNull q qVar, float f2, float f3, float f4) {
        qVar.q(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        double sin = Math.sin(Math.toRadians(f2));
        double d2 = f4;
        Double.isNaN(d2);
        double d3 = f3;
        Double.isNaN(d3);
        double sin2 = Math.sin(Math.toRadians(90.0f - f2));
        Double.isNaN(d2);
        Double.isNaN(d3);
        qVar.n((float) (sin * d2 * d3), (float) (sin2 * d2 * d3));
    }

    @Deprecated
    public f(float f2) {
        this.f7403a = -1.0f;
        this.f7403a = f2;
    }
}
