package com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.f;

import android.app.Activity;
import android.content.Context;
import com.aggmoread.sdk.z.d.a.a.d.a.d.g;
import com.aggmoread.sdk.z.d.a.a.d.a.d.m;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.f;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class b extends g implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {

    /* renamed from: p */
    private TTFullScreenVideoAd f5627p;

    /* renamed from: q */
    private AtomicBoolean f5628q;

    /* renamed from: r */
    private AtomicBoolean f5629r;

    /* renamed from: s */
    private String f5630s;

    public class a implements TTAdNative.FullScreenVideoAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onError(int i10, String str) {
            b.this.a(i10, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            b.this.f5627p = tTFullScreenVideoAd;
            b.this.B();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
            b.this.C();
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.f.b$b */
    public class RunnableC0152b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ Activity f5632b;

        public RunnableC0152b(Activity activity) {
            this.f5632b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b(this.f5632b);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            Object obj = bVar.f5842g.f5856b;
            Object[] objArr = ((g) bVar).f5343n;
            b bVar2 = b.this;
            l.a(obj, objArr, bVar2.f5842g.f5859e, Integer.valueOf(bVar2.f5843h.f()));
            b bVar3 = b.this;
            l.b(bVar3.f5842g.f5856b, bVar3.f5843h.e(), b.this.f5843h.b());
            byte[] b10 = b.this.f5842g.f5872r.b();
            if (b10 != null) {
                l.a(b.this.f5842g.f5856b, b10);
            }
            l.a((Object) ((g) b.this).f5343n, true, true);
            l.a(((g) b.this).f5343n, b.this.f5843h);
            l.a(((g) b.this).f5343n, 3);
        }
    }

    public b(d dVar, e eVar) {
        super(dVar, eVar);
        this.f5628q = new AtomicBoolean();
        this.f5629r = new AtomicBoolean();
        this.f5630s = "msdk-user";
    }

    private void A() {
        if (this.f5629r.compareAndSet(false, true)) {
            l.a(this.f5343n, 2);
            x();
        }
    }

    private void D() {
        com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b.a(this.f5841f, this.f5627p);
    }

    private int y() {
        return this.f5842g.f5858d.getResources().getConfiguration().orientation == 2 ? 2 : 1;
    }

    private void z() {
        Activity a10 = m.a(this.f5842g.f5858d);
        if (a10 == null) {
            a(1001003005, "当前传入Activity为空");
            return;
        }
        com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5842g.f5873s;
        boolean d10 = bVar != null ? bVar.d() : true;
        TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(a10);
        HashMap hashMap = new HashMap();
        String a11 = this.f5842g.f5870p.a();
        f fVar = this.f5843h.f5907c;
        Object obj = e.c.T;
        String a12 = com.aggmoread.sdk.z.d.a.a.e.m.a(a11, fVar.c(obj));
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGCSJ", "uid = " + this.f5842g.f5870p.e() + ", extra = " + hashMap);
        AdSlot build = new AdSlot.Builder().setCodeId(this.f5843h.f5907c.c(obj)).setUserID(this.f5630s).setUserData(a12).setOrientation(y()).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(d10).setBidNotify(true).setRewardName(this.f5842g.f5870p.d()).setRewardAmount(this.f5842g.f5870p.b()).setExtraObject("gromoreExtra", a12).build()).build();
        new k(this.f5842g, this.f5843h).a(0).b();
        createAdNative.loadFullScreenVideoAd(build, new a());
    }

    public void B() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGCSJ", "onFullVideoAdLoad ");
        D();
        u();
    }

    public void C() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGCSJ", "onFullVideoCached");
        w();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.g, com.aggmoread.sdk.z.d.a.a.c.q.b
    public void b() {
        Context context = this.f5842g.f5858d;
        if (context instanceof Activity) {
            b((Activity) context);
        } else {
            super.b();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.q.b
    public void destroy() {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.f5627p;
        if (tTFullScreenVideoAd == null || tTFullScreenVideoAd.getMediationManager() == null) {
            return;
        }
        this.f5627p.getMediationManager().destroy();
        this.f5627p = null;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.s.a.c().d();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        com.aggmoread.sdk.z.d.a.a.c.r.c cVar = this.f5842g.f5870p;
        if (cVar != null) {
            this.f5630s = cVar.e();
        }
        boolean c10 = com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b.c(this.f5842g.f5858d, this.f5843h.f5907c.c(e.c.X), this.f5843h.f5907c.c(e.c.W));
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGCSJ", "isInit " + c10);
        if (c10) {
            z();
        } else {
            b(new i(1001003005, "csj: MSDK未初始化，请稍后重试!"));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClose() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGCSJ", "onAdClose");
        s();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdShow() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGCSJ", "onAdShow");
        n.a(new c(), 500L);
        if (this.f5627p != null) {
            D();
        }
        v();
        t();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGCSJ", "onAdVideoBarClick");
        r();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGCSJ", "onSkippedVideo");
        A();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoComplete() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGCSJ", "onVideoComplete");
        A();
    }

    public void b(Activity activity) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGCSJ", "showAd activity = " + activity);
        TTFullScreenVideoAd tTFullScreenVideoAd = this.f5627p;
        if (tTFullScreenVideoAd != null) {
            boolean z10 = tTFullScreenVideoAd.getMediationManager() != null && this.f5627p.getMediationManager().isReady();
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGCSJ", "showAd isReady = " + z10);
            if (z10 && this.f5628q.compareAndSet(false, true)) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGCSJ", "show");
                if (activity == null) {
                    super.b();
                } else {
                    this.f5627p.setFullScreenVideoAdInteractionListener(this);
                    this.f5627p.showFullScreenVideoAd(activity);
                }
            }
        }
    }

    public void a(int i10, String str) {
        b(new i(i10, str));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.q.b
    public void a(Activity activity) {
        try {
            activity.getWindow().getDecorView().post(new RunnableC0152b(activity));
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGCSJ", "show #3 " + e10.getMessage());
            b(activity);
        }
    }
}
