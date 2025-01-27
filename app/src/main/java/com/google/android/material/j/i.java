package com.google.android.material.j;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class i extends g {

    /* renamed from: a */
    private final float f7411a;

    public i(float f2) {
        this.f7411a = f2 - 0.001f;
    }

    @Override // com.google.android.material.j.g
    boolean a() {
        return true;
    }

    @Override // com.google.android.material.j.g
    public void b(float f2, float f3, float f4, @NonNull q qVar) {
        double d2 = this.f7411a;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d2);
        float f5 = (float) ((d2 * sqrt) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(this.f7411a, 2.0d) - Math.pow(f5, 2.0d));
        double d3 = this.f7411a;
        double sqrt3 = Math.sqrt(2.0d);
        Double.isNaN(d3);
        double d4 = d3 * sqrt3;
        double d5 = this.f7411a;
        Double.isNaN(d5);
        qVar.p(f3 - f5, ((float) (-(d4 - d5))) + sqrt2);
        double d6 = this.f7411a;
        double sqrt4 = Math.sqrt(2.0d);
        Double.isNaN(d6);
        double d7 = d6 * sqrt4;
        double d8 = this.f7411a;
        Double.isNaN(d8);
        qVar.n(f3, (float) (-(d7 - d8)));
        double d9 = this.f7411a;
        double sqrt5 = Math.sqrt(2.0d);
        Double.isNaN(d9);
        double d10 = d9 * sqrt5;
        double d11 = this.f7411a;
        Double.isNaN(d11);
        qVar.n(f3 + f5, ((float) (-(d10 - d11))) + sqrt2);
    }
}
