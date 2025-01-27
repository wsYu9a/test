package com.opos.exoplayer.core.c.d;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.d.a;
import com.opos.exoplayer.core.c.d.g;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.o;
import com.opos.exoplayer.core.video.ColorInfo;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.google.android.exoplayer3.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class h {

    /* renamed from: a */
    private static final int f17930a = u.f("vide");

    /* renamed from: b */
    private static final int f17931b = u.f("soun");

    /* renamed from: c */
    private static final int f17932c = u.f(com.baidu.mobads.sdk.internal.a.f5473b);

    /* renamed from: d */
    private static final int f17933d = u.f("sbtl");

    /* renamed from: e */
    private static final int f17934e = u.f("subt");

    /* renamed from: f */
    private static final int f17935f = u.f("clcp");

    /* renamed from: g */
    private static final int f17936g = u.f(TTDownloadField.TT_META);

    private static final class a {

        /* renamed from: a */
        public final int f17937a;

        /* renamed from: b */
        public int f17938b;

        /* renamed from: c */
        public int f17939c;

        /* renamed from: d */
        public long f17940d;

        /* renamed from: e */
        private final boolean f17941e;

        /* renamed from: f */
        private final com.opos.exoplayer.core.i.m f17942f;

        /* renamed from: g */
        private final com.opos.exoplayer.core.i.m f17943g;

        /* renamed from: h */
        private int f17944h;

        /* renamed from: i */
        private int f17945i;

        public a(com.opos.exoplayer.core.i.m mVar, com.opos.exoplayer.core.i.m mVar2, boolean z) {
            this.f17943g = mVar;
            this.f17942f = mVar2;
            this.f17941e = z;
            mVar2.c(12);
            this.f17937a = mVar2.u();
            mVar.c(12);
            this.f17945i = mVar.u();
            com.opos.exoplayer.core.i.a.b(mVar.o() == 1, "first_chunk must be 1");
            this.f17938b = -1;
        }

        public boolean a() {
            int i2 = this.f17938b + 1;
            this.f17938b = i2;
            if (i2 == this.f17937a) {
                return false;
            }
            this.f17940d = this.f17941e ? this.f17942f.w() : this.f17942f.m();
            if (this.f17938b != this.f17944h) {
                return true;
            }
            this.f17939c = this.f17943g.u();
            this.f17943g.d(4);
            int i3 = this.f17945i - 1;
            this.f17945i = i3;
            this.f17944h = i3 > 0 ? this.f17943g.u() - 1 : -1;
            return true;
        }
    }

    private interface b {
        int a();

        int b();

        boolean c();
    }

    private static final class c {

        /* renamed from: a */
        public final com.opos.exoplayer.core.c.d.f[] f17946a;

        /* renamed from: b */
        public Format f17947b;

        /* renamed from: c */
        public int f17948c;

        /* renamed from: d */
        public int f17949d = 0;

        public c(int i2) {
            this.f17946a = new com.opos.exoplayer.core.c.d.f[i2];
        }
    }

    static final class d implements b {

        /* renamed from: a */
        private final int f17950a;

        /* renamed from: b */
        private final int f17951b;

        /* renamed from: c */
        private final com.opos.exoplayer.core.i.m f17952c;

        public d(g.b bVar) {
            com.opos.exoplayer.core.i.m mVar = bVar.aQ;
            this.f17952c = mVar;
            mVar.c(12);
            this.f17950a = mVar.u();
            this.f17951b = mVar.u();
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public int a() {
            return this.f17951b;
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public int b() {
            int i2 = this.f17950a;
            return i2 == 0 ? this.f17952c.u() : i2;
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public boolean c() {
            return this.f17950a != 0;
        }
    }

    static final class e implements b {

        /* renamed from: a */
        private final com.opos.exoplayer.core.i.m f17953a;

        /* renamed from: b */
        private final int f17954b;

        /* renamed from: c */
        private final int f17955c;

        /* renamed from: d */
        private int f17956d;

        /* renamed from: e */
        private int f17957e;

        public e(g.b bVar) {
            com.opos.exoplayer.core.i.m mVar = bVar.aQ;
            this.f17953a = mVar;
            mVar.c(12);
            this.f17955c = mVar.u() & 255;
            this.f17954b = mVar.u();
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public int a() {
            return this.f17954b;
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public int b() {
            int i2 = this.f17955c;
            if (i2 == 8) {
                return this.f17953a.g();
            }
            if (i2 == 16) {
                return this.f17953a.h();
            }
            int i3 = this.f17956d;
            this.f17956d = i3 + 1;
            if (i3 % 2 != 0) {
                return this.f17957e & 15;
            }
            int g2 = this.f17953a.g();
            this.f17957e = g2;
            return (g2 & org.mozilla.universalchardet.prober.g.n) >> 4;
        }

        @Override // com.opos.exoplayer.core.c.d.h.b
        public boolean c() {
            return false;
        }
    }

    private static final class f {

        /* renamed from: a */
        private final int f17958a;

        /* renamed from: b */
        private final long f17959b;

        /* renamed from: c */
        private final int f17960c;

        public f(int i2, long j2, int i3) {
            this.f17958a = i2;
            this.f17959b = j2;
            this.f17960c = i3;
        }
    }

    private static long a(com.opos.exoplayer.core.i.m mVar) {
        mVar.c(8);
        mVar.d(g.a(mVar.o()) != 0 ? 16 : 8);
        return mVar.m();
    }

    private static Pair<long[], long[]> a(g.a aVar) {
        g.b d2;
        if (aVar == null || (d2 = aVar.d(g.Q)) == null) {
            return Pair.create(null, null);
        }
        com.opos.exoplayer.core.i.m mVar = d2.aQ;
        mVar.c(8);
        int a2 = g.a(mVar.o());
        int u = mVar.u();
        long[] jArr = new long[u];
        long[] jArr2 = new long[u];
        for (int i2 = 0; i2 < u; i2++) {
            jArr[i2] = a2 == 1 ? mVar.w() : mVar.m();
            jArr2[i2] = a2 == 1 ? mVar.q() : mVar.o();
            if (mVar.j() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            mVar.d(2);
        }
        return Pair.create(jArr, jArr2);
    }

    static Pair<Integer, com.opos.exoplayer.core.c.d.f> a(com.opos.exoplayer.core.i.m mVar, int i2, int i3) {
        int i4 = i2 + 8;
        String str = null;
        Integer num = null;
        int i5 = -1;
        int i6 = 0;
        while (i4 - i2 < i3) {
            mVar.c(i4);
            int o = mVar.o();
            int o2 = mVar.o();
            if (o2 == g.ab) {
                num = Integer.valueOf(mVar.o());
            } else if (o2 == g.W) {
                mVar.d(4);
                str = mVar.e(4);
            } else if (o2 == g.X) {
                i5 = i4;
                i6 = o;
            }
            i4 += o;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        com.opos.exoplayer.core.i.a.a(num != null, "frma atom is mandatory");
        com.opos.exoplayer.core.i.a.a(i5 != -1, "schi atom is mandatory");
        com.opos.exoplayer.core.c.d.f a2 = a(mVar, i5, i6, str);
        com.opos.exoplayer.core.i.a.a(a2 != null, "tenc atom is mandatory");
        return Pair.create(num, a2);
    }

    public static com.opos.exoplayer.core.c.d.e a(g.a aVar, g.b bVar, long j2, DrmInitData drmInitData, boolean z, boolean z2) {
        g.b bVar2;
        long j3;
        long[] jArr;
        long[] jArr2;
        g.a e2 = aVar.e(g.E);
        int c2 = c(e2.d(g.S).aQ);
        if (c2 == -1) {
            return null;
        }
        f b2 = b(aVar.d(g.O).aQ);
        long j4 = C.TIME_UNSET;
        if (j2 == C.TIME_UNSET) {
            bVar2 = bVar;
            j3 = b2.f17959b;
        } else {
            bVar2 = bVar;
            j3 = j2;
        }
        long a2 = a(bVar2.aQ);
        if (j3 != C.TIME_UNSET) {
            j4 = u.d(j3, C.MICROS_PER_SECOND, a2);
        }
        long j5 = j4;
        g.a e3 = e2.e(g.F).e(g.G);
        Pair<Long, String> d2 = d(e2.d(g.R).aQ);
        c a3 = a(e3.d(g.T).aQ, b2.f17958a, b2.f17960c, (String) d2.second, drmInitData, z2);
        if (z) {
            jArr = null;
            jArr2 = null;
        } else {
            Pair<long[], long[]> a4 = a(aVar.e(g.P));
            long[] jArr3 = (long[]) a4.first;
            jArr2 = (long[]) a4.second;
            jArr = jArr3;
        }
        if (a3.f17947b == null) {
            return null;
        }
        return new com.opos.exoplayer.core.c.d.e(b2.f17958a, c2, ((Long) d2.first).longValue(), a2, j5, a3.f17947b, a3.f17949d, a3.f17946a, a3.f17948c, jArr, jArr2);
    }

    private static com.opos.exoplayer.core.c.d.f a(com.opos.exoplayer.core.i.m mVar, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            mVar.c(i6);
            int o = mVar.o();
            if (mVar.o() == g.Y) {
                int a2 = g.a(mVar.o());
                mVar.d(1);
                if (a2 == 0) {
                    mVar.d(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int g2 = mVar.g();
                    i4 = g2 & 15;
                    i5 = (g2 & org.mozilla.universalchardet.prober.g.n) >> 4;
                }
                boolean z = mVar.g() == 1;
                int g3 = mVar.g();
                byte[] bArr2 = new byte[16];
                mVar.a(bArr2, 0, 16);
                if (z && g3 == 0) {
                    int g4 = mVar.g();
                    bArr = new byte[g4];
                    mVar.a(bArr, 0, g4);
                }
                return new com.opos.exoplayer.core.c.d.f(z, str, g3, bArr2, i5, i4, bArr);
            }
            i6 += o;
        }
    }

    private static c a(com.opos.exoplayer.core.i.m mVar, int i2, int i3, String str, DrmInitData drmInitData, boolean z) {
        mVar.c(12);
        int o = mVar.o();
        c cVar = new c(o);
        for (int i4 = 0; i4 < o; i4++) {
            int d2 = mVar.d();
            int o2 = mVar.o();
            com.opos.exoplayer.core.i.a.a(o2 > 0, "childAtomSize should be positive");
            int o3 = mVar.o();
            if (o3 == g.f17921b || o3 == g.f17922c || o3 == g.Z || o3 == g.al || o3 == g.f17923d || o3 == g.f17924e || o3 == g.f17925f || o3 == g.aK || o3 == g.aL) {
                a(mVar, o3, d2, o2, i2, i3, drmInitData, cVar, i4);
            } else if (o3 == g.f17928i || o3 == g.aa || o3 == g.n || o3 == g.p || o3 == g.r || o3 == g.u || o3 == g.s || o3 == g.t || o3 == g.ay || o3 == g.az || o3 == g.l || o3 == g.m || o3 == g.f17929j || o3 == g.aO) {
                a(mVar, o3, d2, o2, i2, str, z, drmInitData, cVar, i4);
            } else if (o3 == g.aj || o3 == g.au || o3 == g.av || o3 == g.aw || o3 == g.ax) {
                a(mVar, o3, d2, o2, i2, str, cVar);
            } else if (o3 == g.aN) {
                cVar.f17947b = Format.a(Integer.toString(i2), "application/x-camera-motion", (String) null, -1, (DrmInitData) null);
            }
            mVar.c(d2 + o2);
        }
        return cVar;
    }

    public static m a(com.opos.exoplayer.core.c.d.e eVar, g.a aVar, com.opos.exoplayer.core.c.i iVar) {
        b eVar2;
        boolean z;
        int i2;
        int i3;
        int i4;
        String str;
        com.opos.exoplayer.core.c.d.e eVar3;
        long[] jArr;
        int[] iArr;
        int i5;
        long[] jArr2;
        int[] iArr2;
        long j2;
        long j3;
        boolean z2;
        int[] iArr3;
        int i6;
        int[] iArr4;
        int[] iArr5;
        int[] iArr6;
        int i7;
        int[] iArr7;
        int[] iArr8;
        String str2;
        m mVar;
        int i8;
        g.b d2 = aVar.d(g.aq);
        if (d2 != null) {
            eVar2 = new d(d2);
        } else {
            g.b d3 = aVar.d(g.ar);
            if (d3 == null) {
                throw new o("Track has no sample table size information");
            }
            eVar2 = new e(d3);
        }
        int a2 = eVar2.a();
        if (a2 == 0) {
            return new m(new long[0], new int[0], 0, new long[0], new int[0], C.TIME_UNSET);
        }
        g.b d4 = aVar.d(g.as);
        if (d4 == null) {
            d4 = aVar.d(g.at);
            z = true;
        } else {
            z = false;
        }
        com.opos.exoplayer.core.i.m mVar2 = d4.aQ;
        com.opos.exoplayer.core.i.m mVar3 = aVar.d(g.ap).aQ;
        com.opos.exoplayer.core.i.m mVar4 = aVar.d(g.am).aQ;
        g.b d5 = aVar.d(g.an);
        com.opos.exoplayer.core.i.m mVar5 = null;
        com.opos.exoplayer.core.i.m mVar6 = d5 != null ? d5.aQ : null;
        g.b d6 = aVar.d(g.ao);
        com.opos.exoplayer.core.i.m mVar7 = d6 != null ? d6.aQ : null;
        a aVar2 = new a(mVar3, mVar2, z);
        mVar4.c(12);
        int u = mVar4.u() - 1;
        int u2 = mVar4.u();
        int u3 = mVar4.u();
        if (mVar7 != null) {
            mVar7.c(12);
            i2 = mVar7.u();
        } else {
            i2 = 0;
        }
        int i9 = -1;
        if (mVar6 != null) {
            mVar6.c(12);
            i3 = mVar6.u();
            if (i3 > 0) {
                i9 = mVar6.u() - 1;
                mVar5 = mVar6;
            }
        } else {
            mVar5 = mVar6;
            i3 = 0;
        }
        long j4 = 0;
        if (eVar2.c() && "audio/raw".equals(eVar.f17909f.f17496f) && u == 0 && i2 == 0 && i3 == 0) {
            i4 = a2;
            b bVar = eVar2;
            str = "AtomParsers";
            eVar3 = eVar;
            int i10 = aVar2.f17937a;
            long[] jArr3 = new long[i10];
            int[] iArr9 = new int[i10];
            while (aVar2.a()) {
                int i11 = aVar2.f17938b;
                jArr3[i11] = aVar2.f17940d;
                iArr9[i11] = aVar2.f17939c;
            }
            a.C0401a a3 = com.opos.exoplayer.core.c.d.a.a(bVar.b(), jArr3, iArr9, u3);
            jArr = a3.f17862a;
            iArr = a3.f17863b;
            i5 = a3.f17864c;
            jArr2 = a3.f17865d;
            iArr2 = a3.f17866e;
            j2 = a3.f17867f;
        } else {
            jArr = new long[a2];
            iArr = new int[a2];
            int i12 = i3;
            jArr2 = new long[a2];
            iArr2 = new int[a2];
            int i13 = u3;
            long j5 = 0;
            long j6 = 0;
            int i14 = u;
            int i15 = 0;
            i5 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = i12;
            int i20 = i9;
            int i21 = i2;
            int i22 = u2;
            while (i15 < a2) {
                while (i18 == 0) {
                    com.opos.exoplayer.core.i.a.b(aVar2.a());
                    j5 = aVar2.f17940d;
                    i18 = aVar2.f17939c;
                    i14 = i14;
                    i22 = i22;
                }
                int i23 = i14;
                int i24 = i22;
                if (mVar7 != null) {
                    while (i16 == 0 && i21 > 0) {
                        i16 = mVar7.u();
                        i17 = mVar7.o();
                        i21--;
                    }
                    i16--;
                }
                int i25 = i17;
                jArr[i15] = j5;
                iArr[i15] = eVar2.b();
                if (iArr[i15] > i5) {
                    i5 = iArr[i15];
                }
                int i26 = a2;
                b bVar2 = eVar2;
                jArr2[i15] = i25 + j6;
                iArr2[i15] = mVar5 == null ? 1 : 0;
                if (i15 == i20) {
                    iArr2[i15] = 1;
                    i19--;
                    if (i19 > 0) {
                        i20 = mVar5.u() - 1;
                    }
                }
                j6 += i13;
                int i27 = i24 - 1;
                if (i27 == 0 && i23 > 0) {
                    i23--;
                    i27 = mVar4.u();
                    i13 = mVar4.o();
                }
                int i28 = i27;
                j5 += iArr[i15];
                i18--;
                i15++;
                eVar2 = bVar2;
                a2 = i26;
                i13 = i13;
                i22 = i28;
                i17 = i25;
                i14 = i23;
            }
            int i29 = i14;
            int i30 = i22;
            int i31 = i17;
            i4 = a2;
            long j7 = i31;
            com.opos.exoplayer.core.i.a.a(i16 == 0);
            while (i21 > 0) {
                com.opos.exoplayer.core.i.a.a(mVar7.u() == 0);
                mVar7.o();
                i21--;
            }
            if (i19 == 0 && i30 == 0) {
                i8 = i18;
                if (i8 == 0 && i29 == 0) {
                    eVar3 = eVar;
                    str = "AtomParsers";
                    j2 = j6 + j7;
                }
            } else {
                i8 = i18;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Inconsistent stbl box for track ");
            eVar3 = eVar;
            sb.append(eVar3.f17904a);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i19);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i30);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i8);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i29);
            String sb2 = sb.toString();
            str = "AtomParsers";
            com.opos.cmn.an.f.a.c(str, sb2);
            j2 = j6 + j7;
        }
        int[] iArr10 = iArr2;
        int i32 = i5;
        long d7 = u.d(j2, C.MICROS_PER_SECOND, eVar3.f17906c);
        if (eVar3.f17911h == null || iVar.a()) {
            u.a(jArr2, C.MICROS_PER_SECOND, eVar3.f17906c);
            return new m(jArr, iArr, i32, jArr2, iArr10, d7);
        }
        long[] jArr4 = eVar3.f17911h;
        if (jArr4.length == 1 && eVar3.f17905b == 1 && jArr2.length >= 2) {
            long j8 = eVar3.f17912i[0];
            long d8 = u.d(jArr4[0], eVar3.f17906c, eVar3.f17907d) + j8;
            if (jArr2[0] <= j8 && j8 < jArr2[1] && jArr2[jArr2.length - 1] < d8 && d8 <= j2) {
                long d9 = u.d(j8 - jArr2[0], eVar3.f17909f.s, eVar3.f17906c);
                long d10 = u.d(j2 - d8, eVar3.f17909f.s, eVar3.f17906c);
                if ((d9 != 0 || d10 != 0) && d9 <= 2147483647L && d10 <= 2147483647L) {
                    iVar.f18311b = (int) d9;
                    iVar.f18312c = (int) d10;
                    u.a(jArr2, C.MICROS_PER_SECOND, eVar3.f17906c);
                    mVar = new m(jArr, iArr, i32, jArr2, iArr10, d7);
                    return mVar;
                }
            }
        }
        long[] jArr5 = eVar3.f17911h;
        if (jArr5.length == 1 && jArr5[0] == 0) {
            long j9 = eVar3.f17912i[0];
            for (int i33 = 0; i33 < jArr2.length; i33++) {
                jArr2[i33] = u.d(jArr2[i33] - j9, C.MICROS_PER_SECOND, eVar3.f17906c);
            }
            mVar = new m(jArr, iArr, i32, jArr2, iArr10, u.d(j2 - j9, C.MICROS_PER_SECOND, eVar3.f17906c));
            return mVar;
        }
        boolean z3 = eVar3.f17905b == 1;
        int i34 = 0;
        int i35 = 0;
        int i36 = 0;
        boolean z4 = false;
        while (true) {
            long[] jArr6 = eVar3.f17911h;
            j3 = -1;
            if (i35 >= jArr6.length) {
                break;
            }
            long j10 = eVar3.f17912i[i35];
            if (j10 != -1) {
                iArr8 = iArr10;
                str2 = str;
                long d11 = u.d(jArr6[i35], eVar3.f17906c, eVar3.f17907d);
                int b2 = u.b(jArr2, j10, true, true);
                int b3 = u.b(jArr2, d11 + j10, z3, false);
                i34 += b3 - b2;
                boolean z5 = i36 != b2;
                i36 = b3;
                z4 = z5 | z4;
            } else {
                iArr8 = iArr10;
                str2 = str;
            }
            i35++;
            iArr10 = iArr8;
            str = str2;
        }
        int[] iArr11 = iArr10;
        String str3 = str;
        boolean z6 = (i34 != i4) | z4;
        long[] jArr7 = z6 ? new long[i34] : jArr;
        int[] iArr12 = z6 ? new int[i34] : iArr;
        int i37 = z6 ? 0 : i32;
        int[] iArr13 = z6 ? new int[i34] : iArr11;
        long[] jArr8 = new long[i34];
        int i38 = i37;
        int i39 = 0;
        int i40 = 0;
        while (true) {
            long[] jArr9 = eVar3.f17911h;
            if (i39 >= jArr9.length) {
                break;
            }
            int[] iArr14 = iArr;
            int[] iArr15 = iArr12;
            long j11 = eVar3.f17912i[i39];
            long j12 = jArr9[i39];
            if (j11 != j3) {
                int[] iArr16 = iArr13;
                i6 = i39;
                long d12 = u.d(j12, eVar3.f17906c, eVar3.f17907d);
                int b4 = u.b(jArr2, j11, true, true);
                int b5 = u.b(jArr2, d12 + j11, z3, false);
                if (z6) {
                    int i41 = b5 - b4;
                    System.arraycopy(jArr, b4, jArr7, i40, i41);
                    iArr6 = iArr14;
                    iArr4 = iArr15;
                    System.arraycopy(iArr6, b4, iArr4, i40, i41);
                    z2 = z3;
                    iArr5 = iArr11;
                    i7 = i38;
                    iArr7 = iArr16;
                    System.arraycopy(iArr5, b4, iArr7, i40, i41);
                } else {
                    z2 = z3;
                    iArr6 = iArr14;
                    iArr4 = iArr15;
                    iArr5 = iArr11;
                    i7 = i38;
                    iArr7 = iArr16;
                }
                int i42 = i7;
                while (b4 < b5) {
                    int[] iArr17 = iArr7;
                    int[] iArr18 = iArr6;
                    long j13 = j11;
                    jArr8[i40] = u.d(jArr2[b4] - j11, C.MICROS_PER_SECOND, eVar3.f17906c) + u.d(j4, C.MICROS_PER_SECOND, eVar3.f17907d);
                    if (z6 && iArr4[i40] > i42) {
                        i42 = iArr18[b4];
                    }
                    i40++;
                    b4++;
                    iArr6 = iArr18;
                    j11 = j13;
                    iArr7 = iArr17;
                }
                iArr3 = iArr7;
                iArr14 = iArr6;
                i38 = i42;
            } else {
                z2 = z3;
                iArr3 = iArr13;
                i6 = i39;
                iArr4 = iArr15;
                iArr5 = iArr11;
            }
            j4 += j12;
            i39 = i6 + 1;
            iArr11 = iArr5;
            iArr12 = iArr4;
            z3 = z2;
            iArr = iArr14;
            iArr13 = iArr3;
            j3 = -1;
        }
        int[] iArr19 = iArr11;
        int[] iArr20 = iArr;
        int[] iArr21 = iArr12;
        int i43 = i38;
        long d13 = u.d(j4, C.MICROS_PER_SECOND, eVar3.f17906c);
        boolean z7 = false;
        for (int i44 = 0; i44 < iArr13.length && !z7; i44++) {
            z7 |= (iArr13[i44] & 1) != 0;
        }
        if (z7) {
            return new m(jArr7, iArr21, i43, jArr8, iArr13, d13);
        }
        com.opos.cmn.an.f.a.c(str3, "Ignoring edit list: Edited sample sequence does not contain a sync sample.");
        u.a(jArr2, C.MICROS_PER_SECOND, eVar3.f17906c);
        return new m(jArr, iArr20, i32, jArr2, iArr19, d7);
    }

    public static Metadata a(g.b bVar, boolean z) {
        if (!z) {
            com.opos.exoplayer.core.i.m mVar = bVar.aQ;
            mVar.c(8);
            while (mVar.b() >= 8) {
                int d2 = mVar.d();
                int o = mVar.o();
                if (mVar.o() == g.aB) {
                    mVar.c(d2);
                    return a(mVar, d2 + o);
                }
                mVar.d(o - 8);
            }
        }
        return null;
    }

    private static Metadata a(com.opos.exoplayer.core.i.m mVar, int i2) {
        mVar.d(12);
        while (mVar.d() < i2) {
            int d2 = mVar.d();
            int o = mVar.o();
            if (mVar.o() == g.aC) {
                mVar.c(d2);
                return b(mVar, d2 + o);
            }
            mVar.d(o - 8);
        }
        return null;
    }

    private static void a(com.opos.exoplayer.core.i.m mVar, int i2, int i3, int i4, int i5, int i6, DrmInitData drmInitData, c cVar, int i7) {
        DrmInitData drmInitData2 = drmInitData;
        mVar.c(i3 + 8 + 8);
        mVar.d(16);
        int h2 = mVar.h();
        int h3 = mVar.h();
        mVar.d(50);
        int d2 = mVar.d();
        String str = null;
        int i8 = i2;
        if (i8 == g.Z) {
            Pair<Integer, com.opos.exoplayer.core.c.d.f> c2 = c(mVar, i3, i4);
            if (c2 != null) {
                i8 = ((Integer) c2.first).intValue();
                drmInitData2 = drmInitData2 == null ? null : drmInitData2.a(((com.opos.exoplayer.core.c.d.f) c2.second).f17915b);
                cVar.f17946a[i7] = (com.opos.exoplayer.core.c.d.f) c2.second;
            }
            mVar.c(d2);
        }
        DrmInitData drmInitData3 = drmInitData2;
        List<byte[]> list = null;
        byte[] bArr = null;
        boolean z = false;
        float f2 = 1.0f;
        int i9 = -1;
        while (d2 - i3 < i4) {
            mVar.c(d2);
            int d3 = mVar.d();
            int o = mVar.o();
            if (o == 0 && mVar.d() - i3 == i4) {
                break;
            }
            com.opos.exoplayer.core.i.a.a(o > 0, "childAtomSize should be positive");
            int o2 = mVar.o();
            if (o2 == g.H) {
                com.opos.exoplayer.core.i.a.b(str == null);
                mVar.c(d3 + 8);
                com.opos.exoplayer.core.video.a a2 = com.opos.exoplayer.core.video.a.a(mVar);
                list = a2.f19219a;
                cVar.f17948c = a2.f19220b;
                if (!z) {
                    f2 = a2.f19223e;
                }
                str = "video/avc";
            } else if (o2 == g.I) {
                com.opos.exoplayer.core.i.a.b(str == null);
                mVar.c(d3 + 8);
                com.opos.exoplayer.core.video.b a3 = com.opos.exoplayer.core.video.b.a(mVar);
                list = a3.f19224a;
                cVar.f17948c = a3.f19225b;
                str = "video/hevc";
            } else if (o2 == g.aM) {
                com.opos.exoplayer.core.i.a.b(str == null);
                str = i8 == g.aK ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
            } else if (o2 == g.f17926g) {
                com.opos.exoplayer.core.i.a.b(str == null);
                str = "video/3gpp";
            } else if (o2 == g.J) {
                com.opos.exoplayer.core.i.a.b(str == null);
                Pair<String, byte[]> d4 = d(mVar, d3);
                str = (String) d4.first;
                list = Collections.singletonList(d4.second);
            } else if (o2 == g.ai) {
                f2 = c(mVar, d3);
                z = true;
            } else if (o2 == g.aI) {
                bArr = d(mVar, d3, o);
            } else if (o2 == g.aH) {
                int g2 = mVar.g();
                mVar.d(3);
                if (g2 == 0) {
                    int g3 = mVar.g();
                    if (g3 == 0) {
                        i9 = 0;
                    } else if (g3 == 1) {
                        i9 = 1;
                    } else if (g3 == 2) {
                        i9 = 2;
                    } else if (g3 == 3) {
                        i9 = 3;
                    }
                }
            }
            d2 += o;
        }
        if (str == null) {
            return;
        }
        cVar.f17947b = Format.a(Integer.toString(i5), str, (String) null, -1, -1, h2, h3, -1.0f, list, i6, f2, bArr, i9, (ColorInfo) null, drmInitData3);
    }

    private static void a(com.opos.exoplayer.core.i.m mVar, int i2, int i3, int i4, int i5, String str, c cVar) {
        mVar.c(i3 + 8 + 8);
        String str2 = "application/ttml+xml";
        List list = null;
        long j2 = Long.MAX_VALUE;
        if (i2 != g.aj) {
            if (i2 == g.au) {
                int i6 = (i4 - 8) - 8;
                byte[] bArr = new byte[i6];
                mVar.a(bArr, 0, i6);
                list = Collections.singletonList(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i2 == g.av) {
                str2 = "application/x-mp4-vtt";
            } else if (i2 == g.aw) {
                j2 = 0;
            } else {
                if (i2 != g.ax) {
                    throw new IllegalStateException();
                }
                cVar.f17949d = 1;
                str2 = "application/x-mp4-cea-608";
            }
        }
        cVar.f17947b = Format.a(Integer.toString(i5), str2, null, -1, 0, str, -1, null, j2, list);
    }

    private static void a(com.opos.exoplayer.core.i.m mVar, int i2, int i3, int i4, int i5, String str, boolean z, DrmInitData drmInitData, c cVar, int i6) {
        int i7;
        int i8;
        int i9;
        String str2;
        String str3;
        DrmInitData drmInitData2;
        int i10;
        Format b2;
        int i11 = i3;
        DrmInitData drmInitData3 = drmInitData;
        mVar.c(i11 + 8 + 8);
        if (z) {
            i7 = mVar.h();
            mVar.d(6);
        } else {
            mVar.d(8);
            i7 = 0;
        }
        if (i7 == 0 || i7 == 1) {
            int h2 = mVar.h();
            mVar.d(6);
            int s = mVar.s();
            if (i7 == 1) {
                mVar.d(16);
            }
            i8 = s;
            i9 = h2;
        } else {
            if (i7 != 2) {
                return;
            }
            mVar.d(16);
            i8 = (int) Math.round(mVar.x());
            i9 = mVar.u();
            mVar.d(20);
        }
        int d2 = mVar.d();
        int i12 = i2;
        if (i12 == g.aa) {
            Pair<Integer, com.opos.exoplayer.core.c.d.f> c2 = c(mVar, i11, i4);
            if (c2 != null) {
                i12 = ((Integer) c2.first).intValue();
                drmInitData3 = drmInitData3 == null ? null : drmInitData3.a(((com.opos.exoplayer.core.c.d.f) c2.second).f17915b);
                cVar.f17946a[i6] = (com.opos.exoplayer.core.c.d.f) c2.second;
            }
            mVar.c(d2);
        }
        DrmInitData drmInitData4 = drmInitData3;
        String str4 = "audio/raw";
        String str5 = i12 == g.n ? "audio/ac3" : i12 == g.p ? "audio/eac3" : i12 == g.r ? "audio/vnd.dts" : (i12 == g.s || i12 == g.t) ? "audio/vnd.dts.hd" : i12 == g.u ? "audio/vnd.dts.hd;profile=lbr" : i12 == g.ay ? "audio/3gpp" : i12 == g.az ? "audio/amr-wb" : (i12 == g.l || i12 == g.m) ? "audio/raw" : i12 == g.f17929j ? "audio/mpeg" : i12 == g.aO ? "audio/alac" : null;
        int i13 = i9;
        int i14 = i8;
        int i15 = d2;
        byte[] bArr = null;
        while (i15 - i11 < i4) {
            mVar.c(i15);
            int o = mVar.o();
            com.opos.exoplayer.core.i.a.a(o > 0, "childAtomSize should be positive");
            int o2 = mVar.o();
            int i16 = g.J;
            if (o2 == i16 || (z && o2 == g.k)) {
                str2 = str5;
                str3 = str4;
                drmInitData2 = drmInitData4;
                int b3 = o2 == i16 ? i15 : b(mVar, i15, o);
                if (b3 != -1) {
                    Pair<String, byte[]> d3 = d(mVar, b3);
                    str5 = (String) d3.first;
                    bArr = (byte[]) d3.second;
                    if ("audio/mp4a-latm".equals(str5)) {
                        Pair<Integer, Integer> a2 = com.opos.exoplayer.core.i.c.a(bArr);
                        i14 = ((Integer) a2.first).intValue();
                        i13 = ((Integer) a2.second).intValue();
                    }
                    i15 += o;
                    i11 = i3;
                    drmInitData4 = drmInitData2;
                    str4 = str3;
                }
            } else {
                if (o2 == g.o) {
                    mVar.c(i15 + 8);
                    b2 = com.opos.exoplayer.core.a.a.a(mVar, Integer.toString(i5), str, drmInitData4);
                } else if (o2 == g.q) {
                    mVar.c(i15 + 8);
                    b2 = com.opos.exoplayer.core.a.a.b(mVar, Integer.toString(i5), str, drmInitData4);
                } else {
                    if (o2 == g.v) {
                        str2 = str5;
                        str3 = str4;
                        drmInitData2 = drmInitData4;
                        i10 = i15;
                        cVar.f17947b = Format.a(Integer.toString(i5), str5, null, -1, -1, i13, i14, null, drmInitData2, 0, str);
                        o = o;
                    } else {
                        i10 = i15;
                        str2 = str5;
                        str3 = str4;
                        drmInitData2 = drmInitData4;
                        if (o2 == g.aO) {
                            byte[] bArr2 = new byte[o];
                            i15 = i10;
                            mVar.c(i15);
                            mVar.a(bArr2, 0, o);
                            bArr = bArr2;
                        }
                    }
                    i15 = i10;
                }
                cVar.f17947b = b2;
                str2 = str5;
                str3 = str4;
                drmInitData2 = drmInitData4;
            }
            str5 = str2;
            i15 += o;
            i11 = i3;
            drmInitData4 = drmInitData2;
            str4 = str3;
        }
        String str6 = str5;
        String str7 = str4;
        DrmInitData drmInitData5 = drmInitData4;
        if (cVar.f17947b != null || str6 == null) {
            return;
        }
        cVar.f17947b = Format.a(Integer.toString(i5), str6, (String) null, -1, -1, i13, i14, str7.equals(str6) ? 2 : -1, (List<byte[]>) (bArr != null ? Collections.singletonList(bArr) : null), drmInitData5, 0, str);
    }

    private static int b(com.opos.exoplayer.core.i.m mVar, int i2, int i3) {
        int d2 = mVar.d();
        while (d2 - i2 < i3) {
            mVar.c(d2);
            int o = mVar.o();
            com.opos.exoplayer.core.i.a.a(o > 0, "childAtomSize should be positive");
            if (mVar.o() == g.J) {
                return d2;
            }
            d2 += o;
        }
        return -1;
    }

    private static f b(com.opos.exoplayer.core.i.m mVar) {
        boolean z;
        mVar.c(8);
        int a2 = g.a(mVar.o());
        mVar.d(a2 == 0 ? 8 : 16);
        int o = mVar.o();
        mVar.d(4);
        int d2 = mVar.d();
        int i2 = a2 == 0 ? 4 : 8;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                z = true;
                break;
            }
            if (mVar.f19048a[d2 + i4] != -1) {
                z = false;
                break;
            }
            i4++;
        }
        long j2 = C.TIME_UNSET;
        if (z) {
            mVar.d(i2);
        } else {
            long m = a2 == 0 ? mVar.m() : mVar.w();
            if (m != 0) {
                j2 = m;
            }
        }
        mVar.d(16);
        int o2 = mVar.o();
        int o3 = mVar.o();
        mVar.d(4);
        int o4 = mVar.o();
        int o5 = mVar.o();
        if (o2 == 0 && o3 == 65536 && o4 == -65536 && o5 == 0) {
            i3 = 90;
        } else if (o2 == 0 && o3 == -65536 && o4 == 65536 && o5 == 0) {
            i3 = 270;
        } else if (o2 == -65536 && o3 == 0 && o4 == 0 && o5 == -65536) {
            i3 = TinkerReport.KEY_APPLIED_VERSION_CHECK;
        }
        return new f(o, j2, i3);
    }

    private static Metadata b(com.opos.exoplayer.core.i.m mVar, int i2) {
        mVar.d(8);
        ArrayList arrayList = new ArrayList();
        while (mVar.d() < i2) {
            Metadata.Entry a2 = j.a(mVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static float c(com.opos.exoplayer.core.i.m mVar, int i2) {
        mVar.c(i2 + 8);
        return mVar.u() / mVar.u();
    }

    private static int c(com.opos.exoplayer.core.i.m mVar) {
        mVar.c(16);
        int o = mVar.o();
        if (o == f17931b) {
            return 1;
        }
        if (o == f17930a) {
            return 2;
        }
        if (o == f17932c || o == f17933d || o == f17934e || o == f17935f) {
            return 3;
        }
        return o == f17936g ? 4 : -1;
    }

    private static Pair<Integer, com.opos.exoplayer.core.c.d.f> c(com.opos.exoplayer.core.i.m mVar, int i2, int i3) {
        Pair<Integer, com.opos.exoplayer.core.c.d.f> a2;
        int d2 = mVar.d();
        while (d2 - i2 < i3) {
            mVar.c(d2);
            int o = mVar.o();
            com.opos.exoplayer.core.i.a.a(o > 0, "childAtomSize should be positive");
            if (mVar.o() == g.V && (a2 = a(mVar, d2, o)) != null) {
                return a2;
            }
            d2 += o;
        }
        return null;
    }

    private static Pair<Long, String> d(com.opos.exoplayer.core.i.m mVar) {
        mVar.c(8);
        int a2 = g.a(mVar.o());
        mVar.d(a2 == 0 ? 8 : 16);
        long m = mVar.m();
        mVar.d(a2 == 0 ? 4 : 8);
        int h2 = mVar.h();
        return Pair.create(Long.valueOf(m), "" + ((char) (((h2 >> 10) & 31) + 96)) + ((char) (((h2 >> 5) & 31) + 96)) + ((char) ((h2 & 31) + 96)));
    }

    private static Pair<String, byte[]> d(com.opos.exoplayer.core.i.m mVar, int i2) {
        mVar.c(i2 + 8 + 4);
        mVar.d(1);
        e(mVar);
        mVar.d(2);
        int g2 = mVar.g();
        if ((g2 & 128) != 0) {
            mVar.d(2);
        }
        if ((g2 & 64) != 0) {
            mVar.d(mVar.h());
        }
        if ((g2 & 32) != 0) {
            mVar.d(2);
        }
        mVar.d(1);
        e(mVar);
        String a2 = com.opos.exoplayer.core.i.j.a(mVar.g());
        if ("audio/mpeg".equals(a2) || "audio/vnd.dts".equals(a2) || "audio/vnd.dts.hd".equals(a2)) {
            return Pair.create(a2, null);
        }
        mVar.d(12);
        mVar.d(1);
        int e2 = e(mVar);
        byte[] bArr = new byte[e2];
        mVar.a(bArr, 0, e2);
        return Pair.create(a2, bArr);
    }

    private static byte[] d(com.opos.exoplayer.core.i.m mVar, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            mVar.c(i4);
            int o = mVar.o();
            if (mVar.o() == g.aJ) {
                return Arrays.copyOfRange(mVar.f19048a, i4, o + i4);
            }
            i4 += o;
        }
        return null;
    }

    private static int e(com.opos.exoplayer.core.i.m mVar) {
        int g2 = mVar.g();
        int i2 = g2 & 127;
        while ((g2 & 128) == 128) {
            g2 = mVar.g();
            i2 = (i2 << 7) | (g2 & 127);
        }
        return i2;
    }
}
