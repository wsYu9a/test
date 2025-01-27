package com.aggmoread.sdk.z.d.a.a.d.a.d.q.h;

import android.content.Context;
import com.aggmoread.sdk.z.d.a.a.d.a.c;
import com.aggmoread.sdk.z.d.a.a.d.a.d.i;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.f;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends i implements RewardVideoAd.RewardVideoAdListener {

    /* renamed from: r */
    private RewardVideoAd f5512r;

    /* renamed from: s */
    private AtomicBoolean f5513s;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.h.a$a */
    public class RunnableC0138a implements Runnable {
        public RunnableC0138a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.a(((i) a.this).f5364o, 2);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.a(((i) a.this).f5364o, 2);
        }
    }

    public a(d dVar, e eVar) {
        super(dVar, eVar);
        this.f5513s = new AtomicBoolean();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.i, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(c cVar) {
        this.f5844i = cVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5512r, "203");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void c(int i10) {
        com.aggmoread.sdk.z.d.a.a.e.e.c("win " + i10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5512r, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a().a(this.f5512r);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", "handle");
        Context a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5842g, this.f5843h, this.f5846k);
        com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5842g.f5873s;
        String a11 = this.f5843h.f5907c.a(e.c.X, "");
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(a10, a11);
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", "mute = " + (bVar != null ? bVar.d() : true));
        Context applicationContext = a10.getApplicationContext();
        f fVar = this.f5843h.f5907c;
        Object obj = e.c.T;
        RewardVideoAd rewardVideoAd = new RewardVideoAd(applicationContext, fVar.a(obj, ""), this);
        this.f5512r = rewardVideoAd;
        rewardVideoAd.setAppSid(a11);
        this.f5365p = false;
        if (this.f5842g.f5870p != null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", "set ssv");
            String e10 = this.f5842g.f5870p.e();
            String a12 = this.f5842g.f5870p.a();
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", "u = " + e10 + ", cd = " + a12);
            String a13 = m.a(a12, this.f5843h.f5907c.c(obj));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" _extrasInfo = ");
            sb2.append(a13);
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", sb2.toString());
            this.f5512r.setUserId(e10);
            this.f5512r.setExtraInfo(a13);
        }
        new k(this.f5842g, this.f5843h).a(0).b();
        try {
            RequestParameters.Builder builder = new RequestParameters.Builder();
            com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(builder, this.f5842g, this.f5843h);
            com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5512r, builder.build());
        } catch (Exception unused) {
        }
        this.f5512r.load();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdClick() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", "onADClick");
        q();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdClose(float f10) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", "onADClose " + f10);
        r();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdFailed(String str) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", "onAdFailed " + str);
        b(new com.aggmoread.sdk.z.d.a.a.d.b.i(-1000, str));
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdLoaded() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", "onADLoad");
        int a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a((Object) this.f5512r);
        if (com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5843h, a10)) {
            a(a10, 0);
            return;
        }
        b(a10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.b(this.f5841f, a10, this.f5843h);
        d(1);
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdShow() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", "onADShow");
        d dVar = this.f5842g;
        l.a(dVar.f5856b, this.f5364o, dVar.f5859e, Integer.valueOf(this.f5843h.f()));
        l.b(this.f5842g.f5856b, this.f5843h.e(), this.f5843h.b());
        if (this.f5842g.e() != null) {
            d dVar2 = this.f5842g;
            l.a(dVar2.f5856b, dVar2.e());
        }
        byte[] b10 = this.f5842g.f5872r.b();
        if (b10 != null) {
            l.a(this.f5842g.f5856b, b10);
        }
        l.a((Object) this.f5364o, true, true);
        l.a(this.f5364o, this.f5843h);
        t();
        s();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onAdSkip(float f10) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", "onAdSkip " + f10);
        n.a(new b(), 1000L);
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
    public void onRewardVerify(boolean z10) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", "reward onReward " + z10);
        l.a(this.f5364o, 1);
        b(this.f5363n);
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onVideoDownloadFailed() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", "onVideoDownloadFailed");
        b(new com.aggmoread.sdk.z.d.a.a.d.b.i(-1000, "视频素材缓存失败"));
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void onVideoDownloadSuccess() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", "onVideoDownloadSuccess");
        u();
    }

    @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
    public void playCompletion() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", "playCompletion");
        n.a(new RunnableC0138a(), 1000L);
        a((Map<String, Object>) null);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.i
    public void v() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGBD", "showInner " + this.f5365p);
        if (this.f5365p && this.f5512r != null && this.f5513s.compareAndSet(false, true)) {
            com.aggmoread.sdk.z.d.a.a.d.a.d.u.a.a(this.f5512r, k());
            this.f5512r.show();
        }
    }
}
