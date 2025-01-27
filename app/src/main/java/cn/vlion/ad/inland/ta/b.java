package cn.vlion.ad.inland.ta;

import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd;

/* loaded from: classes.dex */
public final class b implements ITanxFeedExpressAd.OnFeedAdListener {

    /* renamed from: a */
    public final /* synthetic */ a f4027a;

    public b(a aVar) {
        this.f4027a = aVar;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener
    public final void onAdClose(ITanxAd iTanxAd) {
        try {
            LogVlion.e("VlionTaFeed onAdClose:");
            VlionBiddingActionListener vlionBiddingActionListener = this.f4027a.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdClose();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener
    public final void onAdShow(ITanxAd iTanxAd) {
        try {
            LogVlion.e("VlionTaFeed onAdShow:");
            VlionBiddingActionListener vlionBiddingActionListener = this.f4027a.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdExposure();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener
    public final void onClick(ITanxAd iTanxAd) {
        try {
            LogVlion.e("VlionTaFeed onClick:");
            VlionBiddingActionListener vlionBiddingActionListener = this.f4027a.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdClick();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd.OnFeedAdListener
    public final void onError(String str) {
        try {
            LogVlion.e("VlionTaFeed onError:" + str);
            VlionBiddingActionListener vlionBiddingActionListener = this.f4027a.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdShowFailure(-1, str);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
