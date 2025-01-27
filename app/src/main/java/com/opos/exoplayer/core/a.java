package com.opos.exoplayer.core;

import androidx.annotation.Nullable;
import com.opos.exoplayer.core.drm.DrmInitData;

/* loaded from: classes4.dex */
public abstract class a implements s, t {

    /* renamed from: a */
    private final int f17501a;

    /* renamed from: b */
    private u f17502b;

    /* renamed from: c */
    private int f17503c;

    /* renamed from: d */
    private int f17504d;

    /* renamed from: e */
    private com.opos.exoplayer.core.e.i f17505e;

    /* renamed from: f */
    private long f17506f;

    /* renamed from: g */
    private boolean f17507g = true;

    /* renamed from: h */
    private boolean f17508h;

    public a(int i2) {
        this.f17501a = i2;
    }

    protected static boolean a(@Nullable com.opos.exoplayer.core.drm.b<?> bVar, @Nullable DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (bVar == null) {
            return false;
        }
        return bVar.a(drmInitData);
    }

    @Override // com.opos.exoplayer.core.s, com.opos.exoplayer.core.t
    public final int a() {
        return this.f17501a;
    }

    protected final int a(l lVar, com.opos.exoplayer.core.b.e eVar, boolean z) {
        int a2 = this.f17505e.a(lVar, eVar, z);
        if (a2 == -4) {
            if (eVar.c()) {
                this.f17507g = true;
                return this.f17508h ? -4 : -3;
            }
            eVar.f17740c += this.f17506f;
            return a2;
        }
        if (a2 != -5) {
            return a2;
        }
        Format format = lVar.f19091a;
        long j2 = format.w;
        if (j2 == Long.MAX_VALUE) {
            return a2;
        }
        lVar.f19091a = format.a(j2 + this.f17506f);
        return a2;
    }

    @Override // com.opos.exoplayer.core.s
    public final void a(int i2) {
        this.f17503c = i2;
    }

    @Override // com.opos.exoplayer.core.r.b
    public void a(int i2, Object obj) {
    }

    @Override // com.opos.exoplayer.core.s
    public final void a(long j2) {
        this.f17508h = false;
        this.f17507g = false;
        a(j2, false);
    }

    protected void a(long j2, boolean z) {
    }

    @Override // com.opos.exoplayer.core.s
    public final void a(u uVar, Format[] formatArr, com.opos.exoplayer.core.e.i iVar, long j2, boolean z, long j3) {
        com.opos.exoplayer.core.i.a.b(this.f17504d == 0);
        this.f17502b = uVar;
        this.f17504d = 1;
        a(z);
        a(formatArr, iVar, j3);
        a(j2, z);
    }

    protected void a(boolean z) {
    }

    protected void a(Format[] formatArr, long j2) {
    }

    @Override // com.opos.exoplayer.core.s
    public final void a(Format[] formatArr, com.opos.exoplayer.core.e.i iVar, long j2) {
        com.opos.exoplayer.core.i.a.b(!this.f17508h);
        this.f17505e = iVar;
        this.f17507g = false;
        this.f17506f = j2;
        a(formatArr, j2);
    }

    @Override // com.opos.exoplayer.core.s
    public final int a_() {
        return this.f17504d;
    }

    protected int b(long j2) {
        return this.f17505e.a(j2 - this.f17506f);
    }

    @Override // com.opos.exoplayer.core.s
    public final t b() {
        return this;
    }

    @Override // com.opos.exoplayer.core.s
    public final void b_() {
        com.opos.exoplayer.core.i.a.b(this.f17504d == 1);
        this.f17504d = 2;
        n();
    }

    @Override // com.opos.exoplayer.core.s
    public com.opos.exoplayer.core.i.i c() {
        return null;
    }

    @Override // com.opos.exoplayer.core.s
    public final com.opos.exoplayer.core.e.i f() {
        return this.f17505e;
    }

    @Override // com.opos.exoplayer.core.s
    public final boolean g() {
        return this.f17507g;
    }

    @Override // com.opos.exoplayer.core.s
    public final void h() {
        this.f17508h = true;
    }

    @Override // com.opos.exoplayer.core.s
    public final boolean i() {
        return this.f17508h;
    }

    @Override // com.opos.exoplayer.core.s
    public final void j() {
        this.f17505e.c();
    }

    @Override // com.opos.exoplayer.core.s
    public final void k() {
        com.opos.exoplayer.core.i.a.b(this.f17504d == 2);
        this.f17504d = 1;
        o();
    }

    @Override // com.opos.exoplayer.core.s
    public final void l() {
        com.opos.exoplayer.core.i.a.b(this.f17504d == 1);
        this.f17504d = 0;
        this.f17505e = null;
        this.f17508h = false;
        p();
    }

    @Override // com.opos.exoplayer.core.t
    public int m() {
        return 0;
    }

    protected void n() {
    }

    protected void o() {
    }

    protected void p() {
    }

    protected final u q() {
        return this.f17502b;
    }

    protected final int r() {
        return this.f17503c;
    }

    protected final boolean s() {
        return this.f17507g ? this.f17508h : this.f17505e.b();
    }
}
