package com.martian.ttbook.b.c.a.a.b.a.d.y.g;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.martian.ttbook.b.c.a.a.b.a.d.g;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.c.e;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.d;
import com.martian.ttbook.b.c.a.a.e.j;
import com.opos.acs.st.utils.ErrorContants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends g {

    /* renamed from: f */
    public TTAdNative f15520f;

    /* renamed from: g */
    private TTFullScreenVideoAd f15521g;

    /* renamed from: h */
    private AtomicBoolean f15522h;

    /* renamed from: j */
    private AtomicBoolean f15523j;
    private Object[] k;
    private boolean l;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.y.g.a$a */
    class C0337a implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.y.g.a$a$a */
        class RunnableC0338a implements Runnable {
            RunnableC0338a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                Object obj = aVar.f15662c.f15668b;
                Object[] objArr = aVar.k;
                a aVar2 = a.this;
                l.o(obj, objArr, aVar2.f15662c.f15671e, Integer.valueOf(aVar2.f15663d.f()));
                a aVar3 = a.this;
                l.s(aVar3.f15662c.f15668b, aVar3.f15663d.e(), a.this.f15663d.b());
                byte[] h2 = a.this.f15662c.r.h();
                if (h2 != null) {
                    l.j(a.this.f15662c.f15668b, h2);
                }
                l.i(a.this.k, true, true);
            }
        }

        C0337a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClose() {
            d.g("CSJFTAG", "onAdClose");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(1).h();
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdDismissed();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdShow() {
            d.g("CSJFTAG", "onAdShow");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(5).c(k.b.q, a.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdShow();
                ((com.martian.ttbook.b.c.a.a.c.m.b) a.this.f15662c.f15673g).onAdExposed();
            }
            j.b(new RunnableC0338a(), 500L);
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdVideoBarClick() {
            d.g("CSJFTAG", "onAdVideoBarClick");
            l.i(a.this.k, false, true);
            a aVar = a.this;
            k kVar = new k(aVar.f15662c, aVar.f15663d);
            a aVar2 = a.this;
            boolean g2 = kVar.g(aVar2.f15663d, null, 0L, aVar2.k);
            kVar.h();
            if (g2) {
                com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                    ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdClicked();
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
            d.g("CSJFTAG", "onSkippedVideo");
            a.this.H();
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoComplete() {
            d.g("CSJFTAG", "onVideoComplete");
            a.this.H();
        }
    }

    private class b implements InvocationHandler {
        private b() {
        }

        /* synthetic */ b(a aVar, C0337a c0337a) {
            this();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if ("onFullScreenVideoAdLoad".equals(name)) {
                a.this.C((TTFullScreenVideoAd) objArr[0]);
                return null;
            }
            if ("onFullScreenVideoCached".equals(name)) {
                a.this.I();
                return null;
            }
            if (!"onError".equals(name)) {
                return null;
            }
            a.this.onError(((Integer) objArr[0]).intValue(), (String) objArr[1]);
            return null;
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15522h = new AtomicBoolean();
        this.f15523j = new AtomicBoolean();
        this.k = com.martian.ttbook.b.c.a.a.b.n();
    }

    private void E(Activity activity) {
        d.g("CSJFTAG", "showAd activity = " + activity);
        if (this.f15521g == null || !this.f15522h.compareAndSet(false, true)) {
            return;
        }
        d.g("CSJFTAG", "show");
        if (activity == null) {
            super.show();
        } else {
            this.f15521g.showFullScreenVideoAd(activity);
            this.f15521g = null;
        }
    }

    private void G(i iVar) {
        d.g("CSJFTAG", "notifyAdError error " + iVar);
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.l || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    public void H() {
        if (this.f15523j.compareAndSet(false, true)) {
            l.i(this.k, false, true);
            com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdVideoCompleted();
            }
        }
    }

    public void C(TTFullScreenVideoAd tTFullScreenVideoAd) {
        if (com.martian.ttbook.b.c.a.a.b.a.d.y.a.f(this.f15663d, tTFullScreenVideoAd)) {
            A(0);
            return;
        }
        this.l = true;
        new k(this.f15662c, this.f15663d).a(4).h();
        this.f15521g = tTFullScreenVideoAd;
        com.martian.ttbook.b.c.a.a.b.a.d.y.a.d(this.f15661b, tTFullScreenVideoAd, this.f15663d);
        this.f15521g.setFullScreenVideoAdInteractionListener(new C0337a());
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
            ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdLoaded(arrayList);
        }
    }

    public void I() {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.m.a
    public void b() {
        if (this.f15521g != null) {
            this.f15521g = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
    }

    public void onError(int i2, String str) {
        G(new i(i2, str));
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.m.a
    public void show() {
        Context context = this.f15662c.f15670d;
        if (context instanceof Activity) {
            E((Activity) context);
        } else {
            super.show();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.m.a
    public void show(Activity activity) {
        E(activity);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        n.c(this.f15662c.f15670d, this.f15663d.f15701c.l(e.c.U), null);
        this.f15520f = com.martian.ttbook.b.c.a.a.b.a.d.y.c.b().createAdNative(this.f15662c.f15670d.getApplicationContext());
        AdSlot build = new AdSlot.Builder().setCodeId(this.f15663d.f15701c.l(e.c.Q)).setSupportDeepLink(true).setExpressViewAcceptedSize(1.0f, 1.0f).build();
        TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener = (TTAdNative.FullScreenVideoAdListener) Proxy.newProxyInstance(TTAdNative.FullScreenVideoAdListener.class.getClassLoader(), new Class[]{TTAdNative.FullScreenVideoAdListener.class}, new b(this, null));
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15520f.loadFullScreenVideoAd(build, fullScreenVideoAdListener);
    }
}
