package cn.vlion.ad.inland.ku;

import android.content.Context;
import android.view.View;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterDraw;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.List;

/* loaded from: classes.dex */
public final class b extends VlionBaseAdAdapterDraw {

    /* renamed from: a */
    public KsScene f3976a;

    /* renamed from: b */
    public KsDrawAd f3977b;

    public class a implements KsLoadManager.DrawAdListener {

        /* renamed from: cn.vlion.ad.inland.ku.b$a$a */
        public class C0041a implements KsDrawAd.AdInteractionListener {
            public C0041a() {
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onAdClicked() {
                try {
                    LogVlion.e("VlionKuDraw onClick");
                    VlionBiddingActionListener vlionBiddingActionListener = b.this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdClick();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onAdShow() {
                try {
                    LogVlion.e("VlionKuDraw onExposure");
                    VlionBiddingActionListener vlionBiddingActionListener = b.this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdExposure();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onVideoPlayEnd() {
                try {
                    LogVlion.e("VlionKuDraw onVideoPlayEnd");
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = b.this.vlionNativesAdVideoListener;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onVideoAdComplete();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onVideoPlayError() {
                try {
                    LogVlion.e("VlionKuDraw onVideoPlayError");
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = b.this.vlionNativesAdVideoListener;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onAdVideoPlayError("KuDraw player error");
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onVideoPlayPause() {
                try {
                    LogVlion.e("VlionKuDraw onVideoPlayPause");
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = b.this.vlionNativesAdVideoListener;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onVideoAdPaused();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onVideoPlayResume() {
                try {
                    LogVlion.e("VlionKuDraw onVideoPlayResume");
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = b.this.vlionNativesAdVideoListener;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onVideoAdContinuePlay();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public final void onVideoPlayStart() {
                try {
                    LogVlion.e("VlionKuDraw onVideoPlayStart");
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = b.this.vlionNativesAdVideoListener;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onVideoAdStartPlay();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public final void onDrawAdLoad(List<KsDrawAd> list) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        b.this.f3977b = list.get(0);
                        if (b.this.f3977b == null) {
                            return;
                        }
                        b bVar = b.this;
                        bVar.price = bVar.getPrice();
                        LogVlion.e("VlionKuDraw onLoadSuccess price=" + b.this.price);
                        VlionBiddingLoadListener vlionBiddingLoadListener = b.this.vlionBiddingLoadListener;
                        if (vlionBiddingLoadListener != null) {
                            vlionBiddingLoadListener.onAdLoadSuccess(r4.price);
                        }
                        b.this.f3977b.setAdInteractionListener(new C0041a());
                        return;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            }
            VlionBiddingLoadListener vlionBiddingLoadListener2 = b.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener2 != null) {
                vlionBiddingLoadListener2.onAdLoadFailure(-1, "kuDraw not fill");
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public final void onError(int i10, String str) {
            try {
                LogVlion.e("VlionKuDraw:广告数据请求失败" + i10 + str);
                VlionBiddingLoadListener vlionBiddingLoadListener = b.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(-1, str);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public b(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener, VlionNativesAdVideoListener vlionNativesAdVideoListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener, vlionNativesAdVideoListener);
        long j10;
        try {
            LogVlion.e("VlionKuDraw:getSlotID=" + this.slotID + " width=" + this.widthPx + " height=" + this.heightPx);
            try {
                j10 = Long.parseLong(this.slotID);
            } catch (Exception e10) {
                LogVlion.e("VlionKuDraw Exception :" + e10.getMessage());
                j10 = 0;
            }
            this.f3976a = new KsScene.Builder(j10).adNum(1).build();
            LogVlion.e("VlionKuDraw:");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterDraw
    public final void destroy() {
        try {
            if (this.f3977b != null) {
                this.f3977b = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterDraw
    public final int getPrice() {
        int i10 = -1;
        try {
            KsDrawAd ksDrawAd = this.f3977b;
            if (ksDrawAd == null) {
                return -1;
            }
            i10 = ksDrawAd.getECPM();
            LogVlion.e("VlionKuDraw getPrice " + i10);
            return i10;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return i10;
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void loadAd() {
        super.loadAd();
        try {
            LogVlion.e("VlionKuDraw  loadAd:");
            KsAdSDK.getLoadManager().loadDrawAd(this.f3976a, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterDraw
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        try {
            if (this.f3977b == null || vlionLossBiddingReason == null) {
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
            this.f3977b.reportAdExposureFailed(2, adExposureFailedReason);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void renderAD() {
        super.renderAD();
        try {
            LogVlion.e("VlionKuDraw renderAD");
            KsDrawAd ksDrawAd = this.f3977b;
            if (ksDrawAd != null) {
                View drawView = ksDrawAd.getDrawView(this.context);
                if (drawView != null) {
                    try {
                        LogVlion.e("VlionKuDraw onAdRenderSuccess");
                        VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                        if (vlionBiddingActionListener != null) {
                            vlionBiddingActionListener.onAdRenderSuccess(drawView);
                        }
                        KsDrawAd ksDrawAd2 = this.f3977b;
                        if (ksDrawAd2 != null) {
                            ksDrawAd2.setBidEcpm(this.price, this.secondPrice);
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    try {
                        LogVlion.e("VlionKuDraw onAdRenderFailure");
                        VlionBiddingActionListener vlionBiddingActionListener2 = this.vlionBiddingActionListener;
                        if (vlionBiddingActionListener2 != null) {
                            vlionBiddingActionListener2.onAdRenderFailure(-1, "广告渲染失败");
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                VlionSDkManager.getInstance().upLoadCatchException(th);
            }
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }
}
