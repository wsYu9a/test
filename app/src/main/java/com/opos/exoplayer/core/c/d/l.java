package com.opos.exoplayer.core.c.d;

/* loaded from: classes4.dex */
final class l {

    /* renamed from: a */
    public i f17976a;

    /* renamed from: b */
    public long f17977b;

    /* renamed from: c */
    public long f17978c;

    /* renamed from: d */
    public long f17979d;

    /* renamed from: e */
    public int f17980e;

    /* renamed from: f */
    public int f17981f;

    /* renamed from: g */
    public long[] f17982g;

    /* renamed from: h */
    public int[] f17983h;

    /* renamed from: i */
    public int[] f17984i;

    /* renamed from: j */
    public int[] f17985j;
    public long[] k;
    public boolean[] l;
    public boolean m;
    public boolean[] n;
    public f o;
    public int p;
    public com.opos.exoplayer.core.i.m q;
    public boolean r;
    public long s;

    l() {
    }

    public void a() {
        this.f17980e = 0;
        this.s = 0L;
        this.m = false;
        this.r = false;
        this.o = null;
    }

    public void a(int i2) {
        com.opos.exoplayer.core.i.m mVar = this.q;
        if (mVar == null || mVar.c() < i2) {
            this.q = new com.opos.exoplayer.core.i.m(i2);
        }
        this.p = i2;
        this.m = true;
        this.r = true;
    }

    public void a(int i2, int i3) {
        this.f17980e = i2;
        this.f17981f = i3;
        int[] iArr = this.f17983h;
        if (iArr == null || iArr.length < i2) {
            this.f17982g = new long[i2];
            this.f17983h = new int[i2];
        }
        int[] iArr2 = this.f17984i;
        if (iArr2 == null || iArr2.length < i3) {
            int i4 = (i3 * 125) / 100;
            this.f17984i = new int[i4];
            this.f17985j = new int[i4];
            this.k = new long[i4];
            this.l = new boolean[i4];
            this.n = new boolean[i4];
        }
    }

    public void a(com.opos.exoplayer.core.c.f fVar) {
        fVar.b(this.q.f19048a, 0, this.p);
        this.q.c(0);
        this.r = false;
    }

    public void a(com.opos.exoplayer.core.i.m mVar) {
        mVar.a(this.q.f19048a, 0, this.p);
        this.q.c(0);
        this.r = false;
    }

    public long b(int i2) {
        return this.k[i2] + this.f17985j[i2];
    }
}
