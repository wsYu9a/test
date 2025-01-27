package cn.vlion.ad.inland.ta;

import android.content.Context;
import android.view.ViewGroup;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd;
import com.alimm.tanx.core.ad.bean.TanxBiddingInfo;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdLoadType;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.ui.TanxSdk;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class n extends VlionBaseAdAdapterSplash {

    /* renamed from: a */
    public ITanxAdLoader f4066a;

    /* renamed from: b */
    public ITanxSplashExpressAd f4067b;

    /* renamed from: c */
    public TanxAdSlot f4068c;

    /* renamed from: d */
    public ITanxSplashExpressAd f4069d;

    public class a implements ITanxAdLoader.OnAdLoadListener<ITanxSplashExpressAd> {
        public a() {
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public final void onError(TanxError tanxError) {
            if (n.this.vlionBiddingLoadListener == null || tanxError == null) {
                return;
            }
            LogVlion.e("VlionTaSplash onError " + tanxError.getCode() + " " + tanxError.getMessage());
            n.this.vlionBiddingLoadListener.onAdLoadFailure(tanxError.getCode(), tanxError.getMessage());
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener
        public final void onLoaded(List<ITanxSplashExpressAd> list) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        LogVlion.e("VlionTaSplash onSplashAdLoadSuccess adList=" + list.size());
                        long j10 = 0;
                        ITanxSplashExpressAd iTanxSplashExpressAd = null;
                        for (ITanxSplashExpressAd iTanxSplashExpressAd2 : list) {
                            if (iTanxSplashExpressAd2.getBidInfo().getBidPrice() >= j10) {
                                j10 = iTanxSplashExpressAd2.getBidInfo().getBidPrice();
                                iTanxSplashExpressAd = iTanxSplashExpressAd2;
                            }
                        }
                        n.this.f4067b = iTanxSplashExpressAd;
                        if (n.this.f4067b == null) {
                            VlionBiddingLoadListener vlionBiddingLoadListener = n.this.vlionBiddingLoadListener;
                            if (vlionBiddingLoadListener != null) {
                                VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_IS_EMPTY;
                                vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                                return;
                            }
                            return;
                        }
                        n nVar = n.this;
                        nVar.price = nVar.getPrice();
                        LogVlion.e("VlionTaSplash onSplashAdLoadSuccess ecpm=" + n.this.price);
                        VlionBiddingLoadListener vlionBiddingLoadListener2 = n.this.vlionBiddingLoadListener;
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
            VlionBiddingLoadListener vlionBiddingLoadListener3 = n.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener3 != null) {
                VlionAdBaseError vlionAdBaseError2 = VlionAdBaseError.OTHER_AD_IS_EMPTY;
                vlionBiddingLoadListener3.onAdLoadFailure(vlionAdBaseError2.getErrorCode(), vlionAdBaseError2.getErrorMessage());
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public final void onTimeOut() {
            LogVlion.e("VlionTaSplash onTimeOut");
            VlionBiddingLoadListener vlionBiddingLoadListener = n.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadFailure(-1, "TimeOut");
            }
        }
    }

    public class b implements ITanxRequestLoader.OnBiddingListener<ITanxSplashExpressAd> {

        /* renamed from: a */
        public final /* synthetic */ List f4071a;

        public b(ArrayList arrayList) {
            this.f4071a = arrayList;
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener
        public final void onResult(List<ITanxSplashExpressAd> list) {
            try {
                LogVlion.e("VlionTaSplash biddingResult onResult");
                if (this.f4071a.size() == 0) {
                    LogVlion.e("VlionTaSplash biddingResult adList 为空=");
                    VlionBiddingActionListener vlionBiddingActionListener = n.this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdRenderFailure(-1, "biddingResult adList 为空");
                        return;
                    }
                    return;
                }
                ITanxSplashExpressAd iTanxSplashExpressAd = (ITanxSplashExpressAd) this.f4071a.get(0);
                if (iTanxSplashExpressAd == null) {
                    VlionBiddingActionListener vlionBiddingActionListener2 = n.this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener2 != null) {
                        vlionBiddingActionListener2.onAdRenderFailure(-1, "biddingResult SplashExpressAd is null");
                        return;
                    }
                    return;
                }
                n.this.f4069d = iTanxSplashExpressAd;
                n.b(n.this);
                VlionBiddingActionListener vlionBiddingActionListener3 = n.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener3 != null) {
                    vlionBiddingActionListener3.onAdRenderSuccess(null);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class c implements ITanxRequestLoader.OnBiddingListener<ITanxSplashExpressAd> {
        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener
        public final void onResult(List<ITanxSplashExpressAd> list) {
        }
    }

    public n(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        try {
            LogVlion.e("VlionTaSplash getSlotID:" + this.slotID + " widthPx=" + this.widthPx + " heightPx" + this.heightPx);
            this.f4068c = new TanxAdSlot.Builder().adCount(1).pid(this.slotID).setFeedBackDialog(false).setLoadType(TanxAdLoadType.PRELOAD).build();
            this.f4066a = TanxSdk.getSDKManager().createAdLoader(context);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final void destroy() {
        try {
            if (this.f4067b != null) {
                this.f4067b = null;
            }
            if (this.f4069d != null) {
                this.f4069d = null;
            }
            ITanxAdLoader iTanxAdLoader = this.f4066a;
            if (iTanxAdLoader != null) {
                iTanxAdLoader.destroy();
                this.f4066a = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final int getPrice() {
        try {
            ITanxSplashExpressAd iTanxSplashExpressAd = this.f4067b;
            if (iTanxSplashExpressAd != null) {
                r0 = iTanxSplashExpressAd.getBidInfo() != null ? (int) this.f4067b.getBidInfo().getBidPrice() : -1;
                LogVlion.e("VlionTaSplash getPrice price=" + r0);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return r0;
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void loadAd() {
        super.loadAd();
        try {
            LogVlion.e("VlionTaSplash loadAd");
            if (this.f4066a != null) {
                LogVlion.e("VlionTaSplash loadAd bidFloorPrice=" + this.bidFloorPrice);
                this.f4066a.loadSplashAd(this.f4068c, new a(), 5000L);
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

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        ITanxSplashExpressAd iTanxSplashExpressAd;
        try {
            if (this.f4066a == null || (iTanxSplashExpressAd = this.f4067b) == null || iTanxSplashExpressAd.getBiddingInfo() == null || vlionLossBiddingReason == null) {
                return;
            }
            LogVlion.e("VlionTaSplash renderAD bid=");
            TanxBiddingInfo biddingInfo = this.f4067b.getBiddingInfo();
            biddingInfo.setBidResult(false);
            biddingInfo.setWinPrice(vlionLossBiddingReason.getBiddingPrice());
            this.f4067b.setBiddingResult(biddingInfo);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f4067b);
            this.f4066a.biddingResult(arrayList, new c());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void renderAD() {
        ITanxSplashExpressAd iTanxSplashExpressAd;
        try {
            LogVlion.e("VlionTaSplash renderAD price=" + this.price + " isBid=" + this.isBid);
            if (this.f4066a == null || (iTanxSplashExpressAd = this.f4067b) == null || iTanxSplashExpressAd.getBiddingInfo() == null) {
                VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_RENDER_ERROR;
                    vlionBiddingActionListener.onAdRenderFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            } else {
                LogVlion.e("VlionTaSplash renderAD bid=");
                TanxBiddingInfo biddingInfo = this.f4067b.getBiddingInfo();
                biddingInfo.setBidResult(true);
                biddingInfo.setWinPrice(getPrice());
                this.f4067b.setBiddingResult(biddingInfo);
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f4067b);
                this.f4066a.biddingResult(arrayList, new b(arrayList));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final void showAd(ViewGroup viewGroup) {
        ITanxSplashExpressAd iTanxSplashExpressAd;
        try {
            LogVlion.e("VlionTaSplash showAd");
            if (viewGroup == null || (iTanxSplashExpressAd = this.f4069d) == null || iTanxSplashExpressAd.getAdView() == null) {
                VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_SHOW_ERROR;
                    vlionBiddingActionListener.onAdShowFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            } else {
                LogVlion.e("VlionTaSplash showAd adView isBid=" + this.isBid);
                viewGroup.addView(this.f4069d.getAdView(), new ViewGroup.LayoutParams(-1, -1));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void b(n nVar) {
        nVar.f4069d.setOnSplashAdListener(new m(nVar));
    }
}
