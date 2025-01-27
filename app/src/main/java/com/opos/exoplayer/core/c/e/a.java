package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.o;

/* loaded from: classes4.dex */
public class a implements com.opos.exoplayer.core.c.e {

    /* renamed from: a */
    public static final com.opos.exoplayer.core.c.h f17993a = new com.opos.exoplayer.core.c.h() { // from class: com.opos.exoplayer.core.c.e.a.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new a()};
        }
    };

    /* renamed from: b */
    private com.opos.exoplayer.core.c.g f17994b;

    /* renamed from: c */
    private i f17995c;

    /* renamed from: d */
    private boolean f17996d;

    /* renamed from: com.opos.exoplayer.core.c.e.a$1 */
    static final class AnonymousClass1 implements com.opos.exoplayer.core.c.h {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new a()};
        }
    }

    private static m a(m mVar) {
        mVar.c(0);
        return mVar;
    }

    private boolean b(com.opos.exoplayer.core.c.f fVar) {
        i hVar;
        f fVar2 = new f();
        if (fVar2.a(fVar, true) && (fVar2.f18043b & 2) == 2) {
            int min = Math.min(fVar2.f18050i, 8);
            m mVar = new m(min);
            fVar.c(mVar.f19048a, 0, min);
            if (d.a(a(mVar))) {
                hVar = new d();
            } else if (k.a(a(mVar))) {
                hVar = new k();
            } else if (h.a(a(mVar))) {
                hVar = new h();
            }
            this.f17995c = hVar;
            return true;
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        if (this.f17995c == null) {
            if (!b(fVar)) {
                throw new o("Failed to determine bitstream type");
            }
            fVar.a();
        }
        if (!this.f17996d) {
            n a2 = this.f17994b.a(0, 1);
            this.f17994b.a();
            this.f17995c.a(this.f17994b, a2);
            this.f17996d = true;
        }
        return this.f17995c.a(fVar, kVar);
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j2, long j3) {
        i iVar = this.f17995c;
        if (iVar != null) {
            iVar.a(j2, j3);
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.f17994b = gVar;
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        try {
            return b(fVar);
        } catch (o unused) {
            return false;
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
