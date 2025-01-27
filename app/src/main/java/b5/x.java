package b5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.TimeUnit;

@a5.b(emulated = true)
@g
/* loaded from: classes2.dex */
public final class x {

    /* renamed from: a */
    public final b0 f1279a;

    /* renamed from: b */
    public boolean f1280b;

    /* renamed from: c */
    public long f1281c;

    /* renamed from: d */
    public long f1282d;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f1283a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f1283a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1283a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1283a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1283a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1283a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1283a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1283a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public x() {
        this.f1279a = b0.b();
    }

    public static String a(TimeUnit timeUnit) {
        switch (a.f1283a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }

    public static TimeUnit b(long j10) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(j10, timeUnit2) > 0) {
            return timeUnit;
        }
        TimeUnit timeUnit3 = TimeUnit.HOURS;
        if (timeUnit3.convert(j10, timeUnit2) > 0) {
            return timeUnit3;
        }
        TimeUnit timeUnit4 = TimeUnit.MINUTES;
        if (timeUnit4.convert(j10, timeUnit2) > 0) {
            return timeUnit4;
        }
        TimeUnit timeUnit5 = TimeUnit.SECONDS;
        if (timeUnit5.convert(j10, timeUnit2) > 0) {
            return timeUnit5;
        }
        TimeUnit timeUnit6 = TimeUnit.MILLISECONDS;
        if (timeUnit6.convert(j10, timeUnit2) > 0) {
            return timeUnit6;
        }
        TimeUnit timeUnit7 = TimeUnit.MICROSECONDS;
        return timeUnit7.convert(j10, timeUnit2) > 0 ? timeUnit7 : timeUnit2;
    }

    public static x c() {
        return new x().k();
    }

    public static x d(b0 b0Var) {
        return new x(b0Var).k();
    }

    public static x e() {
        return new x();
    }

    public static x f(b0 b0Var) {
        return new x(b0Var);
    }

    public long g(TimeUnit timeUnit) {
        return timeUnit.convert(h(), TimeUnit.NANOSECONDS);
    }

    public final long h() {
        return this.f1280b ? (this.f1279a.a() - this.f1282d) + this.f1281c : this.f1281c;
    }

    public boolean i() {
        return this.f1280b;
    }

    @CanIgnoreReturnValue
    public x j() {
        this.f1281c = 0L;
        this.f1280b = false;
        return this;
    }

    @CanIgnoreReturnValue
    public x k() {
        u.h0(!this.f1280b, "This stopwatch is already running.");
        this.f1280b = true;
        this.f1282d = this.f1279a.a();
        return this;
    }

    @CanIgnoreReturnValue
    public x l() {
        long a10 = this.f1279a.a();
        u.h0(this.f1280b, "This stopwatch is already stopped.");
        this.f1280b = false;
        this.f1281c += a10 - this.f1282d;
        return this;
    }

    public String toString() {
        long h10 = h();
        TimeUnit b10 = b(h10);
        String d10 = com.google.common.base.b.d(h10 / TimeUnit.NANOSECONDS.convert(1L, b10));
        String a10 = a(b10);
        StringBuilder sb2 = new StringBuilder(String.valueOf(d10).length() + 1 + String.valueOf(a10).length());
        sb2.append(d10);
        sb2.append(" ");
        sb2.append(a10);
        return sb2.toString();
    }

    public x(b0 b0Var) {
        this.f1279a = (b0) u.F(b0Var, "ticker");
    }
}
