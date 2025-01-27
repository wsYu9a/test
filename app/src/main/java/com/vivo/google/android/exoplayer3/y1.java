package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.w1;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class y1 extends w1 {
    public a n;
    public int o;
    public boolean p;
    public b2 q;
    public z1 r;

    public static final class a {

        /* renamed from: a */
        public final b2 f28291a;

        /* renamed from: b */
        public final byte[] f28292b;

        /* renamed from: c */
        public final a2[] f28293c;

        /* renamed from: d */
        public final int f28294d;

        public a(b2 b2Var, z1 z1Var, byte[] bArr, a2[] a2VarArr, int i2) {
            this.f28291a = b2Var;
            this.f28292b = bArr;
            this.f28293c = a2VarArr;
            this.f28294d = i2;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.w1
    public long a(n6 n6Var) {
        byte[] bArr = n6Var.f27874a;
        if ((bArr[0] & 1) == 1) {
            return -1L;
        }
        byte b2 = bArr[0];
        a aVar = this.n;
        int i2 = !aVar.f28293c[(b2 >> 1) & (255 >>> (8 - aVar.f28294d))].f27133a ? aVar.f28291a.f27208d : aVar.f28291a.f27209e;
        long j2 = this.p ? (this.o + i2) / 4 : 0;
        n6Var.c(n6Var.f27876c + 4);
        byte[] bArr2 = n6Var.f27874a;
        int i3 = n6Var.f27876c;
        bArr2[i3 - 4] = (byte) (j2 & 255);
        bArr2[i3 - 3] = (byte) ((j2 >>> 8) & 255);
        bArr2[i3 - 2] = (byte) ((j2 >>> 16) & 255);
        bArr2[i3 - 1] = (byte) ((j2 >>> 24) & 255);
        this.p = true;
        this.o = i2;
        return j2;
    }

    @Override // com.vivo.google.android.exoplayer3.w1
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }

    @Override // com.vivo.google.android.exoplayer3.w1
    public void b(long j2) {
        this.f28222g = j2;
        this.p = j2 != 0;
        b2 b2Var = this.q;
        this.o = b2Var != null ? b2Var.f27208d : 0;
    }

    @Override // com.vivo.google.android.exoplayer3.w1
    public boolean a(n6 n6Var, long j2, w1.a aVar) {
        a aVar2;
        int i2;
        long j3;
        int i3;
        if (this.n != null) {
            return false;
        }
        if (this.q == null) {
            g1.a(1, n6Var, false);
            long f2 = n6Var.f();
            int l = n6Var.l();
            long f3 = n6Var.f();
            int e2 = n6Var.e();
            int e3 = n6Var.e();
            int e4 = n6Var.e();
            int l2 = n6Var.l();
            this.q = new b2(f2, l, f3, e2, e3, e4, (int) Math.pow(2.0d, l2 & 15), (int) Math.pow(2.0d, (l2 & org.mozilla.universalchardet.prober.g.n) >> 4), (n6Var.l() & 1) > 0, Arrays.copyOf(n6Var.f27874a, n6Var.f27876c));
        } else if (this.r == null) {
            g1.a(3, n6Var, false);
            String a2 = n6Var.a((int) n6Var.f(), Charset.defaultCharset());
            int length = a2.length() + 11;
            long f4 = n6Var.f();
            String[] strArr = new String[(int) f4];
            int i4 = length + 4;
            for (int i5 = 0; i5 < f4; i5++) {
                strArr[i5] = n6Var.a((int) n6Var.f(), Charset.defaultCharset());
                i4 = i4 + 4 + strArr[i5].length();
            }
            if ((n6Var.l() & 1) != 0) {
                this.r = new z1(a2, strArr, i4 + 1);
            } else {
                throw new f("framing bit expected to be set");
            }
        } else {
            int i6 = n6Var.f27876c;
            byte[] bArr = new byte[i6];
            int i7 = 0;
            System.arraycopy(n6Var.f27874a, 0, bArr, 0, i6);
            int i8 = this.q.f27205a;
            int i9 = 5;
            g1.a(5, n6Var, false);
            int l3 = n6Var.l() + 1;
            x1 x1Var = new x1(n6Var.f27874a);
            x1Var.b(n6Var.f27875b * 8);
            int i10 = 0;
            while (true) {
                int i11 = 16;
                if (i10 < l3) {
                    if (x1Var.a(24) != 5653314) {
                        throw new f("expected code book to start with [0x56, 0x43, 0x42] at " + ((x1Var.f28260c * 8) + x1Var.f28261d));
                    }
                    int a3 = x1Var.a(16);
                    int a4 = x1Var.a(24);
                    long[] jArr = new long[a4];
                    long j4 = 0;
                    if (x1Var.a()) {
                        i2 = a3;
                        int a5 = x1Var.a(5) + 1;
                        int i12 = 0;
                        while (i12 < a4) {
                            int a6 = x1Var.a(g1.a(a4 - i12));
                            int i13 = i12;
                            int i14 = 0;
                            while (i14 < a6 && i13 < a4) {
                                jArr[i13] = a5;
                                i13++;
                                i14++;
                                a4 = a4;
                            }
                            a5++;
                            i12 = i13;
                            a4 = a4;
                        }
                    } else {
                        boolean a7 = x1Var.a();
                        while (i7 < a4) {
                            if (!a7) {
                                i3 = a3;
                                jArr[i7] = x1Var.a(5) + 1;
                            } else if (x1Var.a()) {
                                i3 = a3;
                                jArr[i7] = x1Var.a(5) + 1;
                            } else {
                                i3 = a3;
                                jArr[i7] = 0;
                            }
                            i7++;
                            a3 = i3;
                        }
                        i2 = a3;
                    }
                    int i15 = a4;
                    int a8 = x1Var.a(4);
                    if (a8 > 2) {
                        throw new f("lookup type greater than 2 not decodable: " + a8);
                    }
                    if (a8 == 1 || a8 == 2) {
                        x1Var.b(32);
                        x1Var.b(32);
                        int a9 = x1Var.a(4) + 1;
                        x1Var.b(1);
                        if (a8 == 1) {
                            if (i2 != 0) {
                                double d2 = i2;
                                Double.isNaN(d2);
                                j3 = (long) Math.floor(Math.pow(i15, 1.0d / d2));
                            }
                            x1Var.b((int) (a9 * j4));
                        } else {
                            j3 = i15 * i2;
                        }
                        j4 = j3;
                        x1Var.b((int) (a9 * j4));
                    }
                    i10++;
                    i7 = 0;
                } else {
                    int i16 = 6;
                    int a10 = x1Var.a(6) + 1;
                    for (int i17 = 0; i17 < a10; i17++) {
                        if (x1Var.a(16) != 0) {
                            throw new f("placeholder of time domain transforms not zeroed out");
                        }
                    }
                    int i18 = 1;
                    int a11 = x1Var.a(6) + 1;
                    int i19 = 0;
                    while (i19 < a11) {
                        int a12 = x1Var.a(i11);
                        if (a12 == 0) {
                            int i20 = 8;
                            x1Var.b(8);
                            x1Var.b(16);
                            x1Var.b(16);
                            x1Var.b(6);
                            x1Var.b(8);
                            int a13 = x1Var.a(4) + 1;
                            int i21 = 0;
                            while (i21 < a13) {
                                x1Var.b(i20);
                                i21++;
                                i20 = 8;
                            }
                        } else {
                            if (a12 != i18) {
                                throw new f("floor type greater than 1 not decodable: " + a12);
                            }
                            int a14 = x1Var.a(i9);
                            int[] iArr = new int[a14];
                            int i22 = -1;
                            for (int i23 = 0; i23 < a14; i23++) {
                                iArr[i23] = x1Var.a(4);
                                if (iArr[i23] > i22) {
                                    i22 = iArr[i23];
                                }
                            }
                            int i24 = i22 + 1;
                            int[] iArr2 = new int[i24];
                            for (int i25 = 0; i25 < i24; i25++) {
                                int i26 = 1;
                                iArr2[i25] = x1Var.a(3) + 1;
                                int a15 = x1Var.a(2);
                                int i27 = 8;
                                if (a15 > 0) {
                                    x1Var.b(8);
                                }
                                int i28 = 0;
                                while (i28 < (i26 << a15)) {
                                    x1Var.b(i27);
                                    i28++;
                                    i26 = 1;
                                    i27 = 8;
                                }
                            }
                            x1Var.b(2);
                            int a16 = x1Var.a(4);
                            int i29 = 0;
                            int i30 = 0;
                            for (int i31 = 0; i31 < a14; i31++) {
                                i29 += iArr2[iArr[i31]];
                                while (i30 < i29) {
                                    x1Var.b(a16);
                                    i30++;
                                }
                            }
                        }
                        i19++;
                        i16 = 6;
                        i9 = 5;
                        i18 = 1;
                        i11 = 16;
                    }
                    int i32 = 1;
                    int a17 = x1Var.a(i16) + 1;
                    int i33 = 0;
                    while (i33 < a17) {
                        if (x1Var.a(16) > 2) {
                            throw new f("residueType greater than 2 is not decodable");
                        }
                        x1Var.b(24);
                        x1Var.b(24);
                        x1Var.b(24);
                        int a18 = x1Var.a(i16) + i32;
                        int i34 = 8;
                        x1Var.b(8);
                        int[] iArr3 = new int[a18];
                        for (int i35 = 0; i35 < a18; i35++) {
                            iArr3[i35] = ((x1Var.a() ? x1Var.a(5) : 0) * 8) + x1Var.a(3);
                        }
                        int i36 = 0;
                        while (i36 < a18) {
                            int i37 = 0;
                            while (i37 < i34) {
                                if ((iArr3[i36] & (1 << i37)) != 0) {
                                    x1Var.b(i34);
                                }
                                i37++;
                                i34 = 8;
                            }
                            i36++;
                            i34 = 8;
                        }
                        i33++;
                        i16 = 6;
                        i32 = 1;
                    }
                    int a19 = x1Var.a(i16) + 1;
                    for (int i38 = 0; i38 < a19; i38++) {
                        int a20 = x1Var.a(16);
                        if (a20 != 0) {
                            String str = "mapping type other than 0 not supported: " + a20;
                        } else {
                            int a21 = x1Var.a() ? x1Var.a(4) + 1 : 1;
                            if (x1Var.a()) {
                                int a22 = x1Var.a(8) + 1;
                                for (int i39 = 0; i39 < a22; i39++) {
                                    int i40 = i8 - 1;
                                    x1Var.b(g1.a(i40));
                                    x1Var.b(g1.a(i40));
                                }
                            }
                            if (x1Var.a(2) != 0) {
                                throw new f("to reserved bits must be zero after mapping coupling steps");
                            }
                            if (a21 > 1) {
                                for (int i41 = 0; i41 < i8; i41++) {
                                    x1Var.b(4);
                                }
                            }
                            for (int i42 = 0; i42 < a21; i42++) {
                                x1Var.b(8);
                                x1Var.b(8);
                                x1Var.b(8);
                            }
                        }
                    }
                    int a23 = x1Var.a(6) + 1;
                    a2[] a2VarArr = new a2[a23];
                    for (int i43 = 0; i43 < a23; i43++) {
                        a2VarArr[i43] = new a2(x1Var.a(), x1Var.a(16), x1Var.a(16), x1Var.a(8));
                    }
                    if (x1Var.a()) {
                        aVar2 = new a(this.q, this.r, bArr, a2VarArr, g1.a(a23 - 1));
                    } else {
                        throw new f("framing bit after modes not set as expected");
                    }
                }
            }
        }
        aVar2 = null;
        this.n = aVar2;
        if (aVar2 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.n.f28291a.f27210f);
        arrayList.add(this.n.f28292b);
        b2 b2Var = this.n.f28291a;
        aVar.f28226a = Format.createAudioSampleFormat(null, "audio/vorbis", null, b2Var.f27207c, -1, b2Var.f27205a, (int) b2Var.f27206b, arrayList, null, 0, null);
        return true;
    }
}
