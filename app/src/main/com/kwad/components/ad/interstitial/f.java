package com.kwad.components.ad.interstitial;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: com.kwad.components.ad.interstitial.f$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            KsLoadManager.InterstitialAdListener.this.onError(com.kwad.sdk.core.network.e.azA.errorCode, com.kwad.sdk.core.network.e.azA.msg + "sdk not init");
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.f$2 */
    public class AnonymousClass2 extends com.kwad.components.core.request.d {
        final /* synthetic */ KsLoadManager.InterstitialAdListener ju;
        final /* synthetic */ long jv;

        /* renamed from: com.kwad.components.ad.interstitial.f$2$1 */
        public class AnonymousClass1 extends bd {
            final /* synthetic */ int bW;
            final /* synthetic */ String bX;

            public AnonymousClass1(int i10, String str) {
                i10 = i10;
                str = str;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.core.d.c.w("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                interstitialAdListener.onError(i10, str);
            }
        }

        /* renamed from: com.kwad.components.ad.interstitial.f$2$2 */
        public class C03802 extends bd {
            final /* synthetic */ List jx;

            public C03802(List list) {
                adTemplateList = list;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                try {
                    interstitialAdListener.onRequestResult(adTemplateList.size());
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        /* renamed from: com.kwad.components.ad.interstitial.f$2$3 */
        public class AnonymousClass3 extends bd {
            final /* synthetic */ List du;

            public AnonymousClass3(List list) {
                arrayList = list;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                KsAdLoadManager.M().b(arrayList);
                j.ao("insertAd_", "onInterstitialAdCacheSuccess");
                interstitialAdListener.onInterstitialAdLoad(arrayList);
            }
        }

        public AnonymousClass2(KsLoadManager.InterstitialAdListener interstitialAdListener, long j10) {
            interstitialAdListener = interstitialAdListener;
            elapsedRealtime = j10;
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
        public final void a(@NonNull AdResultData adResultData, boolean z10) {
            List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
            if (adTemplateList.isEmpty()) {
                onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg);
                j.ao("insertAd_", "onInterstitialAdCacheFailed");
                return;
            }
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.interstitial.f.2.2
                final /* synthetic */ List jx;

                public C03802(List adTemplateList2) {
                    adTemplateList = adTemplateList2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    try {
                        interstitialAdListener.onRequestResult(adTemplateList.size());
                    } catch (Throwable th2) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    }
                }
            });
            try {
                if (com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.b.a.class) != null) {
                    com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.b.a.class);
                    adTemplateList2.get(0);
                    com.kwad.sdk.core.response.b.e.eb(adTemplateList2.get(0));
                }
            } catch (Exception unused) {
            }
            com.kwad.components.ad.interstitial.report.c.em().a(adTemplateList2.get(0), z10);
            com.kwad.sdk.commercial.d.d.a(SceneImpl.this, adTemplateList2.size());
            SystemClock.elapsedRealtime();
            ArrayList arrayList = new ArrayList();
            for (AdTemplate adTemplate : adTemplateList2) {
                if (adTemplate != null) {
                    if (adTemplate.mAdScene == null) {
                        adTemplate.mAdScene = SceneImpl.this;
                    }
                    String K = com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.eb(adTemplate));
                    if (!com.kwad.sdk.core.response.b.b.da(adTemplate)) {
                        com.kwad.components.ad.interstitial.report.realtime.a.eq();
                        com.kwad.components.ad.interstitial.report.realtime.a.A(adTemplate);
                    }
                    AdResultData a10 = com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate);
                    if (TextUtils.isEmpty(K)) {
                        arrayList.add(e.d(a10));
                    } else {
                        boolean n10 = com.kwad.components.ad.interstitial.a.a.n(adTemplate);
                        if (com.kwad.sdk.core.config.d.CY() || n10) {
                            arrayList.add(e.d(a10));
                        }
                    }
                }
            }
            if (arrayList.size() != 0) {
                com.kwad.components.ad.interstitial.report.c.em().b(adTemplateList2.get(0), z10);
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.interstitial.f.2.3
                    final /* synthetic */ List du;

                    public AnonymousClass3(List arrayList2) {
                        arrayList = arrayList2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        KsAdLoadManager.M().b(arrayList);
                        j.ao("insertAd_", "onInterstitialAdCacheSuccess");
                        interstitialAdListener.onInterstitialAdLoad(arrayList);
                    }
                });
            } else {
                onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg);
                com.kwad.components.ad.interstitial.report.realtime.a.eq();
                com.kwad.components.ad.interstitial.report.realtime.a.a(com.kwad.sdk.core.network.e.azA);
                j.ao("insertAd_", "onInterstitialAdCacheFailed");
            }
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void onError(int i10, String str) {
            com.kwad.components.ad.interstitial.report.c.em().a(i10, str, SceneImpl.this.getPosId());
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.interstitial.f.2.1
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public AnonymousClass1(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.w("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    interstitialAdListener.onError(i10, str);
                }
            });
        }
    }

    public static void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.InterstitialAdListener interstitialAdListener) {
        if (!l.At().zE()) {
            com.kwad.sdk.core.d.c.e("KsAdInterstitialLoadManager", "loadInterstitialAd please init sdk first");
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.interstitial.f.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    KsLoadManager.InterstitialAdListener.this.onError(com.kwad.sdk.core.network.e.azA.errorCode, com.kwad.sdk.core.network.e.azA.msg + "sdk not init");
                }
            });
            return;
        }
        SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        boolean a10 = m.si().a(covert, "loadInterstitialAd");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        covert.setAdStyle(23);
        com.kwad.components.ad.interstitial.report.c.em().i(covert.getPosId());
        KsAdLoadManager.M().a(new a.C0445a().e(new ImpInfo(covert)).aK(a10).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.interstitial.f.2
            final /* synthetic */ KsLoadManager.InterstitialAdListener ju;
            final /* synthetic */ long jv;

            /* renamed from: com.kwad.components.ad.interstitial.f$2$1 */
            public class AnonymousClass1 extends bd {
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public AnonymousClass1(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.w("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    interstitialAdListener.onError(i10, str);
                }
            }

            /* renamed from: com.kwad.components.ad.interstitial.f$2$2 */
            public class C03802 extends bd {
                final /* synthetic */ List jx;

                public C03802(List adTemplateList2) {
                    adTemplateList = adTemplateList2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    try {
                        interstitialAdListener.onRequestResult(adTemplateList.size());
                    } catch (Throwable th2) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    }
                }
            }

            /* renamed from: com.kwad.components.ad.interstitial.f$2$3 */
            public class AnonymousClass3 extends bd {
                final /* synthetic */ List du;

                public AnonymousClass3(List arrayList2) {
                    arrayList = arrayList2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    KsAdLoadManager.M().b(arrayList);
                    j.ao("insertAd_", "onInterstitialAdCacheSuccess");
                    interstitialAdListener.onInterstitialAdLoad(arrayList);
                }
            }

            public AnonymousClass2(KsLoadManager.InterstitialAdListener interstitialAdListener2, long elapsedRealtime2) {
                interstitialAdListener = interstitialAdListener2;
                elapsedRealtime = elapsedRealtime2;
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z10) {
                List adTemplateList2 = adResultData.getAdTemplateList();
                if (adTemplateList2.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg);
                    j.ao("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.interstitial.f.2.2
                    final /* synthetic */ List jx;

                    public C03802(List adTemplateList22) {
                        adTemplateList = adTemplateList22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        try {
                            interstitialAdListener.onRequestResult(adTemplateList.size());
                        } catch (Throwable th2) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.b.a.class) != null) {
                        com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.b.a.class);
                        adTemplateList22.get(0);
                        com.kwad.sdk.core.response.b.e.eb(adTemplateList22.get(0));
                    }
                } catch (Exception unused) {
                }
                com.kwad.components.ad.interstitial.report.c.em().a(adTemplateList22.get(0), z10);
                com.kwad.sdk.commercial.d.d.a(SceneImpl.this, adTemplateList22.size());
                SystemClock.elapsedRealtime();
                List arrayList2 = new ArrayList();
                for (AdTemplate adTemplate : adTemplateList22) {
                    if (adTemplate != null) {
                        if (adTemplate.mAdScene == null) {
                            adTemplate.mAdScene = SceneImpl.this;
                        }
                        String K = com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.eb(adTemplate));
                        if (!com.kwad.sdk.core.response.b.b.da(adTemplate)) {
                            com.kwad.components.ad.interstitial.report.realtime.a.eq();
                            com.kwad.components.ad.interstitial.report.realtime.a.A(adTemplate);
                        }
                        AdResultData a102 = com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate);
                        if (TextUtils.isEmpty(K)) {
                            arrayList2.add(e.d(a102));
                        } else {
                            boolean n10 = com.kwad.components.ad.interstitial.a.a.n(adTemplate);
                            if (com.kwad.sdk.core.config.d.CY() || n10) {
                                arrayList2.add(e.d(a102));
                            }
                        }
                    }
                }
                if (arrayList2.size() != 0) {
                    com.kwad.components.ad.interstitial.report.c.em().b(adTemplateList22.get(0), z10);
                    bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.interstitial.f.2.3
                        final /* synthetic */ List du;

                        public AnonymousClass3(List arrayList22) {
                            arrayList = arrayList22;
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            KsAdLoadManager.M().b(arrayList);
                            j.ao("insertAd_", "onInterstitialAdCacheSuccess");
                            interstitialAdListener.onInterstitialAdLoad(arrayList);
                        }
                    });
                } else {
                    onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg);
                    com.kwad.components.ad.interstitial.report.realtime.a.eq();
                    com.kwad.components.ad.interstitial.report.realtime.a.a(com.kwad.sdk.core.network.e.azA);
                    j.ao("insertAd_", "onInterstitialAdCacheFailed");
                }
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(int i102, String str2) {
                com.kwad.components.ad.interstitial.report.c.em().a(i102, str2, SceneImpl.this.getPosId());
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.interstitial.f.2.1
                    final /* synthetic */ int bW;
                    final /* synthetic */ String bX;

                    public AnonymousClass1(int i1022, String str22) {
                        i10 = i1022;
                        str = str22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.w("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                        interstitialAdListener.onError(i10, str);
                    }
                });
            }
        }).rA());
    }
}
