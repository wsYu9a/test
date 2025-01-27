package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.Timeline;

/* loaded from: classes4.dex */
public final class r3 extends Timeline {

    /* renamed from: g */
    public static final Object f28003g = new Object();

    /* renamed from: a */
    public final long f28004a;

    /* renamed from: b */
    public final long f28005b;

    /* renamed from: c */
    public final long f28006c;

    /* renamed from: d */
    public final long f28007d;

    /* renamed from: e */
    public final boolean f28008e;

    /* renamed from: f */
    public final boolean f28009f;

    public r3(long j2, long j3, long j4, long j5, boolean z, boolean z2) {
        this.f28004a = j2;
        this.f28005b = j3;
        this.f28006c = j4;
        this.f28007d = j5;
        this.f28008e = z;
        this.f28009f = z2;
    }

    public r3(long j2, boolean z) {
        this(j2, j2, 0L, 0L, z, false);
    }

    @Override // com.vivo.google.android.exoplayer3.Timeline
    public int getIndexOfPeriod(Object obj) {
        return f28003g.equals(obj) ? 0 : -1;
    }

    @Override // com.vivo.google.android.exoplayer3.Timeline
    public Timeline.Period getPeriod(int i2, Timeline.Period period, boolean z) {
        g1.a(i2, 0, 1);
        Object obj = z ? f28003g : null;
        return period.set(obj, obj, 0, this.f28004a, -this.f28006c, false);
    }

    @Override // com.vivo.google.android.exoplayer3.Timeline
    public int getPeriodCount() {
        return 1;
    }

    @Override // com.vivo.google.android.exoplayer3.Timeline
    public Timeline.Window getWindow(int i2, Timeline.Window window, boolean z, long j2) {
        g1.a(i2, 0, 1);
        Object obj = z ? f28003g : null;
        long j3 = this.f28007d;
        boolean z2 = this.f28009f;
        if (z2) {
            j3 += j2;
            if (j3 > this.f28005b) {
                j3 = C.TIME_UNSET;
            }
        }
        return window.set(obj, C.TIME_UNSET, C.TIME_UNSET, this.f28008e, z2, j3, this.f28005b, 0, 0, this.f28006c);
    }

    @Override // com.vivo.google.android.exoplayer3.Timeline
    public int getWindowCount() {
        return 1;
    }
}
