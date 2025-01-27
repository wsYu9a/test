package com.google.zxing.oned.b0;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f8537a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8538b;

    public b(int i2, int i3) {
        this.f8537a = i2;
        this.f8538b = i3;
    }

    public final int a() {
        return this.f8538b;
    }

    public final int b() {
        return this.f8537a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f8537a == bVar.f8537a && this.f8538b == bVar.f8538b;
    }

    public final int hashCode() {
        return this.f8537a ^ this.f8538b;
    }

    public final String toString() {
        return this.f8537a + "(" + this.f8538b + ')';
    }
}
