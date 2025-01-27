package cn.vlion.ad.inland.base;

import android.text.TextUtils;
import android.view.View;
import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.VlionAdStrategyUtils;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class p1 implements g0 {

    /* renamed from: a */
    public final /* synthetic */ VlionCustomParseAdData f3272a;

    /* renamed from: b */
    public final /* synthetic */ q1 f3273b;

    public class a implements r1 {
        public a() {
        }

        public final void a(VlionADClickType vlionADClickType) {
            try {
                VlionAdapterADConfig vlionAdapterADConfig = p1.this.f3273b.f3306d;
                if (vlionAdapterADConfig != null) {
                    vlionAdapterADConfig.setVlionADClickType(vlionADClickType);
                }
                LogVlion.e("VlionCustomBannerAdManager isReadyClick =" + p1.this.f3273b.f2719b);
                if (!p1.this.f3273b.f2719b) {
                    if (vlionADClickType.getVlionBaseParameterReplace() != null) {
                        if (p1.this.f3273b.f3311i.isVideo()) {
                            VlionBaseParameterReplace vlionBaseParameterReplace = vlionADClickType.getVlionBaseParameterReplace();
                            q1 q1Var = p1.this.f3273b;
                            vlionBaseParameterReplace.handleVideoParameter(q1Var.f3314l, q1Var.f3315m, q1Var.f3311i.getDuration());
                        }
                        vlionADClickType.getVlionBaseParameterReplace().handleExposureParameter(p1.this.f3273b.f3317o);
                        vlionADClickType.getVlionBaseParameterReplace().handleRenderSuccessParameter(p1.this.f3273b.f3318p);
                    }
                    c5.a(p1.this.f3273b.f3311i, vlionADClickType);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("VlionCustomBannerAdManager onAdClick =");
                    VlionCustomAdActiveType$VlionCustomTarget vlionCustomAdActiveType$VlionCustomTarget = VlionCustomAdActiveType$VlionCustomTarget.deeplink;
                    sb2.append(vlionCustomAdActiveType$VlionCustomTarget);
                    sb2.append("   ");
                    sb2.append(vlionADClickType.getTarget());
                    LogVlion.e(sb2.toString());
                    LogVlion.e("VlionCustomBannerAdManager onAdClick =" + TextUtils.equals(vlionCustomAdActiveType$VlionCustomTarget.toString(), vlionADClickType.getTarget()));
                    if (TextUtils.equals(vlionCustomAdActiveType$VlionCustomTarget.toString(), vlionADClickType.getTarget())) {
                        c5.b(p1.this.f3273b.f3311i, vlionADClickType);
                    }
                    q1 q1Var2 = p1.this.f3273b;
                    q1Var2.f2719b = true;
                    if (q1Var2.f3306d != null && !vlionADClickType.isDefaultAdStrategy()) {
                        VlionAdStrategyUtils.getInstance().setStrategyBean(p1.this.f3273b.f3306d.getAdxTagId());
                    }
                }
                VlionBiddingActionListener vlionBiddingActionListener = p1.this.f3273b.f3308f;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements cn.vlion.ad.inland.base.a {
        public b() {
        }

        @Override // cn.vlion.ad.inland.base.a
        public final void onAdEnter() {
            VlionADEventManager.getParameterEnter(p1.this.f3273b.f3306d);
        }

        @Override // cn.vlion.ad.inland.base.a
        public final void onAdExposure() {
            try {
                q1 q1Var = p1.this.f3273b;
                if (!q1Var.f2718a) {
                    q1Var.f3317o = System.currentTimeMillis();
                    q1 q1Var2 = p1.this.f3273b;
                    c5.a(q1Var2.f3311i, q1Var2.f3313k, q1Var2.f3317o, q1Var2.f3318p);
                    p1.this.f3273b.f2718a = true;
                }
                VlionBiddingActionListener vlionBiddingActionListener = p1.this.f3273b.f3308f;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public p1(q1 q1Var, VlionCustomParseAdData vlionCustomParseAdData) {
        this.f3273b = q1Var;
        this.f3272a = vlionCustomParseAdData;
    }

    @Override // cn.vlion.ad.inland.base.g0
    public final void a(i1 i1Var) {
        try {
            LogVlion.e("VlionCustomBannerAdManager onAdRenderFailure");
            VlionBiddingActionListener vlionBiddingActionListener = this.f3273b.f3308f;
            if (vlionBiddingActionListener == null || i1Var == null) {
                return;
            }
            vlionBiddingActionListener.onAdRenderFailure(i1Var.f2920a, i1Var.f2921b);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.g0
    public final void onAdRenderSuccess(View view) {
        LogVlion.e("VlionCustomBannerAdManager onAdRenderSuccess");
        if (view != null) {
            try {
                this.f3273b.f3318p = System.currentTimeMillis();
                this.f3273b.f3313k = new v1(this.f3273b.f3305c);
                q1 q1Var = this.f3273b;
                q1Var.f3313k.a(view, q1Var.f3306d, this.f3272a, new a());
                this.f3273b.f3313k.setAdExposureListener(new b());
                this.f3273b.f3313k.a();
                q1 q1Var2 = this.f3273b;
                VlionBiddingActionListener vlionBiddingActionListener = q1Var2.f3308f;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdRenderSuccess(q1Var2.f3313k);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }
}
