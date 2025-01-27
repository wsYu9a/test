package cn.vlion.ad.inland.base;

import android.app.Activity;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class n1 {

    /* renamed from: a */
    public q1 f3110a;

    /* renamed from: b */
    public VlionAdapterADConfig f3111b;

    /* renamed from: c */
    public Activity f3112c;

    public n1(Activity activity, VlionAdapterADConfig vlionAdapterADConfig) {
        this.f3111b = vlionAdapterADConfig;
        this.f3112c = activity;
    }

    public final void a(VlionBiddingLoadListener vlionBiddingLoadListener) {
        try {
            VlionAdapterADConfig vlionAdapterADConfig = this.f3111b;
            if (vlionAdapterADConfig == null) {
                LogVlion.e("VlionCustomBannerAd loadAd: vlionAdapterADConfig is null");
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
            q1 q1Var = this.f3110a;
            if (q1Var != null) {
                try {
                    f7 f7Var = q1Var.f3309g;
                    if (f7Var != null) {
                        f7Var.a();
                        q1Var.f3309g = null;
                    }
                    v1 v1Var = q1Var.f3313k;
                    if (v1Var != null) {
                        v1Var.destroy();
                        q1Var.f3313k = null;
                    }
                    if (q1Var.f3306d != null) {
                        q1Var.f3306d = null;
                    }
                    if (q1Var.f3311i != null) {
                        q1Var.f3311i = null;
                    }
                    r6 r6Var = q1Var.f3312j;
                    if (r6Var != null) {
                        try {
                            q6 q6Var = r6Var.f3358a;
                            if (q6Var != null) {
                                q6Var.cancel();
                                r6Var.f3358a = null;
                            }
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                        q1Var.f3312j = null;
                    }
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
                this.f3110a = null;
            }
            q1 q1Var2 = new q1(this.f3112c, this.f3111b);
            this.f3110a = q1Var2;
            q1Var2.f3307e = vlionBiddingLoadListener;
            q1Var2.a();
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }
}
