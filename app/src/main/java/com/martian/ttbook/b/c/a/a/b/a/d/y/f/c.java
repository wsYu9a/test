package com.martian.ttbook.b.c.a.a.b.a.d.y.f;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.c.a.a.b.a.d.h;
import com.martian.ttbook.b.c.a.a.c.e;
import com.martian.ttbook.b.c.a.a.c.g;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.d;
import com.martian.ttbook.b.c.a.a.e.j;
import com.opos.acs.st.utils.ErrorContants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class c extends h implements TTAdNative.NativeExpressAdListener {

    /* renamed from: f */
    public TTAdNative f15511f;

    /* renamed from: g */
    private TTNativeExpressAd f15512g;

    /* renamed from: h */
    private boolean f15513h;

    /* renamed from: j */
    private boolean f15514j;
    private com.martian.ttbook.b.c.a.a.b.a.d.y.f.b k;
    private AtomicBoolean l;
    private Object[] m;
    private WeakReference<Activity> n;

    class a implements TTNativeExpressAd.AdInteractionListener {

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.y.f.c$a$a */
        class RunnableC0335a implements Runnable {
            RunnableC0335a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                Object obj = cVar.f15662c.f15668b;
                Object[] objArr = cVar.m;
                c cVar2 = c.this;
                l.o(obj, objArr, cVar2.f15662c.f15671e, Integer.valueOf(cVar2.f15663d.f()));
                c cVar3 = c.this;
                l.s(cVar3.f15662c.f15668b, cVar3.f15663d.e(), c.this.f15663d.b());
                byte[] h2 = c.this.f15662c.r.h();
                if (h2 != null) {
                    l.j(c.this.f15662c.f15668b, h2);
                }
                l.i(c.this.m, true, true);
                l.q(c.this.m, 2);
            }
        }

        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i2) {
            d.g("CSJINTAG", "onAdClicked");
            l.i(c.this.m, false, true);
            c cVar = c.this;
            k kVar = new k(cVar.f15662c, cVar.f15663d);
            c cVar2 = c.this;
            boolean g2 = kVar.g(cVar2.f15663d, null, 0L, cVar2.m);
            kVar.h();
            if (g2) {
                e eVar = c.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                    ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdClicked();
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
        public void onAdDismiss() {
            d.g("CSJINTAG", "onDialogDismiss");
            c cVar = c.this;
            new k(cVar.f15662c, cVar.f15663d).a(1).h();
            e eVar = c.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdDismissed();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i2) {
            d.g("CSJINTAG", "onAdShow");
            c cVar = c.this;
            new k(cVar.f15662c, cVar.f15663d).a(5).c(k.b.q, c.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = c.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdShow();
                ((com.martian.ttbook.b.c.a.a.c.n.b) c.this.f15662c.f15673g).onAdExposed();
            }
            n.c(new RunnableC0335a(), 1L);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i2) {
            d.g("CSJINTAG", "onRenderFail s = " + str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f2, float f3) {
            d.g("CSJINTAG", "onRenderSuccess");
            c.this.f15514j = true;
            if (c.this.f15512g == null || !c.this.l.get()) {
                return;
            }
            Activity activity = null;
            if (c.this.n == null || c.this.n.get() == null) {
                Context context = c.this.f15662c.f15670d;
                if (context instanceof Activity) {
                    activity = (Activity) context;
                }
            } else {
                activity = (Activity) c.this.n.get();
            }
            c.this.F(activity);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f15512g == null || !c.this.l.compareAndSet(false, true)) {
                return;
            }
            d.g("CSJINTAG", "s");
            if (c.this.f15514j) {
                d.g("CSJINTAG", "show");
                c cVar = c.this;
                cVar.F((Activity) cVar.n.get());
            }
        }
    }

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.y.f.c$c */
    class RunnableC0336c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Activity f15518a;

        RunnableC0336c(Activity activity) {
            this.f15518a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f15512g.showInteractionExpressAd(this.f15518a);
        }
    }

    public c(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.l = new AtomicBoolean();
        this.m = com.martian.ttbook.b.c.a.a.b.n();
    }

    public void F(Activity activity) {
        if (activity == null) {
            super.show();
            return;
        }
        try {
            activity.getWindow().getDecorView().post(new RunnableC0336c(activity));
        } catch (Exception e2) {
            d.g("CSJINTAG", "show e" + e2.getMessage());
            this.f15512g.showInteractionExpressAd(activity);
        }
    }

    private void I(i iVar) {
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15513h || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    private void L() {
        d.g("CSJINTAG", "showAd");
        j.c(new b());
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public void b() {
        d.g("CSJINTAG", "destroy");
        TTNativeExpressAd tTNativeExpressAd = this.f15512g;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
            this.f15512g = null;
        }
        com.martian.ttbook.b.c.a.a.b.a.d.y.f.b bVar = this.k;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
    public void onError(int i2, String str) {
        I(new i(i2, str));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        d.g("CSJINTAG", "onAdLoaded");
        if (list == null || list.size() == 0) {
            d.g("CSJINTAG", " empty");
            u(new i(10008, "无广告"));
            return;
        }
        if (com.martian.ttbook.b.c.a.a.b.a.d.y.a.f(this.f15663d, list.get(0))) {
            A(0);
            return;
        }
        this.f15513h = true;
        new k(this.f15662c, this.f15663d).a(4).h();
        TTNativeExpressAd tTNativeExpressAd = list.get(0);
        this.f15512g = tTNativeExpressAd;
        com.martian.ttbook.b.c.a.a.b.a.d.y.a.d(this.f15661b, tTNativeExpressAd, this.f15663d);
        this.f15512g.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) new a());
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
            ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdLoaded(arrayList);
        }
        this.f15512g.render();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public void show() {
        d.g("CSJINTAG", "show #1");
        Context context = this.f15662c.f15670d;
        if (context instanceof Activity) {
            show((Activity) context);
        } else {
            super.show();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public void show(Activity activity) {
        d.g("CSJINTAG", "show #2");
        if (this.n == null) {
            this.n = new WeakReference<>(activity);
        }
        L();
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        int i2;
        com.martian.ttbook.b.c.a.a.b.a.d.n.c(this.f15662c.f15670d, this.f15663d.f15701c.l(e.c.U), null);
        this.f15511f = com.martian.ttbook.b.c.a.a.b.a.d.y.c.b().createAdNative(this.f15662c.f15670d.getApplicationContext());
        g gVar = this.f15662c.q;
        int i3 = 0;
        if (gVar != null) {
            i3 = gVar.b();
            i2 = this.f15662c.q.a();
        } else {
            i2 = 0;
        }
        if (i3 < 1) {
            i3 = com.martian.ttbook.b.c.a.a.e.l.b(this.f15662c.f15670d);
        }
        if (i2 < 1) {
            i2 = i3;
        }
        AdSlot build = new AdSlot.Builder().setCodeId(this.f15663d.f15701c.l(e.c.Q)).setSupportDeepLink(true).setAdCount(Math.max(1, Math.min(3, this.f15662c.m))).setExpressViewAcceptedSize(i3, i2).build();
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15511f.loadInteractionExpressAd(build, this);
    }
}
