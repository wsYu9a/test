package com.vivo.mobilead.lottie;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class h<V> {

    /* renamed from: a */
    private final V f29485a;

    /* renamed from: b */
    private final Throwable f29486b;

    public h(V v) {
        this.f29485a = v;
        this.f29486b = null;
    }

    public h(Throwable th) {
        this.f29486b = th;
        this.f29485a = null;
    }

    public V a() {
        return this.f29485a;
    }

    public Throwable b() {
        return this.f29486b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (a() != null && a().equals(hVar.a())) {
            return true;
        }
        if (b() == null || hVar.b() == null) {
            return false;
        }
        return b().toString().equals(b().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{a(), b()});
    }
}
