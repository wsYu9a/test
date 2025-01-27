package com.vivo.mobilead.unified.interstitial;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.s0;
import java.util.List;

/* loaded from: classes4.dex */
public class f extends g {
    private TTAdNative F;
    private TTFullScreenVideoAd G;
    private TTNativeExpressAd H;
    private int I;
    private TTAdNative.NativeExpressAdListener J;
    private TTNativeExpressAd.AdInteractionListener K;

    class a implements TTAdNative.FullScreenVideoAdListener {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            f.this.a(new l0().a(c.a.f28913b).a(str).b(com.vivo.mobilead.unified.base.f.a.c(i2)).a(false));
            k0.a(((com.vivo.mobilead.unified.a) f.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) f.this).f29663c, "1", ((com.vivo.mobilead.unified.a) f.this).f29664d, 1, f.this.I, 2, i2, str, c.a.f28913b.intValue());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            f.this.G = tTFullScreenVideoAd;
            f.this.v();
            f.this.a(new l0().a(c.a.f28913b).a(true));
            k0.a(((com.vivo.mobilead.unified.a) f.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) f.this).f29663c, "1", ((com.vivo.mobilead.unified.a) f.this).f29664d, 1, f.this.I, 1, -10000, "", c.a.f28913b.intValue());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
            f.this.s();
        }
    }

    class b implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClose() {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = f.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdClose();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdShow() {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = f.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdShow();
            }
            k0.a("1", String.valueOf(c.a.f28913b), ((com.vivo.mobilead.unified.a) f.this).f29664d, ((com.vivo.mobilead.unified.a) f.this).f29663c, ((com.vivo.mobilead.unified.a) f.this).f29665e, 1);
            k0.a("1", String.valueOf(c.a.f28913b), ((com.vivo.mobilead.unified.a) f.this).f29664d, ((com.vivo.mobilead.unified.a) f.this).f29663c, ((com.vivo.mobilead.unified.a) f.this).f29665e);
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdVideoBarClick() {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = f.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdClick();
            }
            k0.a("1", String.valueOf(c.a.f28913b), ((com.vivo.mobilead.unified.a) f.this).f29664d, ((com.vivo.mobilead.unified.a) f.this).f29663c, ((com.vivo.mobilead.unified.a) f.this).f29665e, 1, false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoComplete() {
            MediaListener mediaListener = f.this.u;
            if (mediaListener != null) {
                mediaListener.onVideoCompletion();
            }
        }
    }

    class c implements TTAdNative.NativeExpressAdListener {
        c() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            f.this.a(new l0().a(c.a.f28913b).a(str).b(com.vivo.mobilead.unified.base.f.a.c(i2)).a(false));
            k0.a(((com.vivo.mobilead.unified.a) f.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) f.this).f29663c, "1", ((com.vivo.mobilead.unified.a) f.this).f29664d, 1, f.this.I, 2, i2, str, c.a.f28913b.intValue());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (list == null || list.size() <= 0) {
                f.this.a(new l0().a(c.a.f28913b).b(402114).a("暂无广告，请重试").a(false));
                k0.a(((com.vivo.mobilead.unified.a) f.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) f.this).f29663c, "1", ((com.vivo.mobilead.unified.a) f.this).f29664d, 1, f.this.I, 2, 402114, "暂无广告，请重试", c.a.f28913b.intValue());
            } else {
                f.this.H = list.get(0);
                f.this.H.setExpressInteractionListener(f.this.K);
                f.this.H.render();
            }
        }
    }

    class d implements TTNativeExpressAd.AdInteractionListener {
        d() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i2) {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = f.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdClick();
            }
            k0.a("1", String.valueOf(c.a.f28913b), ((com.vivo.mobilead.unified.a) f.this).f29664d, ((com.vivo.mobilead.unified.a) f.this).f29663c, ((com.vivo.mobilead.unified.a) f.this).f29665e, 1, false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
        public void onAdDismiss() {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = f.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdClose();
            }
            f.this.d();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i2) {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = f.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdShow();
            }
            k0.a("1", String.valueOf(c.a.f28913b), ((com.vivo.mobilead.unified.a) f.this).f29664d, ((com.vivo.mobilead.unified.a) f.this).f29663c, ((com.vivo.mobilead.unified.a) f.this).f29665e, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i2) {
            f.this.a(new l0().a(c.a.f28913b).b(com.vivo.mobilead.unified.base.f.a.c(i2)).a(str).a(false));
            f.this.H = null;
            k0.a(((com.vivo.mobilead.unified.a) f.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) f.this).f29663c, "1", ((com.vivo.mobilead.unified.a) f.this).f29664d, 1, f.this.I, 2, i2, str, c.a.f28913b.intValue());
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f2, float f3) {
            f.this.a(new l0().a(c.a.f28913b).a(true));
            k0.a(((com.vivo.mobilead.unified.a) f.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) f.this).f29663c, "1", ((com.vivo.mobilead.unified.a) f.this).f29664d, 1, f.this.I, 1, -10000, "", c.a.f28913b.intValue());
        }
    }

    public f(Activity activity, AdParams adParams) {
        super(activity, adParams);
        this.J = new c();
        this.K = new d();
    }

    public void v() {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.G;
        if (tTFullScreenVideoAd == null) {
            return;
        }
        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new b());
    }

    @Override // com.vivo.mobilead.unified.interstitial.a, com.vivo.mobilead.unified.a
    public void d() {
        super.d();
        TTNativeExpressAd tTNativeExpressAd = this.H;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
            this.H = null;
        }
        this.t = null;
        this.u = null;
        this.v = null;
        this.f29661a = null;
    }

    @Override // com.vivo.mobilead.unified.interstitial.a, com.vivo.mobilead.unified.a
    public void l() {
        Activity activity;
        if (!s0.b() || (activity = this.v) == null || activity.isFinishing()) {
            a(new l0().a("广告SDK未初始化").b(402118).a(false).a(c.a.f28913b));
        } else {
            s0.a().createAdNative(this.v).loadInteractionExpressAd(new AdSlot.Builder().setCodeId(this.f29662b.getPositionId()).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(260.0f, 0.0f).setImageAcceptedSize(750, 750).build(), this.J);
        }
    }

    @Override // com.vivo.mobilead.unified.interstitial.a
    public void o() {
        Activity activity;
        if (!s0.b() || (activity = this.v) == null || activity.isFinishing()) {
            a(new l0().a("暂无广告，请重试").b(402114).a(false).a(c.a.f28913b));
        } else {
            this.F = s0.a().createAdNative(this.v);
            this.F.loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.f29662b.getPositionId()).setSupportDeepLink(true).setOrientation(m.c(this.v) == 2 ? 2 : 1).build(), new a());
        }
    }

    @Override // com.vivo.mobilead.unified.interstitial.a
    public void q() {
        if (this.H == null || this.v.isFinishing()) {
            return;
        }
        this.H.showInteractionExpressAd(this.v);
    }

    @Override // com.vivo.mobilead.unified.interstitial.a, com.vivo.mobilead.unified.a
    public void a(int i2) {
        k0.a(this.f29662b.getPositionId(), this.f29663c, "1", 1, 1, 1, c.a.f28913b.intValue(), i2);
        this.I = i2;
        if (i2 == 2) {
            o();
        } else {
            l();
        }
    }

    @Override // com.vivo.mobilead.unified.interstitial.a
    public void a(Activity activity) {
        TTFullScreenVideoAd tTFullScreenVideoAd;
        if (activity == null || (tTFullScreenVideoAd = this.G) == null) {
            return;
        }
        tTFullScreenVideoAd.showFullScreenVideoAd(activity, TTAdConstant.RitScenes.GAME_GIFT_BONUS, null);
    }
}
