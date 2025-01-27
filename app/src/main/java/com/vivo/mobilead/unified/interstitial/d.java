package com.vivo.mobilead.unified.interstitial;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import com.vivo.mobilead.util.v;
import java.util.List;

/* loaded from: classes4.dex */
public class d extends g {
    private int F;
    private KsFullScreenVideoAd G;
    private KsInterstitialAd H;
    private KsLoadManager.InterstitialAdListener I;
    private KsLoadManager.FullScreenVideoAdListener J;
    private KsFullScreenVideoAd.FullScreenVideoAdInteractionListener K;
    private KsInterstitialAd.AdInteractionListener L;

    class a implements KsLoadManager.InterstitialAdListener {
        a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onError(int i2, String str) {
            d.this.a(new l0().a(c.a.f28915d).a(str).b(com.vivo.mobilead.unified.base.f.a.b(i2)).a(false));
            k0.a(((com.vivo.mobilead.unified.a) d.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) d.this).f29663c, "1", ((com.vivo.mobilead.unified.a) d.this).f29664d, 1, d.this.F, 2, i2, str, c.a.f28915d.intValue());
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
            if (list == null || list.size() == 0 || list.get(0) == null) {
                d.this.a(new l0().a(c.a.f28915d).b(402130).a("暂无广告，请重试").a(false));
                k0.a(((com.vivo.mobilead.unified.a) d.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) d.this).f29663c, "1", ((com.vivo.mobilead.unified.a) d.this).f29664d, 1, d.this.F, 2, 402130, "暂无广告，请重试", c.a.f28915d.intValue());
            } else {
                d.this.H = list.get(0);
                d.this.a(new l0().a(c.a.f28915d).a(true));
                k0.a(((com.vivo.mobilead.unified.a) d.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) d.this).f29663c, "1", ((com.vivo.mobilead.unified.a) d.this).f29664d, 1, d.this.F, 1, -10000, "", c.a.f28915d.intValue());
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onRequestResult(int i2) {
        }
    }

    class b implements KsLoadManager.FullScreenVideoAdListener {
        b() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onError(int i2, String str) {
            d.this.a(new l0().a(c.a.f28915d).a(str).b(com.vivo.mobilead.unified.base.f.a.b(i2)).a(false));
            k0.a(((com.vivo.mobilead.unified.a) d.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) d.this).f29663c, "1", ((com.vivo.mobilead.unified.a) d.this).f29664d, 1, d.this.F, 2, i2, str, c.a.f28915d.intValue());
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
            if (list == null || list.size() == 0 || list.get(0) == null) {
                d.this.a(new l0().a(c.a.f28915d).b(402130).a("暂无广告，请重试").a(false));
                k0.a(((com.vivo.mobilead.unified.a) d.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) d.this).f29663c, "1", ((com.vivo.mobilead.unified.a) d.this).f29664d, 1, d.this.F, 2, 402130, "暂无广告，请重试", c.a.f28915d.intValue());
            } else {
                d.this.G = list.get(0);
                d.this.a(new l0().a(c.a.f28915d).a(true));
                k0.a(((com.vivo.mobilead.unified.a) d.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) d.this).f29663c, "1", ((com.vivo.mobilead.unified.a) d.this).f29664d, 1, d.this.F, 1, -10000, "", c.a.f28915d.intValue());
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onFullScreenVideoResult(@Nullable List<KsFullScreenVideoAd> list) {
        }
    }

    class c implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        c() {
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClicked() {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = d.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdClick();
            }
            k0.a("1", String.valueOf(c.a.f28915d), ((com.vivo.mobilead.unified.a) d.this).f29664d, ((com.vivo.mobilead.unified.a) d.this).f29663c, ((com.vivo.mobilead.unified.a) d.this).f29665e, 1, false);
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onPageDismiss() {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = d.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdClose();
            }
            d.this.d();
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayEnd() {
            MediaListener mediaListener = d.this.u;
            if (mediaListener != null) {
                mediaListener.onVideoCompletion();
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayError(int i2, int i3) {
            MediaListener mediaListener = d.this.u;
            if (mediaListener != null) {
                mediaListener.onVideoError(new VivoAdError(com.vivo.mobilead.unified.base.f.a.b(i2), ""));
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayStart() {
            MediaListener mediaListener = d.this.u;
            if (mediaListener != null) {
                mediaListener.onVideoStart();
            }
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = d.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdShow();
            }
            k0.a("1", String.valueOf(c.a.f28915d), ((com.vivo.mobilead.unified.a) d.this).f29664d, ((com.vivo.mobilead.unified.a) d.this).f29663c, ((com.vivo.mobilead.unified.a) d.this).f29665e, 1);
            k0.a("1", String.valueOf(c.a.f28915d), ((com.vivo.mobilead.unified.a) d.this).f29664d, ((com.vivo.mobilead.unified.a) d.this).f29663c, ((com.vivo.mobilead.unified.a) d.this).f29665e);
        }
    }

    /* renamed from: com.vivo.mobilead.unified.interstitial.d$d */
    class C0649d implements KsInterstitialAd.AdInteractionListener {
        C0649d() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdClicked() {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = d.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdClick();
            }
            k0.a("1", String.valueOf(c.a.f28915d), ((com.vivo.mobilead.unified.a) d.this).f29664d, ((com.vivo.mobilead.unified.a) d.this).f29663c, ((com.vivo.mobilead.unified.a) d.this).f29665e, 1, false);
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdClosed() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdShow() {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = d.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdShow();
            }
            k0.a("1", String.valueOf(c.a.f28915d), ((com.vivo.mobilead.unified.a) d.this).f29664d, ((com.vivo.mobilead.unified.a) d.this).f29663c, ((com.vivo.mobilead.unified.a) d.this).f29665e, 1);
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onPageDismiss() {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = d.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdClose();
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onSkippedAd() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayEnd() {
            MediaListener mediaListener = d.this.u;
            if (mediaListener != null) {
                mediaListener.onVideoCompletion();
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayError(int i2, int i3) {
            MediaListener mediaListener = d.this.u;
            if (mediaListener != null) {
                mediaListener.onVideoError(new VivoAdError(com.vivo.mobilead.unified.base.f.a.b(i2), ""));
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayStart() {
            MediaListener mediaListener = d.this.u;
            if (mediaListener != null) {
                mediaListener.onVideoStart();
            }
            k0.b("1", String.valueOf(c.a.f28915d), ((com.vivo.mobilead.unified.a) d.this).f29664d, ((com.vivo.mobilead.unified.a) d.this).f29663c, ((com.vivo.mobilead.unified.a) d.this).f29665e, 1);
        }
    }

    public d(Activity activity, AdParams adParams) {
        super(activity, adParams);
        this.I = new a();
        this.J = new b();
        this.K = new c();
        this.L = new C0649d();
    }

    @Override // com.vivo.mobilead.unified.interstitial.a, com.vivo.mobilead.unified.a
    public void d() {
        super.d();
        this.G = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.f29661a = null;
    }

    @Override // com.vivo.mobilead.unified.interstitial.a, com.vivo.mobilead.unified.a
    public void l() {
        try {
            KsAdSDK.getLoadManager().loadInterstitialAd(new KsScene.Builder(Long.parseLong(this.f29662b.getPositionId())).build(), this.I);
        } catch (Exception unused) {
            a(new l0().a("暂无广告，请重试").b(402130).a(false).a(c.a.f28915d));
        }
    }

    @Override // com.vivo.mobilead.unified.interstitial.a
    public void o() {
        try {
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(new KsScene.Builder(Long.parseLong(this.f29662b.getPositionId())).build(), this.J);
        } catch (Exception unused) {
            a(new l0().a("暂无广告，请重试").b(402130).a(false).a(c.a.f28915d));
        }
    }

    @Override // com.vivo.mobilead.unified.interstitial.a
    public void q() {
        Activity activity = this.v;
        if (activity == null || activity.isFinishing() || this.H == null) {
            return;
        }
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(false).build();
        this.H.setAdInteractionListener(this.L);
        this.H.showInterstitialAd(this.v, build);
    }

    @Override // com.vivo.mobilead.unified.interstitial.a, com.vivo.mobilead.unified.a
    public void a(int i2) {
        if (!v.a()) {
            a(new l0().a("暂无广告，请重试").b(402130).a(false).a(c.a.f28915d));
            return;
        }
        k0.a(this.f29662b.getPositionId(), this.f29663c, "1", 1, 1, 1, c.a.f28915d.intValue(), i2);
        this.F = i2;
        if (i2 == 2) {
            o();
        } else {
            l();
        }
    }

    @Override // com.vivo.mobilead.unified.interstitial.a
    public void a(Activity activity) {
        KsFullScreenVideoAd ksFullScreenVideoAd;
        if (activity == null || activity.isFinishing() || (ksFullScreenVideoAd = this.G) == null || !ksFullScreenVideoAd.isAdEnable()) {
            return;
        }
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(true).build();
        this.G.setFullScreenVideoAdInteractionListener(this.K);
        this.G.showFullScreenVideoAd(activity, build);
    }
}
