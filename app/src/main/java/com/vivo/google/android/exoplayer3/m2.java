package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.x2;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes4.dex */
public final class m2 implements j2 {

    /* renamed from: a */
    public final u2 f27747a;

    /* renamed from: b */
    public String f27748b;

    /* renamed from: c */
    public n0 f27749c;

    /* renamed from: d */
    public a f27750d;

    /* renamed from: e */
    public boolean f27751e;
    public long l;
    public long m;

    /* renamed from: f */
    public final boolean[] f27752f = new boolean[3];

    /* renamed from: g */
    public final p2 f27753g = new p2(32, 128);

    /* renamed from: h */
    public final p2 f27754h = new p2(33, 128);

    /* renamed from: i */
    public final p2 f27755i = new p2(34, 128);

    /* renamed from: j */
    public final p2 f27756j = new p2(39, 128);
    public final p2 k = new p2(40, 128);
    public final n6 n = new n6();

    public static final class a {

        /* renamed from: a */
        public final n0 f27757a;

        /* renamed from: b */
        public long f27758b;

        /* renamed from: c */
        public boolean f27759c;

        /* renamed from: d */
        public int f27760d;

        /* renamed from: e */
        public long f27761e;

        /* renamed from: f */
        public boolean f27762f;

        /* renamed from: g */
        public boolean f27763g;

        /* renamed from: h */
        public boolean f27764h;

        /* renamed from: i */
        public boolean f27765i;

        /* renamed from: j */
        public boolean f27766j;
        public long k;
        public long l;
        public boolean m;

        public a(n0 n0Var) {
            this.f27757a = n0Var;
        }
    }

    public m2(u2 u2Var) {
        this.f27747a = u2Var;
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(long j2, boolean z) {
        this.m = j2;
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(i0 i0Var, x2.d dVar) {
        dVar.a();
        this.f27748b = dVar.b();
        l3 l3Var = (l3) i0Var;
        n0 a2 = l3Var.a(dVar.c(), 2);
        this.f27749c = a2;
        this.f27750d = new a(a2);
        this.f27747a.a(l3Var, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x03c3  */
    @Override // com.vivo.google.android.exoplayer3.j2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.vivo.google.android.exoplayer3.n6 r39) {
        /*
            Method dump skipped, instructions count: 1001
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.m2.a(com.vivo.google.android.exoplayer3.n6):void");
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void b() {
    }

    public final void a(byte[] bArr, int i2, int i3) {
        if (this.f27751e) {
            a aVar = this.f27750d;
            if (aVar.f27762f) {
                int i4 = aVar.f27760d;
                int i5 = (i2 + 2) - i4;
                if (i5 < i3) {
                    aVar.f27763g = (bArr[i5] & ByteCompanionObject.MIN_VALUE) != 0;
                    aVar.f27762f = false;
                } else {
                    aVar.f27760d = i4 + (i3 - i2);
                }
            }
        } else {
            this.f27753g.a(bArr, i2, i3);
            this.f27754h.a(bArr, i2, i3);
            this.f27755i.a(bArr, i2, i3);
        }
        this.f27756j.a(bArr, i2, i3);
        this.k.a(bArr, i2, i3);
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a() {
        l6.a(this.f27752f);
        this.f27753g.a();
        this.f27754h.a();
        this.f27755i.a();
        this.f27756j.a();
        this.k.a();
        a aVar = this.f27750d;
        aVar.f27762f = false;
        aVar.f27763g = false;
        aVar.f27764h = false;
        aVar.f27765i = false;
        aVar.f27766j = false;
        this.l = 0L;
    }
}
