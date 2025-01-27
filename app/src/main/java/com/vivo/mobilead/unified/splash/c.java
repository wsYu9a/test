package com.vivo.mobilead.unified.splash;

import android.app.Activity;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import com.vivo.mobilead.util.v;

/* loaded from: classes4.dex */
public class c extends g {
    private KsLoadManager.SplashScreenAdListener H;
    private KsSplashScreenAd.SplashScreenAdInteractionListener I;

    class a implements KsLoadManager.SplashScreenAdListener {
        a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onError(int i2, String str) {
            c.this.a(new l0().a(c.a.f28915d).a(str).b(com.vivo.mobilead.unified.base.f.a.b(i2)).a(false));
            c cVar = c.this;
            k0.a(cVar.A, ((com.vivo.mobilead.unified.a) cVar).f29663c, "3", ((com.vivo.mobilead.unified.a) c.this).f29664d, 1, 1, 2, i2, str, c.a.f28915d.intValue());
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onRequestResult(int i2) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd) {
            if (ksSplashScreenAd == null) {
                c.this.a(new l0().a(c.a.f28915d).b(402130).a("暂无广告，请重试").a(false));
                c cVar = c.this;
                k0.a(cVar.A, ((com.vivo.mobilead.unified.a) cVar).f29663c, "3", ((com.vivo.mobilead.unified.a) c.this).f29664d, 1, 1, 2, 402130, "暂无广告，请重试", c.a.f28915d.intValue());
                return;
            }
            try {
                c cVar2 = c.this;
                View view = ksSplashScreenAd.getView(cVar2.F, cVar2.I);
                if (view == null) {
                    c.this.a(new l0().a(c.a.f28915d).b(402130).a("暂无广告，请重试").a(false));
                    c cVar3 = c.this;
                    k0.a(cVar3.A, ((com.vivo.mobilead.unified.a) cVar3).f29663c, "3", ((com.vivo.mobilead.unified.a) c.this).f29664d, 1, 1, 2, 402130, "暂无广告，请重试", c.a.f28915d.intValue());
                } else {
                    c.this.G.addView(view);
                    c.this.a(new l0().a(c.a.f28915d).a(true));
                    c cVar4 = c.this;
                    k0.a(cVar4.A, ((com.vivo.mobilead.unified.a) cVar4).f29663c, "3", ((com.vivo.mobilead.unified.a) c.this).f29664d, 1, 1, 1, -10000, "", c.a.f28915d.intValue());
                }
            } catch (Exception unused) {
                c.this.a(new l0().a(c.a.f28915d).b(402130).a("暂无广告，请重试").a(false));
                c cVar5 = c.this;
                k0.a(cVar5.A, ((com.vivo.mobilead.unified.a) cVar5).f29663c, "3", ((com.vivo.mobilead.unified.a) c.this).f29664d, 1, 1, 2, 402130, "暂无广告，请重试", c.a.f28915d.intValue());
            }
        }
    }

    class b implements KsSplashScreenAd.SplashScreenAdInteractionListener {
        b() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdClicked() {
            UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = c.this.u;
            if (unifiedVivoSplashAdListener != null) {
                unifiedVivoSplashAdListener.onAdClick();
            }
            k0.a("3", String.valueOf(c.a.f28915d), ((com.vivo.mobilead.unified.a) c.this).f29664d, ((com.vivo.mobilead.unified.a) c.this).f29663c, ((com.vivo.mobilead.unified.a) c.this).f29665e, 1, false);
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowEnd() {
            UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = c.this.u;
            if (unifiedVivoSplashAdListener != null) {
                unifiedVivoSplashAdListener.onAdTimeOver();
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowError(int i2, String str) {
            UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = c.this.u;
            if (unifiedVivoSplashAdListener != null) {
                unifiedVivoSplashAdListener.onAdFailed(new VivoAdError(i2, str));
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowStart() {
            UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = c.this.u;
            if (unifiedVivoSplashAdListener != null) {
                unifiedVivoSplashAdListener.onAdShow();
            }
            k0.a("3", String.valueOf(c.a.f28915d), ((com.vivo.mobilead.unified.a) c.this).f29664d, ((com.vivo.mobilead.unified.a) c.this).f29663c, ((com.vivo.mobilead.unified.a) c.this).f29665e, System.currentTimeMillis() - c.this.z, 1);
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogCancel() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogShow() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onSkippedAd() {
            UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = c.this.u;
            if (unifiedVivoSplashAdListener != null) {
                unifiedVivoSplashAdListener.onAdSkip();
            }
        }
    }

    public c(Activity activity, AdParams adParams) {
        super(activity, adParams);
        this.H = new a();
        this.I = new b();
    }

    @Override // com.vivo.mobilead.unified.splash.a, com.vivo.mobilead.unified.a
    public void d() {
        super.d();
    }

    @Override // com.vivo.mobilead.unified.a
    public void l() {
        if (!v.a()) {
            a(new l0().a(c.a.f28915d).b(402130).a("暂无广告，请重试").a(false));
            return;
        }
        try {
            k0.a(this.A, this.f29663c, "3", 1, 1, 1, c.a.f28915d.intValue(), 1, com.vivo.mobilead.manager.b.l().getInt("splash_orientation_key", 1));
            KsAdSDK.getLoadManager().loadSplashScreenAd(new KsScene.Builder(Long.parseLong(this.A)).build(), this.H);
        } catch (Exception unused) {
            a(new l0().a(c.a.f28915d).b(402130).a("暂无广告，请重试").a(false));
        }
    }
}
