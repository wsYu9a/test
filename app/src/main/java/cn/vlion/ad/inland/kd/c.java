package cn.vlion.ad.inland.kd;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener;
import cn.vlion.ad.inland.ad.natives.VlionNativeViewEventManager;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterBanner;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
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

/* loaded from: classes.dex */
public final class c extends VlionBaseAdAdapterBanner {

    /* renamed from: a */
    public IFLYVideoAd f3888a;

    /* renamed from: b */
    public VideoDataRef f3889b;

    /* renamed from: c */
    public Activity f3890c;

    /* renamed from: d */
    public boolean f3891d;

    /* renamed from: e */
    public boolean f3892e;

    /* renamed from: f */
    public VlionSensorBean f3893f;

    /* renamed from: g */
    public VlionNativeViewEventManager f3894g;

    public class a implements IFLYVideoListener {

        /* renamed from: cn.vlion.ad.inland.kd.c$a$a */
        public class ViewOnClickListenerC0036a implements View.OnClickListener {

            /* renamed from: a */
            public final /* synthetic */ View f3896a;

            public ViewOnClickListenerC0036a(ViewGroup viewGroup) {
                this.f3896a = viewGroup;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    LogVlion.e("VlionKdBannerVideo action click");
                    if (c.this.f3889b != null) {
                        LogVlion.e("VlionKdBannerVideo action click isClick=" + c.this.f3889b.onClick(this.f3896a, 2));
                    }
                    VlionBiddingActionListener vlionBiddingActionListener = c.this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdClick();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public class b implements View.OnClickListener {

            /* renamed from: a */
            public final /* synthetic */ View f3898a;

            public b(ViewGroup viewGroup) {
                this.f3898a = viewGroup;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    LogVlion.e("VlionKdBannerVideo adview click");
                    if (c.this.f3889b != null) {
                        LogVlion.e("VlionKdBannerVideo adview click isClick =" + c.this.f3889b.onClick(this.f3898a, 2));
                    }
                    VlionBiddingActionListener vlionBiddingActionListener = c.this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdClick();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        /* renamed from: cn.vlion.ad.inland.kd.c$a$c */
        public class ViewOnClickListenerC0037c implements View.OnClickListener {
            public ViewOnClickListenerC0037c() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    VlionBiddingActionListener vlionBiddingActionListener = c.this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdClose();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public class d implements VlionCustomsNativeEventListener {

            /* renamed from: a */
            public final /* synthetic */ View f3901a;

            public d(ViewGroup viewGroup) {
                this.f3901a = viewGroup;
            }

            @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
            public final void isResume(boolean z10) {
                try {
                    if (c.this.f3888a != null) {
                        LogVlion.e("VlionKdBannerVideo isResume=" + z10 + " isShake=" + c.this.f3891d + " isReadyShake=" + c.this.f3892e);
                        if (z10) {
                            if (!c.this.f3892e) {
                                VlionSensorManagerHelper vlionSensorManagerHelper = VlionSensorManagerHelper.getInstance();
                                c cVar = c.this;
                                vlionSensorManagerHelper.registerShakeListener(cVar.context, cVar.f3893f);
                            }
                            c.this.f3888a.onResume();
                            return;
                        }
                        LogVlion.e("VlionKdBannerVideo isResume false isPlaying()=" + c.this.f3888a.isPlaying());
                        VlionSensorManagerHelper.getInstance().unregisterShakeListener(c.this.f3893f);
                        if (c.this.f3888a.isPlaying()) {
                            LogVlion.e("VlionKdBannerVideo isResume false iflyVideoAd.onPause()");
                            c.this.f3888a.onPause();
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
            }

            @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
            public final void onClose() {
                try {
                    LogVlion.e("VlionKdBannerVideo onClose");
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
            public final void onExposure() {
                try {
                    VlionSensorManagerHelper vlionSensorManagerHelper = VlionSensorManagerHelper.getInstance();
                    c cVar = c.this;
                    vlionSensorManagerHelper.registerShakeListener(cVar.context, cVar.f3893f);
                    LogVlion.e("VlionKdBannerVideo onAdExposure isReadyExposure=");
                    if (c.this.f3889b != null) {
                        if (!c.this.f3889b.isExposured()) {
                            if (c.this.f3889b != null) {
                                LogVlion.e("VlionKdBannerVideo onAdExposure isExposure=" + c.this.f3889b.onExposure(this.f3901a));
                            }
                            VlionBiddingActionListener vlionBiddingActionListener = c.this.vlionBiddingActionListener;
                            if (vlionBiddingActionListener != null) {
                                vlionBiddingActionListener.onAdExposure();
                            }
                            if (!c.this.f3892e) {
                                VlionSensorManagerHelper vlionSensorManagerHelper2 = VlionSensorManagerHelper.getInstance();
                                c cVar2 = c.this;
                                vlionSensorManagerHelper2.registerShakeListener(cVar2.context, cVar2.f3893f);
                            }
                        }
                        int i10 = c.this.AutoPlay;
                        boolean z10 = true;
                        if (i10 != 1 && (i10 != 2 || 2 != NetWorkTypeUtil.getConnectionType())) {
                            z10 = false;
                        }
                        LogVlion.e("VlionKdBannerVideo onExposure isPlaying()=" + c.this.f3888a.isPlaying() + " isAutoPlay=" + z10);
                        if (!z10 || c.this.f3888a.isPlaying()) {
                            return;
                        }
                        c.this.f3888a.startPlay();
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
            LogVlion.e("VlionKdBannerVideo:onAdClick=");
            if (VlionServiceConfigParse.getInstance().isHotspot()) {
                if (c.this.f3889b != null && c.this.f3888a != null) {
                    LogVlion.e("VlionKdBannerVideo:onAdClick=" + c.this.f3889b.onClick(c.this.f3888a.getVideoView(), 2));
                }
                VlionBiddingActionListener vlionBiddingActionListener = c.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClick();
                }
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
                    LogVlion.e("VlionKdBannerVideo onAdFailed:code=" + errorCode + " error=" + errorDescription);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            } else {
                errorDescription = "";
                errorCode = -1;
            }
            LogVlion.e("VlionKdBannerVideo:onAdFailed=" + errorCode + " message=" + errorDescription);
            VlionBiddingLoadListener vlionBiddingLoadListener = c.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadFailure(errorCode, errorDescription);
            }
        }

        @Override // com.shu.priory.listener.IFLYBaseAdListener
        public final void onAdLoaded(VideoDataRef videoDataRef) {
            VideoDataRef videoDataRef2 = videoDataRef;
            try {
                c.this.f3889b = videoDataRef2;
                c cVar = c.this;
                cVar.price = cVar.getPrice();
                LogVlion.e("VlionKdBannerVideo:onAdLoaded=" + c.this.price + " videoDataRef.getPrice()=" + videoDataRef2.getPrice());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionKdBannerVideo:onAdLoaded=");
                sb2.append(VlionKDAdapter.a(videoDataRef2));
                LogVlion.e(sb2.toString());
                VlionBiddingLoadListener vlionBiddingLoadListener = c.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadSuccess(r5.price);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onAdPlayError() {
            LogVlion.e("VlionKdBannerVideo:onAdPlayError=");
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onCancel() {
            LogVlion.e("VlionKdBannerVideo:onCancel");
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onConfirm() {
            LogVlion.e("VlionKdBannerVideo:onConfirm");
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onDownloading() {
            LogVlion.e("VlionKdBannerVideo:onDownloading");
        }

        @Override // com.shu.priory.download.DialogListener
        public final boolean onShowDownloadDialog(DownloadDialogInfo downloadDialogInfo, DownLoadDialogCallback downLoadDialogCallback) {
            try {
                LogVlion.e("VlionKdBannerVideo:onShowDownloadDialog");
                new j(c.this.context, downloadDialogInfo, downLoadDialogCallback).show();
                return true;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return true;
            }
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onVideoCached() {
            try {
                if (c.this.f3889b != null) {
                    c cVar = c.this;
                    cVar.price = cVar.getPrice();
                    ViewGroup videoView = c.this.f3888a.getVideoView();
                    LogVlion.e("VlionKdBannerVideo notifyWinPrice" + VlionKDAdapter.a(c.this.f3889b));
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(c.this.context).inflate(R.layout.vlion_cn_ke_ad_banner, (ViewGroup) null, true);
                    LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.vlion_adContainer);
                    TextView textView = (TextView) viewGroup.findViewById(R.id.vlion_tv_title_info);
                    ImageView imageView = (ImageView) viewGroup.findViewById(R.id.vlion_img_showappicon);
                    VlionDownloadProgressBar vlionDownloadProgressBar = (VlionDownloadProgressBar) viewGroup.findViewById(R.id.vlion_tv_action);
                    ImageView imageView2 = (ImageView) viewGroup.findViewById(R.id.vlion_img_close);
                    LinearLayout linearLayout2 = (LinearLayout) viewGroup.findViewById(R.id.vlion_cn_ll_banner);
                    textView.setText(c.this.f3889b.getTitle());
                    VlionKDAdapter.a(imageView, c.this.f3889b.getIconUrl());
                    vlionDownloadProgressBar.setShakeStyle(c.this.context.getResources().getString(cn.vlion.ad.inland.base.R.string.vlion_custom_ad_click_look), c.this.f3891d);
                    vlionDownloadProgressBar.setOnClickListener(new ViewOnClickListenerC0036a(videoView));
                    if (VlionServiceConfigParse.getInstance().isHotspot()) {
                        linearLayout2.setOnClickListener(new b(videoView));
                    }
                    if (videoView != null) {
                        linearLayout.addView(videoView);
                    }
                    imageView2.setOnClickListener(new ViewOnClickListenerC0037c());
                    c cVar2 = c.this;
                    cVar2.f3894g = new VlionNativeViewEventManager(cVar2.f3890c, viewGroup, null, null, "", null, new d(videoView));
                    c.this.f3888a.showAd(new Object[0]);
                    c.a(videoView, vlionDownloadProgressBar, c.this);
                    VlionBiddingActionListener vlionBiddingActionListener = c.this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdRenderSuccess(viewGroup);
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onVideoComplete() {
            LogVlion.e("VlionKdBannerVideo:onVideoComplete=");
            if (c.this.f3888a == null || c.this.f3888a.isPlaying()) {
                return;
            }
            c.this.f3888a.startPlay();
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onVideoReplay() {
            LogVlion.e("VlionKdBannerVideo:onVideoReplay=");
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public final void onVideoStart() {
            LogVlion.e("VlionKdBannerVideo:onVideoStart=");
            if (c.this.f3888a != null) {
                c.this.f3888a.setVolume(c.this.isClosedVolume);
            }
        }
    }

    public c(Activity activity, VlionAdapterADConfig vlionAdapterADConfig, boolean z10, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(activity, vlionAdapterADConfig, vlionBiddingLoadListener);
        this.f3892e = false;
        try {
            this.f3890c = activity;
            this.f3891d = z10;
            if (vlionAdapterADConfig != null && vlionAdapterADConfig.getAccelerate() == 0 && vlionAdapterADConfig.getAngle() == 0 && vlionAdapterADConfig.getShakeDuration() == 0) {
                this.f3891d = false;
            }
            LogVlion.e("VlionKdBannerVideo:" + this.slotID);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterBanner
    public final void destroy() {
        try {
            IFLYVideoAd iFLYVideoAd = this.f3888a;
            if (iFLYVideoAd != null) {
                iFLYVideoAd.release();
                this.f3888a = null;
            }
            if (this.f3889b != null) {
                this.f3889b = null;
            }
            VlionNativeViewEventManager vlionNativeViewEventManager = this.f3894g;
            if (vlionNativeViewEventManager != null) {
                vlionNativeViewEventManager.destroy();
                this.f3894g = null;
            }
            VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f3893f);
            this.f3893f = null;
            this.f3891d = false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterBanner
    public final int getPrice() {
        try {
            if (this.f3889b == null) {
                return 0;
            }
            LogVlion.e("VlionKdBannerVideo videoDataRef.getPrice() " + this.f3889b.getPrice());
            return (int) (this.f3889b.getPrice() * 100.0d);
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
            LogVlion.e("VlionKdBannerVideo:slotID=" + this.slotID);
            IFLYVideoAd iFLYVideoAd2 = new IFLYVideoAd(this.context, this.slotID, 0, new a());
            this.f3888a = iFLYVideoAd2;
            iFLYVideoAd2.setDirectJump(true);
            IFLYVideoAd iFLYVideoAd3 = this.f3888a;
            Boolean bool = Boolean.TRUE;
            iFLYVideoAd3.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
            this.f3888a.setParameter(AdKeys.OAID, VlionPrivateInfo.getOaid());
            this.f3888a.setParameter(AdKeys.DEBUG_MODE, Boolean.valueOf(VlionSDkManager.getInstance().isEnableLog()));
            VlionAdapterADConfig vlionAdapterADConfig = this.vlionAdapterADConfig;
            if (vlionAdapterADConfig != null) {
                if (vlionAdapterADConfig.getSecondPop() == 0) {
                    this.f3888a.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
                }
                this.f3888a.setParameter(AdKeys.HTTP_REQUEST_TIMEOUT, Float.valueOf(this.vlionAdapterADConfig.getTolerateTime() * 1000.0f));
            }
            LogVlion.e("VlionKdBannerVideo isBid=" + this.isBid + " bidFloorPrice=" + this.bidFloorPrice);
            if (this.isBid) {
                this.f3888a.setParameter(AdKeys.BID_FLOOR, String.valueOf(this.bidFloorPrice));
                iFLYVideoAd = this.f3888a;
                str = "1";
            } else {
                iFLYVideoAd = this.f3888a;
                str = "0";
            }
            iFLYVideoAd.setParameter(AdKeys.SETTLE_TYPE, str);
            this.f3888a.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterBanner
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        try {
            VideoDataRef videoDataRef = this.f3889b;
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
            LogVlion.e("VlionKdBannerVideo renderAD:");
            if (this.f3888a == null || (videoDataRef = this.f3889b) == null) {
                VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_RENDER_ERROR;
                    vlionBiddingActionListener.onAdRenderFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            } else {
                videoDataRef.onBiddingSuccess();
                this.f3888a.cacheVideo();
            }
        } catch (Throwable unused) {
            VlionBiddingActionListener vlionBiddingActionListener2 = this.vlionBiddingActionListener;
            if (vlionBiddingActionListener2 != null) {
                VlionAdBaseError vlionAdBaseError2 = VlionAdBaseError.Exception_CODE_ERROR;
                vlionBiddingActionListener2.onAdRenderFailure(vlionAdBaseError2.getErrorCode(), vlionAdBaseError2.getErrorMessage());
            }
        }
    }

    public static void a(ViewGroup viewGroup, VlionDownloadProgressBar vlionDownloadProgressBar, c cVar) {
        VlionAdapterADConfig vlionAdapterADConfig;
        cVar.getClass();
        try {
            if (cVar.f3891d && !cVar.f3892e && (vlionAdapterADConfig = cVar.vlionAdapterADConfig) != null) {
                cVar.f3893f = new VlionSensorBean(vlionAdapterADConfig.getAccelerate(), cVar.vlionAdapterADConfig.getAngle(), cVar.vlionAdapterADConfig.getShakeDuration(), new d(viewGroup, vlionDownloadProgressBar, cVar));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
