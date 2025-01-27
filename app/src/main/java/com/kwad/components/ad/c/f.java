package com.kwad.components.ad.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.i;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class f {
    public static KsScene bT;

    /* renamed from: com.kwad.components.ad.c.f$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            KsLoadManager.BannerAdListener.this.onError(com.kwad.sdk.core.network.e.azA.errorCode, com.kwad.sdk.core.network.e.azA.msg + "sdk not init");
        }
    }

    /* renamed from: com.kwad.components.ad.c.f$2 */
    public class AnonymousClass2 extends com.kwad.components.core.request.d {
        final /* synthetic */ SceneImpl bV;

        /* renamed from: com.kwad.components.ad.c.f$2$1 */
        public class AnonymousClass1 extends bd {
            final /* synthetic */ int bW;
            final /* synthetic */ String bX;

            public AnonymousClass1(int i10, String str) {
                i10 = i10;
                str = str;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                KsLoadManager.BannerAdListener.this.onError(i10, str);
            }
        }

        /* renamed from: com.kwad.components.ad.c.f$2$2 */
        public class C03632 implements com.kwad.components.ad.c.a.b {
            final /* synthetic */ AdTemplate bZ;

            /* renamed from: ca */
            final /* synthetic */ KsBannerAd f11406ca;

            public C03632(AdTemplate adTemplate, KsBannerAd ksBannerAd) {
                adTemplate = adTemplate;
                gVar = ksBannerAd;
            }

            @Override // com.kwad.components.ad.c.a.b
            public final void ae() {
                com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                AdTemplate adTemplate = adTemplate;
                f.a(KsLoadManager.BannerAdListener.this, gVar);
            }

            @Override // com.kwad.components.ad.c.a.b
            public final void af() {
                AdTemplate adTemplate = adTemplate;
                f.a(KsLoadManager.BannerAdListener.this, gVar);
            }
        }

        public AnonymousClass2(SceneImpl sceneImpl) {
            covert = sceneImpl;
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
        public final void a(@NonNull AdResultData adResultData, boolean z10) {
            List a10 = f.a(covert, adResultData.getAdTemplateList());
            if (a10.isEmpty()) {
                onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg);
                j.ao("bannerAd_", "onBannerAdCacheFailed");
                return;
            }
            AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.d.Ag());
            AdTemplate adTemplate = (AdTemplate) a10.get(0);
            new g(adResultData);
            com.kwad.sdk.commercial.d.d.a(covert, a10.size());
            g gVar = new g(adResultData);
            com.kwad.sdk.core.config.d.Eg();
            AdTemplate adTemplate2 = gVar.getAdTemplate();
            if (com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.eb(adTemplate2))) {
                f.a(KsLoadManager.BannerAdListener.this, gVar);
            } else {
                com.kwad.components.ad.c.a.a.a(adTemplate2, obtainVideoPreCacheConfig, new com.kwad.components.ad.c.a.b() { // from class: com.kwad.components.ad.c.f.2.2
                    final /* synthetic */ AdTemplate bZ;

                    /* renamed from: ca */
                    final /* synthetic */ KsBannerAd f11406ca;

                    public C03632(AdTemplate adTemplate3, KsBannerAd gVar2) {
                        adTemplate = adTemplate3;
                        gVar = gVar2;
                    }

                    @Override // com.kwad.components.ad.c.a.b
                    public final void ae() {
                        com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                        AdTemplate adTemplate3 = adTemplate;
                        f.a(KsLoadManager.BannerAdListener.this, gVar);
                    }

                    @Override // com.kwad.components.ad.c.a.b
                    public final void af() {
                        AdTemplate adTemplate3 = adTemplate;
                        f.a(KsLoadManager.BannerAdListener.this, gVar);
                    }
                });
            }
            com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "loadFullScreenVideoAd after cache");
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void onError(int i10, String str) {
            if (i10 != com.kwad.sdk.core.network.e.azA.errorCode) {
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azv;
            }
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.c.f.2.1
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public AnonymousClass1(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    KsLoadManager.BannerAdListener.this.onError(i10, str);
                }
            });
        }
    }

    /* renamed from: com.kwad.components.ad.c.f$3 */
    public class AnonymousClass3 implements i {
        @Override // com.kwad.components.core.request.i
        @WorkerThread
        public final void ag() {
        }
    }

    /* renamed from: com.kwad.components.ad.c.f$4 */
    public class AnonymousClass4 extends bd {

        /* renamed from: cb */
        final /* synthetic */ KsBannerAd f11407cb;

        public AnonymousClass4(KsBannerAd ksBannerAd) {
            ksBannerAd = ksBannerAd;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            j.ao("bannerAd_", "onBannerAdCacheSuccess");
            KsLoadManager.BannerAdListener.this.onBannerAdLoad(ksBannerAd);
        }
    }

    public static void loadBannerAd(KsScene ksScene, @NonNull KsLoadManager.BannerAdListener bannerAdListener) {
        if (!l.At().zE()) {
            com.kwad.sdk.core.d.c.e("KsAdBannerLoadManager", "loadBannerAd please init sdk first");
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.c.f.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    KsLoadManager.BannerAdListener.this.onError(com.kwad.sdk.core.network.e.azA.errorCode, com.kwad.sdk.core.network.e.azA.msg + "sdk not init");
                }
            });
            return;
        }
        ksScene.setAdNum(com.kwad.sdk.core.config.d.Ek());
        bT = ksScene;
        SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        boolean a10 = m.si().a(covert, "loadBannerAd");
        covert.setAdStyle(5);
        KsAdLoadManager.M().a(new a.C0445a().e(new ImpInfo(covert)).aK(a10).a(new i() { // from class: com.kwad.components.ad.c.f.3
            @Override // com.kwad.components.core.request.i
            @WorkerThread
            public final void ag() {
            }
        }).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.c.f.2
            final /* synthetic */ SceneImpl bV;

            /* renamed from: com.kwad.components.ad.c.f$2$1 */
            public class AnonymousClass1 extends bd {
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public AnonymousClass1(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    KsLoadManager.BannerAdListener.this.onError(i10, str);
                }
            }

            /* renamed from: com.kwad.components.ad.c.f$2$2 */
            public class C03632 implements com.kwad.components.ad.c.a.b {
                final /* synthetic */ AdTemplate bZ;

                /* renamed from: ca */
                final /* synthetic */ KsBannerAd f11406ca;

                public C03632(AdTemplate adTemplate3, KsBannerAd gVar2) {
                    adTemplate = adTemplate3;
                    gVar = gVar2;
                }

                @Override // com.kwad.components.ad.c.a.b
                public final void ae() {
                    com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                    AdTemplate adTemplate3 = adTemplate;
                    f.a(KsLoadManager.BannerAdListener.this, gVar);
                }

                @Override // com.kwad.components.ad.c.a.b
                public final void af() {
                    AdTemplate adTemplate3 = adTemplate;
                    f.a(KsLoadManager.BannerAdListener.this, gVar);
                }
            }

            public AnonymousClass2(SceneImpl covert2) {
                covert = covert2;
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z10) {
                List a102 = f.a(covert, adResultData.getAdTemplateList());
                if (a102.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg);
                    j.ao("bannerAd_", "onBannerAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.d.Ag());
                AdTemplate adTemplate3 = (AdTemplate) a102.get(0);
                new g(adResultData);
                com.kwad.sdk.commercial.d.d.a(covert, a102.size());
                KsBannerAd gVar2 = new g(adResultData);
                com.kwad.sdk.core.config.d.Eg();
                AdTemplate adTemplate2 = gVar2.getAdTemplate();
                if (com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.eb(adTemplate2))) {
                    f.a(KsLoadManager.BannerAdListener.this, gVar2);
                } else {
                    com.kwad.components.ad.c.a.a.a(adTemplate2, obtainVideoPreCacheConfig, new com.kwad.components.ad.c.a.b() { // from class: com.kwad.components.ad.c.f.2.2
                        final /* synthetic */ AdTemplate bZ;

                        /* renamed from: ca */
                        final /* synthetic */ KsBannerAd f11406ca;

                        public C03632(AdTemplate adTemplate32, KsBannerAd gVar22) {
                            adTemplate = adTemplate32;
                            gVar = gVar22;
                        }

                        @Override // com.kwad.components.ad.c.a.b
                        public final void ae() {
                            com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                            AdTemplate adTemplate32 = adTemplate;
                            f.a(KsLoadManager.BannerAdListener.this, gVar);
                        }

                        @Override // com.kwad.components.ad.c.a.b
                        public final void af() {
                            AdTemplate adTemplate32 = adTemplate;
                            f.a(KsLoadManager.BannerAdListener.this, gVar);
                        }
                    });
                }
                com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "loadFullScreenVideoAd after cache");
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(int i102, String str2) {
                if (i102 != com.kwad.sdk.core.network.e.azA.errorCode) {
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azv;
                }
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.c.f.2.1
                    final /* synthetic */ int bW;
                    final /* synthetic */ String bX;

                    public AnonymousClass1(int i1022, String str22) {
                        i10 = i1022;
                        str = str22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                        KsLoadManager.BannerAdListener.this.onError(i10, str);
                    }
                });
            }
        }).rA());
    }

    @NonNull
    public static List<AdTemplate> a(SceneImpl sceneImpl, List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (AdTemplate adTemplate : list) {
            if (adTemplate != null) {
                if (adTemplate.mAdScene == null) {
                    adTemplate.mAdScene = sceneImpl;
                }
                AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
                if (1 == com.kwad.sdk.core.response.b.a.be(eb2)) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.bd(eb2)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    public static void a(KsLoadManager.BannerAdListener bannerAdListener, KsBannerAd ksBannerAd) {
        bt.postOnUiThread(new bd() { // from class: com.kwad.components.ad.c.f.4

            /* renamed from: cb */
            final /* synthetic */ KsBannerAd f11407cb;

            public AnonymousClass4(KsBannerAd ksBannerAd2) {
                ksBannerAd = ksBannerAd2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                j.ao("bannerAd_", "onBannerAdCacheSuccess");
                KsLoadManager.BannerAdListener.this.onBannerAdLoad(ksBannerAd);
            }
        });
    }
}
