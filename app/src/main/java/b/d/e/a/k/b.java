package b.d.e.a.k;

import com.martian.ttbook.sdk.client.AdRequest;
import com.martian.ttbook.sdk.client.banner.BannerAdListener;
import com.martian.ttbook.sdk.client.data.MultiAdDataLoadListener;
import com.martian.ttbook.sdk.client.feedlist.FeedListAdListener;
import com.martian.ttbook.sdk.client.feedlist.FeedListNativeAdListener;
import com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener;
import com.martian.ttbook.sdk.client.splash.SplashAdListener;
import com.martian.ttbook.sdk.client.video.FullScreenVideoAdListener;
import com.martian.ttbook.sdk.client.video.RewardVideoAdListener;

/* loaded from: classes4.dex */
public interface b extends d {
    void a(AdRequest adRequest, BannerAdListener bannerAdListener);

    void b(AdRequest adRequest, FullScreenVideoAdListener fullScreenVideoAdListener);

    void c(AdRequest adRequest, RewardVideoAdListener rewardVideoAdListener);

    void d(AdRequest adRequest, SplashAdListener splashAdListener);

    void e(AdRequest adRequest, FeedListNativeAdListener feedListNativeAdListener);

    void f(AdRequest adRequest, InterstitialAdListener interstitialAdListener);

    void g(AdRequest adRequest, FeedListAdListener feedListAdListener);

    void h(AdRequest adRequest, MultiAdDataLoadListener multiAdDataLoadListener);
}
