package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class v implements com.kwad.sdk.core.webview.b.a {
    private final boolean SG = false;
    private com.kwad.sdk.core.network.m<com.kwad.components.core.n.a, AdResultData> ir;
    private final com.kwad.sdk.core.webview.b mBridgeContext;

    /* renamed from: com.kwad.components.core.webview.jshandler.v$1 */
    final class AnonymousClass1 extends com.kwad.sdk.core.network.m<com.kwad.components.core.n.a, AdResultData> {
        final /* synthetic */ com.kwad.components.core.n.kwai.b Bk;

        AnonymousClass1(com.kwad.components.core.n.kwai.b bVar) {
            bVar = bVar;
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        /* renamed from: aj */
        public AdResultData parseData(String str) {
            JSONObject jSONObject = new JSONObject(str);
            AdResultData adResultData = new AdResultData(bVar.Ow);
            adResultData.parseJson(jSONObject);
            return adResultData;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: mc */
        public com.kwad.components.core.n.a createRequest() {
            return new com.kwad.components.core.n.a(bVar);
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.v$2 */
    final class AnonymousClass2 extends com.kwad.sdk.core.network.p<com.kwad.components.core.n.a, AdResultData> {
        final /* synthetic */ com.kwad.sdk.core.webview.b.c lK;

        /* renamed from: com.kwad.components.core.webview.jshandler.v$2$1 */
        final class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                cVar.a(new a(new ArrayList()));
            }
        }

        /* renamed from: com.kwad.components.core.webview.jshandler.v$2$2 */
        final class RunnableC01942 implements Runnable {
            final /* synthetic */ AdResultData iv;

            RunnableC01942(AdResultData adResultData) {
                adResultData = adResultData;
            }

            @Override // java.lang.Runnable
            public final void run() {
                cVar.a(new a(adResultData.getAdTemplateList()));
            }
        }

        AnonymousClass2(com.kwad.sdk.core.webview.b.c cVar) {
            cVar = cVar;
        }

        private void b(@NonNull AdResultData adResultData) {
            if (!adResultData.isAdResultDataEmpty()) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.v.2.2
                    final /* synthetic */ AdResultData iv;

                    RunnableC01942(AdResultData adResultData2) {
                        adResultData = adResultData2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.a(new a(adResultData.getAdTemplateList()));
                    }
                });
                return;
            }
            StringBuilder sb = new StringBuilder("onError:");
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(com.kwad.sdk.core.network.f.agn.errorCode);
            objArr[1] = TextUtils.isEmpty(adResultData2.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg : adResultData2.testErrorMsg;
            sb.append(String.format("code:%s__msg:%s", objArr));
            com.kwad.sdk.core.d.b.d("WebCardGetKsAdDataHandler", sb.toString());
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.v.2.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    cVar.a(new a(new ArrayList()));
                }
            });
        }

        private void e(int i2, String str) {
            com.kwad.sdk.core.d.b.d("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i2 + " msg: " + str);
            v.this.a(cVar);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.g gVar, int i2, String str) {
            e(i2, str);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
            b((AdResultData) baseResultData);
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.v$3 */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ com.kwad.sdk.core.webview.b.c lK;

        AnonymousClass3(com.kwad.sdk.core.webview.b.c cVar) {
            cVar = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            cVar.a(new a(new ArrayList()));
        }
    }

    public static final class a implements com.kwad.sdk.core.b {
        private List<AdTemplate> SJ;

        public a(List<AdTemplate> list) {
            this.SJ = list;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : this.SJ) {
                if (!TextUtils.isEmpty(adTemplate.mOriginJString)) {
                    try {
                        jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.b.printStackTrace(e2);
                    }
                }
                jSONArray.put(adTemplate.toJson());
            }
            com.kwad.sdk.utils.t.putValue(jSONObject, "impAdInfo", jSONArray);
            return jSONObject;
        }
    }

    public v(com.kwad.sdk.core.webview.b bVar) {
        this.mBridgeContext = bVar;
    }

    private void a(com.kwad.components.core.n.kwai.b bVar, com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.sdk.core.network.m<com.kwad.components.core.n.a, AdResultData> mVar = this.ir;
        if (mVar != null) {
            mVar.cancel();
        }
        AnonymousClass1 anonymousClass1 = new com.kwad.sdk.core.network.m<com.kwad.components.core.n.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.v.1
            final /* synthetic */ com.kwad.components.core.n.kwai.b Bk;

            AnonymousClass1(com.kwad.components.core.n.kwai.b bVar2) {
                bVar = bVar2;
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            /* renamed from: aj */
            public AdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(bVar.Ow);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: mc */
            public com.kwad.components.core.n.a createRequest() {
                return new com.kwad.components.core.n.a(bVar);
            }
        };
        this.ir = anonymousClass1;
        anonymousClass1.request(new com.kwad.sdk.core.network.p<com.kwad.components.core.n.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.v.2
            final /* synthetic */ com.kwad.sdk.core.webview.b.c lK;

            /* renamed from: com.kwad.components.core.webview.jshandler.v$2$1 */
            final class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    cVar.a(new a(new ArrayList()));
                }
            }

            /* renamed from: com.kwad.components.core.webview.jshandler.v$2$2 */
            final class RunnableC01942 implements Runnable {
                final /* synthetic */ AdResultData iv;

                RunnableC01942(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    cVar.a(new a(adResultData.getAdTemplateList()));
                }
            }

            AnonymousClass2(com.kwad.sdk.core.webview.b.c cVar2) {
                cVar = cVar2;
            }

            private void b(@NonNull AdResultData adResultData2) {
                if (!adResultData2.isAdResultDataEmpty()) {
                    bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.v.2.2
                        final /* synthetic */ AdResultData iv;

                        RunnableC01942(AdResultData adResultData22) {
                            adResultData = adResultData22;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            cVar.a(new a(adResultData.getAdTemplateList()));
                        }
                    });
                    return;
                }
                StringBuilder sb = new StringBuilder("onError:");
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(com.kwad.sdk.core.network.f.agn.errorCode);
                objArr[1] = TextUtils.isEmpty(adResultData22.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg : adResultData22.testErrorMsg;
                sb.append(String.format("code:%s__msg:%s", objArr));
                com.kwad.sdk.core.d.b.d("WebCardGetKsAdDataHandler", sb.toString());
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.v.2.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.a(new a(new ArrayList()));
                    }
                });
            }

            private void e(int i2, String str) {
                com.kwad.sdk.core.d.b.d("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i2 + " msg: " + str);
                v.this.a(cVar);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.g gVar, int i2, String str) {
                e(i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                b((AdResultData) baseResultData);
            }
        });
    }

    public void a(com.kwad.sdk.core.webview.b.c cVar) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.v.3
            final /* synthetic */ com.kwad.sdk.core.webview.b.c lK;

            AnonymousClass3(com.kwad.sdk.core.webview.b.c cVar2) {
                cVar = cVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                cVar.a(new a(new ArrayList()));
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getKsAdData";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (!this.SG) {
            if (this.mBridgeContext.yU()) {
                cVar.onError(-1, "native adTemplate is null");
                return;
            } else {
                cVar.a(new a(this.mBridgeContext.yT()));
                return;
            }
        }
        AdTemplate adTemplate = this.mBridgeContext.getAdTemplate();
        com.kwad.components.core.n.kwai.b bVar = new com.kwad.components.core.n.kwai.b(adTemplate.mAdScene);
        if (adTemplate.mAdScene != null) {
            bVar.Ox = r1.getPageScene();
        }
        bVar.Oy = 106L;
        bVar.Ow.setAdNum(12);
        bVar.sdkExtraData = com.kwad.sdk.core.response.a.d.ck(adTemplate);
        a(bVar, cVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        com.kwad.sdk.core.network.m<com.kwad.components.core.n.a, AdResultData> mVar = this.ir;
        if (mVar != null) {
            mVar.cancel();
        }
    }
}
