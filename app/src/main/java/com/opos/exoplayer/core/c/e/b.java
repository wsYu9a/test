package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.o;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class b {

    public static final class a {

        /* renamed from: a */
        public final int f17997a;

        /* renamed from: b */
        public final int f17998b;

        /* renamed from: c */
        public final long[] f17999c;

        /* renamed from: d */
        public final int f18000d;

        /* renamed from: e */
        public final boolean f18001e;

        public a(int i2, int i3, long[] jArr, int i4, boolean z) {
            this.f17997a = i2;
            this.f17998b = i3;
            this.f17999c = jArr;
            this.f18000d = i4;
            this.f18001e = z;
        }
    }

    /* renamed from: com.opos.exoplayer.core.c.e.b$b */
    public static final class C0403b {

        /* renamed from: a */
        public final String f18002a;

        /* renamed from: b */
        public final String[] f18003b;

        /* renamed from: c */
        public final int f18004c;

        public C0403b(String str, String[] strArr, int i2) {
            this.f18002a = str;
            this.f18003b = strArr;
            this.f18004c = i2;
        }
    }

    public static final class c {

        /* renamed from: a */
        public final boolean f18005a;

        /* renamed from: b */
        public final int f18006b;

        /* renamed from: c */
        public final int f18007c;

        /* renamed from: d */
        public final int f18008d;

        public c(boolean z, int i2, int i3, int i4) {
            this.f18005a = z;
            this.f18006b = i2;
            this.f18007c = i3;
            this.f18008d = i4;
        }
    }

    public static final class d {

        /* renamed from: a */
        public final long f18009a;

        /* renamed from: b */
        public final int f18010b;

        /* renamed from: c */
        public final long f18011c;

        /* renamed from: d */
        public final int f18012d;

        /* renamed from: e */
        public final int f18013e;

        /* renamed from: f */
        public final int f18014f;

        /* renamed from: g */
        public final int f18015g;

        /* renamed from: h */
        public final int f18016h;

        /* renamed from: i */
        public final boolean f18017i;

        /* renamed from: j */
        public final byte[] f18018j;

        public d(long j2, int i2, long j3, int i3, int i4, int i5, int i6, int i7, boolean z, byte[] bArr) {
            this.f18009a = j2;
            this.f18010b = i2;
            this.f18011c = j3;
            this.f18012d = i3;
            this.f18013e = i4;
            this.f18014f = i5;
            this.f18015g = i6;
            this.f18016h = i7;
            this.f18017i = z;
            this.f18018j = bArr;
        }
    }

    public static int a(int i2) {
        int i3 = 0;
        while (i2 > 0) {
            i3++;
            i2 >>>= 1;
        }
        return i3;
    }

    private static long a(long j2, long j3) {
        double d2 = j3;
        Double.isNaN(d2);
        return (long) Math.floor(Math.pow(j2, 1.0d / d2));
    }

    public static d a(m mVar) {
        a(1, mVar, false);
        long n = mVar.n();
        int g2 = mVar.g();
        long n2 = mVar.n();
        int p = mVar.p();
        int p2 = mVar.p();
        int p3 = mVar.p();
        int g3 = mVar.g();
        return new d(n, g2, n2, p, p2, p3, (int) Math.pow(2.0d, g3 & 15), (int) Math.pow(2.0d, (g3 & org.mozilla.universalchardet.prober.g.n) >> 4), (mVar.g() & 1) > 0, Arrays.copyOf(mVar.f19048a, mVar.c()));
    }

    private static void a(int i2, j jVar) {
        int a2 = jVar.a(6);
        for (int i3 = 0; i3 < a2 + 1; i3++) {
            int a3 = jVar.a(16);
            if (a3 != 0) {
                com.opos.cmn.an.f.a.d("VorbisUtil", "mapping type other than 0 not supported: " + a3);
            } else {
                int a4 = jVar.a() ? jVar.a(4) + 1 : 1;
                if (jVar.a()) {
                    int a5 = jVar.a(8);
                    for (int i4 = 0; i4 < a5 + 1; i4++) {
                        int i5 = i2 - 1;
                        jVar.b(a(i5));
                        jVar.b(a(i5));
                    }
                }
                if (jVar.a(2) != 0) {
                    throw new o("to reserved bits must be zero after mapping coupling steps");
                }
                if (a4 > 1) {
                    for (int i6 = 0; i6 < i2; i6++) {
                        jVar.b(4);
                    }
                }
                for (int i7 = 0; i7 < a4; i7++) {
                    jVar.b(8);
                    jVar.b(8);
                    jVar.b(8);
                }
            }
        }
    }

    public static boolean a(int i2, m mVar, boolean z) {
        if (mVar.b() < 7) {
            if (!z) {
                throw new o("too short header: " + mVar.b());
            }
        } else if (mVar.g() != i2) {
            if (!z) {
                throw new o("expected header type " + Integer.toHexString(i2));
            }
        } else {
            if (mVar.g() == 118 && mVar.g() == 111 && mVar.g() == 114 && mVar.g() == 98 && mVar.g() == 105 && mVar.g() == 115) {
                return true;
            }
            if (!z) {
                throw new o("expected characters 'vorbis'");
            }
        }
        return false;
    }

    private static c[] a(j jVar) {
        int a2 = jVar.a(6) + 1;
        c[] cVarArr = new c[a2];
        for (int i2 = 0; i2 < a2; i2++) {
            cVarArr[i2] = new c(jVar.a(), jVar.a(16), jVar.a(16), jVar.a(8));
        }
        return cVarArr;
    }

    public static c[] a(m mVar, int i2) {
        a(5, mVar, false);
        int g2 = mVar.g();
        j jVar = new j(mVar.f19048a);
        jVar.b(mVar.d() * 8);
        for (int i3 = 0; i3 < g2 + 1; i3++) {
            d(jVar);
        }
        int a2 = jVar.a(6);
        for (int i4 = 0; i4 < a2 + 1; i4++) {
            if (jVar.a(16) != 0) {
                throw new o("placeholder of time domain transforms not zeroed out");
            }
        }
        c(jVar);
        b(jVar);
        a(i2, jVar);
        c[] a3 = a(jVar);
        if (jVar.a()) {
            return a3;
        }
        throw new o("framing bit after modes not set as expected");
    }

    public static C0403b b(m mVar) {
        a(3, mVar, false);
        String e2 = mVar.e((int) mVar.n());
        int length = e2.length();
        long n = mVar.n();
        String[] strArr = new String[(int) n];
        int i2 = length + 11 + 4;
        for (int i3 = 0; i3 < n; i3++) {
            strArr[i3] = mVar.e((int) mVar.n());
            i2 = i2 + 4 + strArr[i3].length();
        }
        if ((mVar.g() & 1) != 0) {
            return new C0403b(e2, strArr, i2 + 1);
        }
        throw new o("framing bit expected to be set");
    }

    private static void b(j jVar) {
        int a2 = jVar.a(6);
        for (int i2 = 0; i2 < a2 + 1; i2++) {
            if (jVar.a(16) > 2) {
                throw new o("residueType greater than 2 is not decodable");
            }
            jVar.b(24);
            jVar.b(24);
            jVar.b(24);
            int a3 = jVar.a(6) + 1;
            jVar.b(8);
            int[] iArr = new int[a3];
            for (int i3 = 0; i3 < a3; i3++) {
                iArr[i3] = ((jVar.a() ? jVar.a(5) : 0) * 8) + jVar.a(3);
            }
            for (int i4 = 0; i4 < a3; i4++) {
                for (int i5 = 0; i5 < 8; i5++) {
                    if ((iArr[i4] & (1 << i5)) != 0) {
                        jVar.b(8);
                    }
                }
            }
        }
    }

    private static void c(j jVar) {
        int a2 = jVar.a(6);
        for (int i2 = 0; i2 < a2 + 1; i2++) {
            int a3 = jVar.a(16);
            if (a3 == 0) {
                jVar.b(8);
                jVar.b(16);
                jVar.b(16);
                jVar.b(6);
                jVar.b(8);
                int a4 = jVar.a(4);
                for (int i3 = 0; i3 < a4 + 1; i3++) {
                    jVar.b(8);
                }
            } else {
                if (a3 != 1) {
                    throw new o("floor type greater than 1 not decodable: " + a3);
                }
                int a5 = jVar.a(5);
                int i4 = -1;
                int[] iArr = new int[a5];
                for (int i5 = 0; i5 < a5; i5++) {
                    iArr[i5] = jVar.a(4);
                    if (iArr[i5] > i4) {
                        i4 = iArr[i5];
                    }
                }
                int i6 = i4 + 1;
                int[] iArr2 = new int[i6];
                for (int i7 = 0; i7 < i6; i7++) {
                    iArr2[i7] = jVar.a(3) + 1;
                    int a6 = jVar.a(2);
                    if (a6 > 0) {
                        jVar.b(8);
                    }
                    for (int i8 = 0; i8 < (1 << a6); i8++) {
                        jVar.b(8);
                    }
                }
                jVar.b(2);
                int a7 = jVar.a(4);
                int i9 = 0;
                int i10 = 0;
                for (int i11 = 0; i11 < a5; i11++) {
                    i9 += iArr2[iArr[i11]];
                    while (i10 < i9) {
                        jVar.b(a7);
                        i10++;
                    }
                }
            }
        }
    }

    private static a d(j jVar) {
        if (jVar.a(24) != 5653314) {
            throw new o("expected code book to start with [0x56, 0x43, 0x42] at " + jVar.b());
        }
        int a2 = jVar.a(16);
        int a3 = jVar.a(24);
        long[] jArr = new long[a3];
        boolean a4 = jVar.a();
        long j2 = 0;
        if (a4) {
            int a5 = jVar.a(5) + 1;
            int i2 = 0;
            while (i2 < a3) {
                int a6 = jVar.a(a(a3 - i2));
                for (int i3 = 0; i3 < a6 && i2 < a3; i3++) {
                    jArr[i2] = a5;
                    i2++;
                }
                a5++;
            }
        } else {
            boolean a7 = jVar.a();
            for (int i4 = 0; i4 < a3; i4++) {
                if (!a7) {
                    jArr[i4] = jVar.a(5) + 1;
                } else if (jVar.a()) {
                    jArr[i4] = jVar.a(5) + 1;
                } else {
                    jArr[i4] = 0;
                }
            }
        }
        int a8 = jVar.a(4);
        if (a8 > 2) {
            throw new o("lookup type greater than 2 not decodable: " + a8);
        }
        if (a8 == 1 || a8 == 2) {
            jVar.b(32);
            jVar.b(32);
            int a9 = jVar.a(4);
            jVar.b(1);
            if (a8 != 1) {
                j2 = a3 * a2;
            } else if (a2 != 0) {
                j2 = a(a3, a2);
            }
            jVar.b((int) (j2 * (a9 + 1)));
        }
        return new a(a2, a3, jArr, a8, a4);
    }
}
