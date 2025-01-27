package com.martian.ttbook.b.c.a.a.b.a.d.y.d;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.martian.ttbook.b.c.a.a.b.a.c;
import com.martian.ttbook.b.c.a.a.b.a.d.d;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.b.a.d.y.d.b;
import com.martian.ttbook.b.c.a.a.c.e;
import com.martian.ttbook.b.c.a.a.c.g;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.opos.acs.st.utils.ErrorContants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends d implements TTAdNative.NativeExpressAdListener {

    /* renamed from: f */
    public TTAdNative f15487f;

    /* renamed from: g */
    private TTNativeExpressAd f15488g;

    /* renamed from: h */
    private WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> f15489h;

    /* renamed from: j */
    private AtomicBoolean f15490j;
    public Object[] k;
    private boolean l;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.y.d.a$a */
    class C0332a implements TTNativeExpressAd.ExpressAdInteractionListener {
        C0332a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i2) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", "onAdClicked");
            l.i(a.this.k, false, true);
            a aVar = a.this;
            k kVar = new k(aVar.f15662c, aVar.f15663d);
            a aVar2 = a.this;
            boolean g2 = kVar.g(aVar2.f15663d, (com.martian.ttbook.b.c.a.a.d.b.m.a) aVar2.f15489h.get(), 0L, a.this.k);
            kVar.h();
            if (g2) {
                e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
                    ((com.martian.ttbook.b.c.a.a.c.k.b) eVar).onAdClicked();
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i2) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", "onAdShow");
            a aVar = a.this;
            aVar.D((View) aVar.f15489h.get(), new View[0]);
            a aVar2 = a.this;
            new k(aVar2.f15662c, aVar2.f15663d).a(5).c(k.b.q, a.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
                ((com.martian.ttbook.b.c.a.a.c.k.b) eVar).onAdShow();
                ((com.martian.ttbook.b.c.a.a.c.k.b) a.this.f15662c.f15673g).onAdExposed();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i2) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", "onRenderFail");
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f2, float f3) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", "onRenderSuccess");
            com.martian.ttbook.b.c.a.a.d.b.m.a aVar = (com.martian.ttbook.b.c.a.a.d.b.m.a) a.this.f15489h.get();
            if (aVar == null || view == null) {
                return;
            }
            com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", "onRenderSuccess adview ");
            aVar.removeAllViews();
            aVar.addView(view);
        }
    }

    class b implements b.a {
        b() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.d.b.a
        public void a() {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", "onRefuse");
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.d.b.a
        public void b() {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", "onSelected");
            com.martian.ttbook.b.c.a.a.d.b.m.a aVar = (com.martian.ttbook.b.c.a.a.d.b.m.a) a.this.f15489h.get();
            if (aVar != null) {
                aVar.removeAllViews();
            }
            a aVar2 = a.this;
            new k(aVar2.f15662c, aVar2.f15663d).a(1).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
                ((com.martian.ttbook.b.c.a.a.c.k.b) eVar).onAdDismissed();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.d.b.a
        public void onCancel() {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", "onCancel");
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.d.b.a
        public void onShow() {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", "onShow");
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15490j = new AtomicBoolean();
        this.l = false;
        this.k = com.martian.ttbook.b.c.a.a.b.n();
    }

    private void E() {
        com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", "showAd ");
        if (this.f15488g == null || !this.f15490j.compareAndSet(false, true)) {
            return;
        }
        com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", "show");
        this.f15488g.render();
    }

    protected void D(View view, View[] viewArr) {
        WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference = this.f15489h;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        l.n(this.f15662c.f15668b, this.k, h.BANNER, view, viewArr, null, null, Integer.valueOf(this.f15663d.f()));
        l.s(this.f15662c.f15668b, this.f15663d.e(), this.f15663d.b());
        byte[] h2 = this.f15662c.r.h();
        if (h2 != null) {
            l.j(this.f15662c.f15668b, h2);
        }
        l.i(this.k, true, true);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.k.a
    public void a(ViewGroup viewGroup) {
        com.martian.ttbook.b.c.a.a.d.b.m.a aVar = new com.martian.ttbook.b.c.a.a.d.b.m.a(viewGroup.getContext());
        this.f15489h = new WeakReference<>(aVar);
        com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", "showInContainer innerAdContainer = " + aVar);
        ViewGroup viewGroup2 = (ViewGroup) aVar.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(aVar);
        }
        viewGroup.addView(aVar, new ViewGroup.LayoutParams(-1, -2));
        E();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.k.a
    public void b() {
        TTNativeExpressAd tTNativeExpressAd = this.f15488g;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
            this.f15488g = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
    public void onError(int i2, String str) {
        i iVar = new i(i2, str);
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.l || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", "onAdLoaded");
        if (list == null || list.size() == 0) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", " empty");
            u(new i(10008, "无广告"));
            return;
        }
        if (com.martian.ttbook.b.c.a.a.b.a.d.y.a.f(this.f15663d, list.get(0))) {
            A(0);
            return;
        }
        this.l = true;
        TTNativeExpressAd tTNativeExpressAd = list.get(0);
        this.f15488g = tTNativeExpressAd;
        com.martian.ttbook.b.c.a.a.b.a.d.y.a.d(this.f15661b, tTNativeExpressAd, this.f15663d);
        this.f15488g.setExpressInteractionListener(new C0332a());
        try {
            Class<?> cls = Class.forName("com.bytedance.sdk.openadsdk.TTAdDislike$DislikeInteractionCallback");
            TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = (TTAdDislike.DislikeInteractionCallback) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new com.martian.ttbook.b.c.a.a.b.a.d.y.d.b(new b()));
            if (com.martian.ttbook.b.c.a.a.d.a.d.v.d.a.a.a(this.f15662c.f15670d) != null) {
                this.f15488g.setDislikeCallback(com.martian.ttbook.b.c.a.a.d.a.d.v.d.a.a.a(this.f15662c.f15670d), dislikeInteractionCallback);
            }
        } catch (Exception e2) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", "err =" + e2);
        }
        new k(this.f15662c, this.f15663d).a(4).h();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
            ((com.martian.ttbook.b.c.a.a.c.k.b) eVar).onAdLoaded(arrayList);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.k.a
    public void show() {
        a(this.f15662c.f15676j);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        int i2;
        n.c(this.f15662c.f15670d, this.f15663d.f15701c.l(e.c.U), null);
        this.f15487f = com.martian.ttbook.b.c.a.a.b.a.d.y.c.b().createAdNative(this.f15662c.f15670d.getApplicationContext());
        g gVar = this.f15662c.q;
        int i3 = 0;
        if (gVar != null) {
            i3 = gVar.b();
            i2 = this.f15662c.q.a();
        } else {
            i2 = 0;
        }
        if (i3 < 1 || i2 < 1) {
            i3 = 640;
            i2 = 100;
        }
        AdSlot build = new AdSlot.Builder().setCodeId(this.f15663d.f15701c.l(e.c.Q)).setSupportDeepLink(true).setAdCount(Math.max(1, Math.max(3, this.f15662c.m))).setExpressViewAcceptedSize(i3, i2).build();
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15487f.loadBannerExpressAd(build, this);
        com.martian.ttbook.b.c.a.a.e.d.g("CSJIATAG", "handleAd exit ");
    }
}
