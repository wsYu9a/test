package cn.vlion.ad.inland.ku;

import android.app.Activity;
import android.content.Context;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class f extends VlionBaseAdapterVideoAdLoad {

    /* renamed from: a */
    public KsScene f3999a;

    /* renamed from: b */
    public KsRewardVideoAd f4000b;

    /* renamed from: c */
    public KsVideoPlayConfig f4001c;

    public class a implements KsLoadManager.RewardVideoAdListener {
        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onError(int i10, String str) {
            try {
                LogVlion.e("VlionKuRewardVideo onError i= " + i10 + " s=" + str);
                VlionBiddingLoadListener vlionBiddingLoadListener = f.this.vlionBidindRewardVideoListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(-1, str);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        f.this.f4000b = list.get(0);
                        f fVar = f.this;
                        fVar.price = fVar.getPrice();
                        if (f.this.f4000b != null) {
                            KsRewardVideoAd ksRewardVideoAd = f.this.f4000b;
                            f fVar2 = f.this;
                            ksRewardVideoAd.setBidEcpm(fVar2.price, fVar2.secondPrice);
                        }
                        LogVlion.e("VlionKuRewardVideo onLoadSuccess price=" + f.this.price);
                        VlionBiddingLoadListener vlionBiddingLoadListener = f.this.vlionBidindRewardVideoListener;
                        if (vlionBiddingLoadListener != null) {
                            vlionBiddingLoadListener.onAdLoadSuccess(r6.price);
                            return;
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            }
            VlionBiddingLoadListener vlionBiddingLoadListener2 = f.this.vlionBidindRewardVideoListener;
            if (vlionBiddingLoadListener2 != null) {
                vlionBiddingLoadListener2.onAdLoadFailure(-1, "no ad");
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onRewardVideoResult(List<KsRewardVideoAd> list) {
        }
    }

    public class b implements KsRewardVideoAd.RewardAdInteractionListener {
        public b() {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onAdClicked() {
            try {
                LogVlion.e("VlionKuRewardVideo onClick");
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = f.this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onExtraRewardVerify(int i10) {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onPageDismiss() {
            try {
                LogVlion.e("VlionKuRewardVideo onAdClose");
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = f.this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onRewardStepVerify(int i10, int i11) {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onRewardVerify() {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onVideoPlayEnd() {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onVideoPlayError(int i10, int i11) {
            try {
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = f.this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdShowFailure(i10, i11 + "");
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onVideoPlayStart() {
            try {
                LogVlion.e("VlionKuRewardVideo onAdExposure");
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = f.this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onVideoSkipToEnd(long j10) {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public final void onRewardVerify(Map<String, Object> map) {
        }
    }

    public f(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        long j10;
        try {
            LogVlion.e("VlionKuRewardVideo:getSlotID=" + this.slotID + " width=" + this.widthPx + " height=" + this.heightPx);
            try {
                j10 = Long.parseLong(this.slotID);
            } catch (Exception e10) {
                LogVlion.e("VlionKuRewardVideo Exception :" + e10.getMessage());
                j10 = 0;
            }
            if (vlionAdapterADConfig != null && "1".equals(vlionAdapterADConfig.getStyle())) {
                this.f4001c = new KsVideoPlayConfig.Builder().showLandscape(true).build();
            }
            this.f3999a = new KsScene.Builder(j10).build();
            LogVlion.e("VlionKuRewardVideo :");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final void destroy() {
        try {
            if (this.f4000b != null) {
                this.f4000b = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final int getPrice() {
        int i10 = -1;
        try {
            KsRewardVideoAd ksRewardVideoAd = this.f4000b;
            if (ksRewardVideoAd == null) {
                return -1;
            }
            i10 = ksRewardVideoAd.getECPM();
            LogVlion.e("VlionKuRewardVideo getPrice " + i10);
            return i10;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return i10;
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final void loadRewardVideoAd() {
        super.loadRewardVideoAd();
        try {
            KsAdSDK.getLoadManager().loadRewardVideoAd(this.f3999a, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        try {
            if (this.f4000b == null || vlionLossBiddingReason == null) {
                return;
            }
            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
            adExposureFailedReason.setWinEcpm(vlionLossBiddingReason.getBiddingPrice());
            adExposureFailedReason.setAdnType(2);
            adExposureFailedReason.setAdnName(cn.vlion.ad.inland.ku.a.a(vlionLossBiddingReason.getBrandName()));
            adExposureFailedReason.setAdTitle(vlionLossBiddingReason.getAdTitle());
            adExposureFailedReason.setAdRequestId(vlionLossBiddingReason.getAdRequestId());
            adExposureFailedReason.setAdUserName(vlionLossBiddingReason.getAdUserName());
            adExposureFailedReason.setIsShow(vlionLossBiddingReason.getIsShow());
            adExposureFailedReason.setIsClick(vlionLossBiddingReason.getIsClick());
            this.f4000b.reportAdExposureFailed(2, adExposureFailedReason);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final void renderRewardVideoAD() {
        super.renderRewardVideoAD();
        try {
            KsRewardVideoAd ksRewardVideoAd = this.f4000b;
            if (ksRewardVideoAd == null || !ksRewardVideoAd.isAdEnable()) {
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdRenderFailure(-1, "");
                }
            } else {
                this.f4000b.setBidEcpm(getPrice(), 0L);
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener2 = this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener2 != null) {
                    vlionBiddingActionRewardListener2.onAdRenderSuccess();
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final void showRewardVideoAd(Activity activity) {
        try {
            KsRewardVideoAd ksRewardVideoAd = this.f4000b;
            if (ksRewardVideoAd == null || !ksRewardVideoAd.isAdEnable()) {
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdShowFailure(-1, "暂无可用激励视频广告，请等待缓存加载或者重新刷新");
                }
            } else {
                this.f4000b.setRewardAdInteractionListener(new b());
                this.f4000b.showRewardVideoAd(activity, this.f4001c);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
