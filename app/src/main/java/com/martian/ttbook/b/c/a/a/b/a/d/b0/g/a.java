package com.martian.ttbook.b.c.a.a.b.a.d.b0.g;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.martian.ttbook.b.c.a.a.b.a.d.b0.g.b;
import com.martian.ttbook.b.c.a.a.b.a.d.j;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.c.o.c;
import com.martian.ttbook.b.c.a.a.d.b.d;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.opos.acs.st.utils.ErrorContants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends j implements b.a {

    /* renamed from: f */
    private static String f15344f = "KSRETAG";

    /* renamed from: g */
    private KsRewardVideoAd f15345g;

    /* renamed from: h */
    private AtomicBoolean f15346h;

    /* renamed from: j */
    private Object[] f15347j;
    private boolean k;
    private boolean l;
    private KsVideoPlayConfig m;
    int n;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b0.g.a$a */
    class RunnableC0310a implements Runnable {
        RunnableC0310a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.q(a.this.f15347j, 2);
            a.this.Q();
        }
    }

    private class b implements InvocationHandler {
        private b() {
        }

        /* synthetic */ b(a aVar, RunnableC0310a runnableC0310a) {
            this();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if ("onAdClicked".equals(name)) {
                a.this.onAdClicked();
                return null;
            }
            if ("onPageDismiss".equals(name)) {
                a.this.M();
                return null;
            }
            if ("onVideoPlayError".equals(name)) {
                a.this.H(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                return null;
            }
            if ("onVideoPlayEnd".equals(name)) {
                a.this.O();
                return null;
            }
            if ("onVideoSkipToEnd".equals(name)) {
                a.this.F(((Long) objArr[0]).longValue());
                return null;
            }
            if ("onVideoPlayStart".equals(name)) {
                a.this.P();
                return null;
            }
            if ("onRewardVerify".equals(name)) {
                a.this.N();
                return null;
            }
            if ("onRewardStepVerify".equals(name)) {
                a.this.E(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                return null;
            }
            if (!"onExtraRewardVerify".equals(name)) {
                return null;
            }
            a.this.J(((Integer) objArr[0]).intValue());
            return null;
        }
    }

    public a(d dVar, e eVar) {
        super(dVar, eVar);
        this.f15346h = new AtomicBoolean();
        this.f15347j = com.martian.ttbook.b.c.a.a.b.n();
        this.k = false;
        this.l = false;
        this.n = 0;
    }

    private void K(i iVar) {
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.l || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    private void L() {
    }

    public void Q() {
        if (this.k || this.n > 5) {
            return;
        }
        com.martian.ttbook.b.c.a.a.e.d.g(f15344f, "find cc ");
        this.n++;
        com.martian.ttbook.b.c.a.a.e.j.b(new RunnableC0310a(), 500L);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j
    public void C(Activity activity) {
        KsRewardVideoAd ksRewardVideoAd = this.f15345g;
        if (ksRewardVideoAd != null && ksRewardVideoAd.isAdEnable() && this.f15346h.compareAndSet(false, true)) {
            L();
            this.f15345g.showRewardVideoAd(activity, this.m);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j
    public void D() {
        Context context = this.f15662c.f15670d;
        if (context instanceof Activity) {
            C((Activity) context);
            return;
        }
        com.martian.ttbook.b.c.a.a.e.d.g(f15344f, "act = null " + this.l);
        if (this.l) {
            onError(-1001, "当前传入Activity为空");
        }
    }

    public void E(int i2, int i3) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15344f, "onRewardStepVerify " + i2 + ", " + i3);
    }

    public void F(long j2) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15344f, "onVideoSkipToEnd");
        Q();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onVideoComplete();
        }
    }

    public void H(int i2, int i3) {
        com.martian.ttbook.b.c.a.a.e.d.c(f15344f, "onVideoPlayError %s,%s", Integer.valueOf(i2), Integer.valueOf(i3));
        i iVar = new i(i2, i3 + "");
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15345g == null && this.f15663d.k()) {
            return;
        }
        this.f15662c.f15673g.a(iVar);
    }

    public void J(int i2) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15344f, "onExtraRewardVerify " + i2);
    }

    public void M() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15344f, "onPageDismiss");
        new k(this.f15662c, this.f15663d).a(1).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdDismissed();
        }
    }

    public void N() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15344f, "onRewardVerify");
        l.q(this.f15347j, 1);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onReward();
        }
    }

    public void O() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15344f, "onVideoPlayEnd");
        Q();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onVideoComplete();
        }
    }

    public void P() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15344f, "onVideoPlayStart");
        new k(this.f15662c, this.f15663d).a(5).c(k.b.q, this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
        d dVar = this.f15662c;
        l.o(dVar.f15668b, this.f15347j, dVar.f15671e, Integer.valueOf(this.f15663d.f()));
        l.s(this.f15662c.f15668b, this.f15663d.e(), this.f15663d.b());
        if (this.f15662c.m() != null) {
            d dVar2 = this.f15662c;
            l.k(dVar2.f15668b, dVar2.m());
        }
        byte[] h2 = this.f15662c.r.h();
        if (h2 != null) {
            l.j(this.f15662c.f15668b, h2);
        }
        l.i(this.f15347j, true, true);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdShow();
            ((com.martian.ttbook.b.c.a.a.c.o.b) this.f15662c.f15673g).onAdExposed();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.e(this.f15345g, i3);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.g.b.a
    public void b(@Nullable List<KsRewardVideoAd> list) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15344f, "onRewardVideoResult " + list);
    }

    public void onAdClicked() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15344f, "onAdClicked");
        this.k = true;
        k kVar = new k(this.f15662c, this.f15663d);
        boolean g2 = kVar.g(this.f15663d, null, 0L, this.f15347j);
        kVar.h();
        if (g2) {
            com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdClicked();
            }
        }
        l.i(this.f15347j, false, true);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.g.b.a
    public void onError(int i2, String str) {
        com.martian.ttbook.b.c.a.a.e.d.c(f15344f, "onAdError %s,%s", Integer.valueOf(i2), str);
        K(new i(i2, str));
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.g.b.a
    public void onRequestResult(int i2) {
        com.martian.ttbook.b.c.a.a.e.d.c(f15344f, "onRequestResult %s", Integer.valueOf(i2));
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.g.b.a
    public void q(@Nullable List<KsRewardVideoAd> list) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15344f, "ad loaded");
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            this.f15345g = list.get(0);
            this.f15345g.setRewardAdInteractionListener((KsRewardVideoAd.RewardAdInteractionListener) Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{KsRewardVideoAd.RewardAdInteractionListener.class}, new b(this, null)));
        }
        int b2 = com.martian.ttbook.b.c.a.a.b.a.d.b0.b.b(this.f15345g);
        if (com.martian.ttbook.b.c.a.a.b.a.d.b0.b.f(this.f15663d, b2)) {
            A(0);
            return;
        }
        B(b2);
        this.l = true;
        arrayList.add(this);
        this.f15663d.f15703e = list.size();
        new k(this.f15662c, this.f15663d).a(4).c(k.b.B, Integer.valueOf(list.size())).h();
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.h(this.f15661b, b2, this.f15663d);
        ((com.martian.ttbook.b.c.a.a.c.o.b) this.f15662c.f15673g).onAdLoaded(arrayList);
        ((com.martian.ttbook.b.c.a.a.c.o.b) this.f15662c.f15673g).b();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        super.sendWinNotification(i2);
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.g(this.f15345g, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        if (!n.j(this.f15662c.f15670d, this.f15663d.f15701c.d(e.c.U, ""))) {
            K(new i(-1000, "广告加载失败！"));
            return;
        }
        try {
            String l = this.f15663d.f15701c.l(e.c.Q);
            String trim = l.replace("L", "").trim();
            long parseLong = Long.parseLong(trim);
            com.martian.ttbook.b.c.a.a.e.d.g(f15344f, "slotId = " + l + ",slotIdStr = " + trim + ",_slotId = " + parseLong);
            this.f15661b.put("EXTRA_network_placementId", l);
            HashMap hashMap = new HashMap();
            c cVar = this.f15662c.p;
            if (cVar != null) {
                hashMap.put("thirdUserId", cVar.g());
                String b2 = com.martian.ttbook.b.c.a.a.e.i.b(this.f15662c.p.a(), l);
                com.martian.ttbook.b.c.a.a.e.d.g(f15344f, "_ext " + b2);
                hashMap.put("extraData", b2);
            }
            KsAdSDK.getLoadManager().loadRewardVideoAd(new KsScene.Builder(parseLong).rewardCallbackExtraData(hashMap).build(), new com.martian.ttbook.b.c.a.a.b.a.d.b0.g.b(this).a());
            com.martian.ttbook.b.c.a.a.e.d.g(f15344f, "load ad");
            if (this.f15662c.s != null) {
                this.m = new KsVideoPlayConfig.Builder().videoSoundEnable(!this.f15662c.s.k()).build();
            }
            new k(this.f15662c, this.f15663d).a(3).h();
        } catch (Exception unused) {
            K(new i(-1000, "广告ID配置错误，广告加载失败！"));
        }
    }
}
