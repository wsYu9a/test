package com.opos.exoplayer.core.c.c;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.e;
import com.opos.exoplayer.core.c.f;
import com.opos.exoplayer.core.c.g;
import com.opos.exoplayer.core.c.h;
import com.opos.exoplayer.core.c.i;
import com.opos.exoplayer.core.c.j;
import com.opos.exoplayer.core.c.k;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.o;
import com.vivo.google.android.exoplayer3.C;
import java.io.EOFException;
import java.util.List;

/* loaded from: classes4.dex */
public final class a implements e {

    /* renamed from: a */
    public static final h f17839a = new h() { // from class: com.opos.exoplayer.core.c.c.a.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public e[] a() {
            return new e[]{new a()};
        }
    };

    /* renamed from: b */
    private static final int f17840b = u.f("Xing");

    /* renamed from: c */
    private static final int f17841c = u.f("Info");

    /* renamed from: d */
    private static final int f17842d = u.f("VBRI");

    /* renamed from: e */
    private final int f17843e;

    /* renamed from: f */
    private final long f17844f;

    /* renamed from: g */
    private final m f17845g;

    /* renamed from: h */
    private final j f17846h;

    /* renamed from: i */
    private final i f17847i;

    /* renamed from: j */
    private g f17848j;
    private n k;
    private int l;
    private Metadata m;
    private InterfaceC0400a n;
    private long o;
    private long p;
    private int q;

    /* renamed from: com.opos.exoplayer.core.c.c.a$1 */
    static final class AnonymousClass1 implements h {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public e[] a() {
            return new e[]{new a()};
        }
    }

    /* renamed from: com.opos.exoplayer.core.c.c.a$a */
    interface InterfaceC0400a extends l {
        long a(long j2);
    }

    public a() {
        this(0);
    }

    public a(int i2) {
        this(i2, C.TIME_UNSET);
    }

    public a(int i2, long j2) {
        this.f17843e = i2;
        this.f17844f = j2;
        this.f17845g = new m(10);
        this.f17846h = new j();
        this.f17847i = new i();
        this.o = C.TIME_UNSET;
    }

    private static int a(m mVar, int i2) {
        if (mVar.c() >= i2 + 4) {
            mVar.c(i2);
            int o = mVar.o();
            if (o == f17840b || o == f17841c) {
                return o;
            }
        }
        if (mVar.c() >= 40) {
            mVar.c(36);
            int o2 = mVar.o();
            int i3 = f17842d;
            if (o2 == i3) {
                return i3;
            }
        }
        return 0;
    }

    private static boolean a(int i2, long j2) {
        return ((long) (i2 & (-128000))) == (j2 & (-128000));
    }

    private boolean a(f fVar, boolean z) {
        int i2;
        int i3;
        int a2;
        int i4 = z ? 16384 : 131072;
        fVar.a();
        if (fVar.c() == 0) {
            c(fVar);
            i3 = (int) fVar.b();
            if (!z) {
                fVar.b(i3);
            }
            i2 = 0;
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (!fVar.b(this.f17845g.f19048a, 0, 4, i2 > 0)) {
                break;
            }
            this.f17845g.c(0);
            int o = this.f17845g.o();
            if ((i5 == 0 || a(o, i5)) && (a2 = j.a(o)) != -1) {
                i2++;
                if (i2 != 1) {
                    if (i2 == 4) {
                        break;
                    }
                } else {
                    j.a(o, this.f17846h);
                    i5 = o;
                }
                fVar.c(a2 - 4);
            } else {
                int i7 = i6 + 1;
                if (i6 == i4) {
                    if (z) {
                        return false;
                    }
                    throw new o("Searched too many bytes.");
                }
                if (z) {
                    fVar.a();
                    fVar.c(i3 + i7);
                } else {
                    fVar.b(1);
                }
                i6 = i7;
                i2 = 0;
                i5 = 0;
            }
        }
        if (z) {
            fVar.b(i3 + i6);
        } else {
            fVar.a();
        }
        this.l = i5;
        return true;
    }

    private int b(f fVar) {
        if (this.q == 0) {
            fVar.a();
            if (!fVar.b(this.f17845g.f19048a, 0, 4, true)) {
                return -1;
            }
            this.f17845g.c(0);
            int o = this.f17845g.o();
            if (!a(o, this.l) || j.a(o) == -1) {
                fVar.b(1);
                this.l = 0;
                return 0;
            }
            j.a(o, this.f17846h);
            if (this.o == C.TIME_UNSET) {
                this.o = this.n.a(fVar.c());
                if (this.f17844f != C.TIME_UNSET) {
                    this.o = (this.f17844f - this.n.a(0L)) + this.o;
                }
            }
            this.q = this.f17846h.f18318c;
        }
        int a2 = this.k.a(fVar, this.q, true);
        if (a2 == -1) {
            return -1;
        }
        int i2 = this.q - a2;
        this.q = i2;
        if (i2 <= 0) {
            this.k.a(((this.p * C.MICROS_PER_SECOND) / r14.f18319d) + this.o, 1, this.f17846h.f18318c, 0, null);
            this.p += this.f17846h.f18322g;
            this.q = 0;
        }
        return 0;
    }

    private void c(f fVar) {
        int i2 = 0;
        while (true) {
            fVar.c(this.f17845g.f19048a, 0, 10);
            this.f17845g.c(0);
            if (this.f17845g.k() != com.opos.exoplayer.core.metadata.id3.a.f19145a) {
                fVar.a();
                fVar.c(i2);
                return;
            }
            this.f17845g.d(3);
            int t = this.f17845g.t();
            int i3 = t + 10;
            if (this.m == null) {
                byte[] bArr = new byte[i3];
                System.arraycopy(this.f17845g.f19048a, 0, bArr, 0, 10);
                fVar.c(bArr, 10, t);
                Metadata a2 = new com.opos.exoplayer.core.metadata.id3.a((this.f17843e & 2) != 0 ? i.f18309a : null).a(bArr, i3);
                this.m = a2;
                if (a2 != null) {
                    this.f17847i.a(a2);
                }
            } else {
                fVar.c(t);
            }
            i2 += i3;
        }
    }

    private InterfaceC0400a d(f fVar) {
        int i2;
        m mVar = new m(this.f17846h.f18318c);
        fVar.c(mVar.f19048a, 0, this.f17846h.f18318c);
        j jVar = this.f17846h;
        int i3 = jVar.f18316a & 1;
        int i4 = jVar.f18320e;
        if (i3 != 0) {
            if (i4 != 1) {
                i2 = 36;
            }
            i2 = 21;
        } else {
            if (i4 == 1) {
                i2 = 13;
            }
            i2 = 21;
        }
        int a2 = a(mVar, i2);
        if (a2 != f17840b && a2 != f17841c) {
            if (a2 != f17842d) {
                fVar.a();
                return null;
            }
            c a3 = c.a(fVar.d(), fVar.c(), this.f17846h, mVar);
            fVar.b(this.f17846h.f18318c);
            return a3;
        }
        d a4 = d.a(fVar.d(), fVar.c(), this.f17846h, mVar);
        if (a4 != null && !this.f17847i.a()) {
            fVar.a();
            fVar.c(i2 + 141);
            fVar.c(this.f17845g.f19048a, 0, 3);
            this.f17845g.c(0);
            this.f17847i.a(this.f17845g.k());
        }
        fVar.b(this.f17846h.f18318c);
        return (a4 == null || a4.a() || a2 != f17841c) ? a4 : e(fVar);
    }

    private InterfaceC0400a e(f fVar) {
        fVar.c(this.f17845g.f19048a, 0, 4);
        this.f17845g.c(0);
        j.a(this.f17845g.o(), this.f17846h);
        return new b(fVar.d(), fVar.c(), this.f17846h);
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(f fVar, k kVar) {
        if (this.l == 0) {
            try {
                a(fVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.n == null) {
            InterfaceC0400a d2 = d(fVar);
            this.n = d2;
            if (d2 == null || (!d2.a() && (this.f17843e & 1) != 0)) {
                this.n = e(fVar);
            }
            this.f17848j.a(this.n);
            n nVar = this.k;
            j jVar = this.f17846h;
            String str = jVar.f18317b;
            int i2 = jVar.f18320e;
            int i3 = jVar.f18319d;
            i iVar = this.f17847i;
            nVar.a(Format.a((String) null, str, (String) null, -1, 4096, i2, i3, -1, iVar.f18311b, iVar.f18312c, (List<byte[]>) null, (DrmInitData) null, 0, (String) null, (this.f17843e & 2) != 0 ? null : this.m));
        }
        return b(fVar);
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j2, long j3) {
        this.l = 0;
        this.o = C.TIME_UNSET;
        this.p = 0L;
        this.q = 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(g gVar) {
        this.f17848j = gVar;
        this.k = gVar.a(0, 1);
        this.f17848j.a();
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(f fVar) {
        return a(fVar, true);
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
