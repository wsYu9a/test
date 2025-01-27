package com.google.zxing.oned.b0.g;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a */
    private final List<b> f8548a;

    /* renamed from: b */
    private final int f8549b;

    /* renamed from: c */
    private final boolean f8550c;

    c(List<b> list, int i2, boolean z) {
        this.f8548a = new ArrayList(list);
        this.f8549b = i2;
        this.f8550c = z;
    }

    List<b> a() {
        return this.f8548a;
    }

    int b() {
        return this.f8549b;
    }

    boolean c(List<b> list) {
        return this.f8548a.equals(list);
    }

    boolean d() {
        return this.f8550c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f8548a.equals(cVar.a()) && this.f8550c == cVar.f8550c;
    }

    public int hashCode() {
        return this.f8548a.hashCode() ^ Boolean.valueOf(this.f8550c).hashCode();
    }

    public String toString() {
        return "{ " + this.f8548a + " }";
    }
}
