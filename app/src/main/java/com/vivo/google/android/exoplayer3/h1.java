package com.vivo.google.android.exoplayer3;

import android.util.SparseArray;
import com.vivo.advv.virtualview.common.ExprCommon;
import com.vivo.google.android.exoplayer3.d1;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/* loaded from: classes4.dex */
public final class h1 implements g0 {
    public static final int E = Util.getIntegerCodeForString("seig");
    public static final byte[] F = {-94, 57, 79, 82, 90, -101, 79, ExprCommon.OPCODE_MOD_EQ, -94, 68, 108, 66, 124, 100, -115, -12};
    public i0 A;
    public n0 B;
    public n0[] C;
    public boolean D;

    /* renamed from: a */
    public final int f27450a;

    /* renamed from: b */
    public final l1 f27451b;

    /* renamed from: c */
    public final SparseArray<b> f27452c;

    /* renamed from: d */
    public final n6 f27453d;

    /* renamed from: e */
    public final n6 f27454e;

    /* renamed from: f */
    public final n6 f27455f;

    /* renamed from: g */
    public final n6 f27456g;

    /* renamed from: h */
    public final u6 f27457h;

    /* renamed from: i */
    public final n6 f27458i;

    /* renamed from: j */
    public final byte[] f27459j;
    public final Stack<d1.a> k;
    public final LinkedList<a> l;
    public int m;
    public int n;
    public long o;
    public int p;
    public n6 q;
    public long r;
    public int s;
    public long t;
    public long u;
    public b v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    public static final class a {

        /* renamed from: a */
        public final long f27460a;

        /* renamed from: b */
        public final int f27461b;

        public a(long j2, int i2) {
            this.f27460a = j2;
            this.f27461b = i2;
        }
    }

