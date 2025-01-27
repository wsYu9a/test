package com.opos.exoplayer.core.c.d;

import com.opos.exoplayer.core.i.u;

/* loaded from: classes4.dex */
final class a {

    /* renamed from: com.opos.exoplayer.core.c.d.a$a */
    public static final class C0401a {

        /* renamed from: a */
        public final long[] f17862a;

        /* renamed from: b */
        public final int[] f17863b;

        /* renamed from: c */
        public final int f17864c;

        /* renamed from: d */
        public final long[] f17865d;

        /* renamed from: e */
        public final int[] f17866e;

        /* renamed from: f */
        public final long f17867f;

        private C0401a(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j2) {
            this.f17862a = jArr;
            this.f17863b = iArr;
            this.f17864c = i2;
            this.f17865d = jArr2;
            this.f17866e = iArr2;
            this.f17867f = j2;
        }

        /* synthetic */ C0401a(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j2, AnonymousClass1 anonymousClass1) {
            this(jArr, iArr, i2, jArr2, iArr2, j2);
        }
    }

    public static C0401a a(int i2, long[] jArr, int[] iArr, long j2) {
        int i3 = 8192 / i2;
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int a2 = u.a(iArr[i4], i3);
            i4++;
            i5 += a2;
        }
        long[] jArr2 = new long[i5];
        int[] iArr2 = new int[i5];
        long[] jArr3 = new long[i5];
        int[] iArr3 = new int[i5];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < iArr.length; i9++) {
            int i10 = iArr[i9];
            long j3 = jArr[i9];
            while (i10 > 0) {
                int min = Math.min(i3, i10);
                jArr2[i7] = j3;
                iArr2[i7] = i2 * min;
                i8 = Math.max(i8, iArr2[i7]);
                jArr3[i7] = i6 * j2;
                iArr3[i7] = 1;
                j3 += iArr2[i7];
                i6 += min;
                i10 -= min;
                i7++;
            }
        }
        return new C0401a(jArr2, iArr2, i8, jArr3, iArr3, i6 * j2);
    }
}
