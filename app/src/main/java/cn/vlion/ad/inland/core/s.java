package cn.vlion.ad.inland.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.config.VlionSlotConfig;
import cn.vlion.ad.inland.core.feed.VlionFeedListener;

/* loaded from: classes.dex */
public final class s extends d0 {

    /* renamed from: h */
    public VlionFeedListener f3759h;

    public class a implements l {

        /* renamed from: a */
        public final /* synthetic */ LinearLayout f3760a;

        public a(LinearLayout linearLayout) {
            this.f3760a = linearLayout;
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void a(double d10) {
            LogVlion.e("VlionFeedManager onAdBiddingSuccess price=" + d10 + " isFinished=" + s.this.f3576d);
            s.this.b();
            if (s.this.f3759h != null) {
                s.this.f3759h.onAdLoadSuccess(d10);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdClick() {
            LogVlion.e("VlionFeedManager onAdClick ");
            if (s.this.f3759h != null) {
                s.this.f3759h.onAdClick();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdClose() {
            LogVlion.e("VlionFeedManager onAdClose ");
            if (s.this.f3759h != null) {
                s.this.f3759h.onAdClose();
            }
            s.this.d();
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdExposure() {
            LogVlion.e("VlionFeedManager onAdExposure ");
            if (s.this.f3759h != null) {
                s.this.f3759h.onAdExposure();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdRenderFailure(VlionAdError vlionAdError) {
            LogVlion.e("VlionFeedManager onAdRenderFailure ");
            if (s.this.f3759h != null) {
                s.this.f3759h.onAdRenderFailure(vlionAdError);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdRenderSuccess(View view) {
            StringBuilder a10 = f.a("VlionFeedManager onAdRenderSuccess feedView==null");
            a10.append(view == null);
            LogVlion.e(a10.toString());
            if (view != null) {
                try {
                    this.f3760a.removeAllViews();
                    if (s.this.f3759h != null) {
                        s.this.f3759h.onAdRenderSuccess(this.f3760a);
                    }
                    if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    this.f3760a.addView(view, new LinearLayout.LayoutParams(-1, -2));
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdShowFailure(VlionAdError vlionAdError) {
            StringBuilder a10 = f.a("VlionFeedManager onAdShowFailure  isFinished=");
            a10.append(s.this.f3576d);
            LogVlion.e(a10.toString());
            if (s.this.f3759h != null) {
                s.this.f3759h.onAdShowFailure(vlionAdError);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdSkip() {
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void a(VlionAdError vlionAdError) {
            StringBuilder a10 = f.a("VlionFeedManager onAdFailure  isFinished=");
            a10.append(s.this.f3576d);
            LogVlion.e(a10.toString());
            s.this.b();
            if (s.this.f3759h != null) {
                s.this.f3759h.onAdLoadFailure(vlionAdError);
            }
        }
    }

    public s(Context context, VlionSlotConfig vlionSlotConfig) {
        super(context);
        try {
            this.f3574b = d.a(vlionSlotConfig, 2);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void a(VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean) {
        try {
            if (this.f3575c != null) {
                LinearLayout linearLayout = new LinearLayout(this.f3575c);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout.setGravity(17);
                u uVar = new u(this.f3575c, this.f3574b, placementBean);
                this.f3573a = uVar;
                uVar.a(new a(linearLayout));
                this.f3573a.h();
                return;
            }
            LogVlion.e("VlionBannerManager onAdBiddingFailure  isFinished=" + this.f3576d);
            b();
            VlionFeedListener vlionFeedListener = this.f3759h;
            VlionAdBaseError vlionAdBaseError = VlionAdBaseError.LOAD_AD_CONTEXT_IS_NULL;
            vlionFeedListener.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void d() {
        try {
            super.d();
            if (this.f3759h != null) {
                this.f3759h = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void a(VlionAdError vlionAdError) {
        VlionFeedListener vlionFeedListener = this.f3759h;
        if (vlionFeedListener != null) {
            vlionFeedListener.onAdLoadFailure(vlionAdError);
        }
    }

    public final void a(VlionFeedListener vlionFeedListener) {
        this.f3759h = vlionFeedListener;
        try {
            VlionAdError a10 = e.a(this.f3575c, this.f3574b);
            if (a10 == null) {
                e();
            } else if (vlionFeedListener != null) {
                vlionFeedListener.onAdLoadFailure(a10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
