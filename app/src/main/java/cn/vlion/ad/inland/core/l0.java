package cn.vlion.ad.inland.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.config.VlionSlotConfig;
import cn.vlion.ad.inland.core.splash.VlionSplashListener;

/* loaded from: classes.dex */
public final class l0 extends d0 {

    /* renamed from: h */
    public VlionSplashListener f3694h;

    public class a implements l {
        public a() {
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void a(double d10) {
            LogVlion.e("VlionSplashManager onAdBiddingSuccess price=" + d10 + " isFinished=" + l0.this.f3576d);
            l0.this.b();
            if (l0.this.f3694h != null) {
                l0.this.f3694h.onAdLoadSuccess(d10);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdClick() {
            LogVlion.e("VlionSplashManager onAdClick ");
            if (l0.this.f3694h != null) {
                l0.this.f3694h.onAdClick();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdClose() {
            LogVlion.e("VlionSplashManager onAdClose ");
            if (l0.this.f3694h != null) {
                l0.this.f3694h.onAdClose();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdExposure() {
            LogVlion.e("VlionSplashManager onAdExposure ");
            if (l0.this.f3694h != null) {
                l0.this.f3694h.onAdExposure();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdRenderFailure(VlionAdError vlionAdError) {
            LogVlion.e("VlionSplashManager onAdRenderFailure ");
            if (l0.this.f3694h != null) {
                l0.this.f3694h.onAdRenderFailure(vlionAdError);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdRenderSuccess(View view) {
            LogVlion.e("VlionSplashManager onAdRenderSuccess ");
            if (l0.this.f3694h != null) {
                l0.this.f3694h.onAdRenderSuccess();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdShowFailure(VlionAdError vlionAdError) {
            StringBuilder a10 = f.a("VlionSplashManager onAdShowFailure  isFinished=");
            a10.append(l0.this.f3576d);
            LogVlion.e(a10.toString());
            if (l0.this.f3694h != null) {
                l0.this.f3694h.onAdShowFailure(vlionAdError);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdSkip() {
            LogVlion.e("VlionSplashManager onAdSkip ");
            if (l0.this.f3694h != null) {
                l0.this.f3694h.onAdSkip();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void a(VlionAdError vlionAdError) {
            StringBuilder a10 = f.a("VlionSplashManager onAdBiddingFailure  isFinished=");
            a10.append(l0.this.f3576d);
            LogVlion.e(a10.toString());
            l0.this.b();
            if (l0.this.f3694h != null) {
                l0.this.f3694h.onAdLoadFailure(vlionAdError);
            }
        }
    }

    public l0(Context context, VlionSlotConfig vlionSlotConfig) {
        super(context);
        try {
            this.f3574b = d.a(vlionSlotConfig, 5);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(ViewGroup viewGroup) {
        try {
            u uVar = this.f3573a;
            if (uVar != null) {
                uVar.a(viewGroup);
            } else {
                VlionSplashListener vlionSplashListener = this.f3694h;
                if (vlionSplashListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_NOT_READY_ERROR;
                    vlionSplashListener.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void d() {
        try {
            super.d();
            if (this.f3694h != null) {
                this.f3694h = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void a(VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean) {
        try {
            u uVar = new u(this.f3575c, this.f3574b, placementBean);
            this.f3573a = uVar;
            uVar.a(new a());
            this.f3573a.l();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void a(VlionAdError vlionAdError) {
        VlionSplashListener vlionSplashListener = this.f3694h;
        if (vlionSplashListener != null) {
            vlionSplashListener.onAdLoadFailure(vlionAdError);
        }
    }

    public final void a(VlionSplashListener vlionSplashListener) {
        try {
            this.f3694h = vlionSplashListener;
            VlionAdError a10 = e.a(this.f3575c, this.f3574b);
            if (a10 == null) {
                e();
            } else if (vlionSplashListener != null) {
                vlionSplashListener.onAdLoadFailure(a10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
