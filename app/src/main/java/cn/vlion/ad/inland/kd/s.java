package cn.vlion.ad.inland.kd;

import android.content.Context;
import android.view.ViewGroup;
import cn.vlion.ad.inland.ad.utils.VlionCustomSpitUtils;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionPrivateInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.shu.priory.IFLYSplashAd;
import com.shu.priory.bean.DownloadDialogInfo;
import com.shu.priory.config.AdError;
import com.shu.priory.config.AdKeys;
import com.shu.priory.conn.SplashDataRef;
import com.shu.priory.download.DownLoadDialogCallback;
import com.shu.priory.listener.IFLYSplashListener;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class s extends VlionBaseAdAdapterSplash {

    /* renamed from: a */
    public IFLYSplashAd f3966a;

    /* renamed from: b */
    public SplashDataRef f3967b;

    public class a implements IFLYSplashListener {
        public a() {
        }

        @Override // com.shu.priory.listener.IFLYSplashListener
        public final void onAdClick() {
            try {
                LogVlion.e("VlionKdSplash onClick");
                VlionBiddingActionListener vlionBiddingActionListener = s.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.listener.IFLYSplashListener
        public final void onAdExposure() {
            try {
                LogVlion.e("VlionKdSplash onExposure");
                VlionBiddingActionListener vlionBiddingActionListener = s.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdExposure();
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
                    LogVlion.e("VlionKdSplash onAdFailed:code=" + errorCode + " error=" + errorDescription);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            } else {
                errorDescription = "";
                errorCode = -1;
            }
            VlionBiddingLoadListener vlionBiddingLoadListener = s.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadFailure(errorCode, errorDescription);
            }
        }

        @Override // com.shu.priory.listener.IFLYBaseAdListener
        public final void onAdLoaded(SplashDataRef splashDataRef) {
            s.this.f3967b = splashDataRef;
            try {
                int price = s.this.getPrice();
                LogVlion.e("VlionKdSplash onLoadSuccess " + price);
                VlionBiddingLoadListener vlionBiddingLoadListener = s.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadSuccess(price);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.listener.IFLYSplashListener
        public final void onAdSkip() {
            try {
                LogVlion.e("VlionKdSplash onClose");
                VlionBiddingActionListener vlionBiddingActionListener = s.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.listener.IFLYSplashListener
        public final void onAdTimeOver() {
            try {
                LogVlion.e("VlionKdSplash onClose");
                VlionBiddingActionListener vlionBiddingActionListener = s.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClose();
                }
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
                LogVlion.e("VlionKdSplash onShowDownloadDialog");
                new j(s.this.context, downloadDialogInfo, downLoadDialogCallback).show();
                return true;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return true;
            }
        }
    }

    public s(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        try {
            LogVlion.e("VlionKdSplash:" + this.slotID);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final void destroy() {
        try {
            IFLYSplashAd iFLYSplashAd = this.f3966a;
            if (iFLYSplashAd != null) {
                iFLYSplashAd.destroy();
                this.f3966a = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final int getPrice() {
        int i10 = -1;
        try {
            if (this.f3967b != null) {
                LogVlion.e("VlionKdSplash splashDataRef.getPrice() " + this.f3967b.getPrice());
                i10 = (int) (this.f3967b.getPrice() * 100.0d);
            }
            LogVlion.e("VlionKdSplash getPrice price=" + i10);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return i10;
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void loadAd() {
        IFLYSplashAd iFLYSplashAd;
        String str;
        try {
            super.loadAd();
            IFLYSplashAd iFLYSplashAd2 = new IFLYSplashAd(this.context, this.slotID, new a());
            this.f3966a = iFLYSplashAd2;
            Boolean bool = Boolean.TRUE;
            iFLYSplashAd2.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
            this.f3966a.setParameter(AdKeys.OAID, VlionPrivateInfo.getOaid());
            this.f3966a.setParameter(AdKeys.DEBUG_MODE, Boolean.valueOf(VlionSDkManager.getInstance().isEnableLog()));
            this.f3966a.setParameter(AdKeys.COUNT_DOWN, 5);
            LogVlion.e("VlionKdSplash isBid=" + this.isBid + " bidFloorPrice=" + this.bidFloorPrice);
            if (this.isBid) {
                this.f3966a.setParameter(AdKeys.BID_FLOOR, String.valueOf(this.bidFloorPrice));
                iFLYSplashAd = this.f3966a;
                str = "1";
            } else {
                iFLYSplashAd = this.f3966a;
                str = "0";
            }
            iFLYSplashAd.setParameter(AdKeys.SETTLE_TYPE, str);
            VlionAdapterADConfig vlionAdapterADConfig = this.vlionAdapterADConfig;
            if (vlionAdapterADConfig != null) {
                if (vlionAdapterADConfig.getSecondPop() == 0) {
                    this.f3966a.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
                }
                this.f3966a.setParameter(AdKeys.HTTP_REQUEST_TIMEOUT, Float.valueOf(this.vlionAdapterADConfig.getTolerateTime() * 1000.0f));
                ArrayList<String> splitString = VlionCustomSpitUtils.getSplitString(this.vlionAdapterADConfig.getCreativeType());
                if (splitString.size() > 0) {
                    for (int i10 = 0; i10 < splitString.size(); i10++) {
                        if ("2".equals(splitString.get(i10))) {
                            this.f3966a.setParameter(AdKeys.SPLASH_INTERACTION_DISABLE, Boolean.TRUE);
                        }
                    }
                }
            }
            this.f3966a.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        try {
            SplashDataRef splashDataRef = this.f3967b;
            if (splashDataRef != null) {
                splashDataRef.onBiddingFailure(101, "价格低");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void renderAD() {
        SplashDataRef splashDataRef;
        try {
            super.renderAD();
            LogVlion.e("VlionKdSplash renderAD =");
            if (this.f3966a == null || (splashDataRef = this.f3967b) == null) {
                VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_RENDER_ERROR;
                    vlionBiddingActionListener.onAdRenderFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            } else {
                splashDataRef.onBiddingSuccess();
                VlionBiddingActionListener vlionBiddingActionListener2 = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener2 != null) {
                    vlionBiddingActionListener2.onAdRenderSuccess(null);
                }
            }
        } catch (Throwable unused) {
            VlionBiddingActionListener vlionBiddingActionListener3 = this.vlionBiddingActionListener;
            if (vlionBiddingActionListener3 != null) {
                VlionAdBaseError vlionAdBaseError2 = VlionAdBaseError.Exception_CODE_ERROR;
                vlionBiddingActionListener3.onAdRenderFailure(vlionAdBaseError2.getErrorCode(), vlionAdBaseError2.getErrorMessage());
            }
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final void showAd(ViewGroup viewGroup) {
        try {
            LogVlion.e("VlionKdSplash showAd");
            if (this.f3966a == null || viewGroup == null) {
                VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_SHOW_ERROR;
                    vlionBiddingActionListener.onAdShowFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            } else {
                LogVlion.e("VlionKdSplash showAd adView");
                this.f3966a.showAd(viewGroup);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
