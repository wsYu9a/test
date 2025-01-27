package com.opos.exoplayer.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.e.d;
import com.opos.exoplayer.core.e.e;
import com.opos.exoplayer.core.f;
import com.opos.exoplayer.core.g.h;
import com.opos.exoplayer.core.r;
import com.opos.exoplayer.core.y;
import com.vivo.google.android.exoplayer3.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class aa implements Handler.Callback, d.a, e.a, f.a, h.a, r.a {
    private int A;
    private boolean B;
    private int C;
    private d D;
    private long E;
    private int F;

    /* renamed from: a */
    private final s[] f17647a;

    /* renamed from: b */
    private final t[] f17648b;

    /* renamed from: c */
    private final com.opos.exoplayer.core.g.h f17649c;

    /* renamed from: d */
    private final com.opos.exoplayer.core.g.i f17650d;

    /* renamed from: e */
    private final n f17651e;

    /* renamed from: f */
    private final com.opos.exoplayer.core.i.g f17652f;

    /* renamed from: g */
    private final HandlerThread f17653g;

    /* renamed from: h */
    private final Handler f17654h;

    /* renamed from: i */
    private final i f17655i;

    /* renamed from: j */
    private final y.b f17656j;
    private final y.a k;
    private final long l;
    private final boolean m;
    private final f n;
    private final ArrayList<b> p;
    private final com.opos.exoplayer.core.i.b q;
    private ae t;
    private com.opos.exoplayer.core.e.e u;
    private s[] v;
    private boolean w;
    private boolean y;
    private boolean z;
    private volatile boolean x = false;
    private final ad r = new ad();
    private w s = w.f19283e;
    private final c o = new c();

    /* renamed from: com.opos.exoplayer.core.aa$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ r f17657a;

        AnonymousClass1(r rVar) {
            rVar = rVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                aa.this.e(rVar);
            } catch (h e2) {
                com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
                throw new RuntimeException(e2);
            }
        }
    }

    private static final class a {

        /* renamed from: a */
        public final com.opos.exoplayer.core.e.e f17659a;

        /* renamed from: b */
        public final y f17660b;

        /* renamed from: c */
        public final Object f17661c;

        public a(com.opos.exoplayer.core.e.e eVar, y yVar, Object obj) {
            this.f17659a = eVar;
            this.f17660b = yVar;
            this.f17661c = obj;
        }
    }

    private static final class b implements Comparable<b> {

        /* renamed from: a */
        public final r f17662a;

        /* renamed from: b */
        public int f17663b;

        /* renamed from: c */
        public long f17664c;

        /* renamed from: d */
        @Nullable
        public Object f17665d;

        public b(r rVar) {
            this.f17662a = rVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NonNull b bVar) {
            Object obj = this.f17665d;
            if ((obj == null) != (bVar.f17665d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i2 = this.f17663b - bVar.f17663b;
            return i2 == 0 ? com.opos.exoplayer.core.i.u.a(this.f17664c, bVar.f17664c) : i2;
        }

        public void a(int i2, long j2, Object obj) {
            this.f17663b = i2;
            this.f17664c = j2;
            this.f17665d = obj;
        }
    }

    private static final class c {

        /* renamed from: a */
        private ae f17666a;

        /* renamed from: b */
        private int f17667b;

        /* renamed from: c */
        private boolean f17668c;

        /* renamed from: d */
        private int f17669d;

        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(int i2) {
            this.f17667b += i2;
        }

        public boolean a(ae aeVar) {
            return aeVar != this.f17666a || this.f17667b > 0 || this.f17668c;
        }

        public void b(int i2) {
            if (this.f17668c && this.f17669d != 4) {
                com.opos.exoplayer.core.i.a.a(i2 == 4);
            } else {
                this.f17668c = true;
                this.f17669d = i2;
            }
        }

        public void b(ae aeVar) {
            this.f17666a = aeVar;
            this.f17667b = 0;
            this.f17668c = false;
        }
    }

    private static final class d {

        /* renamed from: a */
        public final y f17670a;

        /* renamed from: b */
        public final int f17671b;

        /* renamed from: c */
        public final long f17672c;

        public d(y yVar, int i2, long j2) {
            this.f17670a = yVar;
            this.f17671b = i2;
            this.f17672c = j2;
        }
    }

    public aa(s[] sVarArr, com.opos.exoplayer.core.g.h hVar, com.opos.exoplayer.core.g.i iVar, n nVar, boolean z, int i2, boolean z2, Handler handler, i iVar2, com.opos.exoplayer.core.i.b bVar) {
        this.f17647a = sVarArr;
        this.f17649c = hVar;
        this.f17650d = iVar;
        this.f17651e = nVar;
        this.y = z;
        this.A = i2;
        this.B = z2;
        this.f17654h = handler;
        this.f17655i = iVar2;
        this.q = bVar;
        this.l = nVar.e();
        this.m = nVar.f();
        this.t = new ae(y.f19297a, C.TIME_UNSET, iVar);
        this.f17648b = new t[sVarArr.length];
        for (int i3 = 0; i3 < sVarArr.length; i3++) {
            sVarArr[i3].a(i3);
            this.f17648b[i3] = sVarArr[i3].b();
        }
        this.n = new f(this, bVar);
        this.p = new ArrayList<>();
        this.v = new s[0];
        this.f17656j = new y.b();
        this.k = new y.a();
        hVar.a((h.a) this);
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f17653g = handlerThread;
        handlerThread.start();
        this.f17652f = bVar.a(handlerThread.getLooper(), this);
    }

    private int a(int i2, y yVar, y yVar2) {
        int c2 = yVar.c();
        int i3 = i2;
        int i4 = -1;
        for (int i5 = 0; i5 < c2 && i4 == -1; i5++) {
            i3 = yVar.a(i3, this.k, this.f17656j, this.A, this.B);
            if (i3 == -1) {
                break;
            }
            i4 = yVar2.a(yVar.a(i3, this.k, true).f19299b);
        }
        return i4;
    }

    private long a(e.b bVar, long j2) {
        return a(bVar, j2, this.r.c() != this.r.d());
    }

    private long a(e.b bVar, long j2, boolean z) {
        e();
        this.z = false;
        b(2);
        ab c2 = this.r.c();
        ab abVar = c2;
        while (true) {
            if (abVar == null) {
                break;
            }
            if (a(bVar, j2, abVar)) {
                this.r.a(abVar);
                break;
            }
            abVar = this.r.h();
        }
        if (c2 != abVar || z) {
            for (s sVar : this.v) {
                b(sVar);
            }
            this.v = new s[0];
            c2 = null;
        }
        if (abVar != null) {
            a(c2);
            if (abVar.f17679g) {
                long b2 = abVar.f17673a.b(j2);
                abVar.f17673a.a(b2 - this.l, this.m);
                j2 = b2;
            }
            a(j2);
            q();
        } else {
            this.r.i();
            a(j2);
        }
        this.f17652f.a(2);
        return j2;
    }

    private Pair<Integer, Long> a(d dVar, boolean z) {
        int a2;
        y yVar = this.t.f17700a;
        y yVar2 = dVar.f17670a;
        if (yVar.a()) {
            return null;
        }
        if (yVar2.a()) {
            yVar2 = yVar;
        }
        try {
            Pair<Integer, Long> a3 = yVar2.a(this.f17656j, this.k, dVar.f17671b, dVar.f17672c);
            if (yVar == yVar2) {
                return a3;
            }
            int a4 = yVar.a(yVar2.a(((Integer) a3.first).intValue(), this.k, true).f19299b);
            if (a4 != -1) {
                return Pair.create(Integer.valueOf(a4), a3.second);
            }
            if (!z || (a2 = a(((Integer) a3.first).intValue(), yVar2, yVar)) == -1) {
                return null;
            }
            return b(yVar, yVar.a(a2, this.k).f19300c, C.TIME_UNSET);
        } catch (IndexOutOfBoundsException unused) {
            throw new m(yVar, dVar.f17671b, dVar.f17672c);
        }
    }

    private void a(float f2) {
        for (ab e2 = this.r.e(); e2 != null; e2 = e2.f17681i) {
            com.opos.exoplayer.core.g.i iVar = e2.f17682j;
            if (iVar != null) {
                for (com.opos.exoplayer.core.g.f fVar : iVar.f18894c.a()) {
                    if (fVar != null) {
                        fVar.a(f2);
                    }
                }
            }
        }
    }

    private void a(int i2, boolean z, int i3) {
        ab c2 = this.r.c();
        s sVar = this.f17647a[i2];
        this.v[i3] = sVar;
        if (sVar.a_() == 0) {
            com.opos.exoplayer.core.g.i iVar = c2.f17682j;
            u uVar = iVar.f18896e[i2];
            Format[] a2 = a(iVar.f18894c.a(i2));
            boolean z2 = this.y && this.t.f17705f == 3;
            sVar.a(uVar, a2, c2.f17675c[i2], this.E, !z && z2, c2.a());
            this.n.a(sVar);
            if (z2) {
                sVar.b_();
            }
        }
    }

    private void a(long j2) {
        long a2 = !this.r.f() ? j2 + 60000000 : this.r.c().a(j2);
        this.E = a2;
        this.n.a(a2);
        for (s sVar : this.v) {
            sVar.a(this.E);
        }
    }

    private void a(long j2, long j3) {
        this.f17652f.b(2);
        this.f17652f.a(2, j2 + j3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0066, code lost:
    
        if (r11.a() != false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0068, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006a, code lost:
    
        r12 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a5, code lost:
    
        if (r11.a() != false) goto L96;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.opos.exoplayer.core.aa.a r20) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.aa.a(com.opos.exoplayer.core.aa$a):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006a A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:7:0x005d, B:9:0x0061, B:14:0x006a, B:22:0x0072, B:24:0x007c, B:28:0x0088, B:29:0x0092, B:31:0x00a2, B:35:0x00b4, B:38:0x00be, B:42:0x00c2), top: B:6:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072 A[Catch: all -> 0x00d6, TryCatch #0 {all -> 0x00d6, blocks: (B:7:0x005d, B:9:0x0061, B:14:0x006a, B:22:0x0072, B:24:0x007c, B:28:0x0088, B:29:0x0092, B:31:0x00a2, B:35:0x00b4, B:38:0x00be, B:42:0x00c2), top: B:6:0x005d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.opos.exoplayer.core.aa.d r21) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.aa.a(com.opos.exoplayer.core.aa$d):void");
    }

    private void a(@Nullable ab abVar) {
        ab c2 = this.r.c();
        if (c2 == null || abVar == c2) {
            return;
        }
        boolean[] zArr = new boolean[this.f17647a.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            s[] sVarArr = this.f17647a;
            if (i2 >= sVarArr.length) {
                this.t = this.t.a(c2.f17682j);
                a(zArr, i3);
                return;
            }
            s sVar = sVarArr[i2];
            zArr[i2] = sVar.a_() != 0;
            boolean[] zArr2 = c2.f17682j.f18893b;
            if (zArr2[i2]) {
                i3++;
            }
            if (zArr[i2] && (!zArr2[i2] || (sVar.i() && sVar.f() == abVar.f17675c[i2]))) {
                b(sVar);
            }
            i2++;
        }
    }

    private void a(com.opos.exoplayer.core.g.i iVar) {
        this.f17651e.a(this.f17647a, iVar.f18892a, iVar.f18894c);
    }

    private void a(s sVar) {
        if (sVar.a_() == 2) {
            sVar.k();
        }
    }

    private void a(w wVar) {
        this.s = wVar;
    }

    private void a(boolean z, boolean z2) {
        a(true, z, z);
        this.o.a((z2 ? 1 : 0) + this.C);
        this.C = 0;
        this.f17651e.b();
        b(1);
    }

    private void a(boolean z, boolean z2, boolean z3) {
        com.opos.exoplayer.core.e.e eVar;
        this.f17652f.b(2);
        this.z = false;
        this.n.b();
        this.E = 60000000L;
        for (s sVar : this.v) {
            try {
                b(sVar);
            } catch (h | RuntimeException e2) {
                com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Stop failed.", e2);
            }
        }
        this.v = new s[0];
        this.r.i();
        b(false);
        if (z2) {
            this.D = null;
        }
        if (z3) {
            this.r.a(y.f19297a);
            Iterator<b> it = this.p.iterator();
            while (it.hasNext()) {
                it.next().f17662a.a(false);
            }
            this.p.clear();
            this.F = 0;
        }
        y yVar = z3 ? y.f19297a : this.t.f17700a;
        Object obj = z3 ? null : this.t.f17701b;
        e.b bVar = z2 ? new e.b(i()) : this.t.f17702c;
        long j2 = C.TIME_UNSET;
        long j3 = z2 ? -9223372036854775807L : this.t.f17708i;
        if (!z2) {
            j2 = this.t.f17704e;
        }
        long j4 = j2;
        ae aeVar = this.t;
        this.t = new ae(yVar, obj, bVar, j3, j4, aeVar.f17705f, false, z3 ? this.f17650d : aeVar.f17707h);
        if (!z || (eVar = this.u) == null) {
            return;
        }
        eVar.b();
        this.u = null;
    }

    private void a(boolean[] zArr, int i2) {
        this.v = new s[i2];
        ab c2 = this.r.c();
        int i3 = 0;
        for (int i4 = 0; i4 < this.f17647a.length; i4++) {
            if (c2.f17682j.f18893b[i4]) {
                a(i4, zArr[i4], i3);
                i3++;
            }
        }
    }

    private boolean a(b bVar) {
        Object obj = bVar.f17665d;
        if (obj == null) {
            Pair<Integer, Long> a2 = a(new d(bVar.f17662a.a(), bVar.f17662a.g(), com.opos.exoplayer.core.b.b(bVar.f17662a.f())), false);
            if (a2 != null) {
                bVar.a(((Integer) a2.first).intValue(), ((Long) a2.second).longValue(), this.t.f17700a.a(((Integer) a2.first).intValue(), this.k, true).f19299b);
                return true;
            }
        } else {
            int a3 = this.t.f17700a.a(obj);
            if (a3 != -1) {
                bVar.f17663b = a3;
                return true;
            }
        }
        return false;
    }

    private boolean a(e.b bVar, long j2, ab abVar) {
        if (bVar.equals(abVar.f17680h.f17683a) && abVar.f17678f) {
            this.t.f17700a.a(abVar.f17680h.f17683a.f18423a, this.k);
            int b2 = this.k.b(j2);
            if (b2 == -1 || this.k.a(b2) == abVar.f17680h.f17685c) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    private static Format[] a(com.opos.exoplayer.core.g.f fVar) {
        int e2 = fVar != null ? fVar.e() : 0;
        Format[] formatArr = new Format[e2];
        for (int i2 = 0; i2 < e2; i2++) {
            formatArr[i2] = fVar.a(i2);
        }
        return formatArr;
    }

    private Pair<Integer, Long> b(y yVar, int i2, long j2) {
        return yVar.a(this.f17656j, this.k, i2, j2);
    }

    private void b(int i2) {
        ae aeVar = this.t;
        if (aeVar.f17705f != i2) {
            this.t = aeVar.b(i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        if (r6.F < r6.p.size()) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        r1 = r6.p.get(r6.F);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        if (r1 == null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        if (r1.f17665d == null) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0069, code lost:
    
        r3 = r1.f17663b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        if (r3 < r0) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        if (r3 != r0) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
    
        if (r1.f17664c > r7) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0084, code lost:
    
        if (r1 == null) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0088, code lost:
    
        if (r1.f17665d == null) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008c, code lost:
    
        if (r1.f17663b != r0) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008e, code lost:
    
        r3 = r1.f17664c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0092, code lost:
    
        if (r3 <= r7) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0096, code lost:
    
        if (r3 > r9) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0098, code lost:
    
        c(r1.f17662a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a3, code lost:
    
        if (r1.f17662a.h() == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a5, code lost:
    
        r6.p.remove(r6.F);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bb, code lost:
    
        if (r6.F >= r6.p.size()) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c8, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00bd, code lost:
    
        r1 = r6.p.get(r6.F);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ad, code lost:
    
        r6.F++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0075, code lost:
    
        r1 = r6.F + 1;
        r6.F = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0081, code lost:
    
        if (r1 >= r6.p.size()) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0062, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0063, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0034, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004a -> B:11:0x002a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0081 -> B:23:0x0057). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(long r7, long r9) {
        /*
            r6 = this;
            java.util.ArrayList<com.opos.exoplayer.core.aa$b> r0 = r6.p
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lca
            com.opos.exoplayer.core.ae r0 = r6.t
            com.opos.exoplayer.core.e.e$b r0 = r0.f17702c
            boolean r0 = r0.a()
            if (r0 == 0) goto L14
            goto Lca
        L14:
            com.opos.exoplayer.core.ae r0 = r6.t
            long r1 = r0.f17703d
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 != 0) goto L1f
            r1 = 1
            long r7 = r7 - r1
        L1f:
            com.opos.exoplayer.core.e.e$b r0 = r0.f17702c
            int r0 = r0.f18423a
            int r1 = r6.F
            r2 = 0
            if (r1 <= 0) goto L33
            java.util.ArrayList<com.opos.exoplayer.core.aa$b> r3 = r6.p
        L2a:
            int r1 = r1 + (-1)
            java.lang.Object r1 = r3.get(r1)
            com.opos.exoplayer.core.aa$b r1 = (com.opos.exoplayer.core.aa.b) r1
            goto L34
        L33:
            r1 = r2
        L34:
            if (r1 == 0) goto L4d
            int r3 = r1.f17663b
            if (r3 > r0) goto L42
            if (r3 != r0) goto L4d
            long r3 = r1.f17664c
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 <= 0) goto L4d
        L42:
            int r1 = r6.F
            int r1 = r1 + (-1)
            r6.F = r1
            if (r1 <= 0) goto L33
            java.util.ArrayList<com.opos.exoplayer.core.aa$b> r3 = r6.p
            goto L2a
        L4d:
            int r1 = r6.F
            java.util.ArrayList<com.opos.exoplayer.core.aa$b> r3 = r6.p
            int r3 = r3.size()
            if (r1 >= r3) goto L62
        L57:
            java.util.ArrayList<com.opos.exoplayer.core.aa$b> r1 = r6.p
            int r3 = r6.F
            java.lang.Object r1 = r1.get(r3)
            com.opos.exoplayer.core.aa$b r1 = (com.opos.exoplayer.core.aa.b) r1
            goto L63
        L62:
            r1 = r2
        L63:
            if (r1 == 0) goto L84
            java.lang.Object r3 = r1.f17665d
            if (r3 == 0) goto L84
            int r3 = r1.f17663b
            if (r3 < r0) goto L75
            if (r3 != r0) goto L84
            long r3 = r1.f17664c
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 > 0) goto L84
        L75:
            int r1 = r6.F
            int r1 = r1 + 1
            r6.F = r1
            java.util.ArrayList<com.opos.exoplayer.core.aa$b> r3 = r6.p
            int r3 = r3.size()
            if (r1 >= r3) goto L62
            goto L57
        L84:
            if (r1 == 0) goto Lca
            java.lang.Object r3 = r1.f17665d
            if (r3 == 0) goto Lca
            int r3 = r1.f17663b
            if (r3 != r0) goto Lca
            long r3 = r1.f17664c
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 <= 0) goto Lca
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 > 0) goto Lca
            com.opos.exoplayer.core.r r3 = r1.f17662a
            r6.c(r3)
            com.opos.exoplayer.core.r r1 = r1.f17662a
            boolean r1 = r1.h()
            if (r1 == 0) goto Lad
            java.util.ArrayList<com.opos.exoplayer.core.aa$b> r1 = r6.p
            int r3 = r6.F
            r1.remove(r3)
            goto Lb3
        Lad:
            int r1 = r6.F
            int r1 = r1 + 1
            r6.F = r1
        Lb3:
            int r1 = r6.F
            java.util.ArrayList<com.opos.exoplayer.core.aa$b> r3 = r6.p
            int r3 = r3.size()
            if (r1 >= r3) goto Lc8
            java.util.ArrayList<com.opos.exoplayer.core.aa$b> r1 = r6.p
            int r3 = r6.F
            java.lang.Object r1 = r1.get(r3)
            com.opos.exoplayer.core.aa$b r1 = (com.opos.exoplayer.core.aa.b) r1
            goto L84
        Lc8:
            r1 = r2
            goto L84
        Lca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.aa.b(long, long):void");
    }

    private void b(com.opos.exoplayer.core.e.e eVar, boolean z, boolean z2) {
        this.C++;
        a(true, z, z2);
        this.f17651e.a();
        this.u = eVar;
        b(2);
        eVar.a(this.f17655i, true, this);
        this.f17652f.a(2);
    }

    private void b(p pVar) {
        this.n.a(pVar);
    }

    private void b(r rVar) {
        if (rVar.f() == C.TIME_UNSET) {
            c(rVar);
            return;
        }
        if (this.u == null || this.C > 0) {
            this.p.add(new b(rVar));
            return;
        }
        b bVar = new b(rVar);
        if (!a(bVar)) {
            rVar.a(false);
        } else {
            this.p.add(bVar);
            Collections.sort(this.p);
        }
    }

    private void b(s sVar) {
        this.n.b(sVar);
        a(sVar);
        sVar.l();
    }

    private void b(boolean z) {
        ae aeVar = this.t;
        if (aeVar.f17706g != z) {
            this.t = aeVar.a(z);
        }
    }

    private void c() {
        if (this.o.a(this.t)) {
            this.f17654h.obtainMessage(0, this.o.f17667b, this.o.f17668c ? this.o.f17669d : -1, this.t).sendToTarget();
            this.o.b(this.t);
        }
    }

    private void c(int i2) {
        this.A = i2;
        if (this.r.a(i2)) {
            return;
        }
        e(true);
    }

    private void c(com.opos.exoplayer.core.e.d dVar) {
        if (this.r.a(dVar)) {
            a(this.r.a(this.n.e().f19185b));
            if (!this.r.f()) {
                a(this.r.h().f17680h.f17684b);
                a((ab) null);
            }
            q();
        }
    }

    private void c(r rVar) {
        if (rVar.e().getLooper() != this.f17652f.a()) {
            this.f17652f.a(15, rVar).sendToTarget();
            return;
        }
        e(rVar);
        int i2 = this.t.f17705f;
        if (i2 == 3 || i2 == 2) {
            this.f17652f.a(2);
        }
    }

    private void c(boolean z) {
        this.z = false;
        this.y = z;
        if (!z) {
            e();
            f();
            return;
        }
        int i2 = this.t.f17705f;
        if (i2 == 3) {
            d();
        } else if (i2 != 2) {
            return;
        }
        this.f17652f.a(2);
    }

    private boolean c(s sVar) {
        ab abVar = this.r.d().f17681i;
        return abVar != null && abVar.f17678f && sVar.g();
    }

    private void d() {
        this.z = false;
        this.n.a();
        for (s sVar : this.v) {
            sVar.b_();
        }
    }

    private void d(com.opos.exoplayer.core.e.d dVar) {
        if (this.r.a(dVar)) {
            this.r.a(this.E);
            q();
        }
    }

    private void d(r rVar) {
        rVar.e().post(new Runnable() { // from class: com.opos.exoplayer.core.aa.1

            /* renamed from: a */
            final /* synthetic */ r f17657a;

            AnonymousClass1(r rVar2) {
                rVar = rVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    aa.this.e(rVar);
                } catch (h e2) {
                    com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
                    throw new RuntimeException(e2);
                }
            }
        });
    }

    private void d(boolean z) {
        this.B = z;
        if (this.r.a(z)) {
            return;
        }
        e(true);
    }

    private void e() {
        this.n.b();
        for (s sVar : this.v) {
            a(sVar);
        }
    }

    public void e(r rVar) {
        try {
            rVar.b().a(rVar.c(), rVar.d());
        } finally {
            rVar.a(true);
        }
    }

    private void e(boolean z) {
        e.b bVar = this.r.c().f17680h.f17683a;
        long a2 = a(bVar, this.t.f17708i, true);
        if (a2 != this.t.f17708i) {
            ae aeVar = this.t;
            this.t = aeVar.a(bVar, a2, aeVar.f17704e);
            if (z) {
                this.o.b(4);
            }
        }
    }

    private void f() {
        if (this.r.f()) {
            ab c2 = this.r.c();
            long c3 = c2.f17673a.c();
            if (c3 != C.TIME_UNSET) {
                a(c3);
                if (c3 != this.t.f17708i) {
                    ae aeVar = this.t;
                    this.t = aeVar.a(aeVar.f17702c, c3, aeVar.f17704e);
                    this.o.b(4);
                }
            } else {
                long c4 = this.n.c();
                this.E = c4;
                long b2 = c2.b(c4);
                b(this.t.f17708i, b2);
                this.t.f17708i = b2;
            }
            this.t.f17709j = this.v.length == 0 ? c2.f17680h.f17687e : c2.a(true);
        }
    }

    private boolean f(boolean z) {
        if (this.v.length == 0) {
            return l();
        }
        if (z) {
            if (!this.t.f17706g) {
                return true;
            }
            ab b2 = this.r.b();
            long a2 = b2.a(!b2.f17680h.f17689g);
            if (a2 == Long.MIN_VALUE || this.f17651e.a(a2 - b2.b(this.E), this.n.e().f19185b, this.z)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g() {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.aa.g():void");
    }

    private void h() {
        a(true, true, true);
        this.f17651e.c();
        b(1);
        this.f17653g.quit();
        synchronized (this) {
            this.w = true;
            notifyAll();
        }
    }

    private int i() {
        y yVar = this.t.f17700a;
        if (yVar.a()) {
            return 0;
        }
        return yVar.a(yVar.b(this.B), this.f17656j).f19309f;
    }

    private void j() {
        for (int size = this.p.size() - 1; size >= 0; size--) {
            if (!a(this.p.get(size))) {
                this.p.get(size).f17662a.a(false);
                this.p.remove(size);
            }
        }
        Collections.sort(this.p);
    }

    private void k() {
        if (this.r.f()) {
            float f2 = this.n.e().f19185b;
            ab d2 = this.r.d();
            boolean z = true;
            for (ab c2 = this.r.c(); c2 != null && c2.f17678f; c2 = c2.f17681i) {
                if (c2.b(f2)) {
                    if (z) {
                        ab c3 = this.r.c();
                        boolean a2 = this.r.a(c3);
                        boolean[] zArr = new boolean[this.f17647a.length];
                        long a3 = c3.a(this.t.f17708i, a2, zArr);
                        a(c3.f17682j);
                        ae aeVar = this.t;
                        if (aeVar.f17705f != 4 && a3 != aeVar.f17708i) {
                            ae aeVar2 = this.t;
                            this.t = aeVar2.a(aeVar2.f17702c, a3, aeVar2.f17704e);
                            this.o.b(4);
                            a(a3);
                        }
                        boolean[] zArr2 = new boolean[this.f17647a.length];
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            s[] sVarArr = this.f17647a;
                            if (i2 >= sVarArr.length) {
                                break;
                            }
                            s sVar = sVarArr[i2];
                            zArr2[i2] = sVar.a_() != 0;
                            com.opos.exoplayer.core.e.i iVar = c3.f17675c[i2];
                            if (iVar != null) {
                                i3++;
                            }
                            if (zArr2[i2]) {
                                if (iVar != sVar.f()) {
                                    b(sVar);
                                } else if (zArr[i2]) {
                                    sVar.a(this.E);
                                }
                            }
                            i2++;
                        }
                        this.t = this.t.a(c3.f17682j);
                        a(zArr2, i3);
                    } else {
                        this.r.a(c2);
                        if (c2.f17678f) {
                            c2.a(Math.max(c2.f17680h.f17684b, c2.b(this.E)), false);
                            a(c2.f17682j);
                        }
                    }
                    if (this.t.f17705f != 4) {
                        q();
                        f();
                        this.f17652f.a(2);
                        return;
                    }
                    return;
                }
                if (c2 == d2) {
                    z = false;
                }
            }
        }
    }

    private boolean l() {
        ab abVar;
        ab c2 = this.r.c();
        long j2 = c2.f17680h.f17687e;
        return j2 == C.TIME_UNSET || this.t.f17708i < j2 || ((abVar = c2.f17681i) != null && (abVar.f17678f || abVar.f17680h.f17683a.a()));
    }

    private void m() {
        ab b2 = this.r.b();
        ab d2 = this.r.d();
        if (b2 == null || b2.f17678f) {
            return;
        }
        if (d2 == null || d2.f17681i == b2) {
            for (s sVar : this.v) {
                if (!sVar.g()) {
                    return;
                }
            }
            b2.f17673a.c_();
        }
    }

    private void n() {
        b(4);
        a(false, true, false);
    }

    private void o() {
        com.opos.exoplayer.core.e.e eVar = this.u;
        if (eVar == null) {
            return;
        }
        if (this.C > 0) {
            eVar.a();
            return;
        }
        p();
        ab b2 = this.r.b();
        int i2 = 0;
        if (b2 == null || b2.b()) {
            b(false);
        } else if (!this.t.f17706g) {
            q();
        }
        if (!this.r.f()) {
            return;
        }
        ab c2 = this.r.c();
        ab d2 = this.r.d();
        boolean z = false;
        while (this.y && c2 != d2 && this.E >= c2.f17681i.f17677e) {
            if (z) {
                c();
            }
            int i3 = c2.f17680h.f17688f ? 0 : 3;
            ab h2 = this.r.h();
            a(c2);
            ae aeVar = this.t;
            ac acVar = h2.f17680h;
            this.t = aeVar.a(acVar.f17683a, acVar.f17684b, acVar.f17686d);
            this.o.b(i3);
            f();
            c2 = h2;
            z = true;
        }
        if (d2.f17680h.f17689g) {
            while (true) {
                s[] sVarArr = this.f17647a;
                if (i2 >= sVarArr.length) {
                    return;
                }
                s sVar = sVarArr[i2];
                com.opos.exoplayer.core.e.i iVar = d2.f17675c[i2];
                if (iVar != null && sVar.f() == iVar && sVar.g()) {
                    sVar.h();
                }
                i2++;
            }
        } else {
            ab abVar = d2.f17681i;
            if (abVar == null || !abVar.f17678f) {
                return;
            }
            int i4 = 0;
            while (true) {
                s[] sVarArr2 = this.f17647a;
                if (i4 < sVarArr2.length) {
                    s sVar2 = sVarArr2[i4];
                    com.opos.exoplayer.core.e.i iVar2 = d2.f17675c[i4];
                    if (sVar2.f() != iVar2) {
                        return;
                    }
                    if (iVar2 != null && !sVar2.g()) {
                        return;
                    } else {
                        i4++;
                    }
                } else {
                    com.opos.exoplayer.core.g.i iVar3 = d2.f17682j;
                    ab g2 = this.r.g();
                    com.opos.exoplayer.core.g.i iVar4 = g2.f17682j;
                    boolean z2 = g2.f17673a.c() != C.TIME_UNSET;
                    int i5 = 0;
                    while (true) {
                        s[] sVarArr3 = this.f17647a;
                        if (i5 >= sVarArr3.length) {
                            return;
                        }
                        s sVar3 = sVarArr3[i5];
                        if (iVar3.f18893b[i5]) {
                            if (!z2) {
                                if (!sVar3.i()) {
                                    com.opos.exoplayer.core.g.f a2 = iVar4.f18894c.a(i5);
                                    boolean z3 = iVar4.f18893b[i5];
                                    boolean z4 = this.f17648b[i5].a() == 5;
                                    u uVar = iVar3.f18896e[i5];
                                    u uVar2 = iVar4.f18896e[i5];
                                    if (z3 && uVar2.equals(uVar) && !z4) {
                                        sVar3.a(a(a2), g2.f17675c[i5], g2.a());
                                    }
                                }
                            }
                            sVar3.h();
                        }
                        i5++;
                    }
                }
            }
        }
    }

    private void p() {
        this.r.a(this.E);
        if (this.r.a()) {
            ac a2 = this.r.a(this.E, this.t);
            if (a2 == null) {
                this.u.a();
                return;
            }
            this.r.a(this.f17648b, 60000000L, this.f17649c, this.f17651e.d(), this.u, this.t.f17700a.a(a2.f17683a.f18423a, this.k, true).f19299b, a2).a(this, a2.f17684b);
            b(true);
        }
    }

    private void q() {
        ab b2 = this.r.b();
        long c2 = b2.c();
        if (c2 == Long.MIN_VALUE) {
            b(false);
            return;
        }
        boolean a2 = this.f17651e.a(c2 - b2.b(this.E), this.n.e().f19185b);
        b(a2);
        if (a2) {
            b2.d(this.E);
        }
    }

    public void a() {
        synchronized (this) {
            this.x = true;
            if (!this.w) {
                this.f17652f.a(7);
                boolean z = false;
                while (!this.w) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void a(int i2) {
        this.f17652f.a(12, i2, 0).sendToTarget();
    }

    @Override // com.opos.exoplayer.core.e.d.a
    public void a(com.opos.exoplayer.core.e.d dVar) {
        this.f17652f.a(9, dVar).sendToTarget();
    }

    @Override // com.opos.exoplayer.core.e.e.a
    public void a(com.opos.exoplayer.core.e.e eVar, y yVar, Object obj) {
        this.f17652f.a(8, new a(eVar, yVar, obj)).sendToTarget();
    }

    public void a(com.opos.exoplayer.core.e.e eVar, boolean z, boolean z2) {
        this.f17652f.a(0, z ? 1 : 0, z2 ? 1 : 0, eVar).sendToTarget();
    }

    @Override // com.opos.exoplayer.core.f.a
    public void a(p pVar) {
        this.f17654h.obtainMessage(1, pVar).sendToTarget();
        a(pVar.f19185b);
    }

    @Override // com.opos.exoplayer.core.r.a
    public void a(r rVar) {
        synchronized (this) {
            if (!this.x && !this.w) {
                this.f17652f.a(14, rVar).sendToTarget();
            }
            com.opos.cmn.an.f.a.c("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            rVar.a(false);
        }
    }

    public void a(y yVar, int i2, long j2) {
        this.f17652f.a(3, new d(yVar, i2, j2)).sendToTarget();
    }

    public void a(boolean z) {
        this.f17652f.a(1, z ? 1 : 0, 0).sendToTarget();
    }

    public Looper b() {
        return this.f17653g.getLooper();
    }

    @Override // com.opos.exoplayer.core.e.j.a
    /* renamed from: b */
    public void a(com.opos.exoplayer.core.e.d dVar) {
        this.f17652f.a(10, dVar).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        h e2;
        try {
            switch (message.what) {
                case 0:
                    b((com.opos.exoplayer.core.e.e) message.obj, message.arg1 != 0, message.arg2 != 0);
                    break;
                case 1:
                    c(message.arg1 != 0);
                    break;
                case 2:
                    g();
                    break;
                case 3:
                    a((d) message.obj);
                    break;
                case 4:
                    b((p) message.obj);
                    break;
                case 5:
                    a((w) message.obj);
                    break;
                case 6:
                    a(message.arg1 != 0, true);
                    break;
                case 7:
                    h();
                    return true;
                case 8:
                    a((a) message.obj);
                    break;
                case 9:
                    c((com.opos.exoplayer.core.e.d) message.obj);
                    break;
                case 10:
                    d((com.opos.exoplayer.core.e.d) message.obj);
                    break;
                case 11:
                    k();
                    break;
                case 12:
                    c(message.arg1);
                    break;
                case 13:
                    d(message.arg1 != 0);
                    break;
                case 14:
                    b((r) message.obj);
                    break;
                case 15:
                    d((r) message.obj);
                    break;
                default:
                    return false;
            }
            c();
            return true;
        } catch (h e3) {
            e2 = e3;
            com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Playback error.", e2);
            a(false, false);
            handler = this.f17654h;
            handler.obtainMessage(2, e2).sendToTarget();
            c();
            return true;
        } catch (IOException e4) {
            com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Source error.", e4);
            a(false, false);
            handler = this.f17654h;
            e2 = h.a(e4);
            handler.obtainMessage(2, e2).sendToTarget();
            c();
            return true;
        } catch (RuntimeException e5) {
            com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Internal runtime error.", e5);
            a(false, false);
            handler = this.f17654h;
            e2 = h.a(e5);
            handler.obtainMessage(2, e2).sendToTarget();
            c();
            return true;
        }
    }
}
