package cn.vlion.ad.inland.ku;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
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
import cn.vlion.ad.inland.base.util.VlionADLogoUtils;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class e extends VlionBaseAdAdapterNative {

    /* renamed from: a */
    public KsScene f3989a;

    /* renamed from: b */
    public KsNativeAd f3990b;

    public class a implements KsLoadManager.NativeAdListener {

        /* renamed from: cn.vlion.ad.inland.ku.e$a$a */
        public class C0043a extends VlionNativeAdImpMaterialListener {

            /* renamed from: a */
            public final /* synthetic */ VlionNativeAdData f3992a;

            /* renamed from: cn.vlion.ad.inland.ku.e$a$a$a */
            public class C0044a implements KsNativeAd.AdInteractionListener {

                /* renamed from: a */
                public final /* synthetic */ VlionNativeADEventListener f3994a;

                public C0044a(VlionNativeADEventListener vlionNativeADEventListener) {
                    this.f3994a = vlionNativeADEventListener;
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return false;
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public final void onAdClicked(View view, KsNativeAd ksNativeAd) {
                    if (ksNativeAd != null) {
                        try {
                            LogVlion.e("VlionKuNative onClick");
                            VlionNativeActionListener vlionNativeActionListener = e.this.vlionNativeActionListener;
                            if (vlionNativeActionListener != null) {
                                vlionNativeActionListener.onClick();
                            }
                            VlionNativeADEventListener vlionNativeADEventListener = this.f3994a;
                            if (vlionNativeADEventListener != null) {
                                vlionNativeADEventListener.onClick();
                            }
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public final void onAdShow(KsNativeAd ksNativeAd) {
                    if (ksNativeAd != null) {
                        try {
                            LogVlion.e("VlionKuNative onExposure");
                            VlionNativeActionListener vlionNativeActionListener = e.this.vlionNativeActionListener;
                            if (vlionNativeActionListener != null) {
                                vlionNativeActionListener.onExposure();
                            }
                            VlionNativeADEventListener vlionNativeADEventListener = this.f3994a;
                            if (vlionNativeADEventListener != null) {
                                vlionNativeADEventListener.onExposure();
                            }
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public final void onDownloadTipsDialogDismiss() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public final void onDownloadTipsDialogShow() {
                }
            }

            /* renamed from: cn.vlion.ad.inland.ku.e$a$a$b */
            public class b implements View.OnClickListener {

                /* renamed from: a */
                public final /* synthetic */ VlionNativeADEventListener f3996a;

                public b(VlionNativeADEventListener vlionNativeADEventListener) {
                    this.f3996a = vlionNativeADEventListener;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        LogVlion.e("VlionKuNative registerNativeView onAdClick");
                        VlionNativeActionListener vlionNativeActionListener = e.this.vlionNativeActionListener;
                        if (vlionNativeActionListener != null) {
                            vlionNativeActionListener.onClose();
                        }
                        VlionNativeADEventListener vlionNativeADEventListener = this.f3996a;
                        if (vlionNativeADEventListener != null) {
                            vlionNativeADEventListener.onClose();
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }
            }

            /* renamed from: cn.vlion.ad.inland.ku.e$a$a$c */
            public class c implements VlionNativesAdVideoListener {
                public c() {
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onAdVideoPlayError(String str) {
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onProgressUpdate(int i10, int i11) {
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onVideoAdComplete() {
                    try {
                        if (e.this.f3990b != null) {
                            e.this.f3990b.reportAdVideoPlayEnd();
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onVideoAdContinuePlay() {
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onVideoAdPaused() {
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onVideoAdStartPlay() {
                    try {
                        if (e.this.f3990b != null) {
                            e.this.f3990b.reportAdVideoPlayStart();
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onVideoError(int i10, int i11) {
                }

                @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
                public final void onVideoLoad() {
                }
            }

            public C0043a(VlionNativeAdData vlionNativeAdData) {
                this.f3992a = vlionNativeAdData;
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
            public final void destroy() {
                super.destroy();
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
            public final void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource) {
                try {
                    LogVlion.e("VlionKuNative notifyWinPrice");
                    e eVar = e.this;
                    eVar.price = eVar.getPrice();
                    if (e.this.f3990b != null) {
                        KsNativeAd ksNativeAd = e.this.f3990b;
                        e eVar2 = e.this;
                        ksNativeAd.setBidEcpm(eVar2.price, eVar2.secondPrice);
                    }
                    if (e.this.f3990b != null) {
                        e.this.f3990b.setBidEcpm(e.this.price, 0L);
                    }
                    VlionNativeActionListener vlionNativeActionListener = e.this.vlionNativeActionListener;
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
                    if (e.this.f3990b == null || vlionLossBiddingReason == null) {
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
                    e.this.f3990b.reportAdExposureFailed(2, adExposureFailedReason);
                    VlionNativeActionListener vlionNativeActionListener = e.this.vlionNativeActionListener;
                    if (vlionNativeActionListener != null) {
                        vlionNativeActionListener.notifyWinPriceFailure(d10, vlionBidderSource, vlionLossBiddingReason);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
            public final void onAdRender(Context context, VlionNativeAdData vlionNativeAdData) {
                super.onAdRender(context, vlionNativeAdData);
                VlionNativeActionListener vlionNativeActionListener = e.this.vlionNativeActionListener;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.onAdRenderSuccess();
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
            public final void registerNativeView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, VlionNativeADEventListener vlionNativeADEventListener) {
                l5 l5Var;
                super.registerNativeView(activity, viewGroup, list, list2, list3, vlionNativeADEventListener);
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put(viewGroup, 1);
                    if (list != null && list.size() > 0) {
                        hashMap.put(list.get(0), 2);
                    }
                    e.this.f3990b.registerViewForInteraction(activity, viewGroup, hashMap, new C0044a(vlionNativeADEventListener));
                    if (e.this.f3990b != null && list3 != null && list3.size() > 0) {
                        for (View view : list3) {
                            LogVlion.e("VlionKuNative closeview setOnClickListener");
                            if (view != null) {
                                view.setOnClickListener(new b(vlionNativeADEventListener));
                            }
                        }
                    }
                    if (this.f3992a.getVlionNativeType() != 4 || (l5Var = this.mcontainerLayout) == null) {
                        return;
                    }
                    l5Var.setAdVlionVideoListener(new c());
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public final void onError(int i10, String str) {
            try {
                VlionBiddingLoadListener vlionBiddingLoadListener = e.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(i10, str);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public final void onNativeAdLoad(List<KsNativeAd> list) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        e.this.f3990b = list.get(0);
                        e eVar = e.this;
                        eVar.price = eVar.getPrice();
                        LogVlion.e("VlionKuNative onLoadSuccess price=" + e.this.price);
                        VlionNativeAdData vlionNativeAdData = new VlionNativeAdData();
                        if (e.this.f3990b == null) {
                            VlionBiddingLoadListener vlionBiddingLoadListener = e.this.vlionBiddingLoadListener;
                            if (vlionBiddingLoadListener != null) {
                                VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_IS_EMPTY;
                                vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                                return;
                            }
                            return;
                        }
                        e eVar2 = e.this;
                        eVar2.price = eVar2.getPrice();
                        LogVlion.e("VlionKuNative onLoadSuccess nativeResponse.getECPMLevel():" + e.this.price);
                        LogVlion.e("VlionKuNative onLoadSuccess nativeResponse=:" + e.this.f3990b.getVideoUrl());
                        vlionNativeAdData.setBrandUrl(e.this.f3990b.getAppIconUrl());
                        vlionNativeAdData.setPrice((double) e.this.price);
                        vlionNativeAdData.setTitle(e.this.f3990b.getInteractionType() == 1 ? e.this.f3990b.getAppName() : e.this.f3990b.getProductName());
                        vlionNativeAdData.setDescription(e.this.f3990b.getAdDescription());
                        vlionNativeAdData.setImageWidth((int) e.this.widthPx);
                        vlionNativeAdData.setImageHeight((int) e.this.heightPx);
                        vlionNativeAdData.setImageScale(e.this.imageScale);
                        vlionNativeAdData.setLogoBitmap(VlionADLogoUtils.getLogo(e.this.context));
                        vlionNativeAdData.setIs_circulation(e.this.is_circulation);
                        ArrayList arrayList = new ArrayList();
                        List<KsImage> imageList = e.this.f3990b.getImageList();
                        if (imageList != null && imageList.size() >= 3) {
                            arrayList.add(imageList.get(0).getImageUrl());
                            arrayList.add(imageList.get(1).getImageUrl());
                            arrayList.add(imageList.get(2).getImageUrl());
                            vlionNativeAdData.setVlionNativeType(3);
                            LogVlion.e("VlionKuNative VlionNativeType.GROUP_IMG");
                        } else if (imageList != null && imageList.size() > 0) {
                            arrayList.add(imageList.get(0).getImageUrl());
                            vlionNativeAdData.setVlionNativeType(1);
                        }
                        if (e.this.f3990b.getVideoUrl() != null && e.this.f3990b.getVideoUrl().length() > 0) {
                            vlionNativeAdData.setVlionNativeType(4);
                            vlionNativeAdData.setVideoCover(e.this.f3990b.getVideoCoverImage().getImageUrl());
                            vlionNativeAdData.setVideoUrl(e.this.f3990b.getVideoUrl());
                            LogVlion.e("VlionKuNative VlionNativeType.VIDEO");
                        }
                        vlionNativeAdData.setImgList(arrayList);
                        if (e.this.f3990b.getInteractionType() == 1) {
                            vlionNativeAdData.setInteractionType(2);
                            VlionNativeAdData.ComplianceInfo complianceInfo = new VlionNativeAdData.ComplianceInfo();
                            complianceInfo.setAppName(e.this.f3990b.getAppPackageName());
                            complianceInfo.setAppVersion(e.this.f3990b.getAppVersion());
                            complianceInfo.setDeveloperName(e.this.f3990b.getCorporationName());
                            complianceInfo.setPrivacyUrl(e.this.f3990b.getAppPrivacyUrl());
                            complianceInfo.setPermissionUrl(e.this.f3990b.getPermissionInfoUrl());
                            complianceInfo.setFunctionDescUrl(e.this.f3990b.getIntroductionInfoUrl());
                            vlionNativeAdData.setComplianceInfo(complianceInfo);
                        }
                        VlionNativeAdvert vlionNativeAdvert = new VlionNativeAdvert(e.this.context, vlionNativeAdData, new C0043a(vlionNativeAdData));
                        VlionBiddingLoadListener vlionBiddingLoadListener2 = e.this.vlionBiddingLoadListener;
                        if (vlionBiddingLoadListener2 != null) {
                            vlionBiddingLoadListener2.onAdLoadSuccess(vlionNativeAdvert);
                            return;
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            }
            VlionBiddingLoadListener vlionBiddingLoadListener3 = e.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener3 != null) {
                vlionBiddingLoadListener3.onAdLoadFailure(-1, "没有广告填充");
            }
        }
    }

    public e(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        long j10;
        try {
            LogVlion.e("VlionKuNative:getSlotID=" + this.slotID + " width=" + this.widthPx + " height=" + this.heightPx);
            try {
                j10 = Long.parseLong(this.slotID);
            } catch (Exception e10) {
                LogVlion.e("VlionKuNative Exception :" + e10.getMessage());
                j10 = 0;
            }
            this.f3989a = new KsScene.Builder(j10).adNum(1).build();
            LogVlion.e("VlionKuNative:");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative
    public final void destroy() {
        try {
            if (this.f3990b != null) {
                this.f3990b = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative
    public final int getPrice() {
        int i10 = -1;
        try {
            KsNativeAd ksNativeAd = this.f3990b;
            if (ksNativeAd == null) {
                return -1;
            }
            i10 = ksNativeAd.getECPM();
            LogVlion.e("VlionKuNative getPrice " + i10);
            return i10;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return i10;
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative
    public final void loadAd() {
        try {
            LogVlion.e("VlionKuNative  loadAd:");
            KsAdSDK.getLoadManager().loadNativeAd(this.f3989a, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
