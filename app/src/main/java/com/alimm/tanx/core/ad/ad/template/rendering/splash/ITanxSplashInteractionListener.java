package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;

/* loaded from: classes.dex */
public interface ITanxSplashInteractionListener extends ITanxInteractionListener<ITanxSplashAd> {

    public interface ITanxAppInteraction {
        void onAdClick();

        void onAdError(int i10, String str);

        void onAdFinish();

        void onAdInteractionClick();

        void onAdInteractionEnd();

        void onAdInteractionStart();

        void onAdSkip();
    }

    void onAdClose();

    void onAdShake();

    void onInteraction(ITanxAppInteraction iTanxAppInteraction);
}
