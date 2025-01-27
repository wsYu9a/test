package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* loaded from: classes.dex */
class f {

    /* renamed from: a */
    private static final int f8695a = 5;

    /* renamed from: b */
    private final c f8696b;

    /* renamed from: c */
    private final d[] f8697c;

    f(c cVar) {
        this.f8696b = new c(cVar);
        this.f8697c = new d[(cVar.f() - cVar.h()) + 1];
    }

    final c a() {
        return this.f8696b;
    }

    final d b(int i2) {
        return this.f8697c[e(i2)];
    }

    final d c(int i2) {
        d dVar;
        d dVar2;
        d b2 = b(i2);
        if (b2 != null) {
            return b2;
        }
        for (int i3 = 1; i3 < 5; i3++) {
            int e2 = e(i2) - i3;
            if (e2 >= 0 && (dVar2 = this.f8697c[e2]) != null) {
                return dVar2;
            }
            int e3 = e(i2) + i3;
            d[] dVarArr = this.f8697c;
            if (e3 < dVarArr.length && (dVar = dVarArr[e3]) != null) {
                return dVar;
            }
        }
        return null;
    }

    final d[] d() {
        return this.f8697c;
    }

    final int e(int i2) {
        return i2 - this.f8696b.h();
    }

    final void f(int i2, d dVar) {
        this.f8697c[e(i2)] = dVar;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        int i2 = 0;
        for (d dVar : this.f8697c) {
            if (dVar == null) {
                formatter.format("%3d:    |   %n", Integer.valueOf(i2));
                i2++;
            } else {
                formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i2), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                i2++;
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
