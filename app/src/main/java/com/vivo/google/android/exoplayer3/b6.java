package com.vivo.google.android.exoplayer3;

import java.util.TreeSet;

/* loaded from: classes4.dex */
public final class b6 {

    /* renamed from: a */
    public final int f27227a;

    /* renamed from: b */
    public final String f27228b;

    /* renamed from: c */
    public final TreeSet<d6> f27229c = new TreeSet<>();

    /* renamed from: d */
    public long f27230d;

    public b6(int i2, String str, long j2) {
        this.f27227a = i2;
        this.f27228b = str;
        this.f27230d = j2;
    }

    public int a() {
        int hashCode = ((this.f27227a * 31) + this.f27228b.hashCode()) * 31;
        long j2 = this.f27230d;
        return hashCode + ((int) (j2 ^ (j2 >>> 32)));
    }

    public long a(long j2, long j3) {
        d6 a2 = a(j2);
        if (!a2.f27152d) {
            long j4 = a2.f27151c;
            if (j4 == -1) {
                j4 = Long.MAX_VALUE;
            }
            return -Math.min(j4, j3);
        }
        long j5 = j2 + j3;
        long j6 = a2.f27150b + a2.f27151c;
        if (j6 < j5) {
            for (d6 d6Var : this.f27229c.tailSet(a2, false)) {
                long j7 = d6Var.f27150b;
                if (j7 > j6) {
                    break;
                }
                j6 = Math.max(j6, j7 + d6Var.f27151c);
                if (j6 >= j5) {
                    break;
                }
            }
        }
        return Math.min(j6 - j2, j3);
    }

    public d6 a(long j2) {
        d6 d6Var = new d6(this.f27228b, j2, -1L, C.TIME_UNSET, null);
        d6 floor = this.f27229c.floor(d6Var);
        if (floor != null && floor.f27150b + floor.f27151c > j2) {
            return floor;
        }
        d6 ceiling = this.f27229c.ceiling(d6Var);
        if (ceiling == null) {
            return new d6(this.f27228b, j2, -1L, C.TIME_UNSET, null);
        }
        return new d6(this.f27228b, j2, ceiling.f27150b - j2, C.TIME_UNSET, null);
    }
}
