package cn.vlion.ad.inland.base;

import android.content.Context;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class o2 {

    /* renamed from: a */
    public final Context f3242a;

    /* renamed from: b */
    public VlionAdapterADConfig f3243b;

    /* renamed from: c */
    public a3 f3244c;

    public o2(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        this.f3242a = context;
        this.f3243b = vlionAdapterADConfig;
    }

    public final void a(VlionBiddingLoadListener vlionBiddingLoadListener) {
        try {
            LogVlion.e("VlionCustomFeedAd loadAd");
            VlionAdapterADConfig vlionAdapterADConfig = this.f3243b;
            if (vlionAdapterADConfig == null) {
                LogVlion.e("VlionCustomFeedAd loadAd: vlionAdapterADConfig is null");
                if (vlionBiddingLoadListener != null) {
                    i1 i1Var = i1.f2918h;
                    vlionBiddingLoadListener.onAdLoadFailure(i1Var.f2920a, i1Var.f2921b);
                    return;
                }
                return;
            }
            i1 a10 = m1.a(vlionAdapterADConfig);
            if (a10 != null) {
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(a10.f2920a, a10.f2921b);
                    return;
                }
                return;
            }
            a3 a3Var = this.f3244c;
            if (a3Var != null) {
                try {
                    f7 f7Var = a3Var.f2596f;
                    if (f7Var != null) {
                        f7Var.a();
                        a3Var.f2596f = null;
                    }
                    y2 y2Var = a3Var.f2597g;
                    if (y2Var != null) {
                        y2Var.post(new b3(a3Var));
                    }
                    if (a3Var.f2598h != null) {
                        a3Var.f2598h = null;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
            a3 a3Var2 = new a3(this.f3242a, this.f3243b);
            this.f3244c = a3Var2;
            try {
                LogVlion.e("VlionCustomFeedAdManager loadData=");
                f4.a(2, a3Var2.f2595e, new z2(a3Var2, vlionBiddingLoadListener));
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }

    public final void a(boolean z10) {
        try {
            a3 a3Var = this.f3244c;
            if (a3Var != null) {
                try {
                    VlionCustomParseAdData vlionCustomParseAdData = a3Var.f2598h;
                    if (vlionCustomParseAdData == null) {
                        VlionBiddingActionListener vlionBiddingActionListener = a3Var.f2594d;
                        if (vlionBiddingActionListener != null) {
                            i1 i1Var = i1.f2919i;
                            vlionBiddingActionListener.onAdRenderFailure(i1Var.f2920a, i1Var.f2921b);
                        }
                    } else {
                        vlionCustomParseAdData.setSingleBid(z10);
                        a3Var.a(a3Var.f2598h);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}
