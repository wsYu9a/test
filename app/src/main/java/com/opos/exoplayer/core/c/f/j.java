package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.k;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class j implements h {

    /* renamed from: a */
    private final w f18146a;

    /* renamed from: b */
    private final boolean f18147b;

    /* renamed from: c */
    private final boolean f18148c;

    /* renamed from: g */
    private long f18152g;

    /* renamed from: i */
    private String f18154i;

    /* renamed from: j */
    private com.opos.exoplayer.core.c.n f18155j;
    private a k;
    private boolean l;
    private long m;

    /* renamed from: h */
    private final boolean[] f18153h = new boolean[3];

    /* renamed from: d */
    private final v f18149d = new v(7, 128);

    /* renamed from: e */
    private final v f18150e = new v(8, 128);

    /* renamed from: f */
    private final v f18151f = new v(6, 128);
    private final com.opos.exoplayer.core.i.m n = new com.opos.exoplayer.core.i.m();

    private static final class a {

        /* renamed from: a */
        private final com.opos.exoplayer.core.c.n f18156a;

        /* renamed from: b */
        private final boolean f18157b;

        /* renamed from: c */
        private final boolean f18158c;

        /* renamed from: f */
        private final com.opos.exoplayer.core.i.n f18161f;

        /* renamed from: g */
        private byte[] f18162g;

        /* renamed from: h */
        private int f18163h;

        /* renamed from: i */
        private int f18164i;

        /* renamed from: j */
        private long f18165j;
        private boolean k;
        private long l;
        private boolean o;
        private long p;
        private long q;
        private boolean r;

        /* renamed from: d */
        private final SparseArray<k.b> f18159d = new SparseArray<>();

        /* renamed from: e */
        private final SparseArray<k.a> f18160e = new SparseArray<>();
        private C0404a m = new C0404a();
        private C0404a n = new C0404a();

        /* renamed from: com.opos.exoplayer.core.c.f.j$a$a */
        private static final class C0404a {

            /* renamed from: a */
            private boolean f18166a;

            /* renamed from: b */
            private boolean f18167b;

            /* renamed from: c */
            private k.b f18168c;

            /* renamed from: d */
            private int f18169d;

            /* renamed from: e */
            private int f18170e;

            /* renamed from: f */
            private int f18171f;

            /* renamed from: g */
            private int f18172g;

            /* renamed from: h */
            private boolean f18173h;

            /* renamed from: i */
            private boolean f18174i;

            /* renamed from: j */
            private boolean f18175j;
            private boolean k;
            private int l;
            private int m;
            private int n;
            private int o;
            private int p;

            private C0404a() {
            }

            /* synthetic */ C0404a(AnonymousClass1 anonymousClass1) {
                this();
            }

            public boolean a(C0404a c0404a) {
                boolean z;
                boolean z2;
                if (this.f18166a) {
                    if (!c0404a.f18166a || this.f18171f != c0404a.f18171f || this.f18172g != c0404a.f18172g || this.f18173h != c0404a.f18173h) {
                        return true;
                    }
                    if (this.f18174i && c0404a.f18174i && this.f18175j != c0404a.f18175j) {
                        return true;
                    }
                    int i2 = this.f18169d;
                    int i3 = c0404a.f18169d;
                    if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                        return true;
                    }
                    int i4 = this.f18168c.f19041h;
                    if (i4 == 0 && c0404a.f18168c.f19041h == 0 && (this.m != c0404a.m || this.n != c0404a.n)) {
                        return true;
                    }
                    if ((i4 == 1 && c0404a.f18168c.f19041h == 1 && (this.o != c0404a.o || this.p != c0404a.p)) || (z = this.k) != (z2 = c0404a.k)) {
                        return true;
                    }
                    if (z && z2 && this.l != c0404a.l) {
                        return true;
                    }
                }
                return false;
            }

            public void a() {
                this.f18167b = false;
                this.f18166a = false;
            }

            public void a(int i2) {
                this.f18170e = i2;
                this.f18167b = true;
            }

            public void a(k.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                this.f18168c = bVar;
                this.f18169d = i2;
                this.f18170e = i3;
                this.f18171f = i4;
                this.f18172g = i5;
                this.f18173h = z;
                this.f18174i = z2;
                this.f18175j = z3;
                this.k = z4;
                this.l = i6;
                this.m = i7;
                this.n = i8;
                this.o = i9;
                this.p = i10;
                this.f18166a = true;
                this.f18167b = true;
            }

            public boolean b() {
                int i2;
                return this.f18167b && ((i2 = this.f18170e) == 7 || i2 == 2);
            }
        }

        public a(com.opos.exoplayer.core.c.n nVar, boolean z, boolean z2) {
            this.f18156a = nVar;
            this.f18157b = z;
            this.f18158c = z2;
            byte[] bArr = new byte[128];
            this.f18162g = bArr;
            this.f18161f = new com.opos.exoplayer.core.i.n(bArr, 0, 0);
            b();
        }

        private void a(int i2) {
            boolean z = this.r;
            this.f18156a.a(this.q, z ? 1 : 0, (int) (this.f18165j - this.p), i2, null);
        }

        public void a(long j2, int i2) {
            boolean z = false;
            if (this.f18164i == 9 || (this.f18158c && this.n.a(this.m))) {
                if (this.o) {
                    a(((int) (j2 - this.f18165j)) + i2);
                }
                this.p = this.f18165j;
                this.q = this.l;
                this.r = false;
                this.o = true;
            }
            boolean z2 = this.r;
            int i3 = this.f18164i;
            if (i3 == 5 || (this.f18157b && i3 == 1 && this.n.b())) {
                z = true;
            }
            this.r = z2 | z;
        }

        public void a(long j2, int i2, long j3) {
            this.f18164i = i2;
            this.l = j3;
            this.f18165j = j2;
            if (!this.f18157b || i2 != 1) {
                if (!this.f18158c) {
                    return;
                }
                if (i2 != 5 && i2 != 1 && i2 != 2) {
                    return;
                }
            }
            C0404a c0404a = this.m;
            this.m = this.n;
            this.n = c0404a;
            c0404a.a();
            this.f18163h = 0;
            this.k = true;
        }

        public void a(k.a aVar) {
            this.f18160e.append(aVar.f19031a, aVar);
        }

        public void a(k.b bVar) {
            this.f18159d.append(bVar.f19034a, bVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x00fa  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0101  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0146  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0112  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x00fd  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(byte[] r24, int r25, int r26) {
            /*
                Method dump skipped, instructions count: 398
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.j.a.a(byte[], int, int):void");
        }

        public boolean a() {
            return this.f18158c;
        }

        public void b() {
            this.k = false;
            this.o = false;
            this.n.a();
        }
    }

    public j(w wVar, boolean z, boolean z2) {
        this.f18146a = wVar;
        this.f18147b = z;
        this.f18148c = z2;
    }

    private void a(long j2, int i2, int i3, long j3) {
        v vVar;
        if (!this.l || this.k.a()) {
            this.f18149d.b(i3);
            this.f18150e.b(i3);
            if (this.l) {
                if (this.f18149d.b()) {
                    v vVar2 = this.f18149d;
                    this.k.a(com.opos.exoplayer.core.i.k.a(vVar2.f18286a, 3, vVar2.f18287b));
                    vVar = this.f18149d;
                } else if (this.f18150e.b()) {
                    v vVar3 = this.f18150e;
                    this.k.a(com.opos.exoplayer.core.i.k.b(vVar3.f18286a, 3, vVar3.f18287b));
                    vVar = this.f18150e;
                }
            } else if (this.f18149d.b() && this.f18150e.b()) {
                ArrayList arrayList = new ArrayList();
                v vVar4 = this.f18149d;
                arrayList.add(Arrays.copyOf(vVar4.f18286a, vVar4.f18287b));
                v vVar5 = this.f18150e;
                arrayList.add(Arrays.copyOf(vVar5.f18286a, vVar5.f18287b));
                v vVar6 = this.f18149d;
                k.b a2 = com.opos.exoplayer.core.i.k.a(vVar6.f18286a, 3, vVar6.f18287b);
                v vVar7 = this.f18150e;
                k.a b2 = com.opos.exoplayer.core.i.k.b(vVar7.f18286a, 3, vVar7.f18287b);
                this.f18155j.a(Format.a(this.f18154i, "video/avc", (String) null, -1, -1, a2.f19035b, a2.f19036c, -1.0f, arrayList, -1, a2.f19037d, (DrmInitData) null));
                this.l = true;
                this.k.a(a2);
                this.k.a(b2);
                this.f18149d.a();
                vVar = this.f18150e;
            }
            vVar.a();
        }
        if (this.f18151f.b(i3)) {
            v vVar8 = this.f18151f;
            this.n.a(this.f18151f.f18286a, com.opos.exoplayer.core.i.k.a(vVar8.f18286a, vVar8.f18287b));
            this.n.c(4);
            this.f18146a.a(j3, this.n);
        }
        this.k.a(j2, i2);
    }

    private void a(long j2, int i2, long j3) {
        if (!this.l || this.k.a()) {
            this.f18149d.a(i2);
            this.f18150e.a(i2);
        }
        this.f18151f.a(i2);
        this.k.a(j2, i2, j3);
    }

    private void a(byte[] bArr, int i2, int i3) {
        if (!this.l || this.k.a()) {
            this.f18149d.a(bArr, i2, i3);
            this.f18150e.a(bArr, i2, i3);
        }
        this.f18151f.a(bArr, i2, i3);
        this.k.a(bArr, i2, i3);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        com.opos.exoplayer.core.i.k.a(this.f18153h);
        this.f18149d.a();
        this.f18150e.a();
        this.f18151f.a();
        this.k.b();
        this.f18152g = 0L;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j2, boolean z) {
        this.m = j2;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.f18154i = dVar.c();
        com.opos.exoplayer.core.c.n a2 = gVar.a(dVar.b(), 2);
        this.f18155j = a2;
        this.k = new a(a2, this.f18147b, this.f18148c);
        this.f18146a.a(gVar, dVar);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        int d2 = mVar.d();
        int c2 = mVar.c();
        byte[] bArr = mVar.f19048a;
        this.f18152g += mVar.b();
        this.f18155j.a(mVar, mVar.b());
        while (true) {
            int a2 = com.opos.exoplayer.core.i.k.a(bArr, d2, c2, this.f18153h);
            if (a2 == c2) {
                a(bArr, d2, c2);
                return;
            }
            int b2 = com.opos.exoplayer.core.i.k.b(bArr, a2);
            int i2 = a2 - d2;
            if (i2 > 0) {
                a(bArr, d2, a2);
            }
            int i3 = c2 - a2;
            long j2 = this.f18152g - i3;
            a(j2, i3, i2 < 0 ? -i2 : 0, this.m);
            a(j2, b2, this.m);
            d2 = a2 + 3;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
