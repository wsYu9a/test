package com.martian.ttbook.b.c.a.a.b.a.d.x.h;

import android.content.Context;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.c.a.a.b.a.c;
import com.martian.ttbook.b.c.a.a.b.a.d.j;
import com.martian.ttbook.b.c.a.a.d.b.d;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.opos.acs.st.utils.ErrorContants;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends j implements RewardVideoAd.RewardVideoAdListener {

    /* renamed from: f */
    private RewardVideoAd f15478f;

    /* renamed from: g */
    private boolean f15479g;

    /* renamed from: h */
    private AtomicBoolean f15480h;

    /* renamed from: j */
    private Object[] f15481j;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.x.h.a$a */
    class RunnableC0330a implements Runnable {
        RunnableC0330a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.q(a.this.f15481j, 2);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.q(a.this.f15481j, 2);
        }
    }

    public a(d dVar, e eVar) {
        super(dVar, eVar);
        this.f15479g = false;
        this.f15480h = new AtomicBoolean();
        this.f15481j = com.martian.ttbook.b.c.a.a.b.n();
    }

    private void F(i iVar) {
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15479g || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j
    public void D() {
        com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", "showInner ");
        if (this.f15479g && this.f15478f != null && this.f15480h.compareAndSet(false, true)) {
            com.martian.ttbook.b.c.a.a.d.a.d.x.a.e(this.f15478f, this.f15664e);
            this.f15478f.show();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.e(this.f15478f, "203");
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j, com.martian.ttbook.b.c.a.a.c.a
    public void c(c cVar) {
        this.f15664e = cVar;
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdClick() {
        com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", "onADClick");
        k kVar = new k(this.f15662c, this.f15663d);
        boolean g2 = kVar.g(this.f15663d, null, 0L, this.f15481j);
        kVar.h();
        if (g2) {
            com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdClicked();
            }
        }
        l.i(this.f15481j, false, true);
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdClose(float f2) {
        com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", "onADClose " + f2);
        new k(this.f15662c, this.f15663d).a(1).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdDismissed();
        }
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdFailed(String str) {
        com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", "onAdFailed " + str);
        F(new i(-3000, str));
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdLoaded() {
        com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", "onADLoad");
        int b2 = com.martian.ttbook.b.c.a.a.b.a.d.x.a.b(this.f15478f);
        if (com.martian.ttbook.b.c.a.a.b.a.d.x.a.f(this.f15663d, b2)) {
            A(0);
            return;
        }
        B(b2);
        this.f15479g = true;
        new k(this.f15662c, this.f15663d).a(4).h();
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.g(this.f15661b, b2, this.f15663d);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdLoaded(arrayList);
        }
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdShow() {
        com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", "onADShow");
        d dVar = this.f15662c;
        l.o(dVar.f15668b, this.f15481j, dVar.f15671e, Integer.valueOf(this.f15663d.f()));
        l.s(this.f15662c.f15668b, this.f15663d.e(), this.f15663d.b());
        if (this.f15662c.m() != null) {
            d dVar2 = this.f15662c;
            l.k(dVar2.f15668b, dVar2.m());
        }
        byte[] h2 = this.f15662c.r.h();
        if (h2 != null) {
            l.j(this.f15662c.f15668b, h2);
        }
        l.i(this.f15481j, true, true);
        new k(this.f15662c, this.f15663d).a(5).c(k.b.q, this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdShow();
            ((com.martian.ttbook.b.c.a.a.c.o.b) this.f15662c.f15673g).onAdExposed();
        }
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdSkip(float f2) {
        com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", "onAdSkip " + f2);
        n.c(new b(), 1000L);
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
    public void onRewardVerify(boolean z) {
        com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", "reward onReward " + z);
        l.q(this.f15481j, 1);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onReward();
        }
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onVideoDownloadFailed() {
        com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", "onVideoDownloadFailed");
        F(new i(-3000, "广告视频素材下载失败"));
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onVideoDownloadSuccess() {
        com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", "onVideoDownloadSuccess");
        if (this.f15479g) {
            com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).b();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void playCompletion() {
        com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", "playCompletion");
        n.c(new RunnableC0330a(), 1000L);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onVideoComplete();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        com.martian.ttbook.b.c.a.a.e.d.h("win " + i2);
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.d(this.f15478f, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", "handle");
        com.martian.ttbook.b.c.a.a.c.q.b bVar = this.f15662c.s;
        String d2 = this.f15663d.f15701c.d(e.c.U, "");
        com.martian.ttbook.b.c.a.a.b.a.d.n.a(this.f15662c.f15670d, d2);
        com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", "mute = " + (bVar != null ? bVar.k() : true));
        Context applicationContext = this.f15662c.f15670d.getApplicationContext();
        com.martian.ttbook.b.c.a.a.e.e eVar = this.f15663d.f15701c;
        Object obj = e.c.Q;
        RewardVideoAd rewardVideoAd = new RewardVideoAd(applicationContext, eVar.d(obj, ""), this);
        this.f15478f = rewardVideoAd;
        rewardVideoAd.setAppSid(d2);
        this.f15479g = false;
        if (this.f15662c.p != null) {
            com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", "set ssv");
            String g2 = this.f15662c.p.g();
            String a2 = this.f15662c.p.a();
            com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", "u = " + g2 + ", cd = " + a2);
            String b2 = com.martian.ttbook.b.c.a.a.e.i.b(a2, this.f15663d.f15701c.l(obj));
            StringBuilder sb = new StringBuilder();
            sb.append(" _extrasInfo = ");
            sb.append(b2);
            com.martian.ttbook.b.c.a.a.e.d.g("BDRETAG", sb.toString());
            this.f15478f.setUserId(g2);
            this.f15478f.setExtraInfo(b2);
        }
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15478f.load();
    }
}
