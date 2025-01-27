package cn.vlion.ad.inland.kd;

import android.app.Activity;
import android.content.Context;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener;
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
public final class p extends VlionBaseAdapterVideoAdLoad {

    /* renamed from: a */
    public IFLYVideoAd f3957a;

    /* renamed from: b */
    public VideoDataRef f3958b;

    /* renamed from: c */
    public boolean f3959c;

    public class a implements IFLYVideoListener {
        public a() {
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onAdClick() {
            try {
                LogVlion.e("VlionKdRewardVideo onClick=");
                if (VlionServiceConfigParse.getInstance().isHotspot()) {
                    if (p.this.f3958b != null && p.this.f3957a != null) {
                        LogVlion.e("VlionKdRewardVideo onClick=" + p.this.f3958b.onClick(p.this.f3957a.getVideoView(), 2));
                    }
                    VlionBiddingActionRewardListener vlionBiddingActionRewardListener = p.this.vlionBiddingActionRewardListener;
                    if (vlionBiddingActionRewardListener != null) {
                        vlionBiddingActionRewardListener.onAdClick();
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
                    LogVlion.e("VlionKdRewardVideo onAdFailed:code=" + errorCode + " error=" + errorDescription);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            } else {
                errorDescription = "";
                errorCode = -1;
            }
            LogVlion.e("VlionKdRewardVideo onAdFailed:code=" + errorCode + " error=" + errorDescription);
            VlionBiddingLoadListener vlionBiddingLoadListener = p.this.vlionBidindRewardVideoListener;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadFailure(errorCode, errorDescription);
            }
        }

        @Override // com.shu.priory.listener.IFLYBaseAdListener
        public final void onAdLoaded(VideoDataRef videoDataRef) {
            VideoDataRef videoDataRef2 = videoDataRef;
            try {
                p.this.f3958b = videoDataRef2;
                int price = p.this.getPrice();
                LogVlion.e("VlionKdRewardVideo onLoadSuccess price=" + price + " " + VlionKDAdapter.a(videoDataRef2));
                VlionBiddingLoadListener vlionBiddingLoadListener = p.this.vlionBidindRewardVideoListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadSuccess(price);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onAdPlayError() {
            try {
                LogVlion.e("VlionKdRewardVideo onAdPlayError:");
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = p.this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdPlayFailure(-1, "onAdPlayFailure");
                }
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
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onConfirm() {
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onDownloading() {
        }

        @Override // com.shu.priory.download.DialogListener
        public final boolean onShowDownloadDialog(DownloadDialogInfo downloadDialogInfo, DownLoadDialogCallback downLoadDialogCallback) {
            try {
                LogVlion.e("VlionKdRewardVideo onShowDownloadDialog");
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
                LogVlion.e("VlionKdRewardVideo onVideoCached");
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = p.this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdRenderSuccess();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onVideoComplete() {
            try {
                LogVlion.e("VlionKdRewardVideo playCompletion:");
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = p.this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdVideoPlayComplete();
                }
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener2 = p.this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener2 != null) {
                    vlionBiddingActionRewardListener2.onAdReward();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onVideoReplay() {
            LogVlion.e("VlionKdRewardVideo onVideoReplay:");
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onVideoStart() {
            try {
                LogVlion.e("VlionKdRewardVideo onVideoStart");
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = p.this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdVideoStart();
                }
                if (p.this.f3957a != null) {
                    p.this.f3957a.setVolume(p.this.isClosedVolume);
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
                LogVlion.e("VlionKdRewardVideo onAdClose ");
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = p.this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.kd.VlionKdRewardVideoActivity.f
        public final void onClick() {
            LogVlion.e("VlionKdRewardVideo onClick ");
            VlionBiddingActionRewardListener vlionBiddingActionRewardListener = p.this.vlionBiddingActionRewardListener;
            if (vlionBiddingActionRewardListener != null) {
                vlionBiddingActionRewardListener.onAdClick();
            }
        }

        @Override // cn.vlion.ad.inland.kd.VlionKdRewardVideoActivity.f
        public final void onExposure() {
            try {
                LogVlion.e("VlionKdRewardVideo onExposure ");
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = p.this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public p(Context context, VlionAdapterADConfig vlionAdapterADConfig, boolean z10, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        try {
            this.f3959c = z10;
            LogVlion.e("VlionKdRewardVideo " + this.slotID);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final void destroy() {
        try {
            WeakReference<VlionKdRewardVideoActivity> weakReference = VlionKdRewardVideoActivity.f3853t;
            if (weakReference != null) {
                weakReference.clear();
                VlionKdRewardVideoActivity.f3853t = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final int getPrice() {
        int i10 = -1;
        try {
            if (this.f3958b == null) {
                return -1;
            }
            LogVlion.e("VlionKdRewardVideo videoDataRef.getPrice() " + this.f3958b.getPrice());
            i10 = (int) (this.f3958b.getPrice() * 100.0d);
            LogVlion.e("VlionKdRewardVideo getPrice " + i10);
            return i10;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return i10;
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final void loadRewardVideoAd() {
        IFLYVideoAd iFLYVideoAd;
        String str;
        try {
            super.loadRewardVideoAd();
            LogVlion.e("VlionKdRewardVideo loadRewardVideoAd:");
            IFLYVideoAd iFLYVideoAd2 = new IFLYVideoAd(this.context, this.slotID, 1, new a());
            this.f3957a = iFLYVideoAd2;
            iFLYVideoAd2.setDirectJump(true);
            IFLYVideoAd iFLYVideoAd3 = this.f3957a;
            Boolean bool = Boolean.TRUE;
            iFLYVideoAd3.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
            this.f3957a.setParameter(AdKeys.OAID, VlionPrivateInfo.getOaid());
            this.f3957a.setParameter(AdKeys.DEBUG_MODE, Boolean.valueOf(VlionSDkManager.getInstance().isEnableLog()));
            VlionAdapterADConfig vlionAdapterADConfig = this.vlionAdapterADConfig;
            if (vlionAdapterADConfig != null) {
                if (vlionAdapterADConfig.getSecondPop() == 0) {
                    this.f3957a.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
                }
                this.f3957a.setParameter(AdKeys.HTTP_REQUEST_TIMEOUT, Float.valueOf(this.vlionAdapterADConfig.getTolerateTime() * 1000.0f));
            }
            LogVlion.e("VlionKdRewardVideo isBid=" + this.isBid + " bidFloorPrice=" + this.bidFloorPrice);
            if (this.isBid) {
                this.f3957a.setParameter(AdKeys.BID_FLOOR, String.valueOf(this.bidFloorPrice));
                iFLYVideoAd = this.f3957a;
                str = "1";
            } else {
                iFLYVideoAd = this.f3957a;
                str = "0";
            }
            iFLYVideoAd.setParameter(AdKeys.SETTLE_TYPE, str);
            this.f3957a.loadAd();
            LogVlion.e("VlionKdRewardVideo loadAd");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        try {
            VideoDataRef videoDataRef = this.f3958b;
            if (videoDataRef != null) {
                videoDataRef.onBiddingFailure(101, "价格低");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final void renderRewardVideoAD() {
        VideoDataRef videoDataRef;
        try {
            super.renderRewardVideoAD();
            LogVlion.e("VlionKdRewardVideo renderAD isAdLoadSuccess=" + isHaveLoadStatus());
            if (this.f3957a == null || (videoDataRef = this.f3958b) == null) {
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_RENDER_ERROR;
                    vlionBiddingActionRewardListener.onAdRenderFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            } else {
                videoDataRef.onBiddingSuccess();
                this.f3957a.cacheVideo();
            }
        } catch (Throwable unused) {
            VlionBiddingActionRewardListener vlionBiddingActionRewardListener2 = this.vlionBiddingActionRewardListener;
            if (vlionBiddingActionRewardListener2 != null) {
                VlionAdBaseError vlionAdBaseError2 = VlionAdBaseError.Exception_CODE_ERROR;
                vlionBiddingActionRewardListener2.onAdRenderFailure(vlionAdBaseError2.getErrorCode(), vlionAdBaseError2.getErrorMessage());
            }
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final void showRewardVideoAd(Activity activity) {
        try {
            LogVlion.e("VlionKdRewardVideo showRewardVideoAd");
            if (this.f3957a == null || this.f3958b == null) {
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_SHOW_ERROR;
                    vlionBiddingActionRewardListener.onAdShowFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            } else {
                LogVlion.e("VlionKdRewardVideo showRewardVideoAd view");
                VlionKdRewardVideoActivity.a(activity, this.f3957a, this.f3958b, this.f3959c, this.vlionAdapterADConfig, new b());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
