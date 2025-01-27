package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.a.a;
import com.opos.exoplayer.core.c.f.u;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class b implements h {

    /* renamed from: a */
    private final com.opos.exoplayer.core.i.l f18087a;

    /* renamed from: b */
    private final com.opos.exoplayer.core.i.m f18088b;

    /* renamed from: c */
    private final String f18089c;

    /* renamed from: d */
    private String f18090d;

    /* renamed from: e */
    private com.opos.exoplayer.core.c.n f18091e;

    /* renamed from: f */
    private int f18092f;

    /* renamed from: g */
    private int f18093g;

    /* renamed from: h */
    private boolean f18094h;

    /* renamed from: i */
    private long f18095i;

    /* renamed from: j */
    private Format f18096j;
    private int k;
    private long l;

    public b() {
        this(null);
    }

    public b(String str) {
        com.opos.exoplayer.core.i.l lVar = new com.opos.exoplayer.core.i.l(new byte[128]);
        this.f18087a = lVar;
        this.f18088b = new com.opos.exoplayer.core.i.m(lVar.f19044a);
        this.f18092f = 0;
        this.f18089c = str;
    }

    private boolean a(com.opos.exoplayer.core.i.m mVar, byte[] bArr, int i2) {
        int min = Math.min(mVar.b(), i2 - this.f18093g);
        mVar.a(bArr, this.f18093g, min);
        int i3 = min + this.f18093g;
        this.f18093g = i3;
        return i3 == i2;
    }

    private boolean b(com.opos.exoplayer.core.i.m mVar) {
        while (true) {
            boolean z = true;
            if (mVar.b() <= 0) {
                return false;
            }
            if (this.f18094h) {
                int g2 = mVar.g();
                if (g2 == 119) {
                    this.f18094h = false;
                    return true;
                }
                if (g2 == 11) {
                    this.f18094h = z;
                }
                z = false;
                this.f18094h = z;
            } else {
                if (mVar.g() == 11) {
                    this.f18094h = z;
                }
                z = false;
                this.f18094h = z;
            }
        }
    }

    private void c() {
        this.f18087a.a(0);
        a.C0398a a2 = com.opos.exoplayer.core.a.a.a(this.f18087a);
        Format format = this.f18096j;
        if (format == null || a2.f17518d != format.r || a2.f17517c != format.s || a2.f17515a != format.f17496f) {
            Format a3 = Format.a(this.f18090d, a2.f17515a, null, -1, -1, a2.f17518d, a2.f17517c, null, null, 0, this.f18089c);
            this.f18096j = a3;
            this.f18091e.a(a3);
        }
        this.k = a2.f17519e;
        this.f18095i = (a2.f17520f * C.MICROS_PER_SECOND) / this.f18096j.s;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.f18092f = 0;
        this.f18093g = 0;
        this.f18094h = false;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j2, boolean z) {
        this.l = j2;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.f18090d = dVar.c();
        this.f18091e = gVar.a(dVar.b(), 1);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        while (mVar.b() > 0) {
            int i2 = this.f18092f;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(mVar.b(), this.k - this.f18093g);
                        this.f18091e.a(mVar, min);
                        int i3 = min + this.f18093g;
                        this.f18093g = i3;
                        int i4 = this.k;
                        if (i3 == i4) {
                            this.f18091e.a(this.l, 1, i4, 0, null);
                            this.l += this.f18095i;
                            this.f18092f = 0;
                        }
                    }
                } else if (a(mVar, this.f18088b.f19048a, 128)) {
                    c();
                    this.f18088b.c(0);
                    this.f18091e.a(this.f18088b, 128);
                    this.f18092f = 2;
                }
            } else if (b(mVar)) {
                this.f18092f = 1;
                byte[] bArr = this.f18088b.f19048a;
                bArr[0] = (byte) 11;
                bArr[1] = (byte) 119;
                this.f18093g = 2;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
