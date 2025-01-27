package com.aggmoread.sdk.z.d.a.a.d.a.d;

import android.view.View;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class a extends com.aggmoread.sdk.z.d.a.a.d.b.a implements com.aggmoread.sdk.z.d.a.a.c.m.a {

    /* renamed from: m */
    protected boolean f5291m;

    /* renamed from: n */
    protected com.aggmoread.sdk.z.d.a.a.c.m.c f5292n;

    /* renamed from: o */
    protected AtomicBoolean f5293o;

    /* renamed from: p */
    public Object[] f5294p;

    /* renamed from: q */
    protected WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> f5295q;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.a$a */
    public class RunnableC0116a implements Runnable {

        /* renamed from: b */
        final /* synthetic */ ArrayList f5296b;

        public RunnableC0116a(ArrayList arrayList) {
            this.f5296b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.aggmoread.sdk.z.d.a.a.c.m.b) a.this.f5842g.f5861g).onAdLoaded(this.f5296b);
        }
    }

    public a(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5291m = false;
        this.f5293o = new AtomicBoolean();
        this.f5294p = com.aggmoread.sdk.z.d.a.a.b.b();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public final void a(int i10) {
        if (com.aggmoread.sdk.z.d.a.a.e.m.h(this.f5843h)) {
            c(i10);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
        com.aggmoread.sdk.z.d.a.a.c.f fVar;
        this.f5846k.a();
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(8).a(iVar).b();
        if (this.f5291m) {
            fVar = this.f5292n;
            if (fVar == null) {
                return;
            }
        } else if (this.f5843h.l()) {
            return;
        } else {
            fVar = this.f5842g.f5861g;
        }
        fVar.a(iVar);
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
        com.aggmoread.sdk.z.d.a.a.c.m.c cVar;
        com.aggmoread.sdk.z.d.a.a.d.b.l.a((Object) this.f5294p, false, true);
        com.aggmoread.sdk.z.d.a.a.d.b.k kVar = new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h);
        com.aggmoread.sdk.z.d.a.a.d.b.e eVar = this.f5843h;
        WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = this.f5295q;
        boolean a10 = kVar.a(eVar, weakReference == null ? null : weakReference.get(), 0L, this.f5294p);
        kVar.b();
        if (!a10 || (cVar = this.f5292n) == null) {
            return;
        }
        cVar.onAdClicked();
    }

    public void r() {
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(4).b();
        com.aggmoread.sdk.z.d.a.a.c.m.c cVar = this.f5292n;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void s() {
        com.aggmoread.sdk.z.d.a.a.c.m.c cVar = this.f5292n;
        if (cVar != null) {
            cVar.onADCloseOverlay();
        }
    }

    public void t() {
        com.aggmoread.sdk.z.d.a.a.e.e.a("onAdExposure");
        a((com.aggmoread.sdk.z.d.a.a.c.e) this.f5292n);
    }

    public void u() {
        com.aggmoread.sdk.z.d.a.a.c.m.c cVar = this.f5292n;
        if (cVar != null) {
            cVar.onADLeftApplication();
        }
    }

    public void v() {
        this.f5291m = true;
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(3).a(k.b.f6049q, com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5842g, this.f5843h, this.f5841f)).b();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        if (this.f5842g.f5861g instanceof com.aggmoread.sdk.z.d.a.a.c.m.b) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new RunnableC0116a(arrayList));
        }
    }

    public void w() {
        com.aggmoread.sdk.z.d.a.a.c.m.c cVar = this.f5292n;
        if (cVar != null) {
            cVar.onADOpenOverlay();
        }
    }

    public void x() {
        com.aggmoread.sdk.z.d.a.a.c.m.c cVar = this.f5292n;
        if (cVar != null) {
            cVar.onAdShow();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public final void a(int i10, int i11, String str) {
        if (com.aggmoread.sdk.z.d.a.a.e.m.h(this.f5843h)) {
            b(i10, i11, str);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.m.a
    public void a(com.aggmoread.sdk.z.d.a.a.c.m.c cVar) {
        this.f5292n = cVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
    }

    public void a(View[] viewArr) {
        WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = this.f5295q;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.a("ban apy");
        com.aggmoread.sdk.z.d.a.a.d.b.l.a(this.f5842g.f5856b, this.f5294p, com.aggmoread.sdk.z.d.a.a.c.i.BANNER, this.f5295q.get(), viewArr, null, null, Integer.valueOf(this.f5843h.f()));
        com.aggmoread.sdk.z.d.a.a.d.b.l.b(this.f5842g.f5856b, this.f5843h.e(), this.f5843h.b());
        byte[] b10 = this.f5842g.f5872r.b();
        if (b10 != null) {
            com.aggmoread.sdk.z.d.a.a.d.b.l.a(this.f5842g.f5856b, b10);
        }
        com.aggmoread.sdk.z.d.a.a.d.b.l.a((Object) this.f5294p, true, true);
        com.aggmoread.sdk.z.d.a.a.d.b.l.a(this.f5294p, this.f5843h);
    }
}
