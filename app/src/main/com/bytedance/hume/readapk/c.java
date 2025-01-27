package com.bytedance.hume.readapk;

/* loaded from: classes2.dex */
public final class c<A, B> {

    /* renamed from: a, reason: collision with root package name */
    private final A f7446a;

    /* renamed from: b, reason: collision with root package name */
    private final B f7447b;

    private c(A a10, B b10) {
        this.f7446a = a10;
        this.f7447b = b10;
    }

    public static <A, B> c<A, B> a(A a10, B b10) {
        return new c<>(a10, b10);
    }

    public B b() {
        return this.f7447b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        A a10 = this.f7446a;
        if (a10 == null) {
            if (cVar.f7446a != null) {
                return false;
            }
        } else if (!a10.equals(cVar.f7446a)) {
            return false;
        }
        B b10 = this.f7447b;
        B b11 = cVar.f7447b;
        if (b10 == null) {
            if (b11 != null) {
                return false;
            }
        } else if (!b10.equals(b11)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a10 = this.f7446a;
        int hashCode = ((a10 == null ? 0 : a10.hashCode()) + 31) * 31;
        B b10 = this.f7447b;
        return hashCode + (b10 != null ? b10.hashCode() : 0);
    }

    public A a() {
        return this.f7446a;
    }
}
