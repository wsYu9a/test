package p5;

import com.google.common.math.LongMath;
import java.util.concurrent.TimeUnit;
import p5.n0;

@a5.c
@m
/* loaded from: classes2.dex */
public abstract class r0 extends n0 {

    /* renamed from: c */
    public double f29821c;

    /* renamed from: d */
    public double f29822d;

    /* renamed from: e */
    public double f29823e;

    /* renamed from: f */
    public long f29824f;

    public static final class b extends r0 {

        /* renamed from: g */
        public final double f29825g;

        public b(n0.a aVar, double d10) {
            super(aVar);
            this.f29825g = d10;
        }

        @Override // p5.r0
        public double v() {
            return this.f29823e;
        }

        @Override // p5.r0
        public void w(double d10, double d11) {
            double d12 = this.f29822d;
            double d13 = this.f29825g * d10;
            this.f29822d = d13;
            if (d12 == Double.POSITIVE_INFINITY) {
                this.f29821c = d13;
                return;
            }
            double d14 = l5.c.f27899e;
            if (d12 != l5.c.f27899e) {
                d14 = (this.f29821c * d13) / d12;
            }
            this.f29821c = d14;
        }

        @Override // p5.r0
        public long y(double d10, double d11) {
            return 0L;
        }
    }

    public static final class c extends r0 {

        /* renamed from: g */
        public final long f29826g;

        /* renamed from: h */
        public double f29827h;

        /* renamed from: i */
        public double f29828i;

        /* renamed from: j */
        public double f29829j;

        public c(n0.a aVar, long j10, TimeUnit timeUnit, double d10) {
            super(aVar);
            this.f29826g = timeUnit.toMicros(j10);
            this.f29829j = d10;
        }

        @Override // p5.r0
        public double v() {
            return this.f29826g / this.f29822d;
        }

        @Override // p5.r0
        public void w(double d10, double d11) {
            double d12 = this.f29822d;
            double d13 = this.f29829j * d11;
            long j10 = this.f29826g;
            double d14 = (j10 * 0.5d) / d11;
            this.f29828i = d14;
            double d15 = ((j10 * 2.0d) / (d11 + d13)) + d14;
            this.f29822d = d15;
            this.f29827h = (d13 - d11) / (d15 - d14);
            if (d12 == Double.POSITIVE_INFINITY) {
                this.f29821c = l5.c.f27899e;
                return;
            }
            if (d12 != l5.c.f27899e) {
                d15 = (this.f29821c * d15) / d12;
            }
            this.f29821c = d15;
        }

        @Override // p5.r0
        public long y(double d10, double d11) {
            long j10;
            double d12 = d10 - this.f29828i;
            if (d12 > l5.c.f27899e) {
                double min = Math.min(d12, d11);
                j10 = (long) (((z(d12) + z(d12 - min)) * min) / 2.0d);
                d11 -= min;
            } else {
                j10 = 0;
            }
            return j10 + ((long) (this.f29823e * d11));
        }

        public final double z(double d10) {
            return this.f29823e + (d10 * this.f29827h);
        }
    }

    public /* synthetic */ r0(n0.a aVar, a aVar2) {
        this(aVar);
    }

    @Override // p5.n0
    public final double i() {
        return TimeUnit.SECONDS.toMicros(1L) / this.f29823e;
    }

    @Override // p5.n0
    public final void j(double d10, long j10) {
        x(j10);
        double micros = TimeUnit.SECONDS.toMicros(1L) / d10;
        this.f29823e = micros;
        w(d10, micros);
    }

    @Override // p5.n0
    public final long m(long j10) {
        return this.f29824f;
    }

    @Override // p5.n0
    public final long p(int i10, long j10) {
        x(j10);
        long j11 = this.f29824f;
        double d10 = i10;
        double min = Math.min(d10, this.f29821c);
        this.f29824f = LongMath.x(this.f29824f, y(this.f29821c, min) + ((long) ((d10 - min) * this.f29823e)));
        this.f29821c -= min;
        return j11;
    }

    public abstract double v();

    public abstract void w(double d10, double d11);

    public void x(long j10) {
        if (j10 > this.f29824f) {
            this.f29821c = Math.min(this.f29822d, this.f29821c + ((j10 - r0) / v()));
            this.f29824f = j10;
        }
    }

    public abstract long y(double d10, double d11);

    public r0(n0.a aVar) {
        super(aVar);
        this.f29824f = 0L;
    }
}
