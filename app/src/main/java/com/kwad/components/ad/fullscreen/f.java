package com.kwad.components.ad.fullscreen;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.i;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsScene;
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
public final class f {

    /* renamed from: com.kwad.components.ad.fullscreen.f$1 */
    public class AnonymousClass1 extends com.kwad.components.core.request.d {
        final /* synthetic */ e hL;
        final /* synthetic */ long hM;

        /* renamed from: com.kwad.components.ad.fullscreen.f$1$1 */
        public class C03721 extends bd {
            final /* synthetic */ int bW;
            final /* synthetic */ String bX;

            public C03721(int i10, String str) {
                i10 = i10;
                str = str;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                eVar.onError(i10, str);
            }
        }

        /* renamed from: com.kwad.components.ad.fullscreen.f$1$2 */
        public class AnonymousClass2 extends bd {
            final /* synthetic */ AdTemplate bZ;
            final /* synthetic */ List du;

            public AnonymousClass2(AdTemplate adTemplate, List list) {
                adTemplate2 = adTemplate;
                arrayList = list;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                try {
                    eVar.a(adTemplate2, arrayList);
                } catch (Throwable unused) {
                }
                try {
                    w.callMethod(eVar, "onRequestResult", Integer.valueOf(arrayList.size()));
                } catch (Throwable unused2) {
                }
            }
        }

        /* renamed from: com.kwad.components.ad.fullscreen.f$1$3 */
        public class AnonymousClass3 implements com.kwad.components.ad.d.a {
            final /* synthetic */ AdTemplate bZ;
            final /* synthetic */ List du;
            final /* synthetic */ List hO;
            final /* synthetic */ KsFullScreenVideoAd hP;
            final /* synthetic */ boolean hQ;

            public AnonymousClass3(List list, KsFullScreenVideoAd ksFullScreenVideoAd, AdTemplate adTemplate, boolean z10, List list2) {
                arrayList2 = list;
                ksFullScreenVideoAd = ksFullScreenVideoAd;
                adTemplate2 = adTemplate;
                Eg = z10;
                arrayList = list2;
            }

            @Override // com.kwad.components.ad.d.a
            public final void ae() {
                com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                arrayList2.add(ksFullScreenVideoAd);
                f.a(adTemplate2, eVar, arrayList2);
            }

            @Override // com.kwad.components.ad.d.a
            public final void af() {
                if (Eg) {
                    f.a(adTemplate2, eVar, arrayList);
                }
            }
        }

        public AnonymousClass1(e eVar, long j10) {
            eVar = eVar;
            elapsedRealtime = j10;
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
        public final void a(@NonNull AdResultData adResultData, boolean z10) {
            List list;
            String str;
            com.kwad.components.ad.reward.monitor.c.c(false, SceneImpl.this.posId);
            List<AdTemplate> a10 = f.a(SceneImpl.this, adResultData.getAdTemplateList());
            String str2 = "onFullScreenVideoAdCacheFailed";
            if (a10.isEmpty()) {
                onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg);
                j.ao("fullAd_", "onFullScreenVideoAdCacheFailed");
                return;
            }
            AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.d.Ag());
            ArrayList<KsFullScreenVideoAd> arrayList = new ArrayList();
            for (AdTemplate adTemplate : a10) {
                arrayList.add(new g(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate)));
                com.kwad.components.ad.reward.monitor.d.a(adTemplate, z10, obtainVideoPreCacheConfig);
            }
            AdTemplate adTemplate2 = (AdTemplate) a10.get(0);
            com.kwad.components.ad.reward.monitor.c.a(false, adTemplate2, a10.size(), elapsedRealtime);
            com.kwad.sdk.commercial.d.d.a(SceneImpl.this, a10.size());
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.fullscreen.f.1.2
                final /* synthetic */ AdTemplate bZ;
                final /* synthetic */ List du;

