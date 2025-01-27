package cn.vlion.ad.inland.ta;

import cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.request.TanxPlayerError;
import java.util.Map;

/* loaded from: classes.dex */
public final class j implements ITanxRewardExpressAd.OnRewardAdListener {

    /* renamed from: a */
    public final /* synthetic */ k f4053a;

    public j(k kVar) {
        this.f4053a = kVar;
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
    public final void onAdClicked(TanxAdView tanxAdView, ITanxRewardVideoAd iTanxRewardVideoAd) {
        try {
            LogVlion.e("VlionTaRewardVideo onAdClicked");
            VlionBiddingActionRewardListener vlionBiddingActionRewardListener = this.f4053a.vlionBiddingActionRewardListener;
            if (vlionBiddingActionRewardListener != null) {
                vlionBiddingActionRewardListener.onAdClick();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoInteractionListener
    public final void onAdClose() {
        try {
            LogVlion.e("VlionTaRewardVideo onAdClose");
            VlionBiddingActionRewardListener vlionBiddingActionRewardListener = this.f4053a.vlionBiddingActionRewardListener;
            if (vlionBiddingActionRewardListener != null) {
                vlionBiddingActionRewardListener.onAdClose();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
    public final void onAdShow(ITanxRewardVideoAd iTanxRewardVideoAd) {
        try {
            LogVlion.e("VlionTaRewardVideo onAdShow");
            VlionBiddingActionRewardListener vlionBiddingActionRewardListener = this.f4053a.vlionBiddingActionRewardListener;
            if (vlionBiddingActionRewardListener != null) {
                vlionBiddingActionRewardListener.onAdVideoStart();
            }
            VlionBiddingActionRewardListener vlionBiddingActionRewardListener2 = this.f4053a.vlionBiddingActionRewardListener;
            if (vlionBiddingActionRewardListener2 != null) {
                vlionBiddingActionRewardListener2.onAdExposure();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoInteractionListener
    public final void onError(TanxError tanxError) {
        String str;
        int i10;
        try {
            LogVlion.e("VlionTaRewardVideo tanxError");
            if (tanxError != null) {
                i10 = tanxError.getCode();
                str = tanxError.getMessage();
                LogVlion.e("VlionTaRewardVideo onVideoError:code=" + i10 + " error=" + str);
            } else {
                str = "";
                i10 = -1;
            }
            VlionBiddingActionRewardListener vlionBiddingActionRewardListener = this.f4053a.vlionBiddingActionRewardListener;
            if (vlionBiddingActionRewardListener != null) {
                vlionBiddingActionRewardListener.onAdShowFailure(i10, str);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoInteractionListener
    public final void onRewardArrived(boolean z10, int i10, Map<String, Object> map) {
        try {
            LogVlion.e("VlionTaRewardVideo onRewardArrived");
            VlionBiddingActionRewardListener vlionBiddingActionRewardListener = this.f4053a.vlionBiddingActionRewardListener;
            if (vlionBiddingActionRewardListener != null) {
                vlionBiddingActionRewardListener.onAdReward();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoInteractionListener
    public final void onSkippedVideo() {
        try {
            LogVlion.e("VlionTaRewardVideo onSkippedVideo");
            VlionBiddingActionRewardListener vlionBiddingActionRewardListener = this.f4053a.vlionBiddingActionRewardListener;
            if (vlionBiddingActionRewardListener != null) {
                vlionBiddingActionRewardListener.onAdVideoSkip();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoInteractionListener
    public final void onVideoComplete() {
        try {
            LogVlion.e("VlionTaRewardVideo onVideoComplete");
            VlionBiddingActionRewardListener vlionBiddingActionRewardListener = this.f4053a.vlionBiddingActionRewardListener;
            if (vlionBiddingActionRewardListener != null) {
                vlionBiddingActionRewardListener.onAdVideoPlayComplete();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoInteractionListener
    public final void onVideoError(TanxPlayerError tanxPlayerError) {
        String str;
        int i10;
        try {
            LogVlion.e("VlionTaRewardVideo onVideoError");
            if (tanxPlayerError != null) {
                i10 = tanxPlayerError.getCode();
                str = tanxPlayerError.getMessage();
                LogVlion.e("VlionTaRewardVideo onVideoError:code=" + i10 + " error=" + str);
            } else {
                str = "";
                i10 = -1;
            }
            VlionBiddingActionRewardListener vlionBiddingActionRewardListener = this.f4053a.vlionBiddingActionRewardListener;
            if (vlionBiddingActionRewardListener != null) {
                vlionBiddingActionRewardListener.onAdPlayFailure(i10, str);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
