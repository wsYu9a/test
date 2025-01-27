package com.vivo.google.android.exoplayer3;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.vivo.google.android.exoplayer3.m0;
import com.vivo.google.android.exoplayer3.util.Util;
import com.vivo.google.android.exoplayer3.x2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class w2 implements g0 {
    public static final long l = Util.getIntegerCodeForString("AC-3");
    public static final long m = Util.getIntegerCodeForString("EAC3");
    public static final long n = Util.getIntegerCodeForString("HEVC");

    /* renamed from: a */
    public final int f28228a;

    /* renamed from: b */
    public final List<u6> f28229b;

    /* renamed from: c */
    public final n6 f28230c;

    /* renamed from: d */
    public final SparseIntArray f28231d;

    /* renamed from: e */
    public final x2.c f28232e;

    /* renamed from: f */
    public final SparseArray<x2> f28233f;

    /* renamed from: g */
    public final SparseBooleanArray f28234g;

    /* renamed from: h */
    public i0 f28235h;

    /* renamed from: i */
    public int f28236i;

    /* renamed from: j */
    public boolean f28237j;
    public x2 k;

    public class a implements s2 {

        /* renamed from: a */
        public final m6 f28238a = new m6(new byte[4]);

        public a() {
        }

        @Override // com.vivo.google.android.exoplayer3.s2
        public void a(n6 n6Var) {
            if (n6Var.l() != 0) {
                return;
            }
            n6Var.e(7);
            int a2 = n6Var.a() / 4;
            for (int i2 = 0; i2 < a2; i2++) {
                n6Var.a(this.f28238a, 4);
                int a3 = this.f28238a.a(16);
                this.f28238a.c(3);
                if (a3 == 0) {
                    this.f28238a.c(13);
                } else {
                    int a4 = this.f28238a.a(13);
                    w2 w2Var = w2.this;
                    w2Var.f28233f.put(a4, new t2(w2Var.new b(a4)));
                    w2.this.f28236i++;
                }
            }
            w2 w2Var2 = w2.this;
            if (w2Var2.f28228a != 2) {
                w2Var2.f28233f.remove(0);
            }
        }

        @Override // com.vivo.google.android.exoplayer3.s2
        public void a(u6 u6Var, i0 i0Var, x2.d dVar) {
        }
    }

    public class b implements s2 {

        /* renamed from: a */
        public final m6 f28240a = new m6(new byte[5]);

        /* renamed from: b */
        public final SparseArray<x2> f28241b = new SparseArray<>();

        /* renamed from: c */
        public final SparseIntArray f28242c = new SparseIntArray();

        /* renamed from: d */
        public final int f28243d;

        public b(int i2) {
            this.f28243d = i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:77:0x0205  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0212  */
        @Override // com.vivo.google.android.exoplayer3.s2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(com.vivo.google.android.exoplayer3.n6 r25) {
            /*
                Method dump skipped, instructions count: 721
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.w2.b.a(com.vivo.google.android.exoplayer3.n6):void");
        }

        @Override // com.vivo.google.android.exoplayer3.s2
        public void a(u6 u6Var, i0 i0Var, x2.d dVar) {
        }
    }

    public w2(int i2, u6 u6Var, x2.c cVar) {
        this.f28232e = (x2.c) g1.a(cVar);
        this.f28228a = i2;
        if (i2 == 1 || i2 == 2) {
            this.f28229b = Collections.singletonList(u6Var);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f28229b = arrayList;
            arrayList.add(u6Var);
        }
        this.f28230c = new n6(940);
        this.f28234g = new SparseBooleanArray();
        this.f28233f = new SparseArray<>();
        this.f28231d = new SparseIntArray();
        a();
    }

    public final void a() {
        this.f28234g.clear();
        this.f28233f.clear();
        SparseArray<x2> a2 = this.f28232e.a();
        int size = a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f28233f.put(a2.keyAt(i2), a2.valueAt(i2));
        }
        this.f28233f.put(0, new t2(new a()));
        this.k = null;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(i0 i0Var) {
        this.f28235h = i0Var;
        l3 l3Var = (l3) i0Var;
        l3Var.q = new m0.a(C.TIME_UNSET);
        l3Var.n.post(l3Var.l);
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void release() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x009d, code lost:
    
        if (r6 != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a3, code lost:
    
        if (r0 != ((r7 + 1) & 15)) goto L109;
     */
    @Override // com.vivo.google.android.exoplayer3.g0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.vivo.google.android.exoplayer3.h0 r10, com.vivo.google.android.exoplayer3.l0 r11) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.w2.a(com.vivo.google.android.exoplayer3.h0, com.vivo.google.android.exoplayer3.l0):int");
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(long j2, long j3) {
        int size = this.f28229b.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f28229b.get(i2).f28141c = C.TIME_UNSET;
        }
        this.f28230c.r();
        this.f28231d.clear();
        a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        r2 = r2 + 1;
     */
    @Override // com.vivo.google.android.exoplayer3.g0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.vivo.google.android.exoplayer3.h0 r7) {
        /*
            r6 = this;
            com.vivo.google.android.exoplayer3.n6 r0 = r6.f28230c
            byte[] r0 = r0.f27874a
            com.vivo.google.android.exoplayer3.d0 r7 = (com.vivo.google.android.exoplayer3.d0) r7
            r1 = 0
            r2 = 940(0x3ac, float:1.317E-42)
            r7.a(r0, r1, r2, r1)
            r2 = 0
        Ld:
            r3 = 188(0xbc, float:2.63E-43)
            if (r2 >= r3) goto L29
            r3 = 0
        L12:
            r4 = 5
            if (r3 != r4) goto L1a
            r7.c(r2)
            r7 = 1
            return r7
        L1a:
            int r4 = r3 * 188
            int r4 = r4 + r2
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L26
            int r2 = r2 + 1
            goto Ld
        L26:
            int r3 = r3 + 1
            goto L12
        L29:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.w2.a(com.vivo.google.android.exoplayer3.h0):boolean");
    }
}
