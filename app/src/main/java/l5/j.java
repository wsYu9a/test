package l5;

import b5.u;
import com.google.common.math.Stats;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

@a5.a
@a5.c
@e
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a */
    public long f27924a = 0;

    /* renamed from: b */
    public double f27925b = c.f27899e;

    /* renamed from: c */
    public double f27926c = c.f27899e;

    /* renamed from: d */
    public double f27927d = Double.NaN;

    /* renamed from: e */
    public double f27928e = Double.NaN;

    public static double i(double d10, double d11) {
        if (Doubles.n(d10)) {
            return d11;
        }
        if (Doubles.n(d11) || d10 == d11) {
            return d10;
        }
        return Double.NaN;
    }

    public void a(double d10) {
        long j10 = this.f27924a;
        if (j10 == 0) {
            this.f27924a = 1L;
            this.f27925b = d10;
            this.f27927d = d10;
            this.f27928e = d10;
            if (Doubles.n(d10)) {
                return;
            }
            this.f27926c = Double.NaN;
            return;
        }
        this.f27924a = j10 + 1;
        if (Doubles.n(d10) && Doubles.n(this.f27925b)) {
            double d11 = this.f27925b;
            double d12 = d10 - d11;
            double d13 = d11 + (d12 / this.f27924a);
            this.f27925b = d13;
            this.f27926c += d12 * (d10 - d13);
        } else {
            this.f27925b = i(this.f27925b, d10);
            this.f27926c = Double.NaN;
        }
        this.f27927d = Math.min(this.f27927d, d10);
        this.f27928e = Math.max(this.f27928e, d10);
    }

    public void b(Stats stats) {
        if (stats.count() == 0) {
            return;
        }
        m(stats.count(), stats.mean(), stats.sumOfSquaresOfDeltas(), stats.min(), stats.max());
    }

    public void c(Iterable<? extends Number> iterable) {
        Iterator<? extends Number> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void d(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void e(j jVar) {
        if (jVar.j() == 0) {
            return;
        }
        m(jVar.j(), jVar.l(), jVar.u(), jVar.n(), jVar.k());
    }

    public void f(double... dArr) {
        for (double d10 : dArr) {
            a(d10);
        }
    }

    public void g(int... iArr) {
        for (int i10 : iArr) {
            a(i10);
        }
    }

    public void h(long... jArr) {
        for (long j10 : jArr) {
            a(j10);
        }
    }

    public long j() {
        return this.f27924a;
    }

    public double k() {
        u.g0(this.f27924a != 0);
        return this.f27928e;
    }

    public double l() {
        u.g0(this.f27924a != 0);
        return this.f27925b;
    }

    public final void m(long j10, double d10, double d11, double d12, double d13) {
        long j11 = this.f27924a;
        if (j11 == 0) {
            this.f27924a = j10;
            this.f27925b = d10;
            this.f27926c = d11;
            this.f27927d = d12;
            this.f27928e = d13;
            return;
        }
        this.f27924a = j11 + j10;
        if (Doubles.n(this.f27925b) && Doubles.n(d10)) {
            double d14 = this.f27925b;
            double d15 = d10 - d14;
            double d16 = j10;
            double d17 = d14 + ((d15 * d16) / this.f27924a);
            this.f27925b = d17;
            this.f27926c += d11 + (d15 * (d10 - d17) * d16);
        } else {
            this.f27925b = i(this.f27925b, d10);
            this.f27926c = Double.NaN;
        }
        this.f27927d = Math.min(this.f27927d, d12);
        this.f27928e = Math.max(this.f27928e, d13);
    }

    public double n() {
        u.g0(this.f27924a != 0);
        return this.f27927d;
    }

    public final double o() {
        return Math.sqrt(p());
    }

    public final double p() {
        u.g0(this.f27924a != 0);
        if (Double.isNaN(this.f27926c)) {
            return Double.NaN;
        }
        return this.f27924a == 1 ? c.f27899e : d.b(this.f27926c) / this.f27924a;
    }

    public final double q() {
        return Math.sqrt(r());
    }

    public final double r() {
        u.g0(this.f27924a > 1);
        if (Double.isNaN(this.f27926c)) {
            return Double.NaN;
        }
        return d.b(this.f27926c) / (this.f27924a - 1);
    }

    public Stats s() {
        return new Stats(this.f27924a, this.f27925b, this.f27926c, this.f27927d, this.f27928e);
    }

    public final double t() {
        return this.f27925b * this.f27924a;
    }

    public double u() {
        return this.f27926c;
    }
}
