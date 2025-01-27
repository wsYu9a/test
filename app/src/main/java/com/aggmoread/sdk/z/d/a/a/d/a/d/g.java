package com.aggmoread.sdk.z.d.a.a.d.a.d;

import com.aggmoread.sdk.z.d.a.a.d.b.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class g extends com.aggmoread.sdk.z.d.a.a.d.b.a implements com.aggmoread.sdk.z.d.a.a.c.q.b {

    /* renamed from: m */
    protected boolean f5342m;

    /* renamed from: n */
    protected Object[] f5343n;

    /* renamed from: o */
    private com.aggmoread.sdk.z.d.a.a.c.q.a f5344o;

    public class a implements Runnable {

        /* renamed from: b */
        final /* synthetic */ List f5345b;

        public a(List list) {
            this.f5345b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.aggmoread.sdk.z.d.a.a.c.q.c) g.this.f5842g.f5861g).onAdLoaded(this.f5345b);
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.i f5347b;

        public b(com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
            this.f5347b = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f5842g.f5861g.a(this.f5347b);
        }
    }

    public class c implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.i f5349b;

        public c(com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
            this.f5349b = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f5344o.a(this.f5349b);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.aggmoread.sdk.z.d.a.a.c.q.c) g.this.f5842g.f5861g).onAdVideoCached();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f5344o.a();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f5344o.onADLeftApplication();
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.g$g */
    public class RunnableC0119g implements Runnable {
        public RunnableC0119g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f5344o.onAdShow();
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f5344o.onAdClicked();
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f5344o.onAdVideoCompleted();
        }
    }

    public g(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5342m = false;
        this.f5343n = com.aggmoread.sdk.z.d.a.a.b.b();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.q.b
    public void b() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("当前传入Activity为空");
        c(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002009, "show failed,当前传入Activity为空"));
    }

    public void c(com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
        if (this.f5344o != null) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new c(iVar));
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public String getID() {
        return this.f5842g.f5857c;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public Map<String, Object> h() {
        return com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5841f);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void p() {
        if (m()) {
            return;
        }
        super.p();
    }

    public void q() {
        if (this.f5344o != null) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new f());
        }
    }

    public void r() {
        com.aggmoread.sdk.z.d.a.a.d.b.l.a((Object) this.f5343n, false, true);
        com.aggmoread.sdk.z.d.a.a.d.b.k kVar = new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h);
        boolean a10 = kVar.a(this.f5843h, null, 0L, this.f5343n);
        kVar.b();
        if (!a10 || this.f5344o == null) {
            return;
        }
        com.aggmoread.sdk.z.d.a.a.e.n.a(new h());
    }

    public void s() {
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(4).b();
        if (this.f5344o != null) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new e());
        }
    }

    public void t() {
        com.aggmoread.sdk.z.d.a.a.e.e.a("exposure");
        a((com.aggmoread.sdk.z.d.a.a.c.e) this.f5344o);
    }

    public void u() {
        this.f5342m = true;
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(3).a(k.b.f6049q, com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5842g, this.f5843h, this.f5841f)).b();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        if (this.f5842g.f5861g instanceof com.aggmoread.sdk.z.d.a.a.c.q.c) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new a(arrayList));
        }
    }

    public void v() {
        if (this.f5344o != null) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new RunnableC0119g());
        }
    }

    public void w() {
        if (this.f5342m && (this.f5842g.f5861g instanceof com.aggmoread.sdk.z.d.a.a.c.q.c)) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new d());
        }
    }

    public void x() {
        if (this.f5344o != null) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new i());
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public final void a(int i10) {
        if (com.aggmoread.sdk.z.d.a.a.e.m.h(this.f5843h)) {
            c(i10);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(8).a(iVar).b();
        if (this.f5342m) {
            c(iVar);
        } else {
            if (this.f5843h.l()) {
                return;
            }
            com.aggmoread.sdk.z.d.a.a.e.n.a(new b(iVar));
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public final void a(int i10, int i11, String str) {
        if (com.aggmoread.sdk.z.d.a.a.e.m.h(this.f5843h)) {
            b(i10, i11, str);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.q.b
    public void a(com.aggmoread.sdk.z.d.a.a.c.q.a aVar) {
        this.f5344o = aVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
    }
}
