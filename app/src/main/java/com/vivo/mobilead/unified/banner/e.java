package com.vivo.mobilead.unified.banner;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import com.vivo.mobilead.util.n;
import com.vivo.mobilead.util.s0;
import java.util.List;

/* loaded from: classes4.dex */
public class e extends f {
    private int Q;
    private TTNativeExpressAd R;
    private TTNativeExpressAd.ExpressAdInteractionListener S;
    private TTAdDislike.DislikeInteractionCallback T;

    class a implements TTAdNative.NativeExpressAdListener {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            e.this.a(new l0().a(str).b(i2).a(false).a(c.a.f28913b));
            k0.a(((com.vivo.mobilead.unified.a) e.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) e.this).f29663c, "2", ((com.vivo.mobilead.unified.a) e.this).f29664d, 1, 1, 2, i2, str, c.a.f28913b.intValue());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (list == null || list.size() == 0) {
                e.this.a(new l0().b(402114).a("暂无广告，请重试").a(false).a(c.a.f28913b));
                k0.a(((com.vivo.mobilead.unified.a) e.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) e.this).f29663c, "2", ((com.vivo.mobilead.unified.a) e.this).f29664d, 1, 1, 2, 402114, "暂无广告，请重试", c.a.f28913b.intValue());
                return;
            }
            e.this.R = list.get(0);
            e eVar = e.this;
            eVar.Q = eVar.Q > 0 ? e.this.Q : com.vivo.mobilead.manager.b.l().b();
            e.this.R.setSlideIntervalTime(e.this.Q * 1000);
            TTNativeExpressAd tTNativeExpressAd = e.this.R;
            e eVar2 = e.this;
            tTNativeExpressAd.setDislikeCallback(eVar2.O, eVar2.T);
            e.this.R.setExpressInteractionListener(e.this.S);
            e.this.R.render();
        }
    }

    class b implements TTNativeExpressAd.ExpressAdInteractionListener {
        b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i2) {
            UnifiedVivoBannerAdListener unifiedVivoBannerAdListener = e.this.t;
            if (unifiedVivoBannerAdListener != null) {
                unifiedVivoBannerAdListener.onAdClick();
            }
            k0.a("2", String.valueOf(c.a.f28913b), ((com.vivo.mobilead.unified.a) e.this).f29664d, ((com.vivo.mobilead.unified.a) e.this).f29663c, ((com.vivo.mobilead.unified.a) e.this).f29665e, 1, false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i2) {
            UnifiedVivoBannerAdListener unifiedVivoBannerAdListener = e.this.t;
            if (unifiedVivoBannerAdListener != null) {
                unifiedVivoBannerAdListener.onAdShow();
            }
            k0.a("2", String.valueOf(c.a.f28913b), ((com.vivo.mobilead.unified.a) e.this).f29664d, ((com.vivo.mobilead.unified.a) e.this).f29663c, ((com.vivo.mobilead.unified.a) e.this).f29665e, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i2) {
            e.this.a(new l0().b(com.vivo.mobilead.unified.base.f.a.c(i2)).a(str).a(false).a(c.a.f28913b));
            k0.a(((com.vivo.mobilead.unified.a) e.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) e.this).f29663c, "2", ((com.vivo.mobilead.unified.a) e.this).f29664d, 1, 1, 2, i2, str, c.a.f28913b.intValue());
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f2, float f3) {
            if (view == null) {
                e.this.a(new l0().b(402114).a("暂无广告，请重试").a(false).a(c.a.f28913b));
                k0.a(((com.vivo.mobilead.unified.a) e.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) e.this).f29663c, "2", ((com.vivo.mobilead.unified.a) e.this).f29664d, 1, 1, 2, 402114, "暂无广告，请重试", c.a.f28913b.intValue());
            } else {
                e.this.P.removeAllViews();
                e.this.P.addView(view);
                e.this.a(new l0().a(true).a(c.a.f28913b));
                k0.a(((com.vivo.mobilead.unified.a) e.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) e.this).f29663c, "2", ((com.vivo.mobilead.unified.a) e.this).f29664d, 1, 1, 1, -10000, "", c.a.f28913b.intValue());
            }
        }
    }

    class c implements TTAdDislike.DislikeInteractionCallback {
        c() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i2, String str, boolean z) {
            UnifiedVivoBannerAdListener unifiedVivoBannerAdListener = e.this.t;
            if (unifiedVivoBannerAdListener != null) {
                unifiedVivoBannerAdListener.onAdClose();
            }
            e.this.d();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onShow() {
        }
    }

    public e(Activity activity, AdParams adParams) {
        super(activity, adParams);
        this.S = new b();
        this.T = new c();
        this.Q = adParams.getRefreshIntervalSeconds();
    }

    @Override // com.vivo.mobilead.unified.banner.b, com.vivo.mobilead.unified.a
    public void d() {
        super.d();
        TTNativeExpressAd tTNativeExpressAd = this.R;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
        this.P.removeAllViews();
    }

    @Override // com.vivo.mobilead.unified.a
    public void l() {
        if (!s0.b()) {
            a(new l0().a("暂无广告，请重试").b(402114).a(false).a(c.a.f28913b));
            return;
        }
        float min = Math.min(n.f(), n.e());
        AdSlot build = new AdSlot.Builder().setCodeId(this.f29662b.getPositionId()).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(Math.round(min / n.d()), Math.round(Math.round((17.0f * min) / 108.0f) / n.d())).setImageAcceptedSize(640, 100).build();
        k0.a(this.f29662b.getPositionId(), this.f29663c, "2", 1, 1, 1, c.a.f28913b.intValue(), 1);
        s0.a().createAdNative(this.f29661a).loadBannerExpressAd(build, new a());
    }
}
