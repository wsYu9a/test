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
public class c extends a implements b {
    public c() {
        super(b.class);
    }

    @Override // b.d.e.a.k.b
    public void a(AdRequest adRequest, BannerAdListener bannerAdListener) {
        b.d.e.a.d.a().e(new b.d.e.a.i.c.a(adRequest, bannerAdListener).b());
    }

    @Override // b.d.e.a.k.b
    public void b(AdRequest adRequest, FullScreenVideoAdListener fullScreenVideoAdListener) {
        b.d.e.a.d.a().e(new b.d.e.a.i.g.a(adRequest, fullScreenVideoAdListener).b());
    }

    @Override // b.d.e.a.k.b
    public void c(AdRequest adRequest, RewardVideoAdListener rewardVideoAdListener) {
        b.d.e.a.d.a().e(new b.d.e.a.i.g.b(adRequest, rewardVideoAdListener).b());
    }

    @Override // b.d.e.a.k.b
    public void d(AdRequest adRequest, SplashAdListener splashAdListener) {
        b.d.e.a.d.a().e(new b.d.e.a.i.f.a(adRequest, splashAdListener).b());
    }

    @Override // b.d.e.a.k.b
    public void e(AdRequest adRequest, FeedListNativeAdListener feedListNativeAdListener) {
        b.d.e.a.d.a().e(new b.d.e.a.i.d.a(adRequest, feedListNativeAdListener).b());
    }

    @Override // b.d.e.a.k.b
    public void f(AdRequest adRequest, InterstitialAdListener interstitialAdListener) {
        b.d.e.a.d.a().e(new b.d.e.a.i.e.a(adRequest, interstitialAdListener).b());
    }

    @Override // b.d.e.a.k.b
    public void g(AdRequest adRequest, FeedListAdListener feedListAdListener) {
        b.d.e.a.d.a().e(new b.d.e.a.i.d.b(adRequest, feedListAdListener).b());
    }

    @Override // b.d.e.a.k.b
    public void h(AdRequest adRequest, MultiAdDataLoadListener multiAdDataLoadListener) {
    }
}
