package com.aggmoread.sdk.z.d.a.a.d.a.d;

import android.app.Activity;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class i extends com.aggmoread.sdk.z.d.a.a.d.b.a implements com.aggmoread.sdk.z.d.a.a.c.r.a {

    /* renamed from: m */
    protected AtomicBoolean f5362m;

    /* renamed from: n */
    protected Map<String, Object> f5363n;

    /* renamed from: o */
    protected Object[] f5364o;

    /* renamed from: p */
    protected boolean f5365p;

    /* renamed from: q */
    private com.aggmoread.sdk.z.d.a.a.c.r.d f5366q;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.v();
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ Activity f5368b;

        public b(Activity activity) {
            this.f5368b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.b(this.f5368b);
        }
    }

    public class c implements Runnable {

        /* renamed from: b */
        final /* synthetic */ ArrayList f5370b;

        public c(ArrayList arrayList) {
            this.f5370b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.aggmoread.sdk.z.d.a.a.c.r.b) i.this.f5842g.f5861g).onAdLoaded(this.f5370b);
        }
    }

    public i(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5362m = new AtomicBoolean();
        this.f5363n = new HashMap();
        this.f5364o = com.aggmoread.sdk.z.d.a.a.b.b();
        this.f5365p = false;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public void a(int i10) {
        if (com.aggmoread.sdk.z.d.a.a.e.m.h(this.f5843h)) {
            c(i10);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.r.a
    public void b() {
        if (com.aggmoread.sdk.z.d.a.a.e.m.a()) {
            v();
        } else {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new a());
        }
    }

    public void c(com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(8).a(iVar).b();
        com.aggmoread.sdk.z.d.a.a.c.r.d dVar = this.f5366q;
        if (dVar != null) {
            dVar.a(iVar);
        }
    }

    public void d(int i10) {
        this.f5365p = true;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(3).a(k.b.B, Integer.valueOf(i10)).a(k.b.f6049q, com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5842g, this.f5843h, this.f5841f)).b();
        if (this.f5842g.f5861g instanceof com.aggmoread.sdk.z.d.a.a.c.r.b) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new c(arrayList));
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.r.a
    public void destroy() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public String getID() {
        return this.f5842g.f5857c;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public Map<String, Object> h() {
        return com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5841f);
    }

    public void q() {
        com.aggmoread.sdk.z.d.a.a.c.r.d dVar;
        com.aggmoread.sdk.z.d.a.a.d.b.k kVar = new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h);
        boolean a10 = kVar.a(this.f5843h, null, 0L, this.f5364o);
        kVar.b();
        if (a10 && (dVar = this.f5366q) != null) {
            dVar.onAdClicked();
        }
        com.aggmoread.sdk.z.d.a.a.d.b.l.a((Object) this.f5364o, false, true);
    }

    public void r() {
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(4).b();
        com.aggmoread.sdk.z.d.a.a.c.r.d dVar = this.f5366q;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void s() {
        com.aggmoread.sdk.z.d.a.a.e.e.a("exposure");
        com.aggmoread.sdk.z.d.a.a.e.c.f6081f = null;
        a((com.aggmoread.sdk.z.d.a.a.c.e) this.f5366q);
    }

    public void t() {
        com.aggmoread.sdk.z.d.a.a.c.r.d dVar = this.f5366q;
        if (dVar != null) {
            dVar.onAdShow();
        }
    }

    public void u() {
        if (this.f5365p) {
            com.aggmoread.sdk.z.d.a.a.c.f fVar = this.f5842g.f5861g;
            if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.r.b) {
                ((com.aggmoread.sdk.z.d.a.a.c.r.b) fVar).onAdVideoCached();
            }
        }
    }

    public abstract void v();

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public void a(int i10, int i11, String str) {
        if (com.aggmoread.sdk.z.d.a.a.e.m.h(this.f5843h)) {
            b(i10, i11, str);
        }
    }

    public void b(Activity activity) {
        v();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.r.a
    public void a(Activity activity) {
        if (com.aggmoread.sdk.z.d.a.a.e.m.a()) {
            b(activity);
        } else {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new b(activity));
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
        this.f5846k.a();
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(8).a(iVar).b();
        if (this.f5365p) {
            c(iVar);
        } else {
            if (this.f5843h.l()) {
                return;
            }
            this.f5842g.f5861g.a(iVar);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.r.a
    public void a(com.aggmoread.sdk.z.d.a.a.c.r.d dVar) {
        this.f5366q = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
    
        if (1001007000 == ((java.lang.Integer) r0).intValue()) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.util.Map<java.lang.String, java.lang.Object> r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L18
            java.lang.String r0 = "reward.ERROR_CODE"
            java.lang.Object r0 = r4.get(r0)
            boolean r1 = r0 instanceof java.lang.Integer
            if (r1 == 0) goto L18
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r1 = 1001007000(0x3baa2798, float:0.005192708)
            if (r1 != r0) goto L18
            goto L29
        L18:
            com.aggmoread.sdk.z.d.a.a.d.b.k r0 = new com.aggmoread.sdk.z.d.a.a.d.b.k
            com.aggmoread.sdk.z.d.a.a.d.b.d r1 = r3.f5842g
            com.aggmoread.sdk.z.d.a.a.d.b.e r2 = r3.f5843h
            r0.<init>(r1, r2)
            r1 = 7
            com.aggmoread.sdk.z.d.a.a.d.b.k r0 = r0.a(r1)
            r0.b()
        L29:
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.f5362m
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L50
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "reward "
            r0.append(r1)
            com.aggmoread.sdk.z.d.a.a.c.r.d r1 = r3.f5366q
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.aggmoread.sdk.z.d.a.a.e.e.a(r0)
            com.aggmoread.sdk.z.d.a.a.c.r.d r0 = r3.f5366q
            if (r0 == 0) goto L50
            r0.onReward(r4)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aggmoread.sdk.z.d.a.a.d.a.d.i.b(java.util.Map):void");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
    }

    public void a(Map<String, Object> map) {
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(1).b();
        com.aggmoread.sdk.z.d.a.a.c.r.d dVar = this.f5366q;
        if (dVar != null) {
            dVar.onVideoComplete();
        }
    }
}
