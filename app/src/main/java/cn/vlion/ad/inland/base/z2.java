package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.network.HttpCallBack;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class z2 implements HttpCallBack<VlionCustomParseAdData> {

    /* renamed from: a */
    public final /* synthetic */ VlionBiddingLoadListener f3540a;

    /* renamed from: b */
    public final /* synthetic */ a3 f3541b;

    public z2(a3 a3Var, VlionBiddingLoadListener vlionBiddingLoadListener) {
        this.f3541b = a3Var;
        this.f3540a = vlionBiddingLoadListener;
    }

    @Override // cn.vlion.ad.inland.base.network.HttpCallBack
    public final void onFail(VlionAdBaseError vlionAdBaseError) {
        try {
            VlionBiddingLoadListener vlionBiddingLoadListener = this.f3540a;
            if (vlionBiddingLoadListener == null || vlionAdBaseError == null) {
                return;
            }
            vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.network.HttpCallBack
    public final void onSuccess(VlionCustomParseAdData vlionCustomParseAdData) {
        VlionCustomParseAdData vlionCustomParseAdData2 = vlionCustomParseAdData;
        try {
            this.f3541b.f2598h = vlionCustomParseAdData2.parseBid();
            a3 a3Var = this.f3541b;
            VlionAdapterADConfig vlionAdapterADConfig = a3Var.f2595e;
            if (vlionAdapterADConfig != null) {
                vlionAdapterADConfig.setDspid(a3Var.f2598h.getDspid());
                a3 a3Var2 = this.f3541b;
                a3Var2.f2595e.setCrid(a3Var2.f2598h.getCrid());
                a3 a3Var3 = this.f3541b;
                a3Var3.f2595e.setAd_type(a3Var3.f2598h.isVideo());
                vlionCustomParseAdData2.setSlotID(this.f3541b.f2595e.getSlotID());
            }
            LogVlion.e("onSuccess price=" + vlionCustomParseAdData2.getBidPrice());
            VlionBiddingLoadListener vlionBiddingLoadListener = this.f3540a;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadSuccess(vlionCustomParseAdData2.getBidPrice());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
