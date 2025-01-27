package d5;

import b5.r;
import b5.u;
import com.google.common.math.LongMath;
import javax.annotation.CheckForNull;

@a5.b
@d
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    public final long f25249a;

    /* renamed from: b */
    public final long f25250b;

    /* renamed from: c */
    public final long f25251c;

    /* renamed from: d */
    public final long f25252d;

    /* renamed from: e */
    public final long f25253e;

    /* renamed from: f */
    public final long f25254f;

    public c(long j10, long j11, long j12, long j13, long j14, long j15) {
        u.d(j10 >= 0);
        u.d(j11 >= 0);
        u.d(j12 >= 0);
        u.d(j13 >= 0);
        u.d(j14 >= 0);
        u.d(j15 >= 0);
        this.f25249a = j10;
        this.f25250b = j11;
        this.f25251c = j12;
        this.f25252d = j13;
        this.f25253e = j14;
        this.f25254f = j15;
    }

    public double a() {
        long x10 = LongMath.x(this.f25251c, this.f25252d);
        return x10 == 0 ? l5.c.f27899e : this.f25253e / x10;
    }

    public long b() {
        return this.f25254f;
    }

    public long c() {
        return this.f25249a;
    }

    public double d() {
        long m10 = m();
        if (m10 == 0) {
            return 1.0d;
        }
        return this.f25249a / m10;
    }

    public long e() {
        return LongMath.x(this.f25251c, this.f25252d);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f25249a == cVar.f25249a && this.f25250b == cVar.f25250b && this.f25251c == cVar.f25251c && this.f25252d == cVar.f25252d && this.f25253e == cVar.f25253e && this.f25254f == cVar.f25254f;
    }

    public long f() {
        return this.f25252d;
    }

    public double g() {
        long x10 = LongMath.x(this.f25251c, this.f25252d);
        return x10 == 0 ? l5.c.f27899e : this.f25252d / x10;
    }

    public long h() {
        return this.f25251c;
    }

    public int hashCode() {
        return r.b(Long.valueOf(this.f25249a), Long.valueOf(this.f25250b), Long.valueOf(this.f25251c), Long.valueOf(this.f25252d), Long.valueOf(this.f25253e), Long.valueOf(this.f25254f));
    }

    public c i(c cVar) {
        return new c(Math.max(0L, LongMath.A(this.f25249a, cVar.f25249a)), Math.max(0L, LongMath.A(this.f25250b, cVar.f25250b)), Math.max(0L, LongMath.A(this.f25251c, cVar.f25251c)), Math.max(0L, LongMath.A(this.f25252d, cVar.f25252d)), Math.max(0L, LongMath.A(this.f25253e, cVar.f25253e)), Math.max(0L, LongMath.A(this.f25254f, cVar.f25254f)));
    }

    public long j() {
        return this.f25250b;
    }

    public double k() {
        long m10 = m();
        return m10 == 0 ? l5.c.f27899e : this.f25250b / m10;
    }

    public c l(c cVar) {
        return new c(LongMath.x(this.f25249a, cVar.f25249a), LongMath.x(this.f25250b, cVar.f25250b), LongMath.x(this.f25251c, cVar.f25251c), LongMath.x(this.f25252d, cVar.f25252d), LongMath.x(this.f25253e, cVar.f25253e), LongMath.x(this.f25254f, cVar.f25254f));
    }

    public long m() {
        return LongMath.x(this.f25249a, this.f25250b);
    }

    public long n() {
        return this.f25253e;
    }

    public String toString() {
        return com.google.common.base.a.c(this).e("hitCount", this.f25249a).e("missCount", this.f25250b).e("loadSuccessCount", this.f25251c).e("loadExceptionCount", this.f25252d).e("totalLoadTime", this.f25253e).e("evictionCount", this.f25254f).toString();
    }
}
