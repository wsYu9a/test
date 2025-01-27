package com.martian.ttbook.b.c.a.a.b.a.d.x.f;

import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.c.a.a.b;
import com.martian.ttbook.b.c.a.a.b.a.c;
import com.martian.ttbook.b.c.a.a.b.a.d.g;
import com.martian.ttbook.b.c.a.a.c.e;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.d;
import com.opos.acs.st.utils.ErrorContants;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends g {

    /* renamed from: f */
    private FullScreenVideoAd f15461f;

    /* renamed from: g */
    private boolean f15462g;

    /* renamed from: h */
    private Object[] f15463h;

    /* renamed from: j */
    private AtomicBoolean f15464j;
    private FullScreenVideoAd.FullScreenVideoAdListener k;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.x.f.a$a */
    class C0325a implements FullScreenVideoAd.FullScreenVideoAdListener {

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.x.f.a$a$a */
        class RunnableC0326a implements Runnable {
            RunnableC0326a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                Object obj = aVar.f15662c.f15668b;
                Object[] objArr = aVar.f15463h;
                a aVar2 = a.this;
                l.o(obj, objArr, aVar2.f15662c.f15671e, Integer.valueOf(aVar2.f15663d.f()));
                a aVar3 = a.this;
                l.s(aVar3.f15662c.f15668b, aVar3.f15663d.e(), a.this.f15663d.b());
                byte[] h2 = a.this.f15662c.r.h();
                if (h2 != null) {
                    l.j(a.this.f15662c.f15668b, h2);
                }
                l.i(a.this.f15463h, true, true);
            }
        }

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.x.f.a$a$b */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l.q(a.this.f15463h, 2);
            }
        }

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.x.f.a$a$c */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l.q(a.this.f15463h, 2);
            }
        }

        C0325a() {
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClick() {
            d.g("BDINTAG", "onADClicked");
            l.i(a.this.f15463h, false, true);
            a aVar = a.this;
            k kVar = new k(aVar.f15662c, aVar.f15663d);
            a aVar2 = a.this;
            boolean g2 = kVar.g(aVar2.f15663d, null, 0L, aVar2.f15463h);
            kVar.h();
            if (g2) {
                e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                    ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdClicked();
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClose(float f2) {
            d.g("BDINTAG", "onADClosed playScale = " + f2);
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(1).h();
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdDismissed();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdFailed(String str) {
            d.g("BDINTAG", "failed " + str);
            a.this.I(new i(-3000, str));
        }

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdLoaded() {
            d.g("BDINTAG", "onADReceive");
            int b2 = com.martian.ttbook.b.c.a.a.b.a.d.x.a.b(a.this.f15461f);
            if (com.martian.ttbook.b.c.a.a.b.a.d.x.a.f(a.this.f15663d, b2)) {
                a.this.A(0);
                return;
            }
            a.this.B(b2);
            a.this.f15462g = true;
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(4).h();
            a aVar2 = a.this;
            com.martian.ttbook.b.c.a.a.b.a.d.x.a.g(aVar2.f15661b, b2, aVar2.f15663d);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.this);
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdLoaded(arrayList);
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdShow() {
            d.g("BDINTAG", "onAdShow");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(5).c(k.b.q, a.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdShow();
                ((com.martian.ttbook.b.c.a.a.c.m.b) a.this.f15662c.f15673g).onAdExposed();
            }
            n.c(new RunnableC0326a(), 1L);
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdSkip(float f2) {
            d.g("BDINTAG", "onAdSkip playScale = " + f2);
            n.c(new c(), 1000L);
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadFailed() {
            d.g("BDINTAG", "onVideoDownloadFailed");
            a.this.I(new i(-3000, "广告视频素材下载失败"));
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadSuccess() {
            d.g("BDINTAG", "onVideoDownloadSuccess");
            if (a.this.f15462g) {
                com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                    ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).b();
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void playCompletion() {
            d.g("BDINTAG", "playCompletion");
            n.c(new b(), 1000L);
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdVideoCompleted();
            }
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15462g = false;
        this.f15464j = new AtomicBoolean();
        this.k = new C0325a();
        this.f15463h = b.n();
    }

    public void I(i iVar) {
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15462g || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.e(this.f15461f, "203");
    }

    @Override // com.martian.ttbook.b.c.a.a.c.m.a
    public void b() {
        if (this.f15461f != null) {
            this.f15461f = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(c cVar) {
        this.f15664e = cVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        d.h("win " + i2);
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.d(this.f15461f, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.m.a
    public void show() {
        if (this.f15462g && this.f15461f != null && this.f15464j.compareAndSet(false, true)) {
            d.g("BDINTAG", "show #1 ");
            this.f15461f.show();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        if (x()) {
            return;
        }
        String d2 = this.f15663d.f15701c.d(e.c.U, "");
        com.martian.ttbook.b.c.a.a.b.a.d.n.a(this.f15662c.f15670d, d2);
        FullScreenVideoAd fullScreenVideoAd = new FullScreenVideoAd(this.f15662c.f15670d.getApplicationContext(), this.f15663d.f15701c.l(e.c.Q), this.k);
        this.f15461f = fullScreenVideoAd;
        fullScreenVideoAd.setAppSid(d2);
        this.f15462g = false;
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15461f.load();
        d.g("BDINTAG", "load enter");
    }
}
