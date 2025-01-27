package com.aggmoread.sdk.b;

import android.util.Log;
import com.aggmoread.sdk.client.AMAdType;
import com.aggmoread.sdk.client.AMError;
import com.aggmoread.sdk.client.IAMAdInteractionListener;
import com.aggmoread.sdk.client.IAMAdLoadListener;
import com.aggmoread.sdk.client.banner.AMBannerAdListener;
import com.aggmoread.sdk.client.draw.AMDrawAdListener;
import com.aggmoread.sdk.client.feedlist.AMExpressAdListener;
import com.aggmoread.sdk.client.feedlist.AMMixFeedAdListener;
import com.aggmoread.sdk.client.feedlist.AMNativeAdListener;
import com.aggmoread.sdk.client.fullscreen.AMFullScreenAd;
import com.aggmoread.sdk.client.fullscreen.AMFullScreenAdInteractionListener;
import com.aggmoread.sdk.client.fullscreen.AMFullScreenAdListener;
import com.aggmoread.sdk.client.interstitial.AMInterstitialAd;
import com.aggmoread.sdk.client.interstitial.AMInterstitialAdInteractionListener;
import com.aggmoread.sdk.client.interstitial.AMInterstitialAdListener;
import com.aggmoread.sdk.client.reward.AMRewardAd;
import com.aggmoread.sdk.client.reward.AMRewardAdListener;
import com.aggmoread.sdk.client.reward.AMRewardInteractionListener;
import com.aggmoread.sdk.client.splash.AMSplashAd;
import com.aggmoread.sdk.client.splash.AMSplashAdListener;
import com.aggmoread.sdk.client.splash.AMSplashInteractionListener;
import com.aggmoread.sdk.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private IAMAdLoadListener<?> f4080a;

    /* renamed from: b */
    private IAMAdInteractionListener f4081b;

    /* renamed from: c */
    private AMAdType f4082c;

    /* renamed from: d */
    private boolean f4083d = false;

    /* renamed from: e */
    private boolean f4084e = true;

    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f4085a;

        static {
            int[] iArr = new int[AMAdType.values().length];
            f4085a = iArr;
            try {
                iArr[AMAdType.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4085a[AMAdType.INFORMATION_FLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4085a[AMAdType.EXPRESS_INFORMATION_FLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4085a[AMAdType.REWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4085a[AMAdType.INTERSTITIAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4085a[AMAdType.FULLSCREEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4085a[AMAdType.BANNER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4085a[AMAdType.DRAW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4085a[AMAdType.MIX_INFORMATION_FLOW.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public class b implements com.aggmoread.sdk.z.d.a.a.c.m.b {
        public b() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            d.this.a(dVar);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.m.b
        public void onAdLoaded(List<com.aggmoread.sdk.z.d.a.a.c.m.a> list) {
            Log.e(t.SDK_TAG, "banner ad onAdLoaded");
            d.this.f4083d = true;
            if (d.this.f4080a instanceof AMBannerAdListener) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.aggmoread.sdk.z.d.a.a.c.m.a> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.aggmoread.sdk.b.f(it.next(), d.this));
                }
                ((AMBannerAdListener) d.this.f4080a).onAdLoaded(arrayList);
                if (d.this.f4084e || list.size() <= 0) {
                    return;
                }
                list.get(0).b();
            }
        }
    }

    public class c implements com.aggmoread.sdk.z.d.a.a.c.p.c {
        public c() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            d.this.a(dVar);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.p.c
        public void onAdLoaded(List<com.aggmoread.sdk.z.d.a.a.c.p.b> list) {
            Log.e(t.SDK_TAG, "full ad onAdLoaded");
            d.this.f4083d = true;
            if (d.this.f4080a instanceof AMFullScreenAdListener) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.aggmoread.sdk.z.d.a.a.c.p.b> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.aggmoread.sdk.b.i(it.next(), d.this));
                }
                ((AMFullScreenAdListener) d.this.f4080a).onAdLoaded(arrayList);
                if (d.this.f4084e || arrayList.isEmpty() || !(d.this.f4081b instanceof AMFullScreenAdInteractionListener)) {
                    return;
                }
                ((AMFullScreenAd) arrayList.get(0)).show((AMFullScreenAdInteractionListener) d.this.f4081b);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.p.c
        public void onAdVideoCached() {
            if (d.this.f4080a instanceof AMFullScreenAdListener) {
                ((AMFullScreenAdListener) d.this.f4080a).onAdVideoCached();
            }
        }
    }

    /* renamed from: com.aggmoread.sdk.b.d$d */
    public class C0049d implements com.aggmoread.sdk.z.d.a.a.c.s.b {
        public C0049d() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            Log.e(t.SDK_TAG, "onAdError , " + dVar.a() + ", msg " + dVar.b());
            d.this.a(dVar);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.s.b
        public void onAdLoaded(List<com.aggmoread.sdk.z.d.a.a.c.s.a> list) {
            Log.e(t.SDK_TAG, "onAdLoaded");
            d.this.f4083d = true;
            if (d.this.f4080a instanceof AMSplashAdListener) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.aggmoread.sdk.z.d.a.a.c.s.a> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new o(d.this, it.next()));
                }
                ((AMSplashAdListener) d.this.f4080a).onAdLoaded(arrayList);
                if (d.this.f4084e || arrayList.isEmpty() || !(d.this.f4081b instanceof AMSplashInteractionListener)) {
                    return;
                }
                ((AMSplashAd) arrayList.get(0)).show((AMSplashInteractionListener) d.this.f4081b);
            }
        }
    }

    public class e implements com.aggmoread.sdk.z.d.a.a.c.o.g {
        public e() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            d.this.a(dVar);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.g
        public void onAdLoaded(List<com.aggmoread.sdk.z.d.a.a.c.o.f> list) {
            Log.e(t.SDK_TAG, "native ad onAdLoaded");
            d.this.f4083d = true;
            if (d.this.f4080a instanceof AMNativeAdListener) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.aggmoread.sdk.z.d.a.a.c.o.f> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new l(it.next(), d.this));
                }
                ((AMNativeAdListener) d.this.f4080a).onAdLoaded(arrayList);
            }
        }
    }

    public class f implements com.aggmoread.sdk.z.d.a.a.c.o.c {
        public f() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            d.this.a(dVar);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.c
        public void b(List<com.aggmoread.sdk.z.d.a.a.c.o.d> list) {
            Log.e(t.SDK_TAG, "mixFeed express onAdLoaded");
            d.this.f4083d = true;
            if (d.this.f4080a instanceof AMMixFeedAdListener) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.aggmoread.sdk.z.d.a.a.c.o.d> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new k(it.next(), d.this));
                }
                ((AMMixFeedAdListener) d.this.f4080a).onAdLoaded(arrayList);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.c
        public void a(List<com.aggmoread.sdk.z.d.a.a.c.o.f> list) {
            Log.e(t.SDK_TAG, "mixFeed native onAdLoaded");
            d.this.f4083d = true;
            if (d.this.f4080a instanceof AMMixFeedAdListener) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.aggmoread.sdk.z.d.a.a.c.o.f> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new k(it.next(), d.this));
                }
                ((AMMixFeedAdListener) d.this.f4080a).onAdLoaded(arrayList);
            }
        }
    }

    public class g implements com.aggmoread.sdk.z.d.a.a.c.o.e {

        /* renamed from: a */
        final /* synthetic */ HashMap f4091a;

        public g(HashMap hashMap) {
            this.f4091a = hashMap;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            d.this.a(dVar);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.e
        public void onAdLoaded(List<com.aggmoread.sdk.z.d.a.a.c.o.d> list) {
            Log.e(t.SDK_TAG, "express ad onAdLoaded");
            d.this.f4083d = true;
            if (d.this.f4080a instanceof AMExpressAdListener) {
                ArrayList arrayList = new ArrayList();
                for (com.aggmoread.sdk.z.d.a.a.c.o.d dVar : list) {
                    com.aggmoread.sdk.b.h hVar = new com.aggmoread.sdk.b.h(dVar, d.this);
                    arrayList.add(hVar);
                    this.f4091a.put(dVar, hVar);
                }
                ((AMExpressAdListener) d.this.f4080a).onAdLoaded(arrayList);
            }
        }
    }

    public class h implements com.aggmoread.sdk.z.d.a.a.c.r.b {
        public h() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            d.this.a(dVar);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.r.b
        public void onAdLoaded(List<com.aggmoread.sdk.z.d.a.a.c.r.a> list) {
            Log.e(t.SDK_TAG, "reward ad onAdLoaded");
            d.this.f4083d = true;
            if (d.this.f4080a instanceof AMRewardAdListener) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.aggmoread.sdk.z.d.a.a.c.r.a> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new n(it.next(), d.this));
                }
                ((AMRewardAdListener) d.this.f4080a).onAdLoaded(arrayList);
                if (d.this.f4084e || arrayList.isEmpty() || !(d.this.f4081b instanceof AMRewardInteractionListener)) {
                    return;
                }
                ((AMRewardAd) arrayList.get(0)).show((AMRewardInteractionListener) d.this.f4081b);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.r.b
        public void onAdVideoCached() {
            if (d.this.f4080a instanceof AMRewardAdListener) {
                ((AMRewardAdListener) d.this.f4080a).onAdVideoCached();
            }
        }
    }

    public class i implements com.aggmoread.sdk.z.d.a.a.c.q.c {
        public i() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            d.this.a(dVar);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.q.c
        public void onAdLoaded(List<com.aggmoread.sdk.z.d.a.a.c.q.b> list) {
            Log.e(t.SDK_TAG, "interstitial ad onAdLoaded");
            d.this.f4083d = true;
            if (d.this.f4080a instanceof AMInterstitialAdListener) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.aggmoread.sdk.z.d.a.a.c.q.b> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.aggmoread.sdk.b.j(it.next(), d.this));
                }
                ((AMInterstitialAdListener) d.this.f4080a).onAdLoaded(arrayList);
                if (d.this.f4084e || arrayList.isEmpty() || !(d.this.f4081b instanceof AMInterstitialAdInteractionListener)) {
                    return;
                }
                ((AMInterstitialAd) arrayList.get(0)).show((AMInterstitialAdInteractionListener) d.this.f4081b);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.q.c
        public void onAdVideoCached() {
            if (d.this.f4080a instanceof AMInterstitialAdListener) {
                ((AMInterstitialAdListener) d.this.f4080a).onAdVideoCached();
            }
        }
    }

    public class j implements com.aggmoread.sdk.z.d.a.a.c.n.c {
        public j() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            d.this.a(dVar);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.c
        public void onAdLoaded(List<com.aggmoread.sdk.z.d.a.a.c.n.a> list) {
            Log.e(t.SDK_TAG, "express ad onAdLoaded");
            d.this.f4083d = true;
            if (d.this.f4080a instanceof AMDrawAdListener) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.aggmoread.sdk.z.d.a.a.c.n.a> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.aggmoread.sdk.b.g(it.next(), d.this));
                }
                ((AMDrawAdListener) d.this.f4080a).onAdLoaded(arrayList);
            }
        }
    }

    public d(AMAdType aMAdType) {
        this.f4082c = aMAdType;
    }

    private com.aggmoread.sdk.z.d.a.a.c.o.c b() {
        return new f();
    }

    private com.aggmoread.sdk.z.d.a.a.c.o.g d() {
        return new e();
    }

    private com.aggmoread.sdk.z.d.a.a.c.f e() {
        return new b();
    }

    private com.aggmoread.sdk.z.d.a.a.c.n.c f() {
        return new j();
    }

    private com.aggmoread.sdk.z.d.a.a.c.o.e g() {
        return new g(new HashMap());
    }

    private com.aggmoread.sdk.z.d.a.a.c.f h() {
        return new c();
    }

    private com.aggmoread.sdk.z.d.a.a.c.q.c i() {
        return new i();
    }

    private com.aggmoread.sdk.z.d.a.a.c.f j() {
        return new h();
    }

    private com.aggmoread.sdk.z.d.a.a.c.s.b c() {
        return new C0049d();
    }

    public com.aggmoread.sdk.z.d.a.a.c.f a() {
        switch (a.f4085a[this.f4082c.ordinal()]) {
            case 1:
                return c();
            case 2:
                return d();
            case 3:
                return g();
            case 4:
                return j();
            case 5:
                return i();
            case 6:
                return h();
            case 7:
                return e();
            case 8:
                return f();
            case 9:
                return b();
            default:
                return null;
        }
    }

    public void a(IAMAdInteractionListener iAMAdInteractionListener) {
        this.f4081b = iAMAdInteractionListener;
    }

    public void a(IAMAdLoadListener<?> iAMAdLoadListener) {
        this.f4080a = iAMAdLoadListener;
    }

    public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
        if (this.f4083d) {
            IAMAdInteractionListener iAMAdInteractionListener = this.f4081b;
            if (iAMAdInteractionListener != null) {
                iAMAdInteractionListener.onAdError(new AMError(dVar.a(), dVar.b()));
                return;
            }
            return;
        }
        IAMAdLoadListener<?> iAMAdLoadListener = this.f4080a;
        if (iAMAdLoadListener != null) {
            iAMAdLoadListener.onAdLoadFail(new AMError(dVar.a(), dVar.b()));
        }
    }

    public void a(boolean z10) {
        this.f4084e = z10;
    }
}
