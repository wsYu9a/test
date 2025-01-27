package o6;

import java.util.Formatter;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: c */
    public static final int f29091c = 5;

    /* renamed from: a */
    public final c f29092a;

    /* renamed from: b */
    public final d[] f29093b;

    public f(c cVar) {
        this.f29092a = new c(cVar);
        this.f29093b = new d[(cVar.f() - cVar.h()) + 1];
    }

    public final c a() {
        return this.f29092a;
    }

    public final d b(int i10) {
        return this.f29093b[e(i10)];
    }

    public final d c(int i10) {
        d dVar;
        d dVar2;
        d b10 = b(i10);
        if (b10 != null) {
            return b10;
        }
        for (int i11 = 1; i11 < 5; i11++) {
            int e10 = e(i10) - i11;
            if (e10 >= 0 && (dVar2 = this.f29093b[e10]) != null) {
                return dVar2;
            }
            int e11 = e(i10) + i11;
            d[] dVarArr = this.f29093b;
            if (e11 < dVarArr.length && (dVar = dVarArr[e11]) != null) {
                return dVar;
            }
        }
        return null;
    }

    public final d[] d() {
        return this.f29093b;
    }

    public final int e(int i10) {
        return i10 - this.f29092a.h();
    }

    public final void f(int i10, d dVar) {
        this.f29093b[e(i10)] = dVar;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        int i10 = 0;
        for (d dVar : this.f29093b) {
            if (dVar == null) {
                formatter.format("%3d:    |   %n", Integer.valueOf(i10));
                i10++;
            } else {
                formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i10), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                i10++;
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
