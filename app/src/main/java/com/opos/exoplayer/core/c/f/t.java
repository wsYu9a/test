package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.c.l;
import com.vivo.google.android.exoplayer3.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class t implements com.opos.exoplayer.core.c.e {

    /* renamed from: a */
    public static final com.opos.exoplayer.core.c.h f18257a = new com.opos.exoplayer.core.c.h() { // from class: com.opos.exoplayer.core.c.f.t.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new t()};
        }
    };

    /* renamed from: b */
    private static final long f18258b = com.opos.exoplayer.core.i.u.f("AC-3");

    /* renamed from: c */
    private static final long f18259c = com.opos.exoplayer.core.i.u.f("EAC3");

    /* renamed from: d */
    private static final long f18260d = com.opos.exoplayer.core.i.u.f("HEVC");

    /* renamed from: e */
    private final int f18261e;

    /* renamed from: f */
    private final List<com.opos.exoplayer.core.i.s> f18262f;

    /* renamed from: g */
    private final com.opos.exoplayer.core.i.m f18263g;

    /* renamed from: h */
    private final SparseIntArray f18264h;

    /* renamed from: i */
    private final u.c f18265i;

    /* renamed from: j */
    private final SparseArray<u> f18266j;
    private final SparseBooleanArray k;
    private com.opos.exoplayer.core.c.g l;
    private int m;
    private boolean n;
    private u o;
    private int p;

    /* renamed from: com.opos.exoplayer.core.c.f.t$1 */
    static final class AnonymousClass1 implements com.opos.exoplayer.core.c.h {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new t()};
        }
    }

    private class a implements q {

        /* renamed from: b */
        private final com.opos.exoplayer.core.i.l f18268b = new com.opos.exoplayer.core.i.l(new byte[4]);

        public a() {
        }

        @Override // com.opos.exoplayer.core.c.f.q
        public void a(com.opos.exoplayer.core.i.m mVar) {
            if (mVar.g() != 0) {
                return;
            }
            mVar.d(7);
            int b2 = mVar.b() / 4;
            for (int i2 = 0; i2 < b2; i2++) {
                mVar.a(this.f18268b, 4);
                int c2 = this.f18268b.c(16);
                this.f18268b.b(3);
                if (c2 == 0) {
                    this.f18268b.b(13);
                } else {
                    int c3 = this.f18268b.c(13);
                    t.this.f18266j.put(c3, new r(t.this.new b(c3)));
                    t.b(t.this);
                }
            }
            if (t.this.f18261e != 2) {
                t.this.f18266j.remove(0);
            }
        }

        @Override // com.opos.exoplayer.core.c.f.q
        public void a(com.opos.exoplayer.core.i.s sVar, com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        }
    }

    private class b implements q {

        /* renamed from: b */
        private final com.opos.exoplayer.core.i.l f18270b = new com.opos.exoplayer.core.i.l(new byte[5]);

        /* renamed from: c */
        private final SparseArray<u> f18271c = new SparseArray<>();

        /* renamed from: d */
        private final SparseIntArray f18272d = new SparseIntArray();

        /* renamed from: e */
        private final int f18273e;

        public b(int i2) {
            this.f18273e = i2;
        }

        private u.b a(com.opos.exoplayer.core.i.m mVar, int i2) {
            int d2 = mVar.d();
            int i3 = i2 + d2;
            String str = null;
            ArrayList arrayList = null;
            int i4 = -1;
            while (mVar.d() < i3) {
                int g2 = mVar.g();
                int g3 = mVar.g() + mVar.d();
                if (g2 == 5) {
                    long m = mVar.m();
                    if (m != t.f18258b) {
                        if (m != t.f18259c) {
                            if (m == t.f18260d) {
                                i4 = 36;
                            }
                        }
                        i4 = 135;
                    }
                    i4 = 129;
                } else {
                    if (g2 != 106) {
                        if (g2 != 122) {
                            if (g2 == 123) {
                                i4 = 138;
                            } else if (g2 == 10) {
                                str = mVar.e(3).trim();
                            } else if (g2 == 89) {
                                arrayList = new ArrayList();
                                while (mVar.d() < g3) {
                                    String trim = mVar.e(3).trim();
                                    int g4 = mVar.g();
                                    byte[] bArr = new byte[4];
                                    mVar.a(bArr, 0, 4);
                                    arrayList.add(new u.a(trim, g4, bArr));
                                }
                                i4 = 89;
                            }
                        }
                        i4 = 135;
                    }
                    i4 = 129;
                }
                mVar.d(g3 - mVar.d());
            }
            mVar.c(i3);
            return new u.b(i4, str, arrayList, Arrays.copyOfRange(mVar.f19048a, d2, i3));
        }

        @Override // com.opos.exoplayer.core.c.f.q
        public void a(com.opos.exoplayer.core.i.m mVar) {
            com.opos.exoplayer.core.i.s sVar;
            if (mVar.g() != 2) {
                return;
            }
            if (t.this.f18261e == 1 || t.this.f18261e == 2 || t.this.m == 1) {
                sVar = (com.opos.exoplayer.core.i.s) t.this.f18262f.get(0);
            } else {
                sVar = new com.opos.exoplayer.core.i.s(((com.opos.exoplayer.core.i.s) t.this.f18262f.get(0)).a());
                t.this.f18262f.add(sVar);
            }
            mVar.d(2);
            int h2 = mVar.h();
            int i2 = 5;
            mVar.d(5);
            mVar.a(this.f18270b, 2);
            int i3 = 4;
            this.f18270b.b(4);
            mVar.d(this.f18270b.c(12));
            if (t.this.f18261e == 2 && t.this.o == null) {
                u.b bVar = new u.b(21, null, null, new byte[0]);
                t tVar = t.this;
                tVar.o = tVar.f18265i.a(21, bVar);
                t.this.o.a(sVar, t.this.l, new u.d(h2, 21, 8192));
            }
            this.f18271c.clear();
            this.f18272d.clear();
            int b2 = mVar.b();
            while (b2 > 0) {
                mVar.a(this.f18270b, i2);
                int c2 = this.f18270b.c(8);
                this.f18270b.b(3);
                int c3 = this.f18270b.c(13);
                this.f18270b.b(i3);
                int c4 = this.f18270b.c(12);
                u.b a2 = a(mVar, c4);
                if (c2 == 6) {
                    c2 = a2.f18277a;
                }
                b2 -= c4 + 5;
                int i4 = t.this.f18261e == 2 ? c2 : c3;
                if (!t.this.k.get(i4)) {
                    u a3 = (t.this.f18261e == 2 && c2 == 21) ? t.this.o : t.this.f18265i.a(c2, a2);
                    if (t.this.f18261e != 2 || c3 < this.f18272d.get(i4, 8192)) {
                        this.f18272d.put(i4, c3);
                        this.f18271c.put(i4, a3);
                    }
                }
                i2 = 5;
                i3 = 4;
            }
            int size = this.f18272d.size();
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = this.f18272d.keyAt(i5);
                t.this.k.put(keyAt, true);
                u valueAt = this.f18271c.valueAt(i5);
                if (valueAt != null) {
                    if (valueAt != t.this.o) {
                        valueAt.a(sVar, t.this.l, new u.d(h2, keyAt, 8192));
                    }
                    t.this.f18266j.put(this.f18272d.valueAt(i5), valueAt);
                }
            }
            if (t.this.f18261e != 2) {
                t.this.f18266j.remove(this.f18273e);
                t tVar2 = t.this;
                tVar2.m = tVar2.f18261e != 1 ? t.this.m - 1 : 0;
                if (t.this.m != 0) {
                    return;
                } else {
                    t.this.l.a();
                }
            } else {
                if (t.this.n) {
                    return;
                }
                t.this.l.a();
                t.this.m = 0;
            }
            t.this.n = true;
        }

        @Override // com.opos.exoplayer.core.c.f.q
        public void a(com.opos.exoplayer.core.i.s sVar, com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        }
    }

    public t() {
        this(0);
    }

    public t(int i2) {
        this(1, i2);
    }

    public t(int i2, int i3) {
        this(i2, new com.opos.exoplayer.core.i.s(0L), new e(i3));
    }

    public t(int i2, com.opos.exoplayer.core.i.s sVar, u.c cVar) {
        this.f18265i = (u.c) com.opos.exoplayer.core.i.a.a(cVar);
        this.f18261e = i2;
        if (i2 == 1 || i2 == 2) {
            this.f18262f = Collections.singletonList(sVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f18262f = arrayList;
            arrayList.add(sVar);
        }
        this.f18263g = new com.opos.exoplayer.core.i.m(new byte[9400], 0);
        this.k = new SparseBooleanArray();
        this.f18266j = new SparseArray<>();
        this.f18264h = new SparseIntArray();
        e();
    }

    static /* synthetic */ int b(t tVar) {
        int i2 = tVar.m;
        tVar.m = i2 + 1;
        return i2;
    }

    private void e() {
        this.k.clear();
        this.f18266j.clear();
        SparseArray<u> a2 = this.f18265i.a();
        int size = a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f18266j.put(a2.keyAt(i2), a2.valueAt(i2));
        }
        this.f18266j.put(0, new r(new a()));
        this.o = null;
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        com.opos.exoplayer.core.i.m mVar = this.f18263g;
        byte[] bArr = mVar.f19048a;
        if (9400 - mVar.d() < 188) {
            int b2 = this.f18263g.b();
            if (b2 > 0) {
                System.arraycopy(bArr, this.f18263g.d(), bArr, 0, b2);
            }
            this.f18263g.a(bArr, b2);
        }
        while (this.f18263g.b() < 188) {
            int c2 = this.f18263g.c();
            int a2 = fVar.a(bArr, c2, 9400 - c2);
            if (a2 == -1) {
                return -1;
            }
            this.f18263g.b(c2 + a2);
        }
        int c3 = this.f18263g.c();
        int d2 = this.f18263g.d();
        int i2 = d2;
        while (i2 < c3 && bArr[i2] != 71) {
            i2++;
        }
        this.f18263g.c(i2);
        int i3 = i2 + 188;
        if (i3 > c3) {
            int i4 = (i2 - d2) + this.p;
            this.p = i4;
            if (this.f18261e != 2 || i4 <= 376) {
                return 0;
            }
            throw new com.opos.exoplayer.core.o("Cannot find sync byte. Most likely not a Transport Stream.");
        }
        this.p = 0;
        int o = this.f18263g.o();
        if ((8388608 & o) == 0) {
            boolean z = (4194304 & o) != 0;
            int i5 = (2096896 & o) >> 8;
            boolean z2 = (o & 32) != 0;
            u uVar = (o & 16) != 0 ? this.f18266j.get(i5) : null;
            if (uVar != null) {
                if (this.f18261e != 2) {
                    int i6 = o & 15;
                    int i7 = this.f18264h.get(i5, i6 - 1);
                    this.f18264h.put(i5, i6);
                    if (i7 != i6) {
                        if (i6 != ((i7 + 1) & 15)) {
                            uVar.a();
                        }
                    }
                }
                if (z2) {
                    this.f18263g.d(this.f18263g.g());
                }
                this.f18263g.b(i3);
                uVar.a(this.f18263g, z);
                this.f18263g.b(c3);
            }
        }
        this.f18263g.c(i3);
        return 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j2, long j3) {
        int size = this.f18262f.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f18262f.get(i2).d();
        }
        this.f18263g.a();
        this.f18264h.clear();
        e();
        this.p = 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.l = gVar;
        gVar.a(new l.b(C.TIME_UNSET));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        r2 = r2 + 1;
     */
    @Override // com.opos.exoplayer.core.c.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.opos.exoplayer.core.c.f r7) {
        /*
            r6 = this;
            com.opos.exoplayer.core.i.m r0 = r6.f18263g
            byte[] r0 = r0.f19048a
            r1 = 0
            r2 = 940(0x3ac, float:1.317E-42)
            r7.c(r0, r1, r2)
            r2 = 0
        Lb:
            r3 = 188(0xbc, float:2.63E-43)
            if (r2 >= r3) goto L27
            r3 = 0
        L10:
            r4 = 5
            if (r3 != r4) goto L18
            r7.b(r2)
            r1 = 1
            goto L27
        L18:
            int r4 = r3 * 188
            int r4 = r4 + r2
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L24
            int r2 = r2 + 1
            goto Lb
        L24:
            int r3 = r3 + 1
            goto L10
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.t.a(com.opos.exoplayer.core.c.f):boolean");
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
