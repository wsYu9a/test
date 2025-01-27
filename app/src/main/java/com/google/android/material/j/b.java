package com.google.android.material.j;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: a */
    private final d f7399a;

    /* renamed from: b */
    private final float f7400b;

    public b(float f2, @NonNull d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).f7399a;
            f2 += ((b) dVar).f7400b;
        }
        this.f7399a = dVar;
        this.f7400b = f2;
    }

    @Override // com.google.android.material.j.d
    public float a(@NonNull RectF rectF) {
        return Math.max(0.0f, this.f7399a.a(rectF) + this.f7400b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f7399a.equals(bVar.f7399a) && this.f7400b == bVar.f7400b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7399a, Float.valueOf(this.f7400b)});
    }
}
