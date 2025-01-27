package com.martian.ttbook.b.c.a.a.d.a.d.x.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.martian.ttbook.b.c.a.a.b.a.d.d;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.d.a.d.x.c;
import com.martian.ttbook.b.c.a.a.d.a.d.x.d;
import com.martian.ttbook.b.c.a.a.d.a.d.x.d.a;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.sdk.client.AdExtras;
import com.opos.acs.st.utils.ErrorContants;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class b extends d {

    /* renamed from: f */
    private UnifiedBannerView f15607f;

    /* renamed from: g */
    private boolean f15608g;

    /* renamed from: h */
    private AtomicBoolean f15609h;

    /* renamed from: j */
    private WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> f15610j;
    public Object[] k;

    class a implements a.InterfaceC0347a {
        a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.d.a.InterfaceC0347a
        public void a() {
            b.this.S();
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.d.a.InterfaceC0347a
        public void b() {
            b.this.Q();
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.d.a.InterfaceC0347a
        public void c() {
            b.this.N();
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.d.a.InterfaceC0347a
        public void d() {
            b.this.O();
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.d.a.InterfaceC0347a
        public void e() {
            b.this.R();
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.d.a.InterfaceC0347a
        public void onADClicked() {
            b.this.M();
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.d.a.InterfaceC0347a
        public void onADExposure() {
            b.this.P();
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.d.a.InterfaceC0347a
        public void onNoAD(AdError adError) {
            b.this.F(adError);
        }
    }

    public b(com.martian.ttbook.b.c.a.a.d.b.d dVar, e eVar) {
        super(dVar, eVar);
        this.f15608g = false;
        this.f15609h = new AtomicBoolean();
        this.k = com.martian.ttbook.b.c.a.a.b.n();
    }

    public void F(AdError adError) {
        i iVar = new i(adError.getErrorCode(), adError.getErrorMsg());
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15608g || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    public void M() {
        l.i(this.k, false, true);
        k kVar = new k(this.f15662c, this.f15663d);
        e eVar = this.f15663d;
        WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference = this.f15610j;
        boolean g2 = kVar.g(eVar, weakReference == null ? null : weakReference.get(), 0L, this.k);
        kVar.h();
        if (g2) {
            com.martian.ttbook.b.c.a.a.c.e eVar2 = this.f15662c.f15673g;
            if (eVar2 instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
                ((com.martian.ttbook.b.c.a.a.c.k.b) eVar2).onAdClicked();
            }
        }
    }

    public void N() {
        new k(this.f15662c, this.f15663d).a(1).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
            ((com.martian.ttbook.b.c.a.a.c.k.b) eVar).onAdDismissed();
        }
    }

    public void O() {
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
            ((com.martian.ttbook.b.c.a.a.c.k.b) eVar).d();
        }
    }

    public void P() {
        C(this.f15610j.get(), new View[0]);
        new k(this.f15662c, this.f15663d).a(5).c(k.b.q, this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
            ((com.martian.ttbook.b.c.a.a.c.k.b) eVar).onAdExposed();
        }
    }

    public void Q() {
        int b2 = c.b(this.f15607f);
        if (c.e(this.f15663d, b2)) {
            A(0);
            return;
        }
        B(b2);
        this.f15608g = true;
        this.f15661b.put(AdExtras.EXTRA_APP_INFOURL, com.martian.ttbook.b.c.a.a.d.a.d.x.a.b(this.f15607f));
        c.d(this.f15661b, this.f15607f, this.f15663d);
        new k(this.f15662c, this.f15663d).a(4).h();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
            ((com.martian.ttbook.b.c.a.a.c.k.b) eVar).onAdLoaded(arrayList);
        }
    }

    public void R() {
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
            ((com.martian.ttbook.b.c.a.a.c.k.b) eVar).e();
        }
    }

    public void S() {
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
            ((com.martian.ttbook.b.c.a.a.c.k.b) eVar).a();
        }
    }

    private void T() {
        UnifiedBannerView unifiedBannerView;
        if (this.f15608g && (unifiedBannerView = this.f15607f) != null && unifiedBannerView.getParent() == null && this.f15609h.compareAndSet(false, true)) {
            com.martian.ttbook.b.c.a.a.d.a.d.x.a.e(this.f15607f, this.f15664e);
            com.martian.ttbook.b.c.a.a.d.b.m.a aVar = this.f15610j.get();
            if (aVar != null) {
                aVar.addView(this.f15607f);
            }
        }
    }

    protected void C(View view, View[] viewArr) {
        WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference = this.f15610j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.martian.ttbook.b.c.a.a.e.d.g("GDTBANTAG", "apy");
        l.n(this.f15662c.f15668b, this.k, h.BANNER, view, viewArr, null, null, Integer.valueOf(this.f15663d.f()));
        l.s(this.f15662c.f15668b, this.f15663d.e(), this.f15663d.b());
        byte[] h2 = this.f15662c.r.h();
        if (h2 != null) {
            l.j(this.f15662c.f15668b, h2);
        }
        l.i(this.k, true, true);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.d, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.e.i.d(this.f15607f, i3, i2, str);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.k.a
    public void a(ViewGroup viewGroup) {
        com.martian.ttbook.b.c.a.a.d.b.m.a aVar = new com.martian.ttbook.b.c.a.a.d.b.m.a(this.f15662c.f15670d);
        this.f15610j = new WeakReference<>(aVar);
        aVar.addOnAttachStateChangeListener(new com.martian.ttbook.b.c.a.a.d.b.m.b());
        if (viewGroup != null) {
            ViewGroup viewGroup2 = (ViewGroup) aVar.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(aVar);
            }
            viewGroup.addView(aVar, new ViewGroup.LayoutParams(-1, -2));
        }
        T();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.k.a
    public void b() {
        UnifiedBannerView unifiedBannerView = this.f15607f;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
            this.f15607f = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
        this.f15664e = cVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.d, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        com.martian.ttbook.b.c.a.a.e.i.c(this.f15607f, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.k.a
    public void show() {
        a(this.f15662c.f15676j);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        Context context = this.f15662c.f15670d;
        com.martian.ttbook.b.c.a.a.e.e eVar = this.f15663d.f15701c;
        Object obj = e.c.U;
        n.f(context, eVar.d(obj, ""));
        UnifiedBannerView unifiedBannerView = (UnifiedBannerView) com.martian.ttbook.b.c.a.a.d.a.d.x.d.b(d.e.BANNER, this.f15662c.f15670d, this.f15663d.f15701c.l(obj), this.f15663d.f15701c.l(e.c.Q), new com.martian.ttbook.b.c.a.a.d.a.d.x.d.a(new a()).a(), new Object[0]);
        this.f15607f = unifiedBannerView;
        this.f15608g = false;
        com.martian.ttbook.b.c.a.a.d.b.d dVar = this.f15662c;
        unifiedBannerView.setRefresh(dVar.l ? 0 : dVar.o);
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15607f.loadAD();
    }
}
