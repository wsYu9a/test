package com.vivo.google.android.exoplayer3;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.vivo.google.android.exoplayer3.e0;
import com.vivo.google.android.exoplayer3.o3;
import com.vivo.google.android.exoplayer3.source.ExtractorMediaSource;
import com.vivo.google.android.exoplayer3.source.MediaSource;
import com.vivo.google.android.exoplayer3.source.TrackGroupArray;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelection;
import com.vivo.google.android.exoplayer3.upstream.DataSource;
import com.vivo.google.android.exoplayer3.util.Util;
import com.vivo.google.android.exoplayer3.v5;
import com.vivo.google.android.exoplayer3.v5.b;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class l3 implements o3, i0, v5.a<c>, e0.d {
    public boolean A;
    public long C;
    public int E;
    public boolean F;
    public boolean G;

    /* renamed from: a */
    public final Uri f27643a;

    /* renamed from: b */
    public final DataSource f27644b;

    /* renamed from: c */
    public final int f27645c;

    /* renamed from: d */
    public final Handler f27646d;

    /* renamed from: e */
    public final ExtractorMediaSource.EventListener f27647e;

    /* renamed from: f */
    public final MediaSource.Listener f27648f;

    /* renamed from: g */
    public final k5 f27649g;

    /* renamed from: h */
    public final String f27650h;

    /* renamed from: j */
    public final d f27652j;
    public o3.a p;
    public m0 q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public TrackGroupArray w;
    public long x;
    public boolean[] y;
    public boolean[] z;

    /* renamed from: i */
    public final v5 f27651i = new v5("Loader:ExtractorMediaPeriod");
    public final h6 k = new h6();
    public final Runnable l = new a();
    public final Runnable m = new b();
    public final Handler n = new Handler();
    public long D = C.TIME_UNSET;
    public final SparseArray<e0> o = new SparseArray<>();
    public long B = -1;

    public class a extends v6 {
        public a() {
        }

        @Override // com.vivo.google.android.exoplayer3.v6
        public void a() {
            l3 l3Var = l3.this;
            if (l3Var.G || l3Var.s || l3Var.q == null || !l3Var.r) {
                return;
            }
            int size = l3Var.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (l3Var.o.valueAt(i2).f27309c.b() == null) {
                    return;
                }
            }
            l3Var.k.b();
            s3[] s3VarArr = new s3[size];
            l3Var.z = new boolean[size];
            l3Var.y = new boolean[size];
            l3Var.x = l3Var.q.c();
            int i3 = 0;
            while (true) {
                boolean z = true;
                if (i3 >= size) {
                    l3Var.w = new TrackGroupArray(s3VarArr);
                    l3Var.s = true;
                    l3Var.f27648f.onSourceInfoRefreshed(new r3(l3Var.x, l3Var.q.a()), null);
                    ((com.vivo.google.android.exoplayer3.b) l3Var.p).f27176f.obtainMessage(8, l3Var).sendToTarget();
                    return;
                }
                Format b2 = l3Var.o.valueAt(i3).f27309c.b();
                s3VarArr[i3] = new s3(b2);
                String str = b2.sampleMimeType;
                if (!g1.e(str) && !g1.d(str)) {
                    z = false;
                }
                l3Var.z[i3] = z;
                l3Var.A = z | l3Var.A;
                i3++;
            }
        }
    }

    public class b extends v6 {
        public b() {
        }

        @Override // com.vivo.google.android.exoplayer3.v6
        public void a() {
            l3 l3Var = l3.this;
            if (l3Var.G) {
                return;
            }
            ((com.vivo.google.android.exoplayer3.b) l3Var.p).a((q3) l3Var);
        }
    }

    public final class c implements v5.c {

        /* renamed from: a */
        public final Uri f27655a;

        /* renamed from: b */
        public final DataSource f27656b;

        /* renamed from: c */
        public final d f27657c;

        /* renamed from: d */
        public final h6 f27658d;

        /* renamed from: f */
        public volatile boolean f27660f;

        /* renamed from: h */
        public long f27662h;

        /* renamed from: e */
        public final l0 f27659e = new l0();

        /* renamed from: g */
        public boolean f27661g = true;

        /* renamed from: i */
        public long f27663i = -1;

        public c(Uri uri, DataSource dataSource, d dVar, h6 h6Var) {
            this.f27655a = (Uri) g1.a(uri);
            this.f27656b = (DataSource) g1.a(dataSource);
            this.f27657c = (d) g1.a(dVar);
            this.f27658d = h6Var;
        }

        public void a() {
            d0 d0Var;
            int i2 = 0;
            while (i2 == 0 && !this.f27660f) {
                try {
                    long j2 = this.f27659e.f27602a;
                    long open = this.f27656b.open(new q5(this.f27655a, j2, j2, -1L, l3.this.f27650h, 0));
                    this.f27663i = open;
                    if (open != -1) {
                        this.f27663i = open + j2;
                    }
                    d0Var = new d0(this.f27656b, j2, this.f27663i);
                    try {
                        g0 a2 = this.f27657c.a(d0Var, this.f27656b.getUri());
                        if (this.f27661g) {
                            a2.a(j2, this.f27662h);
                            this.f27661g = false;
                        }
                        long j3 = j2;
                        while (i2 == 0 && !this.f27660f) {
                            this.f27658d.a();
                            i2 = a2.a(d0Var, this.f27659e);
                            long j4 = d0Var.f27268c;
                            if (j4 > 1048576 + j3) {
                                this.f27658d.b();
                                l3 l3Var = l3.this;
                                l3Var.n.post(l3Var.m);
                                j3 = j4;
                            }
                        }
                        if (i2 == 1) {
                            i2 = 0;
                        } else {
                            this.f27659e.f27602a = d0Var.f27268c;
                        }
                        Util.closeQuietly(this.f27656b);
                    } catch (Throwable th) {
                        th = th;
                        if (i2 != 1 && d0Var != null) {
                            this.f27659e.f27602a = d0Var.f27268c;
                        }
                        Util.closeQuietly(this.f27656b);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    d0Var = null;
                }
            }
        }
    }

    public static final class d {

        /* renamed from: a */
        public final g0[] f27665a;

        /* renamed from: b */
        public final i0 f27666b;

        /* renamed from: c */
        public g0 f27667c;

        public d(g0[] g0VarArr, i0 i0Var) {
            this.f27665a = g0VarArr;
            this.f27666b = i0Var;
        }

        public g0 a(h0 h0Var, Uri uri) {
            g0 g0Var = this.f27667c;
            if (g0Var != null) {
                return g0Var;
            }
            g0[] g0VarArr = this.f27665a;
            int length = g0VarArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                g0 g0Var2 = g0VarArr[i2];
                try {
                } catch (EOFException unused) {
                } catch (Throwable th) {
                    ((d0) h0Var).f27270e = 0;
                    throw th;
                }
                if (g0Var2.a(h0Var)) {
                    this.f27667c = g0Var2;
                    ((d0) h0Var).f27270e = 0;
                    break;
                }
                continue;
                ((d0) h0Var).f27270e = 0;
                i2++;
            }
            g0 g0Var3 = this.f27667c;
            if (g0Var3 != null) {
                g0Var3.a(this.f27666b);
                return this.f27667c;
            }
            throw new t3("None of the available extractors (" + Util.getCommaDelimitedSimpleClassNames(this.f27665a) + ") could read the stream.", uri);
        }
    }

    public final class e implements p3 {

        /* renamed from: a */
        public final int f27668a;

        public e(int i2) {
            this.f27668a = i2;
        }

        public boolean a() {
            l3 l3Var = l3.this;
            return l3Var.F || !(l3Var.i() || l3Var.o.valueAt(this.f27668a).f27309c.c());
        }
    }

    public l3(Uri uri, DataSource dataSource, g0[] g0VarArr, int i2, Handler handler, ExtractorMediaSource.EventListener eventListener, MediaSource.Listener listener, k5 k5Var, String str) {
        this.f27643a = uri;
        this.f27644b = dataSource;
        this.f27645c = i2;
        this.f27646d = handler;
        this.f27647e = eventListener;
        this.f27648f = listener;
        this.f27649g = k5Var;
        this.f27650h = str;
        this.f27652j = new d(g0VarArr, this);
    }

    @Override // com.vivo.google.android.exoplayer3.o3
    public long a() {
        if (this.v == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    public void a(m0 m0Var) {
        this.q = m0Var;
        this.n.post(this.l);
    }

    @Override // com.vivo.google.android.exoplayer3.o3
    public void a(o3.a aVar) {
        this.p = aVar;
        this.k.c();
        k();
    }

    public void a(v5.c cVar, long j2, long j3, boolean z) {
        c cVar2 = (c) cVar;
        if (this.B == -1) {
            this.B = cVar2.f27663i;
        }
        if (z || this.v <= 0) {
            return;
        }
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.o.valueAt(i2).a(this.y[i2]);
        }
        ((com.vivo.google.android.exoplayer3.b) this.p).a((q3) this);
    }

    @Override // com.vivo.google.android.exoplayer3.o3
    public boolean a(long j2) {
        if (this.F) {
            return false;
        }
        if (this.s && this.v == 0) {
            return false;
        }
        boolean c2 = this.k.c();
        if (this.f27651i.a()) {
            return c2;
        }
        k();
        return true;
    }

    @Override // com.vivo.google.android.exoplayer3.o3
    public long b() {
        if (!this.u) {
            return C.TIME_UNSET;
        }
        this.u = false;
        return this.C;
    }

    @Override // com.vivo.google.android.exoplayer3.o3
    public long b(long j2) {
        if (!this.q.a()) {
            j2 = 0;
        }
        this.C = j2;
        int size = this.o.size();
        boolean z = !i();
        for (int i2 = 0; z && i2 < size; i2++) {
            if (this.y[i2]) {
                e0 valueAt = this.o.valueAt(i2);
                long a2 = valueAt.f27309c.a(j2, false);
                if (a2 == -1) {
                    z = false;
                } else {
                    valueAt.a(a2);
                    z = true;
                }
            }
        }
        if (!z) {
            this.D = j2;
            this.F = false;
            if (this.f27651i.a()) {
                this.f27651i.f28155b.a(false);
            } else {
                for (int i3 = 0; i3 < size; i3++) {
                    this.o.valueAt(i3).a(this.y[i3]);
                }
            }
        }
        this.u = false;
        return j2;
    }

    @Override // com.vivo.google.android.exoplayer3.o3
    public TrackGroupArray c() {
        return this.w;
    }

    @Override // com.vivo.google.android.exoplayer3.o3
    public void c(long j2) {
    }

    @Override // com.vivo.google.android.exoplayer3.o3
    public long d() {
        long h2;
        if (this.F) {
            return Long.MIN_VALUE;
        }
        if (i()) {
            return this.D;
        }
        if (this.A) {
            h2 = Long.MAX_VALUE;
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.z[i2]) {
                    h2 = Math.min(h2, this.o.valueAt(i2).f27309c.a());
                }
            }
        } else {
            h2 = h();
        }
        return h2 == Long.MIN_VALUE ? this.C : h2;
    }

    @Override // com.vivo.google.android.exoplayer3.o3
    public void e() {
        j();
    }

    public void f() {
        this.r = true;
        this.n.post(this.l);
    }

    public final int g() {
        int size = this.o.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            e0.c cVar = this.o.valueAt(i3).f27309c;
            i2 += cVar.f27330j + cVar.f27329i;
        }
        return i2;
    }

    public final long h() {
        int size = this.o.size();
        long j2 = Long.MIN_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            j2 = Math.max(j2, this.o.valueAt(i2).f27309c.a());
        }
        return j2;
    }

    public final boolean i() {
        return this.D != C.TIME_UNSET;
    }

    public void j() {
        v5 v5Var = this.f27651i;
        IOException iOException = v5Var.f28156c;
        if (iOException != null) {
            throw iOException;
        }
        v5.b<? extends v5.c> bVar = v5Var.f28155b;
        if (bVar != null) {
            int i2 = bVar.f28159c;
            IOException iOException2 = bVar.f28161e;
            if (iOException2 != null && bVar.f28162f > i2) {
                throw iOException2;
            }
        }
    }

    public final void k() {
        m0 m0Var;
        c cVar = new c(this.f27643a, this.f27644b, this.f27652j, this.k);
        if (this.s) {
            g1.b(i());
            long j2 = this.x;
            if (j2 != C.TIME_UNSET && this.D >= j2) {
                this.F = true;
                this.D = C.TIME_UNSET;
                return;
            }
            long a2 = this.q.a(this.D);
            long j3 = this.D;
            cVar.f27659e.f27602a = a2;
            cVar.f27662h = j3;
            cVar.f27661g = true;
            this.D = C.TIME_UNSET;
        }
        this.E = g();
        int i2 = this.f27645c;
        int i3 = i2 == -1 ? (this.s && this.B == -1 && ((m0Var = this.q) == null || m0Var.c() == C.TIME_UNSET)) ? 6 : 3 : i2;
        v5 v5Var = this.f27651i;
        v5Var.getClass();
        Looper myLooper = Looper.myLooper();
        g1.b(myLooper != null);
        v5Var.new b(myLooper, cVar, this, i3, SystemClock.elapsedRealtime()).a(0L);
    }

    @Override // com.vivo.google.android.exoplayer3.o3
    public long a(TrackSelection[] trackSelectionArr, boolean[] zArr, p3[] p3VarArr, boolean[] zArr2, long j2) {
        g1.b(this.s);
        for (int i2 = 0; i2 < trackSelectionArr.length; i2++) {
            if (p3VarArr[i2] != null && (trackSelectionArr[i2] == null || !zArr[i2])) {
                int i3 = ((e) p3VarArr[i2]).f27668a;
                g1.b(this.y[i3]);
                this.v--;
                this.y[i3] = false;
                this.o.valueAt(i3).b();
                p3VarArr[i2] = null;
            }
        }
        boolean z = false;
        for (int i4 = 0; i4 < trackSelectionArr.length; i4++) {
            if (p3VarArr[i4] == null && trackSelectionArr[i4] != null) {
                TrackSelection trackSelection = trackSelectionArr[i4];
                g1.b(trackSelection.length() == 1);
                g1.b(trackSelection.getIndexInTrackGroup(0) == 0);
                int indexOf = this.w.indexOf(trackSelection.getTrackGroup());
                g1.b(!this.y[indexOf]);
                this.v++;
                this.y[indexOf] = true;
                p3VarArr[i4] = new e(indexOf);
                zArr2[i4] = true;
                z = true;
            }
        }
        if (!this.t) {
            int size = this.o.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (!this.y[i5]) {
                    this.o.valueAt(i5).b();
                }
            }
        }
        if (this.v == 0) {
            this.u = false;
            if (this.f27651i.a()) {
                this.f27651i.f28155b.a(false);
            }
        } else if (!this.t ? j2 != 0 : z) {
            j2 = b(j2);
            for (int i6 = 0; i6 < p3VarArr.length; i6++) {
                if (p3VarArr[i6] != null) {
                    zArr2[i6] = true;
                }
            }
        }
        this.t = true;
        return j2;
    }

    public n0 a(int i2, int i3) {
        e0 e0Var = this.o.get(i2);
        if (e0Var != null) {
            return e0Var;
        }
        e0 e0Var2 = new e0(this.f27649g);
        e0Var2.p = this;
        this.o.put(i2, e0Var2);
        return e0Var2;
    }
}
