package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import com.opos.exoplayer.core.c.l;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class p implements com.opos.exoplayer.core.c.e {

    /* renamed from: a */
    public static final com.opos.exoplayer.core.c.h f18232a = new com.opos.exoplayer.core.c.h() { // from class: com.opos.exoplayer.core.c.f.p.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new p()};
        }
    };

    /* renamed from: b */
    private final com.opos.exoplayer.core.i.s f18233b;

    /* renamed from: c */
    private final SparseArray<a> f18234c;

    /* renamed from: d */
    private final com.opos.exoplayer.core.i.m f18235d;

    /* renamed from: e */
    private boolean f18236e;

    /* renamed from: f */
    private boolean f18237f;

    /* renamed from: g */
    private boolean f18238g;

    /* renamed from: h */
    private com.opos.exoplayer.core.c.g f18239h;

    /* renamed from: com.opos.exoplayer.core.c.f.p$1 */
    static final class AnonymousClass1 implements com.opos.exoplayer.core.c.h {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new p()};
        }
    }

    private static final class a {

        /* renamed from: a */
        private final h f18240a;

        /* renamed from: b */
        private final com.opos.exoplayer.core.i.s f18241b;

        /* renamed from: c */
        private final com.opos.exoplayer.core.i.l f18242c = new com.opos.exoplayer.core.i.l(new byte[64]);

        /* renamed from: d */
        private boolean f18243d;

        /* renamed from: e */
        private boolean f18244e;

        /* renamed from: f */
        private boolean f18245f;

        /* renamed from: g */
        private int f18246g;

        /* renamed from: h */
        private long f18247h;

        public a(h hVar, com.opos.exoplayer.core.i.s sVar) {
            this.f18240a = hVar;
            this.f18241b = sVar;
        }

        private void b() {
            this.f18242c.b(8);
            this.f18243d = this.f18242c.e();
            this.f18244e = this.f18242c.e();
            this.f18242c.b(6);
            this.f18246g = this.f18242c.c(8);
        }

        private void c() {
            char c2;
            this.f18247h = 0L;
            if (this.f18243d) {
                this.f18242c.b(4);
                long c3 = this.f18242c.c(3);
                this.f18242c.b(1);
                long c4 = this.f18242c.c(15) << 15;
                this.f18242c.b(1);
                long c5 = this.f18242c.c(15);
                this.f18242c.b(1);
                if (this.f18245f || !this.f18244e) {
                    c2 = 30;
                } else {
                    this.f18242c.b(4);
                    long c6 = this.f18242c.c(3);
                    this.f18242c.b(1);
                    long c7 = this.f18242c.c(15) << 15;
                    this.f18242c.b(1);
                    long c8 = this.f18242c.c(15);
                    this.f18242c.b(1);
                    c2 = 30;
                    this.f18241b.b((c6 << 30) | c7 | c8);
                    this.f18245f = true;
                }
                this.f18247h = this.f18241b.b((c3 << c2) | c4 | c5);
            }
        }

        public void a() {
            this.f18245f = false;
            this.f18240a.a();
        }

        public void a(com.opos.exoplayer.core.i.m mVar) {
            mVar.a(this.f18242c.f19044a, 0, 3);
            this.f18242c.a(0);
            b();
            mVar.a(this.f18242c.f19044a, 0, this.f18246g);
            this.f18242c.a(0);
            c();
            this.f18240a.a(this.f18247h, true);
            this.f18240a.a(mVar);
            this.f18240a.b();
        }
    }

    public p() {
        this(new com.opos.exoplayer.core.i.s(0L));
    }

    public p(com.opos.exoplayer.core.i.s sVar) {
        this.f18233b = sVar;
        this.f18235d = new com.opos.exoplayer.core.i.m(4096);
        this.f18234c = new SparseArray<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a8  */
    @Override // com.opos.exoplayer.core.c.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.opos.exoplayer.core.c.f r10, com.opos.exoplayer.core.c.k r11) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.p.a(com.opos.exoplayer.core.c.f, com.opos.exoplayer.core.c.k):int");
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j2, long j3) {
        this.f18233b.d();
        for (int i2 = 0; i2 < this.f18234c.size(); i2++) {
            this.f18234c.valueAt(i2).a();
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.f18239h = gVar;
        gVar.a(new l.b(C.TIME_UNSET));
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        byte[] bArr = new byte[14];
        fVar.c(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        fVar.c(bArr[13] & 7);
        fVar.c(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
