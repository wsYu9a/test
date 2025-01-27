package com.google.common.math;

import b5.u;
import com.google.errorprone.annotations.concurrent.LazyInit;
import javax.annotation.CheckForNull;

@a5.a
@a5.c
@l5.e
/* loaded from: classes2.dex */
public abstract class a {

    public static final class b {

        /* renamed from: a */
        public final double f10166a;

        /* renamed from: b */
        public final double f10167b;

        public /* synthetic */ b(double d10, double d11, C0302a c0302a) {
            this(d10, d11);
        }

        public a a(double d10, double d11) {
            u.d(l5.d.d(d10) && l5.d.d(d11));
            double d12 = this.f10166a;
            if (d10 != d12) {
                return b((d11 - this.f10167b) / (d10 - d12));
            }
            u.d(d11 != this.f10167b);
            return new e(this.f10166a);
        }

        public a b(double d10) {
            u.d(!Double.isNaN(d10));
            return l5.d.d(d10) ? new d(d10, this.f10167b - (this.f10166a * d10)) : new e(this.f10166a);
        }

        public b(double d10, double d11) {
            this.f10166a = d10;
            this.f10167b = d11;
        }
    }

    public static final class c extends a {

        /* renamed from: a */
        public static final c f10168a = new c();

        @Override // com.google.common.math.a
        public a c() {
            return this;
        }

        @Override // com.google.common.math.a
        public boolean d() {
            return false;
        }

        @Override // com.google.common.math.a
        public boolean e() {
            return false;
        }

        @Override // com.google.common.math.a
        public double g() {
            return Double.NaN;
        }

        @Override // com.google.common.math.a
        public double h(double d10) {
            return Double.NaN;
        }

        public String toString() {
            return "NaN";
        }
    }

    public static a a() {
        return c.f10168a;
    }

    public static a b(double d10) {
        u.d(l5.d.d(d10));
        return new d(l5.c.f27899e, d10);
    }

    public static b f(double d10, double d11) {
        u.d(l5.d.d(d10) && l5.d.d(d11));
        return new b(d10, d11);
    }

    public static a i(double d10) {
        u.d(l5.d.d(d10));
        return new e(d10);
    }

    public abstract a c();

    public abstract boolean d();

    public abstract boolean e();

    public abstract double g();

    public abstract double h(double d10);

    public static final class e extends a {

        /* renamed from: a */
        public final double f10172a;

        /* renamed from: b */
        @CheckForNull
        @LazyInit
        public a f10173b;

        public e(double d10) {
            this.f10172a = d10;
            this.f10173b = null;
        }

        private a j() {
            return new d(l5.c.f27899e, this.f10172a, this);
        }

        @Override // com.google.common.math.a
        public a c() {
            a aVar = this.f10173b;
            if (aVar != null) {
                return aVar;
            }
            a j10 = j();
            this.f10173b = j10;
            return j10;
        }

        @Override // com.google.common.math.a
        public boolean d() {
            return false;
        }

        @Override // com.google.common.math.a
        public boolean e() {
            return true;
        }

        @Override // com.google.common.math.a
        public double g() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.math.a
        public double h(double d10) {
            throw new IllegalStateException();
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f10172a));
        }

        public e(double d10, a aVar) {
            this.f10172a = d10;
            this.f10173b = aVar;
        }
    }

    public static final class d extends a {

        /* renamed from: a */
        public final double f10169a;

        /* renamed from: b */
        public final double f10170b;

        /* renamed from: c */
        @CheckForNull
        @LazyInit
        public a f10171c;

        public d(double d10, double d11) {
            this.f10169a = d10;
            this.f10170b = d11;
            this.f10171c = null;
        }

        @Override // com.google.common.math.a
        public a c() {
            a aVar = this.f10171c;
            if (aVar != null) {
                return aVar;
            }
            a j10 = j();
            this.f10171c = j10;
            return j10;
        }

        @Override // com.google.common.math.a
        public boolean d() {
            return this.f10169a == l5.c.f27899e;
        }

        @Override // com.google.common.math.a
        public boolean e() {
            return false;
        }

        @Override // com.google.common.math.a
        public double g() {
            return this.f10169a;
        }

        @Override // com.google.common.math.a
        public double h(double d10) {
            return (d10 * this.f10169a) + this.f10170b;
        }

        public final a j() {
            double d10 = this.f10169a;
            return d10 != l5.c.f27899e ? new d(1.0d / d10, (this.f10170b * (-1.0d)) / d10, this) : new e(this.f10170b, this);
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.f10169a), Double.valueOf(this.f10170b));
        }

        public d(double d10, double d11, a aVar) {
            this.f10169a = d10;
            this.f10170b = d11;
            this.f10171c = aVar;
        }
    }
}
