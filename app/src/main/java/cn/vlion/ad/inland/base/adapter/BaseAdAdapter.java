package cn.vlion.ad.inland.base.adapter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.ViewGroup;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.bid.VlionNativeActionListener;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionAdapterInitConfig;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;

/* loaded from: classes.dex */
public abstract class BaseAdAdapter {
    public VlionBiddingActionListener vlionBiddingActionListener;
    public VlionBiddingActionRewardListener vlionBiddingActionRewardListener;
    public VlionBiddingLoadListener vlionBiddingListener;
    public VlionNativeActionListener vlionNativeActionListener;
    public VlionNativesAdVideoListener vlionNativesAdVideoListener;

    public abstract void destroy();

    public abstract String getNetworkName();

    public abstract void initialize(Application application, VlionAdapterInitConfig vlionAdapterInitConfig, VlionMediaInitCallback vlionMediaInitCallback);

    public abstract void loadBannerAD(Activity activity, VlionAdapterADConfig vlionAdapterADConfig);

    public abstract void loadDrawAD(Context context, VlionAdapterADConfig vlionAdapterADConfig);

    public abstract void loadFeedAD(Context context, VlionAdapterADConfig vlionAdapterADConfig);

    public abstract void loadInterstitialAD(Activity activity, VlionAdapterADConfig vlionAdapterADConfig);

    public abstract void loadNativeAD(Context context, VlionAdapterADConfig vlionAdapterADConfig);

    public abstract void loadRewardVideoAD(Context context, VlionAdapterADConfig vlionAdapterADConfig);

    public abstract void loadSplashAD(Context context, VlionAdapterADConfig vlionAdapterADConfig);

    public abstract void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason);

    public abstract void notifyWinPrice(boolean z10);

    public void setVlionBiddingActionListener(VlionBiddingActionListener vlionBiddingActionListener) {
        this.vlionBiddingActionListener = vlionBiddingActionListener;
    }

    public void setVlionBiddingActionRewardListener(VlionBiddingActionRewardListener vlionBiddingActionRewardListener) {
        this.vlionBiddingActionRewardListener = vlionBiddingActionRewardListener;
    }

    public void setVlionBiddingListener(VlionBiddingLoadListener vlionBiddingLoadListener) {
        this.vlionBiddingListener = vlionBiddingLoadListener;
    }

    public void setVlionNativeActionListener(VlionNativeActionListener vlionNativeActionListener) {
        this.vlionNativeActionListener = vlionNativeActionListener;
    }

    public void setVlionNativesAdVideoListener(VlionNativesAdVideoListener vlionNativesAdVideoListener) {
        this.vlionNativesAdVideoListener = vlionNativesAdVideoListener;
    }

    public abstract void showInterstitialAD(Activity activity);

    public abstract void showRewardVideoAD(Activity activity);

    public abstract void showSplashAD(ViewGroup viewGroup);
}
