package com.google.android.material.j;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class t extends g {

    /* renamed from: a */
    private final float f7512a;

    /* renamed from: b */
    private final boolean f7513b;

    public t(float f2, boolean z) {
        this.f7512a = f2;
        this.f7513b = z;
    }

    @Override // com.google.android.material.j.g
    public void b(float f2, float f3, float f4, @NonNull q qVar) {
        qVar.n(f3 - (this.f7512a * f4), 0.0f);
        qVar.n(f3, (this.f7513b ? this.f7512a : -this.f7512a) * f4);
        qVar.n(f3 + (this.f7512a * f4), 0.0f);
        qVar.n(f2, 0.0f);
    }
}
