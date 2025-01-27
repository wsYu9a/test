package cn.vlion.ad.inland.kd;

import android.app.Activity;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionPrivateInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.kd.VlionKdRewardVideoActivity;
import com.shu.priory.IFLYVideoAd;
import com.shu.priory.bean.DownloadDialogInfo;
import com.shu.priory.config.AdError;
import com.shu.priory.config.AdKeys;
import com.shu.priory.conn.VideoDataRef;
import com.shu.priory.download.DownLoadDialogCallback;
import com.shu.priory.listener.IFLYVideoListener;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class l extends VlionBaseAdAdapterInterstitial {

    /* renamed from: a */
    public IFLYVideoAd f3919a;

    /* renamed from: b */
    public VideoDataRef f3920b;

    /* renamed from: c */
    public boolean f3921c;

    public class a implements IFLYVideoListener {
        public a() {
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onAdClick() {
            try {
                LogVlion.e("VlionKdInterstitialVideo:onAdClick=");
                if (VlionServiceConfigParse.getInstance().isHotspot()) {
                    if (l.this.f3920b != null && l.this.f3919a != null) {
                        LogVlion.e("VlionKdInterstitialVideo:onAdClick=" + l.this.f3920b.onClick(l.this.f3919a.getVideoView(), 2));
                    }
                    VlionBiddingActionListener vlionBiddingActionListener = l.this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdClick();
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.listener.IFLYBaseAdListener
        public final void onAdFailed(AdError adError) {
            int errorCode;
            String errorDescription;
            if (adError != null) {
                try {
                    errorCode = adError.getErrorCode();
                    errorDescription = adError.getErrorDescription();
                    LogVlion.e("VlionKdInterstitialVideo onAdFailed:code=" + errorCode + " error=" + errorDescription);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            } else {
                errorDescription = "";
                errorCode = -1;
            }
            LogVlion.e("VlionKdInterstitialVideo:onAdFailed=" + errorCode + " message=" + errorDescription);
            VlionBiddingLoadListener vlionBiddingLoadListener = l.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadFailure(errorCode, errorDescription);
            }
        }

        @Override // com.shu.priory.listener.IFLYBaseAdListener
        public final void onAdLoaded(VideoDataRef videoDataRef) {
            VideoDataRef videoDataRef2 = videoDataRef;
            try {
                LogVlion.e("VlionKdInterstitialVideo:onAdLoaded=======");
                l.this.f3920b = videoDataRef2;
                l lVar = l.this;
                lVar.price = lVar.getPrice();
                LogVlion.e("VlionKdInterstitialVideo:onAdLoaded=" + l.this.price + " videoDataRef.getPrice()=" + videoDataRef2.getPrice());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionKdInterstitialVideo:onAdLoaded=");
                sb2.append(VlionKDAdapter.a(videoDataRef2));
                LogVlion.e(sb2.toString());
                VlionBiddingLoadListener vlionBiddingLoadListener = l.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadSuccess(r5.price);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onAdPlayError() {
            try {
                LogVlion.e("VlionKdInterstitialVideo:onAdPlayError=");
                WeakReference<VlionKdRewardVideoActivity> weakReference = VlionKdRewardVideoActivity.f3853t;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                VlionKdRewardVideoActivity.f3853t.get().finish();
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onCancel() {
            LogVlion.e("VlionKdInterstitialVideo:onCancel=");
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onConfirm() {
            LogVlion.e("VlionKdInterstitialVideo:onConfirm=");
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onDownloading() {
            LogVlion.e("VlionKdInterstitialVideo:onDownloading=");
        }

        @Override // com.shu.priory.download.DialogListener
        public final boolean onShowDownloadDialog(DownloadDialogInfo downloadDialogInfo, DownLoadDialogCallback downLoadDialogCallback) {
            try {
                LogVlion.e("VlionKdInterstitialVideo:onShowDownloadDialog=");
                WeakReference<VlionKdRewardVideoActivity> weakReference = VlionKdRewardVideoActivity.f3853t;
                if (weakReference == null || weakReference.get() == null) {
                    return true;
                }
                new j(VlionKdRewardVideoActivity.f3853t.get(), downloadDialogInfo, downLoadDialogCallback).show();
                return true;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return true;
            }
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onVideoCached() {
            try {
                if (l.this.f3920b != null) {
                    LogVlion.e("VlionKdInterstitialVideo onVideoCached" + VlionKDAdapter.a(l.this.f3920b));
                    VlionBiddingActionListener vlionBiddingActionListener = l.this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdRenderSuccess(null);
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onVideoComplete() {
            LogVlion.e("VlionKdInterstitialVideo:onVideoComplete=");
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onVideoReplay() {
            LogVlion.e("VlionKdInterstitialVideo:onVideoReplay=");
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onVideoStart() {
            try {
                LogVlion.e("VlionKdInterstitialVideo:onVideoStart=");
                if (l.this.f3919a != null) {
                    l.this.f3919a.setVolume(l.this.isClosedVolume);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements VlionKdRewardVideoActivity.f {
        public b() {
        }

        @Override // cn.vlion.ad.inland.kd.VlionKdRewardVideoActivity.f
        public final void onAdClose() {
            try {
                LogVlion.e("VlionKdInterstitialVideo onAdClose ");
                VlionBiddingActionListener vlionBiddingActionListener = l.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.kd.VlionKdRewardVideoActivity.f
        public final void onClick() {
            LogVlion.e("VlionKdInterstitialVideo onClick ");
            VlionBiddingActionListener vlionBiddingActionListener = l.this.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdClick();
            }
        }

        @Override // cn.vlion.ad.inland.kd.VlionKdRewardVideoActivity.f
        public final void onExposure() {
            try {
                LogVlion.e("VlionKdInterstitialVideo onExposure ");
                VlionBiddingActionListener vlionBiddingActionListener = l.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public l(Activity activity, VlionAdapterADConfig vlionAdapterADConfig, boolean z10, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(activity, vlionAdapterADConfig, vlionBiddingLoadListener);
        try {
            this.f3921c = z10;
            LogVlion.e("VlionKdInterstitialVideo:" + this.slotID);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final void destroy() {
        try {
            IFLYVideoAd iFLYVideoAd = this.f3919a;
            if (iFLYVideoAd != null) {
                iFLYVideoAd.release();
                this.f3919a = null;
            }
            if (this.f3920b != null) {
                this.f3920b = null;
            }
            WeakReference<VlionKdRewardVideoActivity> weakReference = VlionKdRewardVideoActivity.f3853t;
            if (weakReference != null) {
                weakReference.clear();
                VlionKdRewardVideoActivity.f3853t = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final int getPrice() {
        try {
            if (this.f3920b == null) {
                return 0;
            }
            LogVlion.e("VlionKdInterstitialVideo videoDataRef.getPrice() " + this.f3920b.getPrice());
            return (int) (this.f3920b.getPrice() * 100.0d);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return 0;
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void loadAd() {
        IFLYVideoAd iFLYVideoAd;
        String str;
        super.loadAd();
        try {
            LogVlion.e("VlionKdInterstitialVideo:slotID=" + this.slotID);
            IFLYVideoAd iFLYVideoAd2 = new IFLYVideoAd(this.context, this.slotID, 0, new a());
            this.f3919a = iFLYVideoAd2;
            iFLYVideoAd2.setDirectJump(true);
            IFLYVideoAd iFLYVideoAd3 = this.f3919a;
            Boolean bool = Boolean.TRUE;
            iFLYVideoAd3.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
            this.f3919a.setParameter(AdKeys.OAID, VlionPrivateInfo.getOaid());
            this.f3919a.setParameter(AdKeys.DEBUG_MODE, Boolean.valueOf(VlionSDkManager.getInstance().isEnableLog()));
            VlionAdapterADConfig vlionAdapterADConfig = this.vlionAdapterADConfig;
            if (vlionAdapterADConfig != null) {
                if (vlionAdapterADConfig.getSecondPop() == 0) {
                    this.f3919a.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
                }
                this.f3919a.setParameter(AdKeys.HTTP_REQUEST_TIMEOUT, Float.valueOf(this.vlionAdapterADConfig.getTolerateTime() * 1000.0f));
            }
            LogVlion.e("VlionKdInterstitialVideo isBid=" + this.isBid + " bidFloorPrice=" + this.bidFloorPrice);
            if (this.isBid) {
                this.f3919a.setParameter(AdKeys.BID_FLOOR, String.valueOf(this.bidFloorPrice));
                iFLYVideoAd = this.f3919a;
                str = "1";
            } else {
                iFLYVideoAd = this.f3919a;
                str = "0";
            }
            iFLYVideoAd.setParameter(AdKeys.SETTLE_TYPE, str);
            this.f3919a.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        try {
            VideoDataRef videoDataRef = this.f3920b;
            if (videoDataRef != null) {
                videoDataRef.onBiddingFailure(101, "价格低");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void renderAD() {
        VideoDataRef videoDataRef;
        try {
            super.renderAD();
            LogVlion.e("VlionKdInterstitialVideo renderAD:");
            if (this.f3919a == null || (videoDataRef = this.f3920b) == null) {
                VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_RENDER_ERROR;
                    vlionBiddingActionListener.onAdRenderFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            } else {
                videoDataRef.onBiddingSuccess();
                this.f3919a.cacheVideo();
            }
        } catch (Throwable unused) {
            VlionBiddingActionListener vlionBiddingActionListener2 = this.vlionBiddingActionListener;
            if (vlionBiddingActionListener2 != null) {
                VlionAdBaseError vlionAdBaseError2 = VlionAdBaseError.Exception_CODE_ERROR;
                vlionBiddingActionListener2.onAdRenderFailure(vlionAdBaseError2.getErrorCode(), vlionAdBaseError2.getErrorMessage());
            }
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final void showAd(Activity activity) {
        try {
            LogVlion.e("VlionKdInterstitialVideo showRewardVideoAd");
            if (this.f3919a == null || this.f3920b == null) {
                VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_SHOW_ERROR;
                    vlionBiddingActionListener.onAdShowFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            } else {
                LogVlion.e("VlionKdInterstitialVideo showRewardVideoAd view");
                VlionKdRewardVideoActivity.a(activity, this.f3919a, this.f3920b, this.f3921c, this.vlionAdapterADConfig, new b());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
