package com.opos.exoplayer.core;

import com.vivo.google.android.exoplayer3.DefaultLoadControl;
import com.vivo.ic.dm.Constants;

/* loaded from: classes4.dex */
public class e implements n {

    /* renamed from: a */
    private final com.opos.exoplayer.core.h.j f18378a;

    /* renamed from: b */
    private final long f18379b;

    /* renamed from: c */
    private final long f18380c;

    /* renamed from: d */
    private final long f18381d;

    /* renamed from: e */
    private final long f18382e;

    /* renamed from: f */
    private final int f18383f;

    /* renamed from: g */
    private final boolean f18384g;

    /* renamed from: h */
    private final com.opos.exoplayer.core.i.p f18385h;

    /* renamed from: i */
    private int f18386i;

    /* renamed from: j */
    private boolean f18387j;

    public e() {
        this(new com.opos.exoplayer.core.h.j(true, 65536));
    }

    public e(com.opos.exoplayer.core.h.j jVar) {
        this(jVar, Constants.DEFAULT_READ_TIMEOUT, 30000, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 5000, -1, true);
    }

    public e(com.opos.exoplayer.core.h.j jVar, int i2, int i3, int i4, int i5, int i6, boolean z) {
        this(jVar, i2, i3, i4, i5, i6, z, null);
    }

    public e(com.opos.exoplayer.core.h.j jVar, int i2, int i3, int i4, int i5, int i6, boolean z, com.opos.exoplayer.core.i.p pVar) {
        this.f18378a = jVar;
        this.f18379b = i2 * 1000;
        this.f18380c = i3 * 1000;
        this.f18381d = i4 * 1000;
        this.f18382e = i5 * 1000;
        this.f18383f = i6;
        this.f18384g = z;
        this.f18385h = pVar;
    }

    private void a(boolean z) {
        this.f18386i = 0;
        com.opos.exoplayer.core.i.p pVar = this.f18385h;
        if (pVar != null && this.f18387j) {
            pVar.b(0);
        }
        this.f18387j = false;
        if (z) {
            this.f18378a.d();
        }
    }

    protected int a(s[] sVarArr, com.opos.exoplayer.core.g.g gVar) {
        int i2 = 0;
        for (int i3 = 0; i3 < sVarArr.length; i3++) {
            if (gVar.a(i3) != null) {
                i2 = com.opos.exoplayer.core.i.u.e(sVarArr[i3].a()) + i2;
            }
        }
        return i2;
    }

    @Override // com.opos.exoplayer.core.n
    public void a() {
        a(false);
    }

    @Override // com.opos.exoplayer.core.n
    public void a(s[] sVarArr, com.opos.exoplayer.core.e.m mVar, com.opos.exoplayer.core.g.g gVar) {
        int i2 = this.f18383f;
        if (i2 == -1) {
            i2 = a(sVarArr, gVar);
        }
        this.f18386i = i2;
        this.f18378a.a(i2);
    }

    @Override // com.opos.exoplayer.core.n
    public boolean a(long j2, float f2) {
        boolean z;
        boolean z2 = true;
        boolean z3 = this.f18378a.e() >= this.f18386i;
        boolean z4 = this.f18387j;
        if (!this.f18384g ? z3 || (j2 >= this.f18379b && (j2 > this.f18380c || !z4)) : j2 >= this.f18379b && (j2 > this.f18380c || !z4 || z3)) {
            z2 = false;
        }
        this.f18387j = z2;
        com.opos.exoplayer.core.i.p pVar = this.f18385h;
        if (pVar != null && (z = this.f18387j) != z4) {
            if (z) {
                pVar.a(0);
            } else {
                pVar.b(0);
            }
        }
        return this.f18387j;
    }

    @Override // com.opos.exoplayer.core.n
    public boolean a(long j2, float f2, boolean z) {
        long b2 = com.opos.exoplayer.core.i.u.b(j2, f2);
        long j3 = z ? this.f18382e : this.f18381d;
        return j3 <= 0 || b2 >= j3 || (!this.f18384g && this.f18378a.e() >= this.f18386i);
    }

    @Override // com.opos.exoplayer.core.n
    public void b() {
        a(true);
    }

    @Override // com.opos.exoplayer.core.n
    public void c() {
        a(true);
    }

    @Override // com.opos.exoplayer.core.n
    public com.opos.exoplayer.core.h.b d() {
        return this.f18378a;
    }

    @Override // com.opos.exoplayer.core.n
    public long e() {
        return 0L;
    }

    @Override // com.opos.exoplayer.core.n
    public boolean f() {
        return false;
    }
}
