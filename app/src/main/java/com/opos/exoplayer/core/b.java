package com.opos.exoplayer.core;

import com.vivo.google.android.exoplayer3.C;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    public static final int f17710a;

    /* renamed from: b */
    public static final UUID f17711b;

    /* renamed from: c */
    public static final UUID f17712c;

    /* renamed from: d */
    public static final UUID f17713d;

    /* renamed from: e */
    public static final UUID f17714e;

    /* renamed from: f */
    public static final UUID f17715f;

    static {
        f17710a = com.opos.exoplayer.core.i.u.f19078a < 23 ? 1020 : 6396;
        f17711b = new UUID(0L, 0L);
        f17712c = new UUID(1186680826959645954L, -5988876978535335093L);
        f17713d = new UUID(-2129748144642739255L, 8654423357094679310L);
        f17714e = new UUID(-1301668207276963122L, -6645017420763422227L);
        f17715f = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long a(long j2) {
        return (j2 == C.TIME_UNSET || j2 == Long.MIN_VALUE) ? j2 : j2 / 1000;
    }

    public static long b(long j2) {
        return (j2 == C.TIME_UNSET || j2 == Long.MIN_VALUE) ? j2 : j2 * 1000;
    }
}
