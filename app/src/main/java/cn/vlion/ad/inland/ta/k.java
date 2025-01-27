package cn.vlion.ad.inland.ta;

import android.app.Activity;
import android.content.Context;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.md5.MD5Utils;
import com.alimm.tanx.core.ad.ad.reward.model.VideoParam;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd;
import com.alimm.tanx.core.ad.bean.TanxBiddingInfo;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.ui.TanxSdk;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class k extends VlionBaseAdapterVideoAdLoad {

    /* renamed from: a */
    public ITanxAdLoader f4054a;

    /* renamed from: b */
    public ITanxRewardExpressAd f4055b;

    /* renamed from: c */
    public TanxAdSlot f4056c;

    /* renamed from: d */
    public ITanxRewardExpressAd f4057d;

    public class a implements ITanxAdLoader.OnRewardAdLoadListener<ITanxRewardExpressAd> {
        public a() {
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public final void onError(TanxError tanxError) {
            try {
                if (k.this.vlionBidindRewardVideoListener == null || tanxError == null) {
                    return;
                }
                LogVlion.e("VlionTaRewardVideo onError=" + tanxError.getCode() + " " + tanxError.getMessage());
                k.this.vlionBidindRewardVideoListener.onAdLoadFailure(tanxError.getCode(), tanxError.getMessage());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener
        public final void onLoaded(List<ITanxRewardExpressAd> list) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        LogVlion.e("VlionTaRewardVideo onLoaded adList=" + list.size());
                        ITanxRewardExpressAd iTanxRewardExpressAd = null;
                        for (ITanxRewardExpressAd iTanxRewardExpressAd2 : list) {
                            if (iTanxRewardExpressAd2.getBidInfo().getBidPrice() >= 0) {
                                iTanxRewardExpressAd = iTanxRewardExpressAd2;
                            }
                        }
                        k.this.f4055b = iTanxRewardExpressAd;
                        if (k.this.f4055b == null) {
                            VlionBiddingLoadListener vlionBiddingLoadListener = k.this.vlionBidindRewardVideoListener;
                            if (vlionBiddingLoadListener != null) {
                                VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_IS_EMPTY;
                                vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                                return;
                            }
                            return;
                        }
                        k kVar = k.this;
                        kVar.price = kVar.getPrice();
                        LogVlion.e("VlionTaRewardVideo onLoaded ecpm=" + k.this.price);
                        VlionBiddingLoadListener vlionBiddingLoadListener2 = k.this.vlionBidindRewardVideoListener;
                        if (vlionBiddingLoadListener2 != null) {
                            vlionBiddingLoadListener2.onAdLoadSuccess(r8.price);
                            return;
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            }
            VlionBiddingLoadListener vlionBiddingLoadListener3 = k.this.vlionBidindRewardVideoListener;
            if (vlionBiddingLoadListener3 != null) {
                VlionAdBaseError vlionAdBaseError2 = VlionAdBaseError.OTHER_AD_IS_EMPTY;
                vlionBiddingLoadListener3.onAdLoadFailure(vlionAdBaseError2.getErrorCode(), vlionAdBaseError2.getErrorMessage());
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener
        public final void onRewardVideoCached(ITanxRewardExpressAd iTanxRewardExpressAd) {
            VlionBiddingActionRewardListener vlionBiddingActionRewardListener;
            try {
                LogVlion.e("VlionTaRewardVideo onRewardVideoCached=");
                if (!k.this.isAdRenderSuccessCallback() || (vlionBiddingActionRewardListener = k.this.vlionBiddingActionRewardListener) == null) {
                    return;
                }
                vlionBiddingActionRewardListener.onAdRenderSuccess();
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public final void onTimeOut() {
            try {
                LogVlion.e("VlionTaRewardVideo onTimeOut=");
                VlionBiddingLoadListener vlionBiddingLoadListener = k.this.vlionBidindRewardVideoListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(-1, "TimeOut");
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements ITanxRequestLoader.OnBiddingListener<ITanxRewardExpressAd> {

        /* renamed from: a */
        public final /* synthetic */ List f4059a;

        public b(ArrayList arrayList) {
            this.f4059a = arrayList;
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener
        public final void onResult(List<ITanxRewardExpressAd> list) {
            VlionBiddingActionRewardListener vlionBiddingActionRewardListener;
            try {
                List list2 = this.f4059a;
                if (list2 != null && list2.size() != 0) {
                    long j10 = 0;
                    ITanxRewardExpressAd iTanxRewardExpressAd = null;
                    for (ITanxRewardExpressAd iTanxRewardExpressAd2 : this.f4059a) {
                        if (iTanxRewardExpressAd2.getBidInfo().getBidPrice() >= j10) {
                            j10 = iTanxRewardExpressAd2.getBidInfo().getBidPrice();
                            iTanxRewardExpressAd = iTanxRewardExpressAd2;
                        }
                    }
                    if (iTanxRewardExpressAd == null) {
                        VlionBiddingActionRewardListener vlionBiddingActionRewardListener2 = k.this.vlionBiddingActionRewardListener;
                        if (vlionBiddingActionRewardListener2 != null) {
                            vlionBiddingActionRewardListener2.onAdRenderFailure(-1, "biddingResult SplashExpressAd is null");
                            return;
                        }
                        return;
                    }
                    k.this.f4057d = iTanxRewardExpressAd;
                    k.b(k.this);
                    if (!k.this.isHaveLoadStatus() || (vlionBiddingActionRewardListener = k.this.vlionBiddingActionRewardListener) == null) {
                        return;
                    }
                    vlionBiddingActionRewardListener.onAdRenderSuccess();
                    return;
                }
                LogVlion.e("VlionTaRewardVideo biddingResult adList 为空=");
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener3 = k.this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener3 != null) {
                    vlionBiddingActionRewardListener3.onAdRenderFailure(-1, "biddingResult adList 为空");
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public k(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        try {
            LogVlion.e("VlionTaRewardVideo :");
            this.f4056c = new TanxAdSlot.Builder().pid(this.slotID).setMediaUid(MD5Utils.encode(VlionServiceConfigParse.getInstance().getUuid())).build();
            this.f4054a = TanxSdk.getSDKManager().createAdLoader(context);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final void destroy() {
        try {
            if (this.f4055b != null) {
                this.f4055b = null;
            }
            if (this.f4057d != null) {
                this.f4057d = null;
            }
            ITanxAdLoader iTanxAdLoader = this.f4054a;
            if (iTanxAdLoader != null) {
                iTanxAdLoader.destroy();
                this.f4054a = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final int getPrice() {
        try {
            ITanxRewardExpressAd iTanxRewardExpressAd = this.f4055b;
            if (iTanxRewardExpressAd != null) {
                r0 = iTanxRewardExpressAd.getBidInfo() != null ? (int) this.f4055b.getBidInfo().getBidPrice() : -1;
                LogVlion.e("VlionTaRewardVideo getPrice price=" + r0);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return r0;
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final void loadRewardVideoAd() {
        super.loadRewardVideoAd();
        try {
            LogVlion.e("VlionTaRewardVideo loadRewardVideoAd");
            if (this.f4054a != null) {
                LogVlion.e("VlionTaRewardVideo loadRewardVideoAd isBid=" + this.isBid + " bidFloorPric=" + this.bidFloorPrice + " adSlot=" + this.f4056c);
                this.f4054a.loadRewardVideoAd(this.f4056c, new a());
            } else {
                VlionBiddingLoadListener vlionBiddingLoadListener = this.vlionBidindRewardVideoListener;
                if (vlionBiddingLoadListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_IS_DESTROY;
                    vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final void renderRewardVideoAD() {
        ITanxRewardExpressAd iTanxRewardExpressAd;
        super.renderRewardVideoAD();
        try {
            LogVlion.e("VlionTaRewardVideo renderAD isBid=" + this.isBid);
            if (this.f4054a == null || (iTanxRewardExpressAd = this.f4055b) == null || iTanxRewardExpressAd.getBiddingInfo() == null) {
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_RENDER_ERROR;
                    vlionBiddingActionRewardListener.onAdRenderFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            } else {
                LogVlion.e("VlionTaRewardVideo renderAD bid=");
                TanxBiddingInfo biddingInfo = this.f4055b.getBiddingInfo();
                biddingInfo.setBidResult(true);
                this.f4055b.setBiddingResult(biddingInfo);
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f4055b);
                this.f4054a.biddingResult(arrayList, new b(arrayList));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdapterVideoAdLoad
    public final void showRewardVideoAd(Activity activity) {
        try {
            LogVlion.e("VlionTaRewardVideo showRewardVideoAd");
            if (this.f4057d != null) {
                LogVlion.e("VlionTaRewardVideo showAd adView price=" + this.price + " isBid=" + this.isBid);
                VideoParam videoParam = new VideoParam();
                videoParam.mute = this.isClosedVolume;
                this.f4057d.showAd(activity, videoParam);
            } else {
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = this.vlionBiddingActionRewardListener;
                if (vlionBiddingActionRewardListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_SHOW_ERROR;
                    vlionBiddingActionRewardListener.onAdShowFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void b(k kVar) {
        kVar.f4057d.setOnRewardAdListener(new j(kVar));
    }
}
