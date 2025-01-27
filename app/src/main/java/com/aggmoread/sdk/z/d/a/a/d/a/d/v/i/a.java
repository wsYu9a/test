package com.aggmoread.sdk.z.d.a.a.d.a.d.v.i;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.aggmoread.sdk.z.d.a.a.c.r.c;
import com.aggmoread.sdk.z.d.a.a.d.a.d.i;
import com.aggmoread.sdk.z.d.a.a.d.a.d.v.i.b;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends i implements b.a {

    /* renamed from: w */
    private static String f5801w = "AMRTAGKS";

    /* renamed from: r */
    private KsRewardVideoAd f5802r;

    /* renamed from: s */
    private AtomicBoolean f5803s;

    /* renamed from: t */
    private boolean f5804t;

    /* renamed from: u */
    private KsVideoPlayConfig f5805u;

    /* renamed from: v */
    int f5806v;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.v.i.a$a */
    public class RunnableC0176a implements Runnable {
        public RunnableC0176a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.a(((i) a.this).f5364o, 2);
            a.this.A();
        }
    }

    public class b implements InvocationHandler {
        private b() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Map map;
            String name = method.getName();
            if ("onAdClicked".equals(name)) {
                a.this.onAdClicked();
            } else if ("onPageDismiss".equals(name)) {
                a.this.x();
            } else if ("onVideoPlayError".equals(name)) {
                a.this.c(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
            } else if ("onVideoPlayEnd".equals(name)) {
                a.this.y();
            } else if ("onVideoSkipToEnd".equals(name)) {
                a.this.a(((Long) objArr[0]).longValue());
            } else if ("onVideoPlayStart".equals(name)) {
                a.this.z();
            } else if ("onRewardVerify".equals(name)) {
                if (objArr != null && objArr.length > 0) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof Map) {
                        map = (Map) obj2;
                        a.this.c(map);
                    }
                }
                map = null;
                a.this.c(map);
            } else if ("onRewardStepVerify".equals(name)) {
                a.this.b(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
            } else if ("onExtraRewardVerify".equals(name)) {
                a.this.e(((Integer) objArr[0]).intValue());
            }
            return null;
        }

        public /* synthetic */ b(a aVar, RunnableC0176a runnableC0176a) {
            this();
        }
    }

    public a(d dVar, e eVar) {
        super(dVar, eVar);
        this.f5803s = new AtomicBoolean();
        this.f5804t = false;
        this.f5806v = 0;
    }

    public void A() {
        if (this.f5804t || this.f5806v > 5) {
            return;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5801w, "find cc ");
        this.f5806v++;
        n.a(new RunnableC0176a(), 500L);
    }

    private void w() {
    }

    public void a(long j10) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5801w, "onVideoSkipToEnd");
        A();
        a((Map<String, Object>) null);
    }

    public void b(int i10, int i11) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5801w, "onRewardStepVerify " + i10 + ", " + i11);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void c(int i10) {
        super.c(i10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.b(this.f5802r, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.i.b.a
    public void d(@Nullable List<KsRewardVideoAd> list) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5801w, "ad loaded");
        if (list != null && list.size() > 0) {
            this.f5802r = list.get(0);
            this.f5802r.setRewardAdInteractionListener((KsRewardVideoAd.RewardAdInteractionListener) Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{KsRewardVideoAd.RewardAdInteractionListener.class}, new b(this, null)));
        }
        int a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a((Object) this.f5802r);
        if (com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(this.f5843h, a10)) {
            a(a10, 0);
            return;
        }
        b(a10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.b(this.f5841f, a10, this.f5843h);
        d(1);
        u();
    }

    public void e(int i10) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5801w, "onExtraRewardVerify " + i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a().a(this.f5802r);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        if (!com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(this.f5842g.f5858d, this.f5843h.f5907c.a(e.c.X, ""))) {
            b(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002008, "广告加载失败！"));
            return;
        }
        try {
            String c10 = this.f5843h.f5907c.c(e.c.T);
            String trim = c10.replace("L", "").trim();
            long parseLong = Long.parseLong(trim);
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5801w, "slotId = " + c10 + ",slotIdStr = " + trim + ",_slotId = " + parseLong);
            HashMap hashMap = new HashMap();
            c cVar = this.f5842g.f5870p;
            if (cVar != null) {
                hashMap.put("thirdUserId", cVar.e());
                String a10 = m.a(this.f5842g.f5870p.a(), c10);
                com.aggmoread.sdk.z.d.a.a.e.e.b(f5801w, "_ext " + a10);
                hashMap.put("extraData", a10);
            }
            KsAdSDK.getLoadManager().loadRewardVideoAd(new KsScene.Builder(parseLong).rewardCallbackExtraData(hashMap).build(), new com.aggmoread.sdk.z.d.a.a.d.a.d.v.i.b(this).a());
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5801w, "load ad");
            if (this.f5842g.f5873s != null) {
                this.f5805u = new KsVideoPlayConfig.Builder().videoSoundEnable(!this.f5842g.f5873s.d()).build();
            }
            new k(this.f5842g, this.f5843h).a(0).b();
        } catch (Exception unused) {
            b(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002008, "广告ID配置错误，广告加载失败！"));
        }
    }

    public void onAdClicked() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5801w, "onAdClicked");
        q();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.i.b.a
    public void onError(int i10, String str) {
        com.aggmoread.sdk.z.d.a.a.e.e.a(f5801w, "onAdError %s,%s", Integer.valueOf(i10), str);
        b(new com.aggmoread.sdk.z.d.a.a.d.b.i(i10, str));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.i.b.a
    public void onRequestResult(int i10) {
        com.aggmoread.sdk.z.d.a.a.e.e.a(f5801w, "onRequestResult %s", Integer.valueOf(i10));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.i
    public void v() {
        Context context = this.f5842g.f5858d;
        if (context instanceof Activity) {
            b((Activity) context);
            return;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5801w, "act = null " + this.f5365p);
        if (this.f5365p) {
            onError(1001002009, "当前传入Activity为空");
        }
    }

    public void x() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5801w, "onPageDismiss");
        r();
    }

    public void y() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5801w, "onVideoPlayEnd");
        A();
        a((Map<String, Object>) null);
    }

    public void z() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5801w, "onVideoPlayStart");
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

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(this.f5802r, i11);
    }

    public void c(int i10, int i11) {
        com.aggmoread.sdk.z.d.a.a.e.e.a(f5801w, "onVideoPlayError %s,%s", Integer.valueOf(i10), Integer.valueOf(i11));
        c(new com.aggmoread.sdk.z.d.a.a.d.b.i(i10, i11 + ""));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.i
    public void b(Activity activity) {
        KsRewardVideoAd ksRewardVideoAd = this.f5802r;
        if (ksRewardVideoAd != null && ksRewardVideoAd.isAdEnable() && this.f5803s.compareAndSet(false, true)) {
            w();
            this.f5802r.showRewardVideoAd(activity, this.f5805u);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.i.b.a
    public void c(@Nullable List<KsRewardVideoAd> list) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5801w, "onRewardVideoResult " + list);
    }

    public void c(Map map) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5801w, "onRewardVerify " + map);
        l.a(this.f5364o, 1);
        if (map != null) {
            try {
                this.f5363n.putAll(map);
            } catch (Exception unused) {
            }
        }
        b(this.f5363n);
    }
}
