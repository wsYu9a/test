package com.martian.ttbook.b.c.a.a.b.a.d.x.g;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.c.a.a.b.a.d.h;
import com.martian.ttbook.b.c.a.a.b.a.d.x.c;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.d;
import com.opos.acs.st.utils.ErrorContants;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends h {

    /* renamed from: f */
    private ExpressInterstitialAd f15469f;

    /* renamed from: g */
    private boolean f15470g;

    /* renamed from: h */
    private Object[] f15471h;

    /* renamed from: j */
    private AtomicBoolean f15472j;
    private c.d k;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.x.g.a$a */
    class C0327a implements c.d {

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.x.g.a$a$a */
        class RunnableC0328a implements Runnable {

            /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.x.g.a$a$a$a */
            class RunnableC0329a implements Runnable {
                RunnableC0329a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    l.q(a.this.f15471h, 2);
                }
            }

            RunnableC0328a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                Object obj = aVar.f15662c.f15668b;
                Object[] objArr = aVar.f15471h;
                a aVar2 = a.this;
                l.o(obj, objArr, aVar2.f15662c.f15671e, Integer.valueOf(aVar2.f15663d.f()));
                a aVar3 = a.this;
                l.s(aVar3.f15662c.f15668b, aVar3.f15663d.e(), a.this.f15663d.b());
                byte[] h2 = a.this.f15662c.r.h();
                if (h2 != null) {
                    l.j(a.this.f15662c.f15668b, h2);
                }
                l.i(a.this.f15471h, true, true);
                n.c(new RunnableC0329a(), 3000L);
            }
        }

        C0327a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.c.d
        public void a() {
            d.g("BDINTAG", "onADExposureFailed");
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.c.d
        public void a(int i2, String str) {
            d.g("BDINTAG", "onAdFailed " + i2 + ", " + str);
            a.this.I(new i(i2, str));
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.c.d
        public void onADExposed() {
            d.g("BDINTAG", "onADExposure");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(5).c(k.b.q, a.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdShow();
                ((com.martian.ttbook.b.c.a.a.c.n.b) a.this.f15662c.f15673g).onAdExposed();
            }
            n.c(new RunnableC0328a(), 1L);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.c.d
        public void onADLoaded() {
            d.g("BDINTAG", "onADReceive");
            int b2 = com.martian.ttbook.b.c.a.a.b.a.d.x.a.b(a.this.f15469f);
            if (com.martian.ttbook.b.c.a.a.b.a.d.x.a.f(a.this.f15663d, b2)) {
                a.this.A(0);
            } else {
                a.this.B(b2);
                a.this.f15470g = true;
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.c.d
        public void onAdCacheFailed() {
            d.g("BDINTAG", "onAdCacheFailed");
            a.this.I(new i(-3000, "广告视频素材下载失败"));
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.c.d
        public void onAdCacheSuccess() {
            d.g("BDINTAG", "onAdCacheSuccess");
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.c.d
        public void onAdClick() {
            d.g("BDINTAG", "onADClicked");
            l.i(a.this.f15471h, false, true);
            a aVar = a.this;
            k kVar = new k(aVar.f15662c, aVar.f15663d);
            a aVar2 = a.this;
            boolean g2 = kVar.g(aVar2.f15663d, null, 0L, aVar2.f15471h);
            kVar.h();
            if (g2) {
                com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                    ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdClicked();
                }
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.c.d
        public void onAdClose() {
            d.g("BDINTAG", "onADClosed");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(1).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdDismissed();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.c.d
        public void onLpClosed() {
            d.g("BDINTAG", "onLpClosed");
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.c.d
        public void onNoAd(int i2, String str) {
            d.g("BDINTAG", "onNoAD " + i2 + ", " + str);
            a.this.I(new i(i2, str));
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.c.d
        public void onVideoDownloadFailed() {
            d.g("BDINTAG", "onVideoDownloadFailed");
            a.this.I(new i(-3000, "广告视频素材下载失败"));
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.x.c.d
        public void onVideoDownloadSuccess() {
            d.g("BDINTAG", "onVideoDownloadSuccess");
            if (a.this.f15470g) {
                a aVar = a.this;
                new k(aVar.f15662c, aVar.f15663d).a(4).h();
                a aVar2 = a.this;
                com.martian.ttbook.b.c.a.a.b.a.d.x.a.g(aVar2.f15661b, com.martian.ttbook.b.c.a.a.b.a.d.x.a.b(aVar2.f15469f), a.this.f15663d);
                ArrayList arrayList = new ArrayList();
                arrayList.add(a.this);
                com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                    ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdLoaded(arrayList);
                    ((com.martian.ttbook.b.c.a.a.c.n.b) a.this.f15662c.f15673g).b();
                }
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Activity f15476a;

        b(Activity activity) {
            this.f15476a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f15469f != null) {
                a.this.f15469f.show(this.f15476a);
            }
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, e eVar) {
        super(dVar, eVar);
        this.f15470g = false;
        this.f15472j = new AtomicBoolean();
        this.k = new C0327a();
        this.f15471h = com.martian.ttbook.b.c.a.a.b.n();
    }

    public void I(i iVar) {
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15470g || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.e(this.f15469f, "203");
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public void b() {
        ExpressInterstitialAd expressInterstitialAd = this.f15469f;
        if (expressInterstitialAd != null) {
            expressInterstitialAd.destroy();
            this.f15469f = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
        this.f15664e = cVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        d.h("win " + i2);
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.d(this.f15469f, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public void show() {
        d.g("BDINTAG", "show()");
        Context context = this.f15662c.f15670d;
        if (context instanceof Activity) {
            show((Activity) context);
        } else {
            super.show();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public void show(Activity activity) {
        d.g("BDINTAG", "show #2 activity = " + activity);
        if (this.f15470g && this.f15469f != null && this.f15472j.compareAndSet(false, true)) {
            d.g("BDINTAG", "show #2 ");
            if (activity == null) {
                super.show();
                return;
            }
            try {
                activity.getWindow().getDecorView().post(new b(activity));
            } catch (Exception e2) {
                d.g("BDINTAG", "show #3 " + e2.getMessage());
                ExpressInterstitialAd expressInterstitialAd = this.f15469f;
                if (expressInterstitialAd != null) {
                    expressInterstitialAd.show(activity);
                }
            }
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        String d2 = this.f15663d.f15701c.d(e.c.U, "");
        com.martian.ttbook.b.c.a.a.b.a.d.n.a(this.f15662c.f15670d, d2);
        ExpressInterstitialAd expressInterstitialAd = new ExpressInterstitialAd(this.f15662c.f15670d.getApplicationContext(), this.f15663d.f15701c.l(e.c.Q));
        this.f15469f = expressInterstitialAd;
        expressInterstitialAd.setLoadListener(c.c().a(this.k));
        this.f15469f.setAppSid(d2);
        this.f15470g = false;
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15469f.load();
        d.g("BDINTAG", "load enter");
    }
}
