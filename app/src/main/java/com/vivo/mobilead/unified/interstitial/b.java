package com.vivo.mobilead.unified.interstitial;

import android.app.Activity;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.util.AdError;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;

/* loaded from: classes4.dex */
public class b extends g {
    private UnifiedInterstitialAD F;
    private int G;
    private UnifiedInterstitialADListener H;

    class a implements UnifiedInterstitialADListener {

        /* renamed from: com.vivo.mobilead.unified.interstitial.b$a$a */
        class C0648a implements UnifiedInterstitialMediaListener {
            C0648a() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoComplete() {
                MediaListener mediaListener = b.this.u;
                if (mediaListener != null) {
                    mediaListener.onVideoCompletion();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoError(AdError adError) {
                MediaListener mediaListener = b.this.u;
                if (mediaListener != null) {
                    mediaListener.onVideoError(new VivoAdError(com.vivo.mobilead.unified.base.f.a.a(adError.getErrorCode()), adError.getErrorMsg()));
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoInit() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoLoading() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageClose() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageOpen() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPause() {
                MediaListener mediaListener = b.this.u;
                if (mediaListener != null) {
                    mediaListener.onVideoPause();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoReady(long j2) {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoStart() {
                MediaListener mediaListener = b.this.u;
                if (mediaListener != null) {
                    mediaListener.onVideoStart();
                }
                k0.b("1", String.valueOf(c.a.f28914c), ((com.vivo.mobilead.unified.a) b.this).f29664d, ((com.vivo.mobilead.unified.a) b.this).f29663c, ((com.vivo.mobilead.unified.a) b.this).f29665e, 1);
            }
        }

        a() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = b.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdClick();
            }
            k0.a("1", String.valueOf(c.a.f28914c), ((com.vivo.mobilead.unified.a) b.this).f29664d, ((com.vivo.mobilead.unified.a) b.this).f29663c, ((com.vivo.mobilead.unified.a) b.this).f29665e, 1, false);
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = b.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdClose();
            }
            b.this.d();
            b bVar = b.this;
            bVar.t = null;
            bVar.u = null;
            bVar.v = null;
            ((com.vivo.mobilead.unified.a) bVar).f29661a = null;
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = b.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdShow();
            }
            k0.a("1", String.valueOf(c.a.f28914c), ((com.vivo.mobilead.unified.a) b.this).f29664d, ((com.vivo.mobilead.unified.a) b.this).f29663c, ((com.vivo.mobilead.unified.a) b.this).f29665e, 1);
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            if (b.this.F != null) {
                b.this.F.setMediaListener(new C0648a());
            }
            b.this.a(new l0().a(c.a.f28914c).a(true));
            k0.a(((com.vivo.mobilead.unified.a) b.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) b.this).f29663c, "1", ((com.vivo.mobilead.unified.a) b.this).f29664d, 1, b.this.G, 1, -10000, "", c.a.f28914c.intValue());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            b.this.a(new l0().a(c.a.f28914c).a(adError.getErrorMsg()).b(com.vivo.mobilead.unified.base.f.a.a(adError.getErrorCode())).a(false));
            k0.a(((com.vivo.mobilead.unified.a) b.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) b.this).f29663c, "1", ((com.vivo.mobilead.unified.a) b.this).f29664d, 1, b.this.G, 2, adError.getErrorCode(), adError.getErrorMsg(), c.a.f28914c.intValue());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
            b.this.a(new l0().a("渲染视图出现异常").b(402126).a(false).a(c.a.f28914c));
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
            b.this.s();
        }
    }

    public b(Activity activity, AdParams adParams) {
        super(activity, adParams);
        this.H = new a();
    }

    private VideoOption v() {
        return new VideoOption.Builder().setAutoPlayMuted(false).setEnableUserControl(true).setAutoPlayPolicy(2).build();
    }

    private VideoOption w() {
        return new VideoOption.Builder().setAutoPlayMuted(true).setEnableUserControl(true).setAutoPlayPolicy(0).build();
    }

    @Override // com.vivo.mobilead.unified.interstitial.a, com.vivo.mobilead.unified.a
    public void d() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.F;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.close();
            this.F.destroy();
            this.F = null;
        }
    }

    @Override // com.vivo.mobilead.unified.interstitial.a, com.vivo.mobilead.unified.a
    public void l() {
        d();
        UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD(this.v, this.f29662b.getPositionId(), this.H);
        this.F = unifiedInterstitialAD;
        unifiedInterstitialAD.setVideoOption(w());
        this.F.loadAD();
    }

    @Override // com.vivo.mobilead.unified.interstitial.a
    public void o() {
        d();
        UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD(this.v, this.f29662b.getPositionId(), this.H);
        this.F = unifiedInterstitialAD;
        unifiedInterstitialAD.setVideoPlayPolicy(2);
        this.F.setVideoOption(v());
        this.F.loadFullScreenAD();
    }

    @Override // com.vivo.mobilead.unified.interstitial.a
    public void q() {
        if (this.F == null || this.v.isFinishing()) {
            return;
        }
        this.F.show(this.v);
    }

    @Override // com.vivo.mobilead.unified.interstitial.a, com.vivo.mobilead.unified.a
    public void a(int i2) {
        k0.a(this.f29662b.getPositionId(), this.f29663c, "1", 1, 1, 1, c.a.f28914c.intValue(), i2);
        this.G = i2;
        if (i2 == 2) {
            o();
        } else {
            l();
        }
    }

    @Override // com.vivo.mobilead.unified.interstitial.a
    public void a(Activity activity) {
        if (this.F == null || activity.isFinishing()) {
            return;
        }
        this.F.showFullScreenAD(activity);
    }
}
