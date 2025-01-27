package cn.vlion.ad.inland.base;

import android.text.TextUtils;
import android.view.View;
import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.VlionAdStrategyUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class q4 implements g0 {

    /* renamed from: a */
    public final /* synthetic */ r4 f3325a;

    public q4(r4 r4Var) {
        this.f3325a = r4Var;
    }

    @Override // cn.vlion.ad.inland.base.g0
    public final void a(i1 i1Var) {
        try {
            VlionBiddingActionListener vlionBiddingActionListener = this.f3325a.f3353i;
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
        try {
            this.f3325a.f3355k = System.currentTimeMillis();
            this.f3325a.f3350f = new j(this.f3325a.f3347c, new a());
            r4 r4Var = this.f3325a;
            r4Var.f3350f.a(view, r4Var.f3348d, r4Var.f3351g);
            r4 r4Var2 = this.f3325a;
            VlionBiddingActionListener vlionBiddingActionListener = r4Var2.f3353i;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdRenderSuccess(r4Var2.f3350f);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public class a implements k1 {
        public a() {
        }

        public final void a(VlionADClickType vlionADClickType) {
            try {
                VlionAdapterADConfig vlionAdapterADConfig = q4.this.f3325a.f3348d;
                if (vlionAdapterADConfig != null) {
                    vlionAdapterADConfig.setVlionADClickType(vlionADClickType);
                }
                if (!q4.this.f3325a.f2719b) {
                    if (vlionADClickType.getVlionBaseParameterReplace() != null) {
                        vlionADClickType.getVlionBaseParameterReplace().handleExposureParameter(q4.this.f3325a.f3354j);
                        vlionADClickType.getVlionBaseParameterReplace().handleRenderSuccessParameter(q4.this.f3325a.f3355k);
                    }
                    c5.a(q4.this.f3325a.f3351g, vlionADClickType);
                    if (TextUtils.equals(VlionCustomAdActiveType$VlionCustomTarget.deeplink.toString(), vlionADClickType.getTarget())) {
                        c5.b(q4.this.f3325a.f3351g, vlionADClickType);
                    }
                    r4 r4Var = q4.this.f3325a;
                    r4Var.f2719b = true;
                    if (r4Var.f3348d != null && !vlionADClickType.isDefaultAdStrategy()) {
                        VlionAdStrategyUtils.getInstance().setStrategyBean(q4.this.f3325a.f3348d.getAdxTagId());
                    }
                }
                VlionBiddingActionListener vlionBiddingActionListener = q4.this.f3325a.f3353i;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        public final void a() {
            try {
                r4 r4Var = q4.this.f3325a;
                if (!r4Var.f2718a) {
                    r4Var.f3354j = System.currentTimeMillis();
                    r4 r4Var2 = q4.this.f3325a;
                    c5.a(r4Var2.f3351g, r4Var2.f3350f, r4Var2.f3354j, r4Var2.f3355k);
                    q4.this.f3325a.f2718a = true;
                }
                VlionBiddingActionListener vlionBiddingActionListener = q4.this.f3325a.f3353i;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }
}
