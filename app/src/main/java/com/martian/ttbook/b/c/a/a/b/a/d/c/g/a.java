package com.martian.ttbook.b.c.a.a.b.a.d.c.g;

import android.app.Activity;
import android.content.Context;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.c.a.a.b.a.d.j;
import com.martian.ttbook.b.c.a.a.b.a.d.o;
import com.martian.ttbook.b.c.a.a.b.a.d.q;
import com.martian.ttbook.b.c.a.a.b.a.d.u;
import com.martian.ttbook.b.c.a.a.c.e;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.d;
import com.opos.acs.st.utils.ErrorContants;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.reward.UnifiedVivoRewardVideoAd;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends j {

    /* renamed from: f */
    private AtomicBoolean f15395f;

    /* renamed from: g */
    private boolean f15396g;

    /* renamed from: h */
    private UnifiedVivoRewardVideoAd f15397h;

    /* renamed from: j */
    private Object[] f15398j;
    private u k;
    private q l;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.c.g.a$a */
    class C0318a implements u {

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.c.g.a$a$a */
        class RunnableC0319a implements Runnable {
            RunnableC0319a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l.q(a.this.f15398j, 2);
            }
        }

        C0318a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.u
        public void a(i iVar) {
            d.g("VVRETAG", "onAdFailed");
            a.this.L(iVar);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.u
        public void b() {
            d.g("VVRETAG", "onAdVideoCached");
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).b();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.u
        public void onAdClicked() {
            d.g("VVRETAG", "onAdClicked");
            a aVar = a.this;
            k kVar = new k(aVar.f15662c, aVar.f15663d);
            a aVar2 = a.this;
            boolean g2 = kVar.g(aVar2.f15663d, null, 0L, aVar2.f15398j);
            kVar.h();
            if (g2) {
                e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                    ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdClicked();
                }
            }
            l.i(a.this.f15398j, false, true);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.u
        public void onAdDismissed() {
            d.g("VVRETAG", "onAdDismissed");
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdDismissed();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.u
        public void onAdExposed() {
            d.g("VVRETAG", "onAdExposed");
            a aVar = a.this;
            Object obj = aVar.f15662c.f15668b;
            Object[] objArr = aVar.f15398j;
            a aVar2 = a.this;
            l.o(obj, objArr, aVar2.f15662c.f15671e, Integer.valueOf(aVar2.f15663d.f()));
            a aVar3 = a.this;
            l.s(aVar3.f15662c.f15668b, aVar3.f15663d.e(), a.this.f15663d.b());
            if (a.this.f15662c.m() != null) {
                com.martian.ttbook.b.c.a.a.d.b.d dVar = a.this.f15662c;
                l.k(dVar.f15668b, dVar.m());
            }
            byte[] h2 = a.this.f15662c.r.h();
            if (h2 != null) {
                l.j(a.this.f15662c.f15668b, h2);
            }
            l.i(a.this.f15398j, true, true);
            a aVar4 = a.this;
            new k(aVar4.f15662c, aVar4.f15663d).a(5).c(k.b.q, a.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdShow();
                ((com.martian.ttbook.b.c.a.a.c.o.b) a.this.f15662c.f15673g).onAdExposed();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.u
        public void onAdLoaded() {
            d.g("VVRETAG", "onAdLoaded");
            int c2 = com.martian.ttbook.b.c.a.a.b.a.d.c.b.c(a.this.f15397h);
            if (com.martian.ttbook.b.c.a.a.b.a.d.c.b.i(a.this.f15663d, c2)) {
                a.this.A(0);
                return;
            }
            a.this.B(c2);
            a.this.f15396g = true;
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(4).h();
            a aVar2 = a.this;
            com.martian.ttbook.b.c.a.a.b.a.d.c.b.k(aVar2.f15661b, c2, aVar2.f15663d);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.this);
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdLoaded(arrayList);
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.u
        public void onReward() {
            d.g("VVRETAG", "onReward");
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onReward();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.u
        public void onVideoComplete() {
            d.g("VVRETAG", "onVideoComplete");
            n.c(new RunnableC0319a(), 1000L);
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onVideoComplete();
            }
        }
    }

    class b implements q {
        b() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void a(i iVar) {
            a.this.k.a(iVar);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void onVideoComplete() {
            a.this.k.onVideoComplete();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void onVideoPause() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void onVideoReady(long j2) {
            a.this.k.b();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.q
        public void onVideoStart() {
        }
    }

    class c implements o {
        c() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.o
        public void a() {
            d.g("VVRETAG", "init success");
            a.this.N();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.o
        public void b() {
            a.this.L(new i(-1000, "广告加载失败！"));
            d.g("VVRETAG", "returen #1");
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15395f = new AtomicBoolean();
        this.f15396g = false;
        this.f15398j = com.martian.ttbook.b.c.a.a.b.n();
        this.k = new C0318a();
        this.l = new b();
    }

    public void L(i iVar) {
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15396g || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    public void N() {
        AdParams.Builder f2 = com.martian.ttbook.b.c.a.a.b.a.d.c.b.f(this.f15663d);
        if (f2 == null) {
            L(new i(-1001, "广告配置信息解析错误"));
            return;
        }
        UnifiedVivoRewardVideoAd unifiedVivoRewardVideoAd = new UnifiedVivoRewardVideoAd(this.f15662c.f15670d, f2.build(), com.martian.ttbook.b.c.a.a.b.a.d.c.d.a().h(this.k));
        this.f15397h = unifiedVivoRewardVideoAd;
        unifiedVivoRewardVideoAd.setMediaListener(com.martian.ttbook.b.c.a.a.b.a.d.c.d.a().f(this.l));
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15397h.loadAd();
        d.g("VVRETAG", "load ad");
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j
    protected void C(Activity activity) {
        d.g("VVRETAG", "showInner ac " + activity);
        if (this.f15396g && this.f15397h != null && this.f15395f.compareAndSet(false, true)) {
            com.martian.ttbook.b.c.a.a.d.a.d.x.a.e(this.f15397h, this.f15664e);
            this.f15397h.showAd(activity);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j
    public void D() {
        Context context = this.f15662c.f15670d;
        if (context instanceof Activity) {
            show((Activity) context);
        } else {
            super.D();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.b.a.d.c.b.h(this.f15397h, i3);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        d.h("win " + i2);
        com.martian.ttbook.b.c.a.a.b.a.d.c.b.j(this.f15397h, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    protected void w() {
        com.martian.ttbook.b.c.a.a.b.a.d.n.b(this.f15662c.f15670d.getApplicationContext(), this.f15663d.f15701c.d(e.c.U, ""), new c());
    }
}
