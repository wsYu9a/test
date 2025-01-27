package cn.vlion.ad.inland.ku;

import android.content.Context;
import android.view.View;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterFeed;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.List;

/* loaded from: classes.dex */
public final class c extends VlionBaseAdAdapterFeed {

    /* renamed from: a */
    public KsScene f3980a;

    /* renamed from: b */
    public KsFeedAd f3981b;

    public class a implements KsLoadManager.FeedAdListener {
        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public final void onError(int i10, String str) {
            try {
                LogVlion.e("VlionKuFeed onError i= " + i10 + " s=" + str);
                VlionBiddingLoadListener vlionBiddingLoadListener = c.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(-1, str);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public final void onFeedAdLoad(List<KsFeedAd> list) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        c.this.f3981b = list.get(0);
                        c cVar = c.this;
                        cVar.price = cVar.getPrice();
                        LogVlion.e("VlionKuFeed onLoadSuccess price=" + c.this.price);
                        if (c.this.f3981b != null) {
                            KsFeedAd ksFeedAd = c.this.f3981b;
                            c cVar2 = c.this;
                            ksFeedAd.setBidEcpm(cVar2.price, cVar2.secondPrice);
                        }
                        VlionBiddingLoadListener vlionBiddingLoadListener = c.this.vlionBiddingLoadListener;
                        if (vlionBiddingLoadListener != null) {
                            vlionBiddingLoadListener.onAdLoadSuccess(r6.price);
                            return;
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            }
            VlionBiddingLoadListener vlionBiddingLoadListener2 = c.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener2 != null) {
                vlionBiddingLoadListener2.onAdLoadFailure(-1, "没有广告填充");
            }
        }
    }

    public class b implements KsFeedAd.AdInteractionListener {
        public b() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public final void onAdClicked() {
            try {
                LogVlion.e("VlionKuFeed onClick");
                VlionBiddingActionListener vlionBiddingActionListener = c.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public final void onAdShow() {
            try {
                LogVlion.e("VlionKuFeed onExposure");
                VlionBiddingActionListener vlionBiddingActionListener = c.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public final void onDislikeClicked() {
            try {
                LogVlion.e("VlionKuFeed onClose");
                VlionBiddingActionListener vlionBiddingActionListener = c.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public final void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public final void onDownloadTipsDialogShow() {
        }
    }

    /* renamed from: cn.vlion.ad.inland.ku.c$c */
    public class C0042c implements KsFeedAd.AdRenderListener {
        public C0042c() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
        public final void onAdRenderFailed(int i10, String str) {
            try {
                VlionBiddingActionListener vlionBiddingActionListener = c.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdRenderFailure(i10, str);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
        public final void onAdRenderSuccess(View view) {
            try {
                VlionBiddingActionListener vlionBiddingActionListener = c.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdRenderSuccess(view);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public c(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        long j10;
        try {
            LogVlion.e("VlionKuFeed:getSlotID=" + this.slotID + " width=" + this.widthPx + " height=" + this.heightPx);
            try {
                j10 = Long.parseLong(this.slotID);
            } catch (Exception e10) {
                LogVlion.e("VlionKuFeed Exception :" + e10.getMessage());
                j10 = 0;
            }
            this.f3980a = new KsScene.Builder(j10).width((int) this.widthPx).adNum(1).build();
            LogVlion.e("VlionKuFeed:");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterFeed
    public final void destroy() {
        try {
            if (this.f3981b != null) {
                this.f3981b = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterFeed
    public final int getPrice() {
        int i10 = -1;
        try {
            KsFeedAd ksFeedAd = this.f3981b;
            if (ksFeedAd == null) {
                return -1;
            }
            i10 = ksFeedAd.getECPM();
            LogVlion.e("VlionKuFeed getPrice " + i10);
            return i10;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return i10;
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void loadAd() {
        super.loadAd();
        LogVlion.e("VlionKuFeed  loadAd:");
        try {
            KsAdSDK.getLoadManager().loadConfigFeedAd(this.f3980a, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterFeed
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        try {
            if (this.f3981b == null || vlionLossBiddingReason == null) {
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
            this.f3981b.reportAdExposureFailed(2, adExposureFailedReason);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void renderAD() {
        super.renderAD();
        try {
            LogVlion.e("VlionKuFeed renderAD");
            KsFeedAd ksFeedAd = this.f3981b;
            if (ksFeedAd != null) {
                ksFeedAd.setAdInteractionListener(new b());
                this.f3981b.setVideoPlayConfig(new KsAdVideoPlayConfig.Builder().dataFlowAutoStart(false).videoAutoPlayType(1).build());
                this.f3981b.setBidEcpm(getPrice(), 0L);
                this.f3981b.render(new C0042c());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
