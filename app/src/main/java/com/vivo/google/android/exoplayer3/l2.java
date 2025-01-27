package com.vivo.google.android.exoplayer3;

import android.util.SparseArray;
import com.vivo.google.android.exoplayer3.l6;
import com.vivo.google.android.exoplayer3.x2;

/* loaded from: classes4.dex */
public final class l2 implements j2 {

    /* renamed from: a */
    public final u2 f27613a;

    /* renamed from: b */
    public final boolean f27614b;

    /* renamed from: c */
    public final boolean f27615c;

    /* renamed from: g */
    public long f27619g;

    /* renamed from: i */
    public String f27621i;

    /* renamed from: j */
    public n0 f27622j;
    public b k;
    public boolean l;
    public long m;

    /* renamed from: h */
    public final boolean[] f27620h = new boolean[3];

    /* renamed from: d */
    public final p2 f27616d = new p2(7, 128);

    /* renamed from: e */
    public final p2 f27617e = new p2(8, 128);

    /* renamed from: f */
    public final p2 f27618f = new p2(6, 128);
    public final n6 n = new n6();

    public static final class b {

        /* renamed from: a */
        public final n0 f27623a;

        /* renamed from: b */
        public final boolean f27624b;

        /* renamed from: c */
        public final boolean f27625c;

        /* renamed from: f */
        public final o6 f27628f;

        /* renamed from: g */
        public byte[] f27629g;

        /* renamed from: h */
        public int f27630h;

        /* renamed from: i */
        public int f27631i;

        /* renamed from: j */
        public long f27632j;
        public boolean k;
        public long l;
        public boolean o;
        public long p;
        public long q;
        public boolean r;

        /* renamed from: d */
        public final SparseArray<l6.b> f27626d = new SparseArray<>();

        /* renamed from: e */
        public final SparseArray<l6.a> f27627e = new SparseArray<>();
        public a m = new a();
        public a n = new a();

        public static final class a {

            /* renamed from: a */
            public boolean f27633a;

            /* renamed from: b */
            public boolean f27634b;

            /* renamed from: c */
            public l6.b f27635c;

            /* renamed from: d */
            public int f27636d;

            /* renamed from: e */
            public int f27637e;

            /* renamed from: f */
            public int f27638f;

            /* renamed from: g */
            public int f27639g;

            /* renamed from: h */
            public boolean f27640h;

            /* renamed from: i */
            public boolean f27641i;

            /* renamed from: j */
            public boolean f27642j;
            public boolean k;
            public int l;
            public int m;
            public int n;
            public int o;
            public int p;

            public a() {
            }

            public /* synthetic */ a(a aVar) {
                this();
            }

            public static /* synthetic */ boolean a(a aVar, a aVar2) {
                boolean z;
                boolean z2;
                if (aVar.f27633a) {
                    if (!aVar2.f27633a || aVar.f27638f != aVar2.f27638f || aVar.f27639g != aVar2.f27639g || aVar.f27640h != aVar2.f27640h) {
                        return true;
                    }
                    if (aVar.f27641i && aVar2.f27641i && aVar.f27642j != aVar2.f27642j) {
                        return true;
                    }
                    int i2 = aVar.f27636d;
                    int i3 = aVar2.f27636d;
                    if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                        return true;
                    }
                    int i4 = aVar.f27635c.f27740h;
                    if (i4 == 0 && aVar2.f27635c.f27740h == 0 && (aVar.m != aVar2.m || aVar.n != aVar2.n)) {
                        return true;
                    }
                    if ((i4 == 1 && aVar2.f27635c.f27740h == 1 && (aVar.o != aVar2.o || aVar.p != aVar2.p)) || (z = aVar.k) != (z2 = aVar2.k)) {
                        return true;
                    }
                    if (z && z2 && aVar.l != aVar2.l) {
                        return true;
                    }
                }
                return false;
            }
        }

        public b(n0 n0Var, boolean z, boolean z2) {
            this.f27623a = n0Var;
            this.f27624b = z;
            this.f27625c = z2;
            byte[] bArr = new byte[128];
            this.f27629g = bArr;
            this.f27628f = new o6(bArr, 0, 0);
            a();
        }

        public void a() {
            this.k = false;
            this.o = false;
            a aVar = this.n;
            aVar.f27634b = false;
            aVar.f27633a = false;
        }
    }

    public l2(u2 u2Var, boolean z, boolean z2) {
        this.f27613a = u2Var;
        this.f27614b = z;
        this.f27615c = z2;
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(long j2, boolean z) {
        this.m = j2;
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(i0 i0Var, x2.d dVar) {
        dVar.a();
        this.f27621i = dVar.b();
        l3 l3Var = (l3) i0Var;
        n0 a2 = l3Var.a(dVar.c(), 2);
        this.f27622j = a2;
        this.k = new b(a2, this.f27614b, this.f27615c);
        this.f27613a.a(l3Var, dVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x01b9, code lost:
    
        if ((r1.f27634b && ((r1 = r1.f27637e) == 7 || r1 == 2)) != false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01ea, code lost:
    
        if (r6 != 1) goto L161;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x020a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0177  */
    @Override // com.vivo.google.android.exoplayer3.j2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.vivo.google.android.exoplayer3.n6 r31) {
        /*
            Method dump skipped, instructions count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.l2.a(com.vivo.google.android.exoplayer3.n6):void");
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.l2.a(byte[], int, int):void");
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a() {
        l6.a(this.f27620h);
        this.f27616d.a();
        this.f27617e.a();
        this.f27618f.a();
        b bVar = this.k;
        bVar.k = false;
        bVar.o = false;
        b.a aVar = bVar.n;
        aVar.f27634b = false;
        aVar.f27633a = false;
        this.f27619g = 0L;
    }
}
