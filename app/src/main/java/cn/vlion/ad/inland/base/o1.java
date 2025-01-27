package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.network.HttpCallBack;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class o1 implements HttpCallBack<VlionCustomParseAdData> {

    /* renamed from: a */
    public final /* synthetic */ q1 f3241a;

    public o1(q1 q1Var) {
        this.f3241a = q1Var;
    }

    @Override // cn.vlion.ad.inland.base.network.HttpCallBack
    public final void onFail(VlionAdBaseError vlionAdBaseError) {
        VlionBiddingLoadListener vlionBiddingLoadListener = this.f3241a.f3307e;
        if (vlionBiddingLoadListener == null || vlionAdBaseError == null) {
            return;
        }
        vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
    }

    @Override // cn.vlion.ad.inland.base.network.HttpCallBack
    public final void onSuccess(VlionCustomParseAdData vlionCustomParseAdData) {
        VlionCustomParseAdData vlionCustomParseAdData2 = vlionCustomParseAdData;
        try {
            this.f3241a.f3311i = vlionCustomParseAdData2.parseBid();
            q1 q1Var = this.f3241a;
            VlionAdapterADConfig vlionAdapterADConfig = q1Var.f3306d;
            if (vlionAdapterADConfig != null) {
                vlionAdapterADConfig.setDspid(q1Var.f3311i.getDspid());
                q1 q1Var2 = this.f3241a;
                q1Var2.f3306d.setCrid(q1Var2.f3311i.getCrid());
                q1 q1Var3 = this.f3241a;
                q1Var3.f3306d.setAd_type(q1Var3.f3311i.isVideo());
                vlionCustomParseAdData2.setSlotID(this.f3241a.f3306d.getSlotID());
            }
            LogVlion.e("onSuccess price=" + vlionCustomParseAdData2.getBidPrice());
            VlionBiddingLoadListener vlionBiddingLoadListener = this.f3241a.f3307e;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadSuccess(vlionCustomParseAdData2.getBidPrice());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