                public AnonymousClass2(AdTemplate adTemplate22, List arrayList2) {
                    adTemplate2 = adTemplate22;
                    arrayList = arrayList2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    try {
                        eVar.a(adTemplate2, arrayList);
                    } catch (Throwable unused) {
                    }
                    try {
                        w.callMethod(eVar, "onRequestResult", Integer.valueOf(arrayList.size()));
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
            ArrayList arrayList2 = new ArrayList();
            com.kwad.components.ad.reward.monitor.c.d(false, adTemplate22);
            boolean Eg = com.kwad.sdk.core.config.d.Eg();
            for (KsFullScreenVideoAd ksFullScreenVideoAd : arrayList2) {
                AdTemplate adTemplate3 = ((g) ksFullScreenVideoAd).getAdTemplate();
                AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate3);
                if (com.kwad.sdk.core.response.b.a.bd(eb2) || com.kwad.sdk.core.response.b.a.cS(eb2)) {
                    list = a10;
                    str = str2;
                    arrayList2.add(ksFullScreenVideoAd);
                    f.a(adTemplate22, eVar, arrayList2);
                } else {
                    list = a10;
                    str = str2;
                    com.kwad.components.ad.d.b.a(adTemplate3, false, obtainVideoPreCacheConfig, new com.kwad.components.ad.d.a() { // from class: com.kwad.components.ad.fullscreen.f.1.3
                        final /* synthetic */ AdTemplate bZ;
                        final /* synthetic */ List du;
                        final /* synthetic */ List hO;
                        final /* synthetic */ KsFullScreenVideoAd hP;
                        final /* synthetic */ boolean hQ;

                        public AnonymousClass3(List arrayList22, KsFullScreenVideoAd ksFullScreenVideoAd2, AdTemplate adTemplate22, boolean Eg2, List arrayList23) {
                            arrayList2 = arrayList22;
                            ksFullScreenVideoAd = ksFullScreenVideoAd2;
                            adTemplate2 = adTemplate22;
                            Eg = Eg2;
                            arrayList = arrayList23;
                        }

                        @Override // com.kwad.components.ad.d.a
                        public final void ae() {
                            com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                            arrayList2.add(ksFullScreenVideoAd);
                            f.a(adTemplate2, eVar, arrayList2);
                        }

                        @Override // com.kwad.components.ad.d.a
                        public final void af() {
                            if (Eg) {
                                f.a(adTemplate2, eVar, arrayList);
                            }
                        }
                    });
                }
                a10 = list;
                str2 = str;
            }
            List list2 = a10;
            String str3 = str2;
            com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd after cache");
            if (Eg2 || !arrayList22.isEmpty()) {
                com.kwad.components.ad.reward.monitor.c.b(false, (AdTemplate) list2.get(0), list2.size(), elapsedRealtime);
                return;
            }
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azB;
            onError(eVar.errorCode, eVar.msg);
            j.ao("fullAd_", str3);
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void onError(int i10, String str) {
            com.kwad.components.ad.reward.monitor.c.a(false, i10, str, SceneImpl.this.getPosId());
            if (i10 != com.kwad.sdk.core.network.e.azA.errorCode && i10 != com.kwad.sdk.core.network.e.azv.errorCode) {
                com.kwad.components.ad.reward.monitor.b.c(false, i10);
            }
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.fullscreen.f.1.1
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public C03721(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    eVar.onError(i10, str);
                }
            });
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.f$2 */
    public class AnonymousClass2 implements i {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.request.i
        @WorkerThread
        public final void ag() {
            com.kwad.components.ad.reward.monitor.c.b(false, SceneImpl.this.posId);
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.f$3 */
    public class AnonymousClass3 extends bd {
        final /* synthetic */ AdTemplate cP;
        final /* synthetic */ List du;
        final /* synthetic */ e hL;

        public AnonymousClass3(List list, e eVar, AdTemplate adTemplate) {
            list = list;
            eVar = eVar;
            adTemplate = adTemplate;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            j.ao("fullAd_", "onFullScreenVideoAdCacheFailed");
            KsAdLoadManager.M().b(list);
            eVar.b(adTemplate, list);
        }
    }

    public static void a(KsScene ksScene, @NonNull e eVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        com.kwad.components.ad.reward.monitor.c.a(false, covert.getPosId());
        boolean a10 = m.si().a(covert, "loadFullScreenVideoAd");
        covert.setAdStyle(3);
        KsAdLoadManager.M().a(new a.C0445a().e(new ImpInfo(covert)).aK(a10).a(new i() { // from class: com.kwad.components.ad.fullscreen.f.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.request.i
            @WorkerThread
            public final void ag() {
                com.kwad.components.ad.reward.monitor.c.b(false, SceneImpl.this.posId);
            }
        }).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.fullscreen.f.1
            final /* synthetic */ e hL;
            final /* synthetic */ long hM;

            /* renamed from: com.kwad.components.ad.fullscreen.f$1$1 */
            public class C03721 extends bd {
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public C03721(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    eVar.onError(i10, str);
                }
            }

            /* renamed from: com.kwad.components.ad.fullscreen.f$1$2 */
            public class AnonymousClass2 extends bd {
                final /* synthetic */ AdTemplate bZ;
                final /* synthetic */ List du;

                public AnonymousClass2(AdTemplate adTemplate22, List arrayList23) {
                    adTemplate2 = adTemplate22;
                    arrayList = arrayList23;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    try {
                        eVar.a(adTemplate2, arrayList);
                    } catch (Throwable unused) {
                    }
                    try {
                        w.callMethod(eVar, "onRequestResult", Integer.valueOf(arrayList.size()));
                    } catch (Throwable unused2) {
                    }
                }
            }

            /* renamed from: com.kwad.components.ad.fullscreen.f$1$3 */
            public class AnonymousClass3 implements com.kwad.components.ad.d.a {
                final /* synthetic */ AdTemplate bZ;
                final /* synthetic */ List du;
                final /* synthetic */ List hO;
                final /* synthetic */ KsFullScreenVideoAd hP;
                final /* synthetic */ boolean hQ;

                public AnonymousClass3(List arrayList22, KsFullScreenVideoAd ksFullScreenVideoAd2, AdTemplate adTemplate22, boolean Eg2, List arrayList23) {
                    arrayList2 = arrayList22;
                    ksFullScreenVideoAd = ksFullScreenVideoAd2;
                    adTemplate2 = adTemplate22;
                    Eg = Eg2;
                    arrayList = arrayList23;
                }

                @Override // com.kwad.components.ad.d.a
                public final void ae() {
                    com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                    arrayList2.add(ksFullScreenVideoAd);
                    f.a(adTemplate2, eVar, arrayList2);
                }

                @Override // com.kwad.components.ad.d.a
                public final void af() {
                    if (Eg) {
                        f.a(adTemplate2, eVar, arrayList);
                    }
                }
            }

            public AnonymousClass1(e eVar2, long elapsedRealtime2) {
                eVar = eVar2;
                elapsedRealtime = elapsedRealtime2;
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z10) {
                List list;
                String str;
                com.kwad.components.ad.reward.monitor.c.c(false, SceneImpl.this.posId);
                List<AdTemplate> a102 = f.a(SceneImpl.this, adResultData.getAdTemplateList());
                String str2 = "onFullScreenVideoAdCacheFailed";
                if (a102.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg);
                    j.ao("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.d.Ag());
                List arrayList23 = new ArrayList();
                for (AdTemplate adTemplate : a102) {
                    arrayList23.add(new g(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate)));
                    com.kwad.components.ad.reward.monitor.d.a(adTemplate, z10, obtainVideoPreCacheConfig);
                }
                AdTemplate adTemplate22 = (AdTemplate) a102.get(0);
                com.kwad.components.ad.reward.monitor.c.a(false, adTemplate22, a102.size(), elapsedRealtime);
                com.kwad.sdk.commercial.d.d.a(SceneImpl.this, a102.size());
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.fullscreen.f.1.2
                    final /* synthetic */ AdTemplate bZ;
                    final /* synthetic */ List du;

                    public AnonymousClass2(AdTemplate adTemplate222, List arrayList232) {
                        adTemplate2 = adTemplate222;
                        arrayList = arrayList232;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        try {
                            eVar.a(adTemplate2, arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            w.callMethod(eVar, "onRequestResult", Integer.valueOf(arrayList.size()));
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
                List arrayList22 = new ArrayList();
                com.kwad.components.ad.reward.monitor.c.d(false, adTemplate222);
                boolean Eg2 = com.kwad.sdk.core.config.d.Eg();
                for (KsFullScreenVideoAd ksFullScreenVideoAd2 : arrayList232) {
                    AdTemplate adTemplate3 = ((g) ksFullScreenVideoAd2).getAdTemplate();
                    AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate3);
                    if (com.kwad.sdk.core.response.b.a.bd(eb2) || com.kwad.sdk.core.response.b.a.cS(eb2)) {
                        list = a102;
                        str = str2;
                        arrayList22.add(ksFullScreenVideoAd2);
                        f.a(adTemplate222, eVar, arrayList22);
                    } else {
                        list = a102;
                        str = str2;
                        com.kwad.components.ad.d.b.a(adTemplate3, false, obtainVideoPreCacheConfig, new com.kwad.components.ad.d.a() { // from class: com.kwad.components.ad.fullscreen.f.1.3
                            final /* synthetic */ AdTemplate bZ;
                            final /* synthetic */ List du;
                            final /* synthetic */ List hO;
                            final /* synthetic */ KsFullScreenVideoAd hP;
                            final /* synthetic */ boolean hQ;

                            public AnonymousClass3(List arrayList222, KsFullScreenVideoAd ksFullScreenVideoAd22, AdTemplate adTemplate222, boolean Eg22, List arrayList232) {
                                arrayList2 = arrayList222;
                                ksFullScreenVideoAd = ksFullScreenVideoAd22;
                                adTemplate2 = adTemplate222;
                                Eg = Eg22;
                                arrayList = arrayList232;
                            }

                            @Override // com.kwad.components.ad.d.a
                            public final void ae() {
                                com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList2.add(ksFullScreenVideoAd);
                                f.a(adTemplate2, eVar, arrayList2);
                            }

                            @Override // com.kwad.components.ad.d.a
                            public final void af() {
                                if (Eg) {
                                    f.a(adTemplate2, eVar, arrayList);
                                }
                            }
                        });
                    }
                    a102 = list;
                    str2 = str;
                }
                List list2 = a102;
                String str3 = str2;
                com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd after cache");
                if (Eg22 || !arrayList222.isEmpty()) {
                    com.kwad.components.ad.reward.monitor.c.b(false, (AdTemplate) list2.get(0), list2.size(), elapsedRealtime);
                    return;
                }
                com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.azB;
                onError(eVar2.errorCode, eVar2.msg);
                j.ao("fullAd_", str3);
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(int i102, String str2) {
                com.kwad.components.ad.reward.monitor.c.a(false, i102, str2, SceneImpl.this.getPosId());
                if (i102 != com.kwad.sdk.core.network.e.azA.errorCode && i102 != com.kwad.sdk.core.network.e.azv.errorCode) {
                    com.kwad.components.ad.reward.monitor.b.c(false, i102);
                }
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.fullscreen.f.1.1
                    final /* synthetic */ int bW;
                    final /* synthetic */ String bX;

                    public C03721(int i1022, String str22) {
                        i10 = i1022;
                        str = str22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                        eVar.onError(i10, str);
                    }
                });
            }
        }).rA());
    }

    public static void a(AdTemplate adTemplate, e eVar, List<KsFullScreenVideoAd> list) {
        bt.postOnUiThread(new bd() { // from class: com.kwad.components.ad.fullscreen.f.3
            final /* synthetic */ AdTemplate cP;
            final /* synthetic */ List du;
            final /* synthetic */ e hL;

            public AnonymousClass3(List list2, e eVar2, AdTemplate adTemplate2) {
                list = list2;
                eVar = eVar2;
                adTemplate = adTemplate2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                j.ao("fullAd_", "onFullScreenVideoAdCacheFailed");
                KsAdLoadManager.M().b(list);
                eVar.b(adTemplate, list);
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
                if (1 == com.kwad.sdk.core.response.b.a.be(eb2) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(eb2))) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.bd(eb2)) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.cS(eb2)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }
}
