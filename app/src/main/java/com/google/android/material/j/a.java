package com.google.android.material.j;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a */
    private final float f7398a;

    public a(float f2) {
        this.f7398a = f2;
    }

    @Override // com.google.android.material.j.d
    public float a(@NonNull RectF rectF) {
        return this.f7398a;
    }

    public float b() {
        return this.f7398a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f7398a == ((a) obj).f7398a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f7398a)});
    }
}
