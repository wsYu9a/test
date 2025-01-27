package com.kwad.components.ad.reward.g;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.reward.KsRewardVideoAdControl;
import com.kwad.components.core.request.d;
import com.kwad.components.core.request.i;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.w;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: com.kwad.components.ad.reward.g.b$1 */
    public class AnonymousClass1 extends d {
        final /* synthetic */ long hM;
        final /* synthetic */ c tl;

        /* renamed from: com.kwad.components.ad.reward.g.b$1$1 */
        public class C03961 extends bd {
            final /* synthetic */ int bW;
            final /* synthetic */ String bX;

            public C03961(int i10, String str) {
                i10 = i10;
                str = str;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                cVar.onError(i10, str);
            }
        }

        /* renamed from: com.kwad.components.ad.reward.g.b$1$2 */
        public class AnonymousClass2 extends bd {
            final /* synthetic */ AdTemplate bZ;
            final /* synthetic */ List du;

            public AnonymousClass2(List list, AdTemplate adTemplate) {
                arrayList2 = list;
                adTemplate = adTemplate;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                try {
                    KsAdLoadManager.M().b(arrayList2);
                    cVar.c(adTemplate, arrayList2);
                } catch (Throwable unused) {
                }
                try {
                    w.callMethod(cVar, "onRequestResult", Integer.valueOf(arrayList2.size()));
                } catch (Throwable unused2) {
                }
            }
        }

        /* renamed from: com.kwad.components.ad.reward.g.b$1$3 */
        public class AnonymousClass3 implements com.kwad.components.ad.d.a {
            final /* synthetic */ AdTemplate bZ;
            final /* synthetic */ List du;
            final /* synthetic */ List hO;
            final /* synthetic */ boolean hQ;
            final /* synthetic */ KsRewardVideoAd tn;

            public AnonymousClass3(List list, KsRewardVideoAd ksRewardVideoAd, AdTemplate adTemplate, boolean z10, List list2) {
                arrayList4 = list;
                ksRewardVideoAd = ksRewardVideoAd;
                adTemplate = adTemplate;
                Eg = z10;
                arrayList2 = list2;
            }

            @Override // com.kwad.components.ad.d.a
            public final void ae() {
                com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "loadRewardVideoAd startCacheVideo onCacheTargetSuccess");
                arrayList4.add(ksRewardVideoAd);
                b.a(adTemplate, cVar, arrayList4);
            }

            @Override // com.kwad.components.ad.d.a
            public final void af() {
                if (Eg) {
                    b.a(adTemplate, cVar, arrayList2);
                }
            }
        }

        public AnonymousClass1(c cVar, long j10) {
            cVar = cVar;
            elapsedRealtime = j10;
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
        public final void a(@NonNull AdResultData adResultData, boolean z10) {
            List list;
            ArrayList arrayList;
            com.kwad.components.ad.reward.monitor.c.c(true, SceneImpl.this.posId);
            List a10 = b.a(SceneImpl.this, adResultData.getProceedTemplateList());
            if (a10.isEmpty()) {
                onError(e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? e.azA.msg : adResultData.testErrorMsg);
                j.ao("rewardAd_", "onRewardVideoAdCacheFailed");
                return;
            }
            AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.d.Ag());
            ArrayList<KsRewardVideoAd> arrayList2 = new ArrayList();
            AdTemplate adTemplate = (AdTemplate) a10.get(0);
            arrayList2.add(new KsRewardVideoAdControl(adResultData));
            com.kwad.components.ad.reward.monitor.d.a(adTemplate, z10, obtainVideoPreCacheConfig);
            com.kwad.components.ad.reward.monitor.c.a(true, (AdTemplate) a10.get(0), a10.size(), elapsedRealtime);
            com.kwad.sdk.commercial.d.d.a(SceneImpl.this, a10.size());
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.g.b.1.2
                final /* synthetic */ AdTemplate bZ;
                final /* synthetic */ List du;

                public AnonymousClass2(List arrayList22, AdTemplate adTemplate2) {
                    arrayList2 = arrayList22;
                    adTemplate = adTemplate2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    try {
                        KsAdLoadManager.M().b(arrayList2);
                        cVar.c(adTemplate, arrayList2);
                    } catch (Throwable unused) {
                    }
                    try {
                        w.callMethod(cVar, "onRequestResult", Integer.valueOf(arrayList2.size()));
                    } catch (Throwable unused2) {
                    }
                }
            });
            try {
                if (com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.b.a.class) != null) {
                    com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.b.a.class);
                    a10.get(0);
                    com.kwad.sdk.core.response.b.e.eb((AdTemplate) a10.get(0));
                }
            } catch (Exception unused) {
            }
            ArrayList arrayList3 = new ArrayList();
            com.kwad.components.ad.reward.monitor.c.d(true, adTemplate2);
            boolean Eg = com.kwad.sdk.core.config.d.Eg();
            boolean z11 = false;
            for (KsRewardVideoAd ksRewardVideoAd : arrayList22) {
                AdTemplate adTemplate2 = ((KsRewardVideoAdControl) ksRewardVideoAd).getAdTemplate();
                AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate2);
                if (adTemplate2.isNativeRewardPreview || com.kwad.sdk.core.response.b.a.cS(eb2)) {
                    list = a10;
                    arrayList = arrayList3;
                } else if (com.kwad.sdk.core.response.b.a.bd(eb2)) {
                    arrayList = arrayList3;
                    list = a10;
                } else {
                    com.kwad.components.ad.d.b.a(adTemplate2, true, obtainVideoPreCacheConfig, new com.kwad.components.ad.d.a() { // from class: com.kwad.components.ad.reward.g.b.1.3
                        final /* synthetic */ AdTemplate bZ;
                        final /* synthetic */ List du;
                        final /* synthetic */ List hO;
                        final /* synthetic */ boolean hQ;
                        final /* synthetic */ KsRewardVideoAd tn;

                        public AnonymousClass3(List arrayList32, KsRewardVideoAd ksRewardVideoAd2, AdTemplate adTemplate22, boolean Eg2, List arrayList22) {
                            arrayList4 = arrayList32;
                            ksRewardVideoAd = ksRewardVideoAd2;
                            adTemplate = adTemplate22;
                            Eg = Eg2;
                            arrayList2 = arrayList22;
                        }

                        @Override // com.kwad.components.ad.d.a
                        public final void ae() {
                            com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "loadRewardVideoAd startCacheVideo onCacheTargetSuccess");
                            arrayList4.add(ksRewardVideoAd);
                            b.a(adTemplate, cVar, arrayList4);
                        }

                        @Override // com.kwad.components.ad.d.a
                        public final void af() {
                            if (Eg) {
                                b.a(adTemplate, cVar, arrayList2);
                            }
                        }
                    });
                    a10 = a10;
                    arrayList32 = arrayList32;
                }
                arrayList.add(ksRewardVideoAd2);
                b.a(adTemplate22, cVar, arrayList);
                arrayList32 = arrayList;
                a10 = list;
                z11 = true;
            }
            ArrayList arrayList4 = arrayList32;
            List list2 = a10;
            com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "loadRewardVideoAd after cache");
            if (Eg2 || z11 || !arrayList4.isEmpty()) {
                com.kwad.components.ad.reward.monitor.c.b(true, (AdTemplate) list2.get(0), list2.size(), elapsedRealtime);
                return;
            }
            e eVar = e.azB;
            onError(eVar.errorCode, eVar.msg);
            j.ao("rewardAd_", "onRewardVideoAdCacheFailed");
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void onError(int i10, String str) {
            com.kwad.components.ad.reward.monitor.c.a(true, i10, str, SceneImpl.this.getPosId());
            if (i10 != e.azA.errorCode && i10 != e.azv.errorCode) {
                com.kwad.components.ad.reward.monitor.b.c(true, i10);
            }
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.g.b.1.1
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public C03961(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    cVar.onError(i10, str);
                }
            });
        }
    }

    /* renamed from: com.kwad.components.ad.reward.g.b$2 */
    public class AnonymousClass2 implements i {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.request.i
        @WorkerThread
        public final void ag() {
            com.kwad.components.ad.reward.monitor.c.b(true, SceneImpl.this.posId);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.g.b$3 */
    public class AnonymousClass3 extends bd {
        final /* synthetic */ AdTemplate cP;
        final /* synthetic */ List hO;

        public AnonymousClass3(AdTemplate adTemplate, List list) {
            adTemplate = adTemplate;
            list = list;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            j.ao("rewardAd_", "onRewardVideoAdCacheSuccess");
            c.this.d(adTemplate, list);
        }
    }

    public static void a(KsScene ksScene, @NonNull c cVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        com.kwad.components.ad.reward.monitor.c.a(true, covert.getPosId());
        boolean a10 = m.si().a(covert, "loadRewardVideoAd");
        covert.setAdStyle(2);
        KsAdLoadManager.M().a(new a.C0445a().e(new ImpInfo(covert)).aK(a10).a(new i() { // from class: com.kwad.components.ad.reward.g.b.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.request.i
            @WorkerThread
            public final void ag() {
                com.kwad.components.ad.reward.monitor.c.b(true, SceneImpl.this.posId);
            }
        }).a(new d() { // from class: com.kwad.components.ad.reward.g.b.1
            final /* synthetic */ long hM;
            final /* synthetic */ c tl;

            /* renamed from: com.kwad.components.ad.reward.g.b$1$1 */
            public class C03961 extends bd {
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public C03961(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    cVar.onError(i10, str);
                }
            }

            /* renamed from: com.kwad.components.ad.reward.g.b$1$2 */
            public class AnonymousClass2 extends bd {
                final /* synthetic */ AdTemplate bZ;
                final /* synthetic */ List du;

                public AnonymousClass2(List arrayList22, AdTemplate adTemplate22) {
                    arrayList2 = arrayList22;
                    adTemplate = adTemplate22;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    try {
                        KsAdLoadManager.M().b(arrayList2);
                        cVar.c(adTemplate, arrayList2);
                    } catch (Throwable unused) {
                    }
                    try {
                        w.callMethod(cVar, "onRequestResult", Integer.valueOf(arrayList2.size()));
                    } catch (Throwable unused2) {
                    }
                }
            }

            /* renamed from: com.kwad.components.ad.reward.g.b$1$3 */
            public class AnonymousClass3 implements com.kwad.components.ad.d.a {
                final /* synthetic */ AdTemplate bZ;
                final /* synthetic */ List du;
                final /* synthetic */ List hO;
                final /* synthetic */ boolean hQ;
                final /* synthetic */ KsRewardVideoAd tn;

                public AnonymousClass3(List arrayList32, KsRewardVideoAd ksRewardVideoAd2, AdTemplate adTemplate22, boolean Eg2, List arrayList22) {
                    arrayList4 = arrayList32;
                    ksRewardVideoAd = ksRewardVideoAd2;
                    adTemplate = adTemplate22;
                    Eg = Eg2;
                    arrayList2 = arrayList22;
                }

                @Override // com.kwad.components.ad.d.a
                public final void ae() {
                    com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "loadRewardVideoAd startCacheVideo onCacheTargetSuccess");
                    arrayList4.add(ksRewardVideoAd);
                    b.a(adTemplate, cVar, arrayList4);
                }

                @Override // com.kwad.components.ad.d.a
                public final void af() {
                    if (Eg) {
                        b.a(adTemplate, cVar, arrayList2);
                    }
                }
            }

            public AnonymousClass1(c cVar2, long elapsedRealtime2) {
                cVar = cVar2;
                elapsedRealtime = elapsedRealtime2;
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z10) {
                List list;
                ArrayList arrayList;
                com.kwad.components.ad.reward.monitor.c.c(true, SceneImpl.this.posId);
                List a102 = b.a(SceneImpl.this, adResultData.getProceedTemplateList());
                if (a102.isEmpty()) {
                    onError(e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? e.azA.msg : adResultData.testErrorMsg);
                    j.ao("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.d.Ag());
                List arrayList22 = new ArrayList();
                AdTemplate adTemplate22 = (AdTemplate) a102.get(0);
                arrayList22.add(new KsRewardVideoAdControl(adResultData));
                com.kwad.components.ad.reward.monitor.d.a(adTemplate22, z10, obtainVideoPreCacheConfig);
                com.kwad.components.ad.reward.monitor.c.a(true, (AdTemplate) a102.get(0), a102.size(), elapsedRealtime);
                com.kwad.sdk.commercial.d.d.a(SceneImpl.this, a102.size());
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.g.b.1.2
                    final /* synthetic */ AdTemplate bZ;
                    final /* synthetic */ List du;

                    public AnonymousClass2(List arrayList222, AdTemplate adTemplate222) {
                        arrayList2 = arrayList222;
                        adTemplate = adTemplate222;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        try {
                            KsAdLoadManager.M().b(arrayList2);
                            cVar.c(adTemplate, arrayList2);
                        } catch (Throwable unused) {
                        }
                        try {
                            w.callMethod(cVar, "onRequestResult", Integer.valueOf(arrayList2.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.b.a.class) != null) {
                        com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.b.a.class);
                        a102.get(0);
                        com.kwad.sdk.core.response.b.e.eb((AdTemplate) a102.get(0));
                    }
                } catch (Exception unused) {
                }
                List arrayList32 = new ArrayList();
                com.kwad.components.ad.reward.monitor.c.d(true, adTemplate222);
                boolean Eg2 = com.kwad.sdk.core.config.d.Eg();
                boolean z11 = false;
                for (KsRewardVideoAd ksRewardVideoAd2 : arrayList222) {
                    AdTemplate adTemplate2 = ((KsRewardVideoAdControl) ksRewardVideoAd2).getAdTemplate();
                    AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate2);
                    if (adTemplate2.isNativeRewardPreview || com.kwad.sdk.core.response.b.a.cS(eb2)) {
                        list = a102;
                        arrayList = arrayList32;
                    } else if (com.kwad.sdk.core.response.b.a.bd(eb2)) {
                        arrayList = arrayList32;
                        list = a102;
                    } else {
                        com.kwad.components.ad.d.b.a(adTemplate2, true, obtainVideoPreCacheConfig, new com.kwad.components.ad.d.a() { // from class: com.kwad.components.ad.reward.g.b.1.3
                            final /* synthetic */ AdTemplate bZ;
                            final /* synthetic */ List du;
                            final /* synthetic */ List hO;
                            final /* synthetic */ boolean hQ;
                            final /* synthetic */ KsRewardVideoAd tn;

                            public AnonymousClass3(List arrayList322, KsRewardVideoAd ksRewardVideoAd22, AdTemplate adTemplate222, boolean Eg22, List arrayList222) {
                                arrayList4 = arrayList322;
                                ksRewardVideoAd = ksRewardVideoAd22;
                                adTemplate = adTemplate222;
                                Eg = Eg22;
                                arrayList2 = arrayList222;
                            }

                            @Override // com.kwad.components.ad.d.a
                            public final void ae() {
                                com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "loadRewardVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList4.add(ksRewardVideoAd);
                                b.a(adTemplate, cVar, arrayList4);
                            }

                            @Override // com.kwad.components.ad.d.a
                            public final void af() {
                                if (Eg) {
                                    b.a(adTemplate, cVar, arrayList2);
                                }
                            }
                        });
                        a102 = a102;
                        arrayList322 = arrayList322;
                    }
                    arrayList.add(ksRewardVideoAd22);
                    b.a(adTemplate222, cVar, arrayList);
                    arrayList322 = arrayList;
                    a102 = list;
                    z11 = true;
                }
                ArrayList arrayList4 = arrayList322;
                List list2 = a102;
                com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "loadRewardVideoAd after cache");
                if (Eg22 || z11 || !arrayList4.isEmpty()) {
                    com.kwad.components.ad.reward.monitor.c.b(true, (AdTemplate) list2.get(0), list2.size(), elapsedRealtime);
                    return;
                }
                e eVar = e.azB;
                onError(eVar.errorCode, eVar.msg);
                j.ao("rewardAd_", "onRewardVideoAdCacheFailed");
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(int i102, String str2) {
                com.kwad.components.ad.reward.monitor.c.a(true, i102, str2, SceneImpl.this.getPosId());
                if (i102 != e.azA.errorCode && i102 != e.azv.errorCode) {
                    com.kwad.components.ad.reward.monitor.b.c(true, i102);
                }
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.g.b.1.1
                    final /* synthetic */ int bW;
                    final /* synthetic */ String bX;

                    public C03961(int i1022, String str22) {
                        i10 = i1022;
                        str = str22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                        cVar.onError(i10, str);
                    }
                });
            }
        }).rA());
    }

    public static void a(AdTemplate adTemplate, c cVar, List<KsRewardVideoAd> list) {
        bt.postOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.g.b.3
            final /* synthetic */ AdTemplate cP;
            final /* synthetic */ List hO;

            public AnonymousClass3(AdTemplate adTemplate2, List list2) {
                adTemplate = adTemplate2;
                list = list2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                j.ao("rewardAd_", "onRewardVideoAdCacheSuccess");
                c.this.d(adTemplate, list);
            }
        });
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
                int be2 = com.kwad.sdk.core.response.b.a.be(eb2);
                if (adTemplate.isNativeRewardPreview) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.cS(eb2)) {
                    arrayList.add(adTemplate);
                } else if (1 == be2 && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(eb2))) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.bd(eb2)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }
}
