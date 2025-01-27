package com.google.android.material.j;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class l extends g {

    /* renamed from: a */
    private final g f7435a;

    /* renamed from: b */
    private final float f7436b;

    public l(@NonNull g gVar, float f2) {
        this.f7435a = gVar;
        this.f7436b = f2;
    }

    @Override // com.google.android.material.j.g
    boolean a() {
        return this.f7435a.a();
    }

    @Override // com.google.android.material.j.g
    public void b(float f2, float f3, float f4, @NonNull q qVar) {
        this.f7435a.b(f2, f3 - this.f7436b, f4, qVar);
    }
}
