package com.kwad.components.ad.interstitial;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.k;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: com.kwad.components.ad.interstitial.e$1 */
    static class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            KsLoadManager.InterstitialAdListener.this.onError(f.agn.errorCode, f.agn.msg + "sdk not init");
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.e$2 */
    static class AnonymousClass2 extends com.kwad.components.core.n.c {
        final /* synthetic */ KsLoadManager.InterstitialAdListener hQ;
        final /* synthetic */ long hR;

        /* renamed from: com.kwad.components.ad.interstitial.e$2$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ int ck;
            final /* synthetic */ String cl;

            AnonymousClass1(int i2, String str) {
                i2 = i2;
                str = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.w("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                interstitialAdListener.onError(i2, str);
            }
        }

        /* renamed from: com.kwad.components.ad.interstitial.e$2$2 */
        final class RunnableC01402 implements Runnable {
            final /* synthetic */ List hT;

            RunnableC01402(List list) {
                adTemplateList = list;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    interstitialAdListener.onRequestResult(adTemplateList.size());
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        /* renamed from: com.kwad.components.ad.interstitial.e$2$3 */
        final class AnonymousClass3 implements Runnable {
            final /* synthetic */ List cn;

            AnonymousClass3(List list) {
                arrayList = list;
            }

            @Override // java.lang.Runnable
            public final void run() {
                KsAdLoadManager.ac().b(arrayList);
                i.Z("insertAd_", "onInterstitialAdCacheSuccess");
                interstitialAdListener.onInterstitialAdLoad(arrayList);
            }
        }

        AnonymousClass2(KsLoadManager.InterstitialAdListener interstitialAdListener, long j2) {
            interstitialAdListener = interstitialAdListener;
            elapsedRealtime = j2;
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
        public final void a(@NonNull AdResultData adResultData, boolean z) {
            b bVar;
            List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
            if (adTemplateList.isEmpty()) {
                onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg);
                i.Z("insertAd_", "onInterstitialAdCacheFailed");
                return;
            }
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.2.2
                final /* synthetic */ List hT;

                RunnableC01402(List adTemplateList2) {
                    adTemplateList = adTemplateList2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        interstitialAdListener.onRequestResult(adTemplateList.size());
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
            });
            com.kwad.components.ad.interstitial.monitor.b.cR();
            com.kwad.components.ad.interstitial.monitor.b.a(adTemplateList2.get(0), elapsedRealtime, z);
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_INTERSTITIAL, "dataReady").report();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ArrayList arrayList = new ArrayList();
            for (AdTemplate adTemplate : adTemplateList2) {
                if (adTemplate != null) {
                    if (adTemplate.mAdScene == null) {
                        adTemplate.mAdScene = SceneImpl.this;
                    }
                    if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)))) {
                        bVar = new b(SceneImpl.this, adTemplate);
                    } else if (com.kwad.components.ad.interstitial.monitor.a.f(adTemplate)) {
                        bVar = new b(SceneImpl.this, adTemplate);
                    }
                    arrayList.add(bVar);
                }
            }
            if (arrayList.size() == 0) {
                onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg);
                i.Z("insertAd_", "onInterstitialAdCacheFailed");
            } else {
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.b(adTemplateList2.get(0), elapsedRealtime, z);
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.2.3
                    final /* synthetic */ List cn;

                    AnonymousClass3(List arrayList2) {
                        arrayList = arrayList2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        KsAdLoadManager.ac().b(arrayList);
                        i.Z("insertAd_", "onInterstitialAdCacheSuccess");
                        interstitialAdListener.onInterstitialAdLoad(arrayList);
                    }
                });
            }
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
        public final void onError(int i2, String str) {
            com.kwad.components.ad.interstitial.monitor.b.cR();
            com.kwad.components.ad.interstitial.monitor.b.a(i2, str, SceneImpl.this.getPosId());
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.2.1
                final /* synthetic */ int ck;
                final /* synthetic */ String cl;

                AnonymousClass1(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.w("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    interstitialAdListener.onError(i2, str);
                }
            });
        }
    }

    public static void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.InterstitialAdListener interstitialAdListener) {
        if (!KsAdSDKImpl.get().hasInitFinish()) {
            com.kwad.sdk.core.d.b.e("KsAdInterstitialLoadManager", "loadInterstitialAd please init sdk first");
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    KsLoadManager.InterstitialAdListener.this.onError(f.agn.errorCode, f.agn.msg + "sdk not init");
                }
            });
            return;
        }
        SceneImpl covert = SceneImpl.covert(ksScene);
        boolean a2 = k.pP().a(covert, "loadInterstitialAd");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        covert.setAdStyle(13);
        com.kwad.components.ad.interstitial.monitor.b.cR();
        com.kwad.components.ad.interstitial.monitor.b.g(covert.getPosId());
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0180a().e(new com.kwad.components.core.n.kwai.b(covert)).aH(a2).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.interstitial.e.2
            final /* synthetic */ KsLoadManager.InterstitialAdListener hQ;
            final /* synthetic */ long hR;

            /* renamed from: com.kwad.components.ad.interstitial.e$2$1 */
            final class AnonymousClass1 implements Runnable {
                final /* synthetic */ int ck;
                final /* synthetic */ String cl;

                AnonymousClass1(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.w("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    interstitialAdListener.onError(i2, str);
                }
            }

            /* renamed from: com.kwad.components.ad.interstitial.e$2$2 */
            final class RunnableC01402 implements Runnable {
                final /* synthetic */ List hT;

                RunnableC01402(List adTemplateList2) {
                    adTemplateList = adTemplateList2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        interstitialAdListener.onRequestResult(adTemplateList.size());
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
            }

            /* renamed from: com.kwad.components.ad.interstitial.e$2$3 */
            final class AnonymousClass3 implements Runnable {
                final /* synthetic */ List cn;

                AnonymousClass3(List arrayList2) {
                    arrayList = arrayList2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    KsAdLoadManager.ac().b(arrayList);
                    i.Z("insertAd_", "onInterstitialAdCacheSuccess");
                    interstitialAdListener.onInterstitialAdLoad(arrayList);
                }
            }

            AnonymousClass2(KsLoadManager.InterstitialAdListener interstitialAdListener2, long elapsedRealtime2) {
                interstitialAdListener = interstitialAdListener2;
                elapsedRealtime = elapsedRealtime2;
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
            public final void a(@NonNull AdResultData adResultData, boolean z) {
                b bVar;
                List adTemplateList2 = adResultData.getAdTemplateList();
                if (adTemplateList2.isEmpty()) {
                    onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg);
                    i.Z("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.2.2
                    final /* synthetic */ List hT;

                    RunnableC01402(List adTemplateList22) {
                        adTemplateList = adTemplateList22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            interstitialAdListener.onRequestResult(adTemplateList.size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                });
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.a(adTemplateList22.get(0), elapsedRealtime, z);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_INTERSTITIAL, "dataReady").report();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                List arrayList2 = new ArrayList();
                for (AdTemplate adTemplate : adTemplateList22) {
                    if (adTemplate != null) {
                        if (adTemplate.mAdScene == null) {
                            adTemplate.mAdScene = SceneImpl.this;
                        }
                        if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)))) {
                            bVar = new b(SceneImpl.this, adTemplate);
                        } else if (com.kwad.components.ad.interstitial.monitor.a.f(adTemplate)) {
                            bVar = new b(SceneImpl.this, adTemplate);
                        }
                        arrayList2.add(bVar);
                    }
                }
                if (arrayList2.size() == 0) {
                    onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg);
                    i.Z("insertAd_", "onInterstitialAdCacheFailed");
                } else {
                    com.kwad.components.ad.interstitial.monitor.b.cR();
                    com.kwad.components.ad.interstitial.monitor.b.b(adTemplateList22.get(0), elapsedRealtime2, z);
                    bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.2.3
                        final /* synthetic */ List cn;

                        AnonymousClass3(List arrayList22) {
                            arrayList = arrayList22;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            KsAdLoadManager.ac().b(arrayList);
                            i.Z("insertAd_", "onInterstitialAdCacheSuccess");
                            interstitialAdListener.onInterstitialAdLoad(arrayList);
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
            public final void onError(int i22, String str2) {
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.a(i22, str2, SceneImpl.this.getPosId());
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.2.1
                    final /* synthetic */ int ck;
                    final /* synthetic */ String cl;

                    AnonymousClass1(int i222, String str22) {
                        i2 = i222;
                        str = str22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.w("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        interstitialAdListener.onError(i2, str);
                    }
                });
            }
        }).pj());
    }
}
