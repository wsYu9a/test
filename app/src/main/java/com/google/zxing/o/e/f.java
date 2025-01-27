package com.google.zxing.o.e;

import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
final class f {

    /* renamed from: a */
    static final f f8495a = new f(g.f8500a, 0, 0, 0);

    /* renamed from: b */
    private final int f8496b;

    /* renamed from: c */
    private final g f8497c;

    /* renamed from: d */
    private final int f8498d;

    /* renamed from: e */
    private final int f8499e;

    private f(g gVar, int i2, int i3, int i4) {
        this.f8497c = gVar;
        this.f8496b = i2;
        this.f8498d = i3;
        this.f8499e = i4;
    }

    f a(int i2) {
        g gVar = this.f8497c;
        int i3 = this.f8496b;
        int i4 = this.f8499e;
        if (i3 == 4 || i3 == 2) {
            int i5 = d.f8488g[i3][0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            gVar = gVar.a(i6, i7);
            i4 += i7;
            i3 = 0;
        }
        int i8 = this.f8498d;
        f fVar = new f(gVar, i3, i8 + 1, i4 + ((i8 == 0 || i8 == 31) ? 18 : i8 == 62 ? 9 : 8));
        return fVar.f8498d == 2078 ? fVar.b(i2 + 1) : fVar;
    }

    f b(int i2) {
        int i3 = this.f8498d;
        return i3 == 0 ? this : new f(this.f8497c.b(i2 - i3, i3), this.f8496b, 0, this.f8499e);
    }

    int c() {
        return this.f8498d;
    }

    int d() {
        return this.f8499e;
    }

    int e() {
        return this.f8496b;
    }

    g f() {
        return this.f8497c;
    }

    boolean g(f fVar) {
        int i2;
        int i3 = this.f8499e + (d.f8488g[this.f8496b][fVar.f8496b] >> 16);
        int i4 = fVar.f8498d;
        if (i4 > 0 && ((i2 = this.f8498d) == 0 || i2 > i4)) {
            i3 += 10;
        }
        return i3 <= fVar.f8499e;
    }

    f h(int i2, int i3) {
        int i4 = this.f8499e;
        g gVar = this.f8497c;
        int i5 = this.f8496b;
        if (i2 != i5) {
            int i6 = d.f8488g[i5][i2];
            int i7 = 65535 & i6;
            int i8 = i6 >> 16;
            gVar = gVar.a(i7, i8);
            i4 += i8;
        }
        int i9 = i2 == 2 ? 4 : 5;
        return new f(gVar.a(i3, i9), i2, 0, i4 + i9);
    }

    f i(int i2, int i3) {
        g gVar = this.f8497c;
        int i4 = this.f8496b;
        int i5 = i4 == 2 ? 4 : 5;
        return new f(gVar.a(d.f8490i[i4][i2], i5).a(i3, 5), this.f8496b, 0, this.f8499e + i5 + 5);
    }

    com.google.zxing.common.a j(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (g gVar = b(bArr.length).f8497c; gVar != null; gVar = gVar.d()) {
            linkedList.addFirst(gVar);
        }
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", d.f8482a[this.f8496b], Integer.valueOf(this.f8499e), Integer.valueOf(this.f8498d));
    }
}
