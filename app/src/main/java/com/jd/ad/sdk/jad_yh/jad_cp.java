package com.jd.ad.sdk.jad_yh;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* loaded from: classes2.dex */
public class jad_cp<T> {
    public final jad_bo<T> jad_an;

    @Nullable
    public T jad_bo;

    public jad_cp() {
        this.jad_an = new jad_bo<>();
        this.jad_bo = null;
    }

    @Nullable
    public T jad_an(jad_bo<T> jad_boVar) {
        return this.jad_bo;
    }

    public jad_cp(@Nullable T t10) {
        this.jad_an = new jad_bo<>();
        this.jad_bo = t10;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T jad_an(float f10, float f11, T t10, T t11, float f12, float f13, float f14) {
        jad_bo<T> jad_boVar = this.jad_an;
        jad_boVar.jad_an = t10;
        jad_boVar.jad_bo = t11;
        return jad_an(jad_boVar);
    }
}
