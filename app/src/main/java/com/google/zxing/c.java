package com.google.zxing;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final int f8202a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8203b;

    public c(int i2, int i3) {
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException();
        }
        this.f8202a = i2;
        this.f8203b = i3;
    }

    public int a() {
        return this.f8203b;
    }

    public int b() {
        return this.f8202a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f8202a == cVar.f8202a && this.f8203b == cVar.f8203b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f8202a * 32713) + this.f8203b;
    }

    public String toString() {
        return this.f8202a + "x" + this.f8203b;
    }
}
