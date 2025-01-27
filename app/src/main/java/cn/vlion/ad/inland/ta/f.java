package cn.vlion.ad.inland.ta;

import android.app.Activity;
import android.content.Context;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd;
import com.alimm.tanx.core.ad.bean.TanxBiddingInfo;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.ui.TanxSdk;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends VlionBaseAdAdapterInterstitial {

    /* renamed from: a */
    public ITanxAdLoader f4031a;

    /* renamed from: b */
    public ITanxTableScreenExpressAd f4032b;

    /* renamed from: c */
    public TanxAdSlot f4033c;

    /* renamed from: d */
    public ITanxTableScreenExpressAd f4034d;

    public class a implements ITanxAdLoader.OnAdLoadListener<ITanxTableScreenExpressAd> {
        public a() {
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public final void onError(TanxError tanxError) {
            try {
                if (f.this.vlionBiddingLoadListener == null || tanxError == null) {
                    return;
                }
                LogVlion.e("VlionTaInterstitial onError=" + tanxError.getCode() + " " + tanxError.getMessage());
                f.this.vlionBiddingLoadListener.onAdLoadFailure(tanxError.getCode(), tanxError.getMessage());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener
        public final void onLoaded(List<ITanxTableScreenExpressAd> list) {
            try {
                LogVlion.e("VlionTaInterstitial onLoaded:");
                if (list == null || list.size() <= 0) {
                    VlionBiddingLoadListener vlionBiddingLoadListener = f.this.vlionBiddingLoadListener;
                    if (vlionBiddingLoadListener != null) {
                        VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_IS_EMPTY;
                        vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                        return;
                    }
                    return;
                }
                LogVlion.e("VlionTaInterstitial onLoaded adList=" + list.size());
                ITanxTableScreenExpressAd iTanxTableScreenExpressAd = null;
                for (ITanxTableScreenExpressAd iTanxTableScreenExpressAd2 : list) {
                    if (iTanxTableScreenExpressAd2.getBidInfo().getBidPrice() >= 0) {
                        iTanxTableScreenExpressAd = iTanxTableScreenExpressAd2;
                    }
                }
                f.this.f4032b = iTanxTableScreenExpressAd;
                if (f.this.f4032b == null) {
                    VlionBiddingLoadListener vlionBiddingLoadListener2 = f.this.vlionBiddingLoadListener;
                    if (vlionBiddingLoadListener2 != null) {
                        VlionAdBaseError vlionAdBaseError2 = VlionAdBaseError.OTHER_AD_IS_EMPTY;
                        vlionBiddingLoadListener2.onAdLoadFailure(vlionAdBaseError2.getErrorCode(), vlionAdBaseError2.getErrorMessage());
                        return;
                    }
                    return;
                }
                f fVar = f.this;
                fVar.price = fVar.getPrice();
                LogVlion.e("VlionTaInterstitial onLoaded ecpm=" + f.this.price);
                VlionBiddingLoadListener vlionBiddingLoadListener3 = f.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener3 != null) {
                    vlionBiddingLoadListener3.onAdLoadSuccess(r8.price);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public final void onTimeOut() {
            try {
                LogVlion.e("VlionTaInterstitial onTimeOut=");
                VlionBiddingLoadListener vlionBiddingLoadListener = f.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(-1, "TimeOut");
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements ITanxRequestLoader.OnBiddingListener<ITanxTableScreenExpressAd> {

        /* renamed from: a */
        public final /* synthetic */ List f4036a;

        public b(ArrayList arrayList) {
            this.f4036a = arrayList;
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener
        public final void onResult(List<ITanxTableScreenExpressAd> list) {
            try {
                LogVlion.e("VlionTaInterstitial biddingResult onResult");
                if (this.f4036a.size() == 0) {
                    LogVlion.e("VlionTaInterstitial biddingResult adList 为空=");
                    VlionBiddingActionListener vlionBiddingActionListener = f.this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdRenderFailure(-1, "biddingResult adList 为空");
                        return;
                    }
                    return;
                }
                long j10 = 0;
                ITanxTableScreenExpressAd iTanxTableScreenExpressAd = null;
                for (ITanxTableScreenExpressAd iTanxTableScreenExpressAd2 : this.f4036a) {
                    if (iTanxTableScreenExpressAd2.getBidInfo().getBidPrice() >= j10) {
                        j10 = iTanxTableScreenExpressAd2.getBidInfo().getBidPrice();
                        iTanxTableScreenExpressAd = iTanxTableScreenExpressAd2;
                    }
                }
                if (iTanxTableScreenExpressAd == null) {
                    VlionBiddingActionListener vlionBiddingActionListener2 = f.this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener2 != null) {
                        vlionBiddingActionListener2.onAdRenderFailure(-1, "biddingResult SplashExpressAd is null");
                        return;
                    }
                    return;
                }
                f.this.f4034d = iTanxTableScreenExpressAd;
                f.b(f.this);
                VlionBiddingActionListener vlionBiddingActionListener3 = f.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener3 != null) {
                    vlionBiddingActionListener3.onAdRenderSuccess(null);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public f(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        try {
            LogVlion.e("VlionTaInterstitial :");
            this.f4033c = new TanxAdSlot.Builder().adCount(1).pid(this.slotID).build();
            this.f4031a = TanxSdk.getSDKManager().createAdLoader(context);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final void destroy() {
        try {
            if (this.f4032b != null) {
                this.f4032b = null;
            }
            if (this.f4034d != null) {
                this.f4034d = null;
            }
            ITanxAdLoader iTanxAdLoader = this.f4031a;
            if (iTanxAdLoader != null) {
                iTanxAdLoader.destroy();
                this.f4031a = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final int getPrice() {
        try {
            ITanxTableScreenExpressAd iTanxTableScreenExpressAd = this.f4032b;
            if (iTanxTableScreenExpressAd != null) {
                r0 = iTanxTableScreenExpressAd.getBidInfo() != null ? (int) this.f4032b.getBidInfo().getBidPrice() : -1;
                LogVlion.e("VlionTaInterstitial getPrice price=" + r0);
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
            LogVlion.e("VlionTaInterstitial loadAd");
            if (this.f4031a != null) {
                LogVlion.e("VlionTaInterstitial loadAd isBid=" + this.isBid + " bidFloorPric=" + this.bidFloorPrice);
                this.f4031a.loadTableScreenAd(this.f4033c, new a());
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

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void renderAD() {
        ITanxTableScreenExpressAd iTanxTableScreenExpressAd;
        super.renderAD();
        try {
            LogVlion.e("VlionTaInterstitial renderAD isHaveLoadStatus=" + isHaveLoadStatus() + " isLoadStatusError=" + isLoadStatusError() + " price=" + this.price);
            if (this.f4031a == null || (iTanxTableScreenExpressAd = this.f4032b) == null || iTanxTableScreenExpressAd.getBiddingInfo() == null) {
                VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_RENDER_ERROR;
                    vlionBiddingActionListener.onAdRenderFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            } else {
                LogVlion.e("VlionTaInterstitial renderAD bid=");
                TanxBiddingInfo biddingInfo = this.f4032b.getBiddingInfo();
                biddingInfo.setBidResult(true);
                biddingInfo.setWinPrice(getPrice());
                this.f4032b.setBiddingResult(biddingInfo);
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f4032b);
                LogVlion.e("VlionTaInterstitial biddingResult adList " + arrayList.size());
                this.f4031a.biddingResult(arrayList, new b(arrayList));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final void showAd(Activity activity) {
        try {
            LogVlion.e("VlionTaInterstitial showAd");
            if (this.f4034d != null) {
                LogVlion.e("VlionTaInterstitial showAd adView price=" + this.price + " isBid=" + this.isBid);
                this.f4034d.showAd(activity);
            } else {
                VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_SHOW_ERROR;
                    vlionBiddingActionListener.onAdShowFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void b(f fVar) {
        fVar.getClass();
        try {
            if (fVar.f4034d != null) {
                LogVlion.e("VlionTaInterstitial setListener");
                fVar.f4034d.setOnTableScreenAdListener(new e(fVar));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
