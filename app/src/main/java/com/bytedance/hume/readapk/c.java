package com.bytedance.hume.readapk;

/* loaded from: classes.dex */
public final class c<A, B> {

    /* renamed from: a, reason: collision with root package name */
    private final A f5969a;

    /* renamed from: b, reason: collision with root package name */
    private final B f5970b;

    private c(A a2, B b2) {
        this.f5969a = a2;
        this.f5970b = b2;
    }

    public static <A, B> c<A, B> a(A a2, B b2) {
        return new c<>(a2, b2);
    }

    public A a() {
        return this.f5969a;
    }

    public B b() {
        return this.f5970b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        A a2 = this.f5969a;
        if (a2 == null) {
            if (cVar.f5969a != null) {
                return false;
            }
        } else if (!a2.equals(cVar.f5969a)) {
            return false;
        }
        B b2 = this.f5970b;
        B b3 = cVar.f5970b;
        if (b2 == null) {
            if (b3 != null) {
                return false;
            }
        } else if (!b2.equals(b3)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a2 = this.f5969a;
        int hashCode = ((a2 == null ? 0 : a2.hashCode()) + 31) * 31;
        B b2 = this.f5970b;
        return hashCode + (b2 != null ? b2.hashCode() : 0);
    }
}
