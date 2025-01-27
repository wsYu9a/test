package com.vivo.mobilead.unified.splash;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;

/* loaded from: classes4.dex */
public class b extends g {
    private SplashAD H;
    private boolean I;
    private long J;
    private ViewTreeObserver.OnPreDrawListener K;
    private View.OnAttachStateChangeListener L;

    class a implements SplashADListener {
        a() {
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = b.this.u;
            if (unifiedVivoSplashAdListener != null) {
                unifiedVivoSplashAdListener.onAdClick();
            }
            k0.a("3", String.valueOf(c.a.f28914c), ((com.vivo.mobilead.unified.a) b.this).f29664d, ((com.vivo.mobilead.unified.a) b.this).f29663c, ((com.vivo.mobilead.unified.a) b.this).f29665e, 1, false);
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = b.this.u;
            if (unifiedVivoSplashAdListener != null) {
                unifiedVivoSplashAdListener.onAdSkip();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
            UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = b.this.u;
            if (unifiedVivoSplashAdListener != null) {
                unifiedVivoSplashAdListener.onAdShow();
            }
            k0.a("3", String.valueOf(c.a.f28914c), ((com.vivo.mobilead.unified.a) b.this).f29664d, ((com.vivo.mobilead.unified.a) b.this).f29663c, ((com.vivo.mobilead.unified.a) b.this).f29665e, System.currentTimeMillis() - b.this.z, 1);
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j2) {
            b.this.J = j2;
            b bVar = b.this;
            k0.a(bVar.A, ((com.vivo.mobilead.unified.a) bVar).f29663c, "3", ((com.vivo.mobilead.unified.a) b.this).f29664d, 1, 1, 1, -10000, "", c.a.f28914c.intValue());
            b.this.q();
            b.this.a(new l0().a(c.a.f28914c).a(true));
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j2) {
            UnifiedVivoSplashAdListener unifiedVivoSplashAdListener;
            if (j2 != 0 || (unifiedVivoSplashAdListener = b.this.u) == null) {
                return;
            }
            unifiedVivoSplashAdListener.onAdTimeOver();
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = b.this.u;
            if (unifiedVivoSplashAdListener != null) {
                unifiedVivoSplashAdListener.onAdFailed(new VivoAdError(adError.getErrorCode(), adError.getErrorMsg()));
            }
            b bVar = b.this;
            k0.a(bVar.A, ((com.vivo.mobilead.unified.a) bVar).f29663c, "3", ((com.vivo.mobilead.unified.a) b.this).f29664d, 1, 1, 2, adError.getErrorCode(), adError.getErrorMsg(), c.a.f28914c.intValue());
        }
    }

    /* renamed from: com.vivo.mobilead.unified.splash.b$b */
    class ViewTreeObserverOnPreDrawListenerC0659b implements ViewTreeObserver.OnPreDrawListener {
        ViewTreeObserverOnPreDrawListenerC0659b() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!b.this.I) {
                b.this.I = true;
                boolean z = SystemClock.elapsedRealtime() >= b.this.J;
                if (b.this.H == null || z) {
                    UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = b.this.u;
                    if (unifiedVivoSplashAdListener != null) {
                        unifiedVivoSplashAdListener.onAdFailed(new VivoAdError(402134, "广告展示超时"));
                    }
                } else {
                    b.this.H.showAd(b.this.G);
                }
                b.this.G.getViewTreeObserver().removeOnPreDrawListener(b.this.K);
            }
            return true;
        }
    }

    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b.this.G.getViewTreeObserver().addOnPreDrawListener(b.this.K);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            b.this.G.removeOnAttachStateChangeListener(this);
        }
    }

    public b(Activity activity, AdParams adParams) {
        super(activity, adParams);
        this.K = new ViewTreeObserverOnPreDrawListenerC0659b();
        this.L = new c();
    }

    public void q() {
        this.G.addOnAttachStateChangeListener(this.L);
    }

    @Override // com.vivo.mobilead.unified.a
    public void l() {
        this.H = new SplashAD(this.F, this.f29662b.getPositionId(), new a());
        try {
            k0.a(this.f29662b.getPositionId(), this.f29663c, "3", 1, 1, 1, c.a.f28914c.intValue(), 1, com.vivo.mobilead.manager.b.l().getInt("splash_orientation_key", 1));
        } catch (Exception unused) {
        }
        SplashAD splashAD = this.H;
        if (splashAD != null) {
            splashAD.fetchAdOnly();
        }
    }
}
