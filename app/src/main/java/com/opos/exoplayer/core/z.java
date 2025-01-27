package com.opos.exoplayer.core;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.opos.exoplayer.core.e.e;
import com.opos.exoplayer.core.q;
import com.opos.exoplayer.core.r;
import com.opos.exoplayer.core.y;
import com.vivo.google.android.exoplayer3.C;
import com.vivo.google.android.exoplayer3.ExoPlayerImpl;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes4.dex */
final class z implements i {

    /* renamed from: a */
    private final s[] f19314a;

    /* renamed from: b */
    private final com.opos.exoplayer.core.g.h f19315b;

    /* renamed from: c */
    private final com.opos.exoplayer.core.g.i f19316c;

    /* renamed from: d */
    private final Handler f19317d;

    /* renamed from: e */
    private final aa f19318e;

    /* renamed from: f */
    private final Handler f19319f;

    /* renamed from: g */
    private final CopyOnWriteArraySet<q.b> f19320g;

    /* renamed from: h */
    private final y.b f19321h;

    /* renamed from: i */
    private final y.a f19322i;

    /* renamed from: j */
    private boolean f19323j;
    private int k;
    private boolean l;
    private int m;
    private boolean n;
    private boolean o;
    private p p;
    private ae q;
    private int r;
    private int s;
    private long t;

