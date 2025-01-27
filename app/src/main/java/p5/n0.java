package p5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;
import p5.r0;

@a5.a
@a5.c
@m
/* loaded from: classes2.dex */
public abstract class n0 {

    /* renamed from: a */
    public final a f29808a;

    /* renamed from: b */
    @CheckForNull
    public volatile Object f29809b;

    public static abstract class a {

        /* renamed from: p5.n0$a$a */
        public class C0765a extends a {

            /* renamed from: a */
            public final b5.x f29810a = b5.x.c();

            @Override // p5.n0.a
            public long b() {
                return this.f29810a.g(TimeUnit.MICROSECONDS);
            }

            @Override // p5.n0.a
            public void c(long j10) {
                if (j10 > 0) {
                    b1.k(j10, TimeUnit.MICROSECONDS);
                }
            }
        }

        public static a a() {
            return new C0765a();
        }

        public abstract long b();

        public abstract void c(long j10);
    }

    public n0(a aVar) {
        this.f29808a = (a) b5.u.E(aVar);
    }

    public static void d(int i10) {
        b5.u.k(i10 > 0, "Requested permits (%s) must be positive", i10);
    }

    public static n0 e(double d10) {
        return h(d10, a.a());
    }

    public static n0 f(double d10, long j10, TimeUnit timeUnit) {
        b5.u.p(j10 >= 0, "warmupPeriod must not be negative: %s", j10);
        return g(d10, j10, timeUnit, 3.0d, a.a());
    }

    @a5.d
    public static n0 g(double d10, long j10, TimeUnit timeUnit, double d11, a aVar) {
        r0.c cVar = new r0.c(aVar, j10, timeUnit, d11);
        cVar.q(d10);
        return cVar;
    }

    @a5.d
    public static n0 h(double d10, a aVar) {
        r0.b bVar = new r0.b(aVar, 1.0d);
        bVar.q(d10);
        return bVar;
    }

    @CanIgnoreReturnValue
    public double a() {
        return b(1);
    }

    @CanIgnoreReturnValue
    public double b(int i10) {
        long n10 = n(i10);
        this.f29808a.c(n10);
        return (n10 * 1.0d) / TimeUnit.SECONDS.toMicros(1L);
    }

    public final boolean c(long j10, long j11) {
        return m(j10) - j11 <= j10;
    }

    public abstract double i();

    public abstract void j(double d10, long j10);

    public final double k() {
        double i10;
        synchronized (l()) {
            i10 = i();
        }
        return i10;
    }

    public final Object l() {
        Object obj = this.f29809b;
        if (obj == null) {
            synchronized (this) {
                try {
                    obj = this.f29809b;
                    if (obj == null) {
                        obj = new Object();
                        this.f29809b = obj;
                    }
                } finally {
                }
            }
        }
        return obj;
    }

    public abstract long m(long j10);

    public final long n(int i10) {
        long o10;
        d(i10);
        synchronized (l()) {
            o10 = o(i10, this.f29808a.b());
        }
        return o10;
    }

    public final long o(int i10, long j10) {
        return Math.max(p(i10, j10) - j10, 0L);
    }

    public abstract long p(int i10, long j10);

    public final void q(double d10) {
        b5.u.e(d10 > l5.c.f27899e && !Double.isNaN(d10), "rate must be positive");
        synchronized (l()) {
            j(d10, this.f29808a.b());
        }
    }

    public boolean r() {
        return t(1, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean s(int i10) {
        return t(i10, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean t(int i10, long j10, TimeUnit timeUnit) {
        long max = Math.max(timeUnit.toMicros(j10), 0L);
        d(i10);
        synchronized (l()) {
            try {
                long b10 = this.f29808a.b();
                if (!c(b10, max)) {
                    return false;
                }
                this.f29808a.c(o(i10, b10));
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", Double.valueOf(k()));
    }

    public boolean u(long j10, TimeUnit timeUnit) {
        return t(1, j10, timeUnit);
    }
}
