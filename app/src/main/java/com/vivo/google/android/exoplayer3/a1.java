package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.metadata.Metadata;
import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class a1 implements g0 {
    public static final int n = Util.getIntegerCodeForString("Xing");
    public static final int o = Util.getIntegerCodeForString("Info");
    public static final int p = Util.getIntegerCodeForString("VBRI");

    /* renamed from: a */
    public final int f27123a;

    /* renamed from: b */
    public final long f27124b;

    /* renamed from: f */
    public i0 f27128f;

    /* renamed from: g */
    public n0 f27129g;

    /* renamed from: h */
    public int f27130h;

    /* renamed from: i */
    public Metadata f27131i;

    /* renamed from: j */
    public a f27132j;
    public long l;
    public int m;

    /* renamed from: c */
    public final n6 f27125c = new n6(10);

    /* renamed from: d */
    public final k0 f27126d = new k0();

    /* renamed from: e */
    public final j0 f27127e = new j0();
    public long k = C.TIME_UNSET;

    public interface a extends m0 {
        long c(long j2);
    }

    public a1(int i2, long j2) {
        this.f27123a = i2;
        this.f27124b = j2;
    }

    public static boolean a(int i2, long j2) {
        return ((long) (i2 & (-128000))) == (j2 & (-128000));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:
    
        if (r12 != com.vivo.google.android.exoplayer3.a1.o) goto L163;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x005f  */
    @Override // com.vivo.google.android.exoplayer3.g0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.vivo.google.android.exoplayer3.h0 r41, com.vivo.google.android.exoplayer3.l0 r42) {
        /*
            Method dump skipped, instructions count: 783
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.a1.a(com.vivo.google.android.exoplayer3.h0, com.vivo.google.android.exoplayer3.l0):int");
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(long j2, long j3) {
        this.f27130h = 0;
        this.k = C.TIME_UNSET;
        this.l = 0L;
        this.m = 0;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(i0 i0Var) {
        this.f27128f = i0Var;
        this.f27129g = ((l3) i0Var).a(0, 1);
        ((l3) this.f27128f).f();
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public boolean a(h0 h0Var) {
        return a(h0Var, true);
    }

    public final a b(h0 h0Var) {
        d0 d0Var = (d0) h0Var;
        d0Var.a(this.f27125c.f27874a, 0, 4, false);
        this.f27125c.d(0);
        k0.a(this.f27125c.c(), this.f27126d);
        return new z0(d0Var.f27268c, this.f27126d.f27557f, d0Var.f27267b);
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void release() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00dd, code lost:
    
        if (r15 == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00df, code lost:
    
        r14.c(r3 + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e6, code lost:
    
        r13.f27130h = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e8, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e4, code lost:
    
        r14.f27270e = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(com.vivo.google.android.exoplayer3.h0 r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.a1.a(com.vivo.google.android.exoplayer3.h0, boolean):boolean");
    }
}
