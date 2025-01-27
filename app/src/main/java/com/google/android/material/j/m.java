package com.google.android.material.j;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class m implements d {

    /* renamed from: a */
    private final float f7437a;

    public m(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f7437a = f2;
    }

    @Override // com.google.android.material.j.d
    public float a(@NonNull RectF rectF) {
        return this.f7437a * rectF.height();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float b() {
        return this.f7437a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && this.f7437a == ((m) obj).f7437a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f7437a)});
    }
}
