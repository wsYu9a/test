package com.martian.ttbook.b.c.a.a.b.a.d.y.g;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.martian.ttbook.b.c.a.a.b.a.d.j;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.b.a.d.y.g.c;
import com.martian.ttbook.b.c.a.a.c.e;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.d;
import com.opos.acs.st.utils.ErrorContants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class b extends j {

    /* renamed from: f */
    public TTAdNative f15527f;

    /* renamed from: g */
    private TTRewardVideoAd f15528g;

    /* renamed from: h */
    private boolean f15529h;

    /* renamed from: j */
    private AtomicBoolean f15530j;
    private Object[] k;

    class a implements c.a {

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.y.g.b$a$a */
        class RunnableC0339a implements Runnable {
            RunnableC0339a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                Object obj = bVar.f15662c.f15668b;
                Object[] objArr = bVar.k;
                b bVar2 = b.this;
                l.o(obj, objArr, bVar2.f15662c.f15671e, Integer.valueOf(bVar2.f15663d.f()));
                b bVar3 = b.this;
                l.s(bVar3.f15662c.f15668b, bVar3.f15663d.e(), b.this.f15663d.b());
                byte[] h2 = b.this.f15662c.r.h();
                if (h2 != null) {
                    l.j(b.this.f15662c.f15668b, h2);
                }
                l.i(b.this.k, true, true);
            }
        }

        a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.g.c.a
        public void a() {
            d.g("CSJRTAG", "onVideoError");
            b.this.u(new i(-100, "视频加载失败!"));
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.g.c.a
        public void a(boolean z, int i2, String str, int i3, String str2) {
            d.g("CSJRTAG", "onRewardVerify");
            l.q(b.this.k, 1);
            e eVar = b.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onReward();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.g.c.a
        public void b(boolean z, int i2, Bundle bundle) {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.g.c.a
        public void onAdClose() {
            d.g("CSJRTAG", "onAdClose");
            b bVar = b.this;
            new k(bVar.f15662c, bVar.f15663d).a(1).h();
            e eVar = b.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdDismissed();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.g.c.a
        public void onAdShow() {
            d.g("CSJRTAG", "onAdShow");
            com.martian.ttbook.b.c.a.a.e.j.b(new RunnableC0339a(), 500L);
            b bVar = b.this;
            new k(bVar.f15662c, bVar.f15663d).a(5).c(k.b.q, b.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = b.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdShow();
                ((com.martian.ttbook.b.c.a.a.c.o.b) b.this.f15662c.f15673g).onAdExposed();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.g.c.a
        public void onAdVideoBarClick() {
            d.g("CSJRTAG", "onAdVideoBarClick");
            l.i(b.this.k, false, true);
            b bVar = b.this;
            k kVar = new k(bVar.f15662c, bVar.f15663d);
            b bVar2 = b.this;
            boolean g2 = kVar.g(bVar2.f15663d, null, 0L, bVar2.k);
            kVar.h();
            if (g2) {
                com.martian.ttbook.b.c.a.a.c.e eVar = b.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                    ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdClicked();
                }
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.g.c.a
        public void onSkippedVideo() {
            d.g("CSJRTAG", "onSkippedVideo");
            l.q(b.this.k, 2);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.g.c.a
        public void onVideoComplete() {
            d.g("CSJRTAG", "onVideoComplete");
            l.q(b.this.k, 2);
            com.martian.ttbook.b.c.a.a.c.e eVar = b.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onVideoComplete();
            }
        }
    }

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.y.g.b$b */
    class C0340b implements TTAppDownloadListener {
        C0340b(b bVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j2, long j3, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j2, long j3, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j2, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j2, long j3, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
        }
    }

    private class c implements InvocationHandler {
        private c() {
        }

        /* synthetic */ c(b bVar, a aVar) {
            this();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if ("onRewardVideoAdLoad".equals(name)) {
                b.this.E((TTRewardVideoAd) objArr[0]);
                return null;
            }
            if ("onRewardVideoCached".equals(name)) {
                b.this.I();
                return null;
            }
            if (!"onError".equals(name)) {
                return null;
            }
            b.this.onError(((Integer) objArr[0]).intValue(), (String) objArr[1]);
            return null;
        }
    }

    public b(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15530j = new AtomicBoolean();
        this.k = com.martian.ttbook.b.c.a.a.b.n();
    }

    private void G(Activity activity) {
        d.g("CSJRTAG", "showAd activity = " + activity);
        if (this.f15528g == null || !this.f15530j.compareAndSet(false, true)) {
            return;
        }
        d.g("CSJRTAG", "show");
        this.f15528g.showRewardVideoAd(activity, TTAdConstant.RitScenes.CUSTOMIZE_SCENES, "custom_reward");
        this.f15528g = null;
    }

    private int H() {
        return this.f15662c.f15670d.getResources().getConfiguration().orientation == 2 ? 2 : 1;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j
    protected void C(Activity activity) {
        G(activity);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j
    public void D() {
        Context context = this.f15662c.f15670d;
        if (context instanceof Activity) {
            C((Activity) context);
            return;
        }
        d.g("CSJRTAG", "act = null " + this.f15529h);
        if (this.f15529h) {
            onError(-1001, "当前传入Activity为空");
        }
    }

    public void E(TTRewardVideoAd tTRewardVideoAd) {
        d.g("CSJRTAG", "ad loaded");
        if (com.martian.ttbook.b.c.a.a.b.a.d.y.a.f(this.f15663d, tTRewardVideoAd)) {
            A(0);
            return;
        }
        com.martian.ttbook.b.c.a.a.b.a.d.y.a.d(this.f15661b, tTRewardVideoAd, this.f15663d);
        this.f15529h = true;
        this.f15528g = tTRewardVideoAd;
        tTRewardVideoAd.setRewardAdInteractionListener(new com.martian.ttbook.b.c.a.a.b.a.d.y.g.c(new a()).a());
        this.f15528g.setDownloadListener(new C0340b(this));
        new k(this.f15662c, this.f15663d).a(4).h();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdLoaded(arrayList);
        }
    }

    public void I() {
        d.g("CSJRTAG", "onRewardVideoCached");
        if (this.f15529h) {
            com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).b();
            }
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j, com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
    }

    public void onError(int i2, String str) {
        i iVar = new i(i2, str);
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15529h || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        com.martian.ttbook.b.c.a.a.d.b.d dVar = this.f15662c;
        if (dVar.p == null) {
            u(new i(-100, "缺少必要的激励视频配置参数!"));
            return;
        }
        n.c(dVar.f15670d, this.f15663d.f15701c.l(e.c.U), null);
        String d2 = this.f15663d.f15701c.d(e.c.P, "2");
        boolean equals = d2.equals("1");
        d.g("CSJRTAG", "isExpress = " + equals + ",v = " + d2);
        this.f15527f = com.martian.ttbook.b.c.a.a.b.a.d.y.c.b().createAdNative(this.f15662c.f15670d.getApplicationContext());
        AdSlot.Builder builder = new AdSlot.Builder();
        if (equals) {
            builder.setExpressViewAcceptedSize(500.0f, 500.0f);
        }
        String a2 = this.f15662c.p.a();
        com.martian.ttbook.b.c.a.a.e.e eVar = this.f15663d.f15701c;
        Object obj = e.c.Q;
        AdSlot build = builder.setCodeId(this.f15663d.f15701c.l(obj)).setSupportDeepLink(true).setUserID(this.f15662c.p.g()).setMediaExtra(com.martian.ttbook.b.c.a.a.e.i.b(a2, eVar.l(obj))).setOrientation(H()).build();
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15527f.loadRewardVideoAd(build, (TTAdNative.RewardVideoAdListener) Proxy.newProxyInstance(TTAdNative.RewardVideoAdListener.class.getClassLoader(), new Class[]{TTAdNative.RewardVideoAdListener.class}, new c(this, null)));
    }
}
