package com.aggmoread.sdk.client;

import android.content.Context;
import com.aggmoread.sdk.b.a;
import com.aggmoread.sdk.client.banner.AMBannerAdInteractionListener;
import com.aggmoread.sdk.client.banner.AMBannerAdListener;
import com.aggmoread.sdk.client.draw.AMDrawAdInteractionListener;
import com.aggmoread.sdk.client.draw.AMDrawAdListener;
import com.aggmoread.sdk.client.feedlist.AMExpressAdListener;
import com.aggmoread.sdk.client.feedlist.AMMixFeedAdListener;
import com.aggmoread.sdk.client.feedlist.AMNativeAdListener;
import com.aggmoread.sdk.client.fullscreen.AMFullScreenAdInteractionListener;
import com.aggmoread.sdk.client.fullscreen.AMFullScreenAdListener;
import com.aggmoread.sdk.client.interstitial.AMInterstitialAdInteractionListener;
import com.aggmoread.sdk.client.interstitial.AMInterstitialAdListener;
import com.aggmoread.sdk.client.reward.AMRewardAdListener;
import com.aggmoread.sdk.client.reward.AMRewardInteractionListener;
import com.aggmoread.sdk.client.splash.AMSplashAdListener;
import com.aggmoread.sdk.client.splash.AMSplashInteractionListener;

/* loaded from: classes.dex */
public final class AMAdLoader {
    private AMAdLoadSlot adLoadSlot;
    private IAdLoader loaderImpl;

    public interface IAdLoader {
        void loadAd(Context context, AMAdType aMAdType, AMAdLoadSlot aMAdLoadSlot, IAMAdLoadListener iAMAdLoadListener);

        void loadAndShowAd(Context context, AMAdType aMAdType, AMAdLoadSlot aMAdLoadSlot, IAMAdLoadListener iAMAdLoadListener, IAMAdInteractionListener iAMAdInteractionListener);
    }

    public AMAdLoader(AMAdLoadSlot aMAdLoadSlot) {
        this.adLoadSlot = aMAdLoadSlot;
        Object a10 = a.a();
        if (a10 instanceof IAdLoader) {
            this.loaderImpl = (IAdLoader) a10;
        }
    }

    private void loadAd(Context context, AMAdType aMAdType, IAMAdLoadListener<?> iAMAdLoadListener) {
        this.loaderImpl.loadAd(context, aMAdType, this.adLoadSlot, iAMAdLoadListener);
    }

    private void loadAndShowAd(Context context, AMAdType aMAdType, IAMAdLoadListener<?> iAMAdLoadListener, IAMAdInteractionListener iAMAdInteractionListener) {
        this.loaderImpl.loadAndShowAd(context, aMAdType, this.adLoadSlot, iAMAdLoadListener, iAMAdInteractionListener);
    }

    public void loadAnShowRewardAd(Context context, AMRewardAdListener aMRewardAdListener, AMRewardInteractionListener aMRewardInteractionListener) {
        loadAndShowAd(context, AMAdType.REWARD, aMRewardAdListener, aMRewardInteractionListener);
    }

    public void loadAndShowBannerAd(Context context, AMBannerAdListener aMBannerAdListener, AMBannerAdInteractionListener aMBannerAdInteractionListener) {
        loadAndShowAd(context, AMAdType.BANNER, aMBannerAdListener, aMBannerAdInteractionListener);
    }

    public void loadAndShowDrawAd(Context context, AMDrawAdListener aMDrawAdListener, AMDrawAdInteractionListener aMDrawAdInteractionListener) {
        loadAndShowAd(context, AMAdType.DRAW, aMDrawAdListener, aMDrawAdInteractionListener);
    }

    public void loadAndShowFullScreenAd(Context context, AMFullScreenAdListener aMFullScreenAdListener, AMFullScreenAdInteractionListener aMFullScreenAdInteractionListener) {
        loadAndShowAd(context, AMAdType.FULLSCREEN, aMFullScreenAdListener, aMFullScreenAdInteractionListener);
    }

    public void loadAndShowInterstitialAd(Context context, AMInterstitialAdListener aMInterstitialAdListener, AMInterstitialAdInteractionListener aMInterstitialAdInteractionListener) {
        loadAndShowAd(context, AMAdType.INTERSTITIAL, aMInterstitialAdListener, aMInterstitialAdInteractionListener);
    }

    public void loadAndShowSplashAd(Context context, AMSplashAdListener aMSplashAdListener, AMSplashInteractionListener aMSplashInteractionListener) {
        loadAndShowAd(context, AMAdType.SPLASH, aMSplashAdListener, aMSplashInteractionListener);
    }

    public void loadBannerAd(Context context, AMBannerAdListener aMBannerAdListener) {
        loadAd(context, AMAdType.BANNER, aMBannerAdListener);
    }

    public void loadDrawAd(Context context, AMDrawAdListener aMDrawAdListener) {
        loadAd(context, AMAdType.DRAW, aMDrawAdListener);
    }

    public void loadExpressAd(Context context, AMExpressAdListener aMExpressAdListener) {
        loadAd(context, AMAdType.EXPRESS_INFORMATION_FLOW, aMExpressAdListener);
    }

    public void loadFullScreenAd(Context context, AMFullScreenAdListener aMFullScreenAdListener) {
        loadAd(context, AMAdType.FULLSCREEN, aMFullScreenAdListener);
    }

    public void loadInterstitialAd(Context context, AMInterstitialAdListener aMInterstitialAdListener) {
        loadAd(context, AMAdType.INTERSTITIAL, aMInterstitialAdListener);
    }

    public void loadMixFeedAd(Context context, AMMixFeedAdListener aMMixFeedAdListener) {
        loadAd(context, AMAdType.MIX_INFORMATION_FLOW, aMMixFeedAdListener);
    }

    public void loadNativeAd(Context context, AMNativeAdListener aMNativeAdListener) {
        loadAd(context, AMAdType.INFORMATION_FLOW, aMNativeAdListener);
    }

    public void loadRewardAd(Context context, AMRewardAdListener aMRewardAdListener) {
        loadAd(context, AMAdType.REWARD, aMRewardAdListener);
    }

    public void loadSplashAd(Context context, AMSplashAdListener aMSplashAdListener) {
        loadAd(context, AMAdType.SPLASH, aMSplashAdListener);
    }
}
