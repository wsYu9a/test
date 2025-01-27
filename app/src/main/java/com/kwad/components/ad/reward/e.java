package com.kwad.components.ad.reward;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.s;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: com.kwad.components.ad.reward.e$1 */
    static class AnonymousClass1 extends com.kwad.components.core.n.c {
        final /* synthetic */ long gh;
        final /* synthetic */ KsLoadManager.RewardVideoAdListener oz;

        /* renamed from: com.kwad.components.ad.reward.e$1$1 */
        final class RunnableC01441 implements Runnable {
            final /* synthetic */ int ck;
            final /* synthetic */ String cl;

            RunnableC01441(int i2, String str) {
                i2 = i2;
                str = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                rewardVideoAdListener.onError(i2, str);
            }
        }

        /* renamed from: com.kwad.components.ad.reward.e$1$2 */
        final class AnonymousClass2 implements Runnable {
            final /* synthetic */ List cn;

            AnonymousClass2(List list) {
                arrayList = list;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    KsAdLoadManager.ac().b(arrayList);
                    rewardVideoAdListener.onRewardVideoResult(arrayList);
                } catch (Throwable unused) {
                }
                try {
                    s.a((Object) rewardVideoAdListener, "onRequestResult", Integer.valueOf(arrayList.size()));
                } catch (Throwable unused2) {
                }
            }
        }

        /* renamed from: com.kwad.components.ad.reward.e$1$3 */
        final class AnonymousClass3 implements Runnable {
            final /* synthetic */ List oB;

            AnonymousClass3(List list) {
                arrayList2 = list;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.utils.i.Z("rewardAd_", "onRewardVideoAdCacheSuccess");
                rewardVideoAdListener.onRewardVideoAdLoad(arrayList2);
            }
        }

        AnonymousClass1(KsLoadManager.RewardVideoAdListener rewardVideoAdListener, long j2) {
            rewardVideoAdListener = rewardVideoAdListener;
            elapsedRealtime = j2;
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
        public final void a(@NonNull AdResultData adResultData, boolean z) {
            List<AdTemplate> a2 = e.a(SceneImpl.this, adResultData.getProceedTemplateList());
            if (a2.isEmpty()) {
                onError(com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg : adResultData.testErrorMsg);
                com.kwad.sdk.utils.i.Z("rewardAd_", "onRewardVideoAdCacheFailed");
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ArrayList<KsRewardVideoAd> arrayList = new ArrayList();
            for (AdTemplate adTemplate : a2) {
                arrayList.add(new f(adTemplate));
                adTemplate.setLoadDataTime(elapsedRealtime);
                adTemplate.setLoadFromCache(z);
            }
            com.kwad.components.ad.reward.monitor.a.a(true, (AdTemplate) a2.get(0), a2.size(), elapsedRealtime);
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_REWARD, "dataReady").report();
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.e.1.2
                final /* synthetic */ List cn;

                AnonymousClass2(List arrayList2) {
                    arrayList = arrayList2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        KsAdLoadManager.ac().b(arrayList);
                        rewardVideoAdListener.onRewardVideoResult(arrayList);
                    } catch (Throwable unused) {
                    }
                    try {
                        s.a((Object) rewardVideoAdListener, "onRequestResult", Integer.valueOf(arrayList.size()));
                    } catch (Throwable unused2) {
                    }
                }
            });
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            for (KsRewardVideoAd ksRewardVideoAd : arrayList2) {
                AdTemplate adTemplate2 = ((f) ksRewardVideoAd).getAdTemplate();
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate2);
                if (com.kwad.sdk.core.response.a.a.bJ(cb) || com.kwad.sdk.core.response.a.a.cq(cb)) {
                    arrayList2.add(ksRewardVideoAd);
                    z2 = true;
                } else if (com.kwad.components.ad.b.a.a(adTemplate2, true)) {
                    arrayList2.add(ksRewardVideoAd);
                }
            }
            if (z2 || !arrayList2.isEmpty()) {
                com.kwad.components.ad.reward.monitor.a.b(true, (AdTemplate) a2.get(0), a2.size(), elapsedRealtime);
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.e.1.3
                    final /* synthetic */ List oB;

                    AnonymousClass3(List arrayList22) {
                        arrayList2 = arrayList22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.utils.i.Z("rewardAd_", "onRewardVideoAdCacheSuccess");
                        rewardVideoAdListener.onRewardVideoAdLoad(arrayList2);
                    }
                });
            } else {
                com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.ago;
                onError(fVar.errorCode, fVar.msg);
                com.kwad.sdk.utils.i.Z("rewardAd_", "onRewardVideoAdCacheFailed");
            }
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
        public final void onError(int i2, String str) {
            com.kwad.components.ad.reward.monitor.a.a(true, i2, str, SceneImpl.this.getPosId());
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.e.1.1
                final /* synthetic */ int ck;
                final /* synthetic */ String cl;

                RunnableC01441(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    rewardVideoAdListener.onError(i2, str);
                }
            });
        }
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
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                if (com.kwad.sdk.core.response.a.a.bJ(cb) || com.kwad.sdk.core.response.a.a.cq(cb) || !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(cb))) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    public static void loadRewardVideoAd(KsScene ksScene, @NonNull KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.components.ad.reward.monitor.a.a(true, covert.getPosId());
        boolean a2 = com.kwad.components.core.r.k.pP().a(covert, "loadRewardVideoAd");
        covert.setAdStyle(2);
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0180a().e(new com.kwad.components.core.n.kwai.b(covert)).aH(a2).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.reward.e.1
            final /* synthetic */ long gh;
            final /* synthetic */ KsLoadManager.RewardVideoAdListener oz;

            /* renamed from: com.kwad.components.ad.reward.e$1$1 */
            final class RunnableC01441 implements Runnable {
                final /* synthetic */ int ck;
                final /* synthetic */ String cl;

                RunnableC01441(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    rewardVideoAdListener.onError(i2, str);
                }
            }

            /* renamed from: com.kwad.components.ad.reward.e$1$2 */
            final class AnonymousClass2 implements Runnable {
                final /* synthetic */ List cn;

                AnonymousClass2(List arrayList2) {
                    arrayList = arrayList2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        KsAdLoadManager.ac().b(arrayList);
                        rewardVideoAdListener.onRewardVideoResult(arrayList);
                    } catch (Throwable unused) {
                    }
                    try {
                        s.a((Object) rewardVideoAdListener, "onRequestResult", Integer.valueOf(arrayList.size()));
                    } catch (Throwable unused2) {
                    }
                }
            }

            /* renamed from: com.kwad.components.ad.reward.e$1$3 */
            final class AnonymousClass3 implements Runnable {
                final /* synthetic */ List oB;

                AnonymousClass3(List arrayList22) {
                    arrayList2 = arrayList22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.utils.i.Z("rewardAd_", "onRewardVideoAdCacheSuccess");
                    rewardVideoAdListener.onRewardVideoAdLoad(arrayList2);
                }
            }

            AnonymousClass1(KsLoadManager.RewardVideoAdListener rewardVideoAdListener2, long elapsedRealtime2) {
                rewardVideoAdListener = rewardVideoAdListener2;
                elapsedRealtime = elapsedRealtime2;
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
            public final void a(@NonNull AdResultData adResultData, boolean z) {
                List<AdTemplate> a22 = e.a(SceneImpl.this, adResultData.getProceedTemplateList());
                if (a22.isEmpty()) {
                    onError(com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg : adResultData.testErrorMsg);
                    com.kwad.sdk.utils.i.Z("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                List arrayList2 = new ArrayList();
                for (AdTemplate adTemplate : a22) {
                    arrayList2.add(new f(adTemplate));
                    adTemplate.setLoadDataTime(elapsedRealtime2);
                    adTemplate.setLoadFromCache(z);
                }
                com.kwad.components.ad.reward.monitor.a.a(true, (AdTemplate) a22.get(0), a22.size(), elapsedRealtime);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_REWARD, "dataReady").report();
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.e.1.2
                    final /* synthetic */ List cn;

                    AnonymousClass2(List arrayList22) {
                        arrayList = arrayList22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            KsAdLoadManager.ac().b(arrayList);
                            rewardVideoAdListener.onRewardVideoResult(arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            s.a((Object) rewardVideoAdListener, "onRequestResult", Integer.valueOf(arrayList.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                List arrayList22 = new ArrayList();
                boolean z2 = false;
                for (KsRewardVideoAd ksRewardVideoAd : arrayList22) {
                    AdTemplate adTemplate2 = ((f) ksRewardVideoAd).getAdTemplate();
                    AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate2);
                    if (com.kwad.sdk.core.response.a.a.bJ(cb) || com.kwad.sdk.core.response.a.a.cq(cb)) {
                        arrayList22.add(ksRewardVideoAd);
                        z2 = true;
                    } else if (com.kwad.components.ad.b.a.a(adTemplate2, true)) {
                        arrayList22.add(ksRewardVideoAd);
                    }
                }
                if (z2 || !arrayList22.isEmpty()) {
                    com.kwad.components.ad.reward.monitor.a.b(true, (AdTemplate) a22.get(0), a22.size(), elapsedRealtime);
                    bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.e.1.3
                        final /* synthetic */ List oB;

                        AnonymousClass3(List arrayList222) {
                            arrayList2 = arrayList222;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.utils.i.Z("rewardAd_", "onRewardVideoAdCacheSuccess");
                            rewardVideoAdListener.onRewardVideoAdLoad(arrayList2);
                        }
                    });
                } else {
                    com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.ago;
                    onError(fVar.errorCode, fVar.msg);
                    com.kwad.sdk.utils.i.Z("rewardAd_", "onRewardVideoAdCacheFailed");
                }
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
            public final void onError(int i22, String str2) {
                com.kwad.components.ad.reward.monitor.a.a(true, i22, str2, SceneImpl.this.getPosId());
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.e.1.1
                    final /* synthetic */ int ck;
                    final /* synthetic */ String cl;

                    RunnableC01441(int i222, String str22) {
                        i2 = i222;
                        str = str22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        rewardVideoAdListener.onError(i2, str);
                    }
                });
            }
        }).pj());
    }
}
