package cn.vlion.ad.inland.base;

import android.content.Context;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class b2 {

    /* renamed from: a */
    public final Context f2640a;

    /* renamed from: b */
    public VlionAdapterADConfig f2641b;

    /* renamed from: c */
    public k2 f2642c;

    public b2(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        this.f2640a = context;
        this.f2641b = vlionAdapterADConfig;
    }

    public final void a(VlionBiddingLoadListener vlionBiddingLoadListener, VlionNativesAdVideoListener vlionNativesAdVideoListener) {
        try {
            LogVlion.e("VlionCustomDrawAd loadAd");
            VlionAdapterADConfig vlionAdapterADConfig = this.f2641b;
            if (vlionAdapterADConfig == null) {
                LogVlion.e("VlionCustomDrawAd loadAd: vlionAdapterADConfig is null");
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
            k2 k2Var = this.f2642c;
            if (k2Var != null) {
                try {
                    f7 f7Var = k2Var.f3011e;
                    if (f7Var != null) {
                        f7Var.a();
                        k2Var.f3011e = null;
                    }
                    i2 i2Var = k2Var.f3012f;
                    if (i2Var != null) {
                        i2Var.post(new m2(k2Var));
                    }
                    if (k2Var.f3013g != null) {
                        k2Var.f3013g = null;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
            k2 k2Var2 = new k2(this.f2640a, this.f2641b);
            this.f2642c = k2Var2;
            l2 l2Var = new l2(k2Var2, vlionNativesAdVideoListener);
            k2Var2.f3014h = l2Var;
            f7 f7Var2 = k2Var2.f3011e;
            if (f7Var2 != null) {
                f7Var2.f2810h = l2Var;
                a7 a7Var = f7Var2.f2806d;
                if (a7Var != null) {
                    a7Var.setVlionNativesAdVideoListener(l2Var);
                }
            }
            k2 k2Var3 = this.f2642c;
            k2Var3.getClass();
            try {
                LogVlion.e("VlionCustomDrawAdManager loadData=");
                f4.a(2, k2Var3.f3010d, new j2(k2Var3, vlionBiddingLoadListener));
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }

    public final void a(boolean z10) {
        try {
            k2 k2Var = this.f2642c;
            if (k2Var != null) {
                try {
                    VlionCustomParseAdData vlionCustomParseAdData = k2Var.f3013g;
                    if (vlionCustomParseAdData == null) {
                        VlionBiddingActionListener vlionBiddingActionListener = k2Var.f3021o;
                        if (vlionBiddingActionListener != null) {
                            i1 i1Var = i1.f2919i;
                            vlionBiddingActionListener.onAdRenderFailure(i1Var.f2920a, i1Var.f2921b);
                        }
                    } else {
                        vlionCustomParseAdData.setSingleBid(z10);
                        k2Var.a(k2Var.f3013g);
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
