package com.martian.ttbook.b.c.a.a.d.a.d.x.g;

import android.app.Activity;
import android.content.Context;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.c.a.a.b.a.d.h;
import com.martian.ttbook.b.c.a.a.c.e;
import com.martian.ttbook.b.c.a.a.c.j;
import com.martian.ttbook.b.c.a.a.c.q.b;
import com.martian.ttbook.b.c.a.a.d.a.d.x.d;
import com.martian.ttbook.b.c.a.a.d.a.d.x.g.b;
import com.martian.ttbook.b.c.a.a.d.a.d.x.g.c;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.d;
import com.martian.ttbook.sdk.client.AdExtras;
import com.opos.acs.st.utils.ErrorContants;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends h {

    /* renamed from: f */
    private UnifiedInterstitialAD f15641f;

    /* renamed from: g */
    private boolean f15642g;

    /* renamed from: h */
    private Object[] f15643h;

    /* renamed from: j */
    private AtomicBoolean f15644j;
    private boolean k;
    private b.a l;
    private c.a m;
    final com.martian.ttbook.b.c.a.a.c.q.b n;

    /* renamed from: com.martian.ttbook.b.c.a.a.d.a.d.x.g.a$a */
    class C0351a implements b.a {

        /* renamed from: com.martian.ttbook.b.c.a.a.d.a.d.x.g.a$a$a */
        class RunnableC0352a implements Runnable {

            /* renamed from: com.martian.ttbook.b.c.a.a.d.a.d.x.g.a$a$a$a */
            class RunnableC0353a implements Runnable {
                RunnableC0353a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    l.q(a.this.f15643h, 2);
                }
            }

            RunnableC0352a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                Object obj = aVar.f15662c.f15668b;
                Object[] objArr = aVar.f15643h;
                a aVar2 = a.this;
                l.o(obj, objArr, aVar2.f15662c.f15671e, Integer.valueOf(aVar2.f15663d.f()));
                a aVar3 = a.this;
                l.s(aVar3.f15662c.f15668b, aVar3.f15663d.e(), a.this.f15663d.b());
                byte[] h2 = a.this.f15662c.r.h();
                if (h2 != null) {
                    l.j(a.this.f15662c.f15668b, h2);
                }
                l.i(a.this.f15643h, true, true);
                n.c(new RunnableC0353a(), 500L);
            }
        }

        C0351a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void a() {
            d.g("GDTINTAG", "onADLeftApplication");
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).a();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void b() {
            d.g("GDTINTAG", "onADReceive");
            int b2 = com.martian.ttbook.b.c.a.a.d.a.d.x.c.b(a.this.f15641f);
            if (com.martian.ttbook.b.c.a.a.d.a.d.x.c.e(a.this.f15663d, b2)) {
                a.this.A(0);
                a.this.k = false;
                return;
            }
            a.this.B(b2);
            a aVar = a.this;
            aVar.f15661b.put(AdExtras.EXTRA_APP_INFOURL, com.martian.ttbook.b.c.a.a.d.a.d.x.a.b(aVar.f15641f));
            a aVar2 = a.this;
            com.martian.ttbook.b.c.a.a.d.a.d.x.c.d(aVar2.f15661b, aVar2.f15641f, a.this.f15663d);
            if (a.this.k) {
                return;
            }
            a.this.f15642g = true;
            a aVar3 = a.this;
            new k(aVar3.f15662c, aVar3.f15663d).a(4).h();
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.this);
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdLoaded(arrayList);
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void c() {
            d.g("GDTINTAG", "onADClosed");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(1).h();
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdDismissed();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void d() {
            d.g("GDTINTAG", "onRenderSuccess");
            if (a.this.k) {
                a.this.f15642g = true;
                a aVar = a.this;
                new k(aVar.f15662c, aVar.f15663d).a(4).h();
                ArrayList arrayList = new ArrayList();
                arrayList.add(a.this);
                e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                    ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdLoaded(arrayList);
                }
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void e() {
            d.g("GDTINTAG", "onRenderFail");
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void f() {
            d.g("GDTINTAG", "onADOpened");
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdShow();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void onADClicked() {
            d.g("GDTINTAG", "onADClicked");
            l.i(a.this.f15643h, false, true);
            a aVar = a.this;
            k kVar = new k(aVar.f15662c, aVar.f15663d);
            a aVar2 = a.this;
            boolean g2 = kVar.g(aVar2.f15663d, null, 0L, aVar2.f15643h);
            kVar.h();
            if (g2) {
                e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                    ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdClicked();
                }
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void onADExposure() {
            d.g("GDTINTAG", "onADExposure");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(5).c(k.b.q, a.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdExposed();
            }
            n.c(new RunnableC0352a(), 1L);
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void onNoAD(AdError adError) {
            d.g("GDTINTAG", "onNoAD");
            a.this.J(new i(adError.getErrorCode(), adError.getErrorMsg()));
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void onVideoCached() {
            d.g("GDTINTAG", "onVideoCached");
            if (a.this.f15642g) {
                com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                    ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).b();
                }
            }
        }
    }

    class b implements c.a {

        /* renamed from: com.martian.ttbook.b.c.a.a.d.a.d.x.g.a$b$a */
        class RunnableC0354a implements Runnable {
            RunnableC0354a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ((j) a.this.f15662c.f15674h).onVideoPageClose();
            }
        }

        b() {
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.c.a
        public void onVideoComplete() {
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15674h;
            if (eVar instanceof j) {
                ((j) eVar).onVideoComplete();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.c.a
        public void onVideoError(AdError adError) {
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15674h;
            if (eVar instanceof j) {
                eVar.a(new i(adError.getErrorCode(), adError.getErrorMsg()));
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.c.a
        public void onVideoInit() {
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15674h;
            if (eVar instanceof j) {
                ((j) eVar).onVideoInit();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.c.a
        public void onVideoLoading() {
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15674h;
            if (eVar instanceof j) {
                ((j) eVar).onVideoLoading();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.c.a
        public void onVideoPageClose() {
            if (a.this.f15662c.f15674h instanceof j) {
                com.martian.ttbook.b.c.a.a.e.j.b(new RunnableC0354a(), 2L);
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.c.a
        public void onVideoPageOpen() {
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15674h;
            if (eVar instanceof j) {
                ((j) eVar).onVideoPageOpen();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.c.a
        public void onVideoPause() {
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15674h;
            if (eVar instanceof j) {
                ((j) eVar).onVideoPause();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.c.a
        public void onVideoReady(long j2) {
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15674h;
            if (eVar instanceof j) {
                ((j) eVar).onVideoReady(j2);
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.c.a
        public void onVideoStart() {
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15674h;
            if (eVar instanceof j) {
                ((j) eVar).onVideoStart();
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Activity f15650a;

        c(Activity activity) {
            this.f15650a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f15641f != null) {
                a.this.f15641f.show(this.f15650a);
            }
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15642g = false;
        this.f15644j = new AtomicBoolean();
        this.k = true;
        this.l = new C0351a();
        this.m = new b();
        this.n = new b.C0342b().h(1).a(1).b(true).c();
        this.f15643h = com.martian.ttbook.b.c.a.a.b.n();
    }

    public void J(i iVar) {
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15642g || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.e.i.d(this.f15641f, i3, i2, str);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public void b() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f15641f;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.close();
            this.f15641f.destroy();
            this.f15641f.setMediaListener(null);
            this.f15641f = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
        this.f15664e = cVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public int getAdPatternType() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f15641f;
        if (unifiedInterstitialAD == null) {
            return 0;
        }
        int adPatternType = unifiedInterstitialAD.getAdPatternType();
        int i2 = 1;
        if (adPatternType != 1) {
            i2 = 2;
            if (adPatternType != 2) {
                i2 = 3;
                if (adPatternType != 3) {
                    i2 = 4;
                    if (adPatternType != 4) {
                        return 0;
                    }
                }
            }
        }
        return i2;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        com.martian.ttbook.b.c.a.a.e.i.c(this.f15641f, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public void show() {
        if (!(this.f15662c.f15670d instanceof Activity)) {
            super.show();
            return;
        }
        if (this.f15642g && this.f15641f != null && this.f15644j.compareAndSet(false, true)) {
            com.martian.ttbook.b.c.a.a.d.a.d.x.a.e(this.f15641f, this.f15664e);
            d.g("GDTINTAG", "show #1 ");
            this.f15641f.show();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public void show(Activity activity) {
        d.g("GDTINTAG", "show #2 activity = " + activity);
        if (this.f15642g && this.f15641f != null && this.f15644j.compareAndSet(false, true)) {
            d.g("GDTINTAG", "show #2 ");
            if (activity == null) {
                super.show();
                return;
            }
            com.martian.ttbook.b.c.a.a.d.a.d.x.a.e(this.f15641f, this.f15664e);
            try {
                activity.getWindow().getDecorView().post(new c(activity));
            } catch (Exception e2) {
                d.g("GDTINTAG", "show #3 " + e2.getMessage());
                UnifiedInterstitialAD unifiedInterstitialAD = this.f15641f;
                if (unifiedInterstitialAD != null) {
                    unifiedInterstitialAD.show(activity);
                }
            }
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        Context context = this.f15662c.f15670d;
        com.martian.ttbook.b.c.a.a.e.e eVar = this.f15663d.f15701c;
        Object obj = e.c.U;
        com.martian.ttbook.b.c.a.a.b.a.d.n.f(context, eVar.d(obj, ""));
        UnifiedInterstitialAD unifiedInterstitialAD = (UnifiedInterstitialAD) com.martian.ttbook.b.c.a.a.d.a.d.x.d.b(d.e.INTERSTITIAL, this.f15662c.f15670d, this.f15663d.f15701c.l(obj), this.f15663d.f15701c.l(e.c.Q), new com.martian.ttbook.b.c.a.a.d.a.d.x.g.b(this.l).a(), new Object[0]);
        this.f15641f = unifiedInterstitialAD;
        com.martian.ttbook.b.c.a.a.d.a.d.x.g.c cVar = new com.martian.ttbook.b.c.a.a.d.a.d.x.g.c(this.m);
        if (this.f15662c.f15674h != null) {
            unifiedInterstitialAD.setMediaListener(cVar.a());
        }
        com.martian.ttbook.b.c.a.a.c.q.b bVar = this.f15662c.s;
        if (bVar == null) {
            bVar = this.n;
        }
        this.f15641f.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(bVar.k()).setAutoPlayPolicy(bVar.a()).build());
        this.f15642g = false;
        this.k = com.martian.ttbook.b.c.a.a.e.i.i("4.371");
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15641f.loadAD();
        com.martian.ttbook.b.c.a.a.e.d.g("GDTINTAG", "load enter");
    }
}
