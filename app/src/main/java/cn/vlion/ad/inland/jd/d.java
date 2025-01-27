package cn.vlion.ad.inland.jd;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.bid.VlionNativeActionListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.l5;
import cn.vlion.ad.inland.base.natives.VlionNativeADEventListener;
import cn.vlion.ad.inland.base.natives.VlionNativeAdData;
import cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener;
import cn.vlion.ad.inland.base.natives.VlionNativeAdvert;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.util.DensityUtil;
import cn.vlion.ad.inland.base.util.VlionADLogoUtils;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeInteractionListener;
import com.jd.ad.sdk.nativead.JADNativeLoadListener;
import com.jd.ad.sdk.nativead.JADNativeWidget;
import java.util.List;

/* loaded from: classes.dex */
public final class d extends VlionBaseAdAdapterNative {

    /* renamed from: a */
    public JADNative f3826a;

    /* renamed from: b */
    public int f3827b;

    /* renamed from: c */
    public int f3828c;

    public class a implements JADNativeLoadListener {

        /* renamed from: cn.vlion.ad.inland.jd.d$a$a */
        public class C0033a extends VlionNativeAdImpMaterialListener {

            /* renamed from: a */
            public final /* synthetic */ VlionNativeAdData f3830a;

            /* renamed from: cn.vlion.ad.inland.jd.d$a$a$a */
            public class C0034a implements JADNativeInteractionListener {

                /* renamed from: a */
                public final /* synthetic */ VlionNativeADEventListener f3832a;

                public C0034a(VlionNativeADEventListener vlionNativeADEventListener) {
                    this.f3832a = vlionNativeADEventListener;
                }

