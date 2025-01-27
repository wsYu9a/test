package cn.vlion.ad.inland.kd;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener;
import cn.vlion.ad.inland.ad.natives.VlionNativeViewEventManager;
import cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorPara;
import cn.vlion.ad.inland.ad.view.active.VlionShakeGuideLayout;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.bid.VlionNativeActionListener;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.natives.VlionNativeADEventListener;
import cn.vlion.ad.inland.base.natives.VlionNativeAdData;
import cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener;
import cn.vlion.ad.inland.base.natives.VlionNativeAdvert;
import cn.vlion.ad.inland.base.util.VlionADLogoUtils;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionPrivateInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.nettype.NetWorkTypeUtil;
import com.shu.priory.IFLYVideoAd;
import com.shu.priory.bean.DownloadDialogInfo;
import com.shu.priory.config.AdError;
import com.shu.priory.config.AdKeys;
import com.shu.priory.conn.VideoDataRef;
import com.shu.priory.download.DownLoadDialogCallback;
import com.shu.priory.listener.IFLYVideoListener;
import java.util.List;

/* loaded from: classes.dex */
public final class o extends VlionBaseAdAdapterNative {

    /* renamed from: a */
    public IFLYVideoAd f3942a;

    /* renamed from: b */
    public VideoDataRef f3943b;

    /* renamed from: c */
    public VlionNativeADEventListener f3944c;

    /* renamed from: d */
    public boolean f3945d;

    /* renamed from: e */
    public VlionSensorBean f3946e;

    /* renamed from: f */
    public boolean f3947f;

    public class a implements IFLYVideoListener {

        /* renamed from: cn.vlion.ad.inland.kd.o$a$a */
        public class C0038a extends VlionNativeAdImpMaterialListener {

            /* renamed from: a */
            public VlionNativeViewEventManager f3949a;

            /* renamed from: b */
            public VlionShakeGuideLayout f3950b;

            /* renamed from: c */
            public final /* synthetic */ ViewGroup f3951c;

            /* renamed from: cn.vlion.ad.inland.kd.o$a$a$a */
            public class C0039a implements SensorManagerManager.OnShakeListener {
                public C0039a() {
                }

                @Override // cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager.OnShakeListener
                public final void onShake(boolean z10, VlionSensorPara vlionSensorPara) {
                    try {
                        LogVlion.e("VlionKdNativeVideo onShake =");
                        if (o.this.f3947f) {
                            return;
                        }
                        o.this.f3947f = true;
                        VlionSensorManagerHelper.getInstance().unregisterShakeListener(o.this.f3946e);
                        o.this.f3945d = false;
                        o.this.f3946e = null;
                        if (C0038a.this.f3950b != null) {
                            C0038a.this.f3950b.setVisibility(8);
                            C0038a.this.f3950b.destroy();
                            C0038a.this.f3950b = null;
                        }
                        if (o.this.f3943b != null) {
                            LogVlion.e("VlionKdNativeVideo onShake isClick=" + o.this.f3943b.onClick(C0038a.this.f3951c, 2));
                        }
                        VlionNativeActionListener vlionNativeActionListener = o.this.vlionNativeActionListener;
                        if (vlionNativeActionListener != null) {
                            vlionNativeActionListener.onClick();
                        }
                        if (o.this.f3944c != null) {
                            o.this.f3944c.onClick();
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }
            }

            /* renamed from: cn.vlion.ad.inland.kd.o$a$a$b */
            public class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        C0038a c0038a = C0038a.this;
                        if (c0038a.f3951c == null || c0038a.f3950b == null) {
                            return;
                        }
                        C0038a c0038a2 = C0038a.this;
                        c0038a2.f3951c.removeView(c0038a2.f3950b);
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        if (C0038a.this.f3950b.getParent() != null && (C0038a.this.f3950b.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) C0038a.this.f3950b.getParent()).removeView(C0038a.this.f3950b);
                        }
                        C0038a c0038a3 = C0038a.this;
                        c0038a3.f3951c.addView(c0038a3.f3950b, layoutParams);
                        C0038a.this.f3950b.startAnimator(true);
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }
            }

            /* renamed from: cn.vlion.ad.inland.kd.o$a$a$c */
            public class c implements VlionCustomsNativeEventListener {

                /* renamed from: a */
                public final /* synthetic */ VlionNativeADEventListener f3955a;

                public c(VlionNativeADEventListener vlionNativeADEventListener) {
                    this.f3955a = vlionNativeADEventListener;
                }

