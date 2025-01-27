package com.opos.cmn.func.dl.base.a.b;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: a */
    private static final String f17261a = "b";

    /* renamed from: b */
    private long f17262b;

    /* renamed from: c */
    private long f17263c;

    @Override // com.opos.cmn.func.dl.base.a.b.a
    public final long a(long j2, long j3, long j4, long j5, float f2, int i2, float f3) {
        if ((SystemClock.uptimeMillis() - this.f17263c <= i2 && j5 - this.f17262b <= Math.max(0.0f, Math.min(j2 * f2, f3))) || SystemClock.uptimeMillis() - this.f17263c <= 50) {
            return 0L;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - j4;
        this.f17262b = j5;
        this.f17263c = SystemClock.uptimeMillis();
        long j6 = 0 != uptimeMillis ? (j5 - j3) / uptimeMillis : 0L;
        if (j6 >= 0) {
            return j6;
        }
        return 0L;
    }
}
