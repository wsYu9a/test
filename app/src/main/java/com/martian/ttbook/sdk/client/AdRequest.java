package com.martian.ttbook.sdk.client;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.d.e.a.g;
import b.d.e.a.j.c;
import b.d.e.a.k.b;
import b.d.e.a.k.e;
import com.martian.ttbook.sdk.client.VideoSettings;
import com.martian.ttbook.sdk.client.banner.BannerAdListener;
import com.martian.ttbook.sdk.client.data.MultiAdDataLoadListener;
import com.martian.ttbook.sdk.client.feedlist.AdSize;
import com.martian.ttbook.sdk.client.feedlist.FeedListAdListener;
import com.martian.ttbook.sdk.client.feedlist.FeedListNativeAdListener;
import com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener;
import com.martian.ttbook.sdk.client.splash.SplashAdListener;
import com.martian.ttbook.sdk.client.video.FullScreenVideoAdListener;
import com.martian.ttbook.sdk.client.video.RewardVideoAdListener;
import java.util.UUID;

/* loaded from: classes.dex */
public class AdRequest {
    static final int BRCOUNT = 1;
    static final String TAG = "AdRequest";
    private Activity activity;
    private AdListeneable adClientListener;
    private ViewGroup adContainer;
    private JoinType adDataType;
    private AdDownloadConfirmListener adDownloadConfirmListener;
    private int adRequestCount;
    private AdRewardListener adRewardListener;
    private AdSize adSize;
    AdType adType;
    private boolean canTouchMove;
    private String codeId;
    private Context context;
    private String customData;
    private AdParameters extParameters;
    private int handlerVersion;
    private boolean isNeedSplashBottomLogo;
    private boolean isRecycled;
    private boolean isSupportVideo;
    private boolean isVolumnOn;
    private long loadTime;
    private String oaId;
    private boolean onlyLoadAdData;
    private g recycler;
    private int refresh;
    private String requestId;
    private long requestTime;
    private int rewardAmount;
    private String rewardName;
    private View skipContainer;
    private FrameLayout.LayoutParams skipContainerLayoutParams;
    private Bitmap splashBottomLogo;
    private int timeoutMs;
    private boolean useCustomSkipView;
    private String userID;
    private VideoSettings videoSettings;

    /* renamed from: com.martian.ttbook.sdk.client.AdRequest$1 */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean val$isOnlyLoadAdData;
        final /* synthetic */ SplashAdListener val$splashAdListener;

