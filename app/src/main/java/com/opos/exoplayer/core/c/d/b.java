package com.opos.exoplayer.core.c.d;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.d.g;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.s;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.o;
import com.vivo.advv.virtualview.common.ExprCommon;
import com.vivo.google.android.exoplayer3.C;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class b implements com.opos.exoplayer.core.c.e {

    /* renamed from: a */
    public static final com.opos.exoplayer.core.c.h f17868a = new com.opos.exoplayer.core.c.h() { // from class: com.opos.exoplayer.core.c.d.b.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new b()};
        }
    };

    /* renamed from: b */
    private static final int f17869b = u.f("seig");

    /* renamed from: c */
    private static final byte[] f17870c = {-94, 57, 79, 82, 90, -101, 79, ExprCommon.OPCODE_MOD_EQ, -94, 68, 108, 66, 124, 100, -115, -12};

    /* renamed from: d */
    private static final Format f17871d = Format.a((String) null, "application/x-emsg", Long.MAX_VALUE);
    private int A;
    private long B;
    private long C;
    private C0402b D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private com.opos.exoplayer.core.c.g I;
    private n[] J;
    private n[] K;
    private boolean L;

    /* renamed from: e */
    private final int f17872e;

    /* renamed from: f */
    private final e f17873f;

    /* renamed from: g */
    private final List<Format> f17874g;

    /* renamed from: h */
    private final DrmInitData f17875h;

    /* renamed from: i */
    private final SparseArray<C0402b> f17876i;

    /* renamed from: j */
    private final com.opos.exoplayer.core.i.m f17877j;
    private final com.opos.exoplayer.core.i.m k;
    private final com.opos.exoplayer.core.i.m l;
    private final com.opos.exoplayer.core.i.m m;
    private final com.opos.exoplayer.core.i.m n;
    private final s o;
    private final com.opos.exoplayer.core.i.m p;
    private final byte[] q;
    private final Stack<g.a> r;
    private final ArrayDeque<a> s;

    @Nullable
    private final n t;
    private int u;
    private int v;
    private long w;
    private int x;
    private com.opos.exoplayer.core.i.m y;
    private long z;

    /* renamed from: com.opos.exoplayer.core.c.d.b$1 */
    static final class AnonymousClass1 implements com.opos.exoplayer.core.c.h {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new b()};
        }
    }

    private static final class a {

        /* renamed from: a */
        public final long f17878a;

        /* renamed from: b */
        public final int f17879b;

        public a(long j2, int i2) {
            this.f17878a = j2;
            this.f17879b = i2;
        }
    }

    /* renamed from: com.opos.exoplayer.core.c.d.b$b */
    private static final class C0402b {

        /* renamed from: a */
        public final l f17880a = new l();

        /* renamed from: b */
        public final n f17881b;

        /* renamed from: c */
        public e f17882c;

        /* renamed from: d */
        public i f17883d;

        /* renamed from: e */
        public int f17884e;

        /* renamed from: f */
        public int f17885f;

        /* renamed from: g */
        public int f17886g;

        public C0402b(n nVar) {
            this.f17881b = nVar;
        }

        public void a() {
            this.f17880a.a();
            this.f17884e = 0;
            this.f17886g = 0;
            this.f17885f = 0;
        }

        public void a(e eVar, i iVar) {
            this.f17882c = (e) com.opos.exoplayer.core.i.a.a(eVar);
            this.f17883d = (i) com.opos.exoplayer.core.i.a.a(iVar);
            this.f17881b.a(eVar.f17909f);
            a();
        }

        public void a(DrmInitData drmInitData) {
            f a2 = this.f17882c.a(this.f17880a.f17976a.f17961a);
            this.f17881b.a(this.f17882c.f17909f.a(drmInitData.a(a2 != null ? a2.f17915b : null)));
        }
    }

    public b() {
        this(0);
    }

    public b(int i2) {
        this(i2, null);
    }

    public b(int i2, s sVar) {
        this(i2, sVar, null, null);
    }

    public b(int i2, s sVar, e eVar, DrmInitData drmInitData) {
        this(i2, sVar, eVar, drmInitData, Collections.emptyList());
    }

    public b(int i2, s sVar, e eVar, DrmInitData drmInitData, List<Format> list) {
        this(i2, sVar, eVar, drmInitData, list, null);
    }

    public b(int i2, s sVar, e eVar, DrmInitData drmInitData, List<Format> list, @Nullable n nVar) {
        this.f17872e = i2 | (eVar != null ? 8 : 0);
        this.o = sVar;
        this.f17873f = eVar;
        this.f17875h = drmInitData;
        this.f17874g = Collections.unmodifiableList(list);
        this.t = nVar;
        this.p = new com.opos.exoplayer.core.i.m(16);
        this.f17877j = new com.opos.exoplayer.core.i.m(com.opos.exoplayer.core.i.k.f19027a);
        this.k = new com.opos.exoplayer.core.i.m(5);
        this.l = new com.opos.exoplayer.core.i.m();
        this.m = new com.opos.exoplayer.core.i.m(1);
        this.n = new com.opos.exoplayer.core.i.m();
        this.q = new byte[16];
        this.r = new Stack<>();
        this.s = new ArrayDeque<>();
        this.f17876i = new SparseArray<>();
        this.B = C.TIME_UNSET;
        this.C = C.TIME_UNSET;
        a();
    }

    private int a(C0402b c0402b) {
        com.opos.exoplayer.core.i.m mVar;
        l lVar = c0402b.f17880a;
        int i2 = lVar.f17976a.f17961a;
        f fVar = lVar.o;
        if (fVar == null) {
            fVar = c0402b.f17882c.a(i2);
        }
        int i3 = fVar.f17917d;
        if (i3 != 0) {
            mVar = lVar.q;
        } else {
            byte[] bArr = fVar.f17918e;
            this.n.a(bArr, bArr.length);
            mVar = this.n;
            i3 = bArr.length;
        }
        boolean z = lVar.n[c0402b.f17884e];
        com.opos.exoplayer.core.i.m mVar2 = this.m;
        mVar2.f19048a[0] = (byte) ((z ? 128 : 0) | i3);
        mVar2.c(0);
        n nVar = c0402b.f17881b;
        nVar.a(this.m, 1);
        nVar.a(mVar, i3);
        if (!z) {
            return i3 + 1;
        }
        com.opos.exoplayer.core.i.m mVar3 = lVar.q;
        int h2 = mVar3.h();
        mVar3.d(-2);
        int i4 = (h2 * 6) + 2;
        nVar.a(mVar3, i4);
        return i3 + 1 + i4;
    }

    private static int a(C0402b c0402b, int i2, long j2, int i3, com.opos.exoplayer.core.i.m mVar, int i4) {
        boolean z;
        int i5;
        boolean z2;
        int i6;
        boolean z3;
        int i7;
        int i8;
        int i9;
        mVar.c(8);
        int b2 = g.b(mVar.o());
        e eVar = c0402b.f17882c;
        l lVar = c0402b.f17880a;
        i iVar = lVar.f17976a;
        lVar.f17983h[i2] = mVar.u();
        long[] jArr = lVar.f17982g;
        jArr[i2] = lVar.f17978c;
        if ((b2 & 1) != 0) {
            jArr[i2] = jArr[i2] + mVar.o();
        }
        boolean z4 = (b2 & 4) != 0;
        int i10 = iVar.f17964d;
        if (z4) {
            i10 = mVar.u();
        }
        boolean z5 = (b2 & 256) != 0;
        boolean z6 = (b2 & 512) != 0;
        boolean z7 = (b2 & 1024) != 0;
        boolean z8 = (b2 & 2048) != 0;
        long[] jArr2 = eVar.f17911h;
        long j3 = 0;
        if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
            j3 = u.d(eVar.f17912i[0], 1000L, eVar.f17906c);
        }
        int[] iArr = lVar.f17984i;
        int[] iArr2 = lVar.f17985j;
        long[] jArr3 = lVar.k;
        boolean[] zArr = lVar.l;
        int i11 = i10;
        boolean z9 = eVar.f17905b == 2 && (i3 & 1) != 0;
        int i12 = i4 + lVar.f17983h[i2];
        long j4 = eVar.f17906c;
        long j5 = j3;
        long j6 = i2 > 0 ? lVar.s : j2;
        int i13 = i4;
        while (i13 < i12) {
            if (z5) {
                z = z5;
                i5 = mVar.u();
            } else {
                z = z5;
                i5 = iVar.f17962b;
            }
            if (z6) {
                z2 = z6;
                i6 = mVar.u();
            } else {
                z2 = z6;
                i6 = iVar.f17963c;
            }
            if (i13 == 0 && z4) {
                z3 = z4;
                i7 = i11;
            } else if (z7) {
                z3 = z4;
                i7 = mVar.o();
            } else {
                z3 = z4;
                i7 = iVar.f17964d;
            }
            boolean z10 = z8;
            if (z8) {
                i8 = i12;
                i9 = i5;
                iArr2[i13] = (int) ((mVar.o() * 1000) / j4);
            } else {
                i8 = i12;
                i9 = i5;
                iArr2[i13] = 0;
            }
            jArr3[i13] = u.d(j6, 1000L, j4) - j5;
            iArr[i13] = i6;
            zArr[i13] = ((i7 >> 16) & 1) == 0 && (!z9 || i13 == 0);
            j6 += i9;
            i13++;
            z5 = z;
            z6 = z2;
            z4 = z3;
            z8 = z10;
            i12 = i8;
        }
        int i14 = i12;
        lVar.s = j6;
        return i14;
    }

    private static Pair<Long, com.opos.exoplayer.core.c.a> a(com.opos.exoplayer.core.i.m mVar, long j2) {
        long w;
        long w2;
        mVar.c(8);
        int a2 = g.a(mVar.o());
        mVar.d(4);
        long m = mVar.m();
        if (a2 == 0) {
            w = mVar.m();
            w2 = mVar.m();
        } else {
            w = mVar.w();
            w2 = mVar.w();
        }
        long j3 = w;
        long j4 = w2 + j2;
        long d2 = u.d(j3, C.MICROS_PER_SECOND, m);
        mVar.d(2);
        int h2 = mVar.h();
        int[] iArr = new int[h2];
        long[] jArr = new long[h2];
        long[] jArr2 = new long[h2];
        long[] jArr3 = new long[h2];
        long j5 = j3;
        long j6 = d2;
        int i2 = 0;
        while (i2 < h2) {
            int o = mVar.o();
            if ((o & Integer.MIN_VALUE) != 0) {
                throw new o("Unhandled indirect reference");
            }
            long m2 = mVar.m();
            iArr[i2] = o & Integer.MAX_VALUE;
            jArr[i2] = j4;
            jArr3[i2] = j6;
            long j7 = j5 + m2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i3 = h2;
            long d3 = u.d(j7, C.MICROS_PER_SECOND, m);
            jArr4[i2] = d3 - jArr5[i2];
            mVar.d(4);
            j4 += r1[i2];
            i2++;
            iArr = iArr;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            h2 = i3;
            j5 = j7;
            j6 = d3;
        }
        return Pair.create(Long.valueOf(d2), new com.opos.exoplayer.core.c.a(iArr, jArr, jArr2, jArr3));
    }

    private static C0402b a(SparseArray<C0402b> sparseArray) {
        int size = sparseArray.size();
        C0402b c0402b = null;
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            C0402b valueAt = sparseArray.valueAt(i2);
            int i3 = valueAt.f17886g;
            l lVar = valueAt.f17880a;
            if (i3 != lVar.f17980e) {
                long j3 = lVar.f17982g[i3];
                if (j3 < j2) {
                    c0402b = valueAt;
                    j2 = j3;
                }
            }
        }
        return c0402b;
    }

    private static C0402b a(com.opos.exoplayer.core.i.m mVar, SparseArray<C0402b> sparseArray, int i2) {
        mVar.c(8);
        int b2 = g.b(mVar.o());
        int o = mVar.o();
        if ((i2 & 8) != 0) {
            o = 0;
        }
        C0402b c0402b = sparseArray.get(o);
        if (c0402b == null) {
            return null;
        }
        if ((b2 & 1) != 0) {
            long w = mVar.w();
            l lVar = c0402b.f17880a;
            lVar.f17978c = w;
            lVar.f17979d = w;
        }
        i iVar = c0402b.f17883d;
        c0402b.f17880a.f17976a = new i((b2 & 2) != 0 ? mVar.u() - 1 : iVar.f17961a, (b2 & 8) != 0 ? mVar.u() : iVar.f17962b, (b2 & 16) != 0 ? mVar.u() : iVar.f17963c, (b2 & 32) != 0 ? mVar.u() : iVar.f17964d);
        return c0402b;
    }

    private static DrmInitData a(List<g.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            g.b bVar = list.get(i2);
            if (bVar.aP == g.U) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.aQ.f19048a;
                UUID a2 = d.a(bArr);
                if (a2 == null) {
                    com.opos.cmn.an.f.a.c("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(a2, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private void a() {
        this.u = 0;
        this.x = 0;
    }

    private void a(long j2) {
        while (!this.r.isEmpty() && this.r.peek().aQ == j2) {
            a(this.r.pop());
        }
        a();
    }

    private static void a(f fVar, com.opos.exoplayer.core.i.m mVar, l lVar) {
        int i2;
        int i3 = fVar.f17917d;
        mVar.c(8);
        if ((g.b(mVar.o()) & 1) == 1) {
            mVar.d(8);
        }
        int g2 = mVar.g();
        int u = mVar.u();
        if (u != lVar.f17981f) {
            throw new o("Length mismatch: " + u + ", " + lVar.f17981f);
        }
        if (g2 == 0) {
            boolean[] zArr = lVar.n;
            i2 = 0;
            int i4 = 0;
            while (i4 < u) {
                int g3 = mVar.g();
                zArr[i4] = g3 > i3;
                i4++;
                i2 += g3;
            }
        } else {
            i2 = (g2 * u) + 0;
            Arrays.fill(lVar.n, 0, u, g2 > i3);
        }
        lVar.a(i2);
    }

    private void a(g.a aVar) {
        int i2 = aVar.aP;
        if (i2 == g.B) {
            b(aVar);
        } else if (i2 == g.K) {
            c(aVar);
        } else {
            if (this.r.isEmpty()) {
                return;
            }
            this.r.peek().a(aVar);
        }
    }

    private static void a(g.a aVar, SparseArray<C0402b> sparseArray, int i2, byte[] bArr) {
        int size = aVar.aS.size();
        for (int i3 = 0; i3 < size; i3++) {
            g.a aVar2 = aVar.aS.get(i3);
            if (aVar2.aP == g.L) {
                b(aVar2, sparseArray, i2, bArr);
            }
        }
    }

    private static void a(g.a aVar, C0402b c0402b, long j2, int i2) {
        List<g.b> list = aVar.aR;
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            g.b bVar = list.get(i5);
            if (bVar.aP == g.z) {
                com.opos.exoplayer.core.i.m mVar = bVar.aQ;
                mVar.c(12);
                int u = mVar.u();
                if (u > 0) {
                    i4 += u;
                    i3++;
                }
            }
        }
        c0402b.f17886g = 0;
        c0402b.f17885f = 0;
        c0402b.f17884e = 0;
        c0402b.f17880a.a(i3, i4);
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            g.b bVar2 = list.get(i8);
            if (bVar2.aP == g.z) {
                int i9 = i7;
                i7++;
                i6 = a(c0402b, i9, j2, i2, bVar2.aQ, i6);
            }
        }
    }

    private void a(g.b bVar, long j2) {
        if (!this.r.isEmpty()) {
            this.r.peek().a(bVar);
            return;
        }
        int i2 = bVar.aP;
        if (i2 != g.A) {
            if (i2 == g.aG) {
                a(bVar.aQ);
            }
        } else {
            Pair<Long, com.opos.exoplayer.core.c.a> a2 = a(bVar.aQ, j2);
            this.C = ((Long) a2.first).longValue();
            this.I.a((com.opos.exoplayer.core.c.l) a2.second);
            this.L = true;
        }
    }

    private void a(com.opos.exoplayer.core.i.m mVar) {
        n[] nVarArr = this.J;
        if (nVarArr == null || nVarArr.length == 0) {
            return;
        }
        mVar.c(12);
        int b2 = mVar.b();
        mVar.y();
        mVar.y();
        long d2 = u.d(mVar.m(), C.MICROS_PER_SECOND, mVar.m());
        for (n nVar : this.J) {
            mVar.c(12);
            nVar.a(mVar, b2);
        }
        if (this.C == C.TIME_UNSET) {
            this.s.addLast(new a(d2, b2));
            this.A += b2;
            return;
        }
        for (n nVar2 : this.J) {
            nVar2.a(this.C + d2, 1, b2, 0, null);
        }
    }

    private static void a(com.opos.exoplayer.core.i.m mVar, int i2, l lVar) {
        mVar.c(i2 + 8);
        int b2 = g.b(mVar.o());
        if ((b2 & 1) != 0) {
            throw new o("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (b2 & 2) != 0;
        int u = mVar.u();
        if (u == lVar.f17981f) {
            Arrays.fill(lVar.n, 0, u, z);
            lVar.a(mVar.b());
            lVar.a(mVar);
        } else {
            throw new o("Length mismatch: " + u + ", " + lVar.f17981f);
        }
    }

    private static void a(com.opos.exoplayer.core.i.m mVar, l lVar) {
        mVar.c(8);
        int o = mVar.o();
        if ((g.b(o) & 1) == 1) {
            mVar.d(8);
        }
        int u = mVar.u();
        if (u == 1) {
            lVar.f17979d = (g.a(o) == 0 ? mVar.m() : mVar.w()) + lVar.f17979d;
        } else {
            throw new o("Unexpected saio entry count: " + u);
        }
    }

    private static void a(com.opos.exoplayer.core.i.m mVar, l lVar, byte[] bArr) {
        mVar.c(8);
        mVar.a(bArr, 0, 16);
        if (Arrays.equals(bArr, f17870c)) {
            a(mVar, 16, lVar);
        }
    }

    private static void a(com.opos.exoplayer.core.i.m mVar, com.opos.exoplayer.core.i.m mVar2, String str, l lVar) {
        byte[] bArr;
        mVar.c(8);
        int o = mVar.o();
        int o2 = mVar.o();
        int i2 = f17869b;
        if (o2 != i2) {
            return;
        }
        if (g.a(o) == 1) {
            mVar.d(4);
        }
        if (mVar.o() != 1) {
            throw new o("Entry count in sbgp != 1 (unsupported).");
        }
        mVar2.c(8);
        int o3 = mVar2.o();
        if (mVar2.o() == i2) {
            int a2 = g.a(o3);
            if (a2 == 1) {
                if (mVar2.m() == 0) {
                    throw new o("Variable length description in sgpd found (unsupported)");
                }
            } else if (a2 >= 2) {
                mVar2.d(4);
            }
            if (mVar2.m() != 1) {
                throw new o("Entry count in sgpd != 1 (unsupported).");
            }
            mVar2.d(1);
            int g2 = mVar2.g();
            boolean z = mVar2.g() == 1;
            if (z) {
                int g3 = mVar2.g();
                byte[] bArr2 = new byte[16];
                mVar2.a(bArr2, 0, 16);
                if (z && g3 == 0) {
                    int g4 = mVar2.g();
                    byte[] bArr3 = new byte[g4];
                    mVar2.a(bArr3, 0, g4);
                    bArr = bArr3;
                } else {
                    bArr = null;
                }
                lVar.m = true;
                lVar.o = new f(z, str, g3, bArr2, (g2 & org.mozilla.universalchardet.prober.g.n) >> 4, g2 & 15, bArr);
            }
        }
    }

    private static boolean a(int i2) {
        return i2 == g.S || i2 == g.R || i2 == g.C || i2 == g.A || i2 == g.T || i2 == g.w || i2 == g.x || i2 == g.O || i2 == g.y || i2 == g.z || i2 == g.U || i2 == g.ac || i2 == g.f17920ad || i2 == g.ah || i2 == g.ag || i2 == g.ae || i2 == g.af || i2 == g.Q || i2 == g.N || i2 == g.aG;
    }

    private static Pair<Integer, i> b(com.opos.exoplayer.core.i.m mVar) {
        mVar.c(12);
        return Pair.create(Integer.valueOf(mVar.o()), new i(mVar.u() - 1, mVar.u(), mVar.u(), mVar.o()));
    }

    private void b() {
        int i2;
        if (this.J == null) {
            n[] nVarArr = new n[2];
            this.J = nVarArr;
            n nVar = this.t;
            if (nVar != null) {
                nVarArr[0] = nVar;
                i2 = 1;
            } else {
                i2 = 0;
            }
            if ((this.f17872e & 4) != 0) {
                nVarArr[i2] = this.I.a(this.f17876i.size(), 4);
                i2++;
            }
            n[] nVarArr2 = (n[]) Arrays.copyOf(this.J, i2);
            this.J = nVarArr2;
            for (n nVar2 : nVarArr2) {
                nVar2.a(f17871d);
            }
        }
        if (this.K == null) {
            this.K = new n[this.f17874g.size()];
            for (int i3 = 0; i3 < this.K.length; i3++) {
                n a2 = this.I.a(this.f17876i.size() + 1 + i3, 3);
                a2.a(this.f17874g.get(i3));
                this.K[i3] = a2;
            }
        }
    }

    private void b(long j2) {
        while (!this.s.isEmpty()) {
            a removeFirst = this.s.removeFirst();
            this.A -= removeFirst.f17879b;
            for (n nVar : this.J) {
                nVar.a(removeFirst.f17878a + j2, 1, removeFirst.f17879b, this.A, null);
            }
        }
    }

    private void b(g.a aVar) {
        int i2;
        int i3;
        int i4 = 0;
        com.opos.exoplayer.core.i.a.b(this.f17873f == null, "Unexpected moov box.");
        DrmInitData drmInitData = this.f17875h;
        if (drmInitData == null) {
            drmInitData = a(aVar.aR);
        }
        g.a e2 = aVar.e(g.M);
        SparseArray sparseArray = new SparseArray();
        int size = e2.aR.size();
        long j2 = -9223372036854775807L;
        for (int i5 = 0; i5 < size; i5++) {
            g.b bVar = e2.aR.get(i5);
            int i6 = bVar.aP;
            if (i6 == g.y) {
                Pair<Integer, i> b2 = b(bVar.aQ);
                sparseArray.put(((Integer) b2.first).intValue(), b2.second);
            } else if (i6 == g.N) {
                j2 = c(bVar.aQ);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = aVar.aS.size();
        int i7 = 0;
        while (i7 < size2) {
            g.a aVar2 = aVar.aS.get(i7);
            if (aVar2.aP == g.D) {
                i2 = i7;
                i3 = size2;
                e a2 = h.a(aVar2, aVar.d(g.C), j2, drmInitData, (this.f17872e & 16) != 0, false);
                if (a2 != null) {
                    sparseArray2.put(a2.f17904a, a2);
                }
            } else {
                i2 = i7;
                i3 = size2;
            }
            i7 = i2 + 1;
            size2 = i3;
        }
        int size3 = sparseArray2.size();
        if (this.f17876i.size() != 0) {
            com.opos.exoplayer.core.i.a.b(this.f17876i.size() == size3);
            while (i4 < size3) {
                e eVar = (e) sparseArray2.valueAt(i4);
                this.f17876i.get(eVar.f17904a).a(eVar, (i) sparseArray.get(eVar.f17904a));
                i4++;
            }
            return;
        }
        while (i4 < size3) {
            e eVar2 = (e) sparseArray2.valueAt(i4);
            C0402b c0402b = new C0402b(this.I.a(i4, eVar2.f17905b));
            c0402b.a(eVar2, (i) sparseArray.get(eVar2.f17904a));
            this.f17876i.put(eVar2.f17904a, c0402b);
            this.B = Math.max(this.B, eVar2.f17908e);
            i4++;
        }
        b();
        this.I.a();
    }

    private static void b(g.a aVar, SparseArray<C0402b> sparseArray, int i2, byte[] bArr) {
        C0402b a2 = a(aVar.d(g.x).aQ, sparseArray, i2);
        if (a2 == null) {
            return;
        }
        l lVar = a2.f17880a;
        long j2 = lVar.s;
        a2.a();
        int i3 = g.w;
        if (aVar.d(i3) != null && (i2 & 2) == 0) {
            j2 = d(aVar.d(i3).aQ);
        }
        a(aVar, a2, j2, i2);
        f a3 = a2.f17882c.a(lVar.f17976a.f17961a);
        g.b d2 = aVar.d(g.ac);
        if (d2 != null) {
            a(a3, d2.aQ, lVar);
        }
        g.b d3 = aVar.d(g.f17920ad);
        if (d3 != null) {
            a(d3.aQ, lVar);
        }
        g.b d4 = aVar.d(g.ah);
        if (d4 != null) {
            b(d4.aQ, lVar);
        }
        g.b d5 = aVar.d(g.ae);
        g.b d6 = aVar.d(g.af);
        if (d5 != null && d6 != null) {
            a(d5.aQ, d6.aQ, a3 != null ? a3.f17915b : null, lVar);
        }
        int size = aVar.aR.size();
        for (int i4 = 0; i4 < size; i4++) {
            g.b bVar = aVar.aR.get(i4);
            if (bVar.aP == g.ag) {
                a(bVar.aQ, lVar, bArr);
            }
        }
    }

    private static void b(com.opos.exoplayer.core.i.m mVar, l lVar) {
        a(mVar, 0, lVar);
    }

    private static boolean b(int i2) {
        return i2 == g.B || i2 == g.D || i2 == g.E || i2 == g.F || i2 == g.G || i2 == g.K || i2 == g.L || i2 == g.M || i2 == g.P;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(com.opos.exoplayer.core.c.f r9) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.d.b.b(com.opos.exoplayer.core.c.f):boolean");
    }

    private static long c(com.opos.exoplayer.core.i.m mVar) {
        mVar.c(8);
        return g.a(mVar.o()) == 0 ? mVar.m() : mVar.w();
    }

    private void c(g.a aVar) {
        a(aVar, this.f17876i, this.f17872e, this.q);
        DrmInitData a2 = this.f17875h != null ? null : a(aVar.aR);
        if (a2 != null) {
            int size = this.f17876i.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f17876i.valueAt(i2).a(a2);
            }
        }
    }

    private void c(com.opos.exoplayer.core.c.f fVar) {
        int i2 = ((int) this.w) - this.x;
        com.opos.exoplayer.core.i.m mVar = this.y;
        if (mVar != null) {
            fVar.b(mVar.f19048a, 8, i2);
            a(new g.b(this.v, this.y), fVar.c());
        } else {
            fVar.b(i2);
        }
        a(fVar.c());
    }

    private static long d(com.opos.exoplayer.core.i.m mVar) {
        mVar.c(8);
        return g.a(mVar.o()) == 1 ? mVar.w() : mVar.m();
    }

    private void d(com.opos.exoplayer.core.c.f fVar) {
        int size = this.f17876i.size();
        C0402b c0402b = null;
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = this.f17876i.valueAt(i2).f17880a;
            if (lVar.r) {
                long j3 = lVar.f17979d;
                if (j3 < j2) {
                    c0402b = this.f17876i.valueAt(i2);
                    j2 = j3;
                }
            }
        }
        if (c0402b == null) {
            this.u = 3;
            return;
        }
        int c2 = (int) (j2 - fVar.c());
        if (c2 < 0) {
            throw new o("Offset to encryption data was negative.");
        }
        fVar.b(c2);
        c0402b.f17880a.a(fVar);
    }

    private boolean e(com.opos.exoplayer.core.c.f fVar) {
        int i2;
        n.a aVar;
        int a2;
        int i3 = 4;
        int i4 = 1;
        int i5 = 0;
        if (this.u == 3) {
            if (this.D == null) {
                C0402b a3 = a(this.f17876i);
                if (a3 == null) {
                    int c2 = (int) (this.z - fVar.c());
                    if (c2 < 0) {
                        throw new o("Offset to end of mdat was negative.");
                    }
                    fVar.b(c2);
                    a();
                    return false;
                }
                int c3 = (int) (a3.f17880a.f17982g[a3.f17886g] - fVar.c());
                if (c3 < 0) {
                    com.opos.cmn.an.f.a.c("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    c3 = 0;
                }
                fVar.b(c3);
                this.D = a3;
            }
            C0402b c0402b = this.D;
            l lVar = c0402b.f17880a;
            this.E = lVar.f17984i[c0402b.f17884e];
            if (lVar.m) {
                int a4 = a(c0402b);
                this.F = a4;
                this.E += a4;
            } else {
                this.F = 0;
            }
            if (this.D.f17882c.f17910g == 1) {
                this.E -= 8;
                fVar.b(8);
            }
            this.u = 4;
            this.G = 0;
        }
        C0402b c0402b2 = this.D;
        l lVar2 = c0402b2.f17880a;
        e eVar = c0402b2.f17882c;
        n nVar = c0402b2.f17881b;
        int i6 = c0402b2.f17884e;
        int i7 = eVar.f17913j;
        if (i7 == 0) {
            while (true) {
                int i8 = this.F;
                int i9 = this.E;
                if (i8 >= i9) {
                    break;
                }
                this.F = nVar.a(fVar, i9 - i8, false) + this.F;
            }
        } else {
            byte[] bArr = this.k.f19048a;
            byte b2 = (byte) 0;
            bArr[0] = b2;
            bArr[1] = b2;
            bArr[2] = b2;
            int i10 = 4 - i7;
            while (this.F < this.E) {
                int i11 = this.G;
                if (i11 == 0) {
                    fVar.b(bArr, i10, i7 + 1);
                    this.k.c(i5);
                    this.G = this.k.u() - i4;
                    this.f17877j.c(i5);
                    nVar.a(this.f17877j, i3);
                    nVar.a(this.k, i4);
                    this.H = this.K.length > 0 && com.opos.exoplayer.core.i.k.a(eVar.f17909f.f17496f, bArr[i3]);
                    this.F += 5;
                    this.E += i10;
                } else {
                    if (this.H) {
                        this.l.a(i11);
                        fVar.b(this.l.f19048a, i5, this.G);
                        nVar.a(this.l, this.G);
                        a2 = this.G;
                        com.opos.exoplayer.core.i.m mVar = this.l;
                        int a5 = com.opos.exoplayer.core.i.k.a(mVar.f19048a, mVar.c());
                        this.l.c("video/hevc".equals(eVar.f17909f.f17496f) ? 1 : 0);
                        this.l.b(a5);
                        com.opos.exoplayer.core.f.a.c.a(lVar2.b(i6) * 1000, this.l, this.K);
                    } else {
                        a2 = nVar.a(fVar, i11, false);
                    }
                    this.F += a2;
                    this.G -= a2;
                    i3 = 4;
                    i4 = 1;
                    i5 = 0;
                }
            }
        }
        long b3 = lVar2.b(i6) * 1000;
        s sVar = this.o;
        if (sVar != null) {
            b3 = sVar.c(b3);
        }
        boolean z = lVar2.l[i6];
        if (lVar2.m) {
            int i12 = (z ? 1 : 0) | 1073741824;
            f fVar2 = lVar2.o;
            if (fVar2 == null) {
                fVar2 = eVar.a(lVar2.f17976a.f17961a);
            }
            i2 = i12;
            aVar = fVar2.f17916c;
        } else {
            i2 = z ? 1 : 0;
            aVar = null;
        }
        nVar.a(b3, i2, this.E, 0, aVar);
        b(b3);
        C0402b c0402b3 = this.D;
        c0402b3.f17884e++;
        int i13 = c0402b3.f17885f + 1;
        c0402b3.f17885f = i13;
        int[] iArr = lVar2.f17983h;
        int i14 = c0402b3.f17886g;
        if (i13 == iArr[i14]) {
            c0402b3.f17886g = i14 + 1;
            c0402b3.f17885f = 0;
            this.D = null;
        }
        this.u = 3;
        return true;
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        while (true) {
            int i2 = this.u;
            if (i2 != 0) {
                if (i2 == 1) {
                    c(fVar);
                } else if (i2 == 2) {
                    d(fVar);
                } else if (e(fVar)) {
                    return 0;
                }
            } else if (!b(fVar)) {
                return -1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j2, long j3) {
        int size = this.f17876i.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f17876i.valueAt(i2).a();
        }
        this.s.clear();
        this.A = 0;
        this.r.clear();
        a();
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.I = gVar;
        e eVar = this.f17873f;
        if (eVar != null) {
            C0402b c0402b = new C0402b(gVar.a(0, eVar.f17905b));
            c0402b.a(this.f17873f, new i(0, 0, 0, 0));
            this.f17876i.put(0, c0402b);
            b();
            this.I.a();
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        return k.a(fVar);
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
