package com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.c;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.aggmoread.sdk.z.d.a.a.c.h;
import com.aggmoread.sdk.z.d.a.a.d.a.d.m;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.aggmoread.sdk.z.d.a.a.e.q;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public class a extends com.aggmoread.sdk.z.d.a.a.d.a.d.a implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* renamed from: r */
    private TTNativeExpressAd f5589r;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.c.a$a */
    public class C0144a implements TTAdNative.NativeExpressAdListener {
        public C0144a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onError(int i10, String str) {
            a.this.a(i10, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (list == null || list.size() <= 0) {
                a.this.a(-1000, "未匹配到合适广告！");
                return;
            }
            a.this.f5589r = list.get(0);
            a.this.z();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.b((Activity) aVar.f5842g.f5858d);
        }
    }

    public class c implements TTAdDislike.DislikeInteractionCallback {
        public c() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i10, String str, boolean z10) {
            e.b("AMBTAGCSJ", "onAdClose");
            a.this.r();
            com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = (com.aggmoread.sdk.z.d.a.a.d.b.m.a) ((com.aggmoread.sdk.z.d.a.a.d.a.d.a) a.this).f5295q.get();
            if (aVar != null) {
                aVar.removeAllViews();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onShow() {
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a((View[]) null);
        }
    }

    public a(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5294p = com.aggmoread.sdk.z.d.a.a.b.b();
    }

    private void A() {
        com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b.a(this.f5841f, this.f5589r);
    }

    private void y() {
        int i10;
        Activity a10 = m.a(this.f5842g.f5858d);
        if (a10 == null) {
            a(1001003005, "当前传入Activity为空");
            return;
        }
        int i11 = 0;
        new k(this.f5842g, this.f5843h).a(0).b();
        h hVar = this.f5842g.f5871q;
        if (hVar != null) {
            i11 = hVar.b();
            i10 = this.f5842g.f5871q.a();
        } else {
            i10 = 0;
        }
        if (i11 < 1 || i10 < 1) {
            i11 = q.a(320.0d);
            i10 = q.a(150.0d);
        }
        TTAdSdk.getAdManager().createAdNative(a10).loadBannerExpressAd(new AdSlot.Builder().setCodeId(this.f5843h.f5907c.c(e.c.T)).setImageAcceptedSize(i11, i10).build(), new C0144a());
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.m.a
    public void destroy() {
        TTNativeExpressAd tTNativeExpressAd = this.f5589r;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
            this.f5589r = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.s.a.c().d(this.f5295q.get());
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        boolean c10 = com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b.c(this.f5842g.f5858d, this.f5843h.f5907c.c(e.c.X), this.f5843h.f5907c.c(e.c.W));
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMBTAGCSJ", "isInit " + c10);
        if (c10) {
            y();
        } else {
            b(new i(1001003005, "csj: MSDK未初始化，请稍后重试!"));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i10) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMBTAGCSJ", "onAdClicked");
        q();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i10) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMBTAGCSJ", "onAdShow");
        n.a(new d(), 500L);
        if (this.f5589r != null) {
            A();
        }
        x();
        t();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i10) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMBTAGCSJ", "onRewardedAdShowFail");
        a(i10, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f10, float f11) {
    }

    public void z() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMBTAGCSJ", "onBannerLoadedInner ");
        A();
        v();
    }

    public void a(int i10, String str) {
        b(new i(i10, str));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.m.a
    public void b() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMBTAGCSJ", "show() ");
        a(this.f5842g.f5864j);
    }

    public void b(Activity activity) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMBTAGCSJ", "showInner ");
        if (this.f5291m && this.f5589r != null && this.f5293o.compareAndSet(false, true)) {
            this.f5589r.setExpressInteractionListener(this);
            if (activity != null) {
                this.f5589r.setDislikeCallback(activity, new c());
            }
            com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = this.f5295q.get();
            View expressAdView = this.f5589r.getExpressAdView();
            if (aVar == null || expressAdView == null) {
                return;
            }
            aVar.removeAllViews();
            aVar.addView(expressAdView);
            this.f5589r.render();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.m.a
    public void a(ViewGroup viewGroup) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMBTAGCSJ", "showInContainer ");
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(this.f5842g.f5858d);
        this.f5295q = new WeakReference<>(aVar);
        aVar.addOnAttachStateChangeListener(new com.aggmoread.sdk.z.d.a.a.d.b.m.b());
        if (viewGroup != null) {
            ViewGroup viewGroup2 = (ViewGroup) aVar.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(aVar);
            }
            viewGroup.addView(aVar, new ViewGroup.LayoutParams(-1, -2));
        }
        try {
            Context context = this.f5842g.f5858d;
            if (context instanceof Activity) {
                ((Activity) context).getWindow().getDecorView().post(new b());
            }
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMBTAGCSJ", "show #3 " + e10.getMessage());
            b((Activity) null);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.a
    public void a(View[] viewArr) {
        com.aggmoread.sdk.z.d.a.a.d.b.d dVar = this.f5842g;
        l.a(dVar.f5856b, this.f5294p, dVar.f5859e, Integer.valueOf(this.f5843h.f()));
        l.b(this.f5842g.f5856b, this.f5843h.e(), this.f5843h.b());
        byte[] b10 = this.f5842g.f5872r.b();
        if (b10 != null) {
            l.a(this.f5842g.f5856b, b10);
        }
        l.a((Object) this.f5294p, true, true);
        l.a(this.f5294p, this.f5843h);
        l.a(this.f5294p, 2);
    }
}
