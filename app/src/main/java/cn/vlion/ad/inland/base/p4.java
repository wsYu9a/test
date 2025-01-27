package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.network.HttpCallBack;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class p4 implements HttpCallBack<VlionCustomParseAdData> {

    /* renamed from: a */
    public final /* synthetic */ VlionBiddingLoadListener f3279a;

    /* renamed from: b */
    public final /* synthetic */ r4 f3280b;

    public p4(r4 r4Var, VlionBiddingLoadListener vlionBiddingLoadListener) {
        this.f3280b = r4Var;
        this.f3279a = vlionBiddingLoadListener;
    }

    @Override // cn.vlion.ad.inland.base.network.HttpCallBack
    public final void onFail(VlionAdBaseError vlionAdBaseError) {
        try {
            VlionBiddingLoadListener vlionBiddingLoadListener = this.f3279a;
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
        VlionCustomParseAdData vlionCustomParseAdData2;
        VlionCustomParseAdData vlionCustomParseAdData3 = vlionCustomParseAdData;
        try {
            this.f3280b.f3351g = vlionCustomParseAdData3.parseBid();
            r4 r4Var = this.f3280b;
            VlionAdapterADConfig vlionAdapterADConfig = r4Var.f3348d;
            if (vlionAdapterADConfig != null && (vlionCustomParseAdData2 = r4Var.f3351g) != null) {
                vlionAdapterADConfig.setDspid(vlionCustomParseAdData2.getDspid());
                r4 r4Var2 = this.f3280b;
                r4Var2.f3348d.setCrid(r4Var2.f3351g.getCrid());
                r4 r4Var3 = this.f3280b;
                r4Var3.f3348d.setAd_type(r4Var3.f3351g.isVideo());
                vlionCustomParseAdData3.setSlotID(this.f3280b.f3348d.getSlotID());
            }
            LogVlion.e("onSuccess price=" + vlionCustomParseAdData3.getBidPrice());
            VlionBiddingLoadListener vlionBiddingLoadListener = this.f3279a;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadSuccess(vlionCustomParseAdData3.getBidPrice());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
