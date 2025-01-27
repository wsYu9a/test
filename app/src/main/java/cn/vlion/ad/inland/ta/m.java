package cn.vlion.ad.inland.ta;

import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd;
import com.alimm.tanx.core.request.TanxError;

/* loaded from: classes.dex */
public final class m implements ITanxSplashExpressAd.OnSplashAdListener {

    /* renamed from: a */
    public final /* synthetic */ n f4065a;

    public m(n nVar) {
        this.f4065a = nVar;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
    public final void onAdClicked() {
        try {
            LogVlion.e("VlionTaSplash onAdClicked");
            VlionBiddingActionListener vlionBiddingActionListener = this.f4065a.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdClick();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
    public final void onAdClosed() {
        try {
            LogVlion.e("VlionTaSplash onAdClosed");
            VlionBiddingActionListener vlionBiddingActionListener = this.f4065a.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdClose();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
    public final void onAdFinish() {
        try {
            LogVlion.e("VlionTaSplash onAdFinish");
            VlionBiddingActionListener vlionBiddingActionListener = this.f4065a.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdClose();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
    public final void onAdRender(ITanxSplashExpressAd iTanxSplashExpressAd) {
        LogVlion.e("VlionTaSplash onAdRender:");
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
    public final void onAdShake() {
        try {
            LogVlion.e("VlionTaSplash onAdShake");
            VlionBiddingActionListener vlionBiddingActionListener = this.f4065a.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdClick();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
    public final void onAdShow() {
        try {
            LogVlion.e("VlionTaSplash onAdShow");
            VlionBiddingActionListener vlionBiddingActionListener = this.f4065a.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdExposure();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
    public final void onShowError(TanxError tanxError) {
        int code;
        String message;
        if (tanxError != null) {
            try {
                code = tanxError.getCode();
                message = tanxError.getMessage();
                LogVlion.e("VlionTaSplash onRenderFailure:code=" + code + " error=" + message);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return;
            }
        } else {
            message = "";
            code = 0;
        }
        VlionBiddingActionListener vlionBiddingActionListener = this.f4065a.vlionBiddingActionListener;
        if (vlionBiddingActionListener != null) {
            vlionBiddingActionListener.onAdShowFailure(code, message);
        }
    }
}
