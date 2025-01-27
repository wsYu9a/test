package cn.vlion.ad.inland.ta;

import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxError;

/* loaded from: classes.dex */
public final class e implements ITanxTableScreenExpressAd.OnTableScreenAdListener {

    /* renamed from: a */
    public final /* synthetic */ f f4030a;

    public e(f fVar) {
        this.f4030a = fVar;
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
    public final void onAdClicked(TanxAdView tanxAdView, ITanxAd iTanxAd) {
        try {
            LogVlion.e("VlionTaInterstitial onAdClicked:");
            VlionBiddingActionListener vlionBiddingActionListener = this.f4030a.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdClick();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd.OnTableScreenAdListener
    public final void onAdClose() {
        try {
            LogVlion.e("VlionTaInterstitial onAdClose:");
            VlionBiddingActionListener vlionBiddingActionListener = this.f4030a.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdClose();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd.OnTableScreenAdListener
    public final void onAdShake() {
        try {
            LogVlion.e("VlionTaInterstitial onAdShake:");
            VlionBiddingActionListener vlionBiddingActionListener = this.f4030a.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdClick();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
    public final void onAdShow(ITanxAd iTanxAd) {
        try {
            LogVlion.e("VlionTaInterstitial onAdShow:");
            VlionBiddingActionListener vlionBiddingActionListener = this.f4030a.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdExposure();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd.OnTableScreenAdListener
    public final void onError(TanxError tanxError) {
        int code;
        String message;
        if (tanxError != null) {
            try {
                code = tanxError.getCode();
                message = tanxError.getMessage();
                LogVlion.e("VlionTaInterstitial onError:code=" + code + " error=" + message);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return;
            }
        } else {
            message = "";
            code = -1;
        }
        LogVlion.e("VlionTaInterstitial onError:");
        VlionBiddingActionListener vlionBiddingActionListener = this.f4030a.vlionBiddingActionListener;
        if (vlionBiddingActionListener != null) {
            vlionBiddingActionListener.onAdShowFailure(code, message);
        }
    }
}
