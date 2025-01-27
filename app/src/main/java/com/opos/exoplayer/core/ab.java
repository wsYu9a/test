package com.opos.exoplayer.core;

/* loaded from: classes4.dex */
final class ab {

    /* renamed from: a */
    public final com.opos.exoplayer.core.e.d f17673a;

    /* renamed from: b */
    public final Object f17674b;

    /* renamed from: c */
    public final com.opos.exoplayer.core.e.i[] f17675c;

    /* renamed from: d */
    public final boolean[] f17676d;

    /* renamed from: e */
    public long f17677e;

    /* renamed from: f */
    public boolean f17678f;

    /* renamed from: g */
    public boolean f17679g;

    /* renamed from: h */
    public ac f17680h;

    /* renamed from: i */
    public ab f17681i;

    /* renamed from: j */
    public com.opos.exoplayer.core.g.i f17682j;
    private final t[] k;
    private final com.opos.exoplayer.core.g.h l;
    private final com.opos.exoplayer.core.e.e m;
    private com.opos.exoplayer.core.g.i n;

    public ab(t[] tVarArr, long j2, com.opos.exoplayer.core.g.h hVar, com.opos.exoplayer.core.h.b bVar, com.opos.exoplayer.core.e.e eVar, Object obj, ac acVar) {
        this.k = tVarArr;
        this.f17677e = j2 - acVar.f17684b;
        this.l = hVar;
        this.m = eVar;
        this.f17674b = com.opos.exoplayer.core.i.a.a(obj);
        this.f17680h = acVar;
        this.f17675c = new com.opos.exoplayer.core.e.i[tVarArr.length];
        this.f17676d = new boolean[tVarArr.length];
        com.opos.exoplayer.core.e.d a2 = eVar.a(acVar.f17683a, bVar);
        if (acVar.f17685c != Long.MIN_VALUE) {
            com.opos.exoplayer.core.e.a aVar = new com.opos.exoplayer.core.e.a(a2, true);
            aVar.a(0L, acVar.f17685c);
            a2 = aVar;
        }
        this.f17673a = a2;
    }

    private void a(com.opos.exoplayer.core.g.i iVar) {
        com.opos.exoplayer.core.g.i iVar2 = this.n;
        if (iVar2 != null) {
            c(iVar2);
        }
        this.n = iVar;
        if (iVar != null) {
            b(iVar);
        }
    }

    private void a(com.opos.exoplayer.core.e.i[] iVarArr) {
        int i2 = 0;
        while (true) {
            t[] tVarArr = this.k;
            if (i2 >= tVarArr.length) {
                return;
            }
            if (tVarArr[i2].a() == 5) {
                iVarArr[i2] = null;
            }
            i2++;
        }
    }

    private void b(com.opos.exoplayer.core.g.i iVar) {
        int i2 = 0;
        while (true) {
            boolean[] zArr = iVar.f18893b;
            if (i2 >= zArr.length) {
                return;
            }
            boolean z = zArr[i2];
            com.opos.exoplayer.core.g.f a2 = iVar.f18894c.a(i2);
            if (z && a2 != null) {
                a2.a();
            }
            i2++;
        }
    }

    private void b(com.opos.exoplayer.core.e.i[] iVarArr) {
        int i2 = 0;
        while (true) {
            t[] tVarArr = this.k;
            if (i2 >= tVarArr.length) {
                return;
            }
            if (tVarArr[i2].a() == 5 && this.f17682j.f18893b[i2]) {
                iVarArr[i2] = new com.opos.exoplayer.core.e.b();
            }
            i2++;
        }
    }

    private void c(com.opos.exoplayer.core.g.i iVar) {
        int i2 = 0;
        while (true) {
            boolean[] zArr = iVar.f18893b;
            if (i2 >= zArr.length) {
                return;
            }
            boolean z = zArr[i2];
            com.opos.exoplayer.core.g.f a2 = iVar.f18894c.a(i2);
            if (z && a2 != null) {
                a2.c();
            }
            i2++;
        }
    }

    public long a() {
        return this.f17677e;
    }

    public long a(long j2) {
        return a() + j2;
    }

    public long a(long j2, boolean z) {
        return a(j2, z, new boolean[this.k.length]);
    }

    public long a(long j2, boolean z, boolean[] zArr) {
        com.opos.exoplayer.core.g.g gVar = this.f17682j.f18894c;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= gVar.f18888a) {
                break;
            }
            boolean[] zArr2 = this.f17676d;
            if (z || !this.f17682j.a(this.n, i2)) {
                z2 = false;
            }
            zArr2[i2] = z2;
            i2++;
        }
        a(this.f17675c);
        a(this.f17682j);
        long a2 = this.f17673a.a(gVar.a(), this.f17676d, this.f17675c, zArr, j2);
        b(this.f17675c);
        this.f17679g = false;
        int i3 = 0;
        while (true) {
            com.opos.exoplayer.core.e.i[] iVarArr = this.f17675c;
            if (i3 >= iVarArr.length) {
                return a2;
            }
            if (iVarArr[i3] != null) {
                com.opos.exoplayer.core.i.a.b(this.f17682j.f18893b[i3]);
                if (this.k[i3].a() != 5) {
                    this.f17679g = true;
                }
            } else {
                com.opos.exoplayer.core.i.a.b(gVar.a(i3) == null);
            }
            i3++;
        }
    }

    public long a(boolean z) {
        if (!this.f17678f) {
            return this.f17680h.f17684b;
        }
        long d2 = this.f17673a.d();
        return (d2 == Long.MIN_VALUE && z) ? this.f17680h.f17687e : d2;
    }

    public com.opos.exoplayer.core.g.i a(float f2) {
        this.f17678f = true;
        b(f2);
        long a2 = a(this.f17680h.f17684b, false);
        long j2 = this.f17677e;
        ac acVar = this.f17680h;
        this.f17677e = j2 + (acVar.f17684b - a2);
        this.f17680h = acVar.a(a2);
        return this.f17682j;
    }

    public long b(long j2) {
        return j2 - a();
    }

    public boolean b() {
        return this.f17678f && (!this.f17679g || this.f17673a.d() == Long.MIN_VALUE);
    }

    public boolean b(float f2) {
        com.opos.exoplayer.core.g.i a2 = this.l.a(this.k, this.f17673a.b());
        if (a2.a(this.n)) {
            return false;
        }
        this.f17682j = a2;
        for (com.opos.exoplayer.core.g.f fVar : a2.f18894c.a()) {
            if (fVar != null) {
                fVar.a(f2);
            }
        }
        return true;
    }

    public long c() {
        if (this.f17678f) {
            return this.f17673a.e();
        }
        return 0L;
    }

    public void c(long j2) {
        if (this.f17678f) {
            this.f17673a.a(b(j2));
        }
    }

    public void d() {
        com.opos.exoplayer.core.e.e eVar;
        com.opos.exoplayer.core.e.d dVar;
        a((com.opos.exoplayer.core.g.i) null);
        try {
            if (this.f17680h.f17685c != Long.MIN_VALUE) {
                eVar = this.m;
                dVar = ((com.opos.exoplayer.core.e.a) this.f17673a).f18388a;
            } else {
                eVar = this.m;
                dVar = this.f17673a;
            }
            eVar.a(dVar);
        } catch (RuntimeException e2) {
            com.opos.cmn.an.f.a.d("MediaPeriodHolder", "Period release failed.", e2);
        }
    }

    public void d(long j2) {
        this.f17673a.c(b(j2));
    }
}
