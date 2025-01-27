package cn.vlion.ad.inland.ku;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.SplashAdExtraData;

/* loaded from: classes.dex */
public final class i extends VlionBaseAdAdapterSplash {

    /* renamed from: a */
    public KsScene f4009a;

    /* renamed from: b */
    public KsSplashScreenAd f4010b;

    /* renamed from: c */
    public View f4011c;

    public class a implements KsLoadManager.SplashScreenAdListener {
        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onError(int i10, String str) {
            try {
                LogVlion.e("VlionKuSplash onError price=" + i.this.price);
                VlionBiddingLoadListener vlionBiddingLoadListener = i.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(-1, str);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onRequestResult(int i10) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
            try {
                i.this.f4010b = ksSplashScreenAd;
                i iVar = i.this;
                iVar.price = iVar.getPrice();
                if (ksSplashScreenAd != null) {
                    i iVar2 = i.this;
                    ksSplashScreenAd.setBidEcpm(iVar2.price, iVar2.secondPrice);
                }
                LogVlion.e("VlionKuSplash onLoadSuccess price=" + i.this.price);
                VlionBiddingLoadListener vlionBiddingLoadListener = i.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadSuccess(r6.price);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements KsSplashScreenAd.SplashScreenAdInteractionListener {
        public b() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public final void onAdClicked() {
            try {
                LogVlion.e("VlionKuSplash onClick");
                VlionBiddingActionListener vlionBiddingActionListener = i.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public final void onAdShowEnd() {
            try {
                LogVlion.e("VlionKuSplash onClose");
                VlionBiddingActionListener vlionBiddingActionListener = i.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public final void onAdShowError(int i10, String str) {
            try {
                VlionBiddingActionListener vlionBiddingActionListener = i.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdShowFailure(i10, str);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public final void onAdShowStart() {
            try {
                LogVlion.e("VlionKuSplash onExposure");
                VlionBiddingActionListener vlionBiddingActionListener = i.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public final void onDownloadTipsDialogCancel() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public final void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public final void onDownloadTipsDialogShow() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public final void onSkippedAd() {
            try {
                LogVlion.e("VlionKuSplash onSkippedAd");
                VlionBiddingActionListener vlionBiddingActionListener = i.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdSkip();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public i(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        long j10;
        try {
            LogVlion.e("VlionKuSplash:getSlotID=" + this.slotID + " width=" + this.widthPx + " height=" + this.heightPx);
            try {
                j10 = Long.parseLong(this.slotID);
            } catch (Exception e10) {
                LogVlion.e("VlionKuSplash Exception :" + e10.getMessage());
                j10 = 0;
            }
            SplashAdExtraData splashAdExtraData = new SplashAdExtraData();
            splashAdExtraData.setDisableShakeStatus(true);
            this.f4009a = new KsScene.Builder(j10).setSplashExtraData(splashAdExtraData).build();
            LogVlion.e("VlionKuSplash:");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final void destroy() {
        try {
            if (this.f4010b != null) {
                this.f4010b = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final int getPrice() {
        int i10 = -1;
        try {
            KsSplashScreenAd ksSplashScreenAd = this.f4010b;
            if (ksSplashScreenAd == null) {
                return -1;
            }
            i10 = ksSplashScreenAd.getECPM();
            LogVlion.e("VlionKuSplash getPrice " + i10);
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
            LogVlion.e("VlionKuSplash loadAd:");
            KsAdSDK.getLoadManager().loadSplashScreenAd(this.f4009a, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        try {
            if (this.f4010b == null || vlionLossBiddingReason == null) {
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
            this.f4010b.reportAdExposureFailed(2, adExposureFailedReason);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void renderAD() {
        super.renderAD();
        try {
            LogVlion.e("VlionKuSplash renderAD=" + isHaveLoadStatus());
            KsSplashScreenAd ksSplashScreenAd = this.f4010b;
            if (ksSplashScreenAd != null) {
                View view = ksSplashScreenAd.getView(this.context, new b());
                this.f4011c = view;
                VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    if (view != null) {
                        vlionBiddingActionListener.onAdRenderSuccess(view);
                    } else {
                        vlionBiddingActionListener.onAdRenderFailure(-1, "");
                    }
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final void showAd(ViewGroup viewGroup) {
        KsSplashScreenAd ksSplashScreenAd;
        try {
            LogVlion.e("VlionKuSplash showAd");
            if (this.f4011c == null || viewGroup == null || (ksSplashScreenAd = this.f4010b) == null || !ksSplashScreenAd.isAdEnable()) {
                return;
            }
            LogVlion.e("VlionKuSplash showAd adView");
            viewGroup.addView(this.f4011c);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
