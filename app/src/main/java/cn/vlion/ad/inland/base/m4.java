package cn.vlion.ad.inland.base;

import android.content.Context;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class m4 {

    /* renamed from: a */
    public final Context f3094a;

    /* renamed from: b */
    public VlionAdapterADConfig f3095b;

    /* renamed from: c */
    public r4 f3096c;

    public m4(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        this.f3094a = context;
        this.f3095b = vlionAdapterADConfig;
    }

    public final void a(VlionBiddingLoadListener vlionBiddingLoadListener) {
        try {
            VlionAdapterADConfig vlionAdapterADConfig = this.f3095b;
            if (vlionAdapterADConfig == null) {
                LogVlion.e("VlionCustomSplashAd loadAd: vlionAdapterADConfig is null");
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
            r4 r4Var = new r4(this.f3094a, this.f3095b);
            this.f3096c = r4Var;
            try {
                LogVlion.e("loadData=");
                f4.a(5, r4Var.f3348d, new p4(r4Var, vlionBiddingLoadListener));
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}
