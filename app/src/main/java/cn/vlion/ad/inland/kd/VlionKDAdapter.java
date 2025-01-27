package cn.vlion.ad.inland.kd;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.vlion.ad.inland.ad.utils.VlionCustomSpitUtils;
import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterBanner;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterNative;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener;
import cn.vlion.ad.inland.base.bid.VlionNativeActionListener;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionAdapterInitConfig;
import cn.vlion.ad.inland.base.network.ImageCallback;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.data.VlionImageSuccessData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import com.shu.priory.conn.NativeDataRef;
import com.shu.priory.conn.VideoDataRef;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VlionKDAdapter extends BaseAdAdapter {

    /* renamed from: a */
    public VlionBaseAdAdapterBanner f3840a;

    /* renamed from: b */
    public s f3841b;

    /* renamed from: c */
    public VlionBaseAdAdapterNative f3842c;

    /* renamed from: d */
    public VlionBaseAdAdapterInterstitial f3843d;

    /* renamed from: e */
    public p f3844e;

    public class a implements ImageCallback {
        @Override // cn.vlion.ad.inland.base.network.ImageCallback
        public final void onFail(VlionAdBaseError vlionAdBaseError) {
        }

        @Override // cn.vlion.ad.inland.base.network.ImageCallback
        public final void onSuccess(VlionImageSuccessData vlionImageSuccessData) {
        }
    }

    public static String a(NativeDataRef nativeDataRef) {
        StringBuilder sb2 = new StringBuilder();
        if (nativeDataRef == null) {
            return "";
        }
        try {
            if (nativeDataRef.getAdImgList() != null && nativeDataRef.getAdImgList().size() > 0) {
                sb2.append("getAdImgList:" + nativeDataRef.getAdImgList().size() + "\n");
            }
            if (!TextUtils.isEmpty(nativeDataRef.getAppName())) {
                sb2.append("appName:" + nativeDataRef.getAppName() + "\n");
            }
            if (nativeDataRef.getAdImg() != null) {
                sb2.append("getAdImg getUrl:" + nativeDataRef.getAdImg().getUrl() + "\n");
                sb2.append("getAdImg:getWidth=" + nativeDataRef.getAdImg().getWidth() + " getHeight=" + nativeDataRef.getAdImg().getHeight() + "\n");
            }
            if (nativeDataRef.getDownloads() > 0) {
                sb2.append("appDownloads:" + nativeDataRef.getDownloads() + "\n");
            }
            if (!TextUtils.isEmpty(nativeDataRef.getRating())) {
                sb2.append("rating:" + nativeDataRef.getRating() + "\n");
            }
            if (!TextUtils.isEmpty(nativeDataRef.getAppVer())) {
                sb2.append("appVer:" + nativeDataRef.getAppVer() + "\n");
            }
            if (nativeDataRef.getAppSize() > l5.c.f27899e) {
                sb2.append("appSize:" + nativeDataRef.getAppSize() + "\n");
            }
            if (!TextUtils.isEmpty(nativeDataRef.getPhone())) {
                sb2.append("phone:" + nativeDataRef.getPhone() + "\n");
            }
            if (nativeDataRef.getLikes() > 0) {
                sb2.append("likes:" + nativeDataRef.getLikes() + "\n");
            }
            if (nativeDataRef.getOriginalPrice() > l5.c.f27899e) {
                sb2.append("oriprice:" + nativeDataRef.getOriginalPrice() + "\n");
            }
            if (nativeDataRef.getCurrentPrice() > l5.c.f27899e) {
                sb2.append("curPrice:" + nativeDataRef.getCurrentPrice() + "\n");
            }
            if (!TextUtils.isEmpty(nativeDataRef.getSponsored())) {
                sb2.append("sponsored:" + nativeDataRef.getSponsored() + "\n");
            }
            if (!TextUtils.isEmpty(nativeDataRef.getAddress())) {
                sb2.append("address:" + nativeDataRef.getAddress() + "\n");
            }
            if (nativeDataRef.getDisplayLabels() != null && nativeDataRef.getDisplayLabels().size() > 0) {
                sb2.append("displaySize:" + nativeDataRef.getDisplayLabels().size() + "\n");
            }
            if (!TextUtils.isEmpty(nativeDataRef.getAdSourceMark())) {
                sb2.append("mark:" + nativeDataRef.getAdSourceMark() + "\n");
            }
            if (!TextUtils.isEmpty(nativeDataRef.getImgUrl())) {
                sb2.append("imgUrl:" + nativeDataRef.getImgUrl() + "\n");
            }
            if (!TextUtils.isEmpty(nativeDataRef.getIconUrl())) {
                sb2.append("iconUrl:" + nativeDataRef.getIconUrl() + "\n");
            }
            if (!TextUtils.isEmpty(nativeDataRef.getTitle())) {
                sb2.append("title:" + nativeDataRef.getTitle() + "\n");
            }
            if (!TextUtils.isEmpty(nativeDataRef.getDesc())) {
                sb2.append("desc:" + nativeDataRef.getDesc() + "\n");
            }
            if (!TextUtils.isEmpty(nativeDataRef.getContent())) {
                sb2.append("content:" + nativeDataRef.getContent() + "\n");
            }
            if (!TextUtils.isEmpty(nativeDataRef.getBrand())) {
                sb2.append("brand:" + nativeDataRef.getBrand() + "\n");
            }
            if (!TextUtils.isEmpty(nativeDataRef.getCtatext())) {
                sb2.append("ctatext:" + nativeDataRef.getCtatext() + "\n");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return sb2.toString();
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void destroy() {
        try {
            VlionBaseAdAdapterBanner vlionBaseAdAdapterBanner = this.f3840a;
            if (vlionBaseAdAdapterBanner != null) {
                vlionBaseAdAdapterBanner.destroy();
                this.f3840a = null;
            }
            s sVar = this.f3841b;
            if (sVar != null) {
                sVar.destroy();
                this.f3841b = null;
            }
            VlionBaseAdAdapterNative vlionBaseAdAdapterNative = this.f3842c;
            if (vlionBaseAdAdapterNative != null) {
                vlionBaseAdAdapterNative.destroy();
            }
            VlionBaseAdAdapterInterstitial vlionBaseAdAdapterInterstitial = this.f3843d;
            if (vlionBaseAdAdapterInterstitial != null) {
                vlionBaseAdAdapterInterstitial.destroy();
                this.f3843d = null;
            }
            p pVar = this.f3844e;
            if (pVar != null) {
                pVar.destroy();
                this.f3844e = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final String getNetworkName() {
        return "KD";
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void initialize(Application application, VlionAdapterInitConfig vlionAdapterInitConfig, VlionMediaInitCallback vlionMediaInitCallback) {
        try {
            q.a().a(application, vlionAdapterInitConfig, vlionMediaInitCallback);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadBannerAD(Activity activity, VlionAdapterADConfig vlionAdapterADConfig) {
        if (vlionAdapterADConfig != null) {
            try {
                boolean a10 = a(vlionAdapterADConfig);
                if (vlionAdapterADConfig.isKdImage()) {
                    cn.vlion.ad.inland.kd.a aVar = new cn.vlion.ad.inland.kd.a(activity, vlionAdapterADConfig, a10, this.vlionBiddingListener);
                    this.f3840a = aVar;
                    aVar.loadAd();
                } else {
                    c cVar = new c(activity, vlionAdapterADConfig, a10, this.vlionBiddingListener);
                    this.f3840a = cVar;
                    cVar.loadAd();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadDrawAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadFeedAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadInterstitialAD(Activity activity, VlionAdapterADConfig vlionAdapterADConfig) {
        if (vlionAdapterADConfig != null) {
            try {
                boolean a10 = a(vlionAdapterADConfig);
                if (vlionAdapterADConfig.isKdImage()) {
                    k kVar = new k(activity, vlionAdapterADConfig, a10, this.vlionBiddingListener);
                    this.f3843d = kVar;
                    kVar.loadAd();
                } else {
                    l lVar = new l(activity, vlionAdapterADConfig, a10, this.vlionBiddingListener);
                    this.f3843d = lVar;
                    lVar.loadAd();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadNativeAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        if (vlionAdapterADConfig != null) {
            try {
                boolean a10 = a(vlionAdapterADConfig);
                if (vlionAdapterADConfig.isKdImage()) {
                    n nVar = new n(context, vlionAdapterADConfig, a10, this.vlionBiddingListener);
                    this.f3842c = nVar;
                    nVar.loadAd();
                } else {
                    o oVar = new o(context, vlionAdapterADConfig, a10, this.vlionBiddingListener);
                    this.f3842c = oVar;
                    oVar.loadAd();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadRewardVideoAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        if (vlionAdapterADConfig != null) {
            try {
                p pVar = new p(context, vlionAdapterADConfig, a(vlionAdapterADConfig), this.vlionBiddingListener);
                this.f3844e = pVar;
                pVar.loadRewardVideoAd();
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadSplashAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        if (vlionAdapterADConfig != null) {
            try {
                a(vlionAdapterADConfig);
                s sVar = new s(context, vlionAdapterADConfig, this.vlionBiddingListener);
                this.f3841b = sVar;
                sVar.loadAd();
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        try {
            VlionBaseAdAdapterBanner vlionBaseAdAdapterBanner = this.f3840a;
            if (vlionBaseAdAdapterBanner != null) {
                vlionBaseAdAdapterBanner.notifyFailPrice(vlionLossBiddingReason);
                return;
            }
            VlionBaseAdAdapterInterstitial vlionBaseAdAdapterInterstitial = this.f3843d;
            if (vlionBaseAdAdapterInterstitial != null) {
                vlionBaseAdAdapterInterstitial.notifyFailPrice(vlionLossBiddingReason);
                return;
            }
            s sVar = this.f3841b;
            if (sVar != null) {
                sVar.notifyFailPrice(vlionLossBiddingReason);
                return;
            }
            p pVar = this.f3844e;
            if (pVar != null) {
                pVar.notifyFailPrice(vlionLossBiddingReason);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void notifyWinPrice(boolean z10) {
        try {
            VlionBaseAdAdapterBanner vlionBaseAdAdapterBanner = this.f3840a;
            if (vlionBaseAdAdapterBanner != null) {
                vlionBaseAdAdapterBanner.renderAD();
                return;
            }
            VlionBaseAdAdapterInterstitial vlionBaseAdAdapterInterstitial = this.f3843d;
            if (vlionBaseAdAdapterInterstitial != null) {
                vlionBaseAdAdapterInterstitial.renderAD();
                return;
            }
            s sVar = this.f3841b;
            if (sVar != null) {
                sVar.renderAD();
                return;
            }
            p pVar = this.f3844e;
            if (pVar != null) {
                pVar.renderRewardVideoAD();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void setVlionBiddingActionListener(VlionBiddingActionListener vlionBiddingActionListener) {
        super.setVlionBiddingActionListener(vlionBiddingActionListener);
        try {
            VlionBaseAdAdapterBanner vlionBaseAdAdapterBanner = this.f3840a;
            if (vlionBaseAdAdapterBanner != null) {
                vlionBaseAdAdapterBanner.setVlionBiddingActionListener(vlionBiddingActionListener);
                return;
            }
            s sVar = this.f3841b;
            if (sVar != null) {
                sVar.setVlionBiddingActionListener(vlionBiddingActionListener);
                return;
            }
            VlionBaseAdAdapterInterstitial vlionBaseAdAdapterInterstitial = this.f3843d;
            if (vlionBaseAdAdapterInterstitial != null) {
                vlionBaseAdAdapterInterstitial.setVlionBiddingActionListener(vlionBiddingActionListener);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void setVlionBiddingActionRewardListener(VlionBiddingActionRewardListener vlionBiddingActionRewardListener) {
        super.setVlionBiddingActionRewardListener(vlionBiddingActionRewardListener);
        try {
            p pVar = this.f3844e;
            if (pVar != null) {
                pVar.setVlionBiddingActionRewardListener(vlionBiddingActionRewardListener);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void setVlionNativeActionListener(VlionNativeActionListener vlionNativeActionListener) {
        super.setVlionNativeActionListener(vlionNativeActionListener);
        try {
            VlionBaseAdAdapterNative vlionBaseAdAdapterNative = this.f3842c;
            if (vlionBaseAdAdapterNative != null) {
                vlionBaseAdAdapterNative.setVlionNativeActionListener(vlionNativeActionListener);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void showInterstitialAD(Activity activity) {
        try {
            VlionBaseAdAdapterInterstitial vlionBaseAdAdapterInterstitial = this.f3843d;
            if (vlionBaseAdAdapterInterstitial != null) {
                vlionBaseAdAdapterInterstitial.showAd(activity);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void showRewardVideoAD(Activity activity) {
        try {
            p pVar = this.f3844e;
            if (pVar != null) {
                pVar.showRewardVideoAd(activity);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void showSplashAD(ViewGroup viewGroup) {
        try {
            s sVar = this.f3841b;
            if (sVar != null) {
                sVar.showAd(viewGroup);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static String a(VideoDataRef videoDataRef) {
        StringBuilder sb2 = new StringBuilder();
        if (videoDataRef == null) {
            return "";
        }
        try {
            if (videoDataRef.getDuration() > 0) {
                sb2.append("duration:" + videoDataRef.getDuration() + "\n");
            }
            if (videoDataRef.getWidth() > 0) {
                sb2.append("width:" + videoDataRef.getWidth() + "\n");
            }
            if (videoDataRef.getHeight() > 0) {
                sb2.append("height:" + videoDataRef.getHeight() + "\n");
            }
            if (!TextUtils.isEmpty(videoDataRef.getAdSourceMark())) {
                sb2.append("mark:" + videoDataRef.getAdSourceMark() + "\n");
            }
            if (!TextUtils.isEmpty(videoDataRef.getImgUrl())) {
                sb2.append("img:" + videoDataRef.getImgUrl() + "\n");
            }
            if (!TextUtils.isEmpty(videoDataRef.getIconUrl())) {
                sb2.append("icon:" + videoDataRef.getIconUrl() + "\n");
            }
            if (!TextUtils.isEmpty(videoDataRef.getTitle())) {
                sb2.append("title:" + videoDataRef.getTitle() + "\n");
            }
            if (!TextUtils.isEmpty(videoDataRef.getDesc())) {
                sb2.append("desc:" + videoDataRef.getDesc() + "\n");
            }
            if (!TextUtils.isEmpty(videoDataRef.getContent())) {
                sb2.append("content:" + videoDataRef.getContent() + "\n");
            }
            if (!TextUtils.isEmpty(videoDataRef.getBrand())) {
                sb2.append("brand:" + videoDataRef.getBrand() + "\n");
            }
            if (!TextUtils.isEmpty(videoDataRef.getCtatext())) {
                sb2.append("ctatext:" + videoDataRef.getCtatext() + "\n");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return sb2.toString();
    }

    public static void a(ImageView imageView, String str) {
        try {
            HttpRequestUtil.downloadBitmapNeedCache(imageView, str, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static boolean a(VlionAdapterADConfig vlionAdapterADConfig) {
        if (vlionAdapterADConfig != null) {
            try {
                ArrayList<String> splitString = VlionCustomSpitUtils.getSplitString(vlionAdapterADConfig.getCreativeType());
                if (splitString.size() > 0) {
                    for (int i10 = 0; i10 < splitString.size(); i10++) {
                        if ("2".equals(splitString.get(i10))) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        return false;
    }
}
