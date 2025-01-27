package com.vivo.mobilead.lottie.c;

import android.util.Pair;

/* loaded from: classes4.dex */
public class i<T> {

    /* renamed from: a */
    T f29402a;

    /* renamed from: b */
    T f29403b;

    private static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void a(T t, T t2) {
        this.f29402a = t;
        this.f29403b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return b(pair.first, this.f29402a) && b(pair.second, this.f29403b);
    }

    public int hashCode() {
        T t = this.f29402a;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f29403b;
        return hashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f29402a) + " " + String.valueOf(this.f29403b) + "}";
    }
}
