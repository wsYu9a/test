package com.martian.ttbook.b.c.a.a.d.a.d.x.f;

import android.app.Activity;
import android.content.Context;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.c.a.a.b.a.d.g;
import com.martian.ttbook.b.c.a.a.c.e;
import com.martian.ttbook.b.c.a.a.c.q.b;
import com.martian.ttbook.b.c.a.a.d.a.d.x.c;
import com.martian.ttbook.b.c.a.a.d.a.d.x.d;
import com.martian.ttbook.b.c.a.a.d.a.d.x.g.b;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.sdk.client.AdExtras;
import com.opos.acs.st.utils.ErrorContants;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends g {

    /* renamed from: f */
    private UnifiedInterstitialAD f15634f;

    /* renamed from: g */
    private boolean f15635g;

    /* renamed from: h */
    private Object[] f15636h;

    /* renamed from: j */
    private AtomicBoolean f15637j;
    private b.a k;
    final com.martian.ttbook.b.c.a.a.c.q.b l;

    /* renamed from: com.martian.ttbook.b.c.a.a.d.a.d.x.f.a$a */
    class C0349a implements b.a {

        /* renamed from: com.martian.ttbook.b.c.a.a.d.a.d.x.f.a$a$a */
        class RunnableC0350a implements Runnable {
            RunnableC0350a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                Object obj = aVar.f15662c.f15668b;
                Object[] objArr = aVar.f15636h;
                a aVar2 = a.this;
                l.o(obj, objArr, aVar2.f15662c.f15671e, Integer.valueOf(aVar2.f15663d.f()));
                a aVar3 = a.this;
                l.s(aVar3.f15662c.f15668b, aVar3.f15663d.e(), a.this.f15663d.b());
                byte[] h2 = a.this.f15662c.r.h();
                if (h2 != null) {
                    l.j(a.this.f15662c.f15668b, h2);
                }
                l.i(a.this.f15636h, true, true);
                l.q(a.this.f15636h, 2);
            }
        }

        C0349a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void a() {
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).a();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void b() {
            int b2 = c.b(a.this.f15634f);
            if (c.e(a.this.f15663d, b2)) {
                a.this.A(0);
                return;
            }
            a.this.B(b2);
            a.this.f15635g = true;
            a aVar = a.this;
            aVar.f15661b.put(AdExtras.EXTRA_APP_INFOURL, com.martian.ttbook.b.c.a.a.d.a.d.x.a.b(aVar.f15634f));
            a aVar2 = a.this;
            c.d(aVar2.f15661b, aVar2.f15634f, a.this.f15663d);
            a aVar3 = a.this;
            new k(aVar3.f15662c, aVar3.f15663d).a(4).h();
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.this);
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdLoaded(arrayList);
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void c() {
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(1).h();
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdDismissed();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void d() {
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void e() {
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void f() {
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdShow();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void onADClicked() {
            l.i(a.this.f15636h, false, true);
            a aVar = a.this;
            k kVar = new k(aVar.f15662c, aVar.f15663d);
            a aVar2 = a.this;
            boolean g2 = kVar.g(aVar2.f15663d, null, 0L, aVar2.f15636h);
            kVar.h();
            if (g2) {
                e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                    ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdClicked();
                }
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void onADExposure() {
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(5).c(k.b.q, a.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdExposed();
            }
            n.c(new RunnableC0350a(), 1L);
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void onNoAD(AdError adError) {
            a.this.I(new i(adError.getErrorCode(), adError.getErrorMsg()));
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.g.b.a
        public void onVideoCached() {
            if (a.this.f15635g) {
                com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                    ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).b();
                }
            }
        }
    }

    class b implements d.InterfaceC0348d {
        b() {
        }

        @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.d.InterfaceC0348d
        public void onReward(Map<String, Object> map) {
            if (a.this.f15662c.p.e() != null) {
                a.this.f15662c.p.e().onReward(map);
            }
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15635g = false;
        this.f15637j = new AtomicBoolean();
        this.k = new C0349a();
        this.l = new b.C0342b().h(1).a(1).b(true).c();
        this.f15636h = com.martian.ttbook.b.c.a.a.b.n();
    }

    public void I(i iVar) {
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15635g || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.e.i.d(this.f15634f, i3, i2, str);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.m.a
    public void b() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f15634f;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.close();
            this.f15634f.destroy();
            this.f15634f = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
        this.f15664e = cVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        com.martian.ttbook.b.c.a.a.e.i.c(this.f15634f, i2);
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
        if (this.f15635g && this.f15634f != null && this.f15637j.compareAndSet(false, true)) {
            com.martian.ttbook.b.c.a.a.e.d.g("GDTFUTAG", "show #2 ");
            if (activity == null) {
                super.show();
            } else {
                com.martian.ttbook.b.c.a.a.d.a.d.x.a.e(this.f15634f, this.f15664e);
                this.f15634f.showFullScreenAD(activity);
            }
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        Context context = this.f15662c.f15670d;
        com.martian.ttbook.b.c.a.a.e.e eVar = this.f15663d.f15701c;
        Object obj = e.c.U;
        com.martian.ttbook.b.c.a.a.b.a.d.n.f(context, eVar.d(obj, ""));
        com.martian.ttbook.b.c.a.a.d.a.d.x.g.b bVar = new com.martian.ttbook.b.c.a.a.d.a.d.x.g.b(this.k);
        d.e eVar2 = d.e.FULLSCREEN;
        Context context2 = this.f15662c.f15670d;
        String l = this.f15663d.f15701c.l(obj);
        com.martian.ttbook.b.c.a.a.e.e eVar3 = this.f15663d.f15701c;
        Object obj2 = e.c.Q;
        this.f15634f = (UnifiedInterstitialAD) d.b(eVar2, context2, l, eVar3.l(obj2), bVar.a(), new Object[0]);
        com.martian.ttbook.b.c.a.a.c.q.b bVar2 = this.f15662c.s;
        if (bVar2 == null) {
            bVar2 = this.l;
        }
        this.f15634f.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(bVar2.k()).setAutoPlayPolicy(bVar2.a()).build());
        boolean i2 = com.martian.ttbook.b.c.a.a.e.i.i("4.390");
        com.martian.ttbook.b.c.a.a.e.d.g("GDTFUTAG", "reward " + i2);
        if (i2) {
            String g2 = this.f15662c.p.g();
            String a2 = this.f15662c.p.a();
            com.martian.ttbook.b.c.a.a.e.d.g("GDTFUTAG", "u = " + g2 + ", cd = " + a2);
            String b2 = com.martian.ttbook.b.c.a.a.e.i.b(a2, this.f15663d.f15701c.l(obj2));
            StringBuilder sb = new StringBuilder();
            sb.append(" _extrasInfo = ");
            sb.append(b2);
            com.martian.ttbook.b.c.a.a.e.d.g("GDTFUTAG", sb.toString());
            this.f15634f.setServerSideVerificationOptions(new ServerSideVerificationOptions.Builder().setUserId(g2).setCustomData(b2).build());
            d.d(this.f15634f, new b());
        }
        this.f15635g = false;
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15634f.loadFullScreenAD();
    }
}
