package cn.vlion.ad.inland.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.config.VlionSlotConfig;
import cn.vlion.ad.inland.core.draw.VlionDrawListener;

/* loaded from: classes.dex */
public final class q extends d0 {

    /* renamed from: h */
    public VlionDrawListener f3743h;

    /* renamed from: i */
    public VlionNativesAdVideoListener f3744i;

    public class a implements l {

        /* renamed from: a */
        public final /* synthetic */ LinearLayout f3745a;

        public a(LinearLayout linearLayout) {
            this.f3745a = linearLayout;
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void a(double d10) {
            LogVlion.e("VlionDrawManager onAdBiddingSuccess price=" + d10 + " isFinished=" + q.this.f3576d);
            q.this.b();
            if (q.this.f3743h != null) {
                q.this.f3743h.onAdLoadSuccess(d10);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdClick() {
            LogVlion.e("VlionDrawManager onAdClick ");
            if (q.this.f3743h != null) {
                q.this.f3743h.onAdClick();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdClose() {
            LogVlion.e("VlionDrawManager onAdClose ");
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdExposure() {
            LogVlion.e("VlionDrawManager onAdExposure ");
            if (q.this.f3743h != null) {
                q.this.f3743h.onAdExposure();
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdRenderFailure(VlionAdError vlionAdError) {
            LogVlion.e("VlionDrawManager onAdRenderFailure ");
            if (q.this.f3743h != null) {
                q.this.f3743h.onAdRenderFailure(vlionAdError);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdRenderSuccess(View view) {
            StringBuilder a10 = f.a("VlionDrawManager onAdRenderSuccess DrawView==null");
            a10.append(view == null);
            LogVlion.e(a10.toString());
            if (view != null) {
                try {
                    this.f3745a.removeAllViews();
                    if (q.this.f3743h != null) {
                        q.this.f3743h.onAdRenderSuccess(this.f3745a);
                    }
                    if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    this.f3745a.addView(view, new LinearLayout.LayoutParams(-1, -2));
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdShowFailure(VlionAdError vlionAdError) {
            StringBuilder a10 = f.a("VlionDrawManager onAdShowFailure  isFinished=");
            a10.append(q.this.f3576d);
            LogVlion.e(a10.toString());
            if (q.this.f3743h != null) {
                q.this.f3743h.onAdShowFailure(vlionAdError);
            }
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void onAdSkip() {
        }

        @Override // cn.vlion.ad.inland.core.l
        public final void a(VlionAdError vlionAdError) {
            StringBuilder a10 = f.a("VlionDrawManager onAdFailure  isFinished=");
            a10.append(q.this.f3576d);
            LogVlion.e(a10.toString());
            q.this.b();
            if (q.this.f3743h != null) {
                q.this.f3743h.onAdLoadFailure(vlionAdError);
            }
        }
    }

    public q(Context context, VlionSlotConfig vlionSlotConfig) {
        super(context);
        try {
            this.f3574b = d.a(vlionSlotConfig, 6);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void a(VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean) {
        try {
            if (this.f3575c == null) {
                LogVlion.e("VlionBannerManager onAdBiddingFailure  isFinished=" + this.f3576d);
                b();
                VlionDrawListener vlionDrawListener = this.f3743h;
                VlionAdBaseError vlionAdBaseError = VlionAdBaseError.LOAD_AD_CONTEXT_IS_NULL;
                vlionDrawListener.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                return;
            }
            LinearLayout linearLayout = new LinearLayout(this.f3575c);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.setGravity(17);
            u uVar = new u(this.f3575c, this.f3574b, placementBean);
            this.f3573a = uVar;
            uVar.a(new a(linearLayout));
            this.f3573a.a(this.f3744i);
            this.f3573a.g();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void d() {
        try {
            super.d();
            if (this.f3743h != null) {
                this.f3743h = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void a(VlionAdError vlionAdError) {
        VlionDrawListener vlionDrawListener = this.f3743h;
        if (vlionDrawListener != null) {
            vlionDrawListener.onAdLoadFailure(vlionAdError);
        }
    }

    public final void a(VlionDrawListener vlionDrawListener, VlionNativesAdVideoListener vlionNativesAdVideoListener) {
        this.f3743h = vlionDrawListener;
        this.f3744i = vlionNativesAdVideoListener;
        try {
            VlionAdError a10 = e.a(this.f3575c, this.f3574b);
            if (a10 == null) {
                e();
            } else if (vlionDrawListener != null) {
                vlionDrawListener.onAdLoadFailure(a10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
