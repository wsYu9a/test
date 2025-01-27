package com.opos.exoplayer.core.e;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.e.d;
import com.opos.exoplayer.core.e.f;
import com.opos.exoplayer.core.e.h;
import com.opos.exoplayer.core.h.r;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.w;
import com.vivo.google.android.exoplayer3.C;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class o implements com.opos.exoplayer.core.c.g, com.opos.exoplayer.core.e.d, h.a, r.a<a>, r.c {
    private boolean[] A;
    private boolean[] B;
    private boolean[] C;
    private boolean D;
    private long F;
    private boolean H;
    private int I;
    private boolean J;
    private boolean K;

    /* renamed from: a */
    private final Uri f18521a;

    /* renamed from: b */
    private final com.opos.exoplayer.core.h.g f18522b;

    /* renamed from: c */
    private final int f18523c;

    /* renamed from: d */
    private final f.a f18524d;

    /* renamed from: e */
    private final c f18525e;

    /* renamed from: f */
    private final com.opos.exoplayer.core.h.b f18526f;

    /* renamed from: g */
    @Nullable
    private final String f18527g;

    /* renamed from: h */
    private final long f18528h;

    /* renamed from: j */
    private final b f18530j;
    private d.a o;
    private com.opos.exoplayer.core.c.l p;
    private boolean s;
    private boolean t;
    private int u;
    private boolean v;
    private boolean w;
    private int x;
    private m y;

    /* renamed from: i */
    private final r f18529i = new r("Loader:ExtractorMediaPeriod");
    private final com.opos.exoplayer.core.i.e k = new com.opos.exoplayer.core.i.e();
    private final Runnable l = new Runnable() { // from class: com.opos.exoplayer.core.e.o.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.j();
        }
    };
    private final Runnable m = new Runnable() { // from class: com.opos.exoplayer.core.e.o.2
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (o.this.K) {
                return;
            }
            o.this.o.a((d.a) o.this);
        }
    };
    private final Handler n = new Handler();
    private int[] r = new int[0];
    private h[] q = new h[0];
    private long G = C.TIME_UNSET;
    private long E = -1;
    private long z = C.TIME_UNSET;

    /* renamed from: com.opos.exoplayer.core.e.o$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.j();
        }
    }

    /* renamed from: com.opos.exoplayer.core.e.o$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (o.this.K) {
                return;
            }
            o.this.o.a((d.a) o.this);
        }
    }

    final class a implements r.b {

        /* renamed from: b */
        private final Uri f18534b;

        /* renamed from: c */
        private final com.opos.exoplayer.core.h.g f18535c;

        /* renamed from: d */
        private final b f18536d;

        /* renamed from: e */
        private final com.opos.exoplayer.core.i.e f18537e;

        /* renamed from: g */
        private volatile boolean f18539g;

        /* renamed from: i */
        private long f18541i;

        /* renamed from: j */
        private com.opos.exoplayer.core.h.i f18542j;
        private long l;

        /* renamed from: f */
        private final com.opos.exoplayer.core.c.k f18538f = new com.opos.exoplayer.core.c.k();

        /* renamed from: h */
        private boolean f18540h = true;
        private long k = -1;

        public a(Uri uri, com.opos.exoplayer.core.h.g gVar, b bVar, com.opos.exoplayer.core.i.e eVar) {
            this.f18534b = (Uri) com.opos.exoplayer.core.i.a.a(uri);
            this.f18535c = (com.opos.exoplayer.core.h.g) com.opos.exoplayer.core.i.a.a(gVar);
            this.f18536d = (b) com.opos.exoplayer.core.i.a.a(bVar);
            this.f18537e = eVar;
        }

        @Override // com.opos.exoplayer.core.h.r.b
        public void a() {
            this.f18539g = true;
        }

        public void a(long j2, long j3) {
            this.f18538f.f18323a = j2;
            this.f18541i = j3;
            this.f18540h = true;
        }

        @Override // com.opos.exoplayer.core.h.r.b
        public boolean b() {
            return this.f18539g;
        }

        @Override // com.opos.exoplayer.core.h.r.b
        public void c() {
            com.opos.exoplayer.core.c.b bVar;
            long j2;
            int i2 = 0;
            while (i2 == 0 && !this.f18539g) {
                try {
                    j2 = this.f18538f.f18323a;
                    com.opos.exoplayer.core.h.i iVar = new com.opos.exoplayer.core.h.i(this.f18534b, j2, -1L, o.this.f18527g);
                    this.f18542j = iVar;
                    long a2 = this.f18535c.a(iVar);
                    this.k = a2;
                    if (a2 != -1) {
                        this.k = a2 + j2;
                    }
                    bVar = new com.opos.exoplayer.core.c.b(this.f18535c, j2, this.k);
                } catch (Throwable th) {
                    th = th;
                    bVar = null;
                }
                try {
                    com.opos.exoplayer.core.c.e a3 = this.f18536d.a(bVar, this.f18535c.a());
                    if (this.f18540h) {
                        a3.a(j2, this.f18541i);
                        this.f18540h = false;
                    }
                    while (i2 == 0 && !this.f18539g) {
                        this.f18537e.c();
                        i2 = a3.a(bVar, this.f18538f);
                        if (bVar.c() > o.this.f18528h + j2) {
                            j2 = bVar.c();
                            this.f18537e.b();
                            o.this.n.post(o.this.m);
                        }
                    }
                    if (i2 == 1) {
                        i2 = 0;
                    } else {
                        this.f18538f.f18323a = bVar.c();
                        this.l = this.f18538f.f18323a - this.f18542j.f18920c;
                    }
                    u.a(this.f18535c);
                } catch (Throwable th2) {
                    th = th2;
                    if (i2 != 1 && bVar != null) {
                        this.f18538f.f18323a = bVar.c();
                        this.l = this.f18538f.f18323a - this.f18542j.f18920c;
                    }
                    u.a(this.f18535c);
                    throw th;
                }
            }
        }
    }

    private static final class b {

        /* renamed from: a */
        private final com.opos.exoplayer.core.c.e[] f18543a;

        /* renamed from: b */
        private final com.opos.exoplayer.core.c.g f18544b;

        /* renamed from: c */
        private com.opos.exoplayer.core.c.e f18545c;

        public b(com.opos.exoplayer.core.c.e[] eVarArr, com.opos.exoplayer.core.c.g gVar) {
            this.f18543a = eVarArr;
            this.f18544b = gVar;
        }

        public com.opos.exoplayer.core.c.e a(com.opos.exoplayer.core.c.f fVar, Uri uri) {
            com.opos.exoplayer.core.c.e eVar = this.f18545c;
            if (eVar != null) {
                return eVar;
            }
            com.opos.exoplayer.core.c.e[] eVarArr = this.f18543a;
            int length = eVarArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                com.opos.exoplayer.core.c.e eVar2 = eVarArr[i2];
                try {
                } catch (EOFException unused) {
                } catch (Throwable th) {
                    fVar.a();
                    throw th;
                }
                if (eVar2.a(fVar)) {
                    this.f18545c = eVar2;
                    fVar.a();
                    break;
                }
                continue;
                fVar.a();
                i2++;
            }
            com.opos.exoplayer.core.c.e eVar3 = this.f18545c;
            if (eVar3 != null) {
                eVar3.a(this.f18544b);
                return this.f18545c;
            }
            throw new n("None of the available extractors (" + u.a(this.f18543a) + ") could read the stream.", uri);
        }

        public void a() {
            com.opos.exoplayer.core.c.e eVar = this.f18545c;
            if (eVar != null) {
                eVar.c();
                this.f18545c = null;
            }
        }
    }

    interface c {
        void a(long j2, boolean z);
    }

    private final class d implements i {

        /* renamed from: b */
        private final int f18547b;

        public d(int i2) {
            this.f18547b = i2;
        }

        @Override // com.opos.exoplayer.core.e.i
        public int a(long j2) {
            return o.this.a(this.f18547b, j2);
        }

        @Override // com.opos.exoplayer.core.e.i
        public int a(com.opos.exoplayer.core.l lVar, com.opos.exoplayer.core.b.e eVar, boolean z) {
            return o.this.a(this.f18547b, lVar, eVar, z);
        }

        @Override // com.opos.exoplayer.core.e.i
        public boolean b() {
            return o.this.a(this.f18547b);
        }

        @Override // com.opos.exoplayer.core.e.i
        public void c() {
            o.this.h();
        }
    }

    public o(Uri uri, com.opos.exoplayer.core.h.g gVar, com.opos.exoplayer.core.c.e[] eVarArr, int i2, f.a aVar, c cVar, com.opos.exoplayer.core.h.b bVar, @Nullable String str, int i3) {
        this.f18521a = uri;
        this.f18522b = gVar;
        this.f18523c = i2;
        this.f18524d = aVar;
        this.f18525e = cVar;
        this.f18526f = bVar;
        this.f18527g = str;
        this.f18528h = i3;
        this.f18530j = new b(eVarArr, this);
        this.u = i2 == -1 ? 3 : i2;
    }

    private void a(a aVar) {
        if (this.E == -1) {
            this.E = aVar.k;
        }
    }

    private boolean a(a aVar, int i2) {
        com.opos.exoplayer.core.c.l lVar;
        if (this.E == -1 && ((lVar = this.p) == null || lVar.b() == C.TIME_UNSET)) {
            if (this.t && !i()) {
                this.H = true;
                return false;
            }
            this.w = this.t;
            this.F = 0L;
            this.I = 0;
            for (h hVar : this.q) {
                hVar.a();
            }
            aVar.a(0L, 0L);
        } else {
            this.I = i2;
        }
        return true;
    }

    private static boolean a(IOException iOException) {
        return iOException instanceof n;
    }

    private void b(int i2) {
        if (this.C[i2]) {
            return;
        }
        Format a2 = this.y.a(i2).a(0);
        this.f18524d.a(com.opos.exoplayer.core.i.j.e(a2.f17496f), a2, 0, null, this.F);
        this.C[i2] = true;
    }

    private void c(int i2) {
        if (this.H && this.B[i2] && !this.q[i2].c()) {
            this.G = 0L;
            this.H = false;
            this.w = true;
            this.F = 0L;
            this.I = 0;
            for (h hVar : this.q) {
                hVar.a();
            }
            this.o.a((d.a) this);
        }
    }

    private boolean d(long j2) {
        int length = this.q.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                return true;
            }
            h hVar = this.q[i2];
            hVar.g();
            if (!(hVar.b(j2, true, false) != -1) && (this.B[i2] || !this.D)) {
                return false;
            }
            i2++;
        }
    }

    private boolean i() {
        return this.w || n();
    }

    public void j() {
        if (this.K || this.t || this.p == null || !this.s) {
            return;
        }
        for (h hVar : this.q) {
            if (hVar.e() == null) {
                return;
            }
        }
        this.k.b();
        int length = this.q.length;
        l[] lVarArr = new l[length];
        this.B = new boolean[length];
        this.A = new boolean[length];
        this.C = new boolean[length];
        this.z = this.p.b();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= length) {
                break;
            }
            Format e2 = this.q[i2].e();
            lVarArr[i2] = new l(e2);
            String str = e2.f17496f;
            if (!com.opos.exoplayer.core.i.j.b(str) && !com.opos.exoplayer.core.i.j.a(str)) {
                z = false;
            }
            this.B[i2] = z;
            this.D = z | this.D;
            i2++;
        }
        this.y = new m(lVarArr);
        if (this.f18523c == -1 && this.E == -1 && this.p.b() == C.TIME_UNSET) {
            this.u = 6;
        }
        this.t = true;
        this.f18525e.a(this.z, this.p.a());
        this.o.a((com.opos.exoplayer.core.e.d) this);
    }

    private void k() {
        a aVar = new a(this.f18521a, this.f18522b, this.f18530j, this.k);
        if (this.t) {
            com.opos.exoplayer.core.i.a.b(n());
            long j2 = this.z;
            if (j2 != C.TIME_UNSET && this.G >= j2) {
                this.J = true;
                this.G = C.TIME_UNSET;
                return;
            } else {
                aVar.a(this.p.b(this.G).f18324a.f18330c, this.G);
                this.G = C.TIME_UNSET;
            }
        }
        this.I = l();
        this.f18524d.a(aVar.f18542j, 1, -1, null, 0, null, aVar.f18541i, this.z, this.f18529i.a(aVar, this, this.u));
    }

    private int l() {
        h[] hVarArr = this.q;
        int length = hVarArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int b2 = hVarArr[i2].b();
            i2++;
            i3 += b2;
        }
        return i3;
    }

    private long m() {
        long j2 = Long.MIN_VALUE;
        for (h hVar : this.q) {
            j2 = Math.max(j2, hVar.f());
        }
        return j2;
    }

    private boolean n() {
        return this.G != C.TIME_UNSET;
    }

    int a(int i2, long j2) {
        int i3 = 0;
        if (!i()) {
            h hVar = this.q[i2];
            if (!this.J || j2 <= hVar.f()) {
                int b2 = hVar.b(j2, true, true);
                if (b2 != -1) {
                    i3 = b2;
                }
            } else {
                i3 = hVar.i();
            }
            if (i3 > 0) {
                b(i2);
            } else {
                c(i2);
            }
        }
        return i3;
    }

    int a(int i2, com.opos.exoplayer.core.l lVar, com.opos.exoplayer.core.b.e eVar, boolean z) {
        if (i()) {
            return -3;
        }
        int a2 = this.q[i2].a(lVar, eVar, z, this.J, this.F);
        if (a2 == -4) {
            b(i2);
        } else if (a2 == -3) {
            c(i2);
        }
        return a2;
    }

    @Override // com.opos.exoplayer.core.h.r.a
    public int a(a aVar, long j2, long j3, IOException iOException) {
        a aVar2;
        boolean z;
        boolean a2 = a(iOException);
        this.f18524d.a(aVar.f18542j, 1, -1, null, 0, null, aVar.f18541i, this.z, j2, j3, aVar.l, iOException, a2);
        a(aVar);
        if (a2) {
            return 3;
        }
        int l = l();
        if (l > this.I) {
            aVar2 = aVar;
            z = true;
        } else {
            aVar2 = aVar;
            z = false;
        }
        if (a(aVar2, l)) {
            return z ? 1 : 0;
        }
        return 2;
    }

    @Override // com.opos.exoplayer.core.e.d
    public long a(long j2, w wVar) {
        if (!this.p.a()) {
            return 0L;
        }
        l.a b2 = this.p.b(j2);
        return u.a(j2, wVar, b2.f18324a.f18329b, b2.f18325b.f18329b);
    }

    @Override // com.opos.exoplayer.core.e.d
    public long a(com.opos.exoplayer.core.g.f[] fVarArr, boolean[] zArr, i[] iVarArr, boolean[] zArr2, long j2) {
        com.opos.exoplayer.core.i.a.b(this.t);
        int i2 = this.x;
        int i3 = 0;
        for (int i4 = 0; i4 < fVarArr.length; i4++) {
            if (iVarArr[i4] != null && (fVarArr[i4] == null || !zArr[i4])) {
                int i5 = ((d) iVarArr[i4]).f18547b;
                com.opos.exoplayer.core.i.a.b(this.A[i5]);
                this.x--;
                this.A[i5] = false;
                iVarArr[i4] = null;
            }
        }
        boolean z = !this.v ? j2 == 0 : i2 != 0;
        for (int i6 = 0; i6 < fVarArr.length; i6++) {
            if (iVarArr[i6] == null && fVarArr[i6] != null) {
                com.opos.exoplayer.core.g.f fVar = fVarArr[i6];
                com.opos.exoplayer.core.i.a.b(fVar.e() == 1);
                com.opos.exoplayer.core.i.a.b(fVar.b(0) == 0);
                int a2 = this.y.a(fVar.d());
                com.opos.exoplayer.core.i.a.b(!this.A[a2]);
                this.x++;
                this.A[a2] = true;
                iVarArr[i6] = new d(a2);
                zArr2[i6] = true;
                if (!z) {
                    h hVar = this.q[a2];
                    hVar.g();
                    z = hVar.b(j2, true, true) == -1 && hVar.d() != 0;
                }
            }
        }
        if (this.x == 0) {
            this.H = false;
            this.w = false;
            if (this.f18529i.a()) {
                h[] hVarArr = this.q;
                int length = hVarArr.length;
                while (i3 < length) {
                    hVarArr[i3].h();
                    i3++;
                }
                this.f18529i.b();
            } else {
                h[] hVarArr2 = this.q;
                int length2 = hVarArr2.length;
                while (i3 < length2) {
                    hVarArr2[i3].a();
                    i3++;
                }
            }
        } else if (z) {
            j2 = b(j2);
            while (i3 < iVarArr.length) {
                if (iVarArr[i3] != null) {
                    zArr2[i3] = true;
                }
                i3++;
            }
        }
        this.v = true;
        return j2;
    }

    @Override // com.opos.exoplayer.core.c.g
    public com.opos.exoplayer.core.c.n a(int i2, int i3) {
        int length = this.q.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.r[i4] == i2) {
                return this.q[i4];
            }
        }
        h hVar = new h(this.f18526f);
        hVar.a(this);
        int i5 = length + 1;
        int[] copyOf = Arrays.copyOf(this.r, i5);
        this.r = copyOf;
        copyOf[length] = i2;
        h[] hVarArr = (h[]) Arrays.copyOf(this.q, i5);
        this.q = hVarArr;
        hVarArr[length] = hVar;
        return hVar;
    }

    @Override // com.opos.exoplayer.core.c.g
    public void a() {
        this.s = true;
        this.n.post(this.l);
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(long j2) {
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(long j2, boolean z) {
        int length = this.q.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.q[i2].a(j2, z, this.A[i2]);
        }
    }

    @Override // com.opos.exoplayer.core.e.h.a
    public void a(Format format) {
        this.n.post(this.l);
    }

    @Override // com.opos.exoplayer.core.c.g
    public void a(com.opos.exoplayer.core.c.l lVar) {
        this.p = lVar;
        this.n.post(this.l);
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(d.a aVar, long j2) {
        this.o = aVar;
        this.k.a();
        k();
    }

    @Override // com.opos.exoplayer.core.h.r.a
    public void a(a aVar, long j2, long j3) {
        if (this.z == C.TIME_UNSET) {
            long m = m();
            long j4 = m == Long.MIN_VALUE ? 0L : m + 10000;
            this.z = j4;
            this.f18525e.a(j4, this.p.a());
        }
        this.f18524d.a(aVar.f18542j, 1, -1, null, 0, null, aVar.f18541i, this.z, j2, j3, aVar.l);
        a(aVar);
        this.J = true;
        this.o.a((d.a) this);
    }

    @Override // com.opos.exoplayer.core.h.r.a
    public void a(a aVar, long j2, long j3, boolean z) {
        this.f18524d.b(aVar.f18542j, 1, -1, null, 0, null, aVar.f18541i, this.z, j2, j3, aVar.l);
        if (z) {
            return;
        }
        a(aVar);
        for (h hVar : this.q) {
            hVar.a();
        }
        if (this.x > 0) {
            this.o.a((d.a) this);
        }
    }

    boolean a(int i2) {
        return !i() && (this.J || this.q[i2].c());
    }

    @Override // com.opos.exoplayer.core.e.d
    public long b(long j2) {
        if (!this.p.a()) {
            j2 = 0;
        }
        this.F = j2;
        this.w = false;
        if (n() || !d(j2)) {
            this.H = false;
            this.G = j2;
            this.J = false;
            if (this.f18529i.a()) {
                this.f18529i.b();
            } else {
                for (h hVar : this.q) {
                    hVar.a();
                }
            }
        }
        return j2;
    }

    @Override // com.opos.exoplayer.core.e.d
    public m b() {
        return this.y;
    }

    @Override // com.opos.exoplayer.core.e.d
    public long c() {
        if (!this.w || (!this.J && l() <= this.I)) {
            return C.TIME_UNSET;
        }
        this.w = false;
        return this.F;
    }

    @Override // com.opos.exoplayer.core.e.d
    public boolean c(long j2) {
        if (this.J || this.H || (this.t && this.x == 0)) {
            return false;
        }
        boolean a2 = this.k.a();
        if (this.f18529i.a()) {
            return a2;
        }
        k();
        return true;
    }

    @Override // com.opos.exoplayer.core.e.d
    public void c_() {
        h();
    }

    @Override // com.opos.exoplayer.core.e.d
    public long d() {
        long m;
        if (this.J) {
            return Long.MIN_VALUE;
        }
        if (n()) {
            return this.G;
        }
        if (this.D) {
            m = Long.MAX_VALUE;
            int length = this.q.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (this.B[i2]) {
                    m = Math.min(m, this.q[i2].f());
                }
            }
        } else {
            m = m();
        }
        return m == Long.MIN_VALUE ? this.F : m;
    }

    @Override // com.opos.exoplayer.core.e.d
    public long e() {
        if (this.x == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    public void f() {
        if (this.t) {
            for (h hVar : this.q) {
                hVar.h();
            }
        }
        this.f18529i.a(this);
        this.n.removeCallbacksAndMessages(null);
        this.K = true;
    }

    @Override // com.opos.exoplayer.core.h.r.c
    public void g() {
        for (h hVar : this.q) {
            hVar.a();
        }
        this.f18530j.a();
    }

    void h() {
        this.f18529i.a(this.u);
    }
}