                @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
                public final void isResume(boolean z10) {
                    try {
                        if (o.this.f3942a != null) {
                            LogVlion.e("VlionKdNativeVideo isResume=" + z10);
                            if (z10) {
                                if (!o.this.f3947f) {
                                    VlionSensorManagerHelper vlionSensorManagerHelper = VlionSensorManagerHelper.getInstance();
                                    o oVar = o.this;
                                    vlionSensorManagerHelper.registerShakeListener(oVar.context, oVar.f3946e);
                                }
                                o.this.f3942a.onResume();
                                return;
                            }
                            LogVlion.e("VlionKdNativeVideo isResume isPlaying()=" + o.this.f3942a.isPlaying());
                            VlionSensorManagerHelper.getInstance().unregisterShakeListener(o.this.f3946e);
                            if (o.this.f3942a.isPlaying()) {
                                o.this.f3942a.onPause();
                            }
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }

                @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
                public final void onAdEnter() {
                }

                @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
                public final void onClick(VlionADClickType vlionADClickType) {
                    try {
                        LogVlion.e("VlionKdNativeVideo onClick");
                        if (o.this.f3943b != null) {
                            LogVlion.e("VlionKdNativeVideo onClick isClick=" + o.this.f3943b.onClick(C0038a.this.f3951c, 2));
                        }
                        VlionNativeActionListener vlionNativeActionListener = o.this.vlionNativeActionListener;
                        if (vlionNativeActionListener != null) {
                            vlionNativeActionListener.onClick();
                        }
                        VlionNativeADEventListener vlionNativeADEventListener = this.f3955a;
                        if (vlionNativeADEventListener != null) {
                            vlionNativeADEventListener.onClick();
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }

                @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
                public final void onClose() {
                    try {
                        LogVlion.e("VlionKdNativeVideo onClose");
                        VlionNativeActionListener vlionNativeActionListener = o.this.vlionNativeActionListener;
                        if (vlionNativeActionListener != null) {
                            vlionNativeActionListener.onClose();
                        }
                        VlionNativeADEventListener vlionNativeADEventListener = this.f3955a;
                        if (vlionNativeADEventListener != null) {
                            vlionNativeADEventListener.onClose();
                        }
                        C0038a.this.destroy();
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }

                @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
                public final void onExposure() {
                    try {
                        LogVlion.e("VlionKdNativeVideo onAdExposure ");
                        if (o.this.f3943b != null) {
                            if (!o.this.f3943b.isExposured()) {
                                if (o.this.f3943b != null) {
                                    LogVlion.e("VlionKdNativeVideo onAdExposure isExposure=" + o.this.f3943b.onExposure(C0038a.this.f3951c));
                                }
                                VlionNativeADEventListener vlionNativeADEventListener = this.f3955a;
                                if (vlionNativeADEventListener != null) {
                                    vlionNativeADEventListener.onExposure();
                                }
                            }
                            if (!o.this.f3947f) {
                                VlionSensorManagerHelper vlionSensorManagerHelper = VlionSensorManagerHelper.getInstance();
                                o oVar = o.this;
                                vlionSensorManagerHelper.registerShakeListener(oVar.context, oVar.f3946e);
                            }
                            int i10 = o.this.AutoPlay;
                            boolean z10 = true;
                            if (i10 != 1 && (i10 != 2 || 2 != NetWorkTypeUtil.getConnectionType())) {
                                z10 = false;
                            }
                            LogVlion.e("VlionKdNativeVideo onExposure isPlaying()=" + o.this.f3942a.isPlaying() + " isAutoPlay=" + z10);
                            if (z10 && !o.this.f3942a.isPlaying()) {
                                o.this.f3942a.startPlay();
                            }
                        }
                        VlionNativeActionListener vlionNativeActionListener = o.this.vlionNativeActionListener;
                        if (vlionNativeActionListener != null) {
                            vlionNativeActionListener.onExposure();
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }
            }

            public C0038a(ViewGroup viewGroup) {
                this.f3951c = viewGroup;
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
            public final void destroy() {
                try {
                    super.destroy();
                    if (o.this.f3942a != null) {
                        o.this.f3942a.release();
                        o.this.f3942a = null;
                    }
                    if (o.this.f3943b != null) {
                        o.this.f3943b = null;
                    }
                    VlionNativeViewEventManager vlionNativeViewEventManager = this.f3949a;
                    if (vlionNativeViewEventManager != null) {
                        vlionNativeViewEventManager.destroy();
                        this.f3949a = null;
                    }
                    VlionShakeGuideLayout vlionShakeGuideLayout = this.f3950b;
                    if (vlionShakeGuideLayout != null) {
                        vlionShakeGuideLayout.destroy();
                        this.f3950b = null;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
            public final void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource) {
                try {
                    LogVlion.e("VlionKdNativeVideo notifyWinPrice");
                    if (o.this.f3943b != null) {
                        o.this.f3943b.onBiddingFailure(101, "价格低");
                    }
                    VlionNativeActionListener vlionNativeActionListener = o.this.vlionNativeActionListener;
                    if (vlionNativeActionListener != null) {
                        vlionNativeActionListener.notifyWinPrice(d10, vlionBidderSource);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
            public final void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossBiddingReason vlionLossBiddingReason) {
                try {
                    LogVlion.e("VlionKdNativeVideo notifyWinPrice");
                    if (o.this.f3943b != null) {
                        o.this.f3943b.onBiddingFailure(101, "价格低");
                    }
                    VlionNativeActionListener vlionNativeActionListener = o.this.vlionNativeActionListener;
                    if (vlionNativeActionListener != null) {
                        vlionNativeActionListener.notifyWinPriceFailure(d10, vlionBidderSource, vlionLossBiddingReason);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
            public final void onAdRender(Context context, VlionNativeAdData vlionNativeAdData) {
                o oVar;
                VlionAdapterADConfig vlionAdapterADConfig;
                try {
                    if (o.this.f3945d) {
                        if (o.this.f3946e == null && (vlionAdapterADConfig = (oVar = o.this).vlionAdapterADConfig) != null) {
                            oVar.f3946e = new VlionSensorBean(vlionAdapterADConfig.getAccelerate(), o.this.vlionAdapterADConfig.getAngle(), o.this.vlionAdapterADConfig.getShakeDuration(), new C0039a());
                        }
                        if (this.f3950b == null) {
                            this.f3950b = new VlionShakeGuideLayout(o.this.context);
                        }
                        ViewGroup viewGroup = this.f3951c;
                        if (viewGroup != null) {
                            viewGroup.post(new b());
                        }
                    }
                    setAdMediaView(this.f3951c);
                    o.this.vlionNativeActionListener.onAdRenderSuccess();
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
            public final void registerNativeView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, VlionNativeADEventListener vlionNativeADEventListener) {
                try {
                    super.registerNativeView(activity, viewGroup, list, list2, list3, vlionNativeADEventListener);
                    o.this.f3944c = vlionNativeADEventListener;
                    this.f3949a = new VlionNativeViewEventManager(activity, viewGroup, list, list3, "", null, new c(vlionNativeADEventListener));
                    if (o.this.f3942a != null) {
                        o.this.f3942a.showAd(new Object[0]);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public a() {
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onAdClick() {
            try {
                LogVlion.e("VlionKdNativeVideo onClick=");
                if (VlionServiceConfigParse.getInstance().isHotspot()) {
                    if (o.this.f3943b != null && o.this.f3942a != null) {
                        LogVlion.e("VlionKdNativeVideo onClick=" + o.this.f3943b.onClick(o.this.f3942a.getVideoView(), 2));
                    }
                    VlionNativeActionListener vlionNativeActionListener = o.this.vlionNativeActionListener;
                    if (vlionNativeActionListener != null) {
                        vlionNativeActionListener.onClick();
                    }
                    if (o.this.f3944c != null) {
                        o.this.f3944c.onClick();
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
                    LogVlion.e("VlionKdNativeVideo onAdFailed:code=" + errorCode + " error=" + errorDescription);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            } else {
                errorDescription = "";
                errorCode = -1;
            }
            VlionBiddingLoadListener vlionBiddingLoadListener = o.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadFailure(errorCode, errorDescription);
            }
        }

        @Override // com.shu.priory.listener.IFLYBaseAdListener
        public final void onAdLoaded(VideoDataRef videoDataRef) {
            VideoDataRef videoDataRef2 = videoDataRef;
            try {
                LogVlion.e("VlionKdNativeVideo:onAdLoaded");
                o.this.f3943b = videoDataRef2;
                if (o.this.f3942a != null) {
                    o.this.f3942a.cacheVideo();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onAdPlayError() {
            LogVlion.e("VlionKdNativeVideo:onAdPlayError");
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onCancel() {
            LogVlion.e("VlionKdNativeVideo:onCancel");
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onConfirm() {
            LogVlion.e("VlionKdNativeVideo:onConfirm");
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onDownloading() {
            LogVlion.e("VlionKdNativeVideo:onDownloading");
        }

        @Override // com.shu.priory.download.DialogListener
        public final boolean onShowDownloadDialog(DownloadDialogInfo downloadDialogInfo, DownLoadDialogCallback downLoadDialogCallback) {
            try {
                LogVlion.e("VlionKdNativeVideo:onShowDownloadDialog");
                new j(o.this.context, downloadDialogInfo, downLoadDialogCallback).show();
                return true;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return true;
            }
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onVideoCached() {
            if (o.this.f3943b == null) {
                VlionBiddingLoadListener vlionBiddingLoadListener = o.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_IS_DESTROY;
                    vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                    return;
                }
                return;
            }
            ViewGroup videoView = o.this.f3942a.getVideoView();
            VlionNativeAdData vlionNativeAdData = new VlionNativeAdData();
            o oVar = o.this;
            oVar.price = oVar.getPrice();
            vlionNativeAdData.setPrice(o.this.price);
            LogVlion.e("VlionKdNativeVideo notifyWinPrice" + VlionKDAdapter.a(o.this.f3943b));
            vlionNativeAdData.setLogoBitmap(VlionADLogoUtils.getLogo(o.this.context));
            vlionNativeAdData.setTitle(o.this.f3943b.getTitle());
            vlionNativeAdData.setDescription(o.this.f3943b.getDesc());
            vlionNativeAdData.setBrandUrl(o.this.f3943b.getIconUrl());
            vlionNativeAdData.setVideoWidth(o.this.f3943b.getWidth());
            vlionNativeAdData.setVideoHeight(o.this.f3943b.getHeight());
            vlionNativeAdData.setImageWidth(o.this.f3943b.getWidth());
            vlionNativeAdData.setImageHeight(o.this.f3943b.getHeight());
            vlionNativeAdData.setVlionNativeType(4);
            vlionNativeAdData.setVideoCover(o.this.f3943b.getAdSourceMark());
            VlionNativeAdvert vlionNativeAdvert = new VlionNativeAdvert(o.this.context, vlionNativeAdData, new C0038a(videoView));
            VlionBiddingLoadListener vlionBiddingLoadListener2 = o.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener2 != null) {
                vlionBiddingLoadListener2.onAdLoadSuccess(vlionNativeAdvert);
            }
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onVideoComplete() {
            LogVlion.e("VlionKdNativeVideo VideoNative:onVideoComplete");
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onVideoReplay() {
            LogVlion.e("VlionKdNativeVideo:onVideoReplay");
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onVideoStart() {
            try {
                LogVlion.e("VlionKdNativeVideo:onVideoStart");
                if (o.this.f3942a != null) {
                    o.this.f3942a.setVolume(o.this.isClosedVolume);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public o(Context context, VlionAdapterADConfig vlionAdapterADConfig, boolean z10, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        this.f3947f = false;
        try {
            this.f3945d = z10;
            LogVlion.e("VlionKdNativeVideo :" + this.slotID);
            if (vlionAdapterADConfig != null && vlionAdapterADConfig.getAccelerate() == 0 && vlionAdapterADConfig.getAngle() == 0 && vlionAdapterADConfig.getShakeDuration() == 0) {
                this.f3945d = false;
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
            if (this.f3943b == null) {
                return -1;
            }
            LogVlion.e("VlionKdNativeVideo videoDataRef.getPrice() " + this.f3943b.getPrice());
            i10 = (int) (this.f3943b.getPrice() * 100.0d);
            LogVlion.e("VlionKdNativeVideo getPrice " + i10);
            return i10;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return i10;
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative
    public final void loadAd() {
        IFLYVideoAd iFLYVideoAd;
        String str;
        try {
            IFLYVideoAd iFLYVideoAd2 = new IFLYVideoAd(this.context, this.slotID, 0, new a());
            this.f3942a = iFLYVideoAd2;
            iFLYVideoAd2.setDirectJump(true);
            IFLYVideoAd iFLYVideoAd3 = this.f3942a;
            Boolean bool = Boolean.TRUE;
            iFLYVideoAd3.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
            this.f3942a.setParameter(AdKeys.OAID, VlionPrivateInfo.getOaid());
            this.f3942a.setParameter(AdKeys.DEBUG_MODE, Boolean.valueOf(VlionSDkManager.getInstance().isEnableLog()));
            VlionAdapterADConfig vlionAdapterADConfig = this.vlionAdapterADConfig;
            if (vlionAdapterADConfig != null) {
                if (vlionAdapterADConfig.getSecondPop() == 0) {
                    this.f3942a.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
                }
                this.f3942a.setParameter(AdKeys.HTTP_REQUEST_TIMEOUT, Float.valueOf(this.vlionAdapterADConfig.getTolerateTime() * 1000.0f));
            }
            LogVlion.e("VlionKdNativeVideo isBid=" + this.isBid + " bidFloorPrice=" + this.bidFloorPrice);
            if (this.isBid) {
                this.f3942a.setParameter(AdKeys.BID_FLOOR, String.valueOf(this.bidFloorPrice));
                iFLYVideoAd = this.f3942a;
                str = "1";
            } else {
                iFLYVideoAd = this.f3942a;
                str = "0";
            }
            iFLYVideoAd.setParameter(AdKeys.SETTLE_TYPE, str);
            this.f3942a.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
