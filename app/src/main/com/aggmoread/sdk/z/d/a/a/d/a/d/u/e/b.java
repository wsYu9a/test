package com.aggmoread.sdk.z.d.a.a.d.a.d.u.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.aggmoread.sdk.z.d.a.a.d.a.c;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.d;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.e.a;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.e.f;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class b extends com.aggmoread.sdk.z.d.a.a.d.a.d.a {

    /* renamed from: r */
    private UnifiedBannerView f5689r;

    public class a implements a.InterfaceC0162a {
        public a() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.e.a.InterfaceC0162a
        public void a() {
            b.this.C();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.e.a.InterfaceC0162a
        public void b() {
            b.this.z();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.e.a.InterfaceC0162a
        public void onADClicked() {
            b.this.y();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.e.a.InterfaceC0162a
        public void onADCloseOverlay() {
            b.this.A();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.e.a.InterfaceC0162a
        public void onADExposure() {
            b.this.B();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.e.a.InterfaceC0162a
        public void onADLeftApplication() {
            b.this.E();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.e.a.InterfaceC0162a
        public void onADOpenOverlay() {
            b.this.D();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.e.a.InterfaceC0162a
        public void onNoAD(AdError adError) {
            b.this.a(adError);
        }
    }

    public b(d dVar, e eVar) {
        super(dVar, eVar);
    }

    public void A() {
        s();
    }

    public void B() {
        a(new View[0]);
        t();
    }

    public void C() {
        if (o()) {
            int a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(this.f5689r);
            if (com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(this.f5843h, a10)) {
                a(a10, 0);
                return;
            }
            b(a10);
        }
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(this.f5841f, this.f5689r, this.f5843h);
        v();
    }

    public void D() {
        w();
    }

    public void E() {
        u();
    }

    private void F() {
        UnifiedBannerView unifiedBannerView;
        if (this.f5291m && (unifiedBannerView = this.f5689r) != null && unifiedBannerView.getParent() == null && this.f5293o.compareAndSet(false, true)) {
            com.aggmoread.sdk.z.d.a.a.d.a.d.u.a.a(this.f5689r, k());
            com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = this.f5295q.get();
            if (aVar != null) {
                aVar.addView(this.f5689r);
            }
        }
    }

    public void y() {
        q();
    }

    public void z() {
        r();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.m.a
    public void a(ViewGroup viewGroup) {
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(this.f5842g.f5858d);
        this.f5295q = new WeakReference<>(aVar);
        aVar.addOnAttachStateChangeListener(new com.aggmoread.sdk.z.d.a.a.d.b.m.b());
        if (viewGroup != null) {
            ViewGroup viewGroup2 = (ViewGroup) aVar.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(aVar);
            }
            viewGroup.addView(aVar, new ViewGroup.LayoutParams(-1, -2));
        }
        F();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.m.a
    public void b() {
        a(this.f5842g.f5864j);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void c(int i10) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5689r, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.m.a
    public void destroy() {
        UnifiedBannerView unifiedBannerView = this.f5689r;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
            this.f5689r = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a().a(this.f5842g);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        Context context = this.f5842g.f5858d;
        f fVar = this.f5843h.f5907c;
        Object obj = e.c.X;
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(context, fVar.a(obj, ""));
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a().a(this.f5843h, this.f5842g);
        UnifiedBannerView unifiedBannerView = (UnifiedBannerView) com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5842g.f5858d, this.f5843h.f5907c.c(obj), this.f5843h.f5907c.c(e.c.T), d.e.BANNER, this.f5845j, new com.aggmoread.sdk.z.d.a.a.d.a.d.u.e.a(new a()).a(), new Object[0]);
        this.f5689r = unifiedBannerView;
        this.f5291m = false;
        com.aggmoread.sdk.z.d.a.a.d.b.d dVar = this.f5842g;
        if (dVar.f5866l) {
            unifiedBannerView.setRefresh(0);
        } else {
            unifiedBannerView.setRefresh(dVar.f5869o);
        }
        new k(this.f5842g, this.f5843h).a(0).b();
        this.f5689r.loadAD();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.a, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(c cVar) {
        this.f5844i = cVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5689r, i11, i10, str);
    }

    public void a(AdError adError) {
        b(new i(adError.getErrorCode(), adError.getErrorMsg()));
    }
}
