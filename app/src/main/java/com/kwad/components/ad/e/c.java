package com.kwad.components.ad.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.k;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: com.kwad.components.ad.e.c$1 */
    static class AnonymousClass1 extends com.kwad.components.core.n.c {
        final /* synthetic */ SceneImpl el;

        /* renamed from: com.kwad.components.ad.e.c$1$1 */
        final class RunnableC01241 implements Runnable {
            final /* synthetic */ int ck;
            final /* synthetic */ String cl;

            RunnableC01241(int i2, String str) {
                i2 = i2;
                str = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                KsLoadManager.NativeAdListener.this.onError(i2, str);
            }
        }

        /* renamed from: com.kwad.components.ad.e.c$1$2 */
        final class AnonymousClass2 implements Runnable {
            final /* synthetic */ List cn;

            AnonymousClass2(List list) {
                arrayList = list;
            }

            @Override // java.lang.Runnable
            public final void run() {
                KsAdLoadManager.ac().b(arrayList);
                KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
            }
        }

        AnonymousClass1(SceneImpl sceneImpl) {
            covert = sceneImpl;
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
        public final void a(@NonNull AdResultData adResultData) {
            ArrayList arrayList = new ArrayList();
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "dataReady").report();
            for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                if (adTemplate != null) {
                    adTemplate.mAdScene = covert;
                    arrayList.add(new d(adTemplate));
                }
            }
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.1.2
                final /* synthetic */ List cn;

                AnonymousClass2(List arrayList2) {
                    arrayList = arrayList2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    KsAdLoadManager.ac().b(arrayList);
                    KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                }
            });
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
        public final void onError(int i2, String str) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.1.1
                final /* synthetic */ int ck;
                final /* synthetic */ String cl;

                RunnableC01241(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    KsLoadManager.NativeAdListener.this.onError(i2, str);
                }
            });
        }
    }

    /* renamed from: com.kwad.components.ad.e.c$2 */
    static class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.b.e("KsAdNativeLoadManager", "method parseJson params jsonResult is empty");
            KsLoadManager.NativeAdListener nativeAdListener = KsLoadManager.NativeAdListener.this;
            com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.agn;
            nativeAdListener.onError(fVar.errorCode, fVar.msg);
        }
    }

    /* renamed from: com.kwad.components.ad.e.c$3 */
    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ KsLoadManager.NativeAdListener mG;

        AnonymousClass3(KsLoadManager.NativeAdListener nativeAdListener) {
            nativeAdListener = nativeAdListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.b.e("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(AdResultData.this.result), AdResultData.this.errorMsg));
            KsLoadManager.NativeAdListener nativeAdListener = nativeAdListener;
            AdResultData adResultData = AdResultData.this;
            nativeAdListener.onError(adResultData.result, adResultData.errorMsg);
        }
    }

    /* renamed from: com.kwad.components.ad.e.c$4 */
    static class AnonymousClass4 implements Runnable {
        final /* synthetic */ AdResultData iv;

        AnonymousClass4(AdResultData adResultData) {
            adResultData = adResultData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            KsLoadManager.NativeAdListener.this.onError(com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg : adResultData.testErrorMsg);
        }
    }

    /* renamed from: com.kwad.components.ad.e.c$5 */
    static class AnonymousClass5 implements Runnable {
        final /* synthetic */ List cn;

        AnonymousClass5(List list) {
            arrayList = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
        }
    }

    public static void loadNativeAd(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        SceneImpl covert = SceneImpl.covert(ksScene);
        boolean a2 = k.pP().a(covert, "loadNativeAd");
        covert.setAdStyle(10000);
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0180a().e(new com.kwad.components.core.n.kwai.b(covert)).aH(a2).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.e.c.1
            final /* synthetic */ SceneImpl el;

            /* renamed from: com.kwad.components.ad.e.c$1$1 */
            final class RunnableC01241 implements Runnable {
                final /* synthetic */ int ck;
                final /* synthetic */ String cl;

                RunnableC01241(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    KsLoadManager.NativeAdListener.this.onError(i2, str);
                }
            }

            /* renamed from: com.kwad.components.ad.e.c$1$2 */
            final class AnonymousClass2 implements Runnable {
                final /* synthetic */ List cn;

                AnonymousClass2(List arrayList2) {
                    arrayList = arrayList2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    KsAdLoadManager.ac().b(arrayList);
                    KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                }
            }

            AnonymousClass1(SceneImpl covert2) {
                covert = covert2;
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
            public final void a(@NonNull AdResultData adResultData) {
                List arrayList2 = new ArrayList();
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "dataReady").report();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null) {
                        adTemplate.mAdScene = covert;
                        arrayList2.add(new d(adTemplate));
                    }
                }
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.1.2
                    final /* synthetic */ List cn;

                    AnonymousClass2(List arrayList22) {
                        arrayList = arrayList22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        KsAdLoadManager.ac().b(arrayList);
                        KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                    }
                });
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
            public final void onError(int i22, String str2) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.1.1
                    final /* synthetic */ int ck;
                    final /* synthetic */ String cl;

                    RunnableC01241(int i222, String str22) {
                        i2 = i222;
                        str = str22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        KsLoadManager.NativeAdListener.this.onError(i2, str);
                    }
                });
            }
        }).pj());
    }

    public static void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        if (k.pP().a((SceneImpl) null, "loadNativeAdByJson") && k.pP().pQ() == 1) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.e("KsAdNativeLoadManager", "method parseJson params jsonResult is empty");
                    KsLoadManager.NativeAdListener nativeAdListener2 = KsLoadManager.NativeAdListener.this;
                    com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.agn;
                    nativeAdListener2.onError(fVar.errorCode, fVar.msg);
                }
            });
        }
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "requestFinish").aW(true).report();
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdResultData adResultData = new AdResultData();
            adResultData.parseJson(jSONObject);
            if (adResultData.result != 1) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.3
                    final /* synthetic */ KsLoadManager.NativeAdListener mG;

                    AnonymousClass3(KsLoadManager.NativeAdListener nativeAdListener2) {
                        nativeAdListener = nativeAdListener2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.e("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(AdResultData.this.result), AdResultData.this.errorMsg));
                        KsLoadManager.NativeAdListener nativeAdListener2 = nativeAdListener;
                        AdResultData adResultData2 = AdResultData.this;
                        nativeAdListener2.onError(adResultData2.result, adResultData2.errorMsg);
                    }
                });
                return;
            }
            if (adResultData.isAdResultDataEmpty()) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.4
                    final /* synthetic */ AdResultData iv;

                    AnonymousClass4(AdResultData adResultData2) {
                        adResultData = adResultData2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        KsLoadManager.NativeAdListener.this.onError(com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg : adResultData.testErrorMsg);
                    }
                });
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (AdTemplate adTemplate : adResultData2.getAdTemplateList()) {
                if (adTemplate != null) {
                    arrayList.add(new d(adTemplate));
                }
            }
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "dataReady").aW(true).report();
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.c.5
                final /* synthetic */ List cn;

                AnonymousClass5(List arrayList2) {
                    arrayList = arrayList2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                }
            });
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.agm;
            nativeAdListener2.onError(fVar.errorCode, fVar.msg);
        }
    }
}