    public h1(int i2, u6 u6Var, l1 l1Var) {
        this.f27450a = i2 | (l1Var != null ? 16 : 0);
        this.f27457h = u6Var;
        this.f27451b = l1Var;
        this.f27458i = new n6(16);
        this.f27453d = new n6(l6.f27726a);
        this.f27454e = new n6(5);
        this.f27455f = new n6();
        this.f27456g = new n6(1);
        this.f27459j = new byte[16];
        this.k = new Stack<>();
        this.l = new LinkedList<>();
        this.f27452c = new SparseArray<>();
        this.t = C.TIME_UNSET;
        this.u = C.TIME_UNSET;
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.vivo.google.android.exoplayer3.drm.DrmInitData a(java.util.List<com.vivo.google.android.exoplayer3.d1.b> r14) {
        /*
            int r0 = r14.size()
            r1 = 0
            r2 = 0
            r4 = r2
            r3 = 0
        L8:
            if (r3 >= r0) goto Laf
            java.lang.Object r5 = r14.get(r3)
            com.vivo.google.android.exoplayer3.d1$b r5 = (com.vivo.google.android.exoplayer3.d1.b) r5
            int r6 = r5.f27281a
            int r7 = com.vivo.google.android.exoplayer3.d1.V
            if (r6 != r7) goto Lab
            if (r4 != 0) goto L1d
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L1d:
            com.vivo.google.android.exoplayer3.n6 r5 = r5.P0
            byte[] r5 = r5.f27874a
            com.vivo.google.android.exoplayer3.n6 r6 = new com.vivo.google.android.exoplayer3.n6
            r6.<init>(r5)
            int r8 = r6.f27876c
            r9 = 32
            if (r8 >= r9) goto L2d
            goto L82
        L2d:
            r6.d(r1)
            int r8 = r6.c()
            int r9 = r6.a()
            int r9 = r9 + 4
            if (r8 == r9) goto L3d
            goto L82
        L3d:
            int r8 = r6.c()
            if (r8 == r7) goto L44
            goto L82
        L44:
            int r7 = r6.c()
            int r7 = com.vivo.google.android.exoplayer3.d1.c(r7)
            r8 = 1
            if (r7 <= r8) goto L60
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "Unsupported pssh version: "
            r6.append(r8)
            r6.append(r7)
            r6.toString()
            goto L82
        L60:
            java.util.UUID r9 = new java.util.UUID
            long r10 = r6.i()
            long r12 = r6.i()
            r9.<init>(r10, r12)
            if (r7 != r8) goto L78
            int r7 = r6.o()
            int r7 = r7 * 16
            r6.e(r7)
        L78:
            int r7 = r6.o()
            int r8 = r6.a()
            if (r7 == r8) goto L84
        L82:
            r6 = r2
            goto L96
        L84:
            byte[] r8 = new byte[r7]
            byte[] r10 = r6.f27874a
            int r11 = r6.f27875b
            java.lang.System.arraycopy(r10, r11, r8, r1, r7)
            int r10 = r6.f27875b
            int r10 = r10 + r7
            r6.f27875b = r10
            android.util.Pair r6 = android.util.Pair.create(r9, r8)
        L96:
            if (r6 != 0) goto L9a
            r6 = r2
            goto L9e
        L9a:
            java.lang.Object r6 = r6.first
            java.util.UUID r6 = (java.util.UUID) r6
        L9e:
            if (r6 != 0) goto La1
            goto Lab
        La1:
            com.vivo.google.android.exoplayer3.drm.DrmInitData$SchemeData r7 = new com.vivo.google.android.exoplayer3.drm.DrmInitData$SchemeData
            java.lang.String r8 = "video/mp4"
            r7.<init>(r6, r8, r5, r1)
            r4.add(r7)
        Lab:
            int r3 = r3 + 1
            goto L8
        Laf:
            if (r4 != 0) goto Lb2
            goto Lc3
        Lb2:
            com.vivo.google.android.exoplayer3.drm.DrmInitData r2 = new com.vivo.google.android.exoplayer3.drm.DrmInitData
            int r14 = r4.size()
            com.vivo.google.android.exoplayer3.drm.DrmInitData$SchemeData[] r14 = new com.vivo.google.android.exoplayer3.drm.DrmInitData.SchemeData[r14]
            java.lang.Object[] r14 = r4.toArray(r14)
            com.vivo.google.android.exoplayer3.drm.DrmInitData$SchemeData[] r14 = (com.vivo.google.android.exoplayer3.drm.DrmInitData.SchemeData[]) r14
            r2.<init>(r1, r14)
        Lc3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.h1.a(java.util.List):com.vivo.google.android.exoplayer3.drm.DrmInitData");
    }

    public final void a() {
        this.m = 0;
        this.p = 0;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(long j2, long j3) {
        int size = this.f27452c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f27452c.valueAt(i2).a();
        }
        this.l.clear();
        this.s = 0;
        this.k.clear();
        a();
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(i0 i0Var) {
        this.A = i0Var;
        l1 l1Var = this.f27451b;
        if (l1Var != null) {
            b bVar = new b(((l3) i0Var).a(0, l1Var.f27604b));
            bVar.a(this.f27451b, new f1(0, 0, 0, 0));
            this.f27452c.put(0, bVar);
            b();
            ((l3) this.A).f();
        }
    }

    public final void b() {
        if ((this.f27450a & 4) != 0 && this.B == null) {
            n0 a2 = ((l3) this.A).a(this.f27452c.size(), 4);
            this.B = a2;
            a2.a(Format.createSampleFormat(null, "application/x-emsg", Long.MAX_VALUE));
        }
        if ((this.f27450a & 8) == 0 || this.C != null) {
            return;
        }
        e0 e0Var = (e0) ((l3) this.A).a(this.f27452c.size() + 1, 3);
        e0Var.a(Format.createTextSampleFormat(null, "application/cea-608", null, -1, 0, null, null));
        this.C = new n0[]{e0Var};
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void release() {
    }

    public static final class b {

        /* renamed from: a */
        public final n1 f27462a = new n1();

        /* renamed from: b */
        public final n0 f27463b;

        /* renamed from: c */
        public l1 f27464c;

        /* renamed from: d */
        public f1 f27465d;

        /* renamed from: e */
        public int f27466e;

        /* renamed from: f */
        public int f27467f;

        /* renamed from: g */
        public int f27468g;

        public b(n0 n0Var) {
            this.f27463b = n0Var;
        }

        public void a(l1 l1Var, f1 f1Var) {
            l1Var.getClass();
            this.f27464c = l1Var;
            f1Var.getClass();
            this.f27465d = f1Var;
            this.f27463b.a(l1Var.f27608f);
            a();
        }

        public void a() {
            n1 n1Var = this.f27462a;
            n1Var.f27853e = 0;
            n1Var.s = 0L;
            n1Var.m = false;
            n1Var.r = false;
            n1Var.o = null;
            this.f27466e = 0;
            this.f27468g = 0;
            this.f27467f = 0;
        }
    }

    public static void a(n6 n6Var, int i2, n1 n1Var) {
        n6Var.d(i2 + 8);
        int b2 = d1.b(n6Var.c());
        if ((b2 & 1) != 0) {
            throw new f("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (b2 & 2) != 0;
        int o = n6Var.o();
        if (o == n1Var.f27854f) {
            Arrays.fill(n1Var.n, 0, o, z);
            n1Var.a(n6Var.a());
            n6Var.a(n1Var.q.f27874a, 0, n1Var.p);
            n1Var.q.d(0);
            n1Var.r = false;
            return;
        }
        throw new f("Length mismatch: " + o + ", " + n1Var.f27854f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:330:0x06ac, code lost:
    
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x06b0, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:200:0x05fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(long r55) {
        /*
            Method dump skipped, instructions count: 1713
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.h1.a(long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:180:0x05b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0002 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0261 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0004 A[SYNTHETIC] */
    @Override // com.vivo.google.android.exoplayer3.g0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.vivo.google.android.exoplayer3.h0 r26, com.vivo.google.android.exoplayer3.l0 r27) {
        /*
            Method dump skipped, instructions count: 1484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.h1.a(com.vivo.google.android.exoplayer3.h0, com.vivo.google.android.exoplayer3.l0):int");
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public boolean a(h0 h0Var) {
        return k1.a(h0Var, true);
    }
}
