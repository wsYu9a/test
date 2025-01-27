package com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.g;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.aggmoread.sdk.client.AMConst;
import com.aggmoread.sdk.z.d.a.a.d.a.d.i;
import com.aggmoread.sdk.z.d.a.a.d.a.d.m;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.g;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.f;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends i implements TTRewardVideoAd.RewardAdInteractionListener {

    /* renamed from: r */
    private TTRewardVideoAd f5635r;

    /* renamed from: s */
    private AtomicBoolean f5636s;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.g.a$a */
    public class C0153a implements TTAdNative.RewardVideoAdListener {
        public C0153a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onError(int i10, String str) {
            a.this.a(i10, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            a.this.f5635r = tTRewardVideoAd;
            a.this.z();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            e.b("AMRTAGCSJ", "onRewardVideoCached #1");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
            e.b("AMRTAGCSJ", "onRewardVideoCached #2");
            a.this.A();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            Object obj = aVar.f5842g.f5856b;
            Object[] objArr = ((i) aVar).f5364o;
            a aVar2 = a.this;
            l.a(obj, objArr, aVar2.f5842g.f5859e, Integer.valueOf(aVar2.f5843h.f()));
            a aVar3 = a.this;
            l.b(aVar3.f5842g.f5856b, aVar3.f5843h.e(), a.this.f5843h.b());
            byte[] b10 = a.this.f5842g.f5872r.b();
            if (b10 != null) {
                l.a(a.this.f5842g.f5856b, b10);
            }
            l.a((Object) ((i) a.this).f5364o, true, true);
            l.a(((i) a.this).f5364o, a.this.f5843h);
        }
    }

    public a(d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5636s = new AtomicBoolean();
    }

    private void B() {
        com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b.a(this.f5841f, this.f5635r);
    }

    private void c(Activity activity) {
        e.b("AMRTAGCSJ", "showAd activity = " + activity);
        if (this.f5635r == null || !this.f5636s.compareAndSet(false, true)) {
            return;
        }
        e.b("AMRTAGCSJ", "show");
        this.f5635r.setRewardAdInteractionListener(this);
        this.f5635r.showRewardVideoAd(activity);
    }

    private Activity w() {
        return m.a(this.f5842g.f5858d);
    }

    private int x() {
        return this.f5842g.f5858d.getResources().getConfiguration().orientation == 2 ? 2 : 1;
    }

    private void y() {
        com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5842g.f5873s;
        boolean d10 = bVar != null ? bVar.d() : true;
        Activity w10 = w();
        if (w10 == null) {
            a(1001003005, "当前传入Activity为空");
            return;
        }
        TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(w10);
        HashMap hashMap = new HashMap();
        String a10 = this.f5842g.f5870p.a();
        f fVar = this.f5843h.f5907c;
        Object obj = e.c.T;
        String a11 = com.aggmoread.sdk.z.d.a.a.e.m.a(a10, fVar.c(obj));
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGCSJ", "use cjs verify = false");
        AdSlot build = new AdSlot.Builder().setCodeId(this.f5843h.f5907c.c(obj)).setUserID(this.f5842g.f5870p.e()).setOrientation(x()).setUserData(a11).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(d10).setUseSurfaceView(g.a().c()).setRewardAmount(this.f5842g.f5870p.b()).setRewardName(this.f5842g.f5870p.d()).setExtraObject("gromoreExtra", a11).build()).build();
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGCSJ", "uid = " + this.f5842g.f5870p.e() + ", extra = " + hashMap.toString());
        new k(this.f5842g, this.f5843h).a(0).b();
        createAdNative.loadRewardVideoAd(build, new C0153a());
    }

    public void A() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGCSJ", "onRewardVideoCached");
        u();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.i
    public void b(Activity activity) {
        c(activity);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.i, com.aggmoread.sdk.z.d.a.a.c.r.a
    public void destroy() {
        TTRewardVideoAd tTRewardVideoAd = this.f5635r;
        if (tTRewardVideoAd == null || tTRewardVideoAd.getMediationManager() == null) {
            return;
        }
        this.f5635r.getMediationManager().destroy();
        this.f5635r = null;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.s.a.c().e();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        int i10;
        String str;
        d dVar = this.f5842g;
        if (dVar.f5870p == null) {
            i10 = 1001001000;
            str = "缺少必要的激励视频配置参数!";
        } else {
            boolean c10 = com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b.c(dVar.f5858d, this.f5843h.f5907c.c(e.c.X), this.f5843h.f5907c.c(e.c.W));
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGCSJ", "isInit " + c10);
            if (c10) {
                y();
                return;
            } else {
                i10 = 1001003005;
                str = "csj: MSDK未初始化，请稍后重试!";
            }
        }
        a(i10, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdClose() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGCSJ", "onAdClose");
        r();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdShow() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGCSJ", "onAdShow");
        n.a(new b(), 500L);
        B();
        t();
        s();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdVideoBarClick() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGCSJ", "onAdVideoBarClick");
        q();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardArrived(boolean z10, int i10, Bundle bundle) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGCSJ", "onRewardVerify");
        if (bundle != null) {
            int i11 = bundle.getInt(TTRewardVideoAd.REWARD_EXTRA_KEY_ERROR_CODE);
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGCSJ", "code = " + i11 + ", msg " + bundle.getString(TTRewardVideoAd.REWARD_EXTRA_KEY_ERROR_MSG));
            if (i11 == 10111) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGCSJ", "当前CSJ判定为异常用户");
                this.f5363n.put(AMConst.REWARD_ERROR_CODE, 1001007000);
            }
        }
        l.a(this.f5364o, 1);
        b(this.f5363n);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(boolean z10, int i10, String str, int i11, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onSkippedVideo() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGCSJ", "onSkippedVideo");
        l.a(this.f5364o, 2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoComplete() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGCSJ", "onVideoComplete");
        l.a(this.f5364o, 2);
        a((Map<String, Object>) null);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoError() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGCSJ", "onVideoError");
        c(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001001000, "视频加载失败!"));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.i
    public void v() {
        Context context = this.f5842g.f5858d;
        if (context instanceof Activity) {
            b((Activity) context);
            return;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGCSJ", "act = null " + this.f5365p);
        if (this.f5365p) {
            c(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002009, "当前传入Activity为空"));
        }
    }

    public void z() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGCSJ", "ad loaded");
        B();
        d(1);
    }

    public void a(int i10, String str) {
        b(new com.aggmoread.sdk.z.d.a.a.d.b.i(i10, str));
    }
}