    /* renamed from: com.opos.exoplayer.core.z$1 */
    class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            z.this.a(message);
        }
    }

    @SuppressLint({"HandlerLeak"})
    public z(s[] sVarArr, com.opos.exoplayer.core.g.h hVar, n nVar, com.opos.exoplayer.core.i.b bVar) {
        com.opos.cmn.an.f.a.a(ExoPlayerImpl.TAG, "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.7.3] [" + com.opos.exoplayer.core.i.u.f19082e + "]");
        com.opos.exoplayer.core.i.a.b(sVarArr.length > 0);
        this.f19314a = (s[]) com.opos.exoplayer.core.i.a.a(sVarArr);
        this.f19315b = (com.opos.exoplayer.core.g.h) com.opos.exoplayer.core.i.a.a(hVar);
        this.f19323j = false;
        this.k = 0;
        this.l = false;
        this.f19320g = new CopyOnWriteArraySet<>();
        com.opos.exoplayer.core.g.i iVar = new com.opos.exoplayer.core.g.i(com.opos.exoplayer.core.e.m.f18516a, new boolean[sVarArr.length], new com.opos.exoplayer.core.g.g(new com.opos.exoplayer.core.g.f[sVarArr.length]), null, new u[sVarArr.length]);
        this.f19316c = iVar;
        this.f19321h = new y.b();
        this.f19322i = new y.a();
        this.p = p.f19184a;
        AnonymousClass1 anonymousClass1 = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) { // from class: com.opos.exoplayer.core.z.1
            AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                z.this.a(message);
            }
        };
        this.f19317d = anonymousClass1;
        this.q = new ae(y.f19297a, 0L, iVar);
        aa aaVar = new aa(sVarArr, hVar, iVar, nVar, this.f19323j, this.k, this.l, anonymousClass1, this, bVar);
        this.f19318e = aaVar;
        this.f19319f = new Handler(aaVar.b());
    }

    private ae a(boolean z, boolean z2, int i2) {
        long m;
        if (z) {
            this.r = 0;
            this.s = 0;
            m = 0;
        } else {
            this.r = i();
            this.s = q();
            m = m();
        }
        this.t = m;
        y yVar = z2 ? y.f19297a : this.q.f17700a;
        Object obj = z2 ? null : this.q.f17701b;
        ae aeVar = this.q;
        return new ae(yVar, obj, aeVar.f17702c, aeVar.f17703d, aeVar.f17704e, i2, false, z2 ? this.f19316c : aeVar.f17707h);
    }

    private void a(ae aeVar, int i2, boolean z, int i3) {
        int i4 = this.m - i2;
        this.m = i4;
        if (i4 == 0) {
            if (aeVar.f17703d == C.TIME_UNSET) {
                aeVar = aeVar.a(aeVar.f17702c, 0L, aeVar.f17704e);
            }
            ae aeVar2 = aeVar;
            if ((!this.q.f17700a.a() || this.n) && aeVar2.f17700a.a()) {
                this.s = 0;
                this.r = 0;
                this.t = 0L;
            }
            int i5 = this.n ? 0 : 2;
            boolean z2 = this.o;
            this.n = false;
            this.o = false;
            a(aeVar2, z, i3, i5, z2);
        }
    }

    private void a(ae aeVar, boolean z, int i2, int i3, boolean z2) {
        ae aeVar2 = this.q;
        boolean z3 = (aeVar2.f17700a == aeVar.f17700a && aeVar2.f17701b == aeVar.f17701b) ? false : true;
        boolean z4 = aeVar2.f17705f != aeVar.f17705f;
        boolean z5 = aeVar2.f17706g != aeVar.f17706g;
        boolean z6 = aeVar2.f17707h != aeVar.f17707h;
        this.q = aeVar;
        if (z3 || i3 == 0) {
            Iterator<q.b> it = this.f19320g.iterator();
            while (it.hasNext()) {
                q.b next = it.next();
                ae aeVar3 = this.q;
                next.a(aeVar3.f17700a, aeVar3.f17701b, i3);
            }
        }
        if (z) {
            Iterator<q.b> it2 = this.f19320g.iterator();
            while (it2.hasNext()) {
                it2.next().b(i2);
            }
        }
        if (z6) {
            this.f19315b.a(this.q.f17707h.f18895d);
            Iterator<q.b> it3 = this.f19320g.iterator();
            while (it3.hasNext()) {
                q.b next2 = it3.next();
                com.opos.exoplayer.core.g.i iVar = this.q.f17707h;
                next2.a(iVar.f18892a, iVar.f18894c);
            }
        }
        if (z5) {
            Iterator<q.b> it4 = this.f19320g.iterator();
            while (it4.hasNext()) {
                it4.next().a(this.q.f17706g);
            }
        }
        if (z4) {
            Iterator<q.b> it5 = this.f19320g.iterator();
            while (it5.hasNext()) {
                it5.next().a(this.f19323j, this.q.f17705f);
            }
        }
        if (z2) {
            Iterator<q.b> it6 = this.f19320g.iterator();
            while (it6.hasNext()) {
                it6.next().e_();
            }
        }
    }

    private long b(long j2) {
        long a2 = b.a(j2);
        if (this.q.f17702c.a()) {
            return a2;
        }
        ae aeVar = this.q;
        aeVar.f17700a.a(aeVar.f17702c.f18423a, this.f19322i);
        return a2 + this.f19322i.b();
    }

    private boolean r() {
        return this.q.f17700a.a() || this.m > 0;
    }

    @Override // com.opos.exoplayer.core.q
    public q.d a() {
        return null;
    }

    @Override // com.opos.exoplayer.core.i
    public r a(r.b bVar) {
        return new r(this.f19318e, bVar, this.q.f17700a, i(), this.f19319f);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(int i2) {
        if (this.k != i2) {
            this.k = i2;
            this.f19318e.a(i2);
            Iterator<q.b> it = this.f19320g.iterator();
            while (it.hasNext()) {
                it.next().a(i2);
            }
        }
    }

    @Override // com.opos.exoplayer.core.q
    public void a(int i2, long j2) {
        y yVar = this.q.f17700a;
        if (i2 < 0 || (!yVar.a() && i2 >= yVar.b())) {
            throw new m(yVar, i2, j2);
        }
        this.o = true;
        this.m++;
        if (o()) {
            com.opos.cmn.an.f.a.c(ExoPlayerImpl.TAG, "seekTo ignored because an ad is playing");
            this.f19317d.obtainMessage(0, 1, -1, this.q).sendToTarget();
            return;
        }
        this.r = i2;
        if (yVar.a()) {
            this.t = j2 == C.TIME_UNSET ? 0L : j2;
            this.s = 0;
        } else {
            long a2 = j2 == C.TIME_UNSET ? yVar.a(i2, this.f19321h).a() : b.b(j2);
            Pair<Integer, Long> a3 = yVar.a(this.f19321h, this.f19322i, i2, a2);
            this.t = b.a(a2);
            this.s = ((Integer) a3.first).intValue();
        }
        this.f19318e.a(yVar, i2, b.b(j2));
        Iterator<q.b> it = this.f19320g.iterator();
        while (it.hasNext()) {
            it.next().b(1);
        }
    }

    @Override // com.opos.exoplayer.core.q
    public void a(long j2) {
        a(i(), j2);
    }

    void a(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            ae aeVar = (ae) message.obj;
            int i3 = message.arg1;
            int i4 = message.arg2;
            a(aeVar, i3, i4 != -1, i4);
            return;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException();
            }
            h hVar = (h) message.obj;
            Iterator<q.b> it = this.f19320g.iterator();
            while (it.hasNext()) {
                it.next().a(hVar);
            }
            return;
        }
        p pVar = (p) message.obj;
        if (this.p.equals(pVar)) {
            return;
        }
        this.p = pVar;
        Iterator<q.b> it2 = this.f19320g.iterator();
        while (it2.hasNext()) {
            it2.next().a(pVar);
        }
    }

    @Override // com.opos.exoplayer.core.i
    public void a(com.opos.exoplayer.core.e.e eVar) {
        a(eVar, true, true);
    }

    public void a(com.opos.exoplayer.core.e.e eVar, boolean z, boolean z2) {
        ae a2 = a(z, z2, 2);
        this.n = true;
        this.m++;
        this.f19318e.a(eVar, z, z2);
        a(a2, false, 4, 1, false);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(q.b bVar) {
        this.f19320g.add(bVar);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(boolean z) {
        if (this.f19323j != z) {
            this.f19323j = z;
            this.f19318e.a(z);
            Iterator<q.b> it = this.f19320g.iterator();
            while (it.hasNext()) {
                it.next().a(z, this.q.f17705f);
            }
        }
    }

    @Override // com.opos.exoplayer.core.q
    public int b(int i2) {
        return this.f19314a[i2].a();
    }

    @Override // com.opos.exoplayer.core.q
    public q.c b() {
        return null;
    }

    @Override // com.opos.exoplayer.core.q
    public void b(q.b bVar) {
        this.f19320g.remove(bVar);
    }

    @Override // com.opos.exoplayer.core.q
    public int c() {
        return this.q.f17705f;
    }

    @Override // com.opos.exoplayer.core.q
    public boolean d() {
        return this.f19323j;
    }

    @Override // com.opos.exoplayer.core.q
    public p e() {
        return this.p;
    }

    @Override // com.opos.exoplayer.core.q
    public void f() {
        com.opos.cmn.an.f.a.a(ExoPlayerImpl.TAG, "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.7.3] [" + com.opos.exoplayer.core.i.u.f19082e + "] [" + k.a() + "]");
        this.f19318e.a();
        this.f19317d.removeCallbacksAndMessages(null);
    }

    @Override // com.opos.exoplayer.core.q
    public com.opos.exoplayer.core.g.g g() {
        return this.q.f17707h.f18894c;
    }

    @Override // com.opos.exoplayer.core.q
    public y h() {
        return this.q.f17700a;
    }

    @Override // com.opos.exoplayer.core.q
    public int i() {
        if (r()) {
            return this.r;
        }
        ae aeVar = this.q;
        return aeVar.f17700a.a(aeVar.f17702c.f18423a, this.f19322i).f19300c;
    }

    @Override // com.opos.exoplayer.core.q
    public int j() {
        y yVar = this.q.f17700a;
        if (yVar.a()) {
            return -1;
        }
        return yVar.a(i(), this.k, this.l);
    }

    @Override // com.opos.exoplayer.core.q
    public int k() {
        y yVar = this.q.f17700a;
        if (yVar.a()) {
            return -1;
        }
        return yVar.b(i(), this.k, this.l);
    }

    @Override // com.opos.exoplayer.core.q
    public long l() {
        y yVar = this.q.f17700a;
        if (yVar.a()) {
            return C.TIME_UNSET;
        }
        if (!o()) {
            return yVar.a(i(), this.f19321h).b();
        }
        e.b bVar = this.q.f17702c;
        yVar.a(bVar.f18423a, this.f19322i);
        return b.a(this.f19322i.c(bVar.f18424b, bVar.f18425c));
    }

    @Override // com.opos.exoplayer.core.q
    public long m() {
        return r() ? this.t : b(this.q.f17708i);
    }

    @Override // com.opos.exoplayer.core.q
    public long n() {
        return r() ? this.t : b(this.q.f17709j);
    }

    @Override // com.opos.exoplayer.core.q
    public boolean o() {
        return !r() && this.q.f17702c.a();
    }

    @Override // com.opos.exoplayer.core.q
    public long p() {
        if (!o()) {
            return m();
        }
        ae aeVar = this.q;
        aeVar.f17700a.a(aeVar.f17702c.f18423a, this.f19322i);
        return this.f19322i.b() + b.a(this.q.f17704e);
    }

    public int q() {
        return r() ? this.s : this.q.f17702c.f18423a;
    }
}
