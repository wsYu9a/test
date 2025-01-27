package com.opos.exoplayer.core.c.g;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.e;
import com.opos.exoplayer.core.c.f;
import com.opos.exoplayer.core.c.g;
import com.opos.exoplayer.core.c.h;
import com.opos.exoplayer.core.c.k;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.o;
import java.util.List;

/* loaded from: classes4.dex */
public final class a implements e {

    /* renamed from: a */
    public static final h f18293a = new h() { // from class: com.opos.exoplayer.core.c.g.a.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public e[] a() {
            return new e[]{new a()};
        }
    };

    /* renamed from: b */
    private g f18294b;

    /* renamed from: c */
    private n f18295c;

    /* renamed from: d */
    private b f18296d;

    /* renamed from: e */
    private int f18297e;

    /* renamed from: f */
    private int f18298f;

    /* renamed from: com.opos.exoplayer.core.c.g.a$1 */
    static final class AnonymousClass1 implements h {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public e[] a() {
            return new e[]{new a()};
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(f fVar, k kVar) {
        if (this.f18296d == null) {
            b a2 = c.a(fVar);
            this.f18296d = a2;
            if (a2 == null) {
                throw new o("Unsupported or unrecognized wav header.");
            }
            this.f18295c.a(Format.a((String) null, "audio/raw", (String) null, a2.e(), 32768, this.f18296d.g(), this.f18296d.f(), this.f18296d.h(), (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
            this.f18297e = this.f18296d.d();
        }
        if (!this.f18296d.c()) {
            c.a(fVar, this.f18296d);
            this.f18294b.a(this.f18296d);
        }
        int a3 = this.f18295c.a(fVar, 32768 - this.f18298f, true);
        if (a3 != -1) {
            this.f18298f += a3;
        }
        int i2 = this.f18298f / this.f18297e;
        if (i2 > 0) {
            long a4 = this.f18296d.a(fVar.c() - this.f18298f);
            int i3 = i2 * this.f18297e;
            int i4 = this.f18298f - i3;
            this.f18298f = i4;
            this.f18295c.a(a4, 1, i3, i4, null);
        }
        return a3 == -1 ? -1 : 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j2, long j3) {
        this.f18298f = 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(g gVar) {
        this.f18294b = gVar;
        this.f18295c = gVar.a(0, 1);
        this.f18296d = null;
        gVar.a();
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(f fVar) {
        return c.a(fVar) != null;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
