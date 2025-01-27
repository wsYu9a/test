package cn.vlion.ad.inland.ta;

import android.content.Context;
import android.widget.FrameLayout;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.bid.VlionNativeActionListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.natives.VlionNativeAdData;
import cn.vlion.ad.inland.base.natives.VlionNativeAdvert;
import cn.vlion.ad.inland.base.util.VlionADLogoUtils;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.ad.reward.model.VideoParam;
import com.alimm.tanx.core.ad.bean.CreativeItem;
import com.alimm.tanx.core.ad.bean.TanxBiddingInfo;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.ui.TanxSdk;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class g extends VlionBaseAdAdapterNative {

    /* renamed from: a */
    public ITanxAdLoader f4038a;

    /* renamed from: b */
    public TanxAdSlot f4039b;

    /* renamed from: c */
    public ITanxFeedAd f4040c;

    /* renamed from: d */
    public TanxAdView f4041d;

    /* renamed from: e */
    public FrameLayout f4042e;

    public class a implements ITanxRequestLoader.ITanxRequestListener<ITanxFeedAd> {
        public a() {
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public final void onError(TanxError tanxError) {
            if (tanxError != null) {
                try {
                    LogVlion.e("VlionTanxNative onError error.getCode()= " + tanxError.getCode() + " error.getMessage()=" + tanxError.getMessage());
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            }
            VlionBiddingLoadListener vlionBiddingLoadListener = g.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener == null || tanxError == null) {
                return;
            }
            vlionBiddingLoadListener.onAdLoadFailure(tanxError.getCode(), tanxError.getMessage());
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public final void onSuccess(List<ITanxFeedAd> list) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionTanxNative onSuccess null != adList=");
                sb2.append(list != null);
                LogVlion.e(sb2.toString());
                if (list == null || list.size() <= 0) {
                    VlionBiddingLoadListener vlionBiddingLoadListener = g.this.vlionBiddingLoadListener;
                    if (vlionBiddingLoadListener != null) {
                        VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_IS_EMPTY;
                        vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                        return;
                    }
                    return;
                }
                LogVlion.e("VlionTanxNative onSuccess adList=" + list.size());
                long j10 = 0;
                ITanxFeedAd iTanxFeedAd = null;
                for (ITanxFeedAd iTanxFeedAd2 : list) {
                    if (iTanxFeedAd2.getBidInfo().getBidPrice() >= j10) {
                        j10 = iTanxFeedAd2.getBidInfo().getBidPrice();
                        iTanxFeedAd = iTanxFeedAd2;
                    }
                }
                if (iTanxFeedAd != null) {
                    g.a(g.this, iTanxFeedAd);
                    return;
                }
                VlionBiddingLoadListener vlionBiddingLoadListener2 = g.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener2 != null) {
                    VlionAdBaseError vlionAdBaseError2 = VlionAdBaseError.OTHER_AD_IS_EMPTY;
                    vlionBiddingLoadListener2.onAdLoadFailure(vlionAdBaseError2.getErrorCode(), vlionAdBaseError2.getErrorMessage());
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public final void onTimeOut() {
            try {
                LogVlion.e("VlionTanxNative onTimeOut ");
                VlionBiddingLoadListener vlionBiddingLoadListener = g.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(-1, "TimeOut");
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public g(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        this.f4041d = null;
        try {
            this.f4039b = new TanxAdSlot.Builder().adCount(1).pid(this.slotID).setCacheUnderWifi(false).setPlayUnderWifi(false).setNotAutoPlay(false).setVideoParam(new VideoParam(this.isClosedVolume)).setFeedBackDialog(true).build();
            this.f4038a = TanxSdk.getSDKManager().createAdLoader(context);
            LogVlion.e("VlionTanxNative VlionTaNative slotID=" + this.slotID);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(g gVar, ITanxFeedAd iTanxFeedAd) {
        gVar.getClass();
        try {
            LogVlion.e("VlionTaNative renderAD  price=" + gVar.price);
            if (gVar.f4038a == null || iTanxFeedAd == null || iTanxFeedAd.getBiddingInfo() == null) {
                VlionNativeActionListener vlionNativeActionListener = gVar.vlionNativeActionListener;
                if (vlionNativeActionListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_RENDER_ERROR;
                    vlionNativeActionListener.onAdRenderFailure(new VlionAdBaseError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                }
            } else {
                LogVlion.e("VlionTaNative renderAD bid=");
                TanxBiddingInfo biddingInfo = iTanxFeedAd.getBiddingInfo();
                biddingInfo.setBidResult(true);
                biddingInfo.setWinPrice(gVar.getPrice());
                iTanxFeedAd.setBiddingResult(biddingInfo);
                ArrayList arrayList = new ArrayList();
                arrayList.add(iTanxFeedAd);
                LogVlion.e("VlionTaNative biddingResult adList " + arrayList.size());
                gVar.f4038a.biddingResult(arrayList, new h(gVar, arrayList));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative
    public final void destroy() {
        try {
            if (this.f4040c != null) {
                this.f4040c = null;
            }
            ITanxAdLoader iTanxAdLoader = this.f4038a;
            if (iTanxAdLoader != null) {
                iTanxAdLoader.destroy();
                this.f4038a = null;
            }
            if (this.f4041d != null) {
                this.f4041d = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative
    public final int getPrice() {
        try {
            ITanxFeedAd iTanxFeedAd = this.f4040c;
            if (iTanxFeedAd != null) {
                r0 = iTanxFeedAd.getBidInfo() != null ? (int) this.f4040c.getBidInfo().getBidPrice() : -1;
                LogVlion.e("VlionTanxNative getPrice price=" + r0);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return r0;
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative
    public final void loadAd() {
        try {
            LogVlion.e("VlionTanxNative loadAd");
            if (this.f4038a != null) {
                LogVlion.e("VlionTanxNative loadAd isBid=" + this.isBid + " bidFloorPric=" + this.bidFloorPrice);
                this.f4038a.request(this.f4039b, new a());
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

    public static void b(g gVar) {
        int i10;
        int i11;
        gVar.getClass();
        try {
            LogVlion.e("VlionTanxNative onSuccess ecpm=" + gVar.price);
            VlionNativeAdData vlionNativeAdData = new VlionNativeAdData();
            ITanxFeedAd iTanxFeedAd = gVar.f4040c;
            if (iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null || gVar.f4040c.getBidInfo().getCreativeItem() == null) {
                VlionBiddingLoadListener vlionBiddingLoadListener = gVar.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(-1, "iTanxFeedAdBiddingResult is empty");
                    return;
                }
                return;
            }
            CreativeItem creativeItem = gVar.f4040c.getBidInfo().getCreativeItem();
            vlionNativeAdData.setLogoBitmap(VlionADLogoUtils.getLogo(gVar.context));
            vlionNativeAdData.setBrandUrl(creativeItem.getImgSm());
            vlionNativeAdData.setPrice(gVar.price);
            vlionNativeAdData.setTitle(creativeItem.getTitle());
            vlionNativeAdData.setDescription(creativeItem.getDescription());
            LogVlion.e("VlionTanxNativeiTanxFeedAdBiddingResult.getAdType()=" + gVar.f4040c.getAdType());
            int i12 = 0;
            switch (gVar.f4040c.getAdType()) {
                case 10:
                case 12:
                    vlionNativeAdData.setVlionNativeType(1);
                    try {
                        i10 = Integer.parseInt(creativeItem.getImageWidth());
                        try {
                            i12 = Integer.parseInt(creativeItem.getImgHeight());
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        i10 = 0;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(creativeItem.getImageUrl());
                    vlionNativeAdData.setImgList(arrayList);
                    vlionNativeAdData.setImageScale(gVar.imageScale);
                    vlionNativeAdData.setImageWidth(i10);
                    vlionNativeAdData.setImageHeight(i12);
                    break;
                case 11:
                case 13:
                    vlionNativeAdData.setVlionNativeType(4);
                    try {
                        i11 = Integer.parseInt(creativeItem.getVideoWidth());
                        try {
                            i12 = Integer.parseInt(creativeItem.getVideoHeight());
                        } catch (Throwable unused3) {
                        }
                    } catch (Throwable unused4) {
                        i11 = 0;
                    }
                    vlionNativeAdData.setVideoWidth(i11);
                    vlionNativeAdData.setVideoHeight(i12);
                    break;
            }
            vlionNativeAdData.setIs_circulation(gVar.is_circulation);
            VlionNativeAdvert vlionNativeAdvert = new VlionNativeAdvert(gVar.context, vlionNativeAdData, new i(gVar, vlionNativeAdData, creativeItem));
            VlionBiddingLoadListener vlionBiddingLoadListener2 = gVar.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener2 != null) {
                vlionBiddingLoadListener2.onAdLoadSuccess(vlionNativeAdvert);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
