package cn.vlion.ad.inland.core;

import android.app.Activity;
import android.view.View;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.banner.VlionBannerAd;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.config.VlionSlotConfig;

/* loaded from: classes.dex */
public final class g extends d0 {

    /* renamed from: h */
    public l f3585h;

    /* renamed from: i */
    public Activity f3586i;

    public class a implements l {
        public a() {
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void a(double d10) {
            LogVlion.e("VlionBannerManager onAdBiddingSuccess price=" + d10 + " isFinished=" + g.this.f3576d);
            g.this.b();
            if (g.this.f3585h != null) {
                g.this.f3585h.a(d10);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdClick() {
            LogVlion.e("VlionBannerManager onAdClick");
            if (g.this.f3585h != null) {
                g.this.f3585h.onAdClick();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdClose() {
            LogVlion.e("VlionBannerManager onAdClose");
            if (g.this.f3585h != null) {
                g.this.f3585h.onAdClose();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdExposure() {
            LogVlion.e("VlionBannerManager onAdExposure");
            if (g.this.f3585h != null) {
                g.this.f3585h.onAdExposure();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdRenderFailure(VlionAdError vlionAdError) {
            LogVlion.e("VlionBannerManager onAdRenderFailure");
            if (g.this.f3585h != null) {
                g.this.f3585h.onAdRenderFailure(vlionAdError);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdRenderSuccess(View view) {
            LogVlion.e("VlionBannerManager onAdRenderSuccess");
            if (g.this.f3585h != null) {
                g.this.f3585h.onAdRenderSuccess(view);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdShowFailure(VlionAdError vlionAdError) {
            StringBuilder a10 = f.a("VlionBannerManager onAdShowFailure  isFinished=");
            a10.append(g.this.f3576d);
            LogVlion.e(a10.toString());
            if (g.this.f3585h != null) {
                g.this.f3585h.onAdShowFailure(vlionAdError);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdSkip() {
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void a(VlionAdError vlionAdError) {
            StringBuilder a10 = f.a("VlionBannerManager onAdBiddingFailure  isFinished=");
            a10.append(g.this.f3576d);
            LogVlion.e(a10.toString());
            g.this.b();
            if (g.this.f3585h != null) {
                g.this.f3585h.a(vlionAdError);
            }
        }
    }

    public g(Activity activity, VlionSlotConfig vlionSlotConfig) {
        super(activity);
        try {
            this.f3586i = activity;
            this.f3574b = d.a(vlionSlotConfig, 1);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void a(VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean) {
        try {
            u uVar = this.f3573a;
            if (uVar != null) {
                uVar.a();
                this.f3573a = null;
            }
            Activity activity = this.f3586i;
            if (activity != null) {
                u uVar2 = new u(activity, this.f3574b, placementBean);
                this.f3573a = uVar2;
                uVar2.a(new a());
                this.f3573a.f();
                return;
            }
            LogVlion.e("VlionBannerManager onAdBiddingFailure  isFinished=" + this.f3576d);
            b();
            l lVar = this.f3585h;
            VlionAdBaseError vlionAdBaseError = VlionAdBaseError.LOAD_AD_CONTEXT_IS_NULL;
            lVar.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void d() {
        try {
            super.d();
            if (this.f3585h != null) {
                this.f3585h = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(VlionBannerAd.a aVar) {
        this.f3585h = aVar;
        try {
            VlionAdError a10 = e.a(this.f3575c, this.f3574b);
            if (a10 != null) {
                aVar.a(a10);
            } else {
                e();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void a(VlionAdError vlionAdError) {
        l lVar = this.f3585h;
        if (lVar != null) {
            lVar.a(vlionAdError);
        }
    }
}