        AnonymousClass1(boolean z, SplashAdListener splashAdListener) {
            z = z;
            splashAdListener = splashAdListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdRequest adRequest = AdRequest.this;
            adRequest.adType = AdType.SPLASH;
            adRequest.onlyLoadAdData = z;
            AdRequest.this.loadTime = System.currentTimeMillis();
            AdRequest.this.adClientListener = splashAdListener;
            ((b) e.a(b.class)).d(AdRequest.this, (SplashAdListener) b.d.e.a.j.e.a(splashAdListener));
        }
    }

    /* renamed from: com.martian.ttbook.sdk.client.AdRequest$2 */
    /* loaded from: classes4.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ AdError val$adError;
        final /* synthetic */ AdCommonListener val$listener;

        AnonymousClass2(AdCommonListener adCommonListener, AdError adError) {
            adCommonListener = adCommonListener;
            adError = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            adCommonListener.onAdError(adError);
        }
    }

    /* renamed from: com.martian.ttbook.sdk.client.AdRequest$3 */
    /* loaded from: classes4.dex */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdRequest.this.recycleRecyler();
            AdRequest.this.recycleRetryPolicy();
            AdRequest.this.recycleClientData();
            AdRequest.this.recycleClientRelation();
            AdRequest.this.isRecycled = true;
            c.h(AdRequest.TAG, "AdRequest recycle enter , codeId = " + AdRequest.this.codeId);
        }
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        private String OAID;
        private Activity activity;
        private ViewGroup adContainer;
        private AdDownloadConfirmListener adDownloadConfirmListener;
        private int adRequestCount;
        private AdRewardListener adRewardListener;
        private AdSize adSize;
        private AdType adType;
        private boolean canTouchMove;
        private String codeId;
        private Context context;
        private String customData;
        private AdParameters extParameters;
        private boolean isNeedSplashBottomLogo;
        private boolean isSupportVideo;
        private boolean isVolumnOn;
        private boolean onlyLoadAdData;
        private int refresh;
        private int rewardAmount;
        private String rewardName;
        private View skipContainer;
        private FrameLayout.LayoutParams skipContainerLayoutParams;
        private Bitmap splashBottomLogo;
        private int timeoutMs;
        private String userID;
        private VideoSettings videoSettings;

        public Builder(Activity activity) {
            this.adType = AdType.UNKNOWN;
            this.adSize = AdSize.AUTO;
            this.adRequestCount = 1;
            this.timeoutMs = 0;
            this.isVolumnOn = true;
            this.refresh = 0;
            this.extParameters = new AdParameters();
            this.videoSettings = VideoSettings.DEFAULT;
            this.isSupportVideo = false;
            this.canTouchMove = true;
            this.onlyLoadAdData = false;
            this.isNeedSplashBottomLogo = true;
            this.activity = activity;
            this.context = activity.getApplicationContext();
        }

        public Builder(Context context) {
            this.adType = AdType.UNKNOWN;
            this.adSize = AdSize.AUTO;
            this.adRequestCount = 1;
            this.timeoutMs = 0;
            this.isVolumnOn = true;
            this.refresh = 0;
            this.extParameters = new AdParameters();
            this.videoSettings = VideoSettings.DEFAULT;
            this.isSupportVideo = false;
            this.canTouchMove = true;
            this.onlyLoadAdData = false;
            this.isNeedSplashBottomLogo = true;
            this.context = context;
        }

        public Builder(AdRequest adRequest) {
            this.adType = AdType.UNKNOWN;
            this.adSize = AdSize.AUTO;
            this.adRequestCount = 1;
            this.timeoutMs = 0;
            this.isVolumnOn = true;
            this.refresh = 0;
            this.extParameters = new AdParameters();
            this.videoSettings = VideoSettings.DEFAULT;
            this.isSupportVideo = false;
            this.canTouchMove = true;
            this.onlyLoadAdData = false;
            this.isNeedSplashBottomLogo = true;
            this.context = adRequest.getContext();
            this.adType = adRequest.getAdType();
            this.activity = adRequest.getActivity();
            this.adRequestCount = adRequest.getAdRequestCount();
            this.adSize = adRequest.getAdSize();
            this.codeId = adRequest.getCodeId();
            this.timeoutMs = adRequest.getTimeoutMs();
            this.splashBottomLogo = adRequest.getSplashBottomLogo();
            this.adContainer = adRequest.getAdContainer();
            this.rewardAmount = adRequest.getRewardAmount();
            this.rewardName = adRequest.getRewardName();
            this.userID = adRequest.getUserID();
            this.customData = adRequest.getCustomData();
            this.refresh = adRequest.getRefresh();
            this.extParameters = new AdParameters(adRequest.getExtParameters());
            this.skipContainer = adRequest.getSkipContainer();
            this.isVolumnOn = adRequest.isVolumnOn();
            this.onlyLoadAdData = adRequest.isOnlyLoadAdData();
            if (adRequest.getVideoSettings() != null) {
                this.videoSettings = new VideoSettings.Builder(adRequest.getVideoSettings()).build();
            }
            this.isSupportVideo = adRequest.isSupportVideo();
            this.isNeedSplashBottomLogo = adRequest.isNeedSplashBottomLogo();
            this.adDownloadConfirmListener = adRequest.getAdDownloadConfirmListener();
            this.adRewardListener = adRequest.getAdRewardListener();
        }

        public Builder appendParameter(String str, int i2) {
            this.extParameters.putInt(str, i2);
            return this;
        }

        public Builder appendParameter(String str, String str2) {
            this.extParameters.putString(str, str2);
            return this;
        }

        public Builder appendParameter(String str, boolean z) {
            this.extParameters.putBoolean(str, z);
            return this;
        }

        public Builder appendParameters(Bundle bundle) {
            this.extParameters.putAll(bundle);
            return this;
        }

        public AdRequest build() {
            AdRequest adRequest = new AdRequest(this.adType);
            adRequest.context = this.context;
            adRequest.activity = this.activity;
            adRequest.adRequestCount = this.adRequestCount;
            adRequest.adSize = this.adSize;
            adRequest.codeId = this.codeId;
            adRequest.timeoutMs = this.timeoutMs;
            adRequest.splashBottomLogo = this.splashBottomLogo;
            adRequest.adContainer = this.adContainer;
            adRequest.rewardAmount = this.rewardAmount;
            adRequest.rewardName = this.rewardName;
            adRequest.userID = this.userID;
            adRequest.customData = this.customData;
            adRequest.refresh = this.refresh;
            adRequest.extParameters = new AdParameters(this.extParameters);
            adRequest.skipContainer = this.skipContainer;
            adRequest.skipContainerLayoutParams = this.skipContainerLayoutParams;
            adRequest.isVolumnOn = this.isVolumnOn;
            adRequest.videoSettings = this.videoSettings;
            adRequest.isSupportVideo = this.isSupportVideo;
            adRequest.oaId = this.OAID;
            adRequest.canTouchMove = this.canTouchMove;
            adRequest.onlyLoadAdData = this.onlyLoadAdData;
            adRequest.isNeedSplashBottomLogo = this.isNeedSplashBottomLogo;
            adRequest.adDownloadConfirmListener = this.adDownloadConfirmListener;
            adRequest.adRewardListener = this.adRewardListener;
            return adRequest;
        }

        public Builder setAdContainer(ViewGroup viewGroup) {
            this.adContainer = viewGroup;
            return this;
        }

        public Builder setAdDownloadConfirmListener(AdDownloadConfirmListener adDownloadConfirmListener) {
            this.adDownloadConfirmListener = adDownloadConfirmListener;
            return this;
        }

        public Builder setAdRequestCount(int i2) {
            this.adRequestCount = i2;
            return this;
        }

        public Builder setAdRewardListener(AdRewardListener adRewardListener) {
            this.adRewardListener = adRewardListener;
            return this;
        }

        public Builder setAdSize(AdSize adSize) {
            if (adSize == null) {
                adSize = AdSize.AUTO;
            }
            this.adSize = adSize;
            return this;
        }

        public Builder setCodeId(String str) {
            if (str == null) {
                str = "";
            }
            this.codeId = str;
            return this;
        }

        public Builder setCustomData(String str) {
            this.customData = str;
            return this;
        }

        public Builder setNeedSplashBottomLogo(boolean z) {
            this.isNeedSplashBottomLogo = z;
            return this;
        }

        public Builder setRefresh(int i2) {
            this.refresh = i2;
            return this;
        }

        public Builder setRewardAmount(int i2) {
            this.rewardAmount = i2;
            return this;
        }

        public Builder setRewardName(String str) {
            this.rewardName = str;
            return this;
        }

        public Builder setSkipContainer(View view, FrameLayout.LayoutParams layoutParams) {
            this.skipContainer = view;
            this.skipContainerLayoutParams = layoutParams;
            return this;
        }

        public Builder setSplashBottomLogo(Bitmap bitmap) {
            this.splashBottomLogo = bitmap;
            return this;
        }

        public Builder setSupportVideo(boolean z) {
            this.isSupportVideo = z;
            return this;
        }

        public Builder setTimeoutMs(int i2) {
            this.timeoutMs = i2;
            return this;
        }

        public Builder setTouchMove(boolean z) {
            this.canTouchMove = z;
            return this;
        }

        public Builder setUserID(String str) {
            this.userID = str;
            return this;
        }

        public Builder setVideoSettings(VideoSettings videoSettings) {
            this.videoSettings = videoSettings;
            return this;
        }

        public Builder setVolumnOn(boolean z) {
            this.isVolumnOn = z;
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public interface Parameters {
        public static final int ATTACH_SHIFT = 24;
        public static final int DEFAULT_VALUE = -1;
        public static final int DEFAULT_VALUE_ESP = -1;
        public static final int DEFAULT_VALUE_SIPL = -1;
        public static final String KEY_ACH_ESP = "com.sdk.key.ACH_ESP";
        public static final String KEY_ESP = "com.sdk.key.ESP";
        public static final String KEY_SIPL = "com.sdk.key.SIPL";
        public static final String KEY_SPLASH_SLOGN_RID = "com.sdk.key.SPLASH_SR";
        public static final int VALUE_ATTACH_MASK = -16777216;
        public static final int VALUE_ESP_1 = 16;
        public static final int VALUE_ESP_10 = 8192;
        public static final int VALUE_ESP_11 = 16384;
        public static final int VALUE_ESP_12 = 32768;
        public static final int VALUE_ESP_2 = 32;
        public static final int VALUE_ESP_3 = 64;
        public static final int VALUE_ESP_4 = 128;
        public static final int VALUE_ESP_5 = 256;
        public static final int VALUE_ESP_6 = 512;
        public static final int VALUE_ESP_7 = 1024;
        public static final int VALUE_ESP_8 = 2048;
        public static final int VALUE_ESP_9 = 4096;
        public static final int VALUE_SIPL_1 = 65536;
        public static final int VALUE_SIPL_10 = 33554432;
        public static final int VALUE_SIPL_11 = 67108864;
        public static final int VALUE_SIPL_12 = 134217728;
        public static final int VALUE_SIPL_2 = 131072;
        public static final int VALUE_SIPL_3 = 262144;
        public static final int VALUE_SIPL_4 = 524288;
        public static final int VALUE_SIPL_5 = 1048576;
        public static final int VALUE_SIPL_6 = 2097152;
        public static final int VALUE_SIPL_7 = 4194304;
        public static final int VALUE_SIPL_8 = 8388608;
        public static final int VALUE_SIPL_9 = 16777216;
    }

    private AdRequest(AdType adType) {
        this.adType = AdType.UNKNOWN;
        this.adSize = AdSize.AUTO;
        this.adRequestCount = 1;
        this.timeoutMs = 0;
        this.requestTime = System.currentTimeMillis();
        this.handlerVersion = 0;
        this.isVolumnOn = true;
        this.adDataType = JoinType.SDK;
        this.refresh = 0;
        this.extParameters = new AdParameters();
        this.videoSettings = VideoSettings.DEFAULT;
        this.isSupportVideo = false;
        this.useCustomSkipView = false;
        this.onlyLoadAdData = false;
        this.isNeedSplashBottomLogo = true;
        this.isRecycled = false;
        this.adType = adType;
        this.requestId = UUID.randomUUID().toString();
    }

    /* synthetic */ AdRequest(AdType adType, AnonymousClass1 anonymousClass1) {
        this(adType);
    }

    public static String getSdkVersion() {
        return com.martian.ttbook.b.c.a.a.e.b.v();
    }

    public static synchronized void init(Context context, SdkConfiguration sdkConfiguration) {
        synchronized (AdRequest.class) {
            Log.i(TAG, "init enter");
            if (AdClientContext.isRealy()) {
                AdClientContext.reinit(context, sdkConfiguration);
            } else {
                AdClientContext.init(context, sdkConfiguration);
            }
        }
    }

    private void notifyErrorInMainThread(AdCommonListener adCommonListener, AdError adError) {
        if (adCommonListener != null) {
            b.d.e.a.j.g.e(new Runnable() { // from class: com.martian.ttbook.sdk.client.AdRequest.2
                final /* synthetic */ AdError val$adError;
                final /* synthetic */ AdCommonListener val$listener;

                AnonymousClass2(AdCommonListener adCommonListener2, AdError adError2) {
                    adCommonListener = adCommonListener2;
                    adError = adError2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    adCommonListener.onAdError(adError);
                }
            });
        }
    }

    void attach(Activity activity) {
        this.activity = activity;
    }

    boolean check(AdCommonListener adCommonListener) {
        if (AdClientContext.isRealy() && AdClientContext.isIsInitSuccess()) {
            return true;
        }
        if (adCommonListener == null) {
            return false;
        }
        notifyErrorInMainThread(adCommonListener, new AdError(-101, "please invoke init !"));
        return false;
    }

    boolean checkActivity(AdCommonListener adCommonListener) {
        if (this.activity != null) {
            return true;
        }
        if (adCommonListener == null) {
            return false;
        }
        notifyErrorInMainThread(adCommonListener, new AdError(-101, "activity is null !"));
        return false;
    }

    boolean checkContext(AdCommonListener adCommonListener) {
        if (this.context != null) {
            return true;
        }
        if (adCommonListener == null) {
            return false;
        }
        notifyErrorInMainThread(adCommonListener, new AdError(-101, "context is null !"));
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdRequest adRequest = (AdRequest) obj;
        if (getRequestId().equals(adRequest.getRequestId())) {
            return getCodeId().equals(adRequest.getCodeId());
        }
        return false;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public AdListeneable getAdClientListener() {
        return this.adClientListener;
    }

    public ViewGroup getAdContainer() {
        return this.adContainer;
    }

    public AdDownloadConfirmListener getAdDownloadConfirmListener() {
        return this.adDownloadConfirmListener;
    }

    public int getAdRequestCount() {
        return this.adRequestCount;
    }

    public AdRewardListener getAdRewardListener() {
        return this.adRewardListener;
    }

    public AdSize getAdSize() {
        return this.adSize;
    }

    public AdType getAdType() {
        return this.adType;
    }

    public String getCodeId() {
        return this.codeId;
    }

    public Context getContext() {
        return this.context;
    }

    public String getCustomData() {
        return this.customData;
    }

    public AdParameters getExtParameters() {
        return this.extParameters;
    }

    public int getHandlerVersion() {
        return this.handlerVersion;
    }

    public long getLoadTime() {
        return this.loadTime;
    }

    public String getOaId() {
        String str = this.oaId;
        return str == null ? "" : str;
    }

    public int getRefresh() {
        return this.refresh;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public long getRequestTime() {
        return this.requestTime;
    }

    public int getRewardAmount() {
        return this.rewardAmount;
    }

    public String getRewardName() {
        return this.rewardName;
    }

    public View getSkipContainer() {
        return this.skipContainer;
    }

    public FrameLayout.LayoutParams getSkipContainerLayoutParams() {
        return this.skipContainerLayoutParams;
    }

    public Bitmap getSplashBottomLogo() {
        return this.splashBottomLogo;
    }

    public int getTimeoutMs() {
        return this.timeoutMs;
    }

    public String getUserID() {
        return this.userID;
    }

    public VideoSettings getVideoSettings() {
        return this.videoSettings;
    }

    public boolean hasParameter(String str) {
        return this.extParameters.containsKey(str);
    }

    public boolean hasSplashSkipView() {
        return this.skipContainer != null;
    }

    public int hashCode() {
        return (getRequestId().hashCode() * 31) + getCodeId().hashCode();
    }

    public boolean isCanTouchMove() {
        return this.canTouchMove;
    }

    public boolean isNeedSplashBottomLogo() {
        return this.isNeedSplashBottomLogo;
    }

    public boolean isOnlyLoadAdData() {
        return this.onlyLoadAdData;
    }

    public boolean isRecycled() {
        return this.isRecycled;
    }

    public boolean isSupportVideo() {
        return this.isSupportVideo;
    }

    public boolean isVolumnOn() {
        return this.isVolumnOn;
    }

    public AdRequest loadBannerAd(BannerAdListener bannerAdListener) {
        return loadBannerAd(bannerAdListener, false);
    }

    public AdRequest loadBannerAd(BannerAdListener bannerAdListener, boolean z) {
        c.h(TAG, "loadBannerAd enter");
        if (!check(bannerAdListener) || !checkActivity(bannerAdListener)) {
            return this;
        }
        this.adType = AdType.BANNER;
        this.loadTime = System.currentTimeMillis();
        this.adClientListener = bannerAdListener;
        this.onlyLoadAdData = z;
        ((b) e.a(b.class)).a(this, (BannerAdListener) b.d.e.a.j.e.a(bannerAdListener));
        return this;
    }

    public AdRequest loadFeedListAd(FeedListAdListener feedListAdListener) {
        c.h(TAG, "loadFeedListAd enter");
        if (!check(feedListAdListener) || !checkActivity(feedListAdListener)) {
            return this;
        }
        this.loadTime = System.currentTimeMillis();
        this.adType = AdType.INFORMATION_FLOW;
        this.adClientListener = feedListAdListener;
        ((b) e.a(b.class)).g(this, (FeedListAdListener) b.d.e.a.j.e.a(feedListAdListener));
        return this;
    }

    public AdRequest loadFeedListNativeAd(FeedListNativeAdListener feedListNativeAdListener) {
        c.h(TAG, "loadFeedListNativeAd enter");
        if (!check(feedListNativeAdListener) || !checkContext(feedListNativeAdListener)) {
            return this;
        }
        this.adType = AdType.INFORMATION_FLOW;
        this.loadTime = System.currentTimeMillis();
        this.adClientListener = feedListNativeAdListener;
        ((b) e.a(b.class)).e(this, (FeedListNativeAdListener) b.d.e.a.j.e.a(feedListNativeAdListener));
        return this;
    }

    public AdRequest loadFullScreenVideoAd(FullScreenVideoAdListener fullScreenVideoAdListener) {
        return loadFullScreenVideoAd(fullScreenVideoAdListener, false);
    }

    public AdRequest loadFullScreenVideoAd(FullScreenVideoAdListener fullScreenVideoAdListener, boolean z) {
        c.h(TAG, "loadFullScreenVideoAd enter");
        if (!check(fullScreenVideoAdListener) || !checkActivity(fullScreenVideoAdListener)) {
            return this;
        }
        this.adType = AdType.FULL_SCREEN_VIDEO;
        this.onlyLoadAdData = z;
        this.loadTime = System.currentTimeMillis();
        this.adClientListener = fullScreenVideoAdListener;
        ((b) e.a(b.class)).b(this, (FullScreenVideoAdListener) b.d.e.a.j.e.a(fullScreenVideoAdListener));
        return this;
    }

    public AdRequest loadInterstitialAd(InterstitialAdListener interstitialAdListener) {
        c.h(TAG, "loadInterstitialAd enter #1");
        return loadInterstitialAd(interstitialAdListener, false);
    }

    public AdRequest loadInterstitialAd(InterstitialAdListener interstitialAdListener, boolean z) {
        c.h(TAG, "loadInterstitialAd enter #2");
        if (!check(interstitialAdListener) || !checkActivity(interstitialAdListener)) {
            return this;
        }
        this.adType = AdType.INTERSTITIAL;
        this.loadTime = System.currentTimeMillis();
        this.adClientListener = interstitialAdListener;
        this.onlyLoadAdData = z;
        ((b) e.a(b.class)).f(this, (InterstitialAdListener) b.d.e.a.j.e.a(interstitialAdListener));
        return this;
    }

    public AdRequest loadMultiAdData(MultiAdDataLoadListener multiAdDataLoadListener) {
        c.h(TAG, "loadMultiAdData enter");
        if (!check(multiAdDataLoadListener) || !checkContext(multiAdDataLoadListener)) {
            return this;
        }
        this.adType = AdType.INFORMATION_FLOW;
        this.loadTime = System.currentTimeMillis();
        this.adClientListener = multiAdDataLoadListener;
        ((b) e.a(b.class)).h(this, (MultiAdDataLoadListener) b.d.e.a.j.e.a(multiAdDataLoadListener));
        return this;
    }

    public AdRequest loadRewardVideoAd(RewardVideoAdListener rewardVideoAdListener) {
        return loadRewardVideoAd(rewardVideoAdListener, false);
    }

    public AdRequest loadRewardVideoAd(RewardVideoAdListener rewardVideoAdListener, boolean z) {
        c.h(TAG, "loadRewardVideoAd enter");
        if (!check(rewardVideoAdListener) || !checkContext(rewardVideoAdListener)) {
            return this;
        }
        this.adType = AdType.REWARD_VIDEO;
        this.onlyLoadAdData = z;
        this.loadTime = System.currentTimeMillis();
        this.adClientListener = rewardVideoAdListener;
        ((b) e.a(b.class)).c(this, (RewardVideoAdListener) b.d.e.a.j.e.a(rewardVideoAdListener));
        return this;
    }

    public AdRequest loadSplashAd(SplashAdListener splashAdListener) {
        return loadSplashAd(splashAdListener, false);
    }

    public AdRequest loadSplashAd(SplashAdListener splashAdListener, boolean z) {
        c.e(TAG, "loadSplashAd enter hasSplashSkipView = %s, skipContainer = %s, onlyLoadAdData = %s", Boolean.valueOf(hasSplashSkipView()), this.skipContainer, Boolean.valueOf(this.onlyLoadAdData));
        if (!check(splashAdListener) || !checkActivity(splashAdListener)) {
            return this;
        }
        b.d.e.a.j.g.e(new Runnable() { // from class: com.martian.ttbook.sdk.client.AdRequest.1
            final /* synthetic */ boolean val$isOnlyLoadAdData;
            final /* synthetic */ SplashAdListener val$splashAdListener;

            AnonymousClass1(boolean z2, SplashAdListener splashAdListener2) {
                z = z2;
                splashAdListener = splashAdListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                AdRequest adRequest = AdRequest.this;
                adRequest.adType = AdType.SPLASH;
                adRequest.onlyLoadAdData = z;
                AdRequest.this.loadTime = System.currentTimeMillis();
                AdRequest.this.adClientListener = splashAdListener;
                ((b) e.a(b.class)).d(AdRequest.this, (SplashAdListener) b.d.e.a.j.e.a(splashAdListener));
            }
        });
        return this;
    }

    public boolean recycle() {
        b.d.e.a.j.g.e(new Runnable() { // from class: com.martian.ttbook.sdk.client.AdRequest.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AdRequest.this.recycleRecyler();
                AdRequest.this.recycleRetryPolicy();
                AdRequest.this.recycleClientData();
                AdRequest.this.recycleClientRelation();
                AdRequest.this.isRecycled = true;
                c.h(AdRequest.TAG, "AdRequest recycle enter , codeId = " + AdRequest.this.codeId);
            }
        });
        return true;
    }

    void recycleClientData() {
        Bitmap bitmap = this.splashBottomLogo;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.splashBottomLogo.recycle();
            this.splashBottomLogo = null;
        }
        this.extParameters.clear();
    }

    void recycleClientRelation() {
        this.adClientListener = AdListeneable.EMPTY;
        c.h(TAG, "recycleClientRelation");
    }

    void recycleRecyler() {
        g gVar = this.recycler;
        if (gVar != null) {
            gVar.recycle();
        }
    }

    void recycleRetryPolicy() {
    }

    void resetAdRequestCount(int i2) {
        this.adRequestCount = i2;
    }

    void setAdType(AdType adType) {
        this.adType = adType;
    }

    public void setNeedSplashBottomLogo(boolean z) {
        this.isNeedSplashBottomLogo = z;
    }

    public void setRecycler(g gVar) {
        this.recycler = gVar;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    boolean throwIfNotOnMainThread(AdCommonListener adCommonListener) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        if (adCommonListener == null) {
            return false;
        }
        notifyErrorInMainThread(adCommonListener, new AdError(-101, "must be invoked from the main thread"));
        return false;
    }

    public String toString() {
        return "AdRequest{codeId='" + this.codeId + "', requestId=" + this.requestId + ", activity=" + this.activity + ", adType=" + this.adType + ", adSize=" + this.adSize + ", adRequestCount=" + this.adRequestCount + ", timeoutMs=" + this.timeoutMs + ", splashBottomLogo=" + this.splashBottomLogo + ", rewardAmount=" + this.rewardAmount + ", rewardName=" + this.rewardName + ", userID=" + this.userID + ", customData=" + this.customData + ", adContainer=" + this.adContainer + ", skipView = " + this.skipContainer + ", skipViewLayoutParams = " + this.skipContainerLayoutParams + '}';
    }
}
