package com.martian.ttbook.b.c.a.a.b.a.d.x.e;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.martian.ttbook.b.c.a.a.b.a.d.x.c;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class c extends com.martian.ttbook.b.c.a.a.b.a.d.e {
    private String m;
    private ExpressResponse n;
    private com.martian.ttbook.b.c.a.a.d.b.m.a o;
    private View p;
    private AtomicBoolean q;

    class a implements ExpressResponse.ExpressInteractionListener {
        a() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdClick() {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, IAdInterListener.AdCommandType.AD_CLICK);
            c.this.u();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdExposed() {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, "onAdExposed");
            c.this.v();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdRenderFail(View view, String str, int i2) {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, "onAdRenderFail " + str + ", code " + i2);
            c.this.w();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdRenderSuccess(View view, float f2, float f3) {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, "onAdRenderSuccess");
            c.this.x();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdUnionClick() {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, "onAdUnionClick");
        }
    }

    class b implements c.InterfaceC0322c {
        b() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.c.InterfaceC0322c
        public void a() {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, "onDislikeWindowShow");
            c.this.A();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.c.InterfaceC0322c
        public void b() {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, "onDislikeWindowClose");
            c.this.z();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.c.InterfaceC0322c
        public void c() {
            com.martian.ttbook.b.c.a.a.e.d.g(c.this.m, "onDislikeItemClick");
            c.this.y();
        }
    }

    public c(ExpressResponse expressResponse, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.m = "BDUNITAG";
        this.q = new AtomicBoolean();
        this.n = expressResponse;
        s();
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.g(this.l, com.martian.ttbook.b.c.a.a.b.a.d.x.a.b(expressResponse), eVar);
    }

    public void A() {
    }

    private void s() {
        this.n.setInteractionListener(new a());
        this.n.setAdDislikeListener(com.martian.ttbook.b.c.a.a.b.a.d.x.c.c().b(new b()));
    }

    public void u() {
        k kVar = new k(this.f15212c, this.f15213d);
        boolean g2 = kVar.c(k.b.n, this.f15210a).g(this.f15213d, i(), this.f15215f, this.f15218j);
        kVar.h();
        l.i(this.f15218j, false, true);
        if (g2) {
            com.martian.ttbook.b.c.a.a.c.e eVar = this.f15212c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
                ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).i(this);
            }
        }
    }

    public void v() {
        this.f15215f = System.currentTimeMillis();
        l.i(this.f15218j, true, true);
        if (t()) {
            new k(this.f15212c, this.f15213d).a(5).c(k.b.n, this.f15210a).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = this.f15212c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
                ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).c(this);
            }
        }
    }

    public void w() {
    }

    public void x() {
    }

    public void y() {
        new k(this.f15212c, this.f15213d).c(k.b.n, this.f15210a).a(1).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15212c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
            ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).f(this);
        }
    }

    public void z() {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.e, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.e(this.n, "203");
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void a(Activity activity) {
        render();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void b() {
        if (this.n != null) {
            this.n = null;
            this.p = null;
            this.o = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.e, com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public View getView() {
        com.martian.ttbook.b.c.a.a.e.d.g(this.m, "getView");
        if (this.p == null) {
            this.p = this.n.getExpressAdView();
        }
        if (this.p == null) {
            return null;
        }
        if (this.o == null) {
            this.o = new com.martian.ttbook.b.c.a.a.d.b.m.a(this.f15212c.f15670d);
        }
        com.martian.ttbook.b.c.a.a.e.d.g(this.m, "getView " + this.o);
        return this.o;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.a
    public com.martian.ttbook.b.c.a.a.d.b.m.a i() {
        com.martian.ttbook.b.c.a.a.e.d.g(this.m, "ac " + this.o);
        com.martian.ttbook.b.c.a.a.d.b.m.a aVar = this.o;
        return aVar != null ? aVar : super.i();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void render() {
        ExpressResponse expressResponse;
        com.martian.ttbook.b.c.a.a.e.d.g(this.m, "render");
        if (this.p == null || (expressResponse = this.n) == null) {
            com.martian.ttbook.b.c.a.a.e.d.g(this.m, "render failed");
            return;
        }
        expressResponse.render();
        if (this.p.getParent() != null || this.o == null) {
            return;
        }
        com.martian.ttbook.b.c.a.a.e.d.g(this.m, "render enter ");
        View[] viewArr = new View[0];
        com.martian.ttbook.b.c.a.a.d.b.m.a aVar = this.o;
        if (aVar != null) {
            aVar.addView(this.p, new FrameLayout.LayoutParams(-1, -2));
        }
        l.c(this.o, this.f15218j);
        l.m(this.f15212c.f15668b, this.f15218j, h.INFORMATION_FLOW, this.o, viewArr, new WeakReference(this.o), null);
        l.s(this.f15212c.f15668b, this.f15213d.e(), this.f15213d.b());
        byte[] h2 = this.f15212c.r.h();
        if (h2 != null) {
            l.j(this.f15212c.f15668b, h2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.e, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        super.sendWinNotification(i2);
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.d(this.n, i2);
    }

    public boolean t() {
        return this.q.compareAndSet(false, true);
    }
}
