package com.vivo.mobilead.unified.splash;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import com.vivo.mobilead.util.n;
import com.vivo.mobilead.util.s0;

/* loaded from: classes4.dex */
public class f extends g {
    private TTAdNative.SplashAdListener H;
    private TTSplashAd.AdInteractionListener I;

    class a implements TTAdNative.SplashAdListener {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            f.this.a(new l0().a(c.a.f28913b).a(str).b(com.vivo.mobilead.unified.base.f.a.c(i2)).a(false));
            k0.a(((com.vivo.mobilead.unified.a) f.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) f.this).f29663c, "3", ((com.vivo.mobilead.unified.a) f.this).f29664d, 1, 1, 2, i2, str, c.a.f28913b.intValue());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        public void onSplashAdLoad(TTSplashAd tTSplashAd) {
            if (tTSplashAd == null) {
                f.this.a(new l0().a(c.a.f28913b).b(402114).a("暂无广告，请重试").a(false));
                k0.a(((com.vivo.mobilead.unified.a) f.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) f.this).f29663c, "3", ((com.vivo.mobilead.unified.a) f.this).f29664d, 1, 1, 2, 402114, "暂无广告，请重试", c.a.f28913b.intValue());
                return;
            }
            tTSplashAd.setSplashInteractionListener(f.this.I);
            FrameLayout frameLayout = f.this.G;
            if (frameLayout != null) {
                frameLayout.addView(tTSplashAd.getSplashView());
            }
            f.this.a(new l0().a(c.a.f28913b).a(true));
            k0.a(((com.vivo.mobilead.unified.a) f.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) f.this).f29663c, "3", ((com.vivo.mobilead.unified.a) f.this).f29664d, 1, 1, 1, -10000, "", c.a.f28913b.intValue());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        public void onTimeout() {
            f.this.a(new l0().a(c.a.f28913b).b(402117).a("广告请求超时，请检查网络").a(false));
            k0.a(((com.vivo.mobilead.unified.a) f.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) f.this).f29663c, "3", ((com.vivo.mobilead.unified.a) f.this).f29664d, 1, 1, 2, 402117, "广告请求超时，请检查网络", c.a.f28913b.intValue());
        }
    }

    class b implements TTSplashAd.AdInteractionListener {
        b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdClicked(View view, int i2) {
            UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = f.this.u;
            if (unifiedVivoSplashAdListener != null) {
                unifiedVivoSplashAdListener.onAdClick();
            }
            k0.a("3", String.valueOf(c.a.f28913b), ((com.vivo.mobilead.unified.a) f.this).f29664d, ((com.vivo.mobilead.unified.a) f.this).f29663c, ((com.vivo.mobilead.unified.a) f.this).f29665e, 1, false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdShow(View view, int i2) {
            UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = f.this.u;
            if (unifiedVivoSplashAdListener != null) {
                unifiedVivoSplashAdListener.onAdShow();
            }
            k0.a("3", String.valueOf(c.a.f28913b), ((com.vivo.mobilead.unified.a) f.this).f29664d, ((com.vivo.mobilead.unified.a) f.this).f29663c, ((com.vivo.mobilead.unified.a) f.this).f29665e, System.currentTimeMillis() - f.this.z, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdSkip() {
            UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = f.this.u;
            if (unifiedVivoSplashAdListener != null) {
                unifiedVivoSplashAdListener.onAdSkip();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdTimeOver() {
            UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = f.this.u;
            if (unifiedVivoSplashAdListener != null) {
                unifiedVivoSplashAdListener.onAdTimeOver();
            }
        }
    }

    public f(Activity activity, AdParams adParams) {
        super(activity, adParams);
        this.H = new a();
        this.I = new b();
    }

    @Override // com.vivo.mobilead.unified.a
    public void l() {
        if (!s0.b()) {
            a(new l0().a("暂无广告，请重试").b(402114).a(false).a(c.a.f28913b));
        } else {
            try {
                k0.a(this.f29662b.getPositionId(), this.f29663c, "3", 1, 1, 1, c.a.f28913b.intValue(), 1, com.vivo.mobilead.manager.b.l().getInt("splash_orientation_key", 1));
            } catch (Exception unused) {
            }
            s0.a().createAdNative(this.F).loadSplashAd(new AdSlot.Builder().setCodeId(this.f29662b.getPositionId()).setSupportDeepLink(true).setImageAcceptedSize(n.f(), n.e()).setOrientation(this.f29662b.getSplashOrientation() == 1 ? 1 : 2).build(), this.H);
        }
    }
}
