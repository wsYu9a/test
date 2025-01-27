package com.kwad.components.ad.g;

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
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: com.kwad.components.ad.g.c$1 */
    public class AnonymousClass1 extends com.kwad.components.core.request.d {
        final /* synthetic */ SceneImpl bV;

        /* renamed from: com.kwad.components.ad.g.c$1$1 */
        public class C03751 extends bd {
            final /* synthetic */ int bW;
            final /* synthetic */ String bX;

            public C03751(int i10, String str) {
                i10 = i10;
                str = str;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.core.d.c.d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                KsLoadManager.NativeAdListener.this.onError(i10, str);
            }
        }

        /* renamed from: com.kwad.components.ad.g.c$1$2 */
        public class AnonymousClass2 extends bd {
            final /* synthetic */ List du;

            public AnonymousClass2(List list) {
                arrayList = list;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                KsAdLoadManager.M().b(arrayList);
                KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
            }
        }

        public AnonymousClass1(SceneImpl sceneImpl) {
            covert = sceneImpl;
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void b(@NonNull AdResultData adResultData) {
            ArrayList arrayList = new ArrayList();
            List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
            com.kwad.sdk.commercial.d.d.a(covert, adTemplateList.size());
            for (AdTemplate adTemplate : adTemplateList) {
                if (adTemplate != null) {
                    adTemplate.mAdScene = covert;
                    arrayList.add(new d(adTemplate));
                }
            }
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.g.c.1.2
                final /* synthetic */ List du;

                public AnonymousClass2(List arrayList2) {
                    arrayList = arrayList2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    KsAdLoadManager.M().b(arrayList);
                    KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                }
            });
            try {
                for (AdTemplate adTemplate2 : adResultData.getAdTemplateList()) {
                    if (adTemplate2 != null) {
                        com.kwad.sdk.core.response.b.e.eb(adTemplate2);
                        try {
                            if (com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.b.a.class) != null) {
                                com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.b.a.class);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void onError(int i10, String str) {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.g.c.1.1
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public C03751(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    KsLoadManager.NativeAdListener.this.onError(i10, str);
                }
            });
        }
    }

    /* renamed from: com.kwad.components.ad.g.c$2 */
    public class AnonymousClass2 extends bd {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.core.d.c.e("KsAdNativeLoadManager", "method parseJson params jsonResult is empty");
            KsLoadManager.NativeAdListener nativeAdListener = KsLoadManager.NativeAdListener.this;
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azA;
            nativeAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    /* renamed from: com.kwad.components.ad.g.c$3 */
    public class AnonymousClass3 extends bd {
        final /* synthetic */ KsLoadManager.NativeAdListener nA;

        public AnonymousClass3(KsLoadManager.NativeAdListener nativeAdListener) {
            nativeAdListener = nativeAdListener;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.core.d.c.e("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(AdResultData.this.result), AdResultData.this.errorMsg));
            KsLoadManager.NativeAdListener nativeAdListener = nativeAdListener;
            AdResultData adResultData = AdResultData.this;
            nativeAdListener.onError(adResultData.result, adResultData.errorMsg);
        }
    }

    /* renamed from: com.kwad.components.ad.g.c$4 */
    public class AnonymousClass4 extends bd {
        final /* synthetic */ AdResultData jX;

        public AnonymousClass4(AdResultData adResultData) {
            adResultData = adResultData;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            KsLoadManager.NativeAdListener.this.onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg);
        }
    }

    /* renamed from: com.kwad.components.ad.g.c$5 */
    public class AnonymousClass5 extends bd {
        final /* synthetic */ List du;

        public AnonymousClass5(List list) {
            arrayList = list;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
        }
    }

    public static void loadNativeAd(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        boolean a10 = m.si().a(covert, "loadNativeAd");
        covert.setAdStyle(10000);
        KsAdLoadManager.M().a(new a.C0445a().e(new ImpInfo(covert)).aK(a10).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.g.c.1
            final /* synthetic */ SceneImpl bV;

            /* renamed from: com.kwad.components.ad.g.c$1$1 */
            public class C03751 extends bd {
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public C03751(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    KsLoadManager.NativeAdListener.this.onError(i10, str);
                }
            }

            /* renamed from: com.kwad.components.ad.g.c$1$2 */
            public class AnonymousClass2 extends bd {
                final /* synthetic */ List du;

                public AnonymousClass2(List arrayList2) {
                    arrayList = arrayList2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    KsAdLoadManager.M().b(arrayList);
                    KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                }
            }

            public AnonymousClass1(SceneImpl covert2) {
                covert = covert2;
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void b(@NonNull AdResultData adResultData) {
                List arrayList2 = new ArrayList();
                List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                com.kwad.sdk.commercial.d.d.a(covert, adTemplateList.size());
                for (AdTemplate adTemplate : adTemplateList) {
                    if (adTemplate != null) {
                        adTemplate.mAdScene = covert;
                        arrayList2.add(new d(adTemplate));
                    }
                }
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.g.c.1.2
                    final /* synthetic */ List du;

                    public AnonymousClass2(List arrayList22) {
                        arrayList = arrayList22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        KsAdLoadManager.M().b(arrayList);
                        KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                    }
                });
                try {
                    for (AdTemplate adTemplate2 : adResultData.getAdTemplateList()) {
                        if (adTemplate2 != null) {
                            com.kwad.sdk.core.response.b.e.eb(adTemplate2);
                            try {
                                if (com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.b.a.class) != null) {
                                    com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.b.a.class);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(int i102, String str2) {
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.g.c.1.1
                    final /* synthetic */ int bW;
                    final /* synthetic */ String bX;

                    public C03751(int i1022, String str22) {
                        i10 = i1022;
                        str = str22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                        KsLoadManager.NativeAdListener.this.onError(i10, str);
                    }
                });
            }
        }).rA());
    }

    public static void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        if (m.si().a((SceneImpl) null, "loadNativeAdByJson") && m.si().sj() == 1) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.g.c.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.e("KsAdNativeLoadManager", "method parseJson params jsonResult is empty");
                    KsLoadManager.NativeAdListener nativeAdListener2 = KsLoadManager.NativeAdListener.this;
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azA;
                    nativeAdListener2.onError(eVar.errorCode, eVar.msg);
                }
            });
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdResultData adResultData = new AdResultData();
            adResultData.parseJson(jSONObject);
            if (adResultData.result != 1) {
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.g.c.3
                    final /* synthetic */ KsLoadManager.NativeAdListener nA;

                    public AnonymousClass3(KsLoadManager.NativeAdListener nativeAdListener2) {
                        nativeAdListener = nativeAdListener2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.e("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(AdResultData.this.result), AdResultData.this.errorMsg));
                        KsLoadManager.NativeAdListener nativeAdListener2 = nativeAdListener;
                        AdResultData adResultData2 = AdResultData.this;
                        nativeAdListener2.onError(adResultData2.result, adResultData2.errorMsg);
                    }
                });
                return;
            }
            if (adResultData.isAdResultDataEmpty()) {
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.g.c.4
                    final /* synthetic */ AdResultData jX;

                    public AnonymousClass4(AdResultData adResultData2) {
                        adResultData = adResultData2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        KsLoadManager.NativeAdListener.this.onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg);
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
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.g.c.5
                final /* synthetic */ List du;

                public AnonymousClass5(List arrayList2) {
                    arrayList = arrayList2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                }
            });
        } catch (JSONException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azz;
            nativeAdListener2.onError(eVar.errorCode, eVar.msg);
        }
    }
}
