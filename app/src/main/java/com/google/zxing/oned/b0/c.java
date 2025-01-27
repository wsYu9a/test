package com.google.zxing.oned.b0;

import com.google.zxing.l;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    private final int f8539a;

    /* renamed from: b */
    private final int[] f8540b;

    /* renamed from: c */
    private final l[] f8541c;

    public c(int i2, int[] iArr, int i3, int i4, int i5) {
        this.f8539a = i2;
        this.f8540b = iArr;
        float f2 = i5;
        this.f8541c = new l[]{new l(i3, f2), new l(i4, f2)};
    }

    public l[] a() {
        return this.f8541c;
    }

    public int[] b() {
        return this.f8540b;
    }

    public int c() {
        return this.f8539a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f8539a == ((c) obj).f8539a;
    }

    public int hashCode() {
        return this.f8539a;
    }
}
