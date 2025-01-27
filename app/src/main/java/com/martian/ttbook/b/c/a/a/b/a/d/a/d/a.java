package com.martian.ttbook.b.c.a.a.b.a.d.a.d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.c.a.a.b.a.d.g;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.d;
import com.opos.acs.st.utils.ErrorContants;
import com.qumeng.advlib.core.AdRequestParam;
import com.qumeng.advlib.core.IMultiAdObject;
import com.qumeng.advlib.core.IMultiAdRequest;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends g {

    /* renamed from: f */
    private IMultiAdObject f15236f;

    /* renamed from: g */
    private boolean f15237g;

    /* renamed from: h */
    private Object[] f15238h;

    /* renamed from: j */
    private AtomicBoolean f15239j;
    private AdRequestParam.ADInteractionListener k;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.a.d.a$a */
    class C0290a implements AdRequestParam.ADInteractionListener {

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.a.d.a$a$a */
        class RunnableC0291a implements Runnable {
            RunnableC0291a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                Object obj = aVar.f15662c.f15668b;
                Object[] objArr = aVar.f15238h;
                a aVar2 = a.this;
                l.o(obj, objArr, aVar2.f15662c.f15671e, Integer.valueOf(aVar2.f15663d.f()));
                a aVar3 = a.this;
                l.s(aVar3.f15662c.f15668b, aVar3.f15663d.e(), a.this.f15663d.b());
                byte[] h2 = a.this.f15662c.r.h();
                if (h2 != null) {
                    l.j(a.this.f15662c.f15668b, h2);
                }
                l.i(a.this.f15238h, true, true);
                l.q(a.this.f15238h, 2);
            }
        }

        C0290a() {
        }

        public void a() {
            d.g("QMFUTAG", "onADExposure");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(5).c(k.b.q, a.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdShow();
                ((com.martian.ttbook.b.c.a.a.c.m.b) a.this.f15662c.f15673g).onAdExposed();
            }
            n.c(new RunnableC0291a(), 1L);
        }

        public void b() {
            d.g("QMFUTAG", "onADClicked");
            l.i(a.this.f15238h, false, true);
            a aVar = a.this;
            k kVar = new k(aVar.f15662c, aVar.f15663d);
            a aVar2 = a.this;
            boolean g2 = kVar.g(aVar2.f15663d, null, 0L, aVar2.f15238h);
            kVar.h();
            if (g2) {
                com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                    ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdClicked();
                }
            }
        }

        public void c(Bundle bundle) {
            d.g("QMFUTAG", "onADClosed");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(1).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdDismissed();
            }
        }

        public void d(String str) {
            d.g("QMFUTAG", "onAdFailed " + str);
            a.this.J(new i(-3000, "广告渲染失败！"));
        }
    }

    class b implements AdRequestParam.ADLoadListener {
        b() {
        }

        public void a(IMultiAdObject iMultiAdObject) {
            d.g("QMFUTAG", "onInterstitialAdLoad");
            if (iMultiAdObject == null) {
                a.this.J(new i(-3000, "广告数据为空！"));
                return;
            }
            a.this.f15236f = iMultiAdObject;
            int c2 = com.martian.ttbook.b.c.a.a.b.a.d.a.b.c(a.this.f15236f);
            if (com.martian.ttbook.b.c.a.a.b.a.d.a.b.f(a.this.f15663d, c2)) {
                a.this.A(c2);
                return;
            }
            a.this.f15237g = true;
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(4).h();
            a aVar2 = a.this;
            com.martian.ttbook.b.c.a.a.b.a.d.a.b.g(aVar2.f15661b, c2, aVar2.f15663d);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.this);
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdLoaded(arrayList);
            }
        }

        public void b(String str) {
            d.g("QMFUTAG", "onError " + str);
            a.this.J(new i(-3000, str));
        }
    }

    class c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Activity f15243a;

        c(Activity activity) {
            this.f15243a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f15236f.showInteractionAd(this.f15243a, a.this.k);
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, e eVar) {
        super(dVar, eVar);
        this.f15237g = false;
        this.f15239j = new AtomicBoolean();
        this.k = new C0290a();
        this.f15238h = com.martian.ttbook.b.c.a.a.b.n();
    }

    public void J(i iVar) {
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15237g || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.m.a
    public void b() {
        if (this.f15236f != null) {
            this.f15236f = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
        this.f15664e = cVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.m.a
    public void show() {
        Context context = this.f15662c.f15670d;
        if (context instanceof Activity) {
            show((Activity) context);
        } else {
            super.show();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.m.a
    public void show(Activity activity) {
        if (this.f15237g && this.f15236f != null && this.f15239j.compareAndSet(false, true)) {
            if (activity == null) {
                super.show();
                return;
            }
            try {
                activity.getWindow().getDecorView().post(new c(activity));
            } catch (Exception e2) {
                d.g("QMFUTAG", "show #3 " + e2.getMessage());
                this.f15236f.showInteractionAd(activity, this.k);
            }
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        d.g("QMFUTAG", "handle enter");
        IMultiAdRequest e2 = com.martian.ttbook.b.c.a.a.b.a.d.a.b.e(this.f15662c.f15670d, this.f15663d.f15701c.d(e.c.U, ""));
        d.g("QMFUTAG", "handle #3");
        String l = this.f15663d.f15701c.l(e.c.Q);
        this.f15237g = false;
        AdRequestParam.Builder builder = new AdRequestParam.Builder();
        builder.adslotID(l).adType(2).adLoadListener(new b());
        if (e2 != null) {
            e2.invokeADV(builder.build());
        }
        new k(this.f15662c, this.f15663d).a(3).h();
        d.g("QMFUTAG", "load ad");
    }
}
