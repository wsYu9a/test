package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.network.HttpCallBack;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class t3 implements HttpCallBack<VlionCustomParseAdData> {

    /* renamed from: a */
    public final /* synthetic */ VlionBiddingLoadListener f3374a;

    /* renamed from: b */
    public final /* synthetic */ v3 f3375b;

    public t3(v3 v3Var, VlionBiddingLoadListener vlionBiddingLoadListener) {
        this.f3375b = v3Var;
        this.f3374a = vlionBiddingLoadListener;
    }

    @Override // cn.vlion.ad.inland.base.network.HttpCallBack
    public final void onFail(VlionAdBaseError vlionAdBaseError) {
        VlionBiddingLoadListener vlionBiddingLoadListener = this.f3374a;
        if (vlionBiddingLoadListener == null || vlionAdBaseError == null) {
            return;
        }
        vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
    }

    @Override // cn.vlion.ad.inland.base.network.HttpCallBack
    public final void onSuccess(VlionCustomParseAdData vlionCustomParseAdData) {
        VlionCustomParseAdData vlionCustomParseAdData2 = vlionCustomParseAdData;
        try {
            this.f3375b.f3459g = vlionCustomParseAdData2.parseBid();
            v3 v3Var = this.f3375b;
            VlionAdapterADConfig vlionAdapterADConfig = v3Var.f3458f;
            if (vlionAdapterADConfig != null) {
                vlionAdapterADConfig.setDspid(v3Var.f3459g.getDspid());
                v3 v3Var2 = this.f3375b;
                v3Var2.f3458f.setCrid(v3Var2.f3459g.getCrid());
                v3 v3Var3 = this.f3375b;
                v3Var3.f3458f.setAd_type(v3Var3.f3459g.isVideo());
                vlionCustomParseAdData2.setSlotID(this.f3375b.f3458f.getSlotID());
            }
            LogVlion.e("onSuccess price=" + vlionCustomParseAdData2.getBidPrice());
            VlionBiddingLoadListener vlionBiddingLoadListener = this.f3374a;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadSuccess(vlionCustomParseAdData2.getBidPrice());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
