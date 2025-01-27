package com.aggmoread.sdk.z.d.a.a.d.a.d;

import android.app.Activity;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class f extends com.aggmoread.sdk.z.d.a.a.d.b.a implements com.aggmoread.sdk.z.d.a.a.c.p.b {

    /* renamed from: m */
    protected boolean f5327m;

    /* renamed from: n */
    protected Object[] f5328n;

    /* renamed from: o */
    private com.aggmoread.sdk.z.d.a.a.c.p.a f5329o;

    public class a implements Runnable {

        /* renamed from: b */
        final /* synthetic */ List f5330b;

        public a(List list) {
            this.f5330b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.aggmoread.sdk.z.d.a.a.c.p.c) f.this.f5842g.f5861g).onAdLoaded(this.f5330b);
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.i f5332b;

        public b(com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
            this.f5332b = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f5842g.f5861g.a(this.f5332b);
        }
    }

    public class c implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.i f5334b;

        public c(com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
            this.f5334b = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f5329o.a(this.f5334b);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.aggmoread.sdk.z.d.a.a.c.p.c) f.this.f5842g.f5861g).onAdVideoCached();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f5329o.a();
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.f$f */
    public class RunnableC0118f implements Runnable {
        public RunnableC0118f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f5329o.onADLeftApplication();
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f5329o.onAdShow();
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f5329o.onAdClicked();
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f5329o.onAdVideoCompleted();
        }
    }

    public f(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5327m = false;
        this.f5328n = com.aggmoread.sdk.z.d.a.a.b.b();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.p.b
    public void b() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("当前传入Activity为空");
        c(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002009, "show failed,当前传入Activity为空"));
    }

    public void c(com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
        if (this.f5329o != null) {
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
        if (this.f5329o != null) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new RunnableC0118f());
        }
    }

    public void r() {
        com.aggmoread.sdk.z.d.a.a.d.b.l.a((Object) this.f5328n, false, true);
        com.aggmoread.sdk.z.d.a.a.d.b.k kVar = new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h);
        boolean a10 = kVar.a(this.f5843h, null, 0L, this.f5328n);
        kVar.b();
        if (!a10 || this.f5329o == null) {
            return;
        }
        com.aggmoread.sdk.z.d.a.a.e.n.a(new h());
    }

    public void s() {
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(4).b();
        if (this.f5329o != null) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new e());
        }
    }

    public void t() {
        com.aggmoread.sdk.z.d.a.a.e.e.a("exposure");
        a((com.aggmoread.sdk.z.d.a.a.c.e) this.f5329o);
    }

    public void u() {
        this.f5327m = true;
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(3).a(k.b.f6049q, com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5842g, this.f5843h, this.f5841f)).b();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        if (this.f5842g.f5861g instanceof com.aggmoread.sdk.z.d.a.a.c.p.c) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new a(arrayList));
        }
    }

    public void v() {
        if (this.f5329o != null) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new g());
        }
    }

    public void w() {
        if (this.f5327m && (this.f5842g.f5861g instanceof com.aggmoread.sdk.z.d.a.a.c.p.c)) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new d());
        }
    }

    public void x() {
        if (this.f5329o != null) {
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
        if (this.f5327m) {
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

    @Override // com.aggmoread.sdk.z.d.a.a.c.p.b
    public void a(Activity activity) {
        b();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.p.b
    public void a(com.aggmoread.sdk.z.d.a.a.c.p.a aVar) {
        this.f5329o = aVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
    }
}
