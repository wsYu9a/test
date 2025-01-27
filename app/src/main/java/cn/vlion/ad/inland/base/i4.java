package cn.vlion.ad.inland.base;

import android.content.Context;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class i4 {

    /* renamed from: a */
    public final Context f2946a;

    /* renamed from: b */
    public VlionAdapterADConfig f2947b;

    /* renamed from: c */
    public cn.vlion.ad.inland.ad.reward.a f2948c;

    public i4(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        this.f2946a = context;
        this.f2947b = vlionAdapterADConfig;
    }

    public final void a(VlionBiddingLoadListener vlionBiddingLoadListener) {
        try {
            VlionAdapterADConfig vlionAdapterADConfig = this.f2947b;
            if (vlionAdapterADConfig == null) {
                LogVlion.e("VlionCustomRewardedVideoAd loadAd: vlionAdapterADConfig is null");
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
            cn.vlion.ad.inland.ad.reward.a aVar = this.f2948c;
            if (aVar != null) {
                try {
                    if (aVar.f2360f != null) {
                        aVar.f2360f = null;
                    }
                    b5 b5Var = aVar.f2363i;
                    if (b5Var != null) {
                        try {
                            b5Var.f2672d = true;
                            b5Var.f2669a = 1;
                            try {
                                if (j7.f2999a != null) {
                                    LogVlion.e("WriteFileUtils onDestroy: ");
                                    j7.f2999a.shutdownNow();
                                    j7.f2999a = null;
                                }
                            } catch (Throwable th2) {
                                VlionSDkManager.getInstance().upLoadCatchException(th2);
                            }
                            b5Var.f2671c = null;
                        } catch (Throwable th3) {
                            VlionSDkManager.getInstance().upLoadCatchException(th3);
                        }
                        aVar.f2363i = null;
                    }
                } catch (Throwable th4) {
                    VlionSDkManager.getInstance().upLoadCatchException(th4);
                }
            }
            cn.vlion.ad.inland.ad.reward.a aVar2 = new cn.vlion.ad.inland.ad.reward.a(this.f2946a, this.f2947b);
            this.f2948c = aVar2;
            try {
                LogVlion.e("loadData=");
                f4.a(3, aVar2.f2359e, new j4(aVar2, vlionBiddingLoadListener));
            } catch (Throwable th5) {
                VlionSDkManager.getInstance().upLoadCatchException(th5);
            }
        } catch (Throwable th6) {
            VlionSDkManager.getInstance().upLoadCatchException(th6);
        }
    }

    public final void a(boolean z10) {
        try {
            cn.vlion.ad.inland.ad.reward.a aVar = this.f2948c;
            if (aVar != null) {
                try {
                    VlionCustomParseAdData vlionCustomParseAdData = aVar.f2360f;
                    if (vlionCustomParseAdData == null) {
                        VlionBiddingActionRewardListener vlionBiddingActionRewardListener = aVar.f2358d;
                        if (vlionBiddingActionRewardListener != null) {
                            i1 i1Var = i1.f2919i;
                            vlionBiddingActionRewardListener.onAdRenderFailure(i1Var.f2920a, i1Var.f2921b);
                        }
                    } else {
                        vlionCustomParseAdData.setSingleBid(z10);
                        aVar.a(aVar.f2360f);
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
