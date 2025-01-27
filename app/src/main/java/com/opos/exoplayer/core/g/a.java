package com.opos.exoplayer.core.g;

import com.opos.exoplayer.core.e.l;
import com.opos.exoplayer.core.g.f;
import com.vivo.google.android.exoplayer3.C;
import com.vivo.google.android.exoplayer3.trackselection.AdaptiveTrackSelection;

/* loaded from: classes4.dex */
public class a extends b {

    /* renamed from: d */
    private final com.opos.exoplayer.core.h.d f18828d;

    /* renamed from: e */
    private final int f18829e;

    /* renamed from: f */
    private final long f18830f;

    /* renamed from: g */
    private final long f18831g;

    /* renamed from: h */
    private final long f18832h;

    /* renamed from: i */
    private final float f18833i;

    /* renamed from: j */
    private final float f18834j;
    private final long k;
    private final com.opos.exoplayer.core.i.b l;
    private float m;
    private int n;
    private int o;
    private long p;

    /* renamed from: com.opos.exoplayer.core.g.a$a */
    public static final class C0415a implements f.a {

        /* renamed from: a */
        private final com.opos.exoplayer.core.h.d f18835a;

        /* renamed from: b */
        private final int f18836b;

        /* renamed from: c */
        private final int f18837c;

        /* renamed from: d */
        private final int f18838d;

        /* renamed from: e */
        private final int f18839e;

        /* renamed from: f */
        private final float f18840f;

        /* renamed from: g */
        private final float f18841g;

        /* renamed from: h */
        private final long f18842h;

        /* renamed from: i */
        private final com.opos.exoplayer.core.i.b f18843i;

        public C0415a(com.opos.exoplayer.core.h.d dVar) {
            this(dVar, AdaptiveTrackSelection.DEFAULT_MAX_INITIAL_BITRATE, 10000, 25000, 25000, 0.75f, 0.75f, 2000L, com.opos.exoplayer.core.i.b.f19008a);
        }

        public C0415a(com.opos.exoplayer.core.h.d dVar, int i2, int i3, int i4, int i5, float f2, float f3, long j2, com.opos.exoplayer.core.i.b bVar) {
            this.f18835a = dVar;
            this.f18836b = i2;
            this.f18837c = i3;
            this.f18838d = i4;
            this.f18839e = i5;
            this.f18840f = f2;
            this.f18841g = f3;
            this.f18842h = j2;
            this.f18843i = bVar;
        }

        @Override // com.opos.exoplayer.core.g.f.a
        /* renamed from: a */
        public a b(l lVar, int... iArr) {
            return new a(lVar, iArr, this.f18835a, this.f18836b, this.f18837c, this.f18838d, this.f18839e, this.f18840f, this.f18841g, this.f18842h, this.f18843i);
        }
    }

    public a(l lVar, int[] iArr, com.opos.exoplayer.core.h.d dVar, int i2, long j2, long j3, long j4, float f2, float f3, long j5, com.opos.exoplayer.core.i.b bVar) {
        super(lVar, iArr);
        this.f18828d = dVar;
        this.f18829e = i2;
        this.f18830f = j2 * 1000;
        this.f18831g = j3 * 1000;
        this.f18832h = j4 * 1000;
        this.f18833i = f2;
        this.f18834j = f3;
        this.k = j5;
        this.l = bVar;
        this.m = 1.0f;
        this.n = a(Long.MIN_VALUE);
        this.o = 1;
        this.p = C.TIME_UNSET;
    }

    private int a(long j2) {
        long a2 = this.f18828d.a();
        long j3 = a2 == -1 ? this.f18829e : (long) (a2 * this.f18833i);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f18845b; i3++) {
            if (j2 == Long.MIN_VALUE || !a(i3, j2)) {
                if (Math.round(a(i3).f17492b * this.m) <= j3) {
                    return i3;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // com.opos.exoplayer.core.g.b, com.opos.exoplayer.core.g.f
    public void a() {
        this.p = C.TIME_UNSET;
    }

    @Override // com.opos.exoplayer.core.g.b, com.opos.exoplayer.core.g.f
    public void a(float f2) {
        this.m = f2;
    }

    @Override // com.opos.exoplayer.core.g.f
    public int b() {
        return this.n;
    }
}
