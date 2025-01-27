package com.opos.exoplayer.core.c.d;

import android.support.v4.media.session.PlaybackStateCompat;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.d.g;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.metadata.Metadata;
import com.vivo.google.android.exoplayer3.C;
import java.util.ArrayList;
import java.util.Stack;

/* loaded from: classes4.dex */
public final class c implements com.opos.exoplayer.core.c.e, com.opos.exoplayer.core.c.l {

    /* renamed from: a */
    public static final com.opos.exoplayer.core.c.h f17887a = new com.opos.exoplayer.core.c.h() { // from class: com.opos.exoplayer.core.c.d.c.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new c()};
        }
    };

    /* renamed from: b */
    private static final int f17888b = u.f("qt  ");

    /* renamed from: c */
    private final int f17889c;

    /* renamed from: d */
    private final com.opos.exoplayer.core.i.m f17890d;

    /* renamed from: e */
    private final com.opos.exoplayer.core.i.m f17891e;

    /* renamed from: f */
    private final com.opos.exoplayer.core.i.m f17892f;

    /* renamed from: g */
    private final Stack<g.a> f17893g;

    /* renamed from: h */
    private int f17894h;

    /* renamed from: i */
    private int f17895i;

    /* renamed from: j */
    private long f17896j;
    private int k;
    private com.opos.exoplayer.core.i.m l;
    private int m;
    private int n;
    private int o;
    private com.opos.exoplayer.core.c.g p;
    private a[] q;
    private long[][] r;
    private int s;
    private long t;
    private boolean u;

    /* renamed from: com.opos.exoplayer.core.c.d.c$1 */
    static final class AnonymousClass1 implements com.opos.exoplayer.core.c.h {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new c()};
        }
    }

    private static final class a {

        /* renamed from: a */
        public final e f17897a;

        /* renamed from: b */
        public final m f17898b;

        /* renamed from: c */
        public final n f17899c;

        /* renamed from: d */
        public int f17900d;

        public a(e eVar, m mVar, n nVar) {
            this.f17897a = eVar;
            this.f17898b = mVar;
            this.f17899c = nVar;
        }
    }

    public c() {
        this(0);
    }

    public c(int i2) {
        this.f17889c = i2;
        this.f17892f = new com.opos.exoplayer.core.i.m(16);
        this.f17893g = new Stack<>();
        this.f17890d = new com.opos.exoplayer.core.i.m(com.opos.exoplayer.core.i.k.f19027a);
        this.f17891e = new com.opos.exoplayer.core.i.m(4);
        this.m = -1;
    }

    private static int a(m mVar, long j2) {
        int a2 = mVar.a(j2);
        return a2 == -1 ? mVar.b(j2) : a2;
    }

    private static long a(m mVar, long j2, long j3) {
        int a2 = a(mVar, j2);
        return a2 == -1 ? j3 : Math.min(mVar.f17987b[a2], j3);
    }

    private void a(long j2) {
        while (!this.f17893g.isEmpty() && this.f17893g.peek().aQ == j2) {
            g.a pop = this.f17893g.pop();
            if (pop.aP == g.B) {
                a(pop);
                this.f17893g.clear();
                this.f17894h = 2;
            } else if (!this.f17893g.isEmpty()) {
                this.f17893g.peek().a(pop);
            }
        }
        if (this.f17894h != 2) {
            d();
        }
    }

    private void a(g.a aVar) {
        Metadata metadata;
        ArrayList arrayList = new ArrayList();
        com.opos.exoplayer.core.c.i iVar = new com.opos.exoplayer.core.c.i();
        g.b d2 = aVar.d(g.aA);
        if (d2 != null) {
            metadata = h.a(d2, this.u);
            if (metadata != null) {
                iVar.a(metadata);
            }
        } else {
            metadata = null;
        }
        int i2 = -1;
        long j2 = C.TIME_UNSET;
        for (int i3 = 0; i3 < aVar.aS.size(); i3++) {
            g.a aVar2 = aVar.aS.get(i3);
            if (aVar2.aP == g.D) {
                e a2 = h.a(aVar2, aVar.d(g.C), C.TIME_UNSET, (DrmInitData) null, (this.f17889c & 1) != 0, this.u);
                if (a2 != null) {
                    m a3 = h.a(a2, aVar2.e(g.E).e(g.F).e(g.G), iVar);
                    if (a3.f17986a != 0) {
                        a aVar3 = new a(a2, a3, this.p.a(i3, a2.f17905b));
                        Format a4 = a2.f17909f.a(a3.f17989d + 30);
                        if (a2.f17905b == 1) {
                            if (iVar.a()) {
                                a4 = a4.a(iVar.f18311b, iVar.f18312c);
                            }
                            if (metadata != null) {
                                a4 = a4.a(metadata);
                            }
                        }
                        aVar3.f17899c.a(a4);
                        long j3 = a2.f17908e;
                        if (j3 == C.TIME_UNSET) {
                            j3 = a3.f17992g;
                        }
                        j2 = Math.max(j2, j3);
                        if (a2.f17905b == 2 && i2 == -1) {
                            i2 = arrayList.size();
                        }
                        arrayList.add(aVar3);
                    }
                }
            }
        }
        this.s = i2;
        this.t = j2;
        a[] aVarArr = (a[]) arrayList.toArray(new a[arrayList.size()]);
        this.q = aVarArr;
        this.r = a(aVarArr);
        this.p.a();
        this.p.a(this);
    }

    private static boolean a(int i2) {
        return i2 == g.R || i2 == g.C || i2 == g.S || i2 == g.T || i2 == g.am || i2 == g.an || i2 == g.ao || i2 == g.Q || i2 == g.ap || i2 == g.aq || i2 == g.ar || i2 == g.as || i2 == g.at || i2 == g.O || i2 == g.f17919a || i2 == g.aA;
    }

    private static boolean a(com.opos.exoplayer.core.i.m mVar) {
        mVar.c(8);
        if (mVar.o() != f17888b) {
            mVar.d(4);
            while (mVar.b() > 0) {
                if (mVar.o() == f17888b) {
                }
            }
            return false;
        }
        return true;
    }

    private static long[][] a(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            jArr[i2] = new long[aVarArr[i2].f17898b.f17986a];
            jArr2[i2] = aVarArr[i2].f17898b.f17990e[0];
        }
        long j2 = 0;
        int i3 = 0;
        while (i3 < aVarArr.length) {
            long j3 = Long.MAX_VALUE;
            int i4 = -1;
            for (int i5 = 0; i5 < aVarArr.length; i5++) {
                if (!zArr[i5] && jArr2[i5] <= j3) {
                    j3 = jArr2[i5];
                    i4 = i5;
                }
            }
            int i6 = iArr[i4];
            jArr[i4][i6] = j2;
            j2 += aVarArr[i4].f17898b.f17988c[i6];
            int i7 = i6 + 1;
            iArr[i4] = i7;
            if (i7 < jArr[i4].length) {
                jArr2[i4] = aVarArr[i4].f17898b.f17990e[i7];
            } else {
                zArr[i4] = true;
                i3++;
            }
        }
        return jArr;
    }

    private static boolean b(int i2) {
        return i2 == g.B || i2 == g.D || i2 == g.E || i2 == g.F || i2 == g.G || i2 == g.P;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(com.opos.exoplayer.core.c.f r9) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.d.c.b(com.opos.exoplayer.core.c.f):boolean");
    }

    private boolean b(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        boolean z;
        long j2 = this.f17896j - this.k;
        long c2 = fVar.c();
        com.opos.exoplayer.core.i.m mVar = this.l;
        if (mVar != null) {
            fVar.b(mVar.f19048a, this.k, (int) j2);
            if (this.f17895i == g.f17919a) {
                this.u = a(this.l);
            } else if (!this.f17893g.isEmpty()) {
                this.f17893g.peek().a(new g.b(this.f17895i, this.l));
            }
        } else {
            if (j2 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                kVar.f18323a = fVar.c() + j2;
                z = true;
                a(c2 + j2);
                return (z || this.f17894h == 2) ? false : true;
            }
            fVar.b((int) j2);
        }
        z = false;
        a(c2 + j2);
        if (z) {
        }
    }

    private int c(long j2) {
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        long j3 = Long.MAX_VALUE;
        boolean z = true;
        long j4 = Long.MAX_VALUE;
        boolean z2 = true;
        long j5 = Long.MAX_VALUE;
        while (true) {
            a[] aVarArr = this.q;
            if (i4 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i4];
            int i5 = aVar.f17900d;
            m mVar = aVar.f17898b;
            if (i5 != mVar.f17986a) {
                long j6 = mVar.f17987b[i5];
                long j7 = this.r[i4][i5];
                long j8 = j6 - j2;
                boolean z3 = j8 < 0 || j8 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                if ((!z3 && z2) || (z3 == z2 && j8 < j5)) {
                    z2 = z3;
                    j5 = j8;
                    i3 = i4;
                    j4 = j7;
                }
                if (j7 < j3) {
                    z = z3;
                    i2 = i4;
                    j3 = j7;
                }
            }
            i4++;
        }
        return (j3 == Long.MAX_VALUE || !z || j4 < j3 + 10485760) ? i3 : i2;
    }

    private int c(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        long c2 = fVar.c();
        if (this.m == -1) {
            int c3 = c(c2);
            this.m = c3;
            if (c3 == -1) {
                return -1;
            }
        }
        a aVar = this.q[this.m];
        n nVar = aVar.f17899c;
        int i2 = aVar.f17900d;
        m mVar = aVar.f17898b;
        long j2 = mVar.f17987b[i2];
        int i3 = mVar.f17988c[i2];
        long j3 = (j2 - c2) + this.n;
        if (j3 < 0 || j3 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            kVar.f18323a = j2;
            return 1;
        }
        if (aVar.f17897a.f17910g == 1) {
            j3 += 8;
            i3 -= 8;
        }
        fVar.b((int) j3);
        int i4 = aVar.f17897a.f17913j;
        if (i4 == 0) {
            while (true) {
                int i5 = this.n;
                if (i5 >= i3) {
                    break;
                }
                int a2 = nVar.a(fVar, i3 - i5, false);
                this.n += a2;
                this.o -= a2;
            }
        } else {
            byte[] bArr = this.f17891e.f19048a;
            byte b2 = (byte) 0;
            bArr[0] = b2;
            bArr[1] = b2;
            bArr[2] = b2;
            int i6 = 4 - i4;
            while (this.n < i3) {
                int i7 = this.o;
                if (i7 == 0) {
                    fVar.b(this.f17891e.f19048a, i6, i4);
                    this.f17891e.c(0);
                    this.o = this.f17891e.u();
                    this.f17890d.c(0);
                    nVar.a(this.f17890d, 4);
                    this.n += 4;
                    i3 += i6;
                } else {
                    int a3 = nVar.a(fVar, i7, false);
                    this.n += a3;
                    this.o -= a3;
                }
            }
        }
        m mVar2 = aVar.f17898b;
        nVar.a(mVar2.f17990e[i2], mVar2.f17991f[i2], i3, 0, null);
        aVar.f17900d++;
        this.m = -1;
        this.n = 0;
        this.o = 0;
        return 0;
    }

    private void d() {
        this.f17894h = 0;
        this.k = 0;
    }

    private void d(long j2) {
        for (a aVar : this.q) {
            m mVar = aVar.f17898b;
            int a2 = mVar.a(j2);
            if (a2 == -1) {
                a2 = mVar.b(j2);
            }
            aVar.f17900d = a2;
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        while (true) {
            int i2 = this.f17894h;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return c(fVar, kVar);
                    }
                    throw new IllegalStateException();
                }
                if (b(fVar, kVar)) {
                    return 1;
                }
            } else if (!b(fVar)) {
                return -1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j2, long j3) {
        this.f17893g.clear();
        this.k = 0;
        this.m = -1;
        this.n = 0;
        this.o = 0;
        if (j2 == 0) {
            d();
        } else if (this.q != null) {
            d(j3);
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.p = gVar;
    }

    @Override // com.opos.exoplayer.core.c.l
    public boolean a() {
        return true;
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        return k.b(fVar);
    }

    @Override // com.opos.exoplayer.core.c.l
    public long b() {
        return this.t;
    }

    @Override // com.opos.exoplayer.core.c.l
    public l.a b(long j2) {
        long j3;
        long j4;
        long j5;
        long j6;
        int b2;
        a[] aVarArr = this.q;
        if (aVarArr.length == 0) {
            return new l.a(com.opos.exoplayer.core.c.m.f18328a);
        }
        long j7 = -1;
        int i2 = this.s;
        if (i2 != -1) {
            m mVar = aVarArr[i2].f17898b;
            int a2 = a(mVar, j2);
            if (a2 == -1) {
                return new l.a(com.opos.exoplayer.core.c.m.f18328a);
            }
            long j8 = mVar.f17990e[a2];
            j3 = mVar.f17987b[a2];
            if (j8 >= j2 || a2 >= mVar.f17986a - 1 || (b2 = mVar.b(j2)) == -1 || b2 == a2) {
                j5 = -1;
                j6 = -9223372036854775807L;
            } else {
                j6 = mVar.f17990e[b2];
                j5 = mVar.f17987b[b2];
            }
            j4 = j6;
            j7 = j5;
            j2 = j8;
        } else {
            j3 = Long.MAX_VALUE;
            j4 = -9223372036854775807L;
        }
        int i3 = 0;
        while (true) {
            a[] aVarArr2 = this.q;
            if (i3 >= aVarArr2.length) {
                break;
            }
            if (i3 != this.s) {
                m mVar2 = aVarArr2[i3].f17898b;
                j3 = a(mVar2, j2, j3);
                if (j4 != C.TIME_UNSET) {
                    j7 = a(mVar2, j4, j7);
                }
            }
            i3++;
        }
        com.opos.exoplayer.core.c.m mVar3 = new com.opos.exoplayer.core.c.m(j2, j3);
        return j4 == C.TIME_UNSET ? new l.a(mVar3) : new l.a(mVar3, new com.opos.exoplayer.core.c.m(j4, j7));
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
