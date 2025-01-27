package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.d1;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.Stack;

/* loaded from: classes4.dex */
public final class j1 implements g0, m0 {
    public static final int p = Util.getIntegerCodeForString("qt  ");

    /* renamed from: e */
    public int f27528e;

    /* renamed from: f */
    public int f27529f;

    /* renamed from: g */
    public long f27530g;

    /* renamed from: h */
    public int f27531h;

    /* renamed from: i */
    public n6 f27532i;

    /* renamed from: j */
    public int f27533j;
    public int k;
    public i0 l;
    public a[] m;
    public long n;
    public boolean o;

    /* renamed from: c */
    public final n6 f27526c = new n6(16);

    /* renamed from: d */
    public final Stack<d1.a> f27527d = new Stack<>();

    /* renamed from: a */
    public final n6 f27524a = new n6(l6.f27726a);

    /* renamed from: b */
    public final n6 f27525b = new n6(4);

    public static final class a {

        /* renamed from: a */
        public final l1 f27534a;

        /* renamed from: b */
        public final o1 f27535b;

        /* renamed from: c */
        public final n0 f27536c;

        /* renamed from: d */
        public int f27537d;

        public a(l1 l1Var, o1 o1Var, n0 n0Var) {
            this.f27534a = l1Var;
            this.f27535b = o1Var;
            this.f27536c = n0Var;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0190 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x02a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0006 A[SYNTHETIC] */
    @Override // com.vivo.google.android.exoplayer3.g0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.vivo.google.android.exoplayer3.h0 r24, com.vivo.google.android.exoplayer3.l0 r25) {
        /*
            Method dump skipped, instructions count: 681
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.j1.a(com.vivo.google.android.exoplayer3.h0, com.vivo.google.android.exoplayer3.l0):int");
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public long a(long j2) {
        long j3 = Long.MAX_VALUE;
        for (a aVar : this.m) {
            o1 o1Var = aVar.f27535b;
            int a2 = o1Var.a(j2);
            if (a2 == -1) {
                a2 = o1Var.b(j2);
            }
            long j4 = o1Var.f27885b[a2];
            if (j4 < j3) {
                j3 = j4;
            }
        }
        return j3;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(i0 i0Var) {
        this.l = i0Var;
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public boolean a() {
        return true;
    }

    public final void b() {
        this.f27528e = 0;
        this.f27531h = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:253:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0193  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(long r52) {
        /*
            Method dump skipped, instructions count: 1681
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.j1.b(long):void");
    }

    @Override // com.vivo.google.android.exoplayer3.m0
    public long c() {
        return this.n;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void release() {
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(long j2, long j3) {
        this.f27527d.clear();
        this.f27531h = 0;
        this.f27533j = 0;
        this.k = 0;
        if (j2 == 0) {
            b();
            return;
        }
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                o1 o1Var = aVar.f27535b;
                int a2 = o1Var.a(j3);
                if (a2 == -1) {
                    a2 = o1Var.b(j3);
                }
                aVar.f27537d = a2;
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public boolean a(h0 h0Var) {
        return k1.a(h0Var, false);
    }
}
