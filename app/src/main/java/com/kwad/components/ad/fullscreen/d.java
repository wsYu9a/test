package com.kwad.components.ad.fullscreen;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.k;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.s;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: com.kwad.components.ad.fullscreen.d$1 */
    static class AnonymousClass1 extends com.kwad.components.core.n.c {
        final /* synthetic */ KsLoadManager.FullScreenVideoAdListener gg;
        final /* synthetic */ long gh;

        /* renamed from: com.kwad.components.ad.fullscreen.d$1$1 */
        final class RunnableC01291 implements Runnable {
            final /* synthetic */ int ck;
            final /* synthetic */ String cl;

            RunnableC01291(int i2, String str) {
                i2 = i2;
                str = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                fullScreenVideoAdListener.onError(i2, str);
            }
        }

        /* renamed from: com.kwad.components.ad.fullscreen.d$1$2 */
        final class AnonymousClass2 implements Runnable {
            final /* synthetic */ List cn;

            AnonymousClass2(List list) {
                arrayList = list;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    fullScreenVideoAdListener.onFullScreenVideoResult(arrayList);
                } catch (Throwable unused) {
                }
                try {
                    s.a((Object) fullScreenVideoAdListener, "onRequestResult", Integer.valueOf(arrayList.size()));
                } catch (Throwable unused2) {
                }
            }
        }

        /* renamed from: com.kwad.components.ad.fullscreen.d$1$3 */
        final class AnonymousClass3 implements Runnable {
            final /* synthetic */ List cn;

            AnonymousClass3(List list) {
                arrayList = list;
            }

            @Override // java.lang.Runnable
            public final void run() {
                i.Z("fullAd_", "onFullScreenVideoAdCacheFailed");
                KsAdLoadManager.ac().b(arrayList);
                fullScreenVideoAdListener.onFullScreenVideoAdLoad(arrayList);
            }
        }

        AnonymousClass1(KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener, long j2) {
            fullScreenVideoAdListener = fullScreenVideoAdListener;
            elapsedRealtime = j2;
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
        public final void a(@NonNull AdResultData adResultData, boolean z) {
            List<AdTemplate> a2 = d.a(SceneImpl.this, adResultData.getAdTemplateList());
            if (a2.isEmpty()) {
                onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg);
                i.Z("fullAd_", "onFullScreenVideoAdCacheFailed");
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ArrayList<KsFullScreenVideoAd> arrayList = new ArrayList();
            for (AdTemplate adTemplate : a2) {
                arrayList.add(new e(adTemplate));
                adTemplate.setLoadDataTime(elapsedRealtime);
                adTemplate.setLoadFromCache(z);
            }
            com.kwad.components.ad.reward.monitor.a.a(false, (AdTemplate) a2.get(0), a2.size(), elapsedRealtime);
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FULLSCREEN, "dataReady").report();
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.d.1.2
                final /* synthetic */ List cn;

                AnonymousClass2(List arrayList2) {
                    arrayList = arrayList2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        fullScreenVideoAdListener.onFullScreenVideoResult(arrayList);
                    } catch (Throwable unused) {
                    }
                    try {
                        s.a((Object) fullScreenVideoAdListener, "onRequestResult", Integer.valueOf(arrayList.size()));
                    } catch (Throwable unused2) {
                    }
                }
            });
            ArrayList arrayList2 = new ArrayList();
            for (KsFullScreenVideoAd ksFullScreenVideoAd : arrayList2) {
                AdTemplate adTemplate2 = ((e) ksFullScreenVideoAd).getAdTemplate();
                if (com.kwad.components.ad.b.a.a(adTemplate2, false) || com.kwad.sdk.core.response.a.a.cq(com.kwad.sdk.core.response.a.d.cb(adTemplate2))) {
                    arrayList2.add(ksFullScreenVideoAd);
                }
            }
            if (!arrayList2.isEmpty()) {
                com.kwad.components.ad.reward.monitor.a.b(false, (AdTemplate) a2.get(0), a2.size(), elapsedRealtime);
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.d.1.3
                    final /* synthetic */ List cn;

                    AnonymousClass3(List arrayList22) {
                        arrayList = arrayList22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        i.Z("fullAd_", "onFullScreenVideoAdCacheFailed");
                        KsAdLoadManager.ac().b(arrayList);
                        fullScreenVideoAdListener.onFullScreenVideoAdLoad(arrayList);
                    }
                });
            } else {
                f fVar = f.ago;
                onError(fVar.errorCode, fVar.msg);
                i.Z("fullAd_", "onFullScreenVideoAdCacheFailed");
            }
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
        public final void onError(int i2, String str) {
            com.kwad.components.ad.reward.monitor.a.a(false, i2, str, SceneImpl.this.getPosId());
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.d.1.1
                final /* synthetic */ int ck;
                final /* synthetic */ String cl;

                RunnableC01291(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    fullScreenVideoAdListener.onError(i2, str);
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
                if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(cb)) || com.kwad.sdk.core.response.a.a.cq(cb)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    public static void loadFullScreenVideoAd(KsScene ksScene, @NonNull KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.components.ad.reward.monitor.a.a(false, covert.getPosId());
        boolean a2 = k.pP().a(covert, "loadFullScreenVideoAd");
        covert.setAdStyle(3);
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0180a().e(new com.kwad.components.core.n.kwai.b(covert)).aH(a2).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.fullscreen.d.1
            final /* synthetic */ KsLoadManager.FullScreenVideoAdListener gg;
            final /* synthetic */ long gh;

            /* renamed from: com.kwad.components.ad.fullscreen.d$1$1 */
            final class RunnableC01291 implements Runnable {
                final /* synthetic */ int ck;
                final /* synthetic */ String cl;

                RunnableC01291(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    fullScreenVideoAdListener.onError(i2, str);
                }
            }

            /* renamed from: com.kwad.components.ad.fullscreen.d$1$2 */
            final class AnonymousClass2 implements Runnable {
                final /* synthetic */ List cn;

                AnonymousClass2(List arrayList22) {
                    arrayList = arrayList22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        fullScreenVideoAdListener.onFullScreenVideoResult(arrayList);
                    } catch (Throwable unused) {
                    }
                    try {
                        s.a((Object) fullScreenVideoAdListener, "onRequestResult", Integer.valueOf(arrayList.size()));
                    } catch (Throwable unused2) {
                    }
                }
            }

            /* renamed from: com.kwad.components.ad.fullscreen.d$1$3 */
            final class AnonymousClass3 implements Runnable {
                final /* synthetic */ List cn;

                AnonymousClass3(List arrayList22) {
                    arrayList = arrayList22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    i.Z("fullAd_", "onFullScreenVideoAdCacheFailed");
                    KsAdLoadManager.ac().b(arrayList);
                    fullScreenVideoAdListener.onFullScreenVideoAdLoad(arrayList);
                }
            }

            AnonymousClass1(KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener2, long elapsedRealtime2) {
                fullScreenVideoAdListener = fullScreenVideoAdListener2;
                elapsedRealtime = elapsedRealtime2;
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
            public final void a(@NonNull AdResultData adResultData, boolean z) {
                List<AdTemplate> a22 = d.a(SceneImpl.this, adResultData.getAdTemplateList());
                if (a22.isEmpty()) {
                    onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg);
                    i.Z("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                List arrayList22 = new ArrayList();
                for (AdTemplate adTemplate : a22) {
                    arrayList22.add(new e(adTemplate));
                    adTemplate.setLoadDataTime(elapsedRealtime2);
                    adTemplate.setLoadFromCache(z);
                }
                com.kwad.components.ad.reward.monitor.a.a(false, (AdTemplate) a22.get(0), a22.size(), elapsedRealtime);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FULLSCREEN, "dataReady").report();
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.d.1.2
                    final /* synthetic */ List cn;

                    AnonymousClass2(List arrayList222) {
                        arrayList = arrayList222;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            fullScreenVideoAdListener.onFullScreenVideoResult(arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            s.a((Object) fullScreenVideoAdListener, "onRequestResult", Integer.valueOf(arrayList.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                ArrayList arrayList2 = new ArrayList();
                for (KsFullScreenVideoAd ksFullScreenVideoAd : arrayList222) {
                    AdTemplate adTemplate2 = ((e) ksFullScreenVideoAd).getAdTemplate();
                    if (com.kwad.components.ad.b.a.a(adTemplate2, false) || com.kwad.sdk.core.response.a.a.cq(com.kwad.sdk.core.response.a.d.cb(adTemplate2))) {
                        arrayList2.add(ksFullScreenVideoAd);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    com.kwad.components.ad.reward.monitor.a.b(false, (AdTemplate) a22.get(0), a22.size(), elapsedRealtime);
                    bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.d.1.3
                        final /* synthetic */ List cn;

                        AnonymousClass3(List arrayList222) {
                            arrayList = arrayList222;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            i.Z("fullAd_", "onFullScreenVideoAdCacheFailed");
                            KsAdLoadManager.ac().b(arrayList);
                            fullScreenVideoAdListener.onFullScreenVideoAdLoad(arrayList);
                        }
                    });
                } else {
                    f fVar = f.ago;
                    onError(fVar.errorCode, fVar.msg);
                    i.Z("fullAd_", "onFullScreenVideoAdCacheFailed");
                }
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
            public final void onError(int i22, String str2) {
                com.kwad.components.ad.reward.monitor.a.a(false, i22, str2, SceneImpl.this.getPosId());
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.d.1.1
                    final /* synthetic */ int ck;
                    final /* synthetic */ String cl;

                    RunnableC01291(int i222, String str22) {
                        i2 = i222;
                        str = str22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        fullScreenVideoAdListener.onError(i2, str);
                    }
                });
            }
        }).pj());
    }
}
