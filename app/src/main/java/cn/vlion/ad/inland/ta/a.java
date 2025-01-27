package cn.vlion.ad.inland.ta;

import android.content.Context;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterFeed;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.DensityUtil;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd;
import com.alimm.tanx.core.ad.bean.TanxBiddingInfo;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.ui.TanxSdk;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class a extends VlionBaseAdAdapterFeed {

    /* renamed from: a */
    public ITanxAdLoader f4021a;

    /* renamed from: b */
    public ITanxFeedExpressAd f4022b;

    /* renamed from: c */
    public TanxAdSlot f4023c;

    /* renamed from: d */
    public ITanxFeedExpressAd f4024d;

    /* renamed from: cn.vlion.ad.inland.ta.a$a */
    public class C0046a implements ITanxAdLoader.OnAdLoadListener<ITanxFeedExpressAd> {
        public C0046a() {
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public final void onError(TanxError tanxError) {
            try {
                if (a.this.vlionBiddingLoadListener == null || tanxError == null) {
                    return;
                }
                LogVlion.e("VlionTaFeed onError=" + tanxError.getCode() + " " + tanxError.getMessage());
                a.this.vlionBiddingLoadListener.onAdLoadFailure(tanxError.getCode(), tanxError.getMessage());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener
        public final void onLoaded(List<ITanxFeedExpressAd> list) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        LogVlion.e("VlionTaFeed onLoaded adList=" + list.size());
                        long j10 = 0;
                        ITanxFeedExpressAd iTanxFeedExpressAd = null;
                        for (ITanxFeedExpressAd iTanxFeedExpressAd2 : list) {
                            if (iTanxFeedExpressAd2.getBidInfo().getBidPrice() >= j10) {
                                j10 = iTanxFeedExpressAd2.getBidInfo().getBidPrice();
                                iTanxFeedExpressAd = iTanxFeedExpressAd2;
                            }
                        }
                        a.this.f4022b = iTanxFeedExpressAd;
                        if (a.this.f4022b == null) {
                            VlionBiddingLoadListener vlionBiddingLoadListener = a.this.vlionBiddingLoadListener;
                            if (vlionBiddingLoadListener != null) {
                                VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_IS_EMPTY;
                                vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                                return;
                            }
                            return;
                        }
                        a aVar = a.this;
                        aVar.price = aVar.getPrice();
                        LogVlion.e("VlionTaFeed onLoaded ecpm=" + a.this.price);
                        VlionBiddingLoadListener vlionBiddingLoadListener2 = a.this.vlionBiddingLoadListener;
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
            VlionBiddingLoadListener vlionBiddingLoadListener3 = a.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener3 != null) {
                VlionAdBaseError vlionAdBaseError2 = VlionAdBaseError.OTHER_AD_IS_EMPTY;
                vlionBiddingLoadListener3.onAdLoadFailure(vlionAdBaseError2.getErrorCode(), vlionAdBaseError2.getErrorMessage());
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public final void onTimeOut() {
            try {
                LogVlion.e("VlionTaFeed onTimeOut=");
                VlionBiddingLoadListener vlionBiddingLoadListener = a.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(-1, "TimeOut");
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements ITanxRequestLoader.OnBiddingListener<ITanxFeedExpressAd> {
        public b() {
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener
        public final void onResult(List<ITanxFeedExpressAd> list) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        LogVlion.e("VlionTaFeed biddingResult list =" + list.size());
                        ITanxFeedExpressAd iTanxFeedExpressAd = list.get(0);
                        if (iTanxFeedExpressAd == null) {
                            LogVlion.e("VlionTaFeed SplashExpressAd is null=");
                            VlionBiddingActionListener vlionBiddingActionListener = a.this.vlionBiddingActionListener;
                            if (vlionBiddingActionListener != null) {
                                vlionBiddingActionListener.onAdRenderFailure(-1, "biddingResult SplashExpressAd is null");
                                return;
                            }
                            return;
                        }
                        a.this.f4024d = iTanxFeedExpressAd;
                        a.b(a.this);
                        VlionBiddingActionListener vlionBiddingActionListener2 = a.this.vlionBiddingActionListener;
                        if (vlionBiddingActionListener2 != null) {
                            vlionBiddingActionListener2.onAdRenderSuccess(iTanxFeedExpressAd.getAdView());
                            return;
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            }
            LogVlion.e("VlionTaFeed biddingResult list 为空=");
            VlionBiddingActionListener vlionBiddingActionListener3 = a.this.vlionBiddingActionListener;
            if (vlionBiddingActionListener3 != null) {
                vlionBiddingActionListener3.onAdRenderFailure(-1, "biddingResult list 为空");
            }
        }
    }

    public a(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        try {
            LogVlion.e("VlionTaFeed :" + this.slotID);
            this.f4023c = new TanxAdSlot.Builder().adCount(1).pid(this.slotID).setExpressViewAcceptedSize(DensityUtil.dip2px(context, this.widthPx)).build();
            this.f4021a = TanxSdk.getSDKManager().createAdLoader(context);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterFeed
    public final void destroy() {
        try {
            if (this.f4022b != null) {
                this.f4022b = null;
            }
            if (this.f4024d != null) {
                this.f4024d = null;
            }
            ITanxAdLoader iTanxAdLoader = this.f4021a;
            if (iTanxAdLoader != null) {
                iTanxAdLoader.destroy();
                this.f4021a = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterFeed
    public final int getPrice() {
        try {
            ITanxFeedExpressAd iTanxFeedExpressAd = this.f4022b;
            if (iTanxFeedExpressAd != null) {
                r0 = iTanxFeedExpressAd.getBidInfo() != null ? (int) this.f4022b.getBidInfo().getBidPrice() : -1;
                LogVlion.e("VlionTaFeed getPrice price=" + r0);
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
            LogVlion.e("VlionTaFeed loadAd");
            if (this.f4021a != null) {
                LogVlion.e("VlionTaFeed loadAd isBid=" + this.isBid + " bidFloorPric=" + this.bidFloorPrice);
                this.f4021a.loadFeedAd(this.f4023c, new C0046a());
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

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterFeed
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void renderAD() {
        ITanxFeedExpressAd iTanxFeedExpressAd;
        super.renderAD();
        try {
            LogVlion.e("VlionTaFeed renderAD");
            if (this.f4021a == null || (iTanxFeedExpressAd = this.f4022b) == null || iTanxFeedExpressAd.getBiddingInfo() == null) {
                VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_RENDER_ERROR;
                    vlionBiddingActionListener.onAdRenderFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            } else {
                LogVlion.e("VlionTaFeed renderAD bid=");
                TanxBiddingInfo biddingInfo = this.f4022b.getBiddingInfo();
                biddingInfo.setBidResult(true);
                this.f4022b.setBiddingResult(biddingInfo);
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f4022b);
                this.f4021a.biddingResult(arrayList, new b());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void b(a aVar) {
        ITanxFeedExpressAd iTanxFeedExpressAd = aVar.f4024d;
        if (iTanxFeedExpressAd != null) {
            iTanxFeedExpressAd.setOnFeedAdListener(new cn.vlion.ad.inland.ta.b(aVar));
        }
    }
}
