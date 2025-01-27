package com.google.common.math;

import a5.c;
import b5.u;
import com.google.common.primitives.Doubles;
import l5.e;
import l5.j;

@a5.a
@c
@e
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    public final j f10174a = new j();

    /* renamed from: b */
    public final j f10175b = new j();

    /* renamed from: c */
    public double f10176c = l5.c.f27899e;

    public static double d(double d10) {
        return Doubles.f(d10, -1.0d, 1.0d);
    }

    public void a(double d10, double d11) {
        this.f10174a.a(d10);
        if (!Doubles.n(d10) || !Doubles.n(d11)) {
            this.f10176c = Double.NaN;
        } else if (this.f10174a.j() > 1) {
            this.f10176c += (d10 - this.f10174a.l()) * (d11 - this.f10175b.l());
        }
        this.f10175b.a(d11);
    }

    public void b(PairedStats pairedStats) {
        if (pairedStats.count() == 0) {
            return;
        }
        this.f10174a.b(pairedStats.xStats());
        if (this.f10175b.j() == 0) {
            this.f10176c = pairedStats.sumOfProductsOfDeltas();
        } else {
            this.f10176c += pairedStats.sumOfProductsOfDeltas() + ((pairedStats.xStats().mean() - this.f10174a.l()) * (pairedStats.yStats().mean() - this.f10175b.l()) * pairedStats.count());
        }
        this.f10175b.b(pairedStats.yStats());
    }

    public long c() {
        return this.f10174a.j();
    }

    public final double e(double d10) {
        if (d10 > l5.c.f27899e) {
            return d10;
        }
        return Double.MIN_VALUE;
    }

    public final a f() {
        u.g0(c() > 1);
        if (Double.isNaN(this.f10176c)) {
            return a.a();
        }
        double u10 = this.f10174a.u();
        if (u10 > l5.c.f27899e) {
            return this.f10175b.u() > l5.c.f27899e ? a.f(this.f10174a.l(), this.f10175b.l()).b(this.f10176c / u10) : a.b(this.f10175b.l());
        }
        u.g0(this.f10175b.u() > l5.c.f27899e);
        return a.i(this.f10174a.l());
    }

    public final double g() {
        u.g0(c() > 1);
        if (Double.isNaN(this.f10176c)) {
            return Double.NaN;
        }
        double u10 = this.f10174a.u();
        double u11 = this.f10175b.u();
        u.g0(u10 > l5.c.f27899e);
        u.g0(u11 > l5.c.f27899e);
        return d(this.f10176c / Math.sqrt(e(u10 * u11)));
    }

    public double h() {
        u.g0(c() != 0);
        return this.f10176c / c();
    }

    public final double i() {
        u.g0(c() > 1);
        return this.f10176c / (c() - 1);
    }

    public PairedStats j() {
        return new PairedStats(this.f10174a.s(), this.f10175b.s(), this.f10176c);
    }

    public Stats k() {
        return this.f10174a.s();
    }

    public Stats l() {
        return this.f10175b.s();
    }
}