                @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
                public final void onClick(View view) {
                    try {
                        LogVlion.e("VlionJdNative onClick");
                        VlionNativeActionListener vlionNativeActionListener = d.this.vlionNativeActionListener;
                        if (vlionNativeActionListener != null) {
                            vlionNativeActionListener.onClick();
                        }
                        VlionNativeADEventListener vlionNativeADEventListener = this.f3832a;
                        if (vlionNativeADEventListener != null) {
                            vlionNativeADEventListener.onClick();
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }

                @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
                public final void onClose(View view) {
                    try {
                        LogVlion.e("VlionJdNative onClose");
                        VlionNativeActionListener vlionNativeActionListener = d.this.vlionNativeActionListener;
                        if (vlionNativeActionListener != null) {
                            vlionNativeActionListener.onClose();
                        }
                        VlionNativeADEventListener vlionNativeADEventListener = this.f3832a;
                        if (vlionNativeADEventListener != null) {
                            vlionNativeADEventListener.onClose();
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }

                @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
                public final void onExposure() {
                    try {
                        LogVlion.e("VlionJdNative onExposure");
                        VlionNativeActionListener vlionNativeActionListener = d.this.vlionNativeActionListener;
                        if (vlionNativeActionListener != null) {
                            vlionNativeActionListener.onExposure();
                        }
                        VlionNativeADEventListener vlionNativeADEventListener = this.f3832a;
                        if (vlionNativeADEventListener != null) {
                            vlionNativeADEventListener.onExposure();
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }
            }

            /* renamed from: cn.vlion.ad.inland.jd.d$a$a$b */
            public class b implements VlionNativesAdVideoListener {
                public b() {
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onAdVideoPlayError(String str) {
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onProgressUpdate(int i10, int i11) {
                    d.this.f3827b = i10;
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onVideoAdComplete() {
                    try {
                        if (d.this.f3826a == null || d.this.f3826a.getJADVideoReporter() == null) {
                            return;
                        }
                        d.this.f3826a.getJADVideoReporter().reportVideoCompleted(d.this.f3827b);
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onVideoAdContinuePlay() {
                    try {
                        if (d.this.f3826a == null || d.this.f3826a.getJADVideoReporter() == null) {
                            return;
                        }
                        d.this.f3826a.getJADVideoReporter().reportVideoResume(d.this.f3827b);
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onVideoAdPaused() {
                    try {
                        if (d.this.f3826a == null || d.this.f3826a.getJADVideoReporter() == null) {
                            return;
                        }
                        d.this.f3826a.getJADVideoReporter().reportVideoPause(d.this.f3827b);
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onVideoAdStartPlay() {
                    try {
                        if (d.this.f3826a == null || d.this.f3826a.getJADVideoReporter() == null) {
                            return;
                        }
                        d.this.f3826a.getJADVideoReporter().reportVideoStart(d.this.f3827b);
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onVideoError(int i10, int i11) {
                    try {
                        if (d.this.f3826a == null || d.this.f3826a.getJADVideoReporter() == null) {
                            return;
                        }
                        d.this.f3826a.getJADVideoReporter().reportVideoError(d.this.f3827b, i10, i11);
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onVideoLoad() {
                    try {
                        if (d.this.f3826a == null || d.this.f3826a.getJADVideoReporter() == null) {
                            return;
                        }
                        d.this.f3826a.getJADVideoReporter().reportVideoWillStart();
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }
            }

            public C0033a(VlionNativeAdData vlionNativeAdData) {
                this.f3830a = vlionNativeAdData;
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
            public final void destroy() {
                super.destroy();
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
            public final void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource) {
                LogVlion.e("VlionJdNative notifyWinPrice");
                VlionNativeActionListener vlionNativeActionListener = d.this.vlionNativeActionListener;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.notifyWinPrice(d10, vlionBidderSource);
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
            public final void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossBiddingReason vlionLossBiddingReason) {
                LogVlion.e("VlionJdNative notifyWinPriceFailure");
                VlionNativeActionListener vlionNativeActionListener = d.this.vlionNativeActionListener;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.notifyWinPriceFailure(d10, vlionBidderSource, vlionLossBiddingReason);
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
            public final void onAdRender(Context context, VlionNativeAdData vlionNativeAdData) {
                try {
                    super.onAdRender(context, vlionNativeAdData);
                    VlionNativeActionListener vlionNativeActionListener = d.this.vlionNativeActionListener;
                    if (vlionNativeActionListener != null) {
                        vlionNativeActionListener.onAdRenderSuccess();
                    }
                    if (d.this.f3828c == 1) {
                        View shakeAnimationView = JADNativeWidget.getShakeAnimationView(d.this.context);
                        this.mcontainerLayout.removeView(shakeAnimationView);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(260, 260);
                        layoutParams.gravity = 17;
                        this.mcontainerLayout.addView(shakeAnimationView, layoutParams);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
            public final void registerNativeView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, VlionNativeADEventListener vlionNativeADEventListener) {
                l5 l5Var;
                try {
                    super.registerNativeView(activity, viewGroup, list, list2, list3, vlionNativeADEventListener);
                    if (d.this.f3826a != null) {
                        d.this.f3826a.registerNativeView(activity, viewGroup, list, list3, new C0034a(vlionNativeADEventListener));
                    }
                    if (this.f3830a.getVlionNativeType() != 4 || (l5Var = this.mcontainerLayout) == null) {
                        return;
                    }
                    l5Var.setAdVlionVideoListener(new b());
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public a() {
        }

        @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
        public final void onLoadFailure(int i10, String str) {
            try {
                LogVlion.e("VlionJdNative onLoadFailure:code=" + i10 + " error=" + str);
                VlionBiddingLoadListener vlionBiddingLoadListener = d.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(i10, str);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
        public final void onLoadSuccess() {
            try {
                d dVar = d.this;
                dVar.price = dVar.getPrice();
                LogVlion.e("VlionJdNative onLoadSuccess:" + d.this.price);
                List<JADMaterialData> dataList = d.this.f3826a.getDataList();
                if (dataList == null || dataList.size() <= 0) {
                    return;
                }
                LogVlion.e("VlionJdNative onLoadSuccess adList.size():" + dataList.size());
                JADMaterialData jADMaterialData = dataList.get(0);
                VlionNativeAdData vlionNativeAdData = new VlionNativeAdData();
                d.this.f3828c = 0;
                if (jADMaterialData != null) {
                    LogVlion.e("VlionJdNative jadMaterialData.getMediaStyle():" + jADMaterialData.getMediaStyle() + " MEDIA_SPEC_SET_TYPE_FEED16_9_SINGLE10003");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("VlionJdNative onLoadSuccess jadMaterialData.getEventInteractionType()=:");
                    sb2.append(jADMaterialData.getEventInteractionType());
                    LogVlion.e(sb2.toString());
                    d.this.f3828c = jADMaterialData.getEventInteractionType();
                    String mediaStyle = jADMaterialData.getMediaStyle();
                    if (mediaStyle.hashCode() == 49 && mediaStyle.equals("1")) {
                        vlionNativeAdData.setVlionNativeType(1);
                    }
                    if (jADMaterialData.getImageUrls() != null && jADMaterialData.getImageUrls().size() > 2) {
                        vlionNativeAdData.setVlionNativeType(3);
                    }
                    vlionNativeAdData.setLogoBitmap(VlionADLogoUtils.getLogo(d.this.context));
                    vlionNativeAdData.setBrandUrl("");
                    vlionNativeAdData.setPrice(d.this.price);
                    vlionNativeAdData.setTitle(jADMaterialData.getTitle());
                    vlionNativeAdData.setDescription(jADMaterialData.getDescription());
                    vlionNativeAdData.setImgList(jADMaterialData.getImageUrls());
                    vlionNativeAdData.setImageWidth(jADMaterialData.getImageWidth());
                    vlionNativeAdData.setImageHeight(jADMaterialData.getImageHeight());
                    vlionNativeAdData.setImageScale(d.this.imageScale);
                    if (jADMaterialData.getVideoUrl() != null && jADMaterialData.getVideoUrl().length() > 0) {
                        vlionNativeAdData.setVlionNativeType(4);
                        vlionNativeAdData.setVideoUrl(jADMaterialData.getVideoUrl());
                    }
                    vlionNativeAdData.setIs_circulation(d.this.is_circulation);
                    LogVlion.e("VlionJdNative jadMaterialData.getImageWidth()" + jADMaterialData.getImageWidth() + " jadMaterialData.getImageHeight()=" + jADMaterialData.getImageHeight());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("VlionJdNative jadMaterialData.getImageUrls()");
                    sb3.append(jADMaterialData.getImageUrls().get(0).replace("http", "---"));
                    LogVlion.e(sb3.toString());
                    LogVlion.e("VlionJdNative jadMaterialData.getVideoUrl()" + jADMaterialData.getVideoUrl().replace("http", "---"));
                }
                VlionNativeAdvert vlionNativeAdvert = new VlionNativeAdvert(d.this.context, vlionNativeAdData, new C0033a(vlionNativeAdData));
                VlionBiddingLoadListener vlionBiddingLoadListener = d.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadSuccess(vlionNativeAdvert);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public d(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        this.f3827b = 0;
        this.f3828c = 0;
        try {
            JADSlot.Builder builder = new JADSlot.Builder();
            LogVlion.e("VlionJdNative getSlotID:" + this.slotID + " widthPx=" + this.widthPx + " heightPx" + this.heightPx + " dpWidth=" + DensityUtil.px2dip(context, this.widthPx) + " dpHeight=" + DensityUtil.px2dip(context, this.heightPx));
            builder.setSlotID(this.slotID).setImageSize((float) DensityUtil.px2dip(context, this.widthPx), (float) DensityUtil.px2dip(context, this.heightPx)).setAdType(2);
            this.f3826a = new JADNative(builder.build());
            LogVlion.e("VlionJdNative :");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative
    public final void destroy() {
        try {
            JADNative jADNative = this.f3826a;
            if (jADNative != null) {
                jADNative.destroy();
                this.f3828c = 0;
                this.f3826a = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative
    public final int getPrice() {
        int i10 = -1;
        try {
            JADNative jADNative = this.f3826a;
            if (jADNative == null || jADNative.getJADExtra() == null) {
                return -1;
            }
            i10 = this.f3826a.getJADExtra().getPrice();
            LogVlion.e("VlionJdNative getPrice " + i10);
            return i10;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return i10;
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative
    public final void loadAd() {
        try {
            JADNative jADNative = this.f3826a;
            if (jADNative != null) {
                jADNative.loadAd(new a());
            } else {
                VlionBiddingLoadListener vlionBiddingLoadListener = this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_IS_DESTROY;
                    vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
