package cn.vlion.ad.inland.core;

import android.app.Activity;
import android.content.Context;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.config.VlionSlotConfig;
import cn.vlion.ad.inland.core.reward.VlionRewardVideoListener;

/* loaded from: classes.dex */
public final class h0 extends d0 {

    /* renamed from: h */
    public VlionRewardVideoListener f3605h;

    public class a implements m {
        public a() {
        }

        public final void a() {
            LogVlion.e("VlionRewardedVideoManager onAdClick ");
            if (h0.this.f3605h != null) {
                h0.this.f3605h.onAdClick();
            }
        }

        public final void b() {
            LogVlion.e("VlionRewardedVideoManager onAdClose ");
            if (h0.this.f3605h != null) {
                h0.this.f3605h.onAdClose();
            }
            h0.this.d();
        }

        public final void c() {
            LogVlion.e("VlionRewardedVideoManager onAdExposure ");
            if (h0.this.f3605h != null) {
                h0.this.f3605h.onAdExposure();
            }
        }

        public final void d() {
            LogVlion.e("VlionRewardedVideoManager onAdRenderSuccess ");
            if (h0.this.f3605h != null) {
                h0.this.f3605h.onAdRenderSuccess();
            }
        }

        public final void e() {
            LogVlion.e("VlionRewardedVideoManager onAdReward ");
            if (h0.this.f3605h != null) {
                h0.this.f3605h.onAdReward();
            }
        }

        public final void f() {
            LogVlion.e("VlionRewardedVideoManager onAdVideoPlayComplete ");
            if (h0.this.f3605h != null) {
                h0.this.f3605h.onVideoCompleted();
            }
        }

        public final void g() {
            LogVlion.e("VlionRewardedVideoManager onAdVideoSkip ");
            if (h0.this.f3605h != null) {
                h0.this.f3605h.onAdVideoSkip();
            }
        }

        public final void h() {
            LogVlion.e("VlionRewardedVideoManager onAdVideoStart ");
            if (h0.this.f3605h != null) {
                h0.this.f3605h.onVideoStart();
            }
        }

        public final void a(double d10) {
            LogVlion.e("VlionRewardedVideoManager onAdBiddingSuccess price=" + d10 + " isFinished=" + h0.this.f3576d);
            h0.this.b();
            if (h0.this.f3605h != null) {
                h0.this.f3605h.onAdLoadSuccess(d10);
            }
        }

        public final void b(VlionAdError vlionAdError) {
            LogVlion.e("VlionRewardedVideoManager onAdPlayFailure ");
            if (h0.this.f3605h != null) {
                h0.this.f3605h.onAdPlayFailure(vlionAdError);
            }
        }

        public final void c(VlionAdError vlionAdError) {
            LogVlion.e("VlionRewardedVideoManager onAdRenderFailure ");
            if (h0.this.f3605h != null) {
                h0.this.f3605h.onAdRenderFailure(vlionAdError);
            }
        }

        public final void d(VlionAdError vlionAdError) {
            LogVlion.e("VlionRewardedVideoManager onAdShowFailure ");
            if (h0.this.f3605h != null) {
                h0.this.f3605h.onAdShowFailure(vlionAdError);
            }
        }

        public final void a(VlionAdError vlionAdError) {
            StringBuilder a10 = f.a("VlionRewardedVideoManager onAdBiddingFailure  isFinished=");
            a10.append(h0.this.f3576d);
            LogVlion.e(a10.toString());
            h0.this.b();
            if (h0.this.f3605h != null) {
                h0.this.f3605h.onAdLoadFailure(vlionAdError);
            }
        }
    }

    public h0(Context context, VlionSlotConfig vlionSlotConfig) {
        super(context);
        try {
            this.f3574b = d.a(vlionSlotConfig, 3);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(Activity activity) {
        try {
            u uVar = this.f3573a;
            if (uVar != null) {
                uVar.b(activity);
            } else {
                VlionRewardVideoListener vlionRewardVideoListener = this.f3605h;
                if (vlionRewardVideoListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_NOT_READY_ERROR;
                    vlionRewardVideoListener.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
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
            if (this.f3605h != null) {
                this.f3605h = null;
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
            this.f3573a.k();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void a(VlionAdError vlionAdError) {
        VlionRewardVideoListener vlionRewardVideoListener = this.f3605h;
        if (vlionRewardVideoListener != null) {
            vlionRewardVideoListener.onAdLoadFailure(vlionAdError);
        }
    }

    public final void a(VlionRewardVideoListener vlionRewardVideoListener) {
        try {
            this.f3605h = vlionRewardVideoListener;
            VlionAdError a10 = e.a(this.f3575c, this.f3574b);
            if (a10 == null) {
                e();
            } else if (vlionRewardVideoListener != null) {
                vlionRewardVideoListener.onAdLoadFailure(a10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
