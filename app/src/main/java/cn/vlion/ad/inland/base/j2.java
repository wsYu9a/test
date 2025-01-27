package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.network.HttpCallBack;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class j2 implements HttpCallBack<VlionCustomParseAdData> {

    /* renamed from: a */
    public final /* synthetic */ VlionBiddingLoadListener f2984a;

    /* renamed from: b */
    public final /* synthetic */ k2 f2985b;

    public j2(k2 k2Var, VlionBiddingLoadListener vlionBiddingLoadListener) {
        this.f2985b = k2Var;
        this.f2984a = vlionBiddingLoadListener;
    }

    @Override // cn.vlion.ad.inland.base.network.HttpCallBack
    public final void onFail(VlionAdBaseError vlionAdBaseError) {
        try {
            VlionBiddingLoadListener vlionBiddingLoadListener = this.f2984a;
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
            this.f2985b.f3013g = vlionCustomParseAdData2.parseBid();
            k2 k2Var = this.f2985b;
            VlionAdapterADConfig vlionAdapterADConfig = k2Var.f3010d;
            if (vlionAdapterADConfig != null) {
                vlionAdapterADConfig.setDspid(k2Var.f3013g.getDspid());
                k2 k2Var2 = this.f2985b;
                k2Var2.f3010d.setCrid(k2Var2.f3013g.getCrid());
                k2 k2Var3 = this.f2985b;
                k2Var3.f3010d.setAd_type(k2Var3.f3013g.isVideo());
                vlionCustomParseAdData2.setSlotID(this.f2985b.f3010d.getSlotID());
            }
            LogVlion.e("onSuccess price=" + vlionCustomParseAdData2.getBidPrice());
            VlionBiddingLoadListener vlionBiddingLoadListener = this.f2984a;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadSuccess(vlionCustomParseAdData2.getBidPrice());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
