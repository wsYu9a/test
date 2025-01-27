package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.network.HttpCallBack;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.device.VlionDeviceInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class j4 implements HttpCallBack<VlionCustomParseAdData> {

    /* renamed from: a */
    public final /* synthetic */ VlionBiddingLoadListener f2990a;

    /* renamed from: b */
    public final /* synthetic */ cn.vlion.ad.inland.ad.reward.a f2991b;

    public j4(cn.vlion.ad.inland.ad.reward.a aVar, VlionBiddingLoadListener vlionBiddingLoadListener) {
        this.f2991b = aVar;
        this.f2990a = vlionBiddingLoadListener;
    }

    @Override // cn.vlion.ad.inland.base.network.HttpCallBack
    public final void onFail(VlionAdBaseError vlionAdBaseError) {
        try {
            if (this.f2990a == null || vlionAdBaseError == null) {
                return;
            }
            LogVlion.e("onFail:code:" + vlionAdBaseError.getErrorCode() + "message:" + vlionAdBaseError.getErrorMessage());
            this.f2990a.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.network.HttpCallBack
    public final void onSuccess(VlionCustomParseAdData vlionCustomParseAdData) {
        VlionCustomParseAdData vlionCustomParseAdData2 = vlionCustomParseAdData;
        try {
            this.f2991b.f2360f = vlionCustomParseAdData2.parseBid();
            cn.vlion.ad.inland.ad.reward.a aVar = this.f2991b;
            VlionAdapterADConfig vlionAdapterADConfig = aVar.f2359e;
            if (vlionAdapterADConfig != null) {
                vlionAdapterADConfig.setDspid(aVar.f2360f.getDspid());
                cn.vlion.ad.inland.ad.reward.a aVar2 = this.f2991b;
                aVar2.f2359e.setCrid(aVar2.f2360f.getCrid());
                cn.vlion.ad.inland.ad.reward.a aVar3 = this.f2991b;
                aVar3.f2359e.setAd_type(aVar3.f2360f.isVideo());
                vlionCustomParseAdData2.setSlotID(this.f2991b.f2359e.getSlotID());
            }
            LogVlion.e("onSuccess price=" + vlionCustomParseAdData2.getBidPrice());
            if (VlionDeviceInfo.getInstance().isConnectionWifi()) {
                LogVlion.e("   -- wifi 下载 :");
                cn.vlion.ad.inland.ad.reward.a aVar4 = this.f2991b;
                String videoUrl = vlionCustomParseAdData2.getVideoUrl();
                synchronized (aVar4) {
                    try {
                        if (aVar4.f2363i == null) {
                            aVar4.f2363i = new b5();
                        }
                        aVar4.f2363i.a(videoUrl, new k4(aVar4));
                    } finally {
                    }
                }
            }
            VlionBiddingLoadListener vlionBiddingLoadListener = this.f2990a;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadSuccess(vlionCustomParseAdData2.getBidPrice());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
