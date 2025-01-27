package cn.vlion.ad.inland.base;

import android.content.Context;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class y3 {

    /* renamed from: a */
    public final Context f3528a;

    /* renamed from: b */
    public VlionAdapterADConfig f3529b;

    /* renamed from: c */
    public z3 f3530c;

    public y3(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        this.f3528a = context;
        this.f3529b = vlionAdapterADConfig;
    }

    public final void a(VlionBiddingLoadListener vlionBiddingLoadListener) {
        try {
            LogVlion.e("VlionCustomNativeAd loadAd");
            VlionAdapterADConfig vlionAdapterADConfig = this.f3529b;
            if (vlionAdapterADConfig == null) {
                LogVlion.e("VlionCustomNativeAd loadAd: vlionAdapterADConfig is null");
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
            z3 z3Var = this.f3530c;
            if (z3Var != null) {
                try {
                    q0 q0Var = z3Var.f3546g;
                    if (q0Var != null) {
                        q0Var.a();
                        z3Var.f3546g = null;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
            z3 z3Var2 = new z3(this.f3528a, this.f3529b);
            this.f3530c = z3Var2;
            z3Var2.f3544e = vlionBiddingLoadListener;
            z3Var2.a();
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}
