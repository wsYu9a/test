package cn.vlion.ad.inland.kd;

import android.content.Context;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.natives.VlionNativeAdData;
import cn.vlion.ad.inland.base.natives.VlionNativeAdvert;
import cn.vlion.ad.inland.base.util.VlionADLogoUtils;
import cn.vlion.ad.inland.base.util.init.VlionPrivateInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.shu.priory.IFLYNativeAd;
import com.shu.priory.bean.DownloadDialogInfo;
import com.shu.priory.config.AdError;
import com.shu.priory.config.AdKeys;
import com.shu.priory.conn.NativeDataRef;
import com.shu.priory.download.DownLoadDialogCallback;
import com.shu.priory.listener.IFLYBaseAdListener;

/* loaded from: classes.dex */
public final class n extends VlionBaseAdAdapterNative {

    /* renamed from: a */
    public IFLYNativeAd f3936a;

    /* renamed from: b */
    public NativeDataRef f3937b;

    /* renamed from: c */
    public boolean f3938c;

    /* renamed from: d */
    public VlionSensorBean f3939d;

    /* renamed from: e */
    public boolean f3940e;

    public class a implements IFLYBaseAdListener<NativeDataRef> {
        public a() {
        }

        @Override // com.shu.priory.listener.IFLYBaseAdListener
        public final void onAdFailed(AdError adError) {
            int errorCode;
            String errorDescription;
            if (adError != null) {
                try {
                    errorCode = adError.getErrorCode();
                    errorDescription = adError.getErrorDescription();
                    LogVlion.e("VlionKdNative onAdFailed:code=" + errorCode + " error=" + errorDescription);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            } else {
                errorDescription = "";
                errorCode = -1;
            }
            VlionBiddingLoadListener vlionBiddingLoadListener = n.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadFailure(errorCode, errorDescription);
            }
        }

        @Override // com.shu.priory.listener.IFLYBaseAdListener
        public final void onAdLoaded(NativeDataRef nativeDataRef) {
            NativeDataRef nativeDataRef2 = nativeDataRef;
            try {
                n.this.f3937b = nativeDataRef2;
                n nVar = n.this;
                nVar.price = nVar.getPrice();
                VlionNativeAdData vlionNativeAdData = new VlionNativeAdData();
                if (nativeDataRef2 != null) {
                    int price = n.this.getPrice();
                    LogVlion.e("VlionKdNative onLoadSuccess price=" + price + VlionKDAdapter.a(nativeDataRef2));
                    vlionNativeAdData.setLogoBitmap(VlionADLogoUtils.getLogo(n.this.context));
                    vlionNativeAdData.setPrice((double) price);
                    vlionNativeAdData.setTitle(nativeDataRef2.getTitle());
                    vlionNativeAdData.setDescription(nativeDataRef2.getDesc());
                    vlionNativeAdData.setBrandUrl(nativeDataRef2.getIconUrl());
                    vlionNativeAdData.setImageScale(n.this.imageScale);
                    if (nativeDataRef2.getAdImg() != null) {
                        vlionNativeAdData.setImageWidth(nativeDataRef2.getAdImg().getWidth());
                        vlionNativeAdData.setImageHeight(nativeDataRef2.getAdImg().getHeight());
                        vlionNativeAdData.setVlionNativeType(1);
                    } else if (nativeDataRef2.getAdImgList() != null && nativeDataRef2.getAdImgList().size() > 0) {
                        if (nativeDataRef2.getAdImgList().get(0) != null) {
                            vlionNativeAdData.setImageWidth(nativeDataRef2.getAdImgList().get(0).getWidth());
                            vlionNativeAdData.setImageHeight(nativeDataRef2.getAdImgList().get(0).getHeight());
                        }
                        vlionNativeAdData.setVlionNativeType(3);
                    }
                    VlionNativeAdvert vlionNativeAdvert = new VlionNativeAdvert(n.this.context, vlionNativeAdData, new m(this, nativeDataRef2));
                    VlionBiddingLoadListener vlionBiddingLoadListener = n.this.vlionBiddingLoadListener;
                    if (vlionBiddingLoadListener != null) {
                        vlionBiddingLoadListener.onAdLoadSuccess(vlionNativeAdvert);
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onCancel() {
            LogVlion.e("VlionKdNative:onCancel");
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onConfirm() {
            LogVlion.e("VlionKdNative:onConfirm");
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onDownloading() {
            LogVlion.e("VlionKdNative:onDownloading");
        }

        @Override // com.shu.priory.download.DialogListener
        public final boolean onShowDownloadDialog(DownloadDialogInfo downloadDialogInfo, DownLoadDialogCallback downLoadDialogCallback) {
            try {
                LogVlion.e("VlionKdNative:onShowDownloadDialog");
                new j(n.this.context, downloadDialogInfo, downLoadDialogCallback).show();
                return true;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return true;
            }
        }
    }

    public n(Context context, VlionAdapterADConfig vlionAdapterADConfig, boolean z10, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        this.f3940e = false;
        try {
            this.f3938c = z10;
            LogVlion.e("VlionKdNative :" + this.slotID);
            if (vlionAdapterADConfig != null && vlionAdapterADConfig.getAccelerate() == 0 && vlionAdapterADConfig.getAngle() == 0 && vlionAdapterADConfig.getShakeDuration() == 0) {
                this.f3938c = false;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative
    public final void destroy() {
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative
    public final int getPrice() {
        int i10 = -1;
        try {
            if (this.f3937b == null) {
                return -1;
            }
            LogVlion.e("VlionKdNative nativeDataRef.getPrice() " + this.f3937b.getPrice());
            i10 = (int) (this.f3937b.getPrice() * 100.0d);
            LogVlion.e("VlionKdNative getPrice " + i10);
            return i10;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return i10;
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative
    public final void loadAd() {
        IFLYNativeAd iFLYNativeAd;
        String str;
        try {
            IFLYNativeAd iFLYNativeAd2 = new IFLYNativeAd(this.context, this.slotID, new a());
            this.f3936a = iFLYNativeAd2;
            Boolean bool = Boolean.TRUE;
            iFLYNativeAd2.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
            this.f3936a.setParameter(AdKeys.OAID, VlionPrivateInfo.getOaid());
            this.f3936a.setParameter(AdKeys.DEBUG_MODE, Boolean.valueOf(VlionSDkManager.getInstance().isEnableLog()));
            VlionAdapterADConfig vlionAdapterADConfig = this.vlionAdapterADConfig;
            if (vlionAdapterADConfig != null) {
                if (vlionAdapterADConfig.getSecondPop() == 0) {
                    this.f3936a.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
                }
                this.f3936a.setParameter(AdKeys.HTTP_REQUEST_TIMEOUT, Float.valueOf(this.vlionAdapterADConfig.getTolerateTime() * 1000.0f));
            }
            LogVlion.e("VlionKdNative isBid=" + this.isBid + " bidFloorPrice=" + this.bidFloorPrice);
            if (this.isBid) {
                this.f3936a.setParameter(AdKeys.BID_FLOOR, String.valueOf(this.bidFloorPrice));
                iFLYNativeAd = this.f3936a;
                str = "1";
            } else {
                iFLYNativeAd = this.f3936a;
                str = "0";
            }
            iFLYNativeAd.setParameter(AdKeys.SETTLE_TYPE, str);
            this.f3936a.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
