package cn.vlion.ad.inland.ku;

import android.app.Activity;
import android.content.Context;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.List;

/* loaded from: classes.dex */
public final class d extends VlionBaseAdAdapterInterstitial {

    /* renamed from: a */
    public KsScene f3985a;

    /* renamed from: b */
    public KsInterstitialAd f3986b;

    public class a implements KsLoadManager.InterstitialAdListener {
        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onError(int i10, String str) {
            try {
                LogVlion.e("VlionKuInterstitial onError i= " + i10 + " s=" + str);
                VlionBiddingLoadListener vlionBiddingLoadListener = d.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(-1, str);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onInterstitialAdLoad(List<KsInterstitialAd> list) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        d.this.f3986b = list.get(0);
                        d dVar = d.this;
                        dVar.price = dVar.getPrice();
                        LogVlion.e("VlionKuInterstitial onLoadSuccess price=" + d.this.price);
                        if (d.this.f3986b != null) {
                            KsInterstitialAd ksInterstitialAd = d.this.f3986b;
                            d dVar2 = d.this;
                            ksInterstitialAd.setBidEcpm(dVar2.price, dVar2.secondPrice);
                        }
                        VlionBiddingLoadListener vlionBiddingLoadListener = d.this.vlionBiddingLoadListener;
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
            VlionBiddingLoadListener vlionBiddingLoadListener2 = d.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener2 != null) {
                vlionBiddingLoadListener2.onAdLoadFailure(-1, "没有广告填充");
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onRequestResult(int i10) {
        }
    }

    public class b implements KsInterstitialAd.AdInteractionListener {
        public b() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public final void onAdClicked() {
            try {
                LogVlion.e("VlionKuInterstitial onClick");
                VlionBiddingActionListener vlionBiddingActionListener = d.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public final void onAdClosed() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public final void onAdShow() {
            try {
                LogVlion.e("VlionKuInterstitial onExposure");
                VlionBiddingActionListener vlionBiddingActionListener = d.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public final void onPageDismiss() {
            try {
                LogVlion.e("VlionKuInterstitial onClose");
                VlionBiddingActionListener vlionBiddingActionListener = d.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public final void onSkippedAd() {
            try {
                VlionBiddingActionListener vlionBiddingActionListener = d.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdSkip();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public final void onVideoPlayEnd() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public final void onVideoPlayError(int i10, int i11) {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public final void onVideoPlayStart() {
        }
    }

    public d(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        long j10;
        this.f3986b = null;
        try {
            LogVlion.e("VlionKuInterstitial:getSlotID=" + this.slotID + " width=" + this.widthPx + " height=" + this.heightPx);
            try {
                j10 = Long.parseLong(this.slotID);
            } catch (Exception e10) {
                LogVlion.e("VlionKuInterstitial Exception :" + e10.getMessage());
                j10 = 0;
            }
            this.f3985a = new KsScene.Builder(j10).adNum(1).build();
            LogVlion.e("VlionKuInterstitial:");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final void destroy() {
        try {
            if (this.f3986b != null) {
                this.f3986b = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final int getPrice() {
        int i10 = -1;
        try {
            KsInterstitialAd ksInterstitialAd = this.f3986b;
            if (ksInterstitialAd == null) {
                return -1;
            }
            i10 = ksInterstitialAd.getECPM();
            LogVlion.e("VlionKuInterstitial getPrice " + i10);
            return i10;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return i10;
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void loadAd() {
        super.loadAd();
        try {
            LogVlion.e("VlionKuInterstitial loadAd:");
            KsAdSDK.getLoadManager().loadInterstitialAd(this.f3985a, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        try {
            if (this.f3986b == null || vlionLossBiddingReason == null) {
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
            this.f3986b.reportAdExposureFailed(2, adExposureFailedReason);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void renderAD() {
        super.renderAD();
        try {
            LogVlion.e("VlionKuInterstitial renderAD isAdLoadSuccess=");
            KsInterstitialAd ksInterstitialAd = this.f3986b;
            if (ksInterstitialAd != null) {
                ksInterstitialAd.setBidEcpm(getPrice(), 0L);
                VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdRenderSuccess(null);
                }
            } else {
                VlionBiddingActionListener vlionBiddingActionListener2 = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener2 != null) {
                    vlionBiddingActionListener2.onAdRenderFailure(-1, "");
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final void showAd(Activity activity) {
        try {
            LogVlion.e("VlionKuInterstitial showAd");
            if (this.f3986b != null) {
                KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().build();
                this.f3986b.setAdInteractionListener(new b());
                this.f3986b.showInterstitialAd(activity, build);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
